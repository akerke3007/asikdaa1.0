# Assignment 1: Divide-and-Conquer Algorithm Analysis

## A. Project Overview
* **Purpose**: The objective of this assignment is to implement, analyze, and benchmark classic divide-and-conquer algorithms in Java, maintaining a structured GitHub workflow and documenting results thoroughly.
* **Implemented Algorithms**:
    1. MergeSort (with linear merge, reusable buffer, and insertion sort cutoff)[cite: 1].
    2. QuickSort (with randomized pivot and tail-recursion optimization)[cite: 1].
    3. Deterministic Select / Median-of-Medians (groups of 5)[cite: 1].
    4. Closest Pair of Points (divide-and-conquer approach)[cite: 1].

## B. Algorithm Analysis
* **MergeSort**: Divides the array into two halves, recursively sorts them, and merges them. Time complexity: $\Theta(n \log n)$, Space complexity: $O(n)$. Recurrence relation: $T(n) = 2T(n/2) + \Theta(n)$ (solved via Master Theorem, Case 2).
* **QuickSort**: Picks a randomized pivot, partitions the array, and recursively sorts partitions. Expected time complexity: $O(n \log n)$, worst-case: $O(n^2)$.
* **Deterministic Select**: Uses the median-of-medians pivot to guarantee a worst-case linear time complexity of $\Theta(n)$.
* **Closest Pair of Points**: Sorts points by x-coordinate, recursively finds the minimum distance in left and right halves, and checks a vertical strip. Time complexity: $\Theta(n \log n)$.

## C. Experimental Results
* The experiments were conducted on various input sizes ($n = 100, 1000, 5000, 10000$) and data types[cite: 1].
* Execution times and recursion depths were measured using `System.nanoTime()` and saved to `results/results.csv`[cite: 1].
* **Plots**: Performance charts are stored in the `plots/` directory (e.g., `plots/chart.png`)[cite: 1].

## D. Discussion
* **Theoretical vs. Practical Performance**: Empirical results align with theoretical complexities, though JVM warmup and garbage collection introduce minor overheads.
* **Input Structure**: Sorted and duplicate-heavy arrays behave differently depending on pivot selection and partitioning strategies.
* **Smaller-first recursion in QuickSort**: Helps maintain a maximum recursion depth of $O(\log n)$, preventing stack overflow errors.

## E. Reflection
* Working on this assignment improved our understanding of divide-and-conquer paradigms, memory management in Java, and empirical performance analysis. The main challenges included handling edge cases in the Closest Pair strip check and implementing the Median-of-Medians pivot efficiently.

## F. Screenshots
* Program output, test results, and plots are available in the `screenshots/` and `plots/` directories[cite: 1].