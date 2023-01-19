package Utilities;

import Base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtils extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static String sheetpath = "/Users/amangarg/Desktop/TestProjectDemo_Automation/src/main/TestData/TestData.xlsx";

    static XSSFWorkbook book;
    static XSSFSheet sheet;

    public void switchToFrame(){
        driver.switchTo().frame("mainframe");
    }

    public static Object[][] getTestData(String sheetname) {
        FileInputStream file = null;
        try {
             file = new FileInputStream(sheetpath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = new XSSFWorkbook(file);
        }catch(InvalidFormatException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetname);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}
