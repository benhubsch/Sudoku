import java.util.*;

public class Sudoku {
	
	public int[][] myBoard;
	
	public Sudoku(int[][] board){
		myBoard = board;
		
		if (solve(0, 0)){
			print();
		}
	}
	
	/*
	 * This method actually solves the Sudoku by using recursion and backtracking;
	 * it picks the first item in the ArrayList of possible numbers for a square,
	 * then continues on given the new state of a board. If a mistake has been
	 * made, that mistake is undone and life continues on.
	 */
	public boolean solve(int row, int col){

		if (isSolved()) return true;
		
		if (col == 9){
			col = 0;
			row +=1 ;
		}
		
		if (myBoard[row][col] == -1){
			ArrayList<Integer> possibles = getPossibles(row, col);
			if (possibles.size() == 0) return false;
				
			for (int guess : possibles){
				myBoard[row][col] = guess;
				
				if (solve(row, col + 1)) return true;
				
				//if not true, "undo" the mistaken guess by making that cell -1 again
				myBoard[row][col] = -1;
			}													
		}
		else{
			if (solve(row, col + 1)) return true;
		}
		return false;
	}
	
	/*
	 * Checks to see if the Sudoku is solved. In my program,
	 * the Sudoku is solved if and only if there are no -1's 
	 * on the board.
	 */
	public boolean isSolved(){
		for (int r=0; r < myBoard[0].length; r++){
			for (int c=0; c < myBoard.length; c++){
				if (myBoard[r][c] == -1) return false;
			}
		}
		return true;
	}
	
	
	/*
	 * returns an integer array of possible guesses based on the location's
	 * row, column, and subgrid entries
	 */
	public ArrayList<Integer> getPossibles(int row, int col){
		ArrayList<Integer> possibles = initPossible();
		//simple: checking row then column
		for (int r = 0; r < myBoard[0].length; r++){
			if (myBoard[r][col] > 0) possibles.remove((Integer) myBoard[r][col]);
		}
		for (int c = 0; c < myBoard.length; c++){
			if (myBoard[row][c] > 0){
				possibles.remove((Integer) myBoard[row][c]);
			}
		}
		
		int startCol = 0;
		int startRow = 0;
		
		//top row of subgrids
		if (row < 3 && col < 3){
			startCol = 0;
			startRow = 0;
		}
		else if (row < 3 && 2 < col && col < 6){
			startCol = 3;
			startRow = 0;
		}
		else if (row < 3 && 5 < col && col < 9){
			startCol = 6;
			startRow = 0;
		}
		//middle row of subgrids
		else if (row < 6 && 0 <= col && col < 3){
			startCol = 0;
			startRow = 3;
		}
		else if (row < 6 && 2 < col && col < 6){
			startCol = 3;
			startRow = 3;
		}
		else if (row < 6 &&  5 < col && col < 9){
			startCol = 6;
			startRow = 3;
		}
		//bottom row of subgrids
		else if (row < 9 && 0 <= col && col < 3){		
			startCol = 0;
			startRow = 6;
		}
		else if (row < 9 && 2 < col && col < 6){
			startCol = 3;
			startRow = 6;
		}
		else if (row < 9 &&  5 < col && col < 9){
			startCol = 6;
			startRow = 6;
		}
		
		//now checking subgrid that board[row][col] belongs to using startX and startY
		for (int m=0; m < 3; m++){
			for (int n=0; n < 3; n++){
				int x = startCol + m;
				int y = startRow + n;
				
				if (myBoard[y][x] > 0){
//					System.out.println(board[y][x]);
					possibles.remove((Integer) myBoard[y][x]);
				}
			}
		}
		
		return possibles;
	}
	
	/*
	 * simply returns an ArrayList of Integers 1-9 that getPossibles uses
	 */
	public ArrayList<Integer> initPossible(){
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i=1; i <= 9; i++){
			l.add(i);
		}
		return l;
	}
	
	/*
	 * prints myBoard in a more legible fashion; particularly useful for debugging
	 * from one instance of myBoard to another
	 */
	public void print(){
		for (int r=0; r < myBoard[0].length; r++){
			for (int c=0; c < myBoard.length; c++){
				if (myBoard[r][c] == -1) System.out.print(myBoard[r][c]);
				else{
					System.out.print(" " + myBoard[r][c]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[][] puzzle = new int[][]{ 
			{-1, -1, -1, -1, -1, 1, -1, -1, -1}, 
			{7, -1, 6, 5, 8, -1, -1, -1, 4},
			{-1, 2, -1, -1, -1, 6, -1, 3, -1},
			{-1, 3, -1, -1, 4, -1, -1, 5, -1},
			{4, -1, 2, -1, -1, -1, 7, -1, 3},
			{-1, 1, -1, -1, 3, -1, -1, -1, -1},
			{-1, 8, -1, 1, -1, -1, -1, 9, -1},
			{1, -1, -1, -1, 2, -1, 6, -1, 5},
			{-1, -1, -1, 7, -1, -1, -1, -1, -1}};
		Sudoku test = new Sudoku(puzzle);
//		test.completePuzzle(puzzle);		
	}
}
