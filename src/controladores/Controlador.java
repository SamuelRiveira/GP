/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelos.Modelo;
import vistas.Vista;

/**
 *
 * @author alumno
 */
public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.boton_actualizar.addActionListener(this);
        this.vista.boton_matar.addActionListener(this);
        this.vista.boton_nuevo.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.boton_actualizar) {
            List<List<String>> matrizProcesos = modelo.ListaProcesos();
            DefaultTableModel model = new DefaultTableModel();
            for (int j=0; j<3; j++) {
                model.addColumn(matrizProcesos.get(0).get(j));
            }
            for (int i = 1; i < matrizProcesos.size(); i++){
                model.addRow(new Object[]{matrizProcesos.get(i).get(0), matrizProcesos.get(i).get(1), matrizProcesos.get(i).get(2)});
            }
            vista.Tabla.setModel(model);
            vista.Label1.setText(String.valueOf(model.getRowCount()) + " procesos");
        }else if(e.getSource() == vista.boton_nuevo){
            var  label = vista.textfieldactualizar.getText();
            modelo.crearProceso(label);
        }else if (e.getSource() == vista.boton_matar){
            var  label = vista.textfieldactualizar.getText();
            try {
                modelo.matarProceso(label);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}