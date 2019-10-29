// 1233. Remove Sub-Folders from the Filesystem
// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
package LeetCode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class RemoveSubFolder{
	public static void main(String[] args){
		String[] test1 = new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
		String[] test2 = new String[]{"/a","/c/b/cdd","/a/bd/d"};
		System.out.println(new RemoveSubFolder().removeSubFolder(test1));
		System.out.println(new RemoveSubFolder().removeSubFolder(test2));
	}

	public List<String> removeSubFolder(String[] folder){
		List<String> result = new ArrayList<>();
		Arrays.sort(folder);
		for (String temp: folder){
			int len = temp.length();
			boolean isContain = false;
			int index = 1;
			while (index < len){
				if (temp.charAt(index) != '/'){
					++index;
					continue;
				}
			
				if (result.contains(temp.substring(0, index))){
					isContain = true;
					break;
				}
				++index;
			}
			if (!isContain){
				result.add(temp);
			}
		}
		return result;
	}
}
