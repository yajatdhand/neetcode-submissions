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
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while(j < k){
                int a = nums[i], b = nums[j], c = nums[k];
                int sum = a + b + c;
                if(sum == 0){
                    ans.add(List.of(a, b, c));
                    j++; k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                } else if(sum < 0){
                    j++;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                } else {
                    k--;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}
