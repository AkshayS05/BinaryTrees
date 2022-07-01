import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckBalanced {
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
    private static boolean checkBalanced(binaryTree<Integer> root) {
    if(root==null){
        return true;
    }
    int leftHeight= getHeight(root.left);
    int rightHeight= getHeight(root.right);

    if(Math.abs(leftHeight-rightHeight)<=1 &&checkBalanced(root.left)&&checkBalanced(root.right)){
    return true;
    }
    return false;
    }
    public static int getHeight(binaryTree<Integer> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public static void main(String[] args) {
        binaryTree<Integer> root= takeInputLevelWise();
        System.out.println(checkBalanced(root));
    }


}
