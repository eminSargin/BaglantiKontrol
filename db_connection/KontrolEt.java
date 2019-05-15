package db_connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
public class KontrolEt {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPortNo;
	private JTextField txtIpAdresi;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontrolEt window = new KontrolEt();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void OracleBaglanti(String ipAdresi,String User,String password,String port) {
		String DB_URL = "jdbc:oracle:thin:@"+ipAdresi+":"+port+":EJD";
		String USER = User;
		String PASS = password;
		
		Connection conn = null;  
	    try {    
	      Class.forName("oracle.jdbc.driver.OracleDriver");    
	      //System.out.println(DB_URL+" "+USER+" "+PASS);    
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      
	    } catch (Exception e) {    
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(frame,e.toString());
	    } finally {    
	      if (conn != null) { 
	    	  JOptionPane.showMessageDialog(frame, "Baðlantý Baþarýlý Bir Þekilde Oluþturuldu.");
	    	  
	    	  System.out.println("Baðlantý Baþarýlý");
	    	  
	        try {  
	        	
	          conn.close();  
	          if(conn.isClosed() == true) {
	        		 System.out.println("Baðlantý Baþarýlý Bir Þekilde Kapatýldý..");
	        	 }
	          
	          	
	        } catch (SQLException e) {    
	          e.printStackTrace();  
	          JOptionPane.showMessageDialog(frame,e.toString());
	        }    
	      }    
	    } 
		
	}
	 
	public void PostgreSqlBaglanti() {
		
	}
	public KontrolEt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 180, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 170, 155, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtIpAdresi.setText("");
				txtPass.setText("");
				txtPortNo.setText("");
				txtUser.setText("");
				 
			}
		});
		panel.add(btnTemizle);
		
		JButton btnSorgula = new JButton("Ba\u011Flan");
		panel.add(btnSorgula);
		
		JCheckBox chcOracle = new JCheckBox("Oracle");
		buttonGroup.add(chcOracle);
		chcOracle.setBounds(10, 38, 57, 23);
		frame.getContentPane().add(chcOracle);
		
		JCheckBox chcPostgreSql = new JCheckBox("PostgreSql");
		chcPostgreSql.setEnabled(false);
		buttonGroup.add(chcPostgreSql);
		chcPostgreSql.setBounds(77, 38, 97, 23);
		frame.getContentPane().add(chcPostgreSql);
		
		txtUser = new JTextField();
		txtUser.setBounds(77, 114, 86, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPortNo = new JTextField();
		txtPortNo.setColumns(10);
		txtPortNo.setBounds(77, 91, 86, 20);
		frame.getContentPane().add(txtPortNo);
		
		JLabel lblDbUser = new JLabel("DB USER");
		lblDbUser.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(lblDbUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 142, 57, 14);
		frame.getContentPane().add(lblPassword);
		
		txtIpAdresi = new JTextField();
		txtIpAdresi.setColumns(10);
		txtIpAdresi.setBounds(77, 67, 86, 20);
		frame.getContentPane().add(txtIpAdresi);
		
		JLabel lblIpAdresi = new JLabel("IP ADRES\u0130");
		lblIpAdresi.setBounds(10, 70, 57, 14);
		frame.getContentPane().add(lblIpAdresi);
		
		JLabel txtPort = new JLabel("PORT");
		txtPort.setBounds(10, 94, 39, 14);
		frame.getContentPane().add(txtPort);
		
		JLabel txtMesaj = new JLabel("Emin SARGIN");
		txtMesaj.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesaj.setHorizontalTextPosition(SwingConstants.CENTER);
		txtMesaj.setBackground(Color.GRAY);
		txtMesaj.setAutoscrolls(true);
		txtMesaj.setBounds(11, 213, 154, 20);
		frame.getContentPane().add(txtMesaj);
		
		JLabel lblBalantKontrol = new JLabel("Ba\u011Flant\u0131 Kontrol");
		lblBalantKontrol.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBalantKontrol.setForeground(Color.RED);
		lblBalantKontrol.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBalantKontrol.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalantKontrol.setBackground(Color.GRAY);
		lblBalantKontrol.setAutoscrolls(true);
		lblBalantKontrol.setBounds(10, 11, 154, 20);
		frame.getContentPane().add(lblBalantKontrol);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(77, 138, 86, 20);
		frame.getContentPane().add(txtPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 210, 154, 2);
		frame.getContentPane().add(separator);
		btnSorgula.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(chcOracle.isSelected() == true) {
					if(!txtUser.getText().equals("") && !txtPort.getText().equals("") && !txtIpAdresi.getText().equals("") && !txtPass.getText().equals("")&& !txtPortNo.getText().equals("")) {
						System.out.println("oracle seçildi");
						String ipAdresi = txtIpAdresi.getText();
						String User = txtUser.getText();
						String password = txtPass.getText();
						String port = txtPortNo.getText();
						User=User.toUpperCase(Locale.ENGLISH);
						OracleBaglanti(ipAdresi, User, password, port);
						
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Tüm Deðerlerin Girilmesi Zorunludur");
					}
					
					
				}
				if(chcPostgreSql.isSelected() == true) {
					
					
				}
				if(chcOracle.isSelected() == false && chcPostgreSql.isSelected() == false) {
					JOptionPane.showMessageDialog(frame, "Veritabaný Tipi Seçilmesi Zorunludur!");
				}
				 
				
			}
		});
		
	}
}
