/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ACUS
 */

import java.awt.Graphics;
import java.awt.Image;import java.io.IOException;
;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.sound.sampled.*;
import tipografias.fuentes;
public class Crono extends javax.swing.JFrame {

    /**
    
     */
    fuentes tipoFuente;
    static boolean iniciar = true;
    boolean correr = false;
    boolean cancion = false;
    static int hrs = 0, min = 0, seg = 0, milis = 0;
    private Clip sonido;
    String soundFilePath = "/sonido/b.wav";
    public Crono() {
        initComponents();
        pausarBtn.setEnabled(false);
        reiniciarBtn.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Cronometro The Batman");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/the_batman__2022__logo_png__by_mintmovi3_de3mn3j-fullview.png")).getImage());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hora = new javax.swing.JLabel();
        reiniciarBtn = new javax.swing.JButton();
        iniciarBtn = new javax.swing.JButton();
        pausarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hora.setBackground(new java.awt.Color(255, 204, 0));
        hora.setFont(new java.awt.Font("Teko SemiBold", 1, 100)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setText("00:00:00.000");
        hora.setToolTipText("");
        getContentPane().add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        reiniciarBtn.setFont(new java.awt.Font("Teko SemiBold", 1, 32)); // NOI18N
        reiniciarBtn.setText("Reiniciar");
        reiniciarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reiniciarBtnMouseClicked(evt);
            }
        });
        reiniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(reiniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, 60));

        iniciarBtn.setFont(new java.awt.Font("Teko SemiBold", 1, 32)); // NOI18N
        iniciarBtn.setText("Iniciar");
        iniciarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarBtnMouseClicked(evt);
            }
        });
        iniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 150, 60));

        pausarBtn.setFont(new java.awt.Font("Teko SemiBold", 1, 32)); // NOI18N
        pausarBtn.setText("Pausar");
        pausarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pausarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 150, 60));

        jLabel2.setBackground(new java.awt.Color(153, 204, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/960x0.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        if(cancion == false){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFilePath)); // Get audio input stream
            Clip clip = AudioSystem.getClip(); // Get audio clip
            clip.open(audioInputStream); // Open the audio stream
            clip.start(); // Start playback
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            // Handle exceptions (e.g., display error message)
            System.out.println("Error playing audio: " + e.getMessage());
        }
        cancion = true;}
        
        if(correr == false){
            iniciarBtn.setEnabled(false);
            pausarBtn.setEnabled(true);
            iniciar = true;
            correr = true;
            iniciarHilo();
                    
        }
    }//GEN-LAST:event_iniciarBtnActionPerformed

    private void iniciarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarBtnMouseClicked
        if(correr == false){
            iniciar = true;
            correr = true;
            iniciarHilo();
                    
        }
    }//GEN-LAST:event_iniciarBtnMouseClicked

    private void pausarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarBtnActionPerformed
        String buttonText = pausarBtn.getText();
        if(buttonText == "Pausar"){
        correr = false;
        iniciar = false;
        reiniciarBtn.setEnabled(true);
        pausarBtn.setText("Reanudar");
        }else{
            correr = true;
        iniciar = true;
        pausarBtn.setText("Pausar");
        reiniciarBtn.setEnabled(false);
        iniciarHilo();
        }
    }//GEN-LAST:event_pausarBtnActionPerformed

    private void reiniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarBtnActionPerformed
        hora.setText("00:00:00.000");
        correr = false;
        iniciar = false;
        iniciarBtn.setEnabled(true);
        pausarBtn.setEnabled(false);
        reiniciarBtn.setEnabled(false);
        
    }//GEN-LAST:event_reiniciarBtnActionPerformed

    private void reiniciarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reiniciarBtnMouseClicked
        hora.setText("00:00:00.000");
        hrs = 0;
        min = 0;
        seg = 0;
        milis = 0;
        correr = false;
        iniciar = false;
        pausarBtn.setText("Pausar");
    }//GEN-LAST:event_reiniciarBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hora;
    private javax.swing.JButton iniciarBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton pausarBtn;
    private javax.swing.JButton reiniciarBtn;
    // End of variables declaration//GEN-END:variables

    private void iniciarHilo() {
        if(iniciar == true){
            System.out.println("Inicio");
            Cronometro cronom =  new Cronometro(hora);
            cronom.start();
        }
    }
    
}