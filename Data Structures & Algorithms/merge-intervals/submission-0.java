class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!list.isEmpty() && start <= list.getLast()[1]) continue;

            for(int j = i + 1; j < n; ++j){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                } else break;
            }
            list.add(new int[]{start, end});
        }

        int[][] ans = new int[list.size()][2];
        int idx = 0;
        for(int[] e : list){
            ans[idx++] = e;
        }
        return ans;
    }
}
