package animal;

public class AnimalApp {
    public static void main(String[] args) {
        Animal a = new Animal();
        String dog = a.iAmDog();
        System.out.println(dog);

        Animal x = new Animal();
        x.doStuff();
        System.out.println(x);

    }
}
