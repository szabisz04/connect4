class Board {
    private char[][] grid;
    private final int ROWS = 6;
    private final int COLS = 7;

    public Board() {
        grid = new char[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = '.';
            }
        }
    }

    public void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(" " + grid[row][col]);
            }
            System.out.println();
        }
    }

    public boolean dropDisc(int col, char disc) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col] == '.') {
                grid[row][col] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkForWin(char disc) {
        // vizszintes
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (grid[row][col] == disc && grid[row][col + 1] == disc && grid[row][col + 2] == disc
                        && grid[row][col + 3] == disc) {
                    return true;
                }
            }
        }
        // fuggoleges
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (grid[row][col] == disc && grid[row + 1][col] == disc && grid[row + 2][col] == disc
                        && grid[row + 3][col] == disc) {
                    return true;
                }
            }
        }
        // bal also jobb felso
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (grid[row][col] == disc && grid[row - 1][col + 1] == disc && grid[row - 2][col + 2] == disc
                        && grid[row - 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        // bal felso jobb also
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (grid[row][col] == disc && grid[row + 1][col + 1] == disc && grid[row + 2][col + 2] == disc
                        && grid[row + 3][col + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int col = 0; col < COLS; col++) {
            if (grid[0][col] == '.') {
                return false;
            }
        }
        return true;
    }
}