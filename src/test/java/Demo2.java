import java.sql.*;

public class Demo2 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName ="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);

            Statement statment= connection.createStatement();
            String query= " select * from employee";
            // Result set is like iterator thar contains the data from statement
            ResultSet resultSet= statment.executeQuery(query);
            //resultset.next will keep on returning true as long as there are rows in resulr set
            ResultSetMetaData resultInfo = resultSet.getMetaData();
           // 1 ile baslattik cunku Table in basinda bos bir sutun var o 0 oluyor
            for (int i = 1; i <= resultInfo.getColumnCount() ; i++)

            System.out.println();

            while (resultSet.next()){
                // ilk basta asagidakini yazdi sadece salary aldi.hepsini alacaksan bu hardcode olur.
                // o nedenle asagidaki for loopu yazdi
               // System.out.println(resultSet.getString("salary"));
                for (int i = 1; i <= resultInfo.getColumnCount() ; i++) {
                    System.out.print(resultSet.getString(i) + "   ");

                }
                System.out.println();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
