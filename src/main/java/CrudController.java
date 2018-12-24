package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.bean.UtenteBean;



@RestController
@RequestMapping("/operazionicrud")
public class CrudController {
    
    
    @GetMapping("/insert")
    /**
     * Operazione di insert
     * @param input
     */
    /**
     * Questa operazione effettua l'insert dell'elemento
     */
    public String insert(@RequestParam String nome, @RequestParam int eta) {
    	Connection conn = getConnection("", "", "");
		if(conn!=null){
    	try {
			PreparedStatement insert = conn.prepareStatement ("INSERT INTO Utenti VALUES (?, ?, ?);");
			insert.execute();
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// da gestire log
				e.printStackTrace();
			}
		}
		//Aggiungo nella lista il nuovo utente come esempio
		UtenteBean utente = new UtenteBean(nome,eta);
		utenti.add(utente);
    	return "Operazione di insert effettuata col parametro :"+nome;
    }

    @GetMapping("/select")
    /**
     * Operazione di insert
     */
    /**
     * Questa operazione effettua l'insert dell'elemento
     */
    public List<UtenteBean> select() {
    	Connection conn = getConnection("", "", "");
    	Statement stmt = null;
		if(conn!=null){
    	try {
			  String sql = "SELECT * FROM UTENTI....;";
			  stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		    	  //Leggo gli utenti
		      }
		      
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// da gestire log
				e.printStackTrace();
			}
		}
    	return utenti;
    }
    
    @GetMapping("/delete")
    /**
     * Operazione di delete
     * @param input
     */
    /**
     * Questa operazione effettua il delete dell'elemento
     */
    public String delete(@RequestParam long idUtente) {
    	Connection conn = getConnection("", "", "");
		if(conn!=null){
    	try {
			PreparedStatement deleteOp = conn.prepareStatement ("DELETE FROM Utenti WHERE id=?; ");
			deleteOp.executeUpdate();
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// da gestire log
				e.printStackTrace();
			}
		}
		
		//Cancello l'utente dalla lista se presente
		int j=-1;
		for(int i=0;i<utenti.size();i++){
			if(utenti.get(i).getId()==idUtente){
				j=i;
				break;
			}
		}
		if(j!=-1) utenti.remove(j);
    	return "Operazione di delete  effettuata col parametro :"+idUtente;
    }
    

    @GetMapping("/update")
    /**
     * Questa operazione effettua update
     */
    public void update(@RequestParam long idUtente, @RequestParam int eta) {
    	Connection conn = getConnection("", "", "");
		if(conn!=null){
    	try {
			PreparedStatement updateOp = conn.prepareStatement ("UPDATE UTENTU SET eta = ? WHERE id=?; ");
			updateOp.executeUpdate();
			if(conn!=null){
				conn.close();
			}
			} catch (SQLException e) {
				// da gestire log
				e.printStackTrace();
			}
		}

		for(int i=0;i<utenti.size();i++){
			if(utenti.get(i).getId()==idUtente){
				utenti.get(i).setEta(eta);
				break;
			}
		}
    }
    
    //-----------AGGIUNTI PER EFFETTUARE UN TEST-----------//
	
    /**
     * Create la connessione verso il datasource.
     * E' possibile farlo anche iniettando le cfg con spring
     * @param URL
     * @param username
     * @param pws
     * @return
     */
    private Connection getConnection(String URL, String username, String pws) {
    	Connection conn;
		try {
			conn = DriverManager.getConnection(URL, username, pws);
	    	return conn;
		} catch (SQLException e) {
			// eventuale log
			e.printStackTrace();
		}
    	return null;
    }

    static List<UtenteBean> utenti;
	
    static {
    	utenti = new ArrayList<UtenteBean>();
    	UtenteBean utente1 = new UtenteBean("Mario",22);
    	utenti.add(utente1);
    }
}
