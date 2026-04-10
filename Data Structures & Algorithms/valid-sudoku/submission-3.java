class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;
                
                int num = val - '1'; // Convert '1'-'9' to 0-8
                int gridKey = (i / 3) * 3 + j / 3;
                
                if (rows[i][num] || cols[j][num] || grid[gridKey][num]) {
                    return false;
                }
                
                rows[i][num] = true;
                cols[j][num] = true;
                grid[gridKey][num] = true;
            }
        }
        return true;
    }
}