package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

public class TestDataUtilities {
    private static final String CSV_FILE_PATH = "test_data.csv";


    public static List<Object[]> getTestDataSets() throws IOException {
        InputStream input = TestDataUtilities.class.getClassLoader().getResourceAsStream(CSV_FILE_PATH);
        assert input != null;

        return  CsvUtilities.getLines(new InputStreamReader(input));
    }
}
