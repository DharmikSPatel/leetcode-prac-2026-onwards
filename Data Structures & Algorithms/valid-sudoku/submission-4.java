class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<Integer, HashSet<Character>> grid = new HashMap<>();

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                char val = board[i][j];
                int k = ((i/3) * 3) + j/3;
                System.out.println(i + " " + j + ": " + (((i/3) * 3) + j/3));
                HashSet<Character> rS = rows.computeIfAbsent(i, key -> new HashSet<Character>());
                HashSet<Character> cS = cols.computeIfAbsent(j, key -> new HashSet<Character>());
                HashSet<Character> gS = grid.computeIfAbsent(k, key -> new HashSet<Character>());
                if(val != '.'){
                    if(!rS.add(val))
                        return false;
                    if(!cS.add(val))
                        return false;
                    if(!gS.add(val))
                        return false;
                }
            }
        }

        return true;
    }
}
