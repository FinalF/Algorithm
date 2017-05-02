public class WordDictionary {
    TrieNode root;
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        if(root==null) root = new TrieNode();
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.getChild(c)==null){
                cur.setChild(new TrieNode(),c);
            }
            cur = cur.getChild(c);
        }
        cur.setEnd();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return BFSsearch(0,word,root);
    }
    
    public boolean BFSsearch(int i, String word, TrieNode cur){
        if(cur==null) return false;
        if(i==word.length()){
            if(cur.isEnd()) return true;
            return false;
        }
        boolean found = false;
        char c = word.charAt(i);
        if(c=='.'){
            for(char x = 'a'; x < 'z'; x ++){
                if(cur.getChild(x)!=null){
                    found = BFSsearch(i+1,word,cur.getChild(x));
                    if(found) return true;
                }
            } 
            if(!found) return false;
        }else{
            if(cur.getChild(c)==null) return false;
        }
        return BFSsearch(i+1,word,cur.getChild(c));

        
    }
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] children;
    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
    public boolean isEnd(){
        return isEnd;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public TrieNode getChild(char c){
        return children[c-'a'];
    }
    public void setChild(TrieNode child, char c){
        children[c-'a'] = child;
    }
}
}