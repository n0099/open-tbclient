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
    public static final byte[] f37582c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    public j f37583a;

    /* renamed from: b  reason: collision with root package name */
    public long f37584b;

    public int a(byte[] bArr, int i, int i2) {
        o.a(bArr.length, i, i2);
        j jVar = this.f37583a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.f37606c - jVar.f37605b);
        System.arraycopy(jVar.f37604a, jVar.f37605b, bArr, i, min);
        int i3 = jVar.f37605b + min;
        jVar.f37605b = i3;
        this.f37584b -= min;
        if (i3 == jVar.f37606c) {
            this.f37583a = jVar.a();
            k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.f37584b;
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
                        byte[] bArr = c2.f37604a;
                        int i4 = c2.f37606c - i;
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
                        int i6 = c2.f37606c;
                        int i7 = (i4 + i5) - i6;
                        c2.f37606c = i6 + i7;
                        this.f37584b += i7;
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
        o.a(this.f37584b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                j jVar = this.f37583a;
                if (jVar.f37605b + j > jVar.f37606c) {
                    return new String(a(j), charset);
                }
                String str = new String(jVar.f37604a, jVar.f37605b, (int) j, charset);
                int i = (int) (jVar.f37605b + j);
                jVar.f37605b = i;
                this.f37584b -= j;
                if (i == jVar.f37606c) {
                    this.f37583a = jVar.a();
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
        o.a(bVar.f37584b, 0L, j);
        while (j > 0) {
            j jVar = bVar.f37583a;
            if (j < jVar.f37606c - jVar.f37605b) {
                j jVar2 = this.f37583a;
                j jVar3 = jVar2 != null ? jVar2.f37610g : null;
                if (jVar3 != null && jVar3.f37608e) {
                    if ((jVar3.f37606c + j) - (jVar3.f37607d ? 0 : jVar3.f37605b) <= 2048) {
                        bVar.f37583a.a(jVar3, (int) j);
                        bVar.f37584b -= j;
                        this.f37584b += j;
                        return;
                    }
                }
                bVar.f37583a = bVar.f37583a.a((int) j);
            }
            j jVar4 = bVar.f37583a;
            long j2 = jVar4.f37606c - jVar4.f37605b;
            bVar.f37583a = jVar4.a();
            j jVar5 = this.f37583a;
            if (jVar5 == null) {
                this.f37583a = jVar4;
                jVar4.f37610g = jVar4;
                jVar4.f37609f = jVar4;
            } else {
                jVar5.f37610g.a(jVar4).b();
            }
            bVar.f37584b -= j2;
            this.f37584b += j2;
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
        o.a(this.f37584b, 0L, j);
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
            long j2 = this.f37584b;
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
        byte[] bArr = c2.f37604a;
        int i2 = c2.f37606c;
        c2.f37606c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f37584b++;
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
                int min = Math.min(i3 - i, 2048 - c2.f37606c);
                System.arraycopy(bArr, i, c2.f37604a, c2.f37606c, min);
                i += min;
                c2.f37606c += min;
            }
            this.f37584b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void b(long j) throws EOFException {
        j jVar;
        while (j > 0) {
            if (this.f37583a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, jVar.f37606c - jVar.f37605b);
            long j2 = min;
            this.f37584b -= j2;
            j -= j2;
            j jVar2 = this.f37583a;
            int i = jVar2.f37605b + min;
            jVar2.f37605b = i;
            if (i == jVar2.f37606c) {
                this.f37583a = jVar2.a();
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
        byte[] bArr = c2.f37604a;
        int i3 = c2.f37606c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f37582c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        c2.f37606c += i2;
        this.f37584b += i2;
        return this;
    }

    public j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        j jVar = this.f37583a;
        if (jVar != null) {
            j jVar2 = jVar.f37610g;
            return (jVar2.f37606c + i > 2048 || !jVar2.f37608e) ? jVar2.a(k.a()) : jVar2;
        }
        j a2 = k.a();
        this.f37583a = a2;
        a2.f37610g = a2;
        a2.f37609f = a2;
        return a2;
    }

    public boolean c() {
        return this.f37584b == 0;
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
        byte[] bArr = c2.f37604a;
        int i = c2.f37606c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f37582c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f37606c += numberOfTrailingZeros;
        this.f37584b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f37584b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                b bVar = b.this;
                if (bVar.f37584b > 0) {
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
        long j = this.f37584b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f37583a.f37610g;
        int i = jVar.f37606c;
        return (i >= 2048 || !jVar.f37608e) ? j : j - (i - jVar.f37605b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            long j = this.f37584b;
            if (j != bVar.f37584b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            j jVar = this.f37583a;
            j jVar2 = bVar.f37583a;
            int i = jVar.f37605b;
            int i2 = jVar2.f37605b;
            while (j2 < this.f37584b) {
                long min = Math.min(jVar.f37606c - i, jVar2.f37606c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (jVar.f37604a[i] != jVar2.f37604a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == jVar.f37606c) {
                    jVar = jVar.f37609f;
                    i = jVar.f37605b;
                }
                if (i2 == jVar2.f37606c) {
                    jVar2 = jVar2.f37609f;
                    i2 = jVar2.f37605b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        long j = this.f37584b;
        if (j != 0) {
            j jVar = this.f37583a;
            int i = jVar.f37605b;
            int i2 = jVar.f37606c;
            int i3 = i + 1;
            byte b2 = jVar.f37604a[i];
            this.f37584b = j - 1;
            if (i3 == i2) {
                this.f37583a = jVar.a();
                k.a(jVar);
            } else {
                jVar.f37605b = i3;
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
            return a(this.f37584b, o.f37616a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int hashCode() {
        j jVar = this.f37583a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.f37606c;
            for (int i3 = jVar.f37605b; i3 < i2; i3++) {
                i = (i * 31) + jVar.f37604a[i3];
            }
            jVar = jVar.f37609f;
        } while (jVar != this.f37583a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f37584b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void j() {
        try {
            b(this.f37584b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f37584b == 0) {
            return bVar;
        }
        j jVar = new j(this.f37583a);
        bVar.f37583a = jVar;
        jVar.f37610g = jVar;
        jVar.f37609f = jVar;
        j jVar2 = this.f37583a;
        while (true) {
            jVar2 = jVar2.f37609f;
            if (jVar2 == this.f37583a) {
                bVar.f37584b = this.f37584b;
                return bVar;
            }
            bVar.f37583a.f37610g.a(new j(jVar2));
        }
    }

    public String toString() {
        long j = this.f37584b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f37584b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f37583a.f37604a, this.f37583a.f37605b, this.f37583a.f37606c - this.f37583a.f37605b);
            j jVar = this.f37583a;
            while (true) {
                jVar = jVar.f37609f;
                if (jVar == this.f37583a) {
                    return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f37584b), e.a(messageDigest.digest()).c());
                }
                messageDigest.update(jVar.f37604a, jVar.f37605b, jVar.f37606c - jVar.f37605b);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
