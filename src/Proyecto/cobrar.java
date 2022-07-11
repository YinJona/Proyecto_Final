package Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class cobrar {
	
	JPanel filtro = new JPanel();
	JPanel ventas = new JPanel();
	String [] resultados = new String[100];
	JComboBox combo_filtro = new JComboBox(resultados);
	Object [][]clientes;
	JTable tabla_compras;
	JScrollPane sp;
	
	
	//aplicar filtro
	JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
	
    //tabla
    Object [][]agregar_productos = new Object [10][5];
    int aumento = 0;
    
    
	
	private void crear () {
		
		filtro.setLayout(null);
		filtro.setBackground(Color.white);
		filtro.setBounds(20,30,830,225);
		ventas.setLayout(null);
		ventas.setBackground(Color.white);
		ventas.setBounds(20,300,830,280);
		
	}
	
	private void botones() throws ClassNotFoundException {
		
		// cargar archivo
				try {

					ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_clientes.dat"));

					clientes = (Object[][]) recuperar.readObject();
					recuperar.close();

				}

				catch (IOException e) {
				}
		
		
		
		//Etiquetas
		
        JLabel filtros = new JLabel("Filtrar por: ");
        filtros.setLocation(50, 30);
        filtros.setSize(100, 15);
        filtros.setFont(new Font("Serig", Font.PLAIN, 15));
        
        JLabel otro = new JLabel("Filtrados: ");
        otro.setLocation(50, 170);
        otro.setSize(100, 15);
        otro.setFont(new Font("Serig", Font.PLAIN, 15));
        filtro.add(otro);
        
        //Subrayado
        
        Font font = filtros.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        filtros.setFont(font.deriveFont(attributes));
        
        filtro.add(filtros);
        
        //label
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(180, 30, 100, 15);
        filtro.add(nombre);
		
        JLabel correo = new JLabel("Correo: ");
        correo.setBounds(180, 75, 100, 15);
        filtro.add(correo);
        
        JLabel nit = new JLabel("NIT: ");
        nit.setBounds(500, 30, 100, 15);
        filtro.add(nit);
		
        JLabel genero = new JLabel("Genero: ");
        genero.setBounds(500, 75, 100, 15);
        filtro.add(genero);
        
        JLabel cliente = new JLabel("Cliente: ");
        cliente.setBounds(180, 170, 100, 15);
        filtro.add(cliente);
	
        
        //textos
        
        
        t1.setBounds(250, 20, 230, 35);
        filtro.add(t1);
        
		
		t2.setBounds(250, 65, 230, 35);
        filtro.add(t2);
        

        t3.setBounds(570, 20, 230, 35);
        filtro.add(t3);
        
		
		t4.setBounds(570, 65, 230, 35);
        filtro.add(t4);
        
        //conbobox
        
        combo_filtro.setBounds(250, 165, 285, 35);
        filtro.add(combo_filtro);
        
        
        //botones
        
        JButton b1 = new JButton();
        b1.setText("APLICAR FILTRO");
        b1.setBounds(250, 120, 550, 30);
        filtro.add(b1);
        
        ActionListener funcion_filtro = new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent e) {

 				try {
					aplicar_filtro();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

 			}
 		};

 		// Acción del evento
 		b1.addActionListener(funcion_filtro);
        
        
        JButton b2 = new JButton();
        b2.setText("NUEVO CLIENTE");
        b2.setBounds(570, 165, 230, 30);
        filtro.add(b2);
        
     // Funcion crear
     		ActionListener funcion_crear = new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent e) {

     				try {
     					crear_cliente();
     				} catch (ClassNotFoundException e1) {
     					// TODO Auto-generated catch block
     					e1.printStackTrace();
     				}

     			}
     		};

     		// Acción del evento
     		b2.addActionListener(funcion_crear);
            
        
        
        
        //label2
        
      //label
        JLabel codigo = new JLabel("Codigo: ");
        codigo.setBounds(85, 70, 100, 15);
        ventas.add(codigo);
        
        JLabel cantidad = new JLabel("Cantidad: ");
        cantidad.setBounds(400, 70, 100, 15);
        ventas.add(cantidad);
        
        
        JLabel no = new JLabel("NO.");
        no.setBounds(700, 20, 100, 15);
        ventas.add(no);
		
        JLabel fecha = new JLabel("Fecha: ");
        fecha.setBounds(450, 20, 100, 15);
        ventas.add(fecha);
        
        JLabel total = new JLabel("Total: ");
        total.setBounds(590, 240, 100, 15);
        ventas.add(total);
        
        JTextField tot = new JTextField();
		tot.setBounds(630, 230, 140, 25);
		ventas.add(tot);
        
        
        
        
        JTextField t1_codigo = new JTextField();
		t1_codigo.setBounds(150, 60, 230, 35);
		ventas.add(t1_codigo);
		
		JTextField t2_cantidad = new JTextField();
		t2_cantidad.setBounds(470, 60, 230, 35);
		ventas.add(t2_cantidad);
        
		
		JButton agregar = new JButton("Agregar");
		agregar.setBounds(720, 60, 80, 35);
		ventas.add(agregar);
		
		ActionListener funcion_comprar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				productos_funciones pf = new productos_funciones();
				Producto x = new Producto();
				x = pf.buscar_producto(Integer.parseInt(t1_codigo.getText()), Integer.parseInt(t2_cantidad.getText()));
				
				if(x == null) {
					JOptionPane.showMessageDialog(null, "Ingresa nuevamente");
        			
				}else {		
				agregar_productos[aumento][0]= x.getCodigo();
				agregar_productos[aumento][1] = x.getNombre();
				agregar_productos[aumento][2]= Integer.parseInt(t2_cantidad.getText());
				agregar_productos[aumento][3] = x.getPrecio();
				agregar_productos[aumento][4] = (Integer.parseInt(t2_cantidad.getText())*x.getPrecio());
				aumento++;
				sp.setVisible(false);
				tabla();
				}

			}
		};

		// Acción del evento
		agregar.addActionListener(funcion_comprar);
        
	}
	
	private void tabla() {
		 String []datos = {"Codigo", "Nombre", "Cantidad", "Precio", "Subtotal"};
			
			tabla_compras = new JTable(agregar_productos,datos);		
			sp = new JScrollPane(tabla_compras);
			sp.setBounds(85,120,700,100);
			ventas.add(sp);
	}
	
	private void crear_cliente() throws ClassNotFoundException {
		// cargar archivo
				try {

					ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("tabla_clientes.dat"));

					clientes = (Object[][]) recuperar.readObject();
					recuperar.close();

				}

				catch (IOException e) {
				}
		
		JFrame crear = new JFrame();
		JPanel p1 = new JPanel();
		
		//etiquetas
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		p1.setLayout(null);
		//textos
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		
		//boton
		JButton b1 = new JButton();
		
		l1.setText("Codigo:");
		l1.setBounds(50,25,90,80);
		l1.setFont(new Font("Serig", Font.PLAIN, 15));
		l1.setVisible(true);
		p1.add(l1);
		
		l2.setText("Nombre:");
		l2.setBounds(50,105,180,80);
		l2.setFont(new Font("Serig", Font.PLAIN, 15));
		l2.setVisible(true);
		p1.add(l2);
		
		l3.setText("NIT:");
		l3.setBounds(50,195,180,80);
		l3.setFont(new Font("Serig", Font.PLAIN, 15));
		l3.setVisible(true);
		p1.add(l3);
		
		l4.setText("Correo:");
		l4.setBounds(50,285,100,80);
		l4.setFont(new Font("Serig", Font.PLAIN, 15));
		l4.setVisible(true);
		p1.add(l4);
		
		l5.setText("Genero:");
		l5.setBounds(50,375,90,80);
		l5.setFont(new Font("Serig", Font.PLAIN, 15));
		l5.setVisible(true);
		p1.add(l5);
		
		
		crear.setTitle("Crear");
		crear.setLocationRelativeTo(null);
		crear.setBounds(500,100,500,700);
		crear.setVisible(true);
		p1.setBackground(Color.yellow);
		crear.add(p1);
		
		t1.setBounds(250,40,200,40);
		t2.setBounds(250,120,200,40);
		t3.setBounds(250,210,200,40);
		t4.setBounds(250,300,200,40);
		t5.setBounds(250,390,200,40);
		
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		
		
		b1.setText("GUARDAR");
		b1.setBounds(175,530,150,60);
		p1.add(b1);
		
		// Funcionalidad
				ActionListener ingresar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						clientes_funciones cf = new clientes_funciones();
						cf.crear(t2.getText(),Integer.parseInt (t3.getText()), t4.getText(), t5.getText());
								
								//guardar datos
								try {
									
									ObjectOutputStream tabla = new ObjectOutputStream(new FileOutputStream("tabla_clientes.dat"));
									tabla.writeObject(clientes);
									tabla.close();
									
										} catch (IOException m) {
											
									}
								
								crear.setVisible(false);
								
								
							
					}
				};

				// Acción del evento
				b1.addActionListener(ingresar);
		
	}
	
	private void aplicar_filtro () throws ClassNotFoundException {
		int x = 0;
		clientes_funciones cf = new clientes_funciones();
		clientes = cf.listar();
		
		if(t1.getText().isEmpty() != false) {
			if(t2.getText().isEmpty() != false) {
				if(t3.getText().isEmpty() != false) {
					if(t4.getText().isEmpty() != false) {
						JOptionPane.showInputDialog(null, "INGRESE UN FILTRO");
					}else {
					//genero
						x = 4;
					}
				}else {
				//nit
					x = 3;
				}
			}else {
			//correo
				x = 2;
			}
		}else {
			//aplicamos filtro de nombre
			x = 1;
		}
		
		switch (x) {
		case 1:
			filtro_nombre(t1.getText());
			break;
		case 2:
			correo_filtro(t2.getText());
			break;
		case 3:
			nit_filtro(Integer.parseInt(t3.getText()));
			break;
		case 4:
			genero_filtro(t4.getText());
			break;

		default:
			break;
		}
	}
	
	private void filtro_nombre(String nombre) throws ClassNotFoundException {
		vaciar();
		
		
		
		
		boolean respuesta = false;
		int contador = 0;
		for (int i = 0; i < clientes.length; i++) {
			if(nombre.equals(clientes[i][1])) {
				//aplicar filtr0
				resultados[contador]= nombre;
				contador++;
				respuesta = true;
			}
		}
		if(respuesta == true) {
			combo_filtro.setVisible(false);
			combo_filtro = new JComboBox(resultados);
			combo_filtro.setBounds(250, 165, 285, 35);
	        filtro.add(combo_filtro);
		}else {
				if (t2.getText().isEmpty() != false) {
					if (t3.getText().isEmpty() != false) {
						if (t4.getText().isEmpty() != false) {
							JOptionPane.showMessageDialog(null, "Por favor llena un filtro");

						}else {
							//aplicamos filtro de Genero
							genero_filtro(t4.getText());
						}
					}else {
						//aplicamos filtro de NIT
						nit_filtro(Integer.parseInt(t3.getText()));
					}
				}else {
					//aplicamos filtro de correo
					correo_filtro(t2.getText());
				}

			}

        
        
	}
	
	private void correo_filtro(String correo) throws ClassNotFoundException {
		vaciar();
		
		boolean respuesta = false;
		int contador =0;
		for (int i = 0; i < clientes.length; i++) {
			if(correo.equals(clientes[i][3])) {
				//aplica filtro
				resultados[contador] = clientes[i][1]+"";
				contador++;				
				respuesta = true;
			}
		}

		if(respuesta == true) {
			combo_filtro.setVisible(false);
			combo_filtro = new JComboBox(resultados);
			combo_filtro.setBounds(250, 165, 285, 35);
	        filtro.add(combo_filtro);
		}else {

					if (t3.getText().isEmpty() != false) {
						if (t4.getText().isEmpty() != false) {
							JOptionPane.showMessageDialog(null, "Por favor llena un filtro");

						}else {
							//aplicamos filtro de Genero
							genero_filtro(t4.getText());
						}
					}else {
						//aplicamos filtro de NIT
						nit_filtro(Integer.parseInt(t3.getText()));
					}

			}
	}

	private void nit_filtro(int nit) throws ClassNotFoundException {
		vaciar();

		
				boolean respuesta = false;
				int contador =0;
				for (int i = 0; i < clientes.length; i++) {

					if((nit+"").equals(clientes[i][2]+"")) {
						//aplica filtro
						resultados[contador] = clientes[i][1]+"";
						contador++;				
						respuesta = true;
					}
				}

				if(respuesta == true) {
					combo_filtro.setVisible(false);
					combo_filtro = new JComboBox(resultados);
					combo_filtro.setBounds(250, 165, 285, 35);
			        filtro.add(combo_filtro);
				}else {


								if (t4.getText().isEmpty() != false) {
									JOptionPane.showMessageDialog(null, "Datos no encontrados");

								}else {
									//aplicamos filtro de Genero
									genero_filtro(t4.getText());
								}


					}

	}

	private void genero_filtro(String genero) throws ClassNotFoundException {
		vaciar();
		
				boolean respuesta = false;
				int contador =0;
				for (int i = 0; i < clientes.length; i++) {
					if(genero.equals(clientes[i][4])) {
						//aplica filtro
						resultados[contador] = clientes[i][1]+"";
						contador++;				
						respuesta = true;
					}
				}

				if(respuesta == true) {
					combo_filtro.setVisible(false);
					combo_filtro = new JComboBox(resultados);
					combo_filtro.setBounds(250, 165, 285, 35);
			        filtro.add(combo_filtro);
				}else {
					JOptionPane.showMessageDialog(null, "Datos no encontrados");
				}
	}
	
	
	
	private void vaciar() {
		for (int i = 0; i < resultados.length; i++) {
			resultados[i]="";
		}
	}
	
	
	public void ejecutar() throws ClassNotFoundException {
		crear();
		botones();
		tabla();
	}
	
	
	
}
