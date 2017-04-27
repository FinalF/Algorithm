    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums==null || nums.length==0) return -1;
        int start=0;
        int cur=start;
        int len=nums.length+1;
        int sum=nums[cur];
        while(cur<nums.length){
            
            if(sum>=s){
                while(sum>=s){
                    len=Math.min(len,cur-start+1);
                    sum-=nums[start];
                    start++;                   
                }
            }else{
                cur++;
                if(cur<nums.length) sum+=nums[cur];
            }
        }
        if(len==nums.length+1) return -1;
        return len;
    }