package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.user.UserService;


/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml",
									"classpath:config/context-aspect.xml",
									"classpath:config/context-mybatis.xml",
									"classpath:config/context-transaction.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		//product.setProdNo(1111);
		product.setProdName("testProdname");//5
		product.setManuDate("333");//4
		product.setFileName("1111"); //3
		product.setPrice(11);// 2
		product.setProdNo(10); //1
		
		productService.addProduct(product);
		
		product = productService.getProduct(10021);

		//==> console Ȯ��
		System.out.println(product);
		
		//==> API Ȯ��
		//Assert.assertEquals("ProdName", product.getProdName());
		//Assert.assertEquals("manuDate", product.getManuDate());
		//Assert.assertEquals("FIleName", product.getFileName());
		//Assert.assertEquals("Price", product.getPrice());
		//Assert.assertEquals("ProdNo", product.getProdNo());

	}
		//@Test
		public void testGetProduct() throws Exception {
			
			Product product = new Product();
			//==> �ʿ��ϴٸ�...
			product.setProdNo(10);
			product.setProdName("testUserName");
			product.setProdDetail("testPasswd");
			product.setManuDate("1111112222222");
			product.setPrice(2000);
			product.setFileName("��⵵");
			
			product = productService.getProduct(10002);

			//==> console Ȯ��
			System.out.println(product);
			
			//==> API Ȯ��
		//	Assert.assertEquals("testUserId", user.getUserId());
		//	Assert.assertEquals("testUserName", user.getUserName());
		//.assertEquals("testPasswd", user.getPassword());
		//	Assert.assertEquals("111-2222-3333", user.getPhone());
		//.assertEquals("��⵵", user.getAddr());
		//	Assert.assertEquals("test@test.com", user.getEmail());

		//.assertNotNull(userService.getUser("user02"));
		//	Assert.assertNotNull(userService.getUser("user05"));
		}
		
		//@Test
		 public void testUpdateProduct() throws Exception{
			 
			Product product = productService.getProduct(10001);
			//Assert.assertNotNull(product);
			
			//Assert.assertEquals("testUserName", product.getUserName());
			//Assert.assertEquals("111-2222-3333", product.getPhone());
			//Assert.assertEquals("��⵵", product.getAddr());
			//Assert.assertEquals("test@test.com", product.getEmail());

			product.setProdNo(10);
			product.setProdName("testUserName");
			product.setProdDetail("testPasswd");
			product.setManuDate("1111112222222");
			product.setPrice(2000);
			product.setFileName("��⵵");
			
			productService.updateProduct(product);
			
			product = productService.getProduct(10021);
			//Assert.assertNotNull(product);
			
			//==> console Ȯ��
			//System.out.println(user);
				
			//==> API Ȯ��
			//Assert.assertEquals("change", product.getUserName());
			//Assert.assertEquals("777-7777-7777", product.getPhone());
			//Assert.assertEquals("change", product.getAddr());
			//Assert.assertEquals("change@change.com", product.getEmail());
		 }
		 
		//@Test
		
		
		 //==>  �ּ��� Ǯ�� �����ϸ�....
		//@Test
		 public void testGetProductListAll() throws Exception{
			 
		 	Search search = new Search();
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	Map<String,Object> map = productService.getProductList(search);
		 	
		 	List<Object> list = (List<Object>)map.get("list");
		 	//Assert.assertEquals(3, list.size());
		 	
			//==> console Ȯ��
		 	//System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
		 	
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	search.setSearchCondition("0");
		 	search.setSearchKeyword("");
		 	map = productService.getProductList(search);
		 	
		 	list = (List<Object>)map.get("list");
		 	//Assert.assertEquals(3, list.size());
		 	
		 	//==> console Ȯ��
		 	System.out.println(list);
		 	
		 	totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 }
		 
		 

	
}