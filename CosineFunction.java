import java.awt.*;

public class CosineFunction extends Function{
    @Override
    public double evaluate(double x) {
        return Math.cos(x);
    }
    public CosineFunction(Color color){
        StdDraw.setPenColor(color);
    }

    @Override
    public void plot(int xmin, int ymin, double width) {
        super.plot(xmin, ymin, width);
    }
}
