import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

    // in order to lessen the time complexity, we will use pair class
 class Pair <T,V>{
        T first;
        V second;
    }
public class DiameterBinaryTree {

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
    public static Pair<Integer,Integer> heightDiameter(binaryTree<Integer>root){
        if(root==null){
            Pair<Integer,Integer> output= new Pair<>();
            output.first=0;
            output.second=0;
            return output;
        }
        Pair<Integer,Integer> leftOutput= heightDiameter(root.left);
        Pair<Integer,Integer> rightOutput= heightDiameter(root.right);
        int height= 1+ Math.max(leftOutput.first, rightOutput.first);
        int option1= leftOutput.first+rightOutput.first;
        int option2= leftOutput.second;
        int option3= rightOutput.second;
        int diameter= Math.max(option1, Math.max(option2,option3));
        Pair<Integer,Integer> output= new Pair<>();
        output.first= height;
        output.second= diameter;
        return output;

    }
    public static void main(String[] args) {
binaryTree<Integer> root= takeInputLevelWise();
        System.out.print("Diameter is "+ heightDiameter(root).second);

    }
}
