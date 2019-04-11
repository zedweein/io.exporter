package exporter.io.core.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import exporter.io.core.ExporterExcelFactory;

public class Excel2007Exporter implements ExporterExcelFactory {
	
	public Boolean export(String xlsxFile, String sheetName, List<Map<String, Object>> dataResult) {
		Map<String, Object> headMap = new ConcurrentHashMap<String, Object>();
		// 对数据插入表头
		try {
			if (dataResult.size() > 0) {
				Map<String, Object> map0 = dataResult.get(0);
				for (String key : map0.keySet()) {
					headMap.put(key, key);
				}
				dataResult.add(0, headMap);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		// 1.申明一个工作簿 xlsx
		XSSFWorkbook workBook = new XSSFWorkbook();
		// 2.申明一个工作表 sheet
		XSSFSheet sheet = workBook.createSheet(sheetName);
		// 3.申明一行 row
		XSSFRow row = null;
		// 4.申明一个单元 cell
		XSSFCell cell = null;
		// 5.申明cell的样式
		XSSFCellStyle cellStyle = workBook.createCellStyle();
		//上下居中
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

		if (dataResult.size() > 0) {
			Map<String, Object> mapObject = null;
			// 遍历行和单元
			for (int i = 0; i < dataResult.size(); i++) {
				row = sheet.createRow(i);
				mapObject = dataResult.get(i);
				int j = 0;
				for (String keyName : headMap.keySet()) {
					cell = row.createCell(j);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(String.valueOf(mapObject.get(keyName)));
					j += 1;
				}
			}
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(new File(xlsxFile));
			workBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		System.gc();
		return true;
	}

	public void newExcelSheet(Workbook workBook, String sheetName, List<Map<String, Object>> dataResult) {
		Map<String, Object> headMap = new ConcurrentHashMap<String, Object>();
		// 对数据插入表头
		try {
			if (dataResult.size() > 0) {
				Map<String, Object> map0 = dataResult.get(0);
				for (String key : map0.keySet()) {
					headMap.put(key, key);
				}
				dataResult.add(0, headMap);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		XSSFWorkbook xworkbook = (XSSFWorkbook) workBook;
		XSSFSheet sheet = xworkbook.createSheet(sheetName);
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCellStyle cellStyle = xworkbook.createCellStyle();
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		if (dataResult.size() > 0) {
			Map<String, Object> mapObject = null;
			for (int i = 0; i < dataResult.size(); i++) {
				row = sheet.createRow(i);
				mapObject = dataResult.get(i);
				int j = 0;
				for (String keyName : mapObject.keySet()) {
					cell = row.createCell(j);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(String.valueOf(mapObject.get(keyName)));
					j += 1;
				}
			}
		}
		System.gc();
	}

	public Boolean exportExcel(String xlsxFile, Workbook workBook) {
		try {
			FileOutputStream fileOut = new FileOutputStream(new File(xlsxFile));
			workBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		System.gc();
		return true;
	}

}
