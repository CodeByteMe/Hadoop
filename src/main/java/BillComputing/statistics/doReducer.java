package BillComputing.statistics;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.text.DecimalFormat;
import java.io.IOException;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 16:58
 */
public class doReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    @Override
    protected void reduce(Text key,Iterable<DoubleWritable> values,Context context) throws IOException, InterruptedException {
        double sum=0;
        for(DoubleWritable value:values)
        {
            sum+=Double.parseDouble(value.toString());
        }
        DecimalFormat df=new DecimalFormat("0.00");
        sum=Double.parseDouble(df.format(sum));
        System.out.println(key+"  "+sum);
        context.write(key,new DoubleWritable(sum));
    }
}
