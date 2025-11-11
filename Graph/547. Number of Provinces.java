class Solution {
    public void dfs(int i,boolean[] visited,List<List<Integer>> list){
        visited[i]=true;
        for(int x:list.get(i)){
            if(visited[x]==false) dfs(x,visited,list);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j) list.get(i).add(j);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                dfs(i,visited,list);
            }

        }
        return count;
    }
}
