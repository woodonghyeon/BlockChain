package core;

import java.util.ArrayList;

import util.Util;

public class BlockChainStarter { // BlockChain을 실질적으로 실행하는 Main 메소드가 포함된 클래스

	public static void main(String[] args) {
		
		Block block1 = new Block(1, null, 0, new ArrayList());
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList());
		block2.addTransaction(new Transaction("반영서", "우동현", 1.5));
		block2.addTransaction(new Transaction("박순범", "우동현", 0.7));
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList());
		block3.addTransaction(new Transaction("송창민", "반영서", 8.2));
		block3.addTransaction(new Transaction("우동현", "박순범", 0.4));
//		block3.addTransaction(new Transaction("우동현", "박순범", 9.9)); // 만약 박순범이라는 해커가 보내는 코인 개수를 수정한 경우
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block(4, block3.getBlockHash(), 0, new ArrayList());
		block4.addTransaction(new Transaction("반영서", "송창민", 0.1));
		block4.mine();
		block4.getInformation();

	}

}
