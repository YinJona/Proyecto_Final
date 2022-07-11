package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
	
	Connection con;
	String url = "jdbc:mysql://localhost:3306/sistema_de_ventas";
	String user = "root";
	String pass = "";
	
	public Connection Conectar(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("conexion exitosa");
		}catch (Exception e) {
			System.out.println("fallo en la conexion");
		}
		return con;
	}

	//public static void main(String[]args) {
		//conexion c = new conexion();
		//System.out.println(c.Conectar());
	//}
}
