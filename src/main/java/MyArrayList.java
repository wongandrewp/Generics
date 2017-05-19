import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by andrewwong on 5/19/17.
 */
public class MyArrayList<E> {
    E[] myArray;
    private int size = 0;

    MyArrayList(){
        this.myArray = (E[]) new Object[0];
    }

    MyArrayList(int capacity){
        this.myArray = (E[]) new Object[capacity];
    }

    public boolean add(E element){
        myArray = Arrays.copyOf(myArray, myArray.length+1);

        myArray[size] = element;
        size++;
        if(myArray.length >= size) return true;
        else return false;
    }

    public void add(int index, E element){
        myArray = Arrays.copyOf(myArray, myArray.length+1);
        myArray[index] = element;
    }

    public E get(int index){
        return myArray[index];
    }

    //TODO resize arraylist after removing element
    public E remove(int index){
        E storedElement = (E) myArray[index];
//        myArray = Arrays.copyOf(myArray, myArray.length-1);
        return storedElement;
    }

    public E set(int index, E element){
        E storedElement = myArray[index];
        myArray[index] = element;
        return storedElement;
    }

    public int size() {
        return size;
    }

    public void clear(){
        for(int i = 0; i < size(); i++){
            myArray[i] = null;
        }
        size = 0;

    }

    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public boolean contains(Object o){
        for(E e: myArray){
            if (e.equals(o)) return true;
        }
        return false;
    }
}
