import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildTreeFromInAndPostOrder {
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

    private static binaryTree<Integer> buildTree(int[] inOrder, int[] postOrder) {
        return buildTree(inOrder,postOrder, 0, inOrder.length-1,0, postOrder.length-1);
    }

    private static binaryTree<Integer> buildTree(int[] inOrder, int[] postOrder, int inSI,int inEI, int postSI, int postEI) {
        if(inSI>inEI){
            return null;
        }
        int rootData= postOrder[postEI];
        binaryTree<Integer> root= new binaryTree<>(rootData);
        int rootInIndex=-1;
        for (int i = inSI; i <=inEI ; i++) {
            if(inOrder[i]==rootData){
                rootInIndex=i;
                break;
            }
        }
        int postLeftStart= postSI;
        int inLeftStart=inSI;
        int inLeftEnd=rootInIndex-1;
        int leftLength=inLeftEnd-inLeftStart+1;
        int postLeftEnd=postLeftStart+leftLength-1;
        int postRightStart= postLeftEnd+1;
        int postRightEnd=postEI-1;
        int inRightStart= rootInIndex+1;
        int inRightEnd= inEI;

        root.left= buildTree(inOrder,postOrder,inLeftStart,inLeftEnd,postLeftStart,postLeftEnd);
        root.right=buildTree(inOrder,postOrder,inRightStart,inRightEnd,postRightStart,postRightEnd);
        return root;
    }

    public static void main(String[] args) {
        int [] inOrder= {4,2,5,1,6,3,7};
        int[] postOrder={4,2,5,6,3,7,1};
        binaryTree<Integer>root=  buildTree(inOrder, postOrder);
        printLevelWise(root);
    }
}
