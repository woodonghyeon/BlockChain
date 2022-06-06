package core;

import java.util.ArrayList;

import util.Util; // util 패키지 불러오기

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
	
	public void addTransaction(Transaction transaction) { // 트랜잭션이 발생했을 때 트랜잭션을 해당 블록에 추가하는 함수
		transactionList.add(transaction);
	}

	public void getInformation() {
		System.out.println("--------------------------");
		System.out.println("블록 번호 : " + getBlockID());
		System.out.println("이전 해시 값 : " + getPreviousBlockHash());
		System.out.println("채굴 변수 값 : " + getNonce());
		System.out.println("트랜잭션 개수 : " +  transactionList.size() + "개");
		for (int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("블록 해시 : " + getBlockHash());
		System.out.println("--------------------------");
	} 
	
	public String getBlockHash() { // 트랜잭션 정보가 조금이라도 변조되는 경우 해시 값이 모두 변경되도록 설정
		String transactionInformations = "";
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println(blockID + "번째 블록의 채굴에 성공했습니다");
				break;
			}
			nonce++;
		}
	}
	
	
	
	
}
