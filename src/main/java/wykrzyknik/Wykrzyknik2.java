package wykrzyknik;

public class Wykrzyknik2 {
    public static void main(String[] args) {
        String exclaim = addExclamationMark("hot dog");
        System.out.println(exclaim.toUpperCase());
    }

    public static String addExclamationMark(String s){
        return s + " !";
    }
}

