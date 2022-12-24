import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class Decryption {
    public static void decrypt() {
        Path path = Path.of("resultDecrypt.txt");
        try {
            Files.createFile(path);
        }
        catch (IOException e) {
            System.out.println("Файл уже существует");
        }
        try (FileReader in = new FileReader(InterfaceApp.path.toFile());
             BufferedReader reader = new BufferedReader(in);
             FileWriter out = new FileWriter(path.toFile());
             BufferedWriter writer = new BufferedWriter(out))
        {
            while (reader.ready()) {
                int index = new String(InterfaceApp.alphabet).indexOf(reader.read());
                if (index - InterfaceApp.answerKey < 0) {
                    int temp = -(index - InterfaceApp.answerKey);
                    index = 73;
                    writer.append(InterfaceApp.alphabet[index - temp + 1]);
                } else {
                    writer.append(InterfaceApp.alphabet[index - InterfaceApp.answerKey]);
                }
            }
        }
        catch (IOException E) {
            System.out.println("Файл не найден");
        }
    }
}
