class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public boolean isYellow(int[] signals, int curr_time) {
        return (signals[0] < curr_time && signals[1] >= (curr_time - signals[0]));
    }
    
    public int solution(int[][] signals) {
        int lcm = 1;
        
        int[] signalPeriod = new int[signals.length];
        
        for (int i = 0; i < signals.length; i++) {
            signalPeriod[i] = signals[i][0] + signals[i][1] + signals[i][2];
            lcm = (signalPeriod[i] * lcm) / gcd(signalPeriod[i], lcm);
        }
                
        for (int i = 0; i < lcm; i++) {
            int j = 0;
            for (; j < signals.length; j++) {
                if (!isYellow(signals[j], i % signalPeriod[j]))
                    break;
            }
            if (j == signals.length)
                return i;
        }
        return -1;
    }
}