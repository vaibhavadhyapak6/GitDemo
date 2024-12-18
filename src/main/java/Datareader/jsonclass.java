package Datareader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonclass {
	
	
	public List<HashMap<String, String>> GetJsonreaderTomap() throws IOException
	
	{
		
		//read json to string
	String jsoncontent=	FileUtils.readFileToString(new File("C:\\Users\\vaibhava\\Desktop\\my learning\\Framework\\SeleniumFrameWorkDesgin\\src\\main\\java\\Datareader\\jsondata.json"),StandardCharsets.UTF_8);
		
		//string to HashMap -Jackson datbind
		
		ObjectMapper mapper=new ObjectMapper();
		
//		/HashMap<String, String> map = objectMapper.readValue(jsoncontent, HashMap.class);
		
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){
				});
		return data;
		
	}

}
