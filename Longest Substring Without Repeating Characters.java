    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null) return 0;
        int len=0;
        int start=0;
        int cur=start;
        Set<Character> dic = new HashSet<Character>();
        while(cur<s.length()){
            char c = s.charAt(cur);
            if(dic.contains(c)) len=Math.max(len,cur-start);
            while(dic.contains(c)){
                dic.remove(s.charAt(start));
                start++;
            }
            dic.add(c);
            cur++;
        }
        len=Math.max(len,cur-start);
        return len;
    }