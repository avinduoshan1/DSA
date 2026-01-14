public class HanoiTower {

    // Recursive function to solve Tower of Hanoi
    // n: number of disks
    // src: source rod
    // aux: auxiliary/helper rod
    // dest: destination rod
    public static void solveHanoi(int n, char src, char aux, char dest) {
        // Base case: If only 1 disk, move it directly from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }

        // Step 1: Move top n-1 disks from Source to Auxiliary
        solveHanoi(n - 1, src, dest, aux);

        // Step 2: Move the nth (largest) disk from Source to Destination
        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        // Step 3: Move the n-1 disks from Auxiliary to Destination
        solveHanoi(n - 1, aux, src, dest);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // You can change this number
        System.out.println("Solution for " + numberOfDisks + " disks:");
        
        // A = Source, B = Auxiliary, C = Destination
        solveHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}