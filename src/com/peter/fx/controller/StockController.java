package com.peter.fx.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.peter.fx.dao.StockDao;
import com.peter.fx.model.Stock;

/**
 * Main Controller class.
 * 
 * @author Peter
 *
 */
public class StockController {

	public StockController() {}
	
	/**
	 * Add a new order.
	 * 
	 * @param tradeName
	 * @param quantity
	 * @param side
	 * @param ccyPair
	 */
	public void addOrder(String tradeName, BigDecimal quantity, Stock.Side side,
			Stock.CcyPair ccyPair) {
		StockDao stockDao = new StockDao();
		stockDao.addOrder(tradeName, quantity, side, ccyPair);
	}
	
	/**
	 * Change market rate.
	 * 
	 * @param marketRate
	 */
	public void setMarketRate(BigDecimal marketRate) {
		StockDao stockDao = new StockDao();
		stockDao.setMarketRate(marketRate);
	}	
	
	/**
	 * Retrieve all stock data.
	 * 
	 * @return All Stock Data
	 */
	public ArrayList<Stock> getStocks() {
		StockDao stockDao = new StockDao();
		return stockDao.getStocks();	
	}
}
