/* BookingFactoryTest.java
  Factory test case for Booking entity
  Author: Uthimna Sisipho Rubushe (221044329)
  Date:08 April 2023
 */
package za.ac.cput.dogparlor.factory;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.dogparlor.domain.Booking;


import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {
    @Test
    public void testObject() {
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        assertNotNull(booking);
    }

    @Test
    public void objectEquality() {
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        Booking booking2 = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        assertEquals(booking, booking2);

    }

    @Test
    public void objectIdentity() {
    
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        // test should fail if you create a new instance but with same values
        // to make test pass, we create a reference variable that points to the same object in memory
        Booking booking2 = booking;
        assertSame(booking, booking2);

    }

    @Test
    public void failingTest() {
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        Booking booking2 = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        assertSame(booking, booking2);
    }

    @Test
    @Timeout(1) // seconds
    public void timeOutTest() {
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");

        try {
            Thread.sleep(400); // half a second; increase to a number higher than 1000 milis to fail the test
            assertEquals(251, booking.getBookingID());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    @Ignore
    @Test
    public void ignoreThisTest() {
        Booking booking = BookingFactory.createBooking(251 , new Date() , new Time(new Date().getTime()).toString(),"Wash , Groom and Dip");
        assertNotNull(booking);
    }
}

