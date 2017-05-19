import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by andrewwong on 5/19/17.
 */
public class MyArrayList<E> {
    E[] myArray;
    private int size = 0;

    MyArrayList() {
        this.myArray = (E[]) new Object[10];
    }

    MyArrayList(int capacity) {
        this.myArray = (E[]) new Object[capacity];
    }

    public boolean add(E element) {
        if (size == myArray.length) {
            myArray = Arrays.copyOf(myArray, myArray.length + 10);
        }
        myArray[size] = element;
        size++;
        return true; //duplicates permitted
    }

    //TODO this just increases size and replaces, need to insert
    public void add(int index, E element) throws IndexOutOfBoundsException {
        E[] newArray = (E[]) new Object[myArray.length + 1];
        System.arraycopy(myArray, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(myArray, index, newArray, index + 1, myArray.length - index);
        myArray = newArray;
    }

    public E get(int index) {
        return (E) myArray[index];
    }

    //TODO resize arraylist after removing element
    public E remove(int index)  throws IndexOutOfBoundsException{
        E[] newArray = (E[]) new Object[myArray.length - 1];
        if(index==0) {
            return removeFromBeginning(newArray);
        }
        System.arraycopy(myArray, 0, newArray, 0, index);
        System.arraycopy(myArray, index, newArray, index - 1, myArray.length - index);
        E storedElement = (E) myArray[index];
        myArray = newArray;
        return storedElement;
    }

    private E removeFromBeginning(E[] newArray){
        System.arraycopy(myArray, 1, newArray, 0, myArray.length-1);
        E storedElement = (E) myArray[0];
        myArray = newArray;
        return storedElement;
    }

    public E set(int index, E element)  throws IndexOutOfBoundsException{
        E storedElement = (E) myArray[index];
        myArray[index] = element;
        return storedElement;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            myArray[i] = null;
        }
        size = 0;

    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public boolean contains(Object o) {
        for (Object e : myArray) {
            if ((o == null ? e == null : o.equals(e)) == true) {
                return true;
            }
        }
        return false;
    }

    //    public boolean addAll(Collection<? extends E> c){
//        //make new myarraylist with an appropriate capacity based on c's size
//        int placeHolder = myArray.length;
//        E[] oldMyArray = myArray;
//        myArray = Arrays.copyOf(myArray, myArray.length + c.size());
//        //use iterator to add to that new arraylist which has all the previous myarraylist elements
//        for(Iterator it = c.iterator(); it.hasNext();){
//            myArray[placeHolder] = (E) it.next();
//            placeHolder++;
//        }
//        return(!oldMyArray.equals(myArray));
//    }
    public boolean addAll(MyArrayList<? extends E> c) {
        E[] oldMyArray = myArray;
        myArray = Arrays.copyOf(myArray, myArray.length + c.size());
        for (int i = oldMyArray.length; i < myArray.length; i++) {
            myArray[i] = c.get(i);
        }
        return (!oldMyArray.equals(myArray));
    }
}
