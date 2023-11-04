package co.edu.escualing.twitter.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.escualing.twitter.model.Tweet;
import co.edu.escualing.twitter.model.User;

public class TwitterDAO {

	private final String FILE_NAME = "/DB.xlsx";
	private static Logger logger = LoggerFactory.getLogger(TwitterDAO.class);

	private Workbook loadFile() throws Exception {
		InputStream is = TwitterDAO.class.getResourceAsStream(FILE_NAME);
		//FileInputStream file = new FileInputStream(new File(FILE_NAME));
		Workbook workbook = new XSSFWorkbook(is);
		return workbook;
	}

	private Map<Integer, List<String>> loadData(Workbook wb) throws Exception {
		Sheet sheet = wb.getSheetAt(1);

		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			data.put(i, new ArrayList<String>());
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case STRING:
					data.get(i).add(cell.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						data.get(i).add(cell.getLocalDateTimeCellValue().toString());
					} else {
						data.get(i).add(String.format("%.0f", cell.getNumericCellValue()));
					}
					break;
				case BOOLEAN:
					data.get(i).add(cell.getBooleanCellValue() + "");
					break;

				case FORMULA:
					data.get(i).add(cell.getCellFormula() + "");
					break;

				default:
					data.get(i).add(" ");
				}
			}
			i++;
		}
		return data;
	}

	private List<Tweet> listTweets(Map<Integer, List<String>> map) throws Exception {
		List<Tweet> tweets = new ArrayList<Tweet>();
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			List<String> list = map.get(it.next());
			Iterator<String> itx = list.iterator();

			Tweet t = new Tweet(list.get(0), new User(list.get(1)), list.get(2), list.get(3));
			tweets.add(t);
		}
		return tweets;
	}
	
	public List<Tweet> getTweets() throws Exception {
		Workbook wb = loadFile();
		Map<Integer, List<String>> data = loadData(wb);
		List<Tweet> tuits = listTweets(data);
		return tuits;
	}

	public static void main(String[] args) {
		TwitterDAO r = new TwitterDAO();

		try {
			List<Tweet> tuits = r.getTweets();
			Iterator<Tweet> it = tuits.iterator();
			while (it.hasNext()) {
				Tweet t = it.next();
				logger.info(t.toString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

}
