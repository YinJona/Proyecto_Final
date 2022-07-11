package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class vendedores_funciones {

	PreparedStatement ps;
	ResultSet su;
	Connection con;
	conexion acceso = new conexion();
	vendedor p = new vendedor();
	Object [][] listar;
	
	public void crear (String nombre, int caja, int ventas, String genero, String password) {
		String sql = "insert into vendedores(nombre, caja, ventas, genero, password) values (?,?,?,?,?)";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setInt(2, caja);
			ps.setInt(3, ventas);
			ps.setString(4, genero);
			ps.setString(5, password);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public void modificar (int codigo_vendedor, String nombre, int caja, int ventas, String genero, String password) {
		String sql = "update vendedores set  nombre = ?, caja = ?, ventas = ?, genero = ?, password = ? where codigo_vendedor = ?";
		
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setInt(2, caja);
			ps.setInt(3, ventas);
			ps.setString(4, genero);
			ps.setString(5, password);
			ps.setInt(6, codigo_vendedor);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminar(int codigo_vendedor) {
		String sql = "delete from vendedores where codigo_vendedor = ?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, codigo_vendedor);
			ps.executeUpdate();
		}catch (Exception e) {
		
		}
	}
	
public Object[][] listar() {
    	
    	String sql = "select * from vendedores";  
    	int filas = 0;
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            su = ps.executeQuery();
            
            while (su.next()) {
            	filas++;
            	
            }
            System.out.println(filas);
            listar = new Object[filas][6];
            int y =0;
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            su = ps.executeQuery();
            while (su.next()) {
            	
            	listar[y][0] = su.getInt(1);
            	listar[y][1] = su.getString(2);
            	listar[y][2] = su.getInt(3);
            	listar[y][3] = su.getInt(4);
            	listar[y][4] = su.getString(5);
            	listar[y][5] = su.getString(6);
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
	//vendedores_funciones vf = new vendedores_funciones();
	//vf.modificar(1,"Maria", 278, 233, "f", "GHAJSHSH676777999");
			
	//}
}
