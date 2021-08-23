package 岛屿数量200;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    String[][] data = null;
    int length_width = 0;
    int length_height = 0;
    int total = 0;

    public int numIslands(String[][] grid) {
        int col_index = 0,column_index =0;

        if (grid.length == 0)
            return -1;

        length_width = grid[0].length;
        length_height = grid.length;

        while (col_index < length_height ){
            if ( grid[col_index][column_index].equals("1") ){
                rightSearch(col_index,column_index,grid);
                downSearch(col_index,column_index,grid);
                grid[col_index][column_index] = "0";
                total ++ ;
            }

            column_index ++ ;

            if (column_index == length_width){
                // 重置
                column_index = 0;
                col_index ++;
            }
        }
        return total;
    }

    public void rightSearch( int col_index,int column_index ,String[][] grid ){
        // 判断越界
        int next_val = ++column_index;

        if ( next_val >= length_width )
            return;

        if ( grid[col_index][next_val].equals("1") ){
            grid[col_index][next_val] = "0";

            rightSearch(col_index,next_val,grid);
        }
    }
    public void downSearch( int col_index,int column_index ,String[][] grid ){
        // 判断越界
        int next_val = ++col_index;

        if ( next_val >= length_height )
            return;

        if ( grid[next_val][column_index].equals("1") ){
            grid[next_val][column_index] = "0";

            rightSearch(next_val,column_index,grid);
        }
    }

    public void createData (){
        this.data = new String[][]{
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createData();
        int i = solution.numIslands(solution.data);

        System.out.println(i);
    }
}