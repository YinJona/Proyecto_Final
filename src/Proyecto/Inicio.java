package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;


public class Inicio {
	//atributos
	JFrame inicio = new JFrame();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel("");
	JLabel l2 = new JLabel("");
	JTextField t1 = new JTextField ();
	JPasswordField t2 = new JPasswordField ();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	Object [][] vendedores = new Object[400][6];
	
	
	public void frame() {
		inicio.setTitle("Login");
		inicio.setLocationRelativeTo(null);
		
		//                x   y  anch0-alto
		inicio.setBounds(600,200,350,350);
		inicio.setVisible(true);
		
		//color
		p1.setBackground(Color.black);
		p1.setBounds(600,200,350,350);
		p1.setLayout(null);
		inicio.add(p1);
		
	}
	
	
	public void etiquetas() {
		//etiquetas
		l1.setText("Usuario:");
		l1.setBounds(50,10,90,80);
		l1.setFont(new Font("Serig", Font.PLAIN, 15));
		l1.setForeground(Color.white);
		l1.setVisible(true);
		p1.add(l1);
		
		
		l2.setText("Contraseña:");
		l2.setFont(new Font("Serig", Font.PLAIN, 15));
		l2.setForeground(Color.white);
		l2.setBounds(50,110,110,80);
		l2.setVisible(true);
		p1.add(l2);
		
		
		
	}
	public void textfiel() {
	//textfield
			t1.setBounds(150,40,140,25);
			t2.setBounds(150,140,140,25);
			t1.setVisible(true);
			t2.setVisible(true);
			p1.add(t1);
			p1.add(t2);
	}
	
	public void botones () {
		
		//INGRESAR
		b1.setText("INGRESAR");
		b1.setBounds(55,230,100,40);
		p1.add(b1);
		
		// Funcionalidad
				ActionListener ingresar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						//carga archivo
						
						try {

							 ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_vendedores.dat"));

							 vendedores = (Object[][]) recuperar.readObject();
							recuperar.close();

							 } catch (IOException v) {
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
							JOptionPane.showMessageDialog(null, "Bienvenidos");
							inicio.setVisible(false);
							Menu_Principal mp = new Menu_Principal();
							try {
								try {
									mp.ejecutar();
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
						
						
						else {
							Boolean acceso = false;
							for (int i = 0; i < vendedores.length; i++) {
								if (t1.getText().equals(vendedores[i][1]) && t2.getText().equals(vendedores[i][5])) {
									acceso = true;
									break;
								}
							}
							if (acceso = true) {
								JOptionPane.showMessageDialog(null, "Bienvenidos");
								Ventas vm = new Ventas();
								inicio.setVisible(false);
								try {
									vm.ejecutar();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}else {
								JOptionPane.showMessageDialog(null, "Usuario Equivocado");
							}
							
							
							
							
						}

					}
				};

				// Acción del evento
				b1.addActionListener(ingresar);
				
				//SALIR
				b2.setText("SALIR");
				b2.setBounds(190,230,100,40);
				ActionListener funcion_b2 = new ActionListener() {

					 @Override
					 public void actionPerformed(ActionEvent e) {

						 System.exit(0);
					 
					 	}
					};

					 // Acción del evento
					b2.addActionListener(funcion_b2);
				p1.add(b2);
				
	}
	
	public void ejecutar() {
		frame();
		etiquetas();
		textfiel();
		botones();
		
	}
	
	public static void main(String[] args) {
		Inicio p1 = new Inicio();
		p1.ejecutar();
	}

}
