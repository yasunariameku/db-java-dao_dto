package main;

import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		
		//登録する
      
    	//データベースと接続する
 
    	//インスタンス生成
    	Product p = new Product(null, "ボールペン", 200);
    	//registerメソッドを使う。
    	new ProductDao(DbUtil.getConnection()).register(p);
    	
    
        
        //テーブルから全件取得する。
        
       
    	//データベースと接続する
		//インスタンスを作る
		List<Product> list = new ProductDao(DbUtil.getConnection()).findAll();
    	
    	//テーブルから全件取得する。findメソッドを使う。
    	
    	
    	for (Product i : list) {
    		System.out.println("product_id:" + i.getProduct_id() + ", " + "Product_name:" + i.getProduct_name() + ", " + "price:" + i.getPrice() );
    	}
        	
	}

}
