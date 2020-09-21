package com.meizu.cloud.pushsdk.b.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class e implements Serializable, Comparable<e> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final e b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(byte[] bArr) {
        this.c = bArr;
    }

    public static e a(InputStream inputStream, int i) throws IOException {
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
        return new e(bArr);
    }

    public static e a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        e eVar = new e(str.getBytes(o.a));
        eVar.e = str;
        return eVar;
    }

    public static e a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new e((byte[]) bArr.clone());
    }

    private e b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = e.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.c);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int i) {
        return this.c[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        int d = d();
        int d2 = eVar.d();
        int min = Math.min(d, d2);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = eVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (d == d2) {
            return 0;
        }
        return d >= d2 ? 1 : -1;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, o.a);
        this.e = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        bVar.c(this.c, 0, this.c.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i <= this.c.length - i3 && i2 <= bArr.length - i3 && o.a(this.c, i, bArr, i2, i3);
    }

    public e b() {
        return b("MD5");
    }

    public String c() {
        byte[] bArr;
        char[] cArr = new char[this.c.length * 2];
        int i = 0;
        for (byte b2 : this.c) {
            int i2 = i + 1;
            cArr[i] = a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b2 & 15];
        }
        return new String(cArr);
    }

    public int d() {
        return this.c.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof e) && ((e) obj).d() == this.c.length && ((e) obj).a(0, this.c, 0, this.c.length);
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        return this.c.length == 0 ? "ByteString[size=0]" : this.c.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(this.c.length), c()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(this.c.length), b().c());
    }
}
