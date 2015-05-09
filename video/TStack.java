package video;
import java.util.*;

/**
 * Created by ikirilov on 28/02/15.
 */
public class TStack<Item> implements Iterable<Item>{
    private Node<Item> first;  //first
    private int N;  //Number of elements

    public TStack(){
      first = null;
      N=0;
    }

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty(){
        return first==null;
    }


    public void push(Item item){
        Node<Item> old_first =  first;
        first = new Node<Item>();
        first.item = item;
        first.next = old_first;
        N++;
    }

    public Item pop(){
        if(isEmpty()){throw new NoSuchElementException();}
        Item item = first.item;
        first = first.next;
        N--;
      return item;

    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
   }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
