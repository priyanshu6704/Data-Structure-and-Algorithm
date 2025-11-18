class Pair{
    int first;
    int second;
    int third;
    public Pair(int a, int b, int c){
        first=a;
        second=b;
        third=c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int dis=q.peek().third;
            q.remove();
            dist[row][col]=dis;
            for(int i=0;i<4;i++){
                int nrow=row+delr[i];
                int ncol=col+delc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false){
                    q.add(new Pair(nrow,ncol,dis+1));
                    vis[nrow][ncol]=true;
                }
            }
        }
        return dist;
        
    }
}
