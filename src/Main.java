import java.util.Scanner; //functions prompts switch bye
class LinkedListStuff {
    Node front;
    Node curr;
    Node tail;

    public LinkedListStuff() {
        front = null;
        curr = null;
        tail = null;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void CreateList() {
        front = null;
    }

    public Node FindTail() {
        if (front == null) {
            return null;
        }
        curr = front;
        while (curr.next != null) {
            curr = curr.next;
        }
        System.out.println("tail found: " + curr.data);
        return curr;
    }

    public void ShowList() { //final
        curr = front;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public Node DeleteNode() {
        if (front == null) {
            return null;
        }
        curr = front;
        front = curr.next;
        System.out.println("deleting node " + curr.data);
        return curr;
    }


    public void InsertNode(int data) { //WORKS
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        } //i used make node and insert node to do the same thing cause for this program it can
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListStuff list = new LinkedListStuff();

        while (true) {
            System.out.println("what would you like to do?");
            System.out.println("(create, make, insert, find, show, delete, exit)");
            String answer = scanner.nextLine();

            if (answer.equals("exit")) {
                System.out.println("goodbye");
                System.exit(0);//return 0;
            }
            if (!answer.equals("create") && !answer.equals("make") && !answer.equals("insert") &&
                    !answer.equals("find") && !answer.equals("show") && !answer.equals("delete") && !answer.equals("exit")) {

                System.out.println("thats not a valid answer");
                System.out.println("answers: create, make, insert, find last node, show");
            }

            switch (answer) {
                case "create":
                    list.CreateList();
                    System.out.println("linked list created");
                    break;
                case "make":
                    System.out.println("what interger data do you want the node to hold?");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    list.InsertNode(n);
                    System.out.println("node with " + n + " data made");
                    break;
                case "insert":
                    System.out.println("what interger data do you want the node to hold?");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    list.InsertNode(value);
                    System.out.println("node with " + value + " data made and inserted first");
                    break;
                case "find":
                    list.FindTail();
                    break;
                case "show":
                    System.out.println("full linked list:");
                    list.ShowList();
                    break;
                case "delete":
                    list.DeleteNode();
                    break;
                case "exit":
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
            }
        }
    }
}