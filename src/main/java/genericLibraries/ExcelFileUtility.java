package genericLibraries;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains reusable methods to perform operations on excel file
 * @author krina
 *
 */
public class ExcelFileUtility
{
	private Workbook workbook;
	
	/**
	 * this method is used to initialize excel file
	 * @param excelpath
	 */
	public void excelInitialization(String excelpath)
	{
		FileInputStream fis=null;
		try 
		{
			fis=new FileInputStream(excelpath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try 
		{
			workbook=WorkbookFactory.create(fis);
		}catch(EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch single data from excel file
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
public String fetchDataFromExcel(String sheetName,int rowNum, int cellNum) 
{
	return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
}
/**
 * this method is used to fetch multiple data from excel
 * @param sheetname
 * @return
 */

public List<String> fetchDatafromExcel(String sheetName){
	List<String> list= new ArrayList<>();
	Sheet sheet= workbook.getSheet(sheetName);
	for(int i=0;i<4;i++) {
		String data=sheet.getRow(i).getCell(1).getStringCellValue();
		list.add(data);
	}
	return list;
}
public void closeWorkbook() {
	try {
		workbook.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
