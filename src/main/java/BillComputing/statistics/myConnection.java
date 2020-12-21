package BillComputing.statistics;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import wordCount.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 16:38
 */
public class myConnection {

    public static FileSystem fileSystem(Properties properties) throws URISyntaxException, IOException, InterruptedException {

        URI address=new URI(properties.getProperty(Constants.ADDRESS.getValue()));
        String user=properties.getProperty(Constants.USER.getValue());
        Configuration conf=new Configuration();
        FileSystem System=FileSystem.get(address,conf,user);
        return System;
    }
}
