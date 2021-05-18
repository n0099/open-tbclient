package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f34762c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    public j f34763a;

    /* renamed from: b  reason: collision with root package name */
    public long f34764b;

    public int a(byte[] bArr, int i2, int i3) {
        o.a(bArr.length, i2, i3);
        j jVar = this.f34763a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i3, jVar.f34786c - jVar.f34785b);
        System.arraycopy(jVar.f34784a, jVar.f34785b, bArr, i2, min);
        int i4 = jVar.f34785b + min;
        jVar.f34785b = i4;
        this.f34764b -= min;
        if (i4 == jVar.f34786c) {
            this.f34763a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.f34764b;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b2 = mVar.b(this, 2048L);
            if (b2 == -1) {
                return j;
            }
            j += b2;
        }
    }

    public b a(int i2) {
        int i3;
        int i4;
        if (i2 >= 128) {
            if (i2 < 2048) {
                i4 = (i2 >> 6) | 192;
            } else {
                if (i2 < 65536) {
                    if (i2 >= 55296 && i2 <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                    }
                    i3 = (i2 >> 12) | 224;
                } else if (i2 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                } else {
                    b((i2 >> 18) | 240);
                    i3 = ((i2 >> 12) & 63) | 128;
                }
                b(i3);
                i4 = ((i2 >> 6) & 63) | 128;
            }
            b(i4);
            i2 = (i2 & 63) | 128;
        }
        b(i2);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: a */
    public b b(e eVar) {
        if (eVar != null) {
            eVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: a */
    public b b(String str) {
        return a(str, 0, str.length());
    }

    public b a(String str, int i2, int i3) {
        int i4;
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            } else if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            } else {
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        j c2 = c(1);
                        byte[] bArr = c2.f34784a;
                        int i5 = c2.f34786c - i2;
                        int min = Math.min(i3, 2048 - i5);
                        int i6 = i2 + 1;
                        bArr[i2 + i5] = (byte) charAt;
                        while (i6 < min) {
                            char charAt2 = str.charAt(i6);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i6 + i5] = (byte) charAt2;
                            i6++;
                        }
                        int i7 = c2.f34786c;
                        int i8 = (i5 + i6) - i7;
                        c2.f34786c = i7 + i8;
                        this.f34764b += i8;
                        i2 = i6;
                    } else {
                        if (charAt < 2048) {
                            i4 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            b((charAt >> '\f') | 224);
                            i4 = ((charAt >> 6) & 63) | 128;
                        } else {
                            int i9 = i2 + 1;
                            char charAt3 = i9 < i3 ? str.charAt(i9) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                b(63);
                                i2 = i9;
                            } else {
                                int i10 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                b((i10 >> 18) | 240);
                                b(((i10 >> 12) & 63) | 128);
                                b(((i10 >> 6) & 63) | 128);
                                b((i10 & 63) | 128);
                                i2 += 2;
                            }
                        }
                        b(i4);
                        b((charAt & '?') | 128);
                        i2++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j, Charset charset) throws EOFException {
        o.a(this.f34764b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                j jVar = this.f34763a;
                if (jVar.f34785b + j > jVar.f34786c) {
                    return new String(a(j), charset);
                }
                String str = new String(jVar.f34784a, jVar.f34785b, (int) j, charset);
                int i2 = (int) (jVar.f34785b + j);
                jVar.f34785b = i2;
                this.f34764b -= j;
                if (i2 == jVar.f34786c) {
                    this.f34763a = jVar.a();
                    k.a(jVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        o.a(bVar.f34764b, 0L, j);
        while (j > 0) {
            j jVar = bVar.f34763a;
            if (j < jVar.f34786c - jVar.f34785b) {
                j jVar2 = this.f34763a;
                j jVar3 = jVar2 != null ? jVar2.f34790g : null;
                if (jVar3 != null && jVar3.f34788e) {
                    if ((jVar3.f34786c + j) - (jVar3.f34787d ? 0 : jVar3.f34785b) <= 2048) {
                        bVar.f34763a.a(jVar3, (int) j);
                        bVar.f34764b -= j;
                        this.f34764b += j;
                        return;
                    }
                }
                bVar.f34763a = bVar.f34763a.a((int) j);
            }
            j jVar4 = bVar.f34763a;
            long j2 = jVar4.f34786c - jVar4.f34785b;
            bVar.f34763a = jVar4.a();
            j jVar5 = this.f34763a;
            if (jVar5 == null) {
                this.f34763a = jVar4;
                jVar4.f34790g = jVar4;
                jVar4.f34789f = jVar4;
            } else {
                jVar5.f34790g.a(jVar4).b();
            }
            bVar.f34764b -= j2;
            this.f34764b += j2;
            j -= j2;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 == -1) {
                throw new EOFException();
            }
            i2 += a2;
        }
    }

    public byte[] a(long j) throws EOFException {
        o.a(this.f34764b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.f34764b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            bVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this;
    }

    public b b(int i2) {
        j c2 = c(1);
        byte[] bArr = c2.f34784a;
        int i3 = c2.f34786c;
        c2.f34786c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f34764b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: b */
    public b c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            o.a(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                j c2 = c(1);
                int min = Math.min(i4 - i2, 2048 - c2.f34786c);
                System.arraycopy(bArr, i2, c2.f34784a, c2.f34786c, min);
                i2 += min;
                c2.f34786c += min;
            }
            this.f34764b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        j jVar;
        while (j > 0) {
            if (this.f34763a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, jVar.f34786c - jVar.f34785b);
            long j2 = min;
            this.f34764b -= j2;
            j -= j2;
            j jVar2 = this.f34763a;
            int i2 = jVar2.f34785b + min;
            jVar2.f34785b = i2;
            if (i2 == jVar2.f34786c) {
                this.f34763a = jVar2.a();
                k.a(jVar2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: c */
    public b e(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return b(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i3 = j < BasicLabelFormatter.TRILLION ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        j c2 = c(i3);
        byte[] bArr = c2.f34784a;
        int i4 = c2.f34786c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f34762c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        c2.f34786c += i3;
        this.f34764b += i3;
        return this;
    }

    public j c(int i2) {
        if (i2 < 1 || i2 > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.f34763a;
        if (jVar != null) {
            j jVar2 = jVar.f34790g;
            return (jVar2.f34786c + i2 > 2048 || !jVar2.f34788e) ? jVar2.a(k.a()) : jVar2;
        }
        j a2 = k.a();
        this.f34763a = a2;
        a2.f34790g = a2;
        a2.f34789f = a2;
        return a2;
    }

    public boolean c() {
        return this.f34764b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() {
    }

    public b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.f34784a;
        int i2 = c2.f34786c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f34762c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f34786c += numberOfTrailingZeros;
        this.f34764b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f34764b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.f34764b > 0) {
                    return bVar.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                return b.this.a(bArr, i2, i3);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.f34764b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f34763a.f34790g;
        int i2 = jVar.f34786c;
        return (i2 >= 2048 || !jVar.f34788e) ? j : j - (i2 - jVar.f34785b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j = this.f34764b;
            if (j != bVar.f34764b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            j jVar = this.f34763a;
            j jVar2 = bVar.f34763a;
            int i2 = jVar.f34785b;
            int i3 = jVar2.f34785b;
            while (j2 < this.f34764b) {
                long min = Math.min(jVar.f34786c - i2, jVar2.f34786c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (jVar.f34784a[i2] != jVar2.f34784a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == jVar.f34786c) {
                    jVar = jVar.f34789f;
                    i2 = jVar.f34785b;
                }
                if (i3 == jVar2.f34786c) {
                    jVar2 = jVar2.f34789f;
                    i3 = jVar2.f34785b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j = this.f34764b;
        if (j != 0) {
            j jVar = this.f34763a;
            int i2 = jVar.f34785b;
            int i3 = jVar.f34786c;
            int i4 = i2 + 1;
            byte b2 = jVar.f34784a[i2];
            this.f34764b = j - 1;
            if (i4 == i3) {
                this.f34763a = jVar.a();
                k.a(jVar);
            } else {
                jVar.f34785b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() {
    }

    public e g() {
        return new e(i());
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public String h() {
        try {
            return a(this.f34764b, o.f34796a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.f34763a;
        if (jVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = jVar.f34786c;
            for (int i4 = jVar.f34785b; i4 < i3; i4++) {
                i2 = (i2 * 31) + jVar.f34784a[i4];
            }
            jVar = jVar.f34789f;
        } while (jVar != this.f34763a);
        return i2;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f34764b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.f34764b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f34764b == 0) {
            return bVar;
        }
        j jVar = new j(this.f34763a);
        bVar.f34763a = jVar;
        jVar.f34790g = jVar;
        jVar.f34789f = jVar;
        j jVar2 = this.f34763a;
        while (true) {
            jVar2 = jVar2.f34789f;
            if (jVar2 == this.f34763a) {
                bVar.f34764b = this.f34764b;
                return bVar;
            }
            bVar.f34763a.f34790g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j = this.f34764b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f34764b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f34763a.f34784a, this.f34763a.f34785b, this.f34763a.f34786c - this.f34763a.f34785b);
            j jVar = this.f34763a;
            while (true) {
                jVar = jVar.f34789f;
                if (jVar == this.f34763a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f34764b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.f34784a, jVar.f34785b, jVar.f34786c - jVar.f34785b);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
