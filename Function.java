import java.awt.Color;
public class Function {
    public double evaluate(double x){
        return x;
    }
    public Color color;
    public void plot(int xmin,int xmax, double width){
        double dx = (xmax-xmin) / width;
        double x = xmin;
        while (x < xmax){
            StdDraw.line(x,evaluate(x),x+dx,evaluate(x + dx));
            x += dx;
        }
    }
    public Function(Color color){
        this.color = color;
    }
    public Function(){
        this(Color.magenta);


    }

}
