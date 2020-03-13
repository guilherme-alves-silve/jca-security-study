package br.com.guilhermealvessilveira.jcasecurity.study.messageauthenticationcode;

import br.com.guilhermealvessilveira.jcasecurity.study.utils.MAC;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class SimpleMACExample {

	public static void main (final String[] args)
			throws NoSuchAlgorithmException, InvalidKeyException {

		final var encrypted = MAC.encrypt("A string".getBytes(), "Password".getBytes());
		System.out.println("HEX: " + Hex.encodeHexString(encrypted));
	}
}
