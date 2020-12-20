package wordCount;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 10:17
 */
public class Driver {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, IllegalAccessException, InstantiationException, ClassNotFoundException {
       /* Configuration conf=new Configuration();
        URI uri=new URI("hdfs://centos01:9000");*/
        //读取配置文件
        Properties properties=Property.getProperties();
        //根据配置获取HDFS文件系统
        FileSystem fileSystem= myConnection.fileSystem(properties);
        //读取并处理文件
        Context context=Reader.read(properties,fileSystem);
        //写入
        boolean success=Output.output(properties,fileSystem,context);
        if(success==true)
            System.out.println("success!");

    }
}
