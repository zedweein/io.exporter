package exporter.io.core;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExporterExcelFactory{

	/**
	 * 小数据量导出方案,万级
	 * 导出excel
	 * @param xlsxFile 目标excel文件路径 
	 * @param dataResult 传入数据
	 * @return
	 */
	Boolean export(String xlsxFile,String sheetName,List<Map<String, Object>> dataResult);
	
	/**
	 * 大数据量导出 分页导出时设置数据
	 * 
	 * @param dataResult
	 * @return
	 */
	void newExcelSheet(Workbook workBook, String sheetName, List<Map<String, Object>> dataResult);

	/**
	 * 分页导出workBook
	 * 
	 * @param workBook
	 * @return
	 */
	Boolean exportExcel(String xlsxFile, Workbook workBook);
	
}
