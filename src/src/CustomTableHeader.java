package src;


import java.awt.Color;
import java.awt.Dimension;
import static javax.swing.SwingConstants.CENTER;
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
public class CustomTableHeader extends DefaultTableCellRenderer{
    public CustomTableHeader() {
        setOpaque(true);
        setPreferredSize(new Dimension(40, 40));
        setHorizontalAlignment(CENTER);
        setBackground(new Color(99, 159, 227));
        setForeground(Color.WHITE);
        
    }
    
}
