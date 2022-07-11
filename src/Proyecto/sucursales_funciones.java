package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class sucursales_funciones {
	
	PreparedStatement ps;
	ResultSet su;
	Connection con;
	conexion acceso = new conexion();
	sucursal s = new sucursal();
	Object [][] listar;
	
	public void crear (String nombre, String direccion, String correo, int telefono) {
		String sql = "insert into sucursales(nombre, direccion, correo, telefono) values (?,?,?,?)";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, direccion);
			ps.setString(3, correo);
			ps.setInt(4, telefono);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public void modificar (sucursal s) {
		String sql = "update sucursales set  nombre = ?, direccion = ?, correo = ?, telefono = ? where codigo_sucursal = ?";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, s.getNombre());
			ps.setString(2, s.getDireccion());
			ps.setString(3, s.getCorreo());
			ps.setInt(4, s.getTelefono());
			ps.setInt(5, s.getCodigo());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminar(int codigo_sucursal) {
		String sql = "delete from sucursales where codigo_sucursal = ?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo_sucursal);
			ps.executeUpdate();
		}catch (Exception e) {
		
		}
		
	}
	
	public Object[][] listar() {
    	
    	String sql = "select * from sucursales";  
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
            	listar[y][3] = su.getString(4);
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
	//public static void main(String[]args) {
		//sucursales_funciones sf = new sucursales_funciones();
		
				
	//}
}
