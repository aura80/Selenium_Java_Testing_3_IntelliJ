package util;

//import com.alibaba.fastjson.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
		// method to read data from a json file
		public static JSONObject json(String name) {
			String jsonPath = System.getProperty("user.dir")+"\\src\\testdatafiles\\"+name+".json";
			
			// read the json file at specific location
			FileReader reader = null;
			try {
				reader = new FileReader(jsonPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			// define the parser to parse the content of the json file
			JSONParser jsonParser = new JSONParser();
			// define the returned object
			JSONObject obj = null;
			try {
				obj = (JSONObject) jsonParser.parse(reader);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return obj;
		}
}
