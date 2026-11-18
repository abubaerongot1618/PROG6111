
package runapplication1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ABUBAKER
 */
public class JFrame9 extends JFrame {
    private final JButton  txtButton = new JButton("OK");
    
    //Declaration of comboBox
       JComboBox<String> comboBox;
    
ProductCalaculations pc = new ProductCalaculations();
        
        
    public JFrame9() {
        //Set title of frame
        setTitle("Product App");
        
        //Size of frame
        setSize(500,500);
        
        //EXIT OUT OF APPLICATION
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         String[] mattress = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
         comboBox = new JComboBox<>(mattress);
        
        //Creating a layout
        setLayout(new BorderLayout());
        
        
        
        JButton loadButton = new JButton("Load Button");
        JButton saveButton = new JButton("Save Button");
        
        JTextArea area = new JTextArea(10,20);
         area.setMargin(new Insets(10, 10, 10, 10));
         
        //Add the area to scroll pane
        JScrollPane scrollPane = new JScrollPane(area);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        
        JMenu toolsMenu =  new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem clearItem = new JMenuItem("Clear");
        
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);
        
        //Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        
        
        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        
        buttonPanel.add(loadButton);
         buttonPanel.add(saveButton);
         
         Container content =getContentPane();
         this.add(comboBox);
         content.add(txtButton);
       
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        
       area.setText("Customer Name:  "+ pc.GetCustomerName() +"\n" +
                   "Product:        "+ pc.GetProduct() + "\n"+
                 "VAT :   "+ Math.round(pc.GetVat()) +"\n" +
                 "Commission: "+ pc.GetCommission()+"\n"+
                "TOTAL: "+ pc.GetTotal());
        
        
       
        
                      
     
       
        // Load Button listener
        loadButton.addActionListener(e -> {
            try{
                area.setText("");
                
              Scanner scanner  =new Scanner (new File("data.txt"));
          while( scanner.hasNextLine()) {
           String line = scanner.nextLine();
           
           area.append(line +"\n");
       } 
           scanner.close();
            } catch (FileNotFoundException ex) {
                System.getLogger(JFrame9.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
           });  
        
        //Save Button listener
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter("data.txt");
                      PrintWriter out = new PrintWriter(fileWriter);
                      
                      //Write the contents of the text area to the file
                      out.println(area.getText());
                      
                      out.close();
                } catch (IOException ex) {
                    System.getLogger(JFrame9.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
            
            
        });
        
        exitItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
    );
        clearItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("");
            } 
        }
        );
        
        saveItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton.doClick();
                
            } 
        }
        );
        
        loadItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                loadButton.doClick();
            }   
        }); 
        setJMenuBar(menuBar);
        setVisible(true);
    }
 
        
        
        
        
   
    }
    

