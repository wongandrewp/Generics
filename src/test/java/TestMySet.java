import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewwong on 5/19/17.
 */
public class TestMySet {
    MySet<Integer> mySet;
    Integer integer0 = new Integer(0);
    Integer integer1 = new Integer(1);
    Integer integer2 = new Integer(2);

    @Before
    public void init(){
        mySet = new MySet<>();
    }

    @Test
    public void testValidAdd(){
        //Given
        //When
        mySet.add(integer0);
        //Then
        assertEquals(integer0, mySet.get(0));
    }

    @Test
    public void testInvalidAdd(){
        //Given
        //When
        //Then
    }
    @Test
    public void testValidAddAll(){
        //Given
        //When
        //Then
    }

    @Test
    public void testInvalidAddAll(){
        //Given
        //When
        //Then
    }
}
