import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class Encryption {
    public static void encrypt() {
        Path path = Path.of("resultEncrypt.txt");
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
                if (index + InterfaceApp.answerKey > 73) {
                    int temp = (index + InterfaceApp.answerKey) - 73;
                    index = 0;
                    writer.append(InterfaceApp.alphabet[index + temp - 1]);
                } else {
                    writer.append(InterfaceApp.alphabet[index + InterfaceApp.answerKey]);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }

}
