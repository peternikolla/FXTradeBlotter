package com.peter.fx.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.peter.fx.model.Stock;

/**
 * Main Table Model
 * 
 * @author Peter
 *
 */
public class MainTableModel extends AbstractTableModel  {

	public static final int TRADE_NAME_COL 	= 0;
	public static final int QUANITITY_COL 	= 1;
	public static final int SIDE_COL		= 2;	
	public static final int CCY_PAIR_COL	= 3;
	public static final int MARKET_RATE_COL	= 4;
	
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames = {"Trade Name",
			"Quantity",
			"Side",
			"CcyPair",
			"Market Rate"
	};
	
	private List<Stock> data = new ArrayList<Stock>();
	
    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
    	Class<?> retVal = String.class;
    	
    	switch ( columnIndex ) {
    	case TRADE_NAME_COL:
    		retVal = String.class;
    		break;
    	case QUANITITY_COL:
    		retVal = BigDecimal.class;
    		break;
    	case SIDE_COL:
    		retVal = Stock.Side.class;
    		break;
    	case CCY_PAIR_COL:
    		retVal = Stock.CcyPair.class;
    		break;
    	case MARKET_RATE_COL:
    		retVal = BigDecimal.class;
    		break;
    	}
    	
        return retVal;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Stock rowData = data.get(rowIndex);
    	Object retVal = 0;
    	
    	switch ( columnIndex ) {
    	case TRADE_NAME_COL:
    		retVal = rowData.getTradeName();
    		break;
    	case QUANITITY_COL:
    		retVal = rowData.getQuantity();
    		break;
    	case SIDE_COL:
    		retVal = rowData.getSide();
    		break;
    	case CCY_PAIR_COL:
    		retVal = rowData.getCcyPair();
    		break;
    	case MARKET_RATE_COL:
    		retVal = rowData.getMarketRate();
    		break;
    	}
        return retVal;
    }

    /**
     * Add a row to the table model
     * 
     * @param value
     */
    public void addRow(Stock value) {
        int rowCount = getRowCount();
        data.add(value);
        fireTableRowsInserted(rowCount, rowCount);
    }

    /**
     * Add multiple rows to the table model
     * @param value
     */
    public void addRows(Stock... value) {
        addRows(Arrays.asList(value));
    }

    /**
     * Used to replace all Data in the model
     * 
     * @param stocks
     */
    public void replaceData(List<Stock> stocks) {
        Collections.reverse(stocks);
    	data.clear();
    	addRows(stocks);
    }
    
    /**
     * Add rows to table and fire table rows inserted event
     * @param rows
     */
    private void addRows(List<Stock> rows) {
        int rowCount = getRowCount();
        data.addAll(rows);
        fireTableRowsInserted(rowCount, getRowCount() - 1);
    }
  }
