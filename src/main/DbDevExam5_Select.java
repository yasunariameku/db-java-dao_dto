package main;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Select {

    public static void main(String[] args) {
        // Daoインスタンス化
        ProductDao dao = new ProductDao(DbUtil.getConnection());

        // 取得する対象のproduct_id
        Integer productId = 102;

        // データ取得
        Product product = dao.findByProductId(productId);

        // 取得したデータを表示
        System.out.println("product_id:" + product.getProduct_id()
              	+ ", product_name:" + product.getProduct_name()
                + ", price:" + product.getPrice());

    }
}