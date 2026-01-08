public class RabbitProblem {

    // Recursive solution to calculate Fibonacci number
    // Month 0 = 0, Month 1 = 1, Month 2 = 1, Month 3 = 2, etc.
    public static int getRabbitPairs(int months) {
        if (months == 0) return 0;
        if (months == 1) return 1;
        
        // F(n) = F(n-1) + F(n-2)
        return getRabbitPairs(months - 1) + getRabbitPairs(months - 2);
    }

    // Iterative solution (More efficient for large numbers)
    public static int getRabbitPairsIterative(int months) {
        if (months <= 1) return months;
        
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= months; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int months = 10;
        
        System.out.println("Calculating Rabbit pairs after " + months + " months.");
        
        // Using Recursion
        int pairs = getRabbitPairs(months);
        System.out.println("Total Pairs (Recursive): " + pairs);
        
        // Using Iteration
        int pairsIter = getRabbitPairsIterative(months);
        System.out.println("Total Pairs (Iterative): " + pairsIter);
    }
}