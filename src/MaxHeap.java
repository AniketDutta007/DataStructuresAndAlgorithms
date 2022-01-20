public class MaxHeap{
    private int[] heap;
    private int size;
    private int capacity;
    MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity];
    }
    MaxHeap(int capacity,int[] heap){
        this.capacity = capacity;
        this.size = capacity;
        this.heap = heap;
        buildHeap();
    }
    MaxHeap(int capacity,int size,int[] heap){
        this.capacity = capacity;
        this.size = size;
        this.heap = heap;
        buildHeap();
    }
    public int size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }
    private int getParent(int child){
        return (int)(child-1)/2;
    }
    private int getLeftChild(int parent){
        return 2*parent+1;
    }
    private int getRightChild(int parent){
        return 2*parent+2;
    }
    public boolean insertKey(int key){
        if(size==capacity)
            return false;
        int pos = size++;
        heap[pos] = key;
        while(pos!=0&&heap[getParent(pos)]<heap[pos]){
            swap(getParent(pos),pos);
            pos = getParent(pos);
        }
        return true;
    }
    public void increaseKey(int pos, int key){
        if(pos<size&&heap[pos]<key)
            return;
        heap[pos] = key;
        while(pos!=0&&heap[getParent(pos)]<heap[pos]){
            swap(getParent(pos),pos);
            pos = getParent(pos);
        }
    }
    public int peekMax(){
        if(size==0)
            return Integer.MIN_VALUE;
        else
            return heap[0];
    }
    public int extractMax(){
        if(size==0)
            return Integer.MIN_VALUE;
        if(size==1){
            size--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[size-1];
        size--;
        maxHeapify(0);
        return root;
    }
    public void deleteKey(int pos){
        increaseKey(pos,Integer.MAX_VALUE);
        extractMax();
    }
    public int[] sort(){
        if(size==0)
            return new int[]{};
        if(size==1)
            return new int[]{heap[0]};
        int[] arr = new int[size];
        while(size>0)
            arr[size-1] = extractMax();
        return arr;
    }
    public void buildHeap(){
        for(int i=(int)size/2-1; i>=0; i--)
            maxHeapify(i);
    }
    public void maxHeapify(int parent){
        if(parent>(int)size/2)//if the parent is a leaf node
            return;

        int largest = parent;//pointer to the index of the largest element
        int leftChild = getLeftChild(parent);//index of the left child
        int rightChild = getRightChild(parent);//index of the right child

        if(leftChild<size&&heap[largest]<heap[leftChild])//if left child is the largest
            largest = leftChild;
        if(rightChild<size&&heap[largest]<heap[rightChild])//if left child is the largest
            largest = rightChild;

        if(largest!=parent){//if parent is not the largest element
            swap(largest,parent);//swap the parent with the largest element
            maxHeapify(largest);//heapify the swapped node
        }
    }
    public void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void show(){
        System.out.print("[");
        for(int i=0; i<size-1; i++)
            System.out.print(heap[i]+", ");
        if(size!=0)
            System.out.print(heap[size-1]);
        System.out.println("]");
    }
}
