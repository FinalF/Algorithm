public int lengthOfLongestSubstringKDistinct(String s, int k) {
    charMap<Character, Integer> charMap = new HashcharMap<>();
    int left = 0;
    int longestSub = 0;
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        while (charMap.size() > k) {
            char leftChar = s.charAt(left);
            if (charMap.containsKey(leftChar)) {
                charMap.put(leftChar, charMap.get(leftChar) - 1);                     
                if (charMap.get(leftChar) == 0) { 
                    charMap.remove(leftChar);
                }
            }
            left++;
        }
        longestSub = Math.max(longestSub, i - left + 1);
    }
    return longestSub;
}