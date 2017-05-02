/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
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

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.getChild(c)==null){
                return false;
            }
            cur = cur.getChild(c);
        }
        if(cur.isEnd()) return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(cur.getChild(c)==null){
                return false;
            }
            cur = cur.getChild(c);
        }
        return true;
    }
}