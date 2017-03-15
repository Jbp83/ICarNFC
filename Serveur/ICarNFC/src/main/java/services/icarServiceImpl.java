package services;

import java.sql.*;

/**
 * Created by Jb on 14/03/2017.
 */
public class icarServiceImpl {

    private static Connection connection;


    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/icarnfc";
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public String testPost( int userid){

        return "youpi : " + userid;
    }


    public String getInfos(String UserLogin,String UserPassword) {

        //Connection à la base de donnée avec la variable conn
        Connection  conn = getConnection();

        // On déclare les variables à utiliser
        Statement statement;
        ResultSet resultats;
        String Req;
        Req = "SELECT * FROM users WHERE login='"+UserLogin+"'AND password ='"+ UserPassword+ "' ;";

        try {
            statement =  conn.createStatement();
            resultats = statement.executeQuery(Req);

            if(resultats.next()) {


                return resultats.getString("status");
            }
            else
                {
                    return "fail";
                }
            }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
