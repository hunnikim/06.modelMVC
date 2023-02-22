package com.model2.mvc.service.product;


import java.util.Map;

//import com.model2.mvc.common.SearchVO;
//import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.common.*;
import com.model2.mvc.service.domain.*;

public interface ProductService {

	public void addProduct(Product product) throws Exception;

	public Product getProduct(int Product) throws Exception;
	
	public Map<String, Object> getProductList(Search search) throws Exception;
	
	public void updateProduct(Product product) throws Exception;

}