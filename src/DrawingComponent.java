import java.awt.*;

public class DrawingComponent {

    private int x;
    private int y;
    private int radius = 4;
    private Color color;

    public DrawingComponent(){

    }

    public DrawingComponent(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadius(){
        return radius;
    }

    public Color getColor(){
        return color;
    }

    public void setRadius(int newRadius){
        radius = newRadius;
    }

    public String toString(){
        return x + " " + y + " " + radius + " " + color.toString();
    }



}
