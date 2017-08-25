/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcubinomio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sanchez Mendez Edmundo y Rodriguez Morua Genaro
 * @version 3.0 25/08/17
 */
public class Home extends JFrame implements ActionListener{
    JTextField Numero, Numero2,Signo,potencia1,potencia2;
    JButton Calcular;
    JLabel resultado;
    JTextField resultado1;
    double nsaldo=0;
    int Fact,fibo;
    Boolean Continuar=false;
    private JLabel titulo, instruccion,instruccion1,instruccion2;
    
    public Home(){
        configurarVentana();
       iniciarComponentes();
    }
    //Configuramos el tamaño y otras caracteristicas de la ventana
    public void configurarVentana(){
        setTitle("Calculadora de Binimios al cuadrado");
        setSize(600,300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(220,216,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Inicialiciamos los componentes que la ventana tendra
    public void iniciarComponentes(){
        titulo = new JLabel("Calculadora de Binimios al cuadrado");
        titulo.setBounds(125, 25, 750, 30);
        titulo.setFont(new Font ("Arial",Font.BOLD,20));
        add(titulo);
        titulo.setVisible(true);
        
        instruccion =  new JLabel("Ingresa el primer termino:");
        instruccion.setBounds(10, 80, 300, 30);
        instruccion.setFont(new Font("Arial",0,16));
        add(instruccion);
        instruccion.setVisible(true);
        
        instruccion1 = new JLabel("(");
        instruccion1.setBounds(200,76,100, 35);
        instruccion1.setFont(new Font("Arial",0,25));
        add(instruccion1);
        instruccion1.setVisible(true);
        
        Numero= new JTextField();
        Numero.setBounds(220, 80, 50, 35);
	Numero.setFont(new Font("Arial", Font.BOLD, 25));
        Numero.setHorizontalAlignment(JTextField.CENTER);
	Numero.setEditable(true);
        add(Numero);
        Numero.setVisible(true);
        
        potencia1= new JTextField();
        potencia1.setBounds(255, 80, 25, 20);
	potencia1.setFont(new Font("Arial", Font.BOLD, 15));
        potencia1.setHorizontalAlignment(JTextField.CENTER);
	potencia1.setEditable(true);
        add(potencia1);
        potencia1.setVisible(true);

        Signo=new JTextField();
        Signo.setBounds(300, 80, 40, 35);
	Signo.setFont(new Font("Arial", Font.BOLD, 25));
        Signo.setHorizontalAlignment(JTextField.CENTER);
	Signo.setEditable(true);
        add(Signo);
        Signo.setVisible(true);

        Numero2= new JTextField();
        Numero2.setBounds(360, 80, 50, 35);
	Numero2.setFont(new Font("Arial", Font.BOLD, 25));
        Numero2.setHorizontalAlignment(JTextField.CENTER);
	Numero2.setEditable(true);
        add(Numero2);
        Numero2.setVisible(true);
        
        potencia2= new JTextField();
        potencia2.setBounds(400, 80, 20, 20);
	potencia2.setFont(new Font("Arial", Font.BOLD, 15));
        potencia2.setHorizontalAlignment(JTextField.CENTER);
	potencia2.setEditable(true);
        add(potencia2);
        potencia2.setVisible(true);
        
        instruccion2 = new JLabel(")");
        instruccion2.setBounds(430,76,100, 35);
        instruccion2.setFont(new Font("Arial",0,25));
        add(instruccion2);
        instruccion2.setVisible(true);
        
        Calcular = new JButton("Calcular");
        Calcular.setBounds(250, 125, 100, 50);
        add(Calcular);
        Calcular.addActionListener(this);
        add(Calcular);     
        
        resultado =  new JLabel("Resultado:");
        resultado.setBounds(10, 200, 300, 30);
        resultado.setFont(new Font("Arial",0,16));
        add(resultado);
        resultado.setVisible(true);
        
        resultado1= new JTextField();
        resultado1.setBounds(100, 200, 475, 35);
	resultado1.setFont(new Font("Arial", Font.BOLD, 25));
        resultado1.setHorizontalAlignment(JTextField.CENTER);
	resultado1.setEditable(false);
        add(resultado1);
        resultado1.setVisible(true);
    }
    //Damos instrucciones a los botones
    @Override
    public void actionPerformed(ActionEvent e){
       //valida los campos
        if(e.getSource()==Calcular){
            String primero= Numero.getText();
            String segundo= Numero2.getText();
            String sig= Signo.getText();
            String potencia=potencia1.getText();
            String potencial=potencia2.getText();
            //Capcidad maxima de operacion
            if(!primero.isEmpty()&&!segundo.isEmpty()&&!sig.isEmpty()){
            if(primero.length()<=3){
                if(primero.length()<2){
                String primero1=primero;
                    if(primero1.matches(".*[^pqrstwxyz].*")){
                       JOptionPane.showMessageDialog(this, "Debe ser una variable");
                       Numero.setText("");
                       resultado1.setText("");
                    }else{
                        if(sig.matches(".*[^+-].*")){
                         JOptionPane.showMessageDialog(this, "Debe poner un signo");
                         Signo.setText("");  
                         resultado1.setText("");
                        }else{
                            if(potencia.isEmpty()){
                              if(segundo.length()<=3){
                                  if(segundo.length()<2){
                                      if(segundo.matches(".*[^pqrstwxyz].*")){
                                        JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                        Numero2.setText("");  
                                        resultado1.setText("");
                                      }else{
                                          if(primero.equals(segundo)){
                                              JOptionPane.showMessageDialog(this, "Ingreso la misma variable");
                                              resultado1.setText("");
                                          }else{
                                              //Aqui solo para una variable
                                              resultado1.setText("("+primero+"^2"+sig+"2"+primero+segundo+"+"+segundo+"^2)");
                                          }
                                      }
                                  }else if(segundo.length()<3){
                                      String segundo1=segundo.substring(1,2);
                                      String segundo2=segundo.substring(0,1);
                                       if(segundo1.matches(".*[^pqrstwxyz].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                       Numero.setText("");  
                                       resultado1.setText("");    
                                       }else if(segundo2.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero.setText("");  
                                       resultado1.setText(""); 
                                       }else{
                                           if(segundo2.matches(".*[0123456789].*")){
                                               int segundo2int=Integer.parseInt(segundo2);
                                               int rp=segundo2int*segundo2int;
                                               int r2=segundo2int*2;
                                               resultado1.setText("("+primero+"^2"+sig+r2+primero+segundo1+"+"+rp+segundo1+"^2)");
                                           }else{
                                                resultado1.setText("("+primero+"^2"+sig+"2"+segundo2+primero+segundo1+"+("+segundo2+")^2 ("+segundo1+")^2)");
                                           }
                                       }
                                  }else if(segundo.length()<4){
                                      String segundo1=segundo.substring(2,3);
                                      String segundo2=segundo.substring(1,2);
                                      String segundo3=segundo.substring(0,1);
                                       if(segundo1.matches(".*[^pqrstwxyz].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                       Numero2.setText("");  
                                       resultado1.setText("");    
                                       }else if(segundo2.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero2.setText("");  
                                       resultado1.setText(""); 
                                       }else if(segundo3.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero2.setText("");  
                                       resultado1.setText(""); 
                                       }else{
                                           if(segundo2.matches(".*[0123456789].*")){
                                               int segundo2int=Integer.parseInt(segundo2);
                                               int rd=segundo2int*segundo2int;
                                               int rd2=segundo2int*2;
                                               if(segundo3.matches(".*[0123456789].*")){
                                                   int segter=Integer.parseInt(segundo.substring(0,2));
                                                   int rp=segter*segter;
                                                   int r2=segter*2;
                                                   resultado1.setText("("+primero+"^2"+sig+r2+primero+segundo1+"+"+rp+segundo1+"^2)");
                                               }else{
                                                   resultado1.setText("("+primero+"^2"+sig+rd2+segundo3+primero+segundo1+"+"+rd+"("+segundo3+")^2 ("+segundo1+")^2)");
                                               }
                                           }else{
                                               if(segundo3.matches(".*[0123456789].*")){
                                                   int segter=Integer.parseInt(segundo3);
                                                   int rp=segter*segter;
                                                   int r2=segter*2;
                                                   resultado1.setText("("+primero+"^2"+sig+r2+segundo2+primero+segundo1+"+"+rp+"("+segundo2+")^2 ("+segundo1+")^2)");
                                               }else{
                                                   if(segundo3.equals(segundo2)){
                                                       JOptionPane.showMessageDialog(this, "Ingreso la misma constante");
                                                       Numero2.setText("");
                                                       resultado.setText("");
                                                   }else{
                                                   resultado1.setText("("+primero+"^2"+sig+"2"+segundo3+segundo2+primero+segundo1+"+("+segundo3+")^2 ("+segundo2+")^2 ("+segundo1+")^2)");
                                                   }
                                               } 
                                           }
                                       }
                                  }
                              }else{
                                  JOptionPane.showMessageDialog(this, "Ingreso una mas de tres caracteres");                              
                              }
                            }else{
                                //Aqui va codigo con potencia
                                if(segundo.length()<=3){
                                  if(segundo.length()<2){
                                      if(segundo.matches(".*[^pqrstwxyz].*")){
                                        JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                        Numero2.setText("");  
                                        resultado1.setText("");
                                      }else{
                                          if(primero.equals(segundo)){
                                              JOptionPane.showMessageDialog(this, "Ingreso la misma variable");
                                              resultado1.setText("");
                                          }else{
                                              //Aqui solo para una variable
                                              if(potencia.matches(".*[0123456789].*")){
                                                  int pot=Integer.parseInt(potencia);
                                                  int pota=pot*2;
                                                  if(potencial.isEmpty()){
                                                  resultado1.setText("(("+primero+")^"+pota+sig+"2("+primero+")^"+pot+segundo+"+"+segundo+"^2)");
                                                  }else{
                                                      if(potencial.matches(".*[0123456789].*")){
                                                      int pot2=Integer.parseInt(potencial);
                                                      int potc=pot2*2;
                                                      resultado1.setText("("+primero+")^"+pota+sig+"2("+primero+")^"+pot+"("+segundo+")^"+pot2+"+"+segundo+"^"+potc);
                                                      }else if(potencial.matches(".*[a-z].*")){
                                                      String pot2="("+potencial+")^2";
                                                      resultado1.setText("("+primero+")^"+pota+sig+"2("+primero+")^"+pot+"("+segundo+")^"+potencial+"+"+segundo+"^"+pot2);
                                                      }
                                                  }
                                              }else if(potencia.matches(".*[a-z].*")){
                                                  //pontencia letra1
                                                  String pot="("+potencia+")^2";
                                                  if(potencial.isEmpty()){
                                                  resultado1.setText("(("+primero+")^"+pot+sig+"2("+primero+")^"+potencia+segundo+"+"+segundo+"^2)");
                                                  }else{
                                                      if(potencial.matches(".*[0123456789].*")){
                                                      int pot2=Integer.parseInt(potencial);
                                                      int potc=pot2*2;
                                                      resultado1.setText("("+primero+")^"+pot+sig+"2("+primero+")^"+pot+"("+segundo+")^"+pot2+"+"+segundo+"^"+potc);
                                                      }else if(potencial.matches(".*[a-z].*")){
                                                      String pot2="("+potencial+")^2";
                                                      String up="("+potencia+")^2";
                                                      resultado1.setText("("+primero+")^"+up+sig+"2("+primero+")^"+potencia+"("+segundo+")^"+potencial+"+"+segundo+"^"+pot2);
                                                      }
                                                  } 
                                              }
                                          }
                                      }
                                      //validacion del segundo campo
                                  }else if(segundo.length()<3){
                                      String segundo1=segundo.substring(1,2);
                                      String segundo2=segundo.substring(0,1);
                                       if(segundo1.matches(".*[^pqrstwxyz].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                       Numero.setText("");  
                                       resultado1.setText("");    
                                       }else if(segundo2.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero.setText("");  
                                       resultado1.setText(""); 
                                       }else{
                                           if(segundo2.matches(".*[0123456789].*")){
                                               int segundo2int=Integer.parseInt(segundo2);
                                               int rp=segundo2int*segundo2int;
                                               int r2=segundo2int*2;
                                               resultado1.setText("("+primero+"^2"+sig+r2+primero+segundo1+"+"+rp+segundo1+"^2)");
                                           }else{
                                                resultado1.setText("("+primero+"^2"+sig+"2"+segundo2+primero+segundo1+"+("+segundo2+")^2 ("+segundo1+")^2)");
                                           }
                                       }
                                       //validacion de campo
                                  }else if(segundo.length()<4){
                                      String segundo1=segundo.substring(2,3);
                                      String segundo2=segundo.substring(1,2);
                                      String segundo3=segundo.substring(0,1);
                                       if(segundo1.matches(".*[^pqrstwxyz].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una variable");
                                       Numero2.setText("");  
                                       resultado1.setText("");    
                                       }else if(segundo2.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero2.setText("");  
                                       resultado1.setText(""); 
                                       }else if(segundo3.matches(".*[^0123456789abcdefghijklmnño].*")){
                                       JOptionPane.showMessageDialog(this, "Debe ser una constante");
                                       Numero2.setText("");  
                                       resultado1.setText(""); 
                                       }else{
                                           //operatividad
                                           if(segundo2.matches(".*[0123456789].*")){
                                               int segundo2int=Integer.parseInt(segundo2);
                                               int rd=segundo2int*segundo2int;
                                               int rd2=segundo2int*2;
                                               if(segundo3.matches(".*[0123456789].*")){
                                                   int segter=Integer.parseInt(segundo.substring(0,2));
                                                   int rp=segter*segter;
                                                   int r2=segter*2;
                                                   resultado1.setText("("+primero+"^2"+sig+r2+primero+segundo1+"+"+rp+segundo1+"^2)");
                                               }else{
                                                   resultado1.setText("("+primero+"^2"+sig+rd2+segundo3+primero+segundo1+"+"+rd+"("+segundo3+")^2 ("+segundo1+")^2)");
                                               }
                                           }else{
                                               if(segundo3.matches(".*[0123456789].*")){
                                                   int segter=Integer.parseInt(segundo3);
                                                   int rp=segter*segter;
                                                   int r2=segter*2;
                                                   resultado1.setText("("+primero+"^2"+sig+r2+segundo2+primero+segundo1+"+"+rp+"("+segundo2+")^2 ("+segundo1+")^2)");
                                               }else{
                                                   if(segundo3.equals(segundo2)){
                                                       JOptionPane.showMessageDialog(this, "Ingreso la misma constante");
                                                       Numero2.setText("");
                                                       resultado.setText("");
                                                   }else{
                                                   resultado1.setText("("+primero+"^2"+sig+"2"+segundo3+segundo2+primero+segundo1+"+("+segundo3+")^2 ("+segundo2+")^2 ("+segundo1+")^2)");
                                                   }
                                               } 
                                           }
                                       }
                                  }
                              }else{
                                  JOptionPane.showMessageDialog(this, "Ingreso una mas de tres caracteres");                              
                              }
                            }
                        }
                    }
                    //validacion
                }else if(primero.length()<3){
                String primero1=primero.substring(0,1);
                String primero2=primero.substring(1,2);
                JOptionPane.showMessageDialog(this, primero1 + primero2);    
                }else if(primero.length()<4){
                String primero1=primero.substring(0,1);
                String primero2=primero.substring(1,2);
                String primero3=primero.substring(2,3);
                JOptionPane.showMessageDialog(this,  primero1 + primero2 + primero3);    
                }
            }else{
            JOptionPane.showMessageDialog(this, "Porfavor ingrese de nuevo \nel primer termino");            
            }
            }else{
            JOptionPane.showMessageDialog(this, "Alguno campo esta vacio");            
              resultado1.setText("Campo Vacio!!"); 
            }
       }
    }
   
}

