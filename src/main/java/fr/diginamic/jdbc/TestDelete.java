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
public class TestDelete {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
        ResourceBundle FichierConf = ResourceBundle.getBundle("database");
        
   
        Class.forName(FichierConf.getString("database.driver"));
        

        String url = FichierConf.getString("database.url"); 
        String utilisateur = FichierConf.getString("database.user");
        String motDePasse =  FichierConf.getString("database.pass");
        Connection uneConnexion = null;
        Statement statement = null;

        try {
        	 uneConnexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        	
        	
            statement = uneConnexion.createStatement();

         
            int nbLignesImpactees = statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4");
            System.out.println(nbLignesImpactees);
         
        } finally {
            statement.close();
            uneConnexion.close();
        }

	}

}
