package se.kth;

import java.awt.geom.Line2D;
import java.util.List;

/**
 * A Polygon, defined as a list of {@link se.kth.Line} objects.
 * We assume that the lines intercept each other.
 */
class Polygon {

    private final List<Line2D.Double> lines;

    public Polygon(List<Line2D.Double> lines) {
        this.lines = lines;
    }

    public List<Line2D.Double> lines() {
        return lines;
    }
}