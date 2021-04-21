package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class b implements c, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f37966c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    public j f37967a;

    /* renamed from: b  reason: collision with root package name */
    public long f37968b;

    public int a(byte[] bArr, int i, int i2) {
        o.a(bArr.length, i, i2);
        j jVar = this.f37967a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.f37990c - jVar.f37989b);
        System.arraycopy(jVar.f37988a, jVar.f37989b, bArr, i, min);
        int i3 = jVar.f37989b + min;
        jVar.f37989b = i3;
        this.f37968b -= min;
        if (i3 == jVar.f37990c) {
            this.f37967a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.f37968b;
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

    public b a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    i2 = (i >> 12) | 224;
                } else if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                } else {
                    b((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                b(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            b(i3);
            i = (i & 63) | 128;
        }
        b(i);
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

    public b a(String str, int i, int i2) {
        int i3;
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        j c2 = c(1);
                        byte[] bArr = c2.f37988a;
                        int i4 = c2.f37990c - i;
                        int min = Math.min(i2, 2048 - i4);
                        int i5 = i + 1;
                        bArr[i + i4] = (byte) charAt;
                        while (i5 < min) {
                            char charAt2 = str.charAt(i5);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i5 + i4] = (byte) charAt2;
                            i5++;
                        }
                        int i6 = c2.f37990c;
                        int i7 = (i4 + i5) - i6;
                        c2.f37990c = i6 + i7;
                        this.f37968b += i7;
                        i = i5;
                    } else {
                        if (charAt < 2048) {
                            i3 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            b((charAt >> '\f') | 224);
                            i3 = ((charAt >> 6) & 63) | 128;
                        } else {
                            int i8 = i + 1;
                            char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                b(63);
                                i = i8;
                            } else {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                b((i9 >> 18) | 240);
                                b(((i9 >> 12) & 63) | 128);
                                b(((i9 >> 6) & 63) | 128);
                                b((i9 & 63) | 128);
                                i += 2;
                            }
                        }
                        b(i3);
                        b((charAt & '?') | 128);
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public String a(long j, Charset charset) throws EOFException {
        o.a(this.f37968b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                j jVar = this.f37967a;
                if (jVar.f37989b + j > jVar.f37990c) {
                    return new String(a(j), charset);
                }
                String str = new String(jVar.f37988a, jVar.f37989b, (int) j, charset);
                int i = (int) (jVar.f37989b + j);
                jVar.f37989b = i;
                this.f37968b -= j;
                if (i == jVar.f37990c) {
                    this.f37967a = jVar.a();
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
        o.a(bVar.f37968b, 0L, j);
        while (j > 0) {
            j jVar = bVar.f37967a;
            if (j < jVar.f37990c - jVar.f37989b) {
                j jVar2 = this.f37967a;
                j jVar3 = jVar2 != null ? jVar2.f37994g : null;
                if (jVar3 != null && jVar3.f37992e) {
                    if ((jVar3.f37990c + j) - (jVar3.f37991d ? 0 : jVar3.f37989b) <= 2048) {
                        bVar.f37967a.a(jVar3, (int) j);
                        bVar.f37968b -= j;
                        this.f37968b += j;
                        return;
                    }
                }
                bVar.f37967a = bVar.f37967a.a((int) j);
            }
            j jVar4 = bVar.f37967a;
            long j2 = jVar4.f37990c - jVar4.f37989b;
            bVar.f37967a = jVar4.a();
            j jVar5 = this.f37967a;
            if (jVar5 == null) {
                this.f37967a = jVar4;
                jVar4.f37994g = jVar4;
                jVar4.f37993f = jVar4;
            } else {
                jVar5.f37994g.a(jVar4).b();
            }
            bVar.f37968b -= j2;
            this.f37968b += j2;
            j -= j2;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 == -1) {
                throw new EOFException();
            }
            i += a2;
        }
    }

    public byte[] a(long j) throws EOFException {
        o.a(this.f37968b, 0L, j);
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
            long j2 = this.f37968b;
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

    public b b(int i) {
        j c2 = c(1);
        byte[] bArr = c2.f37988a;
        int i2 = c2.f37990c;
        c2.f37990c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f37968b++;
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
    public b c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            o.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                j c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.f37990c);
                System.arraycopy(bArr, i, c2.f37988a, c2.f37990c, min);
                i += min;
                c2.f37990c += min;
            }
            this.f37968b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        j jVar;
        while (j > 0) {
            if (this.f37967a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, jVar.f37990c - jVar.f37989b);
            long j2 = min;
            this.f37968b -= j2;
            j -= j2;
            j jVar2 = this.f37967a;
            int i = jVar2.f37989b + min;
            jVar2.f37989b = i;
            if (i == jVar2.f37990c) {
                this.f37967a = jVar2.a();
                k.a(jVar2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: c */
    public b e(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return b(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        j c2 = c(i2);
        byte[] bArr = c2.f37988a;
        int i3 = c2.f37990c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f37966c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        c2.f37990c += i2;
        this.f37968b += i2;
        return this;
    }

    public j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.f37967a;
        if (jVar != null) {
            j jVar2 = jVar.f37994g;
            return (jVar2.f37990c + i > 2048 || !jVar2.f37992e) ? jVar2.a(k.a()) : jVar2;
        }
        j a2 = k.a();
        this.f37967a = a2;
        a2.f37994g = a2;
        a2.f37993f = a2;
        return a2;
    }

    public boolean c() {
        return this.f37968b == 0;
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
        byte[] bArr = c2.f37988a;
        int i = c2.f37990c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f37966c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f37990c += numberOfTrailingZeros;
        this.f37968b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f37968b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.f37968b > 0) {
                    return bVar.f() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return b.this.a(bArr, i, i2);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public long e() {
        long j = this.f37968b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f37967a.f37994g;
        int i = jVar.f37990c;
        return (i >= 2048 || !jVar.f37992e) ? j : j - (i - jVar.f37989b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j = this.f37968b;
            if (j != bVar.f37968b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            j jVar = this.f37967a;
            j jVar2 = bVar.f37967a;
            int i = jVar.f37989b;
            int i2 = jVar2.f37989b;
            while (j2 < this.f37968b) {
                long min = Math.min(jVar.f37990c - i, jVar2.f37990c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (jVar.f37988a[i] != jVar2.f37988a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == jVar.f37990c) {
                    jVar = jVar.f37993f;
                    i = jVar.f37989b;
                }
                if (i2 == jVar2.f37990c) {
                    jVar2 = jVar2.f37993f;
                    i2 = jVar2.f37989b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j = this.f37968b;
        if (j != 0) {
            j jVar = this.f37967a;
            int i = jVar.f37989b;
            int i2 = jVar.f37990c;
            int i3 = i + 1;
            byte b2 = jVar.f37988a[i];
            this.f37968b = j - 1;
            if (i3 == i2) {
                this.f37967a = jVar.a();
                k.a(jVar);
            } else {
                jVar.f37989b = i3;
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
            return a(this.f37968b, o.f38000a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.f37967a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.f37990c;
            for (int i3 = jVar.f37989b; i3 < i2; i3++) {
                i = (i * 31) + jVar.f37988a[i3];
            }
            jVar = jVar.f37993f;
        } while (jVar != this.f37967a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f37968b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.f37968b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f37968b == 0) {
            return bVar;
        }
        j jVar = new j(this.f37967a);
        bVar.f37967a = jVar;
        jVar.f37994g = jVar;
        jVar.f37993f = jVar;
        j jVar2 = this.f37967a;
        while (true) {
            jVar2 = jVar2.f37993f;
            if (jVar2 == this.f37967a) {
                bVar.f37968b = this.f37968b;
                return bVar;
            }
            bVar.f37967a.f37994g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j = this.f37968b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f37968b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f37967a.f37988a, this.f37967a.f37989b, this.f37967a.f37990c - this.f37967a.f37989b);
            j jVar = this.f37967a;
            while (true) {
                jVar = jVar.f37993f;
                if (jVar == this.f37967a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f37968b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.f37988a, jVar.f37989b, jVar.f37990c - jVar.f37989b);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
