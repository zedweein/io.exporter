# io.exporter



io.exporter

简介
导出数据工具包

集成
将jar文件导入classpath即可

接口
 interface: exporter.io.core.ExporterExcelFactory
 Boolean export(String xlsxFile,String sheetName,List<Map<String, Object>> dataResult);
 void newExcelSheet(Workbook workBook, String sheetName, List<Map<String, Object>> dataResult);
 Boolean exportExcel(String xlsxFile, Workbook workBook);

interface: exporter.io.core.ExporterCSVFactory
Boolean export(String csvFile,List<Map<String, Object>> dataResult);

class: exporter.io.core.factory.Excel2007Exporter
class: exporter.io.core.factory.Excel2003Exporter
class: exporter.io.core.factory.CsvExporter

方法
详见doc文档
