import java.nio.file.Path;
import java.util.Scanner;

public class InterfaceApp {
    public static final char[] alphabet = {'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я',
            'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',
            '.',',','"',':','-','!','?',' '};
    private static final String encrypt = "Шифрование";
    private static final String decrypt = "Расшифровка";
    private static final String bruteForce = "Криптоанализ";
    private static final String exit = "Выход";
    public static Path path;
    public static int answerKey;

    public static void application() {
        while (true) {
            System.out.println("Выберите один из вариантов: " + encrypt + ", " + decrypt + ", " + bruteForce + " или " + exit + ".");
            Scanner scanner = new Scanner(System.in);
            String answerCrypt = scanner.nextLine();
            if (answerCrypt.equalsIgnoreCase(exit)) {
                System.exit(1);
            }
            if (answerCrypt.equalsIgnoreCase(encrypt)) {
                System.out.println("Введите путь к файлу");
                path = Path.of(scanner.nextLine());
                System.out.println("Введите криптографический ключ");
                answerKey = scanner.nextInt();
                while (answerKey > 73 || answerKey < 0) {
                    if (answerKey > 73) {
                        System.out.println("Введите число поменьше");
                        answerKey = scanner.nextInt();
                    }
                    if (answerKey < 0) {
                        System.out.println("Введите число побольше");
                        answerKey = scanner.nextInt();
                    }
                }
                Encryption.encrypt();
            }
            if (answerCrypt.equalsIgnoreCase(decrypt)) {
                System.out.println("Введите путь к файлу");
                path = Path.of(scanner.nextLine());
                System.out.println("Введите криптографический ключ");
                answerKey = scanner.nextInt();
                while (answerKey > 73 || answerKey < 0) {
                    if (answerKey > 73) {
                        System.out.println("Введите число поменьше");
                        answerKey = scanner.nextInt();
                    }
                    if (answerKey < 0) {
                        System.out.println("Введите число побольше");
                        answerKey = scanner.nextInt();
                    }
                }
                Decryption.decrypt();
            }
            if (answerCrypt.equalsIgnoreCase(bruteForce)) {
                System.out.println("Введите путь к файлу");
                path = Path.of(scanner.nextLine());
                Cryptanalysis.bruteForce();
            }
        }
    }
}
