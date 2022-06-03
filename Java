// Problem: Check if the nodes of a given BST lie within a given range of Min and Max
// A problem to traverse the entire BST and check if the nodes satisfy a given condition.
// Key: While traversing the tree, replace the "Print" statement with a logic to check for the given condition.
// Variants: return true/false, return number of nodes satisfying/not satisfying above condition.

class Node{
    int data;
    Node left, right;
    Node(int data){this.data = data;}
}

class BST{
    Node root;

    BST(){root = null;}
    BST(int key){root = new Node(key);}
    int result = 0;

    public void Insert(int key){root = InsertBST(root, key);}
    public Node InsertBST(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.data){
            root.left = InsertBST(root.left, key);
        } else if (key > root.data) {
            root.right = InsertBST(root.right, key);
        }
        return root;
    }

    public void Print(){PrintBST(root);}
    public void PrintBST(Node root){
        if (root != null){
            PrintBST(root.left);
            System.out.print(root.data + " ");
            PrintBST(root.right);
        }
    }

    public int isRange(int Min, int Max){ return RangeCheck(root, Min, Max);}
    public int RangeCheck(Node root, int Min, int Max){

        if (root != null) {
            RangeCheck(root.left, Min, Max);

            if ((root.data >= Min) && (root.data <= Max)) {
                result += 1 ;
            }

            RangeCheck(root.right, Min, Max);
        }
    return result;
    }
}

class MyArray{
    public static void main(String[] Args){
    BST tree = new BST();
    tree.Insert(20);
    tree.Insert(2);
    tree.Insert(100);
    tree.Insert(21);
    tree.Insert(55);
    tree.Print();
    System.out.print(tree.isRange(20, 44));
    }
}
