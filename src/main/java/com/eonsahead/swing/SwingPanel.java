package com.eonsahead.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwingPanel extends JPanel implements ActionListener {

    private double centerX = 0.0;
    private double centerY = 0.0;
    private double radius = 0.2;
    private double deltaY = 0.02;
    private double deltaX = 0.06;
    private Color color = Color.red;

    public SwingPanel() {
        Timer timer = new Timer(40, this);
        timer.start();
    } // SwingPanel()

    public double getCenterX() {
        return this.centerX;
    } // getCenterX()

    public void setCenterX(double x) {
        this.centerX = x;
    } // setCenterX( double )

    public double getCenterY() {
        return this.centerY;
    } // getCenterY()

    public void setCenterY(double y) {
        this.centerY = y;
    } // setCenterY( double )

    public double getRadius() {
        return this.radius;
    } // getRadius()

    public void setRadius(double r) {
        this.radius = r;
    } // setRadius( double )

    public Color getColor() {
        return this.color;
    } // getColor()

    public void setColor(Color c) {
        this.color = c;
    } // setColor( Color )
    
   

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);
        AffineTransform rotate = new AffineTransform();
        double angle = 0;
        rotate.setToRotation(angle, 0, 0);
        
        transform.concatenate(scaling);
        transform.concatenate(translation);
        transform.concatenate(rotate);
        // Replace this block of code that creates
        // an ellipse with your own code that draws
        // something else
        // Make sure that all geometry fits in a square
        // whose corners are (-1, -1) and (+1, +1)
        
        double d = 2 * this.radius;
        double ulx1 = this.centerX - this.radius;
        double uly1 = this.centerY - this.radius+0.4;
        double ulx2 = this.centerX - this.radius;
        double uly2 = this.centerY - this.radius+0.2;
        double ulx3 = this.centerX - this.radius;
        double uly3 = this.centerY - this.radius+0.8;
        Rectangle2D.Double Rect1 = new Rectangle2D.Double(ulx1, uly1, d, d);
        Rectangle2D.Double Rect2 = new Rectangle2D.Double(ulx2, uly2, d, d);
        Ellipse2D.Double circle1 = new Ellipse2D.Double(ulx3, uly3, d, d);
        Shape shape1 = transform.createTransformedShape(Rect1);
        Shape shape2 = transform.createTransformedShape(Rect2);
        Shape shape3 = transform.createTransformedShape(circle1);
        g2D.setColor(this.getColor());
        g2D.fill(shape1);
        g2D.fill(shape2);
        g2D.fill(shape3);
    } // paintComponent( Graphics )

    @Override
    public void actionPerformed(ActionEvent event) {
        // You might also like to try what happens
        // in each step of the animation
        // Move? In which direction? How much?
        // Make bigger? Or make smaller?
        // Rotate? (There's an AffineTransform for that, too.)
        // Change color?

        if (this.centerX > 0.5) {
            this.deltaX = -this.deltaX;
        } // if
        else if (this.centerX < -0.5) {
            this.deltaX = -this.deltaX;
        } // else if
        this.centerX += this.deltaX;

        this.repaint();
    } // actionPerformed( ActionEvent )

} // SwingPanel
