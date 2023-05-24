package src;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mphstar
 */
// Tabel

public class CustomTable extends DefaultTableCellRenderer{

    public CustomTable() {
        setOpaque(true);
        
        setPreferredSize(new Dimension(50, 50));
        setHorizontalAlignment(CENTER);
    
        
    }
    
}
