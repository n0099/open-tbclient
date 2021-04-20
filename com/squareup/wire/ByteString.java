package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class ByteString {
    public static final ByteString EMPTY = of(new byte[0]);
    public final byte[] data;
    public transient int hashCode;

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static ByteString of(byte... bArr) {
        return new ByteString((byte[]) bArr.clone());
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException("Expected " + i + "; received " + i2);
            }
            i2 += read;
        }
        return new ByteString(bArr);
    }

    public byte byteAt(int i) {
        return this.data[i];
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof ByteString) && Arrays.equals(((ByteString) obj).data, this.data);
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.data);
        this.hashCode = hashCode;
        return hashCode;
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        return Stringer.encode(this.data);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    public void write(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.data, i, i2);
    }

    public static ByteString of(String str) {
        return new ByteString(Stringer.decode(str));
    }
}
