package ejerciciosFicherosObj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ListaClientes extends JFrame{
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private File f;
	
	public ListaClientes() {
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Listar Clientes");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblTexto = new JLabel("Listar Clientes");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTexto.setBounds(143, 11, 116, 14);
		getContentPane().add(lblTexto);
		
		JButton btnElegirFile = new JButton("Elegir Fichero");
		btnElegirFile.setBounds(143, 48, 116, 23);
		getContentPane().add(btnElegirFile);
		btnElegirFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirExplorador();
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		dtm.setColumnIdentifiers(new String[] {"DNI","Nombre","Direccion","Saldo","Estado_Cuenta"});
		table = new JTable(dtm);
		getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(51, 90, 378, 205);
		getContentPane().add(scrollPane);
		
		setVisible(true);
	}
	
	private void abrirExplorador() throws IOException, ClassNotFoundException {
		ArrayList<Clientes>clientes;//=new ArrayList<>();
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int opcion=fc.showOpenDialog(this);
		
		if(opcion==JFileChooser.APPROVE_OPTION) {
			f=new File(fc.getSelectedFile()+"");
			FileInputStream fs=new FileInputStream(f);
			ObjectInputStream os=new ObjectInputStream(fs);
			clientes=(ArrayList<Clientes>) os.readObject();
			for(Clientes c:clientes) {
				insertarCliente(c);
			}
		}
	}
	
	private void insertarCliente(Clientes c) {
		dtm.addRow(c.getArrayDatos());
		
	}
}
