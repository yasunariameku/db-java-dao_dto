import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Delete {
	public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // confirm
            System.out.println(" --- before connection --- ");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

            // confirm
            System.out.println(" --- after connection --- ");

            // SQL query string
            String sql = "DELETE FROM products WHERE product_name = 'ボールペン'";

            // create statement
            stmt = con.prepareStatement(sql);

            // execute
            stmt.executeUpdate();
            
            System.out.println("削除しました。");

            // output
            //while (rs.next()) {
            //    int product_id = rs.getInt("product_id");
            //    String name = rs.getString("product_name");
            //    int price = rs.getInt("price");

              //  System.out.println("product_id:" + product_id + ", name:" + name + ", price:" + price );
                //System.out.println(name);
                //System.out.println(price);
            //}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
