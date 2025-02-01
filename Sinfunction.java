import java.awt.*;

public class Sinfunction extends Function{
    @Override
    public double evaluate(double x) {
        return Math.sin(x);
    }
    public Sinfunction(Color color){
        StdDraw.setPenColor(color);
    }

    @Override
    public void plot(int xmin, int ymin, double width) {
        super.plot(xmin, ymin, width);
    }
}

