package br.com.guilhermealvessilveira.jcasecurity.study.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteUtils {

    private static final int BUFF_SIZE = 1024;

    private ByteUtils() {
        throw new IllegalArgumentException("No ByteUtils!");
    }

    public static byte[] toByteArray(final FileInputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final var buff = new byte[BUFF_SIZE * 16];

        int len;
        while (true) {
            len = in.read(buff);
            if (len < 0) {
                break;
            }
            baos.write(buff, 0, len);
        }

        return baos.toByteArray();
    }
}
