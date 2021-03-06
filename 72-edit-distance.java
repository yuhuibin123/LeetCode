import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private int[][] dp;
    /**
     * 思路：从字符串尾部开始比较
     */
    public int minDistance(String word1, String word2) {
        int index1 = word1 == null ? 0 : word1.length();
        int index2 = word2 == null ? 0 : word2.length();
        dp = new int[index1 + 1][index2 + 1];
        return change(word1, word2, index1 - 1, index2 - 1);
    }

    private int change(String word1, String word2, int index1, int index2) {
        if (index1 < 0 && index2 < 0) {
            return 0;
        }
        if (index1 < 0 || index2 < 0) {
            return Math.max(index1, index2) + 1;
        }
        if (dp[index1][index2] != 0){
            return dp[index1][index2];
        }
        char c1 = word1.charAt(index1);
        char c2 = word2.charAt(index2);
        if (c1 == c2) {
            int min = change(word1, word2, index1 - 1, index2 - 1);
            setMin(index1, index2, min);
            return min;
        }else{
            // 插入 删除 替换
            int insert = change(word1, word2, index1, index2 - 1);
            int delete = change(word1, word2, index1 - 1, index2);
            int replace = change(word1, word2, index1 - 1, index2 -1);
            int min = Math.min(insert, Math.min(delete, replace)) + 1;
            setMin(index1, index2, min);
            return min;
        }
    }

    private void setMin(int index1, int index2, int size) {
        if (dp[index1][index2] == 0) {
            dp[index1][index2] = size;
        }else {
            dp[index1][index2] = Math.min(size, dp[index1][index2]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = solution.minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");
        System.out.println("min distance: " + n);

    }
}
