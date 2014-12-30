package com.peter.fx.view;

import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.peter.fx.controller.StockController;
import com.peter.fx.model.Stock;

/**
 * Main Table View
 * 
 * @author Peter
 *
 */
public class MainTableView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainTableModel tableModel;	
	private JTable table;
	
	private JScrollPane scrollPane;
	
	/**
	 * Construct Table and scroll pane.
	 */
	public MainTableView() {
		super(new GridLayout(1,0));
		
		tableModel = new MainTableModel();
		
		table = new JTable(tableModel);
		table.setDefaultRenderer(BigDecimal.class, new MainTableRenderer());
		table.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		scrollPane = new JScrollPane(table);
		
		add(scrollPane);
	}

	/**
	 * Call to update table.  This will access the Dao through the controller to 
	 * retrieve the data.
	 */
	public void updateTable() {
		StockController sController = new StockController();
		ArrayList<Stock> stocks = sController.getStocks();

		tableModel.replaceData(stocks);
	}
}
