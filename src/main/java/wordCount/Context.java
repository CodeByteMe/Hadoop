package wordCount;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 10:34
 */
public class Context {
    private TreeMap<String,Integer> map=new TreeMap<String,Integer>();
    public void write(String vocabulary,int num)
    {
        vocabulary=vocabulary.toLowerCase();
        if(map.containsKey(vocabulary))
            shuffle(vocabulary);
        else
            map.put(vocabulary,num);
    }
    public void write(String vocabulary)
    {
        if(map.containsKey(vocabulary))
            shuffle(vocabulary);
        else
            map.put(vocabulary,1);
    }
    public void shuffle(String key)
    {
        map.put(key,map.get(key)+1);
    }
    public TreeMap<String,Integer> read()
    {
        return map;
    }

}
