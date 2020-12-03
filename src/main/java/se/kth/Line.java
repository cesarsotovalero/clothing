package se.kth;


/**
 * A line, defined as: y = mx + n
 */
class Line {

    private final double m;
    private final double n;

    public Line(double m, double n) {
        this.m = m;
        this.n = n;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.m = (y2 - y1) / (x2 - x1);
        this.n = y1 - x1 * this.m;
    }

    public double m() {
        return m;
    }

    public double n() {
        return n;
    }

    @Override
    public String toString() {
        return "y = " + m + "x + " + n;
    }
}