package wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
/**
 * @author Zhou.Y.M
 * @create 2020/12/20 12:37
 */
public class Reader {
    public static Context read(Properties properties,FileSystem fileSystem) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Path path=new Path(properties.getProperty(Constants.INPUT_FILE.getValue()));
        FSDataInputStream in = fileSystem.open(path);
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String line="";
        String contextClassName=properties.getProperty(Constants.CONTEXT_CLASS.getValue());
        Class clazz=Class.forName(contextClassName);
        Context context= (Context) clazz.newInstance();
        while((line=reader.readLine())!=null)
        {
            //System.out.println(line);
            String[] S=line.split(" ");
            for(String s:S)
            {
                System.out.println(s);
                context.write(s,1);
            }
        }
        reader.close();
        return context;
    }
}
