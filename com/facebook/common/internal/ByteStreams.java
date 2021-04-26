package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class ByteStreams {
    public static final int BUF_SIZE = 4096;

    /* loaded from: classes6.dex */
    public static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
        public FastByteArrayOutputStream() {
        }

        public void writeTo(byte[] bArr, int i2) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i2, ((ByteArrayOutputStream) this).count);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static int read(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    break;
                }
                i4 += read;
            }
            return i4;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int read = read(inputStream, bArr, i2, i3);
        if (read == i3) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + read + " bytes; " + i3 + " bytes expected");
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = i2;
        while (i3 > 0) {
            int i4 = i2 - i3;
            int read = inputStream.read(bArr, i4, i3);
            if (read == -1) {
                return Arrays.copyOf(bArr, i4);
            }
            i3 -= read;
        }
        int read2 = inputStream.read();
        if (read2 == -1) {
            return bArr;
        }
        FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        fastByteArrayOutputStream.write(read2);
        copy(inputStream, fastByteArrayOutputStream);
        byte[] bArr2 = new byte[fastByteArrayOutputStream.size() + i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        fastByteArrayOutputStream.writeTo(bArr2, i2);
        return bArr2;
    }
}
