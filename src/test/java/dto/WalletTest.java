package dto;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    public void testSetId() {
        Wallet  W = new Wallet();
        W.setId(11);
        assertTrue(W.getId() == 11);
    }

    @Test
    public void testSetName() {
        Wallet  W = new Wallet();
        W.setName("test");
        assertTrue(W.getName() == "test");
        assertFalse(W.getName() == "tes");
    }

    @Test
    public void testSetBalance() {
        Wallet  W = new Wallet();
        W.setBalance(11.0);
        assertTrue(W.getBalance() == 11.0);
    }

    @Test
    public void testSetPassword() {
        Wallet  W = new Wallet();
        W.setPassword("test123");
        assertTrue(W.getPassword() == "test123");

    }

    @Test
    public void testToString()
    {
        Wallet w = new Wallet();
        w.setId(100);
        w.setName("hello");
        w.setBalance(1000.0);
        w.setPassword("test1234");
        assertEquals("Wallet [id=100, name=hello, balance=1000.0, password=test1234]",
               w.toString());
    }



}