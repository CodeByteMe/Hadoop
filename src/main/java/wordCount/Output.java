package wordCount;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 13:09
 */
public class Output {
    public static boolean output(Properties properties,FileSystem fileSystem,Context context) throws IOException {
        TreeMap<String,Integer> myMap=context.read();
        Iterator<Map.Entry<String, Integer>> it=myMap.entrySet().iterator();

        FSDataOutputStream out = null;
        Path outputPath=new Path(properties.getProperty(Constants.OUTPUT_FILE.getValue()));
        if(fileSystem.exists(outputPath))
            fileSystem.delete(outputPath);
        out = fileSystem.create(outputPath);
        while (it.hasNext())
        {
            java.util.Map.Entry<String,Integer> entry=it.next();
            out.write((entry.getKey()+"\t"+entry.getValue()+"\n").getBytes());
        }
        out.flush();
        out.close();
        fileSystem.close();
        return true;//若成功返回true
    }
}
