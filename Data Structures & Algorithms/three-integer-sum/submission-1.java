class Solution {
    List<List<Integer>> brute(int[] nums){
        Set<List<Integer>> triplets = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                for(int k = j + 1; k < n; ++k){
                    int a = nums[i], b = nums[j], c = nums[k];
                    if(a + b + c == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(c);
                        temp.sort(null);
                        triplets.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(triplets);
        return ans;
    }

    List<List<Integer>> better(int[] nums){
        Set<List<Integer>> triplets = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < n; ++j){
                int a = nums[i], b = nums[j];
                int c = - (a + b);
                if(set.contains(c)){
                    List<Integer> temp = new ArrayList<>(List.of(a, b, c));
                    temp.sort(null);
                    triplets.add(temp);
                }
                set.add(b);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(triplets);
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return better(nums);
    }
}
