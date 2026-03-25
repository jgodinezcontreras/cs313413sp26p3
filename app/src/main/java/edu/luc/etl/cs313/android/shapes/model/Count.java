package edu.luc.etl.cs313.android.shapes.model;

/**
 * A visitor to compute the number of basic shapes in a (possibly complex)
 * shape.
 */
public class Count implements Visitor<Integer> {

    // TODO entirely your job

    @Override
    public Integer onPolygon(final Polygon p) {
        return 1;
    }

    @Override
    public Integer onCircle(final Circle c) {
        return 1;
    }

    @Override
    public Integer onGroup(final Group g) {

        int total = 0;
        for (shape child : g.getShapes()){
            total += child.accept(this);}

    }

    @Override
    public Integer onRectangle(final Rectangle q) {

        return 1//shuold return the rectangle that was already made
    }

    @Override
    public Integer onOutline(final Outline o) {
        o.getShape().accept(this);
    }

    @Override
    public Integer onFill(final Fill c) {
        c.getShape().accept(this);
    }

    @Override
    public Integer onLocation(final Location l) {
        return l.getShape().accept(this);}

    @Override
    public Integer onStrokeColor(final StrokeColor c) {
        return c.getShape().accept(this);// these should return the accepted
    }
}
