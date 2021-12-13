package filemanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            //e.printStackTrace();
            throw new IllegalStateException("Can't read file!", e);
        }

        for (String line : lines) {
            int position = line.indexOf(';');
            String name = line.substring(0, position);
            String identityNumber = line.substring(position + 1, line.length());
            Human newHuman = new Human(name, identityNumber);
            humans.add(newHuman);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> list = new ArrayList<>();
        for (Human element: humans){
            if (element.getIdentityNumber().startsWith("1") || element.getIdentityNumber().startsWith("3")){
                list.add(element.getName()+";"+element.getIdentityNumber());
            }
        }

        try {
            Files.write(path, list);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
