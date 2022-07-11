package Proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Ventas {

	JFrame venta = new JFrame();
	JTabbedPane Pestañas = new JTabbedPane();
	
	//Paneles para las pestañas 
	JPanel nueva_venta = new JPanel();
	JPanel ventas = new JPanel();
	
	cobrar crear = new cobrar();
	
	
	public void valores_iniciales() throws ClassNotFoundException {
		
				//frame
				venta.setTitle("MODULO VENDEDORES");
				venta.setLocationRelativeTo(null);
				// 				x 	y 	anch0-alto
				venta.setBounds(300,100,900,700);
				venta.setVisible(true);
				JButton cerrar = new JButton ("CERRAR SESION");
				cerrar.setBackground(Color.red);
				cerrar.setForeground(Color.white);
				cerrar.setBounds(735,3,150,20);
				
				ActionListener funcion_cerrar = new ActionListener() {

					 @Override
					 public void actionPerformed(ActionEvent e) {

						 Inicio log = new Inicio();
						 log.ejecutar();
						 venta.setVisible(false);
					 
					 	}
					};

					 // Acción del evento
					cerrar.addActionListener(funcion_cerrar);
					
				venta.add(cerrar);
				venta.add(Pestañas);
				
				
				//colores setLayout(null);
				nueva_venta.setBackground(Color.yellow);
				ventas.setBackground(Color.orange);
				
				nueva_venta.setLayout(null);
				ventas.setLayout(null);
				
				//agg paneles
				Pestañas.addTab("Nueva Venta", nueva_venta);
				Pestañas.addTab("Ventas", ventas);
				
				crear.ejecutar();
				nueva_venta.add(crear.filtro);
				nueva_venta.add(crear.ventas);
				
				
				
				
				
				
				
				
				
	}
	public void ejecutar () throws ClassNotFoundException {
		valores_iniciales();
		
		
	}
	
	
		public static void main(String[] args) throws ClassNotFoundException {
			
			Ventas menu = new Ventas();
			menu.valores_iniciales();
			
		}
}
