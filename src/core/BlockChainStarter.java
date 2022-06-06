package core;

import java.util.ArrayList;

import util.Util;

public class BlockChainStarter { // BlockChain�� ���������� �����ϴ� Main �޼ҵ尡 ���Ե� Ŭ����

	public static void main(String[] args) {
		
		Block block1 = new Block(1, null, 0, new ArrayList());
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList());
		block2.addTransaction(new Transaction("�ݿ���", "�쵿��", 1.5));
		block2.addTransaction(new Transaction("�ڼ���", "�쵿��", 0.7));
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList());
		block3.addTransaction(new Transaction("��â��", "�ݿ���", 8.2));
		block3.addTransaction(new Transaction("�쵿��", "�ڼ���", 0.4));
//		block3.addTransaction(new Transaction("�쵿��", "�ڼ���", 9.9)); // ���� �ڼ����̶�� ��Ŀ�� ������ ���� ������ ������ ���
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block(4, block3.getBlockHash(), 0, new ArrayList());
		block4.addTransaction(new Transaction("�ݿ���", "��â��", 0.1));
		block4.mine();
		block4.getInformation();

	}

}
