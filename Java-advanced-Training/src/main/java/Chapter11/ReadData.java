package Chapter11;

import java.sql.*;

/**
 * @author: Dieps
 * Project : Java-advanced-Training
 * DAte:2026/10/15
 **/

public class ReadData {
    public static void main(String[] args) {
        String connectionString="jdbc:sqlserver://ILAB07\\SQLEXPRESS;database=NorthWind;encrypt=true";

        try {
            //create connection object
            Connection objConnection = DriverManager.getConnection(connectionString);
            //open the connection
            Statement stm =objConnection.createStatement();
            String cmdselect="select * from Employees";

            ResultSet result= stm.executeQuery(cmdselect);

            while(result.next()){
                System.out.println(result.getInt(1)+" - "+result.getString(3));
            }
            objConnection.close();




        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
