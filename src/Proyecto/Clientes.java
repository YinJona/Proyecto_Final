package Proyecto;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;

import javax.swing.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Clientes implements Serializable{
	
	//BOTONES
		JButton crear = new JButton();
		JButton cargar = new JButton();
		JButton actualizar = new JButton();
		JButton eliminar = new JButton();
		JButton PDF = new JButton();
		
		
		//MATRIZ
		
		Object [] [] clientes;
		
		
		
		//TABLA-COMPLEMETO
		JTable tabla;
		JScrollPane CP;
		
		
		private void botones () {
			
			crear.setText("Crear");
			crear.setBounds(550,100,130,70);
			
			//Funcion crear
			
					ActionListener funcion_crear = new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {

				 crear();
			 
			 	}
			};

			 // Acción del evento
			crear.addActionListener(funcion_crear);
			
			//carga masiva
			cargar.setText("Carga_Masiva");
			cargar.setBounds(730,100,130,70);
			
			ActionListener funcion_carga = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						carga_masiva();
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			};

			//Acción del evento
			cargar.addActionListener(funcion_carga);
		

	 
			
			actualizar.setText("Actualizar");
			actualizar.setBounds(550,260,130,70);
			
			ActionListener funcion_actualizar = new ActionListener() {

				 @Override
				 public void actionPerformed(ActionEvent e) {

					 actualizar();
				 
				 	}
				};

				 // Acción del evento
				actualizar.addActionListener(funcion_actualizar);
			
			eliminar.setText("Eliminar");
			eliminar.setBounds(730,260,130,70);
			
			ActionListener funcion_eliminar = new ActionListener() {

				 @Override
				 public void actionPerformed(ActionEvent e) {

					 eliminar();
				 
				 	}
				};

				 // Acción del evento
				eliminar.addActionListener(funcion_eliminar);
			
			PDF.setText("Exportar_PDF");
			PDF.setBounds(550,420,310,70);
			
			ActionListener funcion_Exportar_PDF = new ActionListener() {

				 @Override
				 public void actionPerformed(ActionEvent e) {

					 try {
						pdf();
					} catch (FileNotFoundException | DocumentException e1) {
						e1.printStackTrace();
					}
				 
				 	}
				};

				 // Acción del evento
				PDF.addActionListener(funcion_Exportar_PDF);
			
			
		}

		private void tabla() throws ClassNotFoundException {
			
			String []datos = {"Codigo", "Nombre", "NIT", "Correo", "Genero"};
			clientes_funciones cf = new clientes_funciones();
			clientes = cf.listar();
			tabla = new JTable(clientes,datos);		
			CP = new JScrollPane(tabla);
			CP.setBounds(10,10,500,590);
			
		}
		
		private void crear() {
			
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
			p1.setBackground(Color.orange);
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
		
		//leer archivo
		private String leerarchivo() {

			 JPanel c1 = new JPanel();
			JFileChooser fc = new JFileChooser();
				int op = fc.showOpenDialog(c1);
			String content = "";
				if (op == JFileChooser.APPROVE_OPTION) {

			 File pRuta = fc.getSelectedFile();
			String ruta = pRuta.getAbsolutePath();
			File archivo = null;
			FileReader fr = null;
			BufferedReader br = null;

			 try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = "";

			 while ((linea = br.readLine()) != null) {

			 content += linea + "\n";
			}
			return content;

			 } catch (FileNotFoundException ex) {
			String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
			} catch (IOException ex) {
			String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
			} finally {
			try {
			if (null != fr) {
			fr.close();
			}
			} catch (Exception e2) {
			String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
			
			
								return "";
									}

			 				}
			 			return content;

					}
				return null;
			}
		
		private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
			
			String archivo_retorno = leerarchivo();

			JsonParser parse = new JsonParser();
			JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();
			
			for (int i = 0; i < matriz.size(); i++) {
				JsonObject objeto = matriz.get(i).getAsJsonObject();
				clientes_funciones cf = new clientes_funciones();
				cf.crear(objeto.get("nombre").getAsString(),objeto.get("NIT").getAsInt(), objeto.get("correo").getAsString(),objeto.get("genero").getAsString());
			}
			}
		
		private void eliminar () {
			int posicion = tabla.getSelectedRow();
			
			if (posicion != -1) {
				
				clientes_funciones cf = new clientes_funciones();
				cf.eliminar(Integer.parseInt(clientes[posicion][0]+""));
				
				
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
			}
			
			tabla.clearSelection();
		}
		
		private void actualizar () {
			
			int seleccionar = tabla.getSelectedRow();
			if (seleccionar != -1) {
				
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
				
				
				crear.setTitle("Actualizar");
				crear.setLocationRelativeTo(null);
				crear.setBounds(500,100,500,700);
				crear.setVisible(true);
				p1.setBackground(Color.orange);
				crear.add(p1);
				
				t1.setBounds(250,40,200,40);
				t2.setBounds(250,120,200,40);
				t3.setBounds(250,210,200,40);
				t4.setBounds(250,300,200,40);
				t5.setBounds(250,390,200,40);
				
				t1.setText(clientes[seleccionar][0]+"");
				t2.setText(clientes[seleccionar][1].toString());
				t3.setText(clientes[seleccionar][2]+"");
				t4.setText(clientes[seleccionar][3].toString());
				t5.setText(clientes[seleccionar][4].toString());
				
				
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
								cf.modificar(Integer.parseInt (t1.getText()), t2.getText(), Integer.parseInt (t3.getText()), t4.getText(), t5.getText());
								
										
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
				
				
				
			}else{
				
				JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
				
			}
			
		}
		
		private void pdf() throws FileNotFoundException, DocumentException {

			 FileOutputStream gen = new FileOutputStream("Clientes.pdf");
			Document documento = new Document();

			 PdfWriter.getInstance(documento, gen);
			documento.open();

			 Paragraph parrafo = new Paragraph("Clientes");
			parrafo.setAlignment(1);
			documento.add(parrafo);
			documento.add(new Paragraph("\n"));

			 for (int i = 0; i < clientes.length; i++) {

			 if (clientes[i][0] == null) {
			break;
			} else {
			documento.add(new Paragraph("Código: " + clientes[i][0] + " " + "Nombre: " + clientes[i][1] + " "
			+ "NIT: " + clientes[i][2] + " " + "Correo: " + clientes[i][3] + " " + "Genero: "
			+ clientes[i][4]));
			documento.add(new Paragraph("\n\n"));
			}

			 }
			documento.close();
			JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
			try {
			File sucursales_doc = new File("Clientes.pdf");
			Desktop.getDesktop().open(sucursales_doc);
			} catch (Exception e) {
			}
			}
		
		public void ejecutar () throws ClassNotFoundException {
			botones();
			tabla();
		}

}
