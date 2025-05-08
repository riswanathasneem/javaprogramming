package riswana;
class OverLoadDemo{
    void area(float x){
        System.out.println("The area of the square is "+Math.pow(x,2));
    }
    void area(float x,float y){
        System.out.println("The area of the rectangle is "+x*y);
    }
    void area(double x){
        double z= 3.14*x*x;
        System.out.println("The area of the circle is "+ z);
    }
}

class OverLoad{
    public static void main(String args[]){
        OverLoadDemo ob=new OverLoadDemo();
        ob.area(5);
        ob.area(11,12);
        ob.area(2.5);
    }
}