package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtilities {
    private static final char DEFAULT_SEPARATOR = ',';

    public static List<Object[]> getLines(Reader csvFileReader) throws IOException {
        BufferedReader br = new BufferedReader(csvFileReader);
        String line;
        ArrayList<Object[]> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line.split(String.valueOf(DEFAULT_SEPARATOR)));
        }

        return lines;
    }
}
