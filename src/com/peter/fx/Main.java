package com.peter.fx;

import java.math.BigDecimal;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.peter.fx.controller.StockController;
import com.peter.fx.model.Stock;
import com.peter.fx.view.MainTableView;

/**
 * Main class used to start program.
 * 
 * @author Peter
 *
 */
public class Main {

	static MainTableView tableView = new MainTableView();
	
	/**
	 * Setup the Main table
	 */
	public static void displayTable() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFrame frame = new JFrame("FX Trade Blotter");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		tableView.setOpaque(true);
		frame.setContentPane(tableView);
		
		frame.pack();
		frame.setVisible(true);
		
		Runnable tableUpdate = new Runnable() {
			public void run() {
				try {
					while ( true ) {
						tableView.updateTable();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(tableUpdate).start();
	}
	
	public static void main(String[] args) {
	
		StockController sc = new StockController();
		sc.setMarketRate(new BigDecimal(100));
		
		/*
		 * Stock simulator. Add new stocks every 300 milliseconds
		 */
		Runnable newOrder = new Runnable() {
			public void run() {
				try {
					StockController sc = new StockController();
					Random random = new Random();
					while ( true ) {
						BigDecimal quantity = new BigDecimal(random.nextInt(100));
						Stock.Side side = random.nextInt(2) == 0 ? Stock.Side.BUY : Stock.Side.SELL;
						Stock.CcyPair ccyPair = random.nextInt(2) == 0 ? Stock.CcyPair.EUR_USD : Stock.CcyPair.USD_JPY;
						sc.addOrder("EMC", quantity, side, ccyPair);
						Thread.sleep(300);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		};
		new Thread(newOrder).start();
		
		/*
		 * Market Rate simulator.  Change market value every 100 milliseconds
		 */
		Runnable newMarketValue = new Runnable() {
			public void run() {
				try {
					StockController sc = new StockController();
					BigDecimal min = new BigDecimal(90.0);
					BigDecimal max = new BigDecimal(100.0);
					while ( true ) {
						BigDecimal marketRate = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
						sc.setMarketRate(marketRate.setScale(10, BigDecimal.ROUND_HALF_UP));
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		};
		new Thread(newMarketValue).start();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				displayTable();
			}
		});
	}

}
