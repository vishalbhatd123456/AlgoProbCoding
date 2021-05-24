public int countInversionsBruteForce(int[] array) {
    // Write your code here.
		//check for sortedness
		if(array.length == 0 || array.length == 1 || array == null){
			return 0;
		}
		int flag = 0;
		int count = 0;
		for(int i = 0;i<array.length;i++){
			for(int j = i+1; j < array.length;j++){
				if(array[i]>array[j]){
					count++;
					flag = 1;
				}
			}
		}
		if(flag == 0){
			return 0;
		}
    return count;
  }

public int countInversionsOptimized(int[] array) {
    //how unsorted the array is!
		//variation of merge sort algorithm
		
		return countSubArrayInversions(array,0,array.length);
		 
  }
	
	public int countSubArrayInversions(int[] array, int start, int end){
		if(end-start <= 1){
			return 0; //one element, 0 inversions
		}
		
		int mid = (start+end)/2;
		int leftiversions = countSubArrayInversions(array, start, mid);
		int rightInversions = countSubArrayInversions(array, mid, end);
		int mergedArrayInversions = mergeSortAndCountInversions(array, start, mid, end);
		return leftiversions + rightInversions + mergedArrayInversions;
	}
	public int mergeSortAndCountInversions(int[] array, int start, int middle, int end){
		List<Integer> sortedArray = new ArrayList<Integer>();
		int left = start;
		int right = mid;
		int inversions = 0;
		
		while(left < middle && right < end){
			if(array[left] <= array[right]){
				sortedArray.add(array[right]);
				right+=1;
			}
		}
		
		for(int idx = left;idx < mid;idx++){
			sortedArray.add(array[idx]);
		}
		
		for(int idx = right; idx < end;idx++){
			sortedArray.add(array[idx]);
		}
		
		for(int idx = 0;idx < sortedArray.size();idx++){
			int num = sortedArray.get(idx);
			array[start + idx ] = num;
		}
		return inversions;
	}
