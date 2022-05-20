package main;

import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		
		//登録する
      
    	//データベースと接続する
 
    	//Productクラスのインスタンス生成
    	Product p = new Product(null, "ボールペン", 200);
    	//ProductDaoクラスのインスタンスを作成して、そのインスタンスのregisterメソッドを使う。
    	new ProductDao(DbUtil.getConnection()).register(p);
    	
    
        
        //テーブルから全件取得する。
        
       
    	//データベースと接続する
		//ProductDaoクラスのインスタンスを作る
    	//→作ったインスタンスをリストに入れる
    	//→テーブルから全件取得するfindメソッドを使う。
		List<Product> list = new ProductDao(DbUtil.getConnection()).findAll();
    	
    	//拡張for文でとってきた値を出力
    	for (Product i : list) {
    		System.out.println("product_id:" + i.getProduct_id() + ", " + "Product_name:" + i.getProduct_name() + ", " + "price:" + i.getPrice() );
    	}
        	
	}

}
