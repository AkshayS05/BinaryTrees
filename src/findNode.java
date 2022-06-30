import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class findNode {
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
public static boolean findNode(binaryTree<Integer>root,int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;

        }
        boolean ans= false;
        ans= findNode(root.left,x);
        if(!ans) {
            ans = findNode(root.right, x);
        }
        return ans;
}
    public static void main(String[] args) {
        binaryTree<Integer> root= takeInputLevelWise();
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the node you want to find");
        int x= s.nextInt();
        System.out.println(findNode(root,x));
    }
}
