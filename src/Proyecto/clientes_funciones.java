package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clientes_funciones {

	PreparedStatement ps;
	ResultSet su;
	Connection con;
	conexion acceso = new conexion();
	Clientes c = new Clientes();
	Object [][] listar;
	
	public void crear (String nombre, int NIT, String correo, String genero) {
		String sql = "insert into clientes(nombre, NIT, correo, genero) values (?,?,?,?)";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setInt(2, NIT);
			ps.setString(3, correo);
			ps.setString(4, genero);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public void modificar (int codigo_cliente, String nombre, int NIT, String correo, String genero) {
		String sql = "update clientes set  nombre = ?, NIT = ?, correo = ?, genero = ? where codigo_cliente = ?";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setInt(2, NIT);
			ps.setString(3, correo);
			ps.setString(4, genero);
			ps.setInt(5, codigo_cliente);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminar(int codigo_cliente) {
		String sql = "delete from clientes where codigo_cliente = ?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo_cliente);
			ps.executeUpdate();
		}catch (Exception e) {
		
		}
	}
	
public Object[][] listar() {
    	
    	String sql = "select * from clientes";  
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
            	listar[y][2] = su.getInt(3);
            	listar[y][3] = su.getString(4);
            	listar[y][4] = su.getString(5);
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
	
	//public static void main(String[]args) {
		//clientes_funciones cf = new clientes_funciones();
		//cf.eliminar(1);
				
	//}
}
