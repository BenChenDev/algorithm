import java.util.ArrayList;
import java.util.List;

class pascalTriangle {
    private List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < numRows; i++){
            List<Integer> pre_row = result.get(i - 1);
            List<Integer> cur_row = new ArrayList<>();
            cur_row.add(1);
            for(int a = 0; a < pre_row.size() - 1; a++){
                cur_row.add(pre_row.get(a) + pre_row.get(a + 1));
            }
            cur_row.add(1);
            result.add(cur_row);
        }
        
        return result;
    }
}