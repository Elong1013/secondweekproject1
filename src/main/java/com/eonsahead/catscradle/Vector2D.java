package com.eonsahead.catscradle;

import static java.lang.Math.sqrt;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
/**
 * This class models a vector in two dimensions.
 *
 *
 * <p>
 * Like a length (feet and inches), weight (pounds and ounces), time (hours and
 * minutes), fraction (numerator and denominator), a complex number (real and
 * imaginary parts), a 2D vector is a thing with two parts that can be added.
 * </p>
 *
 * <img src="../../../src/vector2d/Vector2D.png" alt="UML class diagram">
 *
 * @author CSC140 Foundations of Computer Science
 * @version 6 March 2013
 */
public class Vector2D {

    private double x;
    private double y;

    /**
     * we defind a coordinator by x and y variables
     *
     * @param x x represent the length of this point on x-axis
     * @param y y represent the length of this point on y-axis
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;

    } // Vector2D( double, double )

    /**
     * the add method for adding one point with another one
     *
     * <p>
     * in matrix operation, addition means u+v = (u_x + v_x, u_y + v_y)
     *
     * @param v the variable we used to store another point
     * @return the sum of two matrix
     */
    public Vector2D add(Vector2D v) {
        double xCoord = this.x + v.x;
        double yCoord = this.y + v.y;

        return new Vector2D(xCoord, yCoord);
    } // add (Vector2D )

    /**
     * multipling this coordinator with a constant number
     *
     * <p>
     * Multiplication in Matrix =(u_x * xFactor , u_y * yFactor)
     *
     * @param xFactor constant number used for multipling with x cooridnator
     * @param yFactor constant number used for multipling with y cooridnator
     * @return New vector after stretching
     */
    public Vector2D scale(double xFactor, double yFactor) {
        double xCoord = this.x * xFactor;
        double yCoord = this.y * yFactor;
        return new Vector2D(xCoord, yCoord);
    } // scale( double )

    /**
     * if we have a amount used to stretch the whole one vector on both x and y
     * numbers. we just need one parameter
     *
     * produce a new vector with one parameter:(factor * u_x, factor * u_y).
     *
     * @param factor a parameter used for multipling
     * @return
     */
    public Vector2D scale(double factor) {
        double xCoord = this.x * factor;
        double yCoord = this.y * factor;
        return new Vector2D(xCoord, yCoord);
    } // scale( double )

    /**
     * if we want to make vector rotate, we need to use angle as a parameter to
     * let vector rotate
     *
     * the rule of rotation is x = u_x * cos( psi ) - u_y * sin( psi ) y = u_x *
     * sin( psi ) - u_y * cos( psi )
     *
     * @param angle angle used for rotation
     * @return the same vector after rotation.
     */
    public Vector2D rotate(double angle) {
        double xCoord = this.x * cos(angle) - this.y * sin(angle);
        double yCoord = this.x * sin(angle) - this.y * cos(angle);

        return new Vector2D(xCoord, yCoord);
    } // rotate( double )

    /**
     * doing rotation scale and tranformation together
     *
     * @param angle angle used for rotation
     * @param scaleX constant number used for multipling with x cooridnator
     * @param scaleY constant number used for multipling with y cooridnator
     * @param deltaX distance moved in the x direction.
     * @param deltaY distance moved in the y direction.
     * @return a new vector after these 3 steps
     */
    public Vector2D rotateScaleTranslate(double angle, double scaleX,
            double scaleY, double deltaX, double deltaY) {
        Vector2D rotation = this.rotate(angle);
        Vector2D scale = rotation.scale(scaleX, scaleY);

        return scale.add(new Vector2D(deltaX, deltaY));
    } // rotateScaleTranslate( double, double, double, double, double )

    /**
     * the dot product applied at here
     *
     * u = (u_x, u_y) v = (v_x, v_y) u * v = u_x v_x + u_y v_y
     *
     * @param v is another vector in dot product with this vector 
     * @return a scalar will be printed out
     */
    public double dot(Vector2D v) {
        double u = this.x * v.x + this.y * v.y;
        return (u);
    } // dot( Vector2D )
    /**
     * Pascal triangle theorem is applied at here for calculating the 
     * magnitude
     * sqrt(this.dot(this))
     * @return 
     */
    public double magnitude() {
        double dotU = this.x * this.x + this.y * this.y;
        double magnitude = sqrt(dotU);

        return (magnitude);
    } // magnitude()
    
    /**
     * this method is used to record only x component 
     * @return a number of x component of one vector
     */
    public double getX() {
//        return this.x;
        double Xcoord = this.x;
        return (Xcoord);
    } // getX()
    
    /**
     * this method is used to record only y component 
     * @return a number of y component of one vector
     */
    public double getY() {
        double Ycoord = this.y;
        return (Ycoord);

    } // getY()
    
    /**
     * used to print our result as a string 
     * @return our result will be printed out like a printable string 
     */
    @Override
    public String toString() {

        return "(" + this.x + "," +this.y + "}";
    } // toString()
    
    /**
     * used to  execute our code 
     * @param args an array 
     */
    public static void main(String[] args) {
        Vector2D a = new Vector2D(3, 4);
        Vector2D b = new Vector2D(5, 12);

        System.out.println("magnitude of a " + a.magnitude());
        

    } // main( String [] )
} // Vector2D