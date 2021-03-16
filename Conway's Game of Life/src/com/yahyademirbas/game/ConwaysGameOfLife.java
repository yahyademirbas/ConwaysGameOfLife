package com.yahyademirbas.game;

public class ConwaysGameOfLife {
	 
	    public static void main(String[] args) 
	    { 
	        int Col = 10, Row = 10; 
	  
	      
	        int[][] square = 
	        	{ 
	        	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
	        }; 
	  
	        // Displaying
	        System.out.println("Original"); 
	        for (int i = 0; i < Col; i++) 
	        { 
	            for (int j = 0; j < Row; j++) 
	            { 
	                if (square[i][j] == 0) 
	                    System.out.print("."); 
	                else
	                    System.out.print("*"); 
	            } 
	            System.out.println(); 
	        } 
	        System.out.println(); 
	        nextGeneration(square, Col, Row); 
	    } 
	  
	    //  next generation 
	    static void nextGeneration(int grid[][], int Col, int Row) 
	    { 
	        int[][] future = new int[Col][Row]; 
	  
	       
	        for (int l = 1; l < Col - 1; l++) 
	        { 
	            for (int m = 1; m < Row - 1; m++) 
	            { 
	                // Neighbours those alive 
	                int aliveNeighbours = 0; 
	                for (int i = -1; i <= 1; i++) 
	                    for (int j = -1; j <= 1; j++) 
	                        aliveNeighbours += grid[l + i][m + j]; 
	  
	             
	            
	                aliveNeighbours -= grid[l][m]; 
	  
	                // the Rules of Life 
	  
	                // alone and dies 
	                if ((grid[l][m] == 1) && (aliveNeighbours < 2)) 
	                    future[l][m] = 0; 
	  
	                // overpopulation 
	                else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) 
	                    future[l][m] = 0; 
	  
	                // newborn 
	                else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) 
	                    future[l][m] = 1; 
	  
	                // Remains
	                else
	                    future[l][m] = grid[l][m]; 
	            } 
	        } 
	  
	        System.out.println("Next Generation"); 
	        for (int i = 0; i < Col; i++) 
	        { 
	            for (int j = 0; j < Row; j++) 
	            { 
	                if (future[i][j] == 0) 
	                    System.out.print("."); 
	                else
	                    System.out.print("*"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	} 
