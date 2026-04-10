class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> grid = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;
                
                int gridKey = (i / 3) * 3 + j / 3;
                
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(val) ||
                    cols.computeIfAbsent(j, k -> new HashSet<>()).contains(val) ||
                    grid.computeIfAbsent(gridKey, k -> new HashSet<>()).contains(val)) {
                    return false;
                }
                
                rows.get(i).add(val);
                cols.get(j).add(val);
                grid.get(gridKey).add(val);
            }
        }
        return true;
    }
}