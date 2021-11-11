package printer;

public class PrinterServiceApp {
    public static void main(String[] args) {

        PrinterService printerService = new PrinterService();             //obiekt
        String textToPrint = "Teks do Wydruku";                           //przykladowy tekst do wydruku

        Printer printer = text -> System.out.println(textToPrint.toUpperCase());
        printerService.PrintContent(printer,textToPrint);

        printerService.PrintContent(text -> System.out.println(text.length()),textToPrint);

    }
}
