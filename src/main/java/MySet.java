/**
 * Created by andrewwong on 5/19/17.
 */
public class MySet<E> extends MyArrayList<E>{
    E[] setElements;
    private int size = 0;

    public MySet() {
        setElements = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e){
        for(E element: setElements){
            if(element==null ? element==null : element.equals(e)){

            }
        }
        return super.add(e);
    }
}
