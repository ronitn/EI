// Target interface that the client expects to work with
interface Printer {
    void print(String document);
}

// Adaptee class (the existing class with an incompatible interface)
class LegacyPrinter {
    public void printLegacy(String doc) {
        System.out.println("Printing using LegacyPrinter: " + doc);
    }
}

// Adapter class that makes LegacyPrinter compatible with the Printer interface
class PrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    // Constructor that takes the legacy printer instance
    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    // Implement the print method expected by the Printer interface
    @Override
    public void print(String document) {
        // Delegate the call to the legacy printer's method
        legacyPrinter.printLegacy(document);
    }
}

// Main class to test the Adapter Pattern
class AdapterPatternDemo {
    public static void main(String[] args) {
        // Create an instance of the legacy printer
        LegacyPrinter legacyPrinter = new LegacyPrinter();

        // Create an adapter for the legacy printer
        Printer printer = new PrinterAdapter(legacyPrinter);

        // Use the adapter to print a document, as expected by the modern Printer interface
        printer.print("Adapter Pattern Example Document");
    }
}
