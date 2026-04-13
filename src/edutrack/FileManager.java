package edutrack;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveStudents(DataManager manager) {
        try {
            FileWriter writer = new FileWriter("students.txt");

            for (Student s : manager.getStudents()) {
                writer.write(s.getId() + "," + s.getName() + "\n");
            }

            writer.close();
            System.out.println("Students saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
}