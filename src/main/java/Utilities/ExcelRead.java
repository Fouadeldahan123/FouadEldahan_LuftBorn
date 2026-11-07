package Utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    private static final String FILE_PATH =
            System.getProperty("user.home") + "/Desktop/Book2.xlsx";

    public static String getTestData(String key) {

        try (FileInputStream file = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(file)) {

            // Automatically get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            DataFormatter formatter = new DataFormatter();

            // Skip header row
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String excelKey = formatter.formatCellValue(row.getCell(0)).trim();
                System.out.println(excelKey);
                String excelValue = formatter.formatCellValue(row.getCell(1)).trim();
                System.out.println(excelValue);

                if (excelKey.equalsIgnoreCase(key.trim())) {
                    return excelValue;
                }
            }

            throw new RuntimeException("Test data key not found: " + key);

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file", e);
        }
    }
}