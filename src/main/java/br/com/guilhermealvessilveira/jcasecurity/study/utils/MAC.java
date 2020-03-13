package br.com.guilhermealvessilveira.jcasecurity.study.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MAC {

	private static final String NO_ALGORITHM = "";

	private MAC() {
		throw new IllegalArgumentException("No MAC!");
	}

	public static byte[] encrypt(final byte[] input, final byte[] password)
			throws InvalidKeyException, NoSuchAlgorithmException {
		final var mac = getMac(password, NO_ALGORITHM);
		return mac.doFinal(input);
	}

	private static Mac getMac(final byte[] password, final String algorithm)
			throws NoSuchAlgorithmException, InvalidKeyException {
		final var mac = Mac.getInstance("HMACMD5");
		mac.init(new SecretKeySpec(password, algorithm));
		return mac;
	}
}
