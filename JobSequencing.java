//program to implement the jobsequencing
import java.util.*;
class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter deadline and profit for job " + (i + 1));
            int d = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(i + 1, d, p);
        }
        // Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job j : jobs)
            maxDeadline = Math.max(maxDeadline, j.deadline);
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);
        int totalProfit = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
               if (slot[j] == -1) {
                    slot[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        System.out.println("Selected Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i] != -1)
                System.out.print("J" + slot[i] + " ");
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
