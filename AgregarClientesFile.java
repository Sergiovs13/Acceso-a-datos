package ejerciciosFicherosObj;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class AgregarClientesFile extends JFrame{
	private JTextField tfDNI,tfNombre,tfDireccion, tfSaldo;
	private JLabel lblDni,lblNombre,lblDireccion, lblSaldo;
	private JButton btnAnyadir, btnBorrar;
	private File f;
	public AgregarClientesFile() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		setTitle("Agregar Clientes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblTexto = new JLabel("Agregar Clientes");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTexto.setBounds(158, 11, 174, 24);
		getContentPane().add(lblTexto);
		
		JButton btnElegirFile = new JButton("Elegir Fichero");
		btnElegirFile.setBounds(168, 46, 121, 23);
		getContentPane().add(btnElegirFile);
		
		btnElegirFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					abrirExploradorFicheros();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setBounds(46, 138, 46, 14);
		getContentPane().add(lblDni);
		lblDni.setVisible(false);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(115, 135, 174, 20);
		getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		tfDNI.setVisible(false);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(35, 181, 57, 14);
		getContentPane().add(lblNombre);
		lblNombre.setVisible(false);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(115, 178, 174, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		tfNombre.setVisible(false);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(35, 220, 57, 14);
		getContentPane().add(lblDireccion);
		lblDireccion.setVisible(false);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(115, 217, 174, 20);
		getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		tfDireccion.setVisible(false);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaldo.setBounds(46, 263, 46, 14);
		getContentPane().add(lblSaldo);
		lblSaldo.setVisible(false);
		
		tfSaldo = new JTextField();
		tfSaldo.setBounds(115, 260, 174, 20);
		getContentPane().add(tfSaldo);
		tfSaldo.setColumns(10);
		tfSaldo.setVisible(false);
		
		btnAnyadir = new JButton("A\u00F1adir");
		btnAnyadir.setBounds(46, 338, 89, 23);
		getContentPane().add(btnAnyadir);
		btnAnyadir.setVisible(false);
		btnAnyadir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Clientes cliente=new Clientes(tfDNI.getText()+"",tfNombre.getText()+"",tfDireccion.getText()+"",Double.parseDouble(tfSaldo.getText()));
				try {
					FileOutputStream fs=new FileOutputStream(f);
					ObjectOutputStream os=new ObjectOutputStream(fs);
					os.writeObject(cliente);
					os.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(215, 338, 89, 23);
		getContentPane().add(btnBorrar);
		btnBorrar.setVisible(false);
		
		setVisible(true);
	}
	
	private void abrirExploradorFicheros() throws IOException {
		
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int opcion=fc.showOpenDialog(this);
		
		if(opcion==JFileChooser.APPROVE_OPTION) {
			f=new File(fc.getSelectedFile()+"");
			if(!f.exists()) {
				f.createNewFile();
				JOptionPane.showMessageDialog(this, "Fichero creado correctamente");
			}
			mostrarComponentes();
		}
	}
	
	private void mostrarComponentes() {
		tfDNI.setVisible(true);
		tfNombre.setVisible(true);
		tfDireccion.setVisible(true);
		tfSaldo.setVisible(true);
		lblDni.setVisible(true);
		lblNombre.setVisible(true);
		lblDireccion.setVisible(true);
		lblSaldo.setVisible(true);
		btnAnyadir.setVisible(true);
		btnBorrar.setVisible(true);
	}
}
