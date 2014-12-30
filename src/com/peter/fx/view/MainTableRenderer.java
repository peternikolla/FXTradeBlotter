package com.peter.fx.view;

import java.awt.Component;
import java.math.BigDecimal;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.peter.fx.model.Stock;

/**
 * Main Table Renderer
 * 
 * @author Peter
 *
 */
public class MainTableRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int rowIndex, int colIndex) {
		
		if ( colIndex == MainTableModel.MARKET_RATE_COL ) {
			Stock.CcyPair pair = (Stock.CcyPair)table.getModel().getValueAt(rowIndex,  MainTableModel.CCY_PAIR_COL);
			BigDecimal marketRate = (BigDecimal)value;
			
			if ( pair == Stock.CcyPair.EUR_USD ) {
				marketRate = marketRate.setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				marketRate = marketRate.setScale(5, BigDecimal.ROUND_HALF_UP);
			}
			value = marketRate;
		}
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, colIndex);
	}
}
