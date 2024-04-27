
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author ACUS
 */
public class Cronometro extends Thread {
    
    JLabel horas;
    
    public Cronometro(JLabel cronometro){
    this.horas = cronometro;
    }
    public void run(){
        try{
            int x = 0;
            
            while(Crono.iniciar){
                Thread.sleep(1);
                hilosCrononom(x);
            }
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void hilosCrononom(int x) {
        Crono.milis++;
        
        if(Crono.milis>999){
            Crono.milis = 0;
            Crono.seg++;
        }
        
        String textMilis = "", textSeg = "", textMin = "", textHrs = "";
        
        if (Crono.milis < 10){
            textMilis = "00" + Crono.milis;
        }else if (Crono.milis < 100){
            textMilis = "0" + Crono.milis;
        } else textMilis = "" + Crono.milis;
        
        if (Crono.seg < 10){
            textSeg = "0" + Crono.seg;
        }else textSeg = "" + Crono.seg;
        
        if (Crono.min < 10){
            textMin = "0" + Crono.min;
        }else textMin = "" + Crono.min;
        
        if (Crono.hrs < 10){
            textHrs = "0" + Crono.hrs;
        }else textHrs = "" + Crono.hrs;
        
        
        String cron = textHrs + ":" + textMin + ":" + textSeg + "." + textMilis;
        
        horas.setText(cron);
    }
    /**
     * @param args the command line arguments
     */

    
}
