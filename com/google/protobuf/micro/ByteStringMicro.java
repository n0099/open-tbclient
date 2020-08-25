package com.google.protobuf.micro;

import java.io.UnsupportedEncodingException;
/* loaded from: classes20.dex */
public final class ByteStringMicro {
    public static final ByteStringMicro EMPTY = new ByteStringMicro(new byte[0]);
    private final byte[] bytes;
    private volatile int hash = 0;

    private ByteStringMicro(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte byteAt(int i) {
        return this.bytes[i];
    }

    public int size() {
        return this.bytes.length;
    }

    public boolean isEmpty() {
        return this.bytes.length == 0;
    }

    public static ByteStringMicro copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteStringMicro(bArr2);
    }

    public static ByteStringMicro copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteStringMicro copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new ByteStringMicro(str.getBytes(str2));
    }

    public static ByteStringMicro copyFromUtf8(String str) {
        try {
            return new ByteStringMicro(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }

    public void copyTo(byte[] bArr, int i) {
        System.arraycopy(this.bytes, 0, bArr, i, this.bytes.length);
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public byte[] toByteArray() {
        int length = this.bytes.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.bytes, 0, bArr, 0, length);
        return bArr;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, str);
    }

    public String toStringUtf8() {
        try {
            return new String(this.bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteStringMicro) {
            ByteStringMicro byteStringMicro = (ByteStringMicro) obj;
            int length = this.bytes.length;
            if (length != byteStringMicro.bytes.length) {
                return false;
            }
            byte[] bArr = this.bytes;
            byte[] bArr2 = byteStringMicro.bytes;
            for (int i = 0; i < length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            byte[] bArr = this.bytes;
            int length = this.bytes.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                i2++;
                i = bArr[i2] + (i * 31);
            }
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }
}
