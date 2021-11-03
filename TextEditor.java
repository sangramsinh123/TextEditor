import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import java.util.*;

@SuppressWarnings("serial")
public class TextEditor extends JFrame implements ActionListener {
	
	JTextArea textArea;
	//InlineCssTextArea area;
	JScrollPane  scrollPane;
	JSpinner FontSizeSpinner;
	JButton fontColorButton;
	JLabel forFonts;
	JLabel forSize;
	//@SuppressWarnings("rawtypes")
	JComboBox<?> changeFontBox;
	//ComboBox combobox;
	JMenuBar menuBar;
	JMenu filemenu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	JMenuItem newItem;
	
	//creating constructor
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TextEditor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sam TextEditor");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		//above the text Editor we have to show Jspinner Options
		textArea=new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Geneva",Font.PLAIN,20));
		
		//area=new Inline
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		forSize= new JLabel("Size");
		FontSizeSpinner = new JSpinner();
		FontSizeSpinner.setPreferredSize(new Dimension(50,25));
		FontSizeSpinner.setValue(20);
		//TODO:I just want to increase the size of the selected font 
		FontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				//TODO
				//change only for selected states
		
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)FontSizeSpinner.getValue()));
//				textArea.getSelectedText().fore

			}
			
		});
		
		fontColorButton = new JButton("Color");
		fontColorButton.addActionListener(this);
		
		forFonts= new JLabel("Fonts");
		
		//Array of stings 
		//List<String> fontFamilies = Font.getFamilies();  //javafx
		//comboBox also provides collection 
		// combobox = newJComboBox(FXCollections.observableArrayList(Font.getFamilies()));  but first import javafx.collections
		String[] fonts=  GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		changeFontBox= new JComboBox(fonts);
		changeFontBox.addActionListener(this);
		changeFontBox.setSelectedItem("Arail");
		//changeFontBox.setSelectedIndex("Arail");
		//=====================
		
		menuBar = new JMenuBar();
		filemenu = new JMenu("File");
		
		newItem = new JMenuItem("New");
		openItem = new JMenuItem("open");
		saveItem = new JMenuItem("save");
		exitItem = new JMenuItem("exit");
		
		newItem.addActionListener(this);
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		filemenu.add(newItem);
		filemenu.add(openItem);
		filemenu.add(saveItem);
		filemenu.add(exitItem);
		menuBar.add(filemenu);
		
		//=====================
		this.setJMenuBar(menuBar);
		this.add(forSize);
		this.add(FontSizeSpinner);
		this.add(fontColorButton);
		this.add(forFonts);
		this.add(changeFontBox);
		this.add(scrollPane);
		this.setVisible(true);
	}
	//method
	
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==fontColorButton) {
			JColorChooser colorChooser= new JColorChooser();
			//Color color=colorChooser.showDialog(null, "choose color", Color.black);
			textArea.setForeground(colorChooser.showDialog(null, "choose color", Color.black));
		}
		
		if(e.getSource()==changeFontBox) {
			textArea.setFont(new Font((String)changeFontBox.getSelectedItem(),(int)Font.PLAIN,(int)textArea.getFont().getSize()));
		}
		
		if(e.getSource()==openItem) {
			
			
		}
		if(e.getSource()==saveItem) {
			
		}
		
		if(e.getSource()==exitItem) {
			//there is bug here 
			System.exit(0);
		}
		
		//create entire new file
		if(e.getSource()==newItem) {
			//run program 
			Main m = null;
			m.main(null);
		}
	}

}
