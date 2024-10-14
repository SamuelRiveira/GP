/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Modelo {
    public List<List<String>> ListaProcesos() {
        String[] comando = {"ps", "-eo", "pid,euser,comm"};
        List<List<String>> listaProcesos = new ArrayList<List<String>>();

        try {
        
            Process proceso = Runtime.getRuntime().exec(comando);
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = lector.readLine()) != null) {
                List<String> filaProcesos = new ArrayList<String>();
                filaProcesos.add(linea.substring(0, 7));
                filaProcesos.add(linea.substring(8, 15));
                filaProcesos.add(linea.substring(16));
                listaProcesos.add(filaProcesos);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return listaProcesos;
    }
    public void matarProceso(String proceso) throws IOException{
        ProcessBuilder pb = new ProcessBuilder("killall", proceso);
        Process p = pb.start();
    }
    public void crearProceso(String proceso){
        ProcessBuilder pb01 = new ProcessBuilder(proceso);
        try {
            Process p01 = pb01.start();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


/*

ELIMINAR Y CREAR PROCESO

ProcessBuilder pb01 = new ProcessBuilder(campoTexto1.getText());
        try {
            Process p01 = pb01.start();
            Thread.sleep(5000);
            p01.destroy();
        } catch (IOException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
*/