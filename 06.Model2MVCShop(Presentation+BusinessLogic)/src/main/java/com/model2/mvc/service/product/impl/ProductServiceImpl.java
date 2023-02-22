package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.user.UserDao;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDAO productDAO;
	
	public void setProductDao(ProductDAO productDao) {
		this.productDAO = productDao;
	}
	
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}
	public void addProduct(Product product) throws Exception {
		productDAO.insertProduct(product);
		
	}
	public Product getProduct(int product) throws Exception {
		return productDAO.findProduct(product);		
	}
	
	public Map<String , Object> getProductList(Search search) throws Exception {
		List<Product> list= productDAO.getProductList(search);
		int totalCount = productDAO.getTotalCount(search);
		System.out.println(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	public void updateProduct(Product productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}

}
