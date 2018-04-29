package Compare;
import HuffmanNode.*;
import java.util.Comparator;
public class Compare implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
 
        return x.frequency- y.frequency;
    }
}