package br.com.guilhermealvessilveira.jcasecurity.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Guilherme Alves Silveira
 */
public final class MD5 {

    private static final int BUFF_SIZE = 1024;

    private MD5() {
        throw new IllegalArgumentException("No MD5");
    }

    public static byte[] toMd5Hash(final byte[] value) throws NoSuchAlgorithmException {
        final var messageDigest = getMessageDigest();
        return messageDigest.digest(value);
    }

    public static byte[] toMd5Hash(final InputStream in) throws IOException, NoSuchAlgorithmException {

        final var messageDigest = getMessageDigest();
        final var buff = new byte[BUFF_SIZE * 16];
        int len;
        while (true) {
            len = in.read(buff);
            if (len < 0) {
                break;
            }
            messageDigest.update(buff, 0, len);
        }

        return messageDigest.digest();
    }

    private static MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }
}
