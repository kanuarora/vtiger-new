package generic_utility;

import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {
    public static String getDataFromJson(String key) throws IOException, ParseException {
        FileReader fr = new FileReader("./src/test/resources/cd.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jObj = (JSONObject) obj;
        String value = jObj.get(key).toString();
        return value;
    }

    public static String getDataFromExcelFile(int rowindex, int cellindex) throws IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/tsd.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("contacts");
        Row row = sh.getRow(rowindex);
        Cell cell = row.getCell(cellindex);
        String value = cell.getStringCellValue();
        return value;
    }

    public static double getNumericDataFromExcelFile(int rowindex, int cellindex) throws IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/tsd.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("contacts");
        Row row = sh.getRow(rowindex);
        Cell cell = row.getCell(cellindex);
        double value = cell.getNumericCellValue();
        return value;
    }
}
