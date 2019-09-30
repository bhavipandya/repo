import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCConnection {
	
	public static void main(String[] args) throws SQLException {
		
		String host="localhost";
		String port="3306";
		
		//DriverManager.getConnection(url, user, password)
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+  ":" +port+ "/automationtesting?useSSL=false", "root", "aryan123");
		Statement s=  con.createStatement();
	    ResultSet rs= s.executeQuery("SELECT * FROM Credentials where UserNamw = 'AdminUser'");
	    while(rs.next()) {
	    	
	    
	    System.out.println(rs.getString("UserNamw"));
	    System.out.println(rs.getString("Password"));
		
	    	WebDriver driver= new ChromeDriver();

	    	driver.get("https://login.salesforce.com");

	    	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("UserNamw"));

	    	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("Password"));
	    	


		
	    }
		
		
	}

}
