
//Show that it is impossible, using rectangles, to tile an square
// from which two opposite corner squares have been removed

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[8][8];
        grid[0][0] = -1;
        grid[7][7] = -1;
        boolean isPossible = tileGrid(grid, 0, 0);
        if (isPossible) {
            System.out.println("It is possible to tile the grid.");
        } else {
            System.out.println("It is impossible to tile the grid.");
        }
    }
    private static boolean tileGrid(int[][] grid, int row, int col) {
        // 基本情况：超出方块边界时返回真值
        if (row >= grid.length) {
            return true;
        }
        // 如果当前行已完成，移动到下一行
        if (col >= grid[0].length) {
            return tileGrid(grid, row + 1, 0);
        }
        // 如果当前单元格已被占据或移除，则跳过
        if (grid[row][col] != 0) {
            return tileGrid(grid, row, col + 1);
        }
        // 尝试水平放置方块
        if (col + 1 < grid[0].length && grid[row][col + 1] == 0) {
            grid[row][col] = 1;
            grid[row][col + 1] = 1;
            if (tileGrid(grid, row, col + 2)) {
                return true;
            }
            grid[row][col] = 0;// 回溯
            grid[row][col + 1] = 0;// 回溯
        }
        // 尝试垂直放置方块
        if (row + 1 < grid.length && grid[row + 1][col] == 0) {
            grid[row][col] = 1;
            grid[row + 1][col] = 1;
            if (tileGrid(grid, row, col + 1)) {
                return true;
            }
            grid[row][col] = 0; // 回溯
            grid[row + 1][col] = 0; // 回溯
        }
        return false;
    }
}