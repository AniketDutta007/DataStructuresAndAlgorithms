//Problem Statement : https://leetcode.com/problems/design-hashmap/
public class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    Node[] map;
    public MyHashMap() {
        map = new Node[1000];
    }

    public void put(int key, int value) {
        int hashValue = key%1000;
        if(map[hashValue]==null){
            map[hashValue] = new Node(key,value);
            return;
        }
        Node prev = null;
        Node curr = map[hashValue];
        while(curr!=null&&key<curr.key){
            prev = curr;
            curr = curr.next;
        }
        if(curr!=null&&curr.key==key)
            curr.val = value;
        else if(prev==null){
            map[hashValue] = new Node(key,value);
            map[hashValue].next = curr;
        } else{
            prev.next = new Node(key,value);
            prev.next.next = curr;
        }
    }

    public int get(int key) {
        int hashValue = key%1000;
        Node curr = map[hashValue];
        while(curr!=null){
            if(curr.key==key)
                return curr.val;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashValue = key%1000;
        if(map[hashValue]!=null&&map[hashValue].key==key){
            map[hashValue] = map[hashValue].next;
            return;
        }
        Node prev = null;
        Node curr = map[hashValue];
        while(curr!=null&&key<curr.key){
            prev = curr;
            curr = curr.next;
        }
        if(curr!=null&&curr.key==key)
            prev.next = curr.next;
    }
}
