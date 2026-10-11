class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        for(int[] e : intervals){
            if(list.isEmpty() || e[0] > list.getLast()[1]){
                list.add(new int[]{e[0], e[1]});
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], e[1]);
            }
        }

        int[][] ans = new int[list.size()][2];
        int idx = 0;
        for(int[] e : list){
            ans[idx++] = e;
        }
        return ans;   
    }
}
