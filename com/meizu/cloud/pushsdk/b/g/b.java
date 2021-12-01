package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.google.android.material.slider.BasicLabelFormatter;
import com.kuaishou.weapon.un.w0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f60327c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    public j a;

    /* renamed from: b  reason: collision with root package name */
    public long f60328b;

    public int a(byte[] bArr, int i2, int i3) {
        o.a(bArr.length, i2, i3);
        j jVar = this.a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i3, jVar.f60340c - jVar.f60339b);
        System.arraycopy(jVar.a, jVar.f60339b, bArr, i2, min);
        int i4 = jVar.f60339b + min;
        jVar.f60339b = i4;
        this.f60328b -= min;
        if (i4 == jVar.f60340c) {
            this.a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.f60328b;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long b2 = mVar.b(this, 2048L);
            if (b2 == -1) {
                return j2;
            }
            j2 += b2;
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
                    i3 = (i2 >> 12) | w0.Q;
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
                        byte[] bArr = c2.a;
                        int i5 = c2.f60340c - i2;
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
                        int i7 = c2.f60340c;
                        int i8 = (i5 + i6) - i7;
                        c2.f60340c = i7 + i8;
                        this.f60328b += i8;
                        i2 = i6;
                    } else {
                        if (charAt < 2048) {
                            i4 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            b((charAt >> '\f') | w0.Q);
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

    public String a(long j2, Charset charset) throws EOFException {
        o.a(this.f60328b, 0L, j2);
        if (charset != null) {
            if (j2 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
            } else if (j2 == 0) {
                return "";
            } else {
                j jVar = this.a;
                if (jVar.f60339b + j2 > jVar.f60340c) {
                    return new String(a(j2), charset);
                }
                String str = new String(jVar.a, jVar.f60339b, (int) j2, charset);
                int i2 = (int) (jVar.f60339b + j2);
                jVar.f60339b = i2;
                this.f60328b -= j2;
                if (i2 == jVar.f60340c) {
                    this.a = jVar.a();
                    k.a(jVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j2) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        o.a(bVar.f60328b, 0L, j2);
        while (j2 > 0) {
            j jVar = bVar.a;
            if (j2 < jVar.f60340c - jVar.f60339b) {
                j jVar2 = this.a;
                j jVar3 = jVar2 != null ? jVar2.f60344g : null;
                if (jVar3 != null && jVar3.f60342e) {
                    if ((jVar3.f60340c + j2) - (jVar3.f60341d ? 0 : jVar3.f60339b) <= 2048) {
                        bVar.a.a(jVar3, (int) j2);
                        bVar.f60328b -= j2;
                        this.f60328b += j2;
                        return;
                    }
                }
                bVar.a = bVar.a.a((int) j2);
            }
            j jVar4 = bVar.a;
            long j3 = jVar4.f60340c - jVar4.f60339b;
            bVar.a = jVar4.a();
            j jVar5 = this.a;
            if (jVar5 == null) {
                this.a = jVar4;
                jVar4.f60344g = jVar4;
                jVar4.f60343f = jVar4;
            } else {
                jVar5.f60344g.a(jVar4).b();
            }
            bVar.f60328b -= j3;
            this.f60328b += j3;
            j2 -= j3;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a = a(bArr, i2, bArr.length - i2);
            if (a == -1) {
                throw new EOFException();
            }
            i2 += a;
        }
    }

    public byte[] a(long j2) throws EOFException {
        o.a(this.f60328b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j2) {
        if (bVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            long j3 = this.f60328b;
            if (j3 == 0) {
                return -1L;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            bVar.a(this, j2);
            return j2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this;
    }

    public b b(int i2) {
        j c2 = c(1);
        byte[] bArr = c2.a;
        int i3 = c2.f60340c;
        c2.f60340c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f60328b++;
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
            long j2 = i3;
            o.a(bArr.length, i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                j c2 = c(1);
                int min = Math.min(i4 - i2, 2048 - c2.f60340c);
                System.arraycopy(bArr, i2, c2.a, c2.f60340c, min);
                i2 += min;
                c2.f60340c += min;
            }
            this.f60328b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j2) throws EOFException {
        j jVar;
        while (j2 > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j2, jVar.f60340c - jVar.f60339b);
            long j3 = min;
            this.f60328b -= j3;
            j2 -= j3;
            j jVar2 = this.a;
            int i2 = jVar2.f60339b + min;
            jVar2.f60339b = i2;
            if (i2 == jVar2.f60340c) {
                this.a = jVar2.a();
                k.a(jVar2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: c */
    public b e(long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return b(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < BasicLabelFormatter.TRILLION ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        j c2 = c(i3);
        byte[] bArr = c2.a;
        int i4 = c2.f60340c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = f60327c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        c2.f60340c += i3;
        this.f60328b += i3;
        return this;
    }

    public j c(int i2) {
        if (i2 < 1 || i2 > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.a;
        if (jVar != null) {
            j jVar2 = jVar.f60344g;
            return (jVar2.f60340c + i2 > 2048 || !jVar2.f60342e) ? jVar2.a(k.a()) : jVar2;
        }
        j a = k.a();
        this.a = a;
        a.f60344g = a;
        a.f60343f = a;
        return a;
    }

    public boolean c() {
        return this.f60328b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() {
    }

    public b d(long j2) {
        if (j2 == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i2 = c2.f60340c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f60327c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        c2.f60340c += numberOfTrailingZeros;
        this.f60328b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f60328b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.f60328b > 0) {
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
        long j2 = this.f60328b;
        if (j2 == 0) {
            return 0L;
        }
        j jVar = this.a.f60344g;
        int i2 = jVar.f60340c;
        return (i2 >= 2048 || !jVar.f60342e) ? j2 : j2 - (i2 - jVar.f60339b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j2 = this.f60328b;
            if (j2 != bVar.f60328b) {
                return false;
            }
            long j3 = 0;
            if (j2 == 0) {
                return true;
            }
            j jVar = this.a;
            j jVar2 = bVar.a;
            int i2 = jVar.f60339b;
            int i3 = jVar2.f60339b;
            while (j3 < this.f60328b) {
                long min = Math.min(jVar.f60340c - i2, jVar2.f60340c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (jVar.a[i2] != jVar2.a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == jVar.f60340c) {
                    jVar = jVar.f60343f;
                    i2 = jVar.f60339b;
                }
                if (i3 == jVar2.f60340c) {
                    jVar2 = jVar2.f60343f;
                    i3 = jVar2.f60339b;
                }
                j3 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j2 = this.f60328b;
        if (j2 != 0) {
            j jVar = this.a;
            int i2 = jVar.f60339b;
            int i3 = jVar.f60340c;
            int i4 = i2 + 1;
            byte b2 = jVar.a[i2];
            this.f60328b = j2 - 1;
            if (i4 == i3) {
                this.a = jVar.a();
                k.a(jVar);
            } else {
                jVar.f60339b = i4;
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
            return a(this.f60328b, o.a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.a;
        if (jVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = jVar.f60340c;
            for (int i4 = jVar.f60339b; i4 < i3; i4++) {
                i2 = (i2 * 31) + jVar.a[i4];
            }
            jVar = jVar.f60343f;
        } while (jVar != this.a);
        return i2;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f60328b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.f60328b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f60328b == 0) {
            return bVar;
        }
        j jVar = new j(this.a);
        bVar.a = jVar;
        jVar.f60344g = jVar;
        jVar.f60343f = jVar;
        j jVar2 = this.a;
        while (true) {
            jVar2 = jVar2.f60343f;
            if (jVar2 == this.a) {
                bVar.f60328b = this.f60328b;
                return bVar;
            }
            bVar.a.f60344g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j2 = this.f60328b;
        if (j2 == 0) {
            return "Buffer[size=0]";
        }
        if (j2 <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f60328b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.a.a, this.a.f60339b, this.a.f60340c - this.a.f60339b);
            j jVar = this.a;
            while (true) {
                jVar = jVar.f60343f;
                if (jVar == this.a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f60328b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.a, jVar.f60339b, jVar.f60340c - jVar.f60339b);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
