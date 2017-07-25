import java.util.ArrayList;

public class Trash {

}

//public boolean solve(int col, int[][] board){
//	if (isSolved(board)) return true;
//	
//	if (col == 9) col = 0;
//	
//	for (int row=0; row < board[0].length; row++){
//		if (board[row][col] == -1){
//			print(board);
//			System.out.println();
//			ArrayList<Integer> possibles = getPossibles(row, col, board);
//			if (possibles.size() == 0) return false;
//			
//			for (int guess : possibles){
//				board[row][col] = guess;
//				if (solve(col + 1, board)) return true;
//			}
//		}
//	}
//	return false;
//}


