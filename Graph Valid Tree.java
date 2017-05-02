public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
     
    private int[] parent = null;
    public boolean validTree(int n, int[][] edges) {
        // find & union
        parent = new int[n];
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!union(a,b)) return false;
        }
        
        int root = -1;
        for(int i = 0; i < n; i ++){
            int curRoot = find(i);
            if(root==-1) root = curRoot;
            if(root != curRoot) return false;
        }
        return true;
    }
    
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent[x]);
    }
    
    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootA] = rootB;
        }else{
            return false; //circle
        }
        return true;
    }
}