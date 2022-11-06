package service;


import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;
import exception.passwordexp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WalletServiceTest {

    static WalletService ws = new WalletServiceImpl();

    @Test
    @Order(1)
    public void test_Register()  {
        try{
            Wallet newWallet = new Wallet(26, "prathe8", 1000.0, "d123");
            Wallet newWalle = new Wallet(27, "prathe8", 100.0, "d123");

            assertEquals(newWallet,ws.registerWallet(newWallet));
            assertEquals(newWalle,ws.registerWallet(newWalle));
        }catch (Exception e){
           e.printStackTrace();

        }

    }

    @Test
    @Order(2)
    public void test_Login()  {
        try{
            assertTrue(ws.login(11,"dsp"));

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Test
    @Order(3)
    public void test_AddFundsToWallets()  {
        try{
            assertEquals(1010,ws.addFundsToWallet(26,10.0));

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Test
    @Order(4)
    public void test_ShowWalletBalance()  {
        try{
            assertEquals(1010,ws.showWalletBalance(26));

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Test
    @Order(5)
    public void test_FundTransfer()  {
        try{

            assertEquals(true, ws.fundTransfer(26, 11, 10.0));


        }catch (Exception e){
            e.printStackTrace();

        }

    }



    @Test
    @Order(6)
    public void test_Withdraw()  {
        try{
            assertEquals(90.0, ws.withdraw(27, 10.0));

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Test
    @Order(7)
    public void test_UnRegisterWallet()  {
        try{

            assertEquals(null,ws.unRegisterWallet(26,"d123"));
            assertEquals(null,ws.unRegisterWallet(27,"d123"));


        }catch (Exception e){
            e.printStackTrace();

        }

    }



    @Test
    @Order(8)
    public void test_Register_Exception_When_SameId() {
        try{
            Wallet newWallet = new Wallet(11, "prathe8", 100.0, "d123");
            assertThrows(AlreadyExistingAccountNumberException.class,()-> ws.registerWallet(newWallet));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(9)
    public void test_Register_Exception_When_ZeroBalance() {
        try{
            Wallet newWallet = new Wallet(1111, "prathe8", 0.0, "d123");
            assertThrows(InsufficeintAmountException.class,()-> ws.registerWallet(newWallet));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(10)
    public void test_Register_Exception_When_InvalidAccountNumber() {
        try{
            Wallet newWallet = new Wallet(-11, "prathe8", 0.0, "d123");
            assertThrows(WalletException.class,()-> ws.registerWallet(newWallet));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(11)
    public void test_Login_Exception_MisMatch_Password() {
        try{

            assertThrows(passwordexp.class,()-> ws.login(11,"dsp1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(12)
    public void test_Login_Exception_MisMatch_userId() {
        try{

            assertThrows(WalletException.class,()-> ws.login(111,"dsp1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(13)
    public void test_AddFundsToWallets_Exception_userId_NotFound() {
        try{

            assertThrows(WalletException.class,()-> ws.addFundsToWallet(111,100.0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(14)
    public void test_ShowWallet_Balance_Exception() {
        try{
            assertThrows(WalletException.class,()-> ws.showWalletBalance(12));
        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Test
    @Order(15)
    public void test_FundTransfer_Exception_userId_NotFound() {
        try{
            assertThrows(WalletException.class,()-> ws.fundTransfer(12,11,10.0));
        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Test
    @Order(16)
    public void test_FundTransfer_Exception_lowBalance() {
        try{
            assertThrows(InsufficeintAmountException.class,()-> ws.fundTransfer(123,11,1000.0));
        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Test
    @Order(17)
    public void test_Withdraw_Exception_lowBalance() {
        try{
            assertThrows(InsufficeintAmountException.class,()-> ws.withdraw(11,100000.0));
        }catch (Exception e){
            e.printStackTrace();

        }


    }


    @Test
    @Order(18)
    public void test_Withdraw_Exception_userId_NotFound() {
        try{
            assertThrows(WalletException.class,()-> ws.withdraw(12,10.0));
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @Test
    @Order(19)
    public void test_DeleteWallet_Exception_MisMatch_Password() {
        try{

            assertThrows(passwordexp.class,()-> ws.unRegisterWallet(11,"dsp1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(20)
    public void test_DeleteWallet_Exception_MisMatch_userId() {
        try{

            assertThrows(WalletException.class,()-> ws.unRegisterWallet(111,"dsp1"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

























}