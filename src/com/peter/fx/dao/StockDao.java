package com.peter.fx.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.peter.fx.model.Stock;

/**
 * Used to access stock data.  Data is stored in a in memory data structure.
 * 
 * @author Peter
 *
 */
public class StockDao {

	private static ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	private static BigDecimal marketRate;
	
	public StockDao() {}
	
	/**
	 * Add a new order.
	 * 
	 * @param tradeName
	 * @param quantity
	 * @param side
	 * @param ccyPair
	 */
	public synchronized void addOrder(String tradeName, BigDecimal quantity, Stock.Side side,
			Stock.CcyPair ccyPair) {
		
		Stock stock = new Stock();
		stock.setTradeName(tradeName);
		stock.setQuantity(quantity);
		stock.setSide(side);
		stock.setCcyPair(ccyPair);
		stock.setMarketRate(StockDao.marketRate);
			
		stocks.add(stock);
	}
	
	/**
	 * Change market rate.
	 * 
	 * @param marketRate
	 */
	public synchronized void setMarketRate(BigDecimal marketRate) {
		StockDao.marketRate = marketRate;
	}
	
	/**
	 * Retrieve all stock data.
	 * 
	 * @return All Stock Data
	 */
	@SuppressWarnings("unchecked")
	public synchronized ArrayList<Stock> getStocks() {		
		return (ArrayList<Stock>)stocks.clone();
	}
}
