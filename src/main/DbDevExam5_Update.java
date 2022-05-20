package main;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Update {
	public static void main(String[] args) {
		
		//Daoインスタンス化
		ProductDao dao = new ProductDao(DbUtil.getConnection());
		
		// 更新するデータの用意 productクラスのインスタンスを生成
		Product updateProduct = new Product(101, "シャープペンシル", 70);

		// 更新前のデータを取得
		System.out.println("【更新前】");
		Product beforeProduct = dao.findByProductId(updateProduct.getProduct_id());
		//Product beforeProduct = dao.findByProductId(101);


		printProductInfo(beforeProduct);
		
		//更新
		dao.update(updateProduct);
		
		//更新後のデータ取得
		System.out.println("【更新後】");
		Product afterProduct = dao.findByProductId(updateProduct.getProduct_id());
		printProductInfo(afterProduct);
	}
	
	
	private static void printProductInfo(Product product) {
		System.out.println("product_id:" + product.getProduct_id() + ", product_name:" + product.getProduct_name() + ", price:" + product.getPrice());
	}
}
