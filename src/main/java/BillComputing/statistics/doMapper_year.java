package BillComputing.statistics;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Test;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 16:43
 */
public class doMapper_year extends Mapper<LongWritable, Text, Text, DoubleWritable> {

        //public static final IntWritable one = new IntWritable(1);//这里的IntWritable相当于Int类型
        //public static Text word = new Text();//Text相当于String类型

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String []line=value.toString().split("\t");
        String phoneAndYear=line[0]+" "+line[1];
        double bill=Double.parseDouble(line[line.length-1]);
        System.out.println("test");
        System.out.println("hgweiohg");
        //将word存到容器中，记一个数
        context.write(new Text(phoneAndYear), new DoubleWritable(bill));
    }
}
