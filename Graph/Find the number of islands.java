class Pair{
    int first;
    int second;
    public Pair(int a, int b){
        first=a;
        second=b;
    }
}
class Solution {
    public void bfs(int row, int col, char[][] grid, boolean[][] vis){
        Queue<Pair> q=new LinkedList<Pair>();
        vis[row][col]=true;
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            for(int delr=-1;delr<=1;delr++){
                for(int delc=-1;delc<=1;delc++){
                    int nrow=r+delr;
                    int ncol=c+delc;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]=='L'){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && grid[i][j]=='L'){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}
