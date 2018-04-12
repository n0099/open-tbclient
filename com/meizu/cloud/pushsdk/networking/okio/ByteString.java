package com.meizu.cloud.pushsdk.networking.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    final byte[] b;
    transient int c;
    transient String d;
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.b = bArr;
    }

    public static ByteString of(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new ByteString((byte[]) bArr.clone());
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        n.a(bArr.length, i, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new ByteString(bArr2);
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(n.a));
        byteString.d = str;
        return byteString;
    }

    public String utf8() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b, n.a);
        this.d = str2;
        return str2;
    }

    public String base64() {
        return a.a(this.b);
    }

    public ByteString md5() {
        return a("MD5");
    }

    public ByteString sha256() {
        return a("SHA-256");
    }

    private ByteString a(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.b));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String base64Url() {
        return a.b(this.b);
    }

    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a2 = a.a(str);
        if (a2 != null) {
            return new ByteString(a2);
        }
        return null;
    }

    public String hex() {
        byte[] bArr;
        char[] cArr = new char[this.b.length * 2];
        int i = 0;
        for (byte b : this.b) {
            int i2 = i + 1;
            cArr[i] = a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b & 15];
        }
        return new String(cArr);
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((a(str.charAt(i * 2)) << 4) + a(str.charAt((i * 2) + 1)));
        }
        return of(bArr);
    }

    private static int a(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    public static ByteString read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
        return new ByteString(bArr);
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b.length) {
                byte b = this.b[i2];
                if (b < 65 || b > 90) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.b.clone();
                    bArr[i2] = (byte) (b + 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b2 = bArr[i3];
                        if (b2 >= 65 && b2 <= 90) {
                            bArr[i3] = (byte) (b2 + 32);
                        }
                    }
                    return new ByteString(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b.length) {
                byte b = this.b[i2];
                if (b < 97 || b > 122) {
                    i = i2 + 1;
                } else {
                    byte[] bArr = (byte[]) this.b.clone();
                    bArr[i2] = (byte) (b - 32);
                    for (int i3 = i2 + 1; i3 < bArr.length; i3++) {
                        byte b2 = bArr[i3];
                        if (b2 >= 97 && b2 <= 122) {
                            bArr[i3] = (byte) (b2 - 32);
                        }
                    }
                    return new ByteString(bArr);
                }
            } else {
                return this;
            }
        }
    }

    public ByteString substring(int i) {
        return substring(i, this.b.length);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 > this.b.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.b.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i != 0 || i2 != this.b.length) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.b, i, bArr, 0, i3);
            return new ByteString(bArr);
        }
        return this;
    }

    public byte getByte(int i) {
        return this.b[i];
    }

    public int size() {
        return this.b.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.b.clone();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        bVar.c(this.b, 0, this.b.length);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.b, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i <= this.b.length - i3 && i2 <= bArr.length - i3 && n.a(this.b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ByteString) && ((ByteString) obj).size() == this.b.length && ((ByteString) obj).rangeEquals(0, this.b, 0, this.b.length);
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.b);
        this.c = hashCode;
        return hashCode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = getByte(i) & 255;
            int i3 = byteString.getByte(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size >= size2 ? 1 : -1;
    }

    public String toString() {
        if (this.b.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.b.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(this.b.length), hex());
        }
        return String.format("ByteString[size=%s md5=%s]", Integer.valueOf(this.b.length), md5().hex());
    }
}
