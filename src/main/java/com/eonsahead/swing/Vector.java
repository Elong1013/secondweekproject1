
package com.eonsahead.swing;


/**
 *
 * @author Erlang
 * @version 1 April 2020
 */
/**
 * this classs is used to create 4 element components.
 *
 * @author Erlang Long
 */
public class Vector {

    private double x;
    private double y;
    private double z;
    private double h;

    /**
     * 4 components in Vector = 0
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.h = 0;

    }

    public Vector(double xCoord, double yCoord, double zCoord) {
        xCoord = this.x;
        yCoord = this.y;
        zCoord = this.z;
        this.h = 1;
    }

       public double get(int position) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
        }// switch
        return this.h;
    } // get(int)
       
       
    public void set(int position, double value) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                this.x = value;
            case 1:
                this.y = value;
            case 2:
                this.z = value;
            case 3:
                this.h = value;
        }
    }
    
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " 
                + this.z + ", " + this.h + ")";
    }// toString()
    
    public double dot(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }// dot(Vector v)
    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }// magnitude()
    
    public Vector normalize() {
        double magnitude = this.magnitude();
        Vector newVector = new Vector();
        for(int i = 0; i < 4; i++) {
            double newValue = this.get(i) / magnitude;
            newVector.set(i, newValue);
        }// for
        return newVector;
    }
    
    public Vector cross(Vector v) {
        double newX = this.y * v.z - this.z * v.y;
        double newY = this.z * v.x - this.x * v.z;
        double newZ = this.x * v.y - this.y * v.x;
        return new Vector(newX, newY, newZ);
    }// cross()
    
    
        /**
         * @param args the command line arguments
         */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}