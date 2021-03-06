package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Status: complete.
 */
class TTB_database {
    static Connection connect() {
        System.out.println("-------Embedded  DB Connection Testing --------");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(" DB Driver not found. Add the classpath to your module.");
            System.out.println("For IntelliJ do the following:");
            System.out.println("File | Project Structure, Modules, Dependency tab");
            System.out.println("Add by clicking on the green plus icon on the right of the window");
            System.out.println("Select JARs or directories. Go to the folder where the  JDK is installed");
            System.out.println("Select the folder java/jdk1.8.xxx/db/lib where xxx is the version.");
            System.out.println(" Click OK, compile the code and run it.");
            e.printStackTrace();
            return null;
        }
        System.out.println(" DB driver registered!");
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:derby:StandaloneDB/DB;create=true");
            //connection = DriverManager.getConnection("jdbc:derby:appDB;create=true");
            System.out.println(System.getProperty("user.dir"));
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
            return null;
        }
    }
}
