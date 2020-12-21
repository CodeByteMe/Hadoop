package BillComputing.statistics;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 16:38
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException, ClassNotFoundException {
        Configuration conf = new Configuration();
        //System.setProperty("HADOOP_USER_NAME", "hadoop");
        //conf.set("fs.defaultFS","hdfs://centos01:9000");

        Job job = Job.getInstance(conf);
        job.setJarByClass(Driver.class);

        job.setMapperClass(doMapper_year.class);
        job.setReducerClass(doReducer.class);
        //设置自定义分区类
        job.setPartitionerClass(myPartition.class);
        // 设置reduce个数
        job.setNumReduceTasks(2);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DoubleWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);


        FileInputFormat.setInputPaths(job, new Path("/test/MapReduce/input"));
        FileOutputFormat.setOutputPath(job, new Path("/test/MapReduce/output"));

        System.exit(job.waitForCompletion(true)?0:-1);
    }


}
