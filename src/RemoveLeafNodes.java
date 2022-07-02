import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RemoveLeafNodes {
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
    private static void levelOrderTraversal(binaryTree<Integer> root) {
        if(root==null){
            return;
        }
        Queue<binaryTree<Integer>>queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            binaryTree<Integer> frontNode= queue.poll();
            if(frontNode==null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
                queue.add(null);
            }
            else{
                System.out.print(frontNode.data+ " ");
                if(frontNode.left!=null){

                    queue.add(frontNode.left);
                }
                if(frontNode.right!=null){

                    queue.add(frontNode.right);
                }

            }
        }
    }
    private static binaryTree<Integer> removeLeafNodes(binaryTree<Integer> root) {
    if(root==null){
        return null;
    }
    if(root.left==null &&root.right==null){
        return null;
    }
    root.left= removeLeafNodes(root.left);
    root.right= removeLeafNodes(root.right);
    return root;
    }
    public static void main(String[] args) {
        binaryTree<Integer>root= takeInputLevelWise();
        removeLeafNodes(root);
        levelOrderTraversal(root);
    }


}
