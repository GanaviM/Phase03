package com.cisco.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.dao.OrdersDao;
import com.cisco.model.OrderedShoeModel;
import com.cisco.model.ShoesDataModel;

@Service
public class OrdersService {
	@Autowired
	private OrdersDao orderDao;
	
	 public void insertBookingInfoService(int shoeid, String name, int categeory,
			 double price, String imglink, int quantity, double totalprice,Date date )
	 {
		 OrderedShoeModel  orderedShoeModel =new  OrderedShoeModel(shoeid, categeory, price, quantity, date, name, imglink, totalprice);
		 orderDao.save(orderedShoeModel);
	 }
	 
	 
	 
 public List<OrderedShoeModel> getCompleteTransactionsDataService() {
		 
		 List<OrderedShoeModel> completeOrdersData= (List)orderDao.findAll();
	      
	       return completeOrdersData;
	    }
 
 public List<OrderedShoeModel> getRequiredCompleteTransactionsDataService(int categeoryId,Date date)
 {
	 List<OrderedShoeModel> orderedShoeList= (List)orderDao.getRequiredCompleteTransactionsData(categeoryId, date);
     
     return orderedShoeList;
	 
 }

}
