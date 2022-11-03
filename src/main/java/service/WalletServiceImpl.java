package service;


import dao.WalletDao;
import dao.WalletDaoImpl;
import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;

import java.util.Objects;

public class WalletServiceImpl implements WalletService {

	private WalletDao walletRepository = new WalletDaoImpl();
	
	
	public Wallet registerWallet(Wallet newWallet) throws WalletException, InsufficeintAmountException, AlreadyExistingAccountNumberException {
		
		return this.walletRepository.addWallet(newWallet);
		
	}

	public Boolean login(Integer walletId, String password) throws WalletException, InsufficeintAmountException {
		// TODO Auto-generated method stub
		boolean success = true;

		Wallet a= walletRepository.getWalletById(walletId);
		if(Objects.equals(a.getPassword(), password)){
			return success;
		}

		return false;
	}

	public Double addFundsToWallet(Integer walletId, Double amount) throws WalletException, InsufficeintAmountException {
		// TODO Auto-generated method stub
        Double a,b,f;
		Wallet c = this.walletRepository.getWalletById(walletId);

		a=c.getBalance();
		b=a+amount;
		c.setBalance(b);

		System.out.println(c);
		this.walletRepository.updateWallet(c);

		Wallet d = this.walletRepository.getWalletById(walletId);
		f=d.getBalance();




		return f;
	}

	public Double showWalletBalance(Integer walletId) throws WalletException, InsufficeintAmountException {
		// TODO Auto-generated method stub

		Wallet d =walletRepository.getWalletById(walletId);
		Double dd=d.getBalance();

		return dd;
	}

	public Boolean fundTransfer(Integer fromId, Integer toId, Double amount) throws WalletException, InsufficeintAmountException {
		// TODO Auto-generated method stub
		boolean success = true;
		Double a1, a2;
		Wallet a= walletRepository.getWalletById(fromId);
		Wallet bb =walletRepository.getWalletById(toId);

		a1=a.getBalance()-amount;
		a.setBalance(a1);
		a2=amount +bb.getBalance();
		bb.setBalance(a2);

		this.walletRepository.updateWallet(a);
		this.walletRepository.updateWallet(bb);




		return success;
	}

	public Wallet unRegisterWallet(Integer walletId, String password) throws WalletException, InsufficeintAmountException {
		// TODO Auto-generated method stub

		Wallet d =walletRepository.getWalletById(walletId);
		if(Objects.equals(d.getPassword(), password)){
			this.walletRepository.deleteWalletById(d.getId());
		}else {
			System.out.println("Paasowrd is wrong");
		}

		return null ;
	}

	@Override
	public Double withdraw(Integer walletId, Double amount) throws WalletException, InsufficeintAmountException {
		Double a,b,f;
		Wallet c = this.walletRepository.getWalletById(walletId);

		a=c.getBalance();
		b=a-amount;
		c.setBalance(b);

		System.out.println(c);
		this.walletRepository.updateWallet(c);

		Wallet d = this.walletRepository.getWalletById(walletId);
		f=d.getBalance();



		return f;
	}

}
