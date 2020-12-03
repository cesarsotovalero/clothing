package se.kth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PatternTest {

    @Test
    void testCreateAngularCut() {

        // Create a polygon defined by the following lines (ordered clockwise form the bottom left point):
        // (-3, -2), (2, -2);
        // (2, -2), (3, 3);
        // (3, 3), (-2, 3);
        // (-2, 3), (-3, -2)
        List<Line2D.Double> lines = new ArrayList<>();
        lines.add(new Line2D.Double(new Point2D.Double(-3, -2), new Point2D.Double(2, -2)));
        lines.add(new Line2D.Double(new Point2D.Double(2, -2), new Point2D.Double(3, 3)));
        lines.add(new Line2D.Double(new Point2D.Double(3, 3), new Point2D.Double(-2, 3)));
        lines.add(new Line2D.Double(new Point2D.Double(-2, 3), new Point2D.Double(-3, -2)));
        Polygon polygon = new Polygon(lines);

        // Create a vanishing point
        Point2D.Double vanishingPoint = new Point2D.Double(0.0, 0.0);

        // Aperture angle
        int apertureAngle = 45;

        // Get the cut point based on the vanishing point and angle
        Optional<Point2D.Double> cutPoint = new Pattern(polygon).createAngularCut(vanishingPoint, apertureAngle);
        Point2D.Double output = new Point2D.Double(3, 3);

        Assertions.assertTrue(cutPoint.isPresent());
        Assertions.assertEquals(output, cutPoint.get());
    }
}