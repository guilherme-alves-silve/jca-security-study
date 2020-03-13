package br.com.guilhermealvessilveira.jcasecurity.study.efficientstreambasedhashing;

import br.com.guilhermealvessilveira.jcasecurity.study.utils.MD5;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class FileHashStreamExample {

	public static void main (final String[] args) throws IOException, NoSuchAlgorithmException {
		if (args.length != 2) {
			System.out.println("Pass one file name and the other a md5 hash");
			return;
		}

		final var fileName = args[0];
		final var hash = args[1];
		System.out.printf("File Name: %s%n", fileName);
		System.out.printf("Hash: %s%n", hash);
		try (final var fis = new FileInputStream(fileName)) {
			final var md5File = MD5.toMd5Hash(fis);
			final var md5String = Hex.encodeHexString(md5File);
			System.out.printf("File Hash: %s%n", md5String);
			System.out.println("Has the same hash? " + hash.equals(md5String));
		}
	}
}
