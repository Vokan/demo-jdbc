/**
 * 
 */
package fr.diginamic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author vokankocak
 *
 */
public class TestConnexionJdbc {

	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		 ResourceBundle FichierConf = ResourceBundle.getBundle("database");
		 
		 Class.forName(FichierConf.getString("database.driver"));
		 String url = FichierConf.getString("database.url");
		 String utilisateur = FichierConf.getString("database.user");
		 String motDePasse =  FichierConf.getString("database.pass");
		 
		 Connection uneConnexion = DriverManager.getConnection(url, utilisateur , motDePasse);
		
		 System.out.println("la connection: "+uneConnexion);
		 
		 uneConnexion.close();
		 }
	}


