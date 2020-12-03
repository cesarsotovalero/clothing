# Clothing

### Input

- The coordinates of a list of points that define a pattern. The pattern is modelled as a polygon. The polygon is constructed by drawing lines between each pair of points clockwise, starting from the leftmost point. For example, the following points define a pattern which shape is a parallelogram:

```
(-3, -2), (2, -2)   
(2, -2), (3, 3)
(3, 3), (-2, 3)
(-2, 3), (-3, -2)
```
- The coordinates of a vanishing point. For simplicity, we assume the coordinates are in `(0, 0)`.
- The cut's aperture angle as a floating-point `P`. For simplicity, we assume the angle is in the first quadrant:  `0 <= P <= 90`

### Output

The coordinates of the cut point for the pattern. 








