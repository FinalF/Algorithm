    public int kthSmallest(int[][] matrix, int k) {
        // binary sort. O(nlogx) x:max-min
        int m=matrix.length;
        int n=matrix[0].length;
        int row=matrix.length;
        int col=matrix.length;
        int min=matrix[0][0];
        int max=matrix[m-1][n-1];
        while(min<max){
            int mid = min+(max-min)/2;
            int count=searchLowerThanMid(matrix, mid, m,n);
            if(count<k) min=mid+1;
            else max=mid;
        }
        return min;
    }
    
    private int searchLowerThanMid(int[][] matrix, int mid, int m,int n){
		int i=m-1;
		int j=0;
		int cnt=0;
		while (i>=0 && j<n) {
			if (matrix[i][j]<=mid) {
				j++;
				cnt += i+1; //add the whole column
			}
			else i--;
		}
		return cnt;
    }