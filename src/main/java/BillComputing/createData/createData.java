package BillComputing.createData;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 16:05
 */
public class createData {
    static final String preNum="191****";
    int []tailNums=new int[4];
    String []Nums=new String[100];
    @Before
    public void createNums()
    {

        for(int i=0;i<Nums.length;i++)
        {
            Nums[i]=preNum;
            for(int j=0;j<tailNums.length;j++)
            {
                tailNums[j]=(int)(Math.random()*10);
                Nums[i]+=tailNums[j];
            }
            //System.out.println(Nums[i]);
        }
    }
    @Test
    public void createBills() throws IOException {
        OutputStream out= new BufferedOutputStream(new FileOutputStream("input\input.txt"));

        int k=(int) (Math.random()* Nums.length);
        DecimalFormat df=new DecimalFormat("0.00");
        for(int j=0;j<5;j++)
        {
            for(int i=0;i< Nums.length;i++)
            {
                if(i==k)
                    break;
                out.write((Nums[i]+"\t"+(int)(2016+Math.random()*5)+"\t"+(int)(Math.random()*12+1)+"\t"+df.format(Math.random()*200)+"\n").getBytes());
            }
        }
        out.flush();
        out.close();
    }
}
