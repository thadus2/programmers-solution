class Solution {
    public int gcp(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public boolean check_yellow(int[] signals, int curr_time) {
        return (signals[0] < curr_time && signals[1] >= (curr_time - signals[0]));
    }
    
    public int solution(int[][] signals) {
        int lcm = 1;
        
        int[] signal_size = new int[signals.length];
        
        for (int i = 0; i < signals.length; i++) {
            signal_size[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = (signal_size[i] * lcm) / gcp(signal_size[i], lcm);
        }
                
        for (int i = 0; i < lcm; i++) {
            int j = 0;
            for (; j < signals.length; j++) {
                if (!check_yellow(signals[j], i % signal_size[j]))
                    break;
            }
            if (j == signals.length)
                return i;
        }
        return -1;
    }
}