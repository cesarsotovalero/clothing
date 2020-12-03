package se.kth;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Optional;

/**
 * A Pattern is as a polygon, a vanishing point, and the aperture angle.
 */
public class Pattern {

    private final Polygon polygon;
    private final Point2D.Double vanishingPoint;
    private final double apertureAngle;

    /**
     * Ctor.
     *
     * @param polygon A {@link se.kth.Polygon}
     * @param vanishingPoint A vanishing point {@link java.awt.geom.Point2D}
     * @param apertureAngle The angle with respect to the the x-axis
     */
    public Pattern(Polygon polygon, Point2D.Double vanishingPoint, double apertureAngle) {
        this.polygon = polygon;
        this.vanishingPoint = vanishingPoint;
        this.apertureAngle = apertureAngle;
    }

    /**
     * Creates an angular cut in a {@link se.kth.Polygon}
     *
     * @return A {@link java.awt.geom.Point2D}, the cut point of the {@link se.kth.Polygon}
     */
    public Optional<Point2D.Double> createAngularCut() {
        Line line1 = line(apertureAngle, vanishingPoint);
        Optional<Point2D.Double> cutPoint = Optional.empty();
        for (Line2D l : polygon.lines()) {
            Line cutLine = new Line(l.getX1(), l.getY1(), l.getX2(), l.getY2());
            cutPoint = intersectionPoint(line1, cutLine);
            if (cutPoint.isPresent() && cutPoint.get().getX() >= 0 && cutPoint.get().getY() >= 0) {
                System.out.printf("Intercept with line %s in the pattern is (%f, %f)%n",
                        cutLine.toString(), cutPoint.get().getX(), cutPoint.get().getY()
                                 );
                return cutPoint;
            }
        }
        return cutPoint;
    }

    /**
     * Creates a {@link se.kth.Line} based on an angle and a {@link java.awt.geom.Point2D}.
     *
     * @param angle The angle with respect to the x-axis
     * @param point A point that belongs to the line
     * @return A line defined as: y = mx + n
     */
    private static Line line(double angle, Point2D.Double point) {
        double m = Math.tan(Math.toRadians(angle));
        double n = point.getX() - (m * point.getY());
        return new Line(m, n);
    }

    /**
     * Compute the interception {@link java.awt.geom.Point2D} between two {@link se.kth.Line} in the Cartesian space.
     *
     * @param l1 A line defined as: y = mx + n
     * @param l2 A line defined as: y = mx + n
     * @return If there is an interception, returns the intersection point between the lines, otherwise returns and
     * empty Optional
     */
    private static Optional<Point2D.Double> intersectionPoint(Line l1, Line l2) {
        if (l1.m() == l2.m()) {
            return Optional.empty();
        }
        double x = (l2.n() - l1.n()) / (l1.m() - l2.m());
        double y = l1.m() * x + l1.n();
        Point2D.Double point = new Point2D.Double();
        point.setLocation(x, y);
        return Optional.of(point);
    }
}