package printer;

public class PrintToCapitalLetter implements Printer{
    @Override
    public void print(String text) {
        print(text.toUpperCase());
    }
}
