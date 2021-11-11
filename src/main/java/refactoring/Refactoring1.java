package refactoring;

public class Refactoring1 {
    public static void main(String[] args) {
        Refactoring1 c = new Refactoring1();
        boolean compare = c.max(5, 10);
        System.out.println(compare);
    }
//    public boolean max ( int a, int b){
//        if (a>b){
//            return true;
//        }else if (a==b){
//            return false;
//        }else {
//            return false;
//        }
//    }
    public boolean max (int a , int b){
        return a > b;
    }
}
