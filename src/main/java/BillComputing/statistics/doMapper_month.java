package BillComputing.statistics;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 17:48
 */
public class doMapper_month extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    //public static final IntWritable one = new IntWritable(1);//这里的IntWritable相当于Int类型
    //public static Text word = new Text();//Text相当于String类型
    // map参数<keyIn key,valueIn value,Context context>，将处理后的数据写入context并传给reduce
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException, IOException {
        //StringTokenizer是Java工具包中的一个类，用于将字符串进行拆分
        String[] line = value.toString().split("\t");
        String phoneAndMonth = line[0] + " " +line[1]+" "+ line[2];
        double bill = Double.parseDouble(line[line.length - 1]);
        //将word存到容器中，记一个数
        context.write(new Text(phoneAndMonth), new DoubleWritable(bill));
    }
}

