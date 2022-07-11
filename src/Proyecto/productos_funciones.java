package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class productos_funciones {

	PreparedStatement ps;
	ResultSet su;
	Connection con;
	conexion acceso = new conexion();
	Producto p = new Producto();
	Object [][] listar;
	
	public void crear (String nombre, String descripcion, int cantidad, int precio) {
		String sql = "insert into productos(nombre, descripcion, cantidad, precio) values (?,?,?,?)";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setInt(3, cantidad);
			ps.setInt(4, precio);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public void modificar (int codigo_producto, String nombre, String descripcion, int cantidad, int precio) {
		String sql = "update productos set  nombre = ?, descripcion = ?, cantidad = ?, precio = ? where codigo_producto = ?";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setInt(3, cantidad);
			ps.setInt(4, precio);
			ps.setInt(5, codigo_producto);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void eliminar(int codigo_producto) {
		String sql = "delete from productos where codigo_producto = ?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo_producto);
			ps.executeUpdate();
		}catch (Exception e) {
		
		}
		
	}
	
	public Object[][] listar() {
    	
    	String sql = "select * from productos";  
    	int filas = 0;
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            su = ps.executeQuery();
            
            while (su.next()) {
            	filas++;
            	
            }
            System.out.println(filas);
            listar = new Object[filas][5];
            int y =0;
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            su = ps.executeQuery();
            while (su.next()) {
            	
            	listar[y][0] = su.getInt(1);
            	listar[y][1] = su.getString(2);
            	listar[y][2] = su.getString(3);
            	listar[y][3] = su.getInt(4);
            	listar[y][4] = su.getInt(5);
            	y++;
            	
            }
        } catch (Exception e) {        	
            System.out.println(e);
        }
		
        for (int i = 0; i < listar.length; i++) {
			System.out.println(listar[i][0]);
		}
    	
    	return listar;
	}
	
public Producto buscar_producto(int id, int cantidad) {
    	
    	String sql = "select * from productos"; 
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            su = ps.executeQuery();
            
            while (su.next()) {
            	if(id == su.getInt(1)) {            		
            		if(cantidad < su.getInt(4)) {
            			p.setCodigo(su.getInt(1));
                		p.setNombre(su.getString(2));            		
                		p.setCantidad(su.getInt(4));
                		p.setPrecio(su.getInt(5));
                		return p;
            		}else {
            			JOptionPane.showMessageDialog(null, "Cantidad solicitada mayor al inventario, se cuenta con:"+ su.getInt(4));
            			break;
            		}            		
            	}
            	
            }
            
        } catch (Exception e) {        	
            System.out.println(e);
        }
        return null;
    	
    	
    	
    }


	//public static void main(String[]args) {
		//productos_funciones pf = new productos_funciones();
		//pf.modificar(2,"Cortinas", "Tcortinas de casa", 100, 50);
				
	//}
	
}
