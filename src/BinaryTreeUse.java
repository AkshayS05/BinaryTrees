import java.util.Scanner;

public class BinaryTreeUse {
    private static binaryTree<Integer> takeInput(Scanner s) {
    int rootData;
        System.out.println("Enter the root data");
        rootData= s.nextInt();
        if(rootData==-1){
            return null;
        }
        binaryTree<Integer> root= new binaryTree<>(rootData);
        root.left= takeInput(s);
        root.right=takeInput(s);
        return root;
    }
    public static void print(binaryTree<Integer> root){
        if(root==null){
            return;
        }
        String toBePrinted= root.data+ " ";
        if(root.left!=null){
            toBePrinted+= "L:" + root.left.data;
        }
        if(root.right!=null){
            toBePrinted+= "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
//        binaryTree<Integer> root= new binaryTree<>(1);
//        binaryTree<Integer> node1= new binaryTree<>(2);
//        binaryTree<Integer> node2= new binaryTree<>(3);
//        root.right=node1;
//        root.left= node2;
        Scanner s= new Scanner(System.in);
        binaryTree<Integer> root= takeInput(s);
        print(root);
    }


}
