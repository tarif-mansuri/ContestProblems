package com.context2.recursion;

public class SortStrings {
	public String[] solve(String[] A) {
        quickSort(A, 0, A.length);
        return A;
    }
    
    public void quickSort(String[] A, int l, int r){
        if(l<=r){
            int p = partition(A, l, r);
            quickSort(A, l, p-1);
            quickSort(A, p+1, r);
        }
    }
    
    public int partition(String[] A, int l, int r){
        String p = A[l];
        int ind = l;
        l++;
        while(l<=r){
            if(A[l].length() < p.length()){
                l++;
            }else if(A[r].length()>p.length()){
                r--;
            }else{
                swap(A, l,r);
                l++;
                r--;
            }
        }
        swap(A, ind, r);
        return r;
    }
    public void swap(String[] A, int i, int j){
        String x = A[i];
        A[i] = A[j];
        A[j] = x;
    }
    
    public static void main(String[] args) {
    	String[] A = {"g", "psv", "kg","lwf", "uf", "e", "u", "qt", "u"};
    	SortStrings sq =new SortStrings();
    	sq.solve(A);
    	for(int i=0; i<A.length; i++) {
    		System.out.print(A[i]+" ");
    	}
    }

}
