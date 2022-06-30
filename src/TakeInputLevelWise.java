import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputLevelWise {
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
    public static void printLevelWise(binaryTree<Integer> root) {
        if(root==null){
            return;
        }
        Queue<binaryTree<Integer>> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            binaryTree<Integer> frontNode = queue.poll();
            if (frontNode == null) {
                if (queue.isEmpty()) {
                    break;
                }
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(frontNode.data+ ":");
                if (frontNode.left != null) {
                    queue.add(frontNode.left);
                    System.out.print("L: " + frontNode.left.data+ ",");
                }else{
                    System.out.print("L:" +"-1"+"," );
                }
                if (frontNode.right != null) {
                    queue.add(frontNode.right);
                    System.out.print("R: " + frontNode.right.data+ ",");
                    System.out.println();
                }
                else{
                    System.out.println("R: -1"+ ",");
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        binaryTree<Integer> root= takeInputLevelWise();
        printLevelWise(root);
    }
}
