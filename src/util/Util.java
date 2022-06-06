package util;

import java.security.MessageDigest;

public class Util {

	public static String getHash(String input) {  // getHash : 입력 값이 들어왔을 때 Hash 값을 구해주는 것을 의미
		StringBuffer result = new StringBuffer(); // 하나의 문자열을 만들 수 있는 객체
		try { // 예외 처리 시작
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // MessageDiget : 자바에서 기본적으로 제공하는 암호화
			md.update(input.getBytes()); // 업데이트, SHA-256으로 해시를 시키기 위한 준비
			byte bytes[] = md.digest();  // 해시 결과 값을 digest 함수를 이용해 byte 형태로 받기
			for (int i = 0; i < bytes.length; i++) {
				result.append( // byte를 문자열 형태로 출력하기 위함
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1) // 16진수 형태로 표현하기 위해 Integer.toString 문자열로 바꾸어줌
				);
			}
		} catch (Exception e) {  // 예외 처리 끝
			e.printStackTrace();
		}
		return result.toString();  // 만들어진 결과 값을 해시 형태로 출력하기
	}

}
