class QuickStart {
    public static void main(String[] args) {
        findLongestSubArrayBySum();
        System.out.println("Hello, World.");
    }

    private int[] findLongestSubArrayBySum(int s, int[] arr){
        int[] result = new int[]{-1};

        int sum = 0;
        int left = 0;
        int right = 0;

        while(right < arr.length){
            sum += arr[right];
            while(sum > s && left < right){
                sum -= arr[left++];
            }

            if(sum == s && (result.length == 1 || right - left > result[1] - result[0])){
                result = new int[]{left, right};
            }

            right++;
        }

        return result;
    }
}