package factorialfibonacci;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class Series implements ActionListener{
    
    /** Es la ventana del programa */
    JFrame ventana;
    
    /** Es el número que se desea usar */
    JTextField numero;
    
    /** Boton de ejecución */
    JButton obtener;
    
    /** Espacios donde se imprimen los resultados */
    JLabel escribeNum, Rfactorial, Sfibonacci;
    
    /** Contenedor de elementos */
    Container cont;
    
    /**
    *
    * Constructor. Crea una ventana y la agrega a un contenedor
    * 
    */
    
    public Series(){
        ventana = new JFrame("Ahorcado");
        ventana.setSize(400,500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.setResizable(false);
        
        cont = ventana.getContentPane();
        cont.setBackground(Color.WHITE);
        Componentes();
        
        ventana.setVisible(true);
    }
    
    public void Componentes(){
        numero = new JTextField("");
        numero.setBounds(230, 120, 100, 30);
        cont.add(numero);
        
        escribeNum = new JLabel("Escribe un numero");
        escribeNum.setBounds(90, 120, 130, 30);
        cont.add(escribeNum);
        
        Sfibonacci = new JLabel("Serie Fibonacci");
        Sfibonacci.setBounds(50, 210, 300, 90);
        cont.add(Sfibonacci);
        
        Rfactorial = new JLabel("Factorial");
        Rfactorial.setBounds(50, 310, 300, 90);
        cont.add(Rfactorial);
        
        obtener = new JButton("Obtener");
        obtener.setBounds(100, 160, 120, 40);
        obtener.addActionListener(this);
        cont.add(obtener);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fibonacci(numero.getText());
        factorial(numero.getText());
    }
    
    
    /**
    * Calcula el factorial.
    * 
    * @param n Numero indicado en el campo de texto
    */
    
    public void fibonacci(String n){
        int nFibonacci = Integer.parseInt(n);
        
        int a = 0;
        int b = 1;
        int resultado;
        String cadena = String.valueOf(a) + ", " + String.valueOf(b) + ", ";
        if(nFibonacci == 1){
            cadena = "0";
        } else{
            if(nFibonacci == 2){
                cadena = "0, 1";
            } else{
                for(int y = 0; y < (nFibonacci - 2); y++){
                    resultado = a + b;
                    if(y == (nFibonacci - 3)){
                        cadena += String.valueOf(resultado);
                    } else{
                        cadena += String.valueOf(resultado) + ", ";
                    }
                    a = b;
                    b = resultado;
                }
            }
        }
        Sfibonacci.setText(cadena);
    }
    
    /**
    * Realiza la serie.
    * 
    * @param n Numero indicado en el campo de texto
    */
    
    public void factorial(String n){
        int nFactorial = Integer.parseInt(n);
        int resultado = 1;
        for(int x = 0; x < nFactorial; x++){
            resultado = resultado * (x + 1);
        }
        Rfactorial.setText(String.valueOf(resultado));
    }
}
