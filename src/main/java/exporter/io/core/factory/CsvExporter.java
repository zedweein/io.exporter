package exporter.io.core.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import exporter.io.core.ExporterCSVFactory;

public class CsvExporter implements ExporterCSVFactory {

	/**
	 * 大数据解决方案,分页插入
	 * 
	 * @param writer
	 * @param csvFile
	 * @param dataResult
	 * @return
	 */
	public Boolean export(String csvFile, List<Map<String, Object>> dataResult) {
		File file = new File(csvFile);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> headMap = new ConcurrentHashMap<String, Object>();
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
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(csvFile), true), "GB2312"), 1024);
			if (dataResult.size() > 0) {
				StringBuffer sbf = new StringBuffer();
				Map<String, Object> mapObject = null;
				for (int i = 0; i < dataResult.size(); i++) {
					mapObject = dataResult.get(i);
					for (String keyName : headMap.keySet()) {
						sbf.append(String.valueOf(mapObject.get(keyName)) + ",");
					}
					sbf.deleteCharAt(sbf.length() - 1);
					writer.write(sbf.toString());
					writer.flush();
					// 清空-效率最高
					sbf.setLength(0);
					writer.newLine();
				}
			}
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
