class Solution {
    List<List<Integer>> brute(int[] nums, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    for (int l = k + 1; l < n; ++l) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            temp.sort(null);
                            quadruplets.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(quadruplets);
        return ans;
    }

    List<List<Integer>> better(int[] nums, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            for (int j = i + 1; j < n; ++j) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; ++k) {
                    int a = nums[i], b = nums[j], c = nums[k];
                    long d = (long) target - a - b - c;
                    if (d >= Integer.MIN_VALUE && d <= Integer.MAX_VALUE && set.contains((int) d)) {
                        List<Integer> temp = Arrays.asList(a, b, c, (int) d);
                        temp.sort(null);
                        quadruplets.add(temp);
                    }
                    set.add(c);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(quadruplets);
        ans.sort((a, b) -> {
            for (int i = 0; i < a.size(); ++i) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0)
                    return cmp;
            }
            return 0;
        });
        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                    } else {
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}