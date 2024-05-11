package com.context2.recursion;

//	Problem Description
//	Given an N x M matrix, with a few hurdles arbitrarily placed, calculate the length of the longest possible route possible from source to a destination within the matrix. If there is no path exist, return -1. Hurdles are represented as 0.
//	We are allowed to move to only adjacent cells which are not hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
//	You are given the source A, destination B and the matrix C. Return the length of the longest possible route from source to destination
//	Problem Constraints
//	1 <= N <= 10
//	1 <= M <= 10
//	4 <= N*M <= 12
//	0 <= A[0], BIO] < N
//	0 <= A[1], B[1] < M
//	0 <= C[illil <= 1
//	A and B are distinct
//	Input Format
//	First argument is the Source A, which is an integer array of size 2.
//	Second argument is the Destination B, which is an integer array of size 2.
//	Third argument is the Matrix C, which is a 2-D integer array consists of Os and 1s.
//	Output Format
//	Return an Integer, which is the length of the longest possible route.


public class LogestPossibleRouteInMatWithHurdles {

	public int solve(int[] A, int[] B, int[][] C) {
        return solveUtil(A[0], A[1], B[0], B[1], C);
        
    }
    public int solveUtil(int x1, int y1, int x2, int y2, int[][] C){
        if(x1 == x2 && y1==y2){
            return 0;
        }
            int maxLen = -1;
            int[] dx = {0, -1, 1, 0};
            int[] dy = {-1, 0, 0, 1};
            C[x1][y1] = -1;
            for(int i=0; i<4; i++){
                int x = x1+dx[i];
                int y = y1+dy[i];
                if(isValid(x,y,C)){
                    int l = solveUtil(x,y,x2,y2,C);
                    if(l!=-1){
                        maxLen = Math.max(maxLen, l+1);
                    }
                }
                
            }
        
        C[x1][y1] = 1;
        return maxLen;
    }
    
    public boolean isValid(int x, int y, int[][] C){
        if(x>=0 && x<C.length && y>=0 && y<C[0].length && C[x][y]==1){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String[] args) {
    	LogestPossibleRouteInMatWithHurdles lprh = new LogestPossibleRouteInMatWithHurdles();
    	int[][] C = {{1,1,1},{1,1,1},{1,1,1}};
    	int[] A = {0,0};
    	int[] B = {2,2};
    	System.out.println(lprh.solve(A,B,C));
    }
}
