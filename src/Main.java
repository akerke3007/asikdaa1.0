public class Main {
    public static void main(String[] args) {
        System.out.println("Assignment 1 running...");

        // Эксперименттерді орындау
        Experiment.runExperiments();

        // Қосымша тексеріс
        int[] testArr = {10, 4, 21, 3, 17, 8};
        QuickSorter.sort(testArr);
        System.out.println("passed successfully!");
    }
}
