package ejercicio24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Arturo
 */
public class VentanaCirculos extends JFrame implements ActionListener{

    JFrame marco;
    JPanel panel;
    Graphics g;
    JButton bdibuja, blimpiar;
    JTextField numero;

    public VentanaCirculos(){
        //Instanciamos los objetos
        marco=new JFrame("Ventana Dibujos");
        panel=new JPanel();
        bdibuja=new JButton("Dibujar");
        blimpiar=new JButton("Limpiar");
        numero=new JTextField(15);
        //Ajustamos los valores iniciales
        numero.setText("0");
        marco.setSize(600, 500);
        //añadimos los objetos a la ventana
        panel.add(blimpiar);
        panel.add(bdibuja);
        panel.add(numero);
        marco.add(panel);
        //Inuciamos los listeners
        blimpiar.addActionListener(this);
        bdibuja.addActionListener(this);
        //Ultimos ajustes de pantalla
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object objeto=e.getSource();
        //valores maximos y minimos para la generación automatica de coordenadas
        int max=380;
        int min=0;
        if(objeto==bdibuja){
            g=panel.getGraphics();
            for(int i=1; i<=Integer.parseInt(numero.getText()); i++){
                int x=(int) (Math.random()*(max-min))+min;
                int y=(int) (Math.random()*(max-min))+min;
                g.setColor(Color.red);
                //se colocan unas variables en las posiciones del circulo para ajustar su posición relativa en la pantalla
                g.fillOval(x+90, y+50, 20, 20);
            }
        }else{

            g.clearRect(0, 50, marco.getWidth(), marco.getHeight());
        }
    }
}
