    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0) return digits;
        List<Integer> res = new ArrayList<>();
        int carry=1;
        int i=digits.length-1;
        while(i>=0){
            int sum=carry+digits[i];
            res.add(0,sum%10);
            carry=sum/10;
            i--;
        }
        if(carry>0) res.add(0,carry);
        int[] result=  new int[res.size()];
        for(int j=0;j<res.size();j++){
            result[j]=res.get(j);
        }
        return result;
    }