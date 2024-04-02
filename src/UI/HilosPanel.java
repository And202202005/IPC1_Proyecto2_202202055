package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HilosPanel extends JPanel {
    JLabel image;

    public HilosPanel(){
        BorderLayout borderLayout = new BorderLayout(32, 0);
        this.setBackground(Paleta.fondo);
        this.setBorder(new EmptyBorder(16,24,16,24));
        this.setLayout(borderLayout);

        JButton btInicio = new JButton("Inicio");
        btInicio.setForeground(Paleta.fondo);
        btInicio.setBackground(Paleta.secundario);
        btInicio.setFont(Fuentes.normal);
        btInicio.addActionListener(this::onBtInicioClick);
        this.add(btInicio, BorderLayout.WEST);

        JButton btRegreso = new JButton("Regreso");
        btRegreso.setForeground(Paleta.fondo);
        btRegreso.setBackground(Paleta.secundario);
        btRegreso.setFont(Fuentes.normal);
        btRegreso.addActionListener(this::onBtRegresoClick);
        this.add(btRegreso, BorderLayout.EAST);

        FlowLayout flowLayout= new FlowLayout(FlowLayout.LEFT);
        JPanel panelImagen = new JPanel(flowLayout);
        panelImagen.setBackground(Paleta.fondo);
        image = new JLabel();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("src\\assets\\moto.png"));
            Image nuevaImagen = bufferedImage.getScaledInstance(120,120, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(nuevaImagen);
            image.setIcon(imageIcon);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
            image.setText("Imagen");
        }
        image.setPreferredSize(new Dimension(120,120));
        this.add(image, BorderLayout.CENTER);
    }


    public void onBtInicioClick(ActionEvent e) {
        if (image.getBounds().x == 145 && image.getBounds().y == 16) {
            Thread hilioInicio = new Thread(() -> {
                for (int i = 145; i <= 600; i += 4) {
                    image.setBounds(i, 16, 120, 120);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            hilioInicio.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede inciar, no te encuentras en la posicion inicial!"
            );
        }
    }


    public void onBtRegresoClick(ActionEvent e) {
        if (image.getBounds().x == 597 && image.getBounds().y == 16) {
            Thread hilioInicio = new Thread(() -> {
                for (int i = 597; i >= 145; i -= 4) {
                    image.setBounds(i, 16, 120, 120);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            hilioInicio.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede regresar, no te encuentras en la posicion final!"
            );
        }
    }


}
