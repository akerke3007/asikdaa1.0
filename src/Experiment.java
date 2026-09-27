import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Experiment {
    public static void runExperiments() {
        int[] sizes = {100, 1000, 5000, 10000};

        // results папкасының бар екенін тексеру, жоқ болса жасау
        File dir = new File("results");
        if (!dir.exists()) {
            dir.mkdir();
        }

        try (FileWriter writer = new FileWriter("results/results.csv")) {
            writer.append("Algorithm,Size,Type,TimeNano\n");

            for (int n : sizes) {
                int[] randomData = generateRandomArray(n);

                // MergeSort тест
                long start = System.nanoTime();
                MergeSorter.sort(randomData.clone());
                long time = System.nanoTime() - start;
                writer.append("MergeSort," + n + ",Random," + time + "\n");

                // QuickSort тест
                start = System.nanoTime();
                QuickSorter.sort(randomData.clone());
                time = System.nanoTime() - start;
                writer.append("QuickSort," + n + ",Random," + time + "\n");
            }
            System.out.println("Эксперименттер сәтті аяқталды! Нәтижелер results/results.csv файлына жазылды.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }
}