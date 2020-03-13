package br.com.guilhermealvessilveira.jcasecurity.study.simplehash;

import br.com.guilhermealvessilveira.jcasecurity.study.utils.MD5;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

/**
 * @author Guilherme Alves Silveira
 */
public class MainSimpleHash {

    public static void main (final String[] args) throws NoSuchAlgorithmException {

        final var value = MD5.toMd5Hash("some_value".getBytes());
        System.out.println("MD5 Hex: " + Hex.encodeHexString(value));
    }
}
