import java.sql.*;

public class Demo1 {

    //In order to test your Database using
    //Selenium, you need to observe the
    //following steps
    //1. Create a connection to the Database
    //2. Create Statement
    //3. Execute Queries
    //4. Process Results
    //5. Close Connection

    //1. First we will add MySQL JDBC in our pom.xml
    //2. Now we need information about our DataBase:
    //HostName: 18.232.148.34
    //Port: 3306
    //DB Name: syntaxhrm_mysql
    //UserName: syntax_hrm
    //Password: syntaxhrm123
    //Connecting to MySQL
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName ="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //In order to make a connection to the database we need to use
            //getConnection() method of DriverManager
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
       // asagidaki satiri yazinca    com.mysql.cj.jdbc.ConnectionImpl@954b04f yazisi konsolda cikiyor.emin olmak icinmis
       // run etti sonra sildi asagidakini
            //System.out.println(connection.toString());

            //The createStatement() method of Connection interface is used to create
            //statement. The object of statement is responsible to execute queries with
            //the database.
            Statement statment= connection.createStatement();
            String query= " select * from person";
   // Result set is like iterator thar contains the data from statement
            //Once the statement object is created we can use executeQuery method to
            //execute the SQL queries
            ResultSet resultSet= statment.executeQuery(query);
      //resultset.next will keep on returning true as long as there are rows in resulr set

            while (resultSet.next()){
                String firstName =resultSet.getString("firstname");
                String lastName =resultSet.getString("lastname");
                String age =resultSet.getString("age");
                System.out.println(firstName+" "+lastName+" "+age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
