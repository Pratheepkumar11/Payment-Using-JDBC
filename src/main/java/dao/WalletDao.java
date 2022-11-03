package dao;


import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;

public interface WalletDao {
	//CRUD
	Wallet addWallet(Wallet newWallet) throws WalletException, AlreadyExistingAccountNumberException, InsufficeintAmountException;
	Wallet getWalletById(Integer walletId) throws WalletException, InsufficeintAmountException;
	Wallet updateWallet(Wallet updateWallet)throws WalletException;
	Wallet deleteWalletById(Integer walletID)throws WalletException;
}
