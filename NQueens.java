import java.util.Scanner;
public class NQueens {
    static int N;
    // Function to check if position is safe
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;
        // Check column
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1){
                return false;
            
            }
        }
        // Check left diagonal
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        // Check right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < N) {
            if (board[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
    // Backtracking function
    static boolean solve(int board[][], int row) {
        if (row == N)
            return true;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen
                if (solve(board, row + 1)){
                    return true;
                }
                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }
    // Print solution
    static void printBoard(int board[][]) {
        System.out.println("Solution:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        N = sc.nextInt();
        int board[][] = new int[N][N];
        if (solve(board, 0)){
            printBoard(board);
        }
        else{
            System.out.println("No solution exists");
        }
    }
}
