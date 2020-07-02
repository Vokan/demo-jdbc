/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



/**
 * @author vokankocak
 *
 */
public class TestInsertion {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// On recupert les données dans le database.properties.
		ResourceBundle FichierConf = ResourceBundle.getBundle("database");
		
		// On enregistre le driver.
		 Class.forName(FichierConf.getString("database.driver"));
		 
		// On crée la connection.
		 String url = FichierConf.getString("database.url");
		 String utilisateur = FichierConf.getString("database.user");
		 String motDePasse =  FichierConf.getString("database.pass");
		 Connection uneConnexion = null;
	        Statement statement = null;
	        try {
	        	 uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse);
	        	
	        	// Etape 3 - Créer un statement pour envoyer des requetes sql a la base
	            statement = uneConnexion.createStatement();

	            // Inserer une ligne 
	            int nvFournisseur = statement.executeUpdate("insert into FOURNISSEUR(ID, NOM) values(4, 'La Maison de la Peinture')");
	            System.out.println(nvFournisseur);
	         
	        } finally {
	        	statement.close();
	            uneConnexion.close();
	            }
		 
		
		
			
		

	}

}
