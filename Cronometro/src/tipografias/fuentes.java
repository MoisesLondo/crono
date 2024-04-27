/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipografias;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author ACUS
 */
public class fuentes {
    private Font font = null;
    public String FIORELLO = "fiorello-cg-condensed-regular.otf";
    
    public Font fuente(String fontName, int estilo, int tamaño){
        try{
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        }
        catch(Exception e){
            System.err.println(fontName + " no se cargó");
        }
        
        Font tfont = font.deriveFont(estilo,tamaño);
        return tfont;
    }
}
