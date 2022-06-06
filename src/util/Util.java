package util;

import java.security.MessageDigest;

public class Util {

	public static String getHash(String input) {  // getHash : �Է� ���� ������ �� Hash ���� �����ִ� ���� �ǹ�
		StringBuffer result = new StringBuffer(); // �ϳ��� ���ڿ��� ���� �� �ִ� ��ü
		try { // ���� ó�� ����
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // MessageDiget : �ڹٿ��� �⺻������ �����ϴ� ��ȣȭ
			md.update(input.getBytes()); // ������Ʈ, SHA-256���� �ؽø� ��Ű�� ���� �غ�
			byte bytes[] = md.digest();  // �ؽ� ��� ���� digest �Լ��� �̿��� byte ���·� �ޱ�
			for (int i = 0; i < bytes.length; i++) {
				result.append( // byte�� ���ڿ� ���·� ����ϱ� ����
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1) // 16���� ���·� ǥ���ϱ� ���� Integer.toString ���ڿ��� �ٲپ���
				);
			}
		} catch (Exception e) {  // ���� ó�� ��
			e.printStackTrace();
		}
		return result.toString();  // ������� ��� ���� �ؽ� ���·� ����ϱ�
	}

}
