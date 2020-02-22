package com.github.chen0040.magento;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.chen0040.magento.models.StockItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


/**
 * Created by xschen on 15/6/2017.
 */
public class MagentoClientInventoryUnitTest {

   private static final Logger logger = LoggerFactory.getLogger(MagentoClientInventoryUnitTest.class);
   @Test
   public static void test_getStockItems(){
      String productSku = "MDM_1_10001";

      MagentoClient client = new MagentoClient(Mediator.url);
      client.loginAsAdmin(Mediator.adminUsername, Mediator.adminPassword);
      logger.info("stock item: {}", JSON.toJSONString(client.products().getProductBySku(productSku), SerializerFeature.PrettyFormat));
   //   logger.info("stock item: {}", JSON.toJSONString(client.inventory().getStockItems(productSku), SerializerFeature.PrettyFormat));
      

  //    productSku = "B203-SKU";
  //    logger.info("stock item: {}", JSON.toJSONString(client.inventory().getStockItems(productSku), SerializerFeature.PrettyFormat));
   }

   @Test
   public void test_saveStockItems(){
      String productSku = "product_dynamic_571";

      MagentoClient client = new MagentoClient(Mediator.url);
      client.loginAsAdmin(Mediator.adminUsername, Mediator.adminPassword);

      productSku = "B203-SKU";
      StockItems si = client.inventory().getStockItems(productSku);
     // si.setQty(2);
      String stockId = client.inventory().saveStockItems(productSku, si);
      logger.info("stock item saved: {}", stockId);
   }
   
   public static void main(String args[]) {
	   test_getStockItems();
   }
}
