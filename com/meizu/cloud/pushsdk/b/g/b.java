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
/* loaded from: classes2.dex */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f68286c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    public j f68287a;

    /* renamed from: b  reason: collision with root package name */
    public long f68288b;

    public int a(byte[] bArr, int i2, int i3) {
        o.a(bArr.length, i2, i3);
        j jVar = this.f68287a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i3, jVar.f68310c - jVar.f68309b);
        System.arraycopy(jVar.f68308a, jVar.f68309b, bArr, i2, min);
        int i4 = jVar.f68309b + min;
        jVar.f68309b = i4;
        this.f68288b -= min;
        if (i4 == jVar.f68310c) {
            this.f68287a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.f68288b;
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
                        byte[] bArr = c2.f68308a;
                        int i5 = c2.f68310c - i2;
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
                        int i7 = c2.f68310c;
                        int i8 = (i5 + i6) - i7;
                        c2.f68310c = i7 + i8;
                        this.f68288b += i8;
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
        o.a(this.f68288b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                j jVar = this.f68287a;
                if (jVar.f68309b + j > jVar.f68310c) {
                    return new String(a(j), charset);
                }
                String str = new String(jVar.f68308a, jVar.f68309b, (int) j, charset);
                int i2 = (int) (jVar.f68309b + j);
                jVar.f68309b = i2;
                this.f68288b -= j;
                if (i2 == jVar.f68310c) {
                    this.f68287a = jVar.a();
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
        o.a(bVar.f68288b, 0L, j);
        while (j > 0) {
            j jVar = bVar.f68287a;
            if (j < jVar.f68310c - jVar.f68309b) {
                j jVar2 = this.f68287a;
                j jVar3 = jVar2 != null ? jVar2.f68314g : null;
                if (jVar3 != null && jVar3.f68312e) {
                    if ((jVar3.f68310c + j) - (jVar3.f68311d ? 0 : jVar3.f68309b) <= 2048) {
                        bVar.f68287a.a(jVar3, (int) j);
                        bVar.f68288b -= j;
                        this.f68288b += j;
                        return;
                    }
                }
                bVar.f68287a = bVar.f68287a.a((int) j);
            }
            j jVar4 = bVar.f68287a;
            long j2 = jVar4.f68310c - jVar4.f68309b;
            bVar.f68287a = jVar4.a();
            j jVar5 = this.f68287a;
            if (jVar5 == null) {
                this.f68287a = jVar4;
                jVar4.f68314g = jVar4;
                jVar4.f68313f = jVar4;
            } else {
                jVar5.f68314g.a(jVar4).b();
            }
            bVar.f68288b -= j2;
            this.f68288b += j2;
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
        o.a(this.f68288b, 0L, j);
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
            long j2 = this.f68288b;
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
        byte[] bArr = c2.f68308a;
        int i3 = c2.f68310c;
        c2.f68310c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f68288b++;
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
                int min = Math.min(i4 - i2, 2048 - c2.f68310c);
                System.arraycopy(bArr, i2, c2.f68308a, c2.f68310c, min);
                i2 += min;
                c2.f68310c += min;
            }
            this.f68288b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        j jVar;
        while (j > 0) {
            if (this.f68287a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, jVar.f68310c - jVar.f68309b);
            long j2 = min;
            this.f68288b -= j2;
            j -= j2;
            j jVar2 = this.f68287a;
            int i2 = jVar2.f68309b + min;
            jVar2.f68309b = i2;
            if (i2 == jVar2.f68310c) {
                this.f68287a = jVar2.a();
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
        byte[] bArr = c2.f68308a;
        int i4 = c2.f68310c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f68286c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        c2.f68310c += i3;
        this.f68288b += i3;
        return this;
    }

    public j c(int i2) {
        if (i2 < 1 || i2 > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.f68287a;
        if (jVar != null) {
            j jVar2 = jVar.f68314g;
            return (jVar2.f68310c + i2 > 2048 || !jVar2.f68312e) ? jVar2.a(k.a()) : jVar2;
        }
        j a2 = k.a();
        this.f68287a = a2;
        a2.f68314g = a2;
        a2.f68313f = a2;
        return a2;
    }

    public boolean c() {
        return this.f68288b == 0;
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
        byte[] bArr = c2.f68308a;
        int i2 = c2.f68310c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f68286c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f68310c += numberOfTrailingZeros;
        this.f68288b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f68288b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.f68288b > 0) {
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
        long j = this.f68288b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f68287a.f68314g;
        int i2 = jVar.f68310c;
        return (i2 >= 2048 || !jVar.f68312e) ? j : j - (i2 - jVar.f68309b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j = this.f68288b;
            if (j != bVar.f68288b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            j jVar = this.f68287a;
            j jVar2 = bVar.f68287a;
            int i2 = jVar.f68309b;
            int i3 = jVar2.f68309b;
            while (j2 < this.f68288b) {
                long min = Math.min(jVar.f68310c - i2, jVar2.f68310c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (jVar.f68308a[i2] != jVar2.f68308a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == jVar.f68310c) {
                    jVar = jVar.f68313f;
                    i2 = jVar.f68309b;
                }
                if (i3 == jVar2.f68310c) {
                    jVar2 = jVar2.f68313f;
                    i3 = jVar2.f68309b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j = this.f68288b;
        if (j != 0) {
            j jVar = this.f68287a;
            int i2 = jVar.f68309b;
            int i3 = jVar.f68310c;
            int i4 = i2 + 1;
            byte b2 = jVar.f68308a[i2];
            this.f68288b = j - 1;
            if (i4 == i3) {
                this.f68287a = jVar.a();
                k.a(jVar);
            } else {
                jVar.f68309b = i4;
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
            return a(this.f68288b, o.f68320a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.f68287a;
        if (jVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = jVar.f68310c;
            for (int i4 = jVar.f68309b; i4 < i3; i4++) {
                i2 = (i2 * 31) + jVar.f68308a[i4];
            }
            jVar = jVar.f68313f;
        } while (jVar != this.f68287a);
        return i2;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f68288b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.f68288b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f68288b == 0) {
            return bVar;
        }
        j jVar = new j(this.f68287a);
        bVar.f68287a = jVar;
        jVar.f68314g = jVar;
        jVar.f68313f = jVar;
        j jVar2 = this.f68287a;
        while (true) {
            jVar2 = jVar2.f68313f;
            if (jVar2 == this.f68287a) {
                bVar.f68288b = this.f68288b;
                return bVar;
            }
            bVar.f68287a.f68314g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j = this.f68288b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f68288b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f68287a.f68308a, this.f68287a.f68309b, this.f68287a.f68310c - this.f68287a.f68309b);
            j jVar = this.f68287a;
            while (true) {
                jVar = jVar.f68313f;
                if (jVar == this.f68287a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f68288b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.f68308a, jVar.f68309b, jVar.f68310c - jVar.f68309b);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
