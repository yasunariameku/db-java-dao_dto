package main;

import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Delete {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao(DbUtil.getConnection());
		
		String productName = "ボールペン";
		
		dao.delete(productName);
		
		List<Product> productList = dao.findAll();
		
		for (Product product: productList) {
			System.out.println("product_id:" + product.getProduct_id() + ", product_name:" + product.getProduct_name() + ", price:" + product.getPrice());
		}
	}
}
