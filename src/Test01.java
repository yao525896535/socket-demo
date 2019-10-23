public class Test01 {
    public static void main(String[] args) {
        Cylinder y1 = new Cylinder();
        Cylinder y2 = new Cylinder(100,20);
        y1.print();
        y2.print();
    }
}
class Cylinder{
    private double height;
    private double radius;
    private double area;
    private double tj;

    public Cylinder(){

    }
    public Cylinder(double height,double radius){
        this.radius = radius;
        this.height = height;
    }
    public double getHeight(){
        return height;
    }
    public double getRadius() {
        return radius;
    }

    public double getArea() {
        area = 2*3.14*radius*height+2*3.14*radius*radius;
        return area;
    }

    public double getTj() {
        tj = 3.14*radius*radius*height;
        return tj;
    }

    public void print(){
        System.out.println("圆的高"+getHeight());
        System.out.println("圆的半径"+getRadius());
        System.out.println("圆的体积"+getTj());
        System.out.println("圆的表面积"+getArea());

    }
}
