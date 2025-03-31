/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p6;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Map;

/**
 *
 * @author aidam
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }
    
    String tipoFuente = "Arial";
    
    Ellipse2D clipArea = new Ellipse2D.Float(100, 100, 500, 500);
    
    Boolean ventanaClipActiva = false;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if(ventanaClipActiva){
            g2d.setClip(clipArea);
            g2d.draw(clipArea);
        }
        this.pruebaAtributos(g2d);
    }

    private void pruebaAtributos(Graphics2D g2d) {
        //Recorte
        //Shape clipArea;
        //clipArea = new Ellipse2D.Float(100, 100, 500, 500);
        //g2d.setClip(clipArea);
        //g2d.draw(clipArea);
        
        //Trazo
        Stroke trazo;
        float patronDiscontinuidad[] = {10.0f, 10.0f};
        trazo = new BasicStroke(5.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f,
                patronDiscontinuidad, 0.0f);
        g2d.setStroke(trazo);
//Pintamos una forma de prueba
        g2d.draw(new Line2D.Float(40, 40, 160, 160));

        //Relleno
        Paint relleno;
        relleno = new Color(255, 100, 0);
        g2d.setPaint(relleno);

        g2d.draw(new Rectangle(170, 40, 120, 120));
        g2d.fill(new Rectangle(300, 40, 120, 120));

        Point pc1 = new Point(430, 40), pc2 = new Point(550, 160);
        relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
        g2d.setPaint(relleno);
        g2d.fill(new Rectangle(430, 40, 120, 120));

        //Composición
        Composite comp;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
        g2d.setComposite(comp);
        g2d.fill(new Rectangle(190, 100, 200, 120));

        //Transformación
        Rectangle r = new Rectangle(430, 190, 120, 120);
        g2d.draw(r); //Dibujamos rectángulo sin transformación
        AffineTransform at;
        at = AffineTransform.getRotateInstance(Math.toRadians(45.0),
                r.getCenterX(),
                r.getCenterY());
        g2d.setTransform(at);

        g2d.fill(r); //Dibujamos rectángulo con transformación

        at = AffineTransform.getScaleInstance(0.5, 0.5);
        g2d.setTransform(at);
        g2d.draw(r);

        at.setToIdentity();
        at.translate(r.getCenterX(), r.getCenterY());
        at.scale(0.5, 0.5);
        at.translate(-r.getCenterX(), -r.getCenterY());
        g2d.setTransform(at);
        g2d.draw(r);

        at.setToIdentity();
        at.translate(r.getCenterX(), r.getCenterY());
        at.scale(0.25, 0.25);
        g2d.setTransform(at);
        g2d.draw(r);

        at.setToIdentity();
        g2d.setTransform(at);

        //Fuente
        Font fuente;
        //fuente = new Font("Arial", Font.BOLD | Font.ITALIC, 45);
        fuente = new Font(tipoFuente, Font.BOLD | Font.ITALIC, 45);
        g2d.setFont(fuente);
        g2d.drawString("Hola", 30, 220);

        Map atributosTexto = fuente.getAttributes();
        atributosTexto.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        g2d.setFont(new Font(atributosTexto));
        g2d.drawString("mundo", 30, 260);

        //Renderización
        RenderingHints render;
        g2d.draw(new Ellipse2D.Float(40, 350, 510, 50)); //Elipse sin antialiasing
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(render);
        g2d.draw(new Ellipse2D.Float(40, 450, 510, 50)); //Elipse con antialiasing
        g2d.drawString("Hola", 30, 170); //Texto con antialiasing

        render.put(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        //Recorte
        /*Shape clipArea;
        clipArea = new Ellipse2D.Float(100, 100, 500, 500);
        g2d.setClip(clipArea);
        g2d.draw(clipArea);*/
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Recorte = new javax.swing.JCheckBox();
        GraphicsEnvironment ge;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String []fuentesSistema = ge.getAvailableFontFamilyNames();
        ListaFuentes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        Recorte.setText("Recorte");
        Recorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecorteActionPerformed(evt);
            }
        });

        ListaFuentes.setModel(new javax.swing.DefaultComboBoxModel<>(fuentesSistema));
        ListaFuentes.setMinimumSize(new java.awt.Dimension(10, 10));
        ListaFuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaFuentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ListaFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Recorte, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Recorte)
                    .addComponent(ListaFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaFuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaFuentesActionPerformed
        // TODO add your handling code here:
        tipoFuente = (String)ListaFuentes.getSelectedItem();
        this.repaint();
    }//GEN-LAST:event_ListaFuentesActionPerformed

    private void RecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecorteActionPerformed
        // TODO add your handling code here:
        ventanaClipActiva = this.Recorte.isSelected();
    }//GEN-LAST:event_RecorteActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        if (ventanaClipActiva){
            Point corner = evt.getPoint();
            corner.translate((int)clipArea.getWidth()/2, (int)clipArea.getHeight()/2);
            clipArea.setFrameFromCenter(evt.getPoint(), corner);
            this.repaint();
        }
    }//GEN-LAST:event_formMouseMoved

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaFuentes;
    private javax.swing.JCheckBox Recorte;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
