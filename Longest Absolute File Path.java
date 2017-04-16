    public int lengthLongestPath(String input) {
        if(input==null || input.isEmpty()) return 0;
        String[] arr = input.split("\n");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (String path : arr) {
            int level = findLevel(path);

            // step back to parent level
            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            // count "/" in
            int len = path.replaceAll("\t", "").length() + 1;
            curLen += len;

            //a file
            if (path.contains(".")) {
                result = Math.max(curLen - 1,result); //-1 means removing "/" for the 1st piece
            }
            stack.add(len);
        }
        return result;
    }
    private int findLevel(String path){
        String cur = path.replaceAll("\t", "");
        return path.length() - cur.length();
    }
    
    private int getLen(int level, String path){
        return path.length()-level;//add "/" into length
    }