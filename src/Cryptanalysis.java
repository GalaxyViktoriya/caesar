import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cryptanalysis {
    public static void bruteForce() {
        Path path = Path.of("resultCryptanalysis.txt");
        try {
            Files.createFile(path);
        } catch (IOException E) {
            System.out.println("Файл уже существует");
        }
        try (FileReader in = new FileReader(InterfaceApp.path.toFile());
             BufferedReader reader = new BufferedReader(in);
             FileWriter out = new FileWriter(path.toFile());
             BufferedWriter writer = new BufferedWriter(out))
        {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
            int key = 0;
            for (int i = 0; i < 73; i++) {
                int ind = new String(InterfaceApp.alphabet).indexOf(builder.charAt(builder.length() - 1));
                if (ind != 72 & ind != 71 & ind != 66) {
                    key++;
                    for (int j = 0; j < builder.length(); j++) {
                        int index = new String(InterfaceApp.alphabet).indexOf(builder.charAt(j));
                        if (index - 1 < 0) {
                            int temp = -(index - 1);
                            index = 73;
                            builder.deleteCharAt(j);
                            builder.insert(j, InterfaceApp.alphabet[index - temp + 1]);
                        } else {
                            builder.deleteCharAt(j);
                            builder.insert(j, InterfaceApp.alphabet[index - 1]);
                        }
                    }
                    continue;
                }
                if (new String(InterfaceApp.alphabet).indexOf(builder.charAt(0)) > 32) {
                    key++;
                    for (int j = 0; j < builder.length(); j++) {
                        int index = new String(InterfaceApp.alphabet).indexOf(builder.charAt(j));
                        if (index - 1 < 0) {
                            int temp = -(index - 1);
                            index = 73;
                            builder.deleteCharAt(j);
                            builder.insert(j, InterfaceApp.alphabet[index - temp + 1]);
                        } else {
                            builder.deleteCharAt(j);
                            builder.insert(j, InterfaceApp.alphabet[index - 1]);
                        }
                    }
                    continue;
                }
                for (int j = 1; j < builder.length()-1; j++) {
                    int index1 = new String(InterfaceApp.alphabet).indexOf(builder.charAt(j-1));
                    int index2 = new String(InterfaceApp.alphabet).indexOf(builder.charAt(j));
                    int index3 = new String(InterfaceApp.alphabet).indexOf(builder.charAt(j+1));
                    if (index2 == 66) {
                        if (index3 != 73)  {
                            key++;
                            for (int k = 0; k < builder.length(); k++) {
                                int index = new String(InterfaceApp.alphabet).indexOf(builder.charAt(k));
                                if (index - 1 < 0) {
                                    int temp = -(index - 1);
                                    index = 73;
                                    builder.deleteCharAt(k);
                                    builder.insert(k, InterfaceApp.alphabet[index - temp + 1]);
                                } else {
                                    builder.deleteCharAt(k);
                                    builder.insert(k, InterfaceApp.alphabet[index - 1]);
                                }
                            }
                        }
                        break;
                    }
                    if (index2 == 73) {
                        if (index1 < 33 || index1 > 65) {
                            key++;
                            for (int k = 0; k < builder.length(); k++) {
                                int index = new String(InterfaceApp.alphabet).indexOf(builder.charAt(k));
                                if (index - 1 < 0) {
                                    int temp = -(index - 1);
                                    index = 73;
                                    builder.deleteCharAt(k);
                                    builder.insert(k, InterfaceApp.alphabet[index - temp + 1]);
                                } else {
                                    builder.deleteCharAt(k);
                                    builder.insert(k, InterfaceApp.alphabet[index - 1]);
                                }
                            }
                        }
                        break;
                    }
                }
            }
            System.out.println("Ваш ключ " + key);
            for (int i = 0; i < builder.length(); i++){
                writer.append(builder.charAt(i));
            }
        }
        catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}
