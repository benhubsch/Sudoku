import javax.swing.*;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SudokuGUI extends JFrame {
	private JTable table;
	private JTextField textField;
	


    public SudokuGUI(int[][] board){
    	getContentPane().setLayout(new GridLayout(9, 9, 0, 0));
    	
    	table = new JTable();
    	table.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			System.out.println("hello");
    		}
    	});
    	
    	textField = new JTextField();
    	textField.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			System.out.println("hello");
    		}
    	});
    	textField.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			System.out.println("hello");
    		}
    	});
    	getContentPane().add(textField);
    	textField.setColumns(10);
    	getContentPane().add(table);

    	
    	
    }
    

}
