package BillComputing.statistics;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author Zhou.Y.M
 * @create 2020/12/21 21:28
 */
public class myPartition extends Partitioner<Text, DoubleWritable> {
    @Override
    public int getPartition(Text text, DoubleWritable intWritable, int num) {
        if(Integer.parseInt(text.toString())<50)
            return 0%num;
        else
            return 1%num;
       // return 0;
    }


}
