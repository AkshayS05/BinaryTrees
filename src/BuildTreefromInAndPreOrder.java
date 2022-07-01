import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildTreefromInAndPreOrder {
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

    private static binaryTree<Integer> buildTree(int[] inOrder, int[] preOrder) {
        return buildTree(inOrder,preOrder, 0, inOrder.length-1,0, preOrder.length-1);
    }

    private static binaryTree<Integer> buildTree(int[] inOrder, int[] preOrder, int inSI,int inEI, int preSI, int preEI) {
    if(inSI>inEI){
        return null;
    }
    int rootData= preOrder[preSI];
        binaryTree<Integer> root= new binaryTree<>(rootData);
        int rootInIndex=-1;
        for (int i = inSI; i <=inEI ; i++) {
            if(inOrder[i]==rootData){
                rootInIndex=i;
                break;
            }
        }
        int preLeftStart= preSI+1;
        int inLeftStart=inSI;
        int inLeftEnd=rootInIndex-1;
        int preLeftEnd=inLeftEnd-inLeftStart+preLeftStart;
        int preRightStart= preLeftEnd+1;
        int preRightEnd=preEI;
        int inRightStart= rootInIndex+1;
        int inRightEnd= inEI;

        root.left= buildTree(inOrder,preOrder,inLeftStart,inLeftEnd,preLeftStart,preLeftEnd);
        root.right=buildTree(inOrder,preOrder,inRightStart,inRightEnd,preRightStart,preRightEnd);
        return root;
    }

    public static void main(String[] args) {
        int [] inOrder= {4,2,1,5,3,7};
        int[] preOrder={1,2,4,5,3,7};
      binaryTree<Integer>root=  buildTree(inOrder, preOrder);
      printLevelWise(root);
    }
}
