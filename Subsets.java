// iterative solution
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        result.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++){
            int size = result.size();
            for(int j = 0; j < size; j++){
                List<Integer> newlist = new ArrayList<>(result.get(j));
                newlist.add(nums[i]);
                result.add(newlist);
            }
        }

        return result;
    }

}


// backtracking

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base case
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        //do not choose the path
        helper(nums, index + 1, path);
        // choose the path or one case
        // action
        path.add(nums[index]);
        // recurse
        helper(nums, index + 1, path);
        // backtrack
        path.remove(path.size() - 1 );
    }

}

// for loop based recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        //base


        //logic
        result.add(path);
        for(int i = index; i < nums.length; i++){
            // action
            List<Integer> newlist = new ArrayList<>(path);
            newlist.add(nums[i]);
            // recurse
            helper(nums, i + 1, path);
            // backtrack
            //path.remove(path.size() - 1);

        }

    }

}

// // recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path){
        // base case
        if(index == nums.length){
            result.add(path);
            return;
        }

        //logic
        //do not choose the path
        helper(nums, index + 1, new ArrayList<>(path));
        // choose the path or one case
        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path));
    }

}