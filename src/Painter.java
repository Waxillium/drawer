import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Painter extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener, ActionListener {

    private int x = -10, y = -10;//x and y coordinates of mouse
    private DrawingComponent tool;
    private int width = 480, height = 600;
    private JPanel pane;
    private int xOffset = 5;
    private int yOffset = 30;
    private ArrayList<DrawingComponent> history;

    public Painter(){
        setTitle("Awesome Raymond is cool");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tool = new DrawingComponent();
        history = new ArrayList<DrawingComponent>();

        //setup layout with canvas and buttons
        JButton send = new JButton("Send");
        send.addActionListener(this);
        Container canvas = this.getContentPane();
        pane = new JPanel();
        pane.add(send);

        canvas.setLayout(new BorderLayout());
        canvas.add(pane, BorderLayout.SOUTH);

        //configure the mouse
        canvas.addMouseMotionListener(this);
        canvas.addMouseWheelListener(this);
        canvas.addMouseListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String act = e.getActionCommand();
        if(act.equals("send")){

        }
    }

    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e){
        x = e.getX();
        x -= tool.getRadius()/2;
        y = e.getY();


        System.out.println(x);
        repaint();//calls paint method with graphics parameter

    }

    public void mouseWheelMoved(MouseWheelEvent e){
        System.out.println(tool.getRadius() + " " + e.getWheelRotation());
        tool.setRadius(tool.getRadius() - e.getWheelRotation());
        if(tool.getRadius() <= 2){
            tool.setRadius(2);
        }
    }

    public void paint(Graphics g){
        int drawX = x + xOffset;
        int drawY = y + yOffset;
        int drawRadius = tool.getRadius();
        Color drawColor = g.getColor();
        DrawingComponent _x = new DrawingComponent(drawX, drawY, drawRadius, drawColor);
        history.add(_x);
        g.fillOval(drawX, drawY, drawRadius, drawRadius);

    }

    public static void main(String args[]){
        Painter p = new Painter();
    }

}
