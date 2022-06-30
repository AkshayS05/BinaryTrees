import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNodesInBinaryTree {
    public static binaryTree<Integer> takeInputLevelWise(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the root data");
        int rootData= s.nextInt();
        binaryTree<Integer> root= new binaryTree<>(rootData);
        Queue<binaryTree<Integer>> pendingNode= new LinkedList<>();
        pendingNode.add(root);
        while(!pendingNode.isEmpty()){
            binaryTree<Integer> front= pendingNode.poll();

            System.out.println("Enter the left child of "+ front.data);
            int leftChild= s.nextInt();
            if(leftChild!=-1){
                binaryTree<Integer> child= new binaryTree<>(leftChild);
                pendingNode.add(child);
                front.left= child;
            }
            System.out.println("Enter the right child of "+ front.data);
            int rightChild= s.nextInt();
            if(rightChild!=-1){
                binaryTree<Integer> child= new binaryTree<>(rightChild);
                pendingNode.add(child);
                front.right= child;
            }
        }

        return root;
    }
    private static int countNodes(binaryTree<Integer> root) {
    if(root==null){
        return 0;
    }
    int ans=1;
    ans+=countNodes(root.left);
    ans+= countNodes(root.right);
    return ans;
    }
    public static void main(String[] args) {
        binaryTree<Integer> root= takeInputLevelWise();
        int ans= countNodes(root);
        System.out.println("The total number of nodes are "+ ans);
    }


}
