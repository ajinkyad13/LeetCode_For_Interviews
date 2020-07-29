package design_data_structure_questions;

import java.util.PriorityQueue;

/*
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the 
 * sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which 
 * contains initial elements from the stream. For each call to the method KthLargest.add, return the element 
 * representing the kth largest element in the stream.
 * 
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */

public class KthLargestElementInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();;
    int k;
    
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        
        for(int num : nums)
            minHeap.offer(num);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        while(minHeap.size() > k)
            minHeap.poll();
        
        return minHeap.peek();
    }
	
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, arr);
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
	}

}
