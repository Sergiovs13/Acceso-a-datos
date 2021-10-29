package ejerciciosFicherosObj;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class AgregarClientesFile extends JFrame{

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
				abrirExploradorFicheros();
			}
		});
		
		setVisible(true);
	}
	
	private void abrirExploradorFicheros() {
		File f=null;
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int opcion=fc.showOpenDialog(this);
		
		if(opcion==JFileChooser.APPROVE_OPTION) {
			
		}
	}
}
