package com.peter.fx.model;

import java.math.BigDecimal;

/**
 * Stock Model
 * 
 * @author Peter
 *
 */
public class Stock {

	public enum Side {BUY, SELL};
	public enum CcyPair {EUR_USD {
		public String toString() {
			return "EUR/USD";
		}
	}, USD_JPY {
		public String toString() {
			return "USD/JPY";
		}
	}
	}
	
	private String tradeName;
	private BigDecimal quantity;
    private Side side;
    private CcyPair ccyPair;
	private BigDecimal marketRate;
    
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public Side getSide() {
		return side;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public CcyPair getCcyPair() {
		return ccyPair;
	}
	public void setCcyPair(CcyPair ccyPair) {
		this.ccyPair = ccyPair;
	}
	public BigDecimal getMarketRate() {
		return marketRate;
	}
	public void setMarketRate(BigDecimal marketRate) {
		this.marketRate = marketRate;
	}
	
	@Override
	public String toString() {
		return "Stocks [tradeName=" + tradeName + ", quantity=" + quantity
				+ ", side=" + side + ", ccyPair=" + ccyPair + ", marketRate="
				+ marketRate + "]";
	}
}
