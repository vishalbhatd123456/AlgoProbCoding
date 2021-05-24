public static int[] twoNumberSum1(int[] array, int targetSum) {
    Arrays.sort(array);
		int left = 0;
		int right = array.length-1;
		
		while(left < right){
			int currSum = array[left] + array[right];
			if(currSum == targetSum){
				return new int[]{array[left], array[right]};
			}else if(currSum < targetSum){
				left++;
			}else if(currSum > targetSum){
				right--;
			}
		}
		return new int[0];public static int[] twoNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);
		int left = 0;
		int right = array.length-1;
		
		while(left < right){
			int currSum = array[left] + array[right];
			if(currSum == targetSum){
				return new int[]{array[left], array[right]};
			}else if(currSum < targetSum){
				left++;
			}else if(currSum > targetSum){
				right--;
			}
		}
		return new int[0];
    }
  
  public static int[] twoNumberSum2(int[] array, int targetSum) {
    // Write your code here.
		for(int i = 0;i<array.length;i++){
			int fNum = array[i];
			for(int j = i+1;j<array.length;j++){
				int sNum = array[j];
				if(fNum + sNum == targetSum){
					return new int []{array[i], array[j]};
				}
			}
		}
    return new int[0];
  }
  public static int[] twoNumberSum3(int[] array, int targetSum) {
   Set<Integer> hashSet = new HashSet<>();
	 for(int num : array){
		 if(hashSet.contains(targetSum - num)){
			 return new int[]{targetSum-num, num};
		 }else{
			hashSet.add(num);
		 }
	 }
		return new int[0];
  }
