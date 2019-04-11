# io.exporter



io.exporter

简介<br/> 
导出数据工具包<br/> 

集成<br/> 
将jar文件导入classpath即可<br/> 

接口<br/> 
 interface: exporter.io.core.ExporterExcelFactory<br/> 
 Boolean export(String xlsxFile,String sheetName,List<Map<String, Object>> dataResult);<br/> 
 void newExcelSheet(Workbook workBook, String sheetName, List<Map<String, Object>> dataResult);<br/> 
 Boolean exportExcel(String xlsxFile, Workbook workBook);<br/> 

interface: exporter.io.core.ExporterCSVFactory<br/> 
Boolean export(String csvFile,List<Map<String, Object>> dataResult);<br/> 

class: exporter.io.core.factory.Excel2007Exporter<br/> 
class: exporter.io.core.factory.Excel2003Exporter<br/> 
class: exporter.io.core.factory.CsvExporter<br/> 

方法<br/> 
详见doc文档<br/> 
