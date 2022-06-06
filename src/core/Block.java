package core;

import java.util.ArrayList;

import util.Util; // util ��Ű�� �ҷ�����

public class Block {
	
	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private ArrayList<Transaction> transactionList;
	
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
		super();
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	public void addTransaction(Transaction transaction) { // Ʈ������� �߻����� �� Ʈ������� �ش� ��Ͽ� �߰��ϴ� �Լ�
		transactionList.add(transaction);
	}

	public void getInformation() {
		System.out.println("--------------------------");
		System.out.println("��� ��ȣ : " + getBlockID());
		System.out.println("���� �ؽ� �� : " + getPreviousBlockHash());
		System.out.println("ä�� ���� �� : " + getNonce());
		System.out.println("Ʈ����� ���� : " +  transactionList.size() + "��");
		for (int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("��� �ؽ� : " + getBlockHash());
		System.out.println("--------------------------");
	} 
	
	public String getBlockHash() { // Ʈ����� ������ �����̶� �����Ǵ� ��� �ؽ� ���� ��� ����ǵ��� ����
		String transactionInformations = "";
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println(blockID + "��° ����� ä���� �����߽��ϴ�");
				break;
			}
			nonce++;
		}
	}
	
	
	
	
}
