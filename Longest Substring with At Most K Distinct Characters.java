public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // two-pointer techniques
        if(s==null || s.isEmpty()) return 0;
        Map<Character,Integer> dic = new HashMap<Character,Integer>();
        int start=0;
        int cur=0;
        int max=0;
        while(cur<s.length()){
            char c = s.charAt(cur);
            if(dic.containsKey(c)){
                dic.put(c,dic.get(c)+1);
            }else{
                dic.put(c,1);
            }
            if(dic.size()<=k) max=Math.max(max,cur-start+1);
            while(dic.size()>k){
                char tmpC = s.charAt(start);
                int count=dic.get(tmpC);
                count--;
                if(count==0) dic.remove(tmpC);
                else dic.put(tmpC,count);
                start++;
            }
            
            cur++;
        }
        max=Math.max(max,cur-start);
        return max;
    }