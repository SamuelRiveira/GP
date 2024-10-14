/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gp;

import controladores.Controlador;
import modelos.Modelo;
import vistas.Vista;



/**
 *
 * @author alumno
 */
public class GP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        vista.setVisible(true);
        vista.boton_actualizar.doClick();
    }
    
}
