## FX Trade Blotter

This is a standalone program that displays a table of stock orders in real time.  The data that is displayed is randomly created to show Buy/Sell orders of EMC shares.
* Designed using MVC.
* Dao is an in memory structure.  The Dao class is synchronized to prevent collisions on the data.
* There are 3 threads used to update data and update the table.
	* Update table runs every second
	* Add Buy/Sell order runs every 300 milliseconds
* 	Market Rate changes every 100 milliseconds
* The table will show the orders from newest to oldest orders
* The Market Rate is a value between 90 and 100 dollars, not realistic but it’s good to show variation in the table.
* The table has a model to handle the data and a renderer to format the cells.
* The main can be found in com.peter.fx.Main
* The program will run until the window is closed.  There is not check for the amount of data, if let run it will eventually run out of memory to store the orders.
* The table will grow with orders and the vertical scroll bar will appear when needed.


