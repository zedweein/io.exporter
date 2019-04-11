package exporter.io.core;

import java.util.List;
import java.util.Map;

public interface ExporterCSVFactory {

	/**
	 * 
	 * csv导出方案
	 * @param xlsxFile 目标excel文件路径 
	 * @param dataResult 传入数据
	 * @return
	 */
	Boolean export(String csvFile,List<Map<String, Object>> dataResult);
	
}
