class Solution {
    public boolean dfs(int node, int parent, List<List<Integer>> list, boolean[] vis){
        vis[node]=true;
        for(int x:list.get(node)){
           if(vis[x]==false){
               if(dfs(x,node,list,vis)==true) return true;
              
           }else if(x!=parent) return true;
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis=new boolean[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++){
            if(!vis[i]){
            if(dfs(i,-1,adj,vis)==true) return true;
        }
        }
        return false;
    }
}
