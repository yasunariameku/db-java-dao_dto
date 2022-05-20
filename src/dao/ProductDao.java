package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	
	
	private Connection connection;

	public ProductDao(Connection connection) {
	    this.connection = connection;
	}
	
	//全件取得のメソッド
	
	private static final String SQL_SELECT_ALL = "SELECT product_id, product_name, price FROM products ORDER BY product_id";


	public List<Product> findAll() {
    	
    	List<Product> list = new ArrayList<Product>();
    	
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Product p = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
                list.add(p);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    
	}
    
    // 入力したidをもとに、レコードを取得する。

	private static final String SQL_SELECT_BY_PRODUCT_ID = "SELECT * FROM products WHERE product_id = ? ORDER BY product_id;";


    public Product findByProductId(Integer product_id) {
    	
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_PRODUCT_ID)) {
            stmt.setInt(1, product_id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    	
    	return null;
        
    }
    
  //テーブルに新しいデータを追加するメソッド。
	
  	private static final String SQL_INSERT = "INSERT INTO products(product_name, price) VALUES (?, ?)";


      public void register(Product product) {
      	
      	try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
              stmt.setString(1, product.getProduct_name());
              stmt.setInt(2, product.getPrice());
              
              stmt.executeUpdate();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      
    private static final String SQL_UPDATE = "UPDATE products SET product_name = ?, price = ? WHERE product_id = ?";
    
  
    	public void update(Product product) {
    		try(PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
    			stmt.setString(1, product.getProduct_name());
    			stmt.setInt(2, product.getPrice());
    			stmt.setInt(3, product.getProduct_id());
    			
    			stmt.executeUpdate();
    			
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    private static final String SQL_DELETE = "DELETE FROM products WHERE product_name = ?";
    
    
    	public void delete(String product_name) {
    		try(PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)){
    			stmt.setString(1, product_name);
    			
    			stmt.executeUpdate();
    			
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    
    
    
}
