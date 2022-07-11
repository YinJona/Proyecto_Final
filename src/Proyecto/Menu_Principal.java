package Proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu_Principal {

	JFrame principal = new JFrame();
	JTabbedPane Pestañas = new JTabbedPane();
	
	//Paneles para las pestañas 
	JPanel sucursales = new JPanel();
	JPanel clientes = new JPanel();
	JPanel vendedores = new JPanel();
	JPanel productos = new JPanel();
	
	Sucursales SM = new Sucursales();
	Productos PM = new Productos();
	Vendedores VM = new Vendedores();
	Clientes CM = new Clientes();
	
	public void valores_iniciales() throws ClassNotFoundException{
		
		//frame
		principal.setTitle("MODULO ADMINISTRADOR");
		principal.setLocationRelativeTo(null);
		// x y ancho-alto
		principal.setBounds(300,100,900,700);
		principal.setVisible(true);
		JButton cerrar = new JButton ("CERRAR SESION");
		cerrar.setBackground(Color.red);
		cerrar.setForeground(Color.white);
		cerrar.setBounds(735,3,150,20);
		
		ActionListener funcion_cerrar = new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {

				 Inicio log = new Inicio();
				 log.ejecutar();
				 principal.setVisible(false);
			 
			 	}
			};

			 // Acción del evento
			cerrar.addActionListener(funcion_cerrar);
			
		principal.add(cerrar);
		principal.add(Pestañas);
		
		
		
		
		//colores setLayout(null);
		sucursales.setBackground(Color.GREEN);
		clientes.setBackground(Color.orange);
		vendedores.setBackground(Color.GRAY);
		productos.setBackground(Color.cyan);
		
		sucursales.setLayout(null);
		clientes.setLayout(null);
		vendedores.setLayout(null);
		productos.setLayout(null);
		
		
		
		//agg paneles
		Pestañas.addTab("Sucursales", sucursales);
		Pestañas.addTab("Clientes", clientes);
		Pestañas.addTab("Vendedores", vendedores);
		try {
			Pestañas.addTab("Productos", productos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//sucursales
		SM.ejecutar();
		sucursales.add(SM.crear);
		sucursales.add(SM.cargar);
		sucursales.add(SM.actualizar);
		sucursales.add(SM.eliminar);
		sucursales.add(SM.PDF);
		sucursales.add(SM.SP);
		
		//productos
		PM.ejecutar();
		productos.add(PM.crear);
		productos.add(PM.cargar);
		productos.add(PM.actualizar);
		productos.add(PM.eliminar);
		productos.add(PM.PDF);
		productos.add(PM.PP);
		
		//vendedores
		VM.ejecutar();
		vendedores.add(VM.crear);
		vendedores.add(VM.cargar);
		vendedores.add(VM.actualizar);
		vendedores.add(VM.eliminar);
		vendedores.add(VM.PDF);
		vendedores.add(VM.VP);
		
		
		//clientes
		CM.ejecutar();
		clientes.add(CM.crear);
		clientes.add(CM.cargar);
		clientes.add(CM.actualizar);
		clientes.add(CM.eliminar);
		clientes.add(CM.PDF);
		clientes.add(CM.CP);
	}
	
	public void ejecutar () throws ClassNotFoundException {
		valores_iniciales();
		
		
	}
	
	
		//public static void main(String[] args) throws ClassNotFoundException {
			
			//Menu_Principal menu = new Menu_Principal();
			//menu.valores_iniciales();
			
		//}
}
