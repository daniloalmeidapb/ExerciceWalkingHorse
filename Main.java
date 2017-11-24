package com.deitel.exercicios.Capitulo7.Cap7_22c;

import javax.crypto.IllegalBlockSizeException;

public class Main
{
	private static final int SIZE = 8;
	
	public static void main( String[] args )
	{
		int[][] accessibility = { { 2, 3, 4, 4, 4, 4, 3, 2 },
					  { 3, 4, 6, 6, 6, 6, 4, 3 },
					  { 4, 6, 8, 8, 8, 8, 6, 4 },
					  { 4, 6, 8, 8, 8, 8, 6, 4 },
					  { 4, 6, 8, 8, 8, 8, 6, 4 },
					  { 4, 6, 8, 8, 8, 8, 6, 4 },
					  { 3, 4, 6, 6, 6, 6, 4, 3 },
					  { 2, 3, 4, 4, 4, 4, 3, 2 } };
		
		int[][] board = new int[ SIZE ][ SIZE ];
		int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
		WalkingHorse myWalkingHorse = new WalkingHorse( board, accessibility, 
														horizontal, vertical, 0, 0 );
		int mov = 0;
		
		
		for( int i = 0; i < 64; i++ )
		{
			myWalkingHorse.setMoveNumber( mov );

			myWalkingHorse.processWakkingHorse();
			
			++mov;
			
			if( mov > 7 )
				mov = 0;
		}
		
		System.out.printf( "%n============ Tabuleiro ============%n" );
		myWalkingHorse.printArray();
	}	

}
