package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> parseDataFromFile(String pathName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(pathName));
        } catch (Exception e) {
            throw new RuntimeException("Can't create data from file: " + pathName, e);
        }
        return lines;
    }

    @Override
    public void writeDataToFile(String data, String file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + file, e);
        }
    }
}