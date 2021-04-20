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
/* loaded from: classes6.dex */
public class e implements Serializable, Comparable<e> {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37875a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final e f37876b = a(new byte[0]);
    public static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f37877c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f37878d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f37879e;

    public e(byte[] bArr) {
        this.f37877c = bArr;
    }

    public static e a(InputStream inputStream, int i) throws IOException {
        if (inputStream != null) {
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
        throw new IllegalArgumentException("in == null");
    }

    public static e a(String str) {
        if (str != null) {
            e eVar = new e(str.getBytes(o.f37905a));
            eVar.f37879e = str;
            return eVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static e a(byte... bArr) {
        if (bArr != null) {
            return new e((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private e b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f37877c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = e.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.f37877c);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f37877c.length);
        objectOutputStream.write(this.f37877c);
    }

    public byte a(int i) {
        return this.f37877c[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        int d2 = d();
        int d3 = eVar.d();
        int min = Math.min(d2, d3);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = eVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (d2 == d3) {
            return 0;
        }
        return d2 < d3 ? -1 : 1;
    }

    public String a() {
        String str = this.f37879e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f37877c, o.f37905a);
        this.f37879e = str2;
        return str2;
    }

    public void a(b bVar) {
        byte[] bArr = this.f37877c;
        bVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f37877c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && o.a(bArr2, i, bArr, i2, i3);
    }

    public e b() {
        return b("MD5");
    }

    public String c() {
        byte[] bArr = this.f37877c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f37875a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int d() {
        return this.f37877c.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            int d2 = eVar.d();
            byte[] bArr = this.f37877c;
            if (d2 == bArr.length && eVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f37878d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f37877c);
        this.f37878d = hashCode;
        return hashCode;
    }

    public String toString() {
        byte[] bArr = this.f37877c;
        return bArr.length == 0 ? "ByteString[size=0]" : bArr.length <= 16 ? String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c()) : String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), b().c());
    }
}
