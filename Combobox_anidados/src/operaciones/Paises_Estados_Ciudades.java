
package operaciones;


import conexion.Ciudades;
import conexion.Estados;
import conexion.Paises;
import java.awt.Image;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Paises_Estados_Ciudades extends javax.swing.JFrame {

    
    public Paises_Estados_Ciudades() {
        initComponents();
         this.setTitle("PEC");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //Codigo para insertar la imagen de fondo y ajustarla 
        ImageIcon imagen = new ImageIcon("mapa.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jButton1.getWidth(), jButton1.getHeight(),Image.SCALE_DEFAULT));
        jButton1.setIcon(icono);
        this.repaint();
        
       //Operaciones con la base de datos
       Paises p = new Paises();
       DefaultComboBoxModel modelopais = new DefaultComboBoxModel(p.mostrarPaises());
       combo_pais.setModel(modelopais);
       

        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_pais = new javax.swing.JComboBox<>();
        combo_estado = new javax.swing.JComboBox<>();
        combo_ciudad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pais:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ciudad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        combo_pais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_paisItemStateChanged(evt);
            }
        });
        combo_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paisActionPerformed(evt);
            }
        });
        getContentPane().add(combo_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 190, -1));

        combo_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_estadoItemStateChanged(evt);
            }
        });
        combo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estadoActionPerformed(evt);
            }
        });
        getContentPane().add(combo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 190, -1));

        combo_ciudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_ciudadItemStateChanged(evt);
            }
        });
        combo_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_ciudadActionPerformed(evt);
            }
        });
        getContentPane().add(combo_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 190, -1));

        informacion.setEditable(false);
        informacion.setColumns(20);
        informacion.setRows(5);
        jScrollPane1.setViewportView(informacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 270, 110));

        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverEnabled(false);
        jButton1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_paisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_paisItemStateChanged
      try{
        if(evt.getStateChange() == ItemEvent.SELECTED){
            
            Paises pai = (Paises) combo_pais.getSelectedItem();
            
            Estados est = new Estados();
            DefaultComboBoxModel modeloestado = new DefaultComboBoxModel(est.mostrarEstados(pai.getId()));
           
            combo_estado.setModel(modeloestado);
//            combo_estado.removeAllItems();
            combo_ciudad.removeAllItems();
            informacion.setText("");
            
        }
      }catch(Exception e){
          
      }
    }//GEN-LAST:event_combo_paisItemStateChanged

    private void combo_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_estadoItemStateChanged
       if(evt.getStateChange() == ItemEvent.SELECTED){
            
            Estados est = (Estados) combo_estado.getSelectedItem();
            
            Ciudades ciu = new Ciudades();
            DefaultComboBoxModel modelociudad = new DefaultComboBoxModel(ciu.mostrarCiudades(est.getId()));
            combo_ciudad.setModel(modelociudad);
            
            
            informacion.setText("");
//            combo_ciudad.removeAllItems();
            
        }
    }//GEN-LAST:event_combo_estadoItemStateChanged

    private void combo_ciudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_ciudadItemStateChanged
       if(evt.getStateChange() == ItemEvent.SELECTED){
           Paises pai = (Paises) combo_pais.getSelectedItem();
            Estados est = (Estados) combo_estado.getSelectedItem();
            Ciudades ciu = (Ciudades) combo_ciudad.getSelectedItem();
            
            informacion.setText("País: "+pai.getNombre()+"\nEstado: "+est.getNombre()+"\nCiudad: "+ciu.getNombre());
            
            
            //Ciudades ciu = new Ciudades();
//            DefaultComboBoxModel modelociudad = new DefaultComboBoxModel(ciu.mostrarCiudades(est.getId()));
//            combo_ciudad.setModel(modelociudad);
            
        }
    }//GEN-LAST:event_combo_ciudadItemStateChanged

    private void combo_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paisActionPerformed
         System.out.println(combo_pais.getSelectedItem().toString());
    }//GEN-LAST:event_combo_paisActionPerformed

    private void combo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estadoActionPerformed
        System.out.println(combo_estado.getSelectedItem().toString());
    }//GEN-LAST:event_combo_estadoActionPerformed

    private void combo_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_ciudadActionPerformed
        System.out.println(combo_ciudad.getSelectedItem().toString());
    }//GEN-LAST:event_combo_ciudadActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paises_Estados_Ciudades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_ciudad;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_pais;
    private javax.swing.JTextArea informacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
