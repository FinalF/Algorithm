     class Node {
        int row;
        int col;
        int val;
        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Assume A & B are valid input
        int m = A.length;
        int n = B.length;
        Queue<Node> pq = new PriorityQueue<Node>(k,new Comparator<Node>() {
           public int compare(Node a, Node b) {
               return a.val - b.val;
           } 
        });
        Set<String> visited = new HashSet<String>();
        pq.offer(new Node(0,0,A[0]+B[0]));//add the 1st node;
        for(int i = 0; i < k-1; i++){
            Node cur = pq.poll();
            int tmpi = cur.row;
            int tmpj = cur.col;
            //only look at the next two larger numbers
            if(tmpi+1<m && !visited.contains(tmpi+1+":"+tmpj)){
                pq.offer(new Node(tmpi+1,tmpj,A[tmpi+1]+B[tmpj]));
                visited.add(tmpi+1+":"+tmpj);
            }
            if(tmpj+1<n && !visited.contains(tmpi+":"+(tmpj+1))){
                pq.offer(new Node(tmpi,tmpj+1,A[tmpi]+B[tmpj+1]));
                visited.add(tmpi+":"+(tmpj+1));
            }
        }
        return pq.poll().val;
    }