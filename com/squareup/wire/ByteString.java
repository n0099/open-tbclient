package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes7.dex */
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

    public static ByteString read(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                throw new EOFException("Expected " + i2 + "; received " + i3);
            }
            i3 += read;
        }
        return new ByteString(bArr);
    }

    public byte byteAt(int i2) {
        return this.data[i2];
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof ByteString) && Arrays.equals(((ByteString) obj).data, this.data);
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
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

    public static ByteString of(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new ByteString(bArr2);
    }

    public void write(OutputStream outputStream, int i2, int i3) throws IOException {
        outputStream.write(this.data, i2, i3);
    }

    public static ByteString of(String str) {
        return new ByteString(Stringer.decode(str));
    }
}
