class Solution {
    public void dfs(int row, int col, int[][] image, int[][] ans, int iniColor, int color, int[] delr, int[] delc){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delr[i];
            int ncol=col+delc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!=color){
                dfs(nrow,ncol,image,ans,iniColor,color,delr,delc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        int iniColor=image[sr][sc];
        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};
        dfs(sr,sc,image,ans,iniColor, color,delr,delc);
        return ans;
        
    }
}
