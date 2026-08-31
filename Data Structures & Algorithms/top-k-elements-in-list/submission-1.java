class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        //1 = 2, 2 = 3, 3 = 4
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer frequency = entry.getValue();
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }

        int[] res = new int[k];
        int count = 0;
        for(int i = buckets.length - 1; i >= 0; --i){
            if(buckets[i] != null){
               for (Integer e : buckets[i]){
                   res[count] = e;
                   count++;

                   if (count == k) return res;
               }
            }
        }
        return res;
    }
}
