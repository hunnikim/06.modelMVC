package com.model2.mvc.service.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.*;

public interface ProductDAO {
	
	
	// INSERT
	public void insertProduct(Product product) throws Exception;
	
	//SELECT ONE
	public Product findProduct(int product) throws Exception;

	//SELECT LIST	
	public List<Product> getProductList(Search search) throws Exception;

	//UPDATE
	public void updateProduct(Product productVO) throws Exception;

	// 게시판 PAGE 처리를 위한 전체 Row(totalCount) return
	public int getTotalCount(Search search) throws Exception;
}