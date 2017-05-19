import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewwong on 5/19/17.
 */
public class TestMyArrayList {
    MyArrayList<Integer> myEmptyIntegerArrayList;
    MyArrayList<Integer> myNotEmptyIntegerArrayList;
    Integer integer0 = new Integer(0);
    Integer integer1 = new Integer(1);

    @Before
    public void initializeMyArrayLists(){
        myEmptyIntegerArrayList = new MyArrayList<Integer>();
        myNotEmptyIntegerArrayList = new MyArrayList<Integer>(2);
        myNotEmptyIntegerArrayList.add(integer0);
        myNotEmptyIntegerArrayList.add(integer1);

    }
    @Test
    public void testSimpleAdd(){
        //Given
        Integer num = new Integer(3);
        boolean expected = true;
        //When
        boolean actual = myEmptyIntegerArrayList.add(num);
        //Then
        assertEquals(expected, actual);
        assertEquals(num, myEmptyIntegerArrayList.get(0));
    }
    @Test
    public void testIndexAddToMiddle(){
        //Given
        int index = 1;
        Integer element = new Integer(5);
        Integer expected = element;
        //When
        myNotEmptyIntegerArrayList.add(index, element);
        Integer actual = myNotEmptyIntegerArrayList.get(index);
        //Then
        assertEquals(expected,actual);

    }
    @Test
    public void testIndexAddToBeginning(){
        //Given
        int index = 0;
        Integer element = new Integer(5);
        Integer expected = element;
        //When
        myNotEmptyIntegerArrayList.add(index, element);
        Integer actual = myNotEmptyIntegerArrayList.get(index);
        //Then
        assertEquals(expected,actual);

    }
    @Test
    public void testGet(){
        //Given
        Integer expected = new Integer(0);
        myEmptyIntegerArrayList.add(expected);
        //When
        Integer actual = myEmptyIntegerArrayList.get(0);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testRemoveMiddle(){
        //Given
        Integer integer20 = new Integer(20);
        myNotEmptyIntegerArrayList.add(integer20);
        //When
        Integer actual = myNotEmptyIntegerArrayList.remove(1);
        //Then
        assertEquals(integer1, actual);
        assertEquals(integer20, myNotEmptyIntegerArrayList.get(1));
    }
    @Test
    public void testRemoveBeginning(){
        //Given
        Integer integer20 = new Integer(20);
        myNotEmptyIntegerArrayList.add(integer20);
        //When
        Integer actual = myNotEmptyIntegerArrayList.remove(0);
        //Then
        assertEquals(integer0, actual);
        assertEquals(integer1, myNotEmptyIntegerArrayList.get(0));
        assertEquals(integer20, myNotEmptyIntegerArrayList.get(1));
    }
    @Test
    public void testSet(){
        //Given
        Integer expected = integer1;
        //When
        Integer actual = myNotEmptyIntegerArrayList.set(1, new Integer(10));
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testClear(){
        //Given
        //When
        myNotEmptyIntegerArrayList.clear();

        //Then
        assertEquals(0, myNotEmptyIntegerArrayList.size());
        assertEquals(null, myNotEmptyIntegerArrayList.get(0));
    }
    @Test
    public void testSize(){
        //Given
        int expected = 2;
        //When
        int actual = myNotEmptyIntegerArrayList.size();
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testIsNotEmpty(){
        //Given
        boolean expected = false;
        //When
        boolean actual = myNotEmptyIntegerArrayList.isEmpty();
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testIsEmpty(){
        //Given
        boolean expected = true;
        //When
        boolean actual = myEmptyIntegerArrayList.isEmpty();
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testContainsTrue(){
        //Given
        boolean expected = true;
        //When
        boolean actual = myNotEmptyIntegerArrayList.contains(integer0);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testContainsFalse(){
        //Given
        boolean expected = false;
        //When
        boolean actual = myEmptyIntegerArrayList.contains(integer0);
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void testAddAll(){
        //Given
        boolean expected = true;
        MyArrayList dummyList = new MyArrayList<Integer>();
        dummyList.add(new Integer(9));
        //When
        boolean actual = myNotEmptyIntegerArrayList.addAll(dummyList);
        //Then
        assertEquals(expected,actual);
    }
}
