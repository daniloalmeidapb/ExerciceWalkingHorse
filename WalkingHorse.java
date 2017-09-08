package com.deitel.exercicios.Capitulo7.Cap7_22c;

public class WalkingHorse
{
	private int[][] board;
	private int[][] accessibility;
	private int[] horizontal;
	private int[] vertical;
	private int currentRow;
	private int currentColumn;
	
	private int countMove = 0;
	
	private int moveNumber;
	
	public WalkingHorse( int[][] board, int[][] accessibility, int[] horizontal,
							int[] vertical, int currentRow, int currentColumn )
	{
		this.board = board;
		this.accessibility = accessibility;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
	}
	
	public void setMoveNumber( int moveNumber )
	{
			this.moveNumber = moveNumber;
	}
	
	public void processWakkingHorse()
	{	
		testAcessibility();
		
		currentRow += vertical[ moveNumber ];
		currentColumn += horizontal[ moveNumber ];
				
		++countMove;
				
		board[ currentRow ][ currentColumn ] = countMove;
				
		++accessibility[ currentRow ][ currentColumn ]; // aumentar o valor da acessibilidade
	}
	
	public boolean testMoveSquare()
	{	
		int testRow = currentRow + vertical[ moveNumber ];
		int testColumn = currentColumn + horizontal[ moveNumber ];
		
		if( board[ testRow ][ testColumn ] == 0 )
			return true;
		else
			return false;
	}
	
	public boolean testMoveOutBoard()
	{
		boolean testRow;
		boolean testColumn;
		
		// teste linha para cavalo nao sair do tabuleiro
		if( currentRow + vertical[ moveNumber ] > 7 )
			testRow = false;
		else if( currentRow + vertical[ moveNumber ] < 0 )
			testRow = false;
		else 
			testRow = true;
		
		// teste coluna para cavalo nao sai do tabuleiro
		if( currentColumn + horizontal[ moveNumber ] > 7 )
			testColumn = false;
		else if( currentColumn + horizontal[ moveNumber ] < 0 )
			testColumn = false;
		else 
			testColumn = true;
		
		return ( testRow && testColumn );
	}
	
	public void testAcessibility()
	{
		int lowest = 10;
		int newMoveNumber = 0;
		
		for( int i = 0; i < 8; i++ )
		{
			int testRow = currentRow + vertical[ i ];
			int testColumn = currentColumn + horizontal[ i ];
			
			moveNumber = i;
			
			if( testMoveOutBoard() && testMoveSquare() )
			{
				if( lowest > accessibility[ testRow ][ testColumn ] )
				{
					lowest = accessibility[ testRow ][ testColumn ];
						
					newMoveNumber = i;
				}
			}
		}

		moveNumber = newMoveNumber;
	}
	
	public void printArray()
	{
		for( int[] x : board )
		{
			for( int boards : x )
			{
				if( boards > 0 )
					System.out.printf( "%4d", boards );
				else if ( boards == 0 )
					System.out.printf( "%4s", "x" );
			}
			
			System.out.printf( "%n%n" );
		}
		
		System.out.printf( "Contador de movimento: %d%n", countMove );
	}
	
}
