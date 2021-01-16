package carparking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
public class conn {
	Connection c=null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:/home/sheetal/Desktop/employe");
			//JOptionPane.showMessageDialog("YES");
			return c;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
