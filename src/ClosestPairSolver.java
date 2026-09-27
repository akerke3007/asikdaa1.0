import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairSolver {

    public static double findClosestPair(Point[] points) {
        Point[] pointsSortedX = points.clone();
        Point[] pointsSortedY = points.clone();
        Arrays.sort(pointsSortedX, Comparator.comparingDouble(Point::getX));
        Arrays.sort(pointsSortedY, Comparator.comparingDouble(Point::getY));
        return closest(pointsSortedX, pointsSortedY, 0, points.length - 1);
    }

    private static double closest(Point[] px, Point[] py, int l, int r) {
        if (r - l <= 3) {
            return bruteForce(px, l, r);
        }

        int mid = l + (r - l) / 2;
        Point midPoint = px[mid];

        Point[] pyl = new Point[mid - l + 1];
        Point[] pyr = new Point[r - mid];
        int li = 0, ri = 0;
        for (Point p : py) {
            if (p.getX() <= midPoint.getX() && li < pyl.length) pyl[li++] = p;
            else if (ri < pyr.length) pyr[ri++] = p;
        }

        double dl = closest(px, pyl, l, mid);
        double dr = closest(px, pyr, mid + 1, r);
        double d = Math.min(dl, dr);

        Point[] strip = new Point[px.length];
        int size = 0;
        for (Point p : py) {
            if (Math.abs(p.getX() - midPoint.getX()) < d) {
                strip[size++] = p;
            }
        }

        double minStripDist = d;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].getY() - strip[i].getY()) < minStripDist; j++) {
                double dist = Point.distance(strip[i], strip[j]);
                if (dist < minStripDist) {
                    minStripDist = dist;
                }
            }
        }

        return Math.min(d, minStripDist);
    }

    private static double bruteForce(Point[] points, int l, int r) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                double dist = Point.distance(points[i], points[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }
}
