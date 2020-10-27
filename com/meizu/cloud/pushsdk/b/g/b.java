package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public final class b implements c, d, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    j f4345a;
    long b;

    public int a(byte[] bArr, int i, int i2) {
        o.a(bArr.length, i, i2);
        j jVar = this.f4345a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.c - jVar.b);
        System.arraycopy(jVar.f4355a, jVar.b, bArr, i, min);
        jVar.b += min;
        this.b -= min;
        if (jVar.b == jVar.c) {
            this.f4345a = jVar.a();
            k.a(jVar);
            return min;
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    public b a(int i) {
        if (i < 128) {
            b(i);
        } else if (i < 2048) {
            b((i >> 6) | 192);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            b((i >> 12) | 224);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else if (i > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        } else {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: a */
    public b b(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        eVar.a(this);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: a */
    public b b(String str) {
        return a(str, 0, str.length());
    }

    public b a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                j c2 = c(1);
                byte[] bArr = c2.f4355a;
                int i4 = c2.c - i;
                int min = Math.min(i2, 2048 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) charAt;
                while (i3 < min) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) charAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - c2.c;
                c2.c += i5;
                this.b += i5;
            } else if (charAt < 2048) {
                b((charAt >> 6) | 192);
                b((charAt & '?') | 128);
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                b((charAt >> '\f') | 224);
                b(((charAt >> 6) & 63) | 128);
                b((charAt & '?') | 128);
                i3 = i + 1;
            } else {
                char charAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                    b(63);
                    i++;
                } else {
                    int i6 = ((charAt3 & 9215) | ((charAt & 10239) << 10)) + 65536;
                    b((i6 >> 18) | 240);
                    b(((i6 >> 12) & 63) | 128);
                    b(((i6 >> 6) & 63) | 128);
                    b((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    public String a(long j, Charset charset) throws EOFException {
        o.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        j jVar = this.f4345a;
        if (jVar.b + j > jVar.c) {
            return new String(a(j), charset);
        }
        String str = new String(jVar.f4355a, jVar.b, (int) j, charset);
        jVar.b = (int) (jVar.b + j);
        this.b -= j;
        if (jVar.b == jVar.c) {
            this.f4345a = jVar.a();
            k.a(jVar);
            return str;
        }
        return str;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        o.a(bVar.b, 0L, j);
        while (j > 0) {
            if (j < bVar.f4345a.c - bVar.f4345a.b) {
                j jVar = this.f4345a != null ? this.f4345a.g : null;
                if (jVar != null && jVar.e) {
                    if ((jVar.c + j) - (jVar.d ? 0 : jVar.b) <= 2048) {
                        bVar.f4345a.a(jVar, (int) j);
                        bVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                bVar.f4345a = bVar.f4345a.a((int) j);
            }
            j jVar2 = bVar.f4345a;
            long j2 = jVar2.c - jVar2.b;
            bVar.f4345a = jVar2.a();
            if (this.f4345a == null) {
                this.f4345a = jVar2;
                j jVar3 = this.f4345a;
                j jVar4 = this.f4345a;
                j jVar5 = this.f4345a;
                jVar4.g = jVar5;
                jVar3.f = jVar5;
            } else {
                this.f4345a.g.a(jVar2).b();
            }
            bVar.b -= j2;
            this.b += j2;
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
        o.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.m
    public long b(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.b == 0) {
            return -1L;
        }
        if (j > this.b) {
            j = this.b;
        }
        bVar.a(this, j);
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.c
    public b b() {
        return this;
    }

    public b b(int i) {
        j c2 = c(1);
        byte[] bArr = c2.f4355a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: b */
    public b c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        o.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            j c2 = c(1);
            int min = Math.min(i3 - i, 2048 - c2.c);
            System.arraycopy(bArr, i, c2.f4355a, c2.c, min);
            i += min;
            c2.c = min + c2.c;
        }
        this.b += i2;
        return this;
    }

    public void b(long j) throws EOFException {
        while (j > 0) {
            if (this.f4345a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.f4345a.c - this.f4345a.b);
            this.b -= min;
            j -= min;
            j jVar = this.f4345a;
            jVar.b = min + jVar.b;
            if (this.f4345a.b == this.f4345a.c) {
                j jVar2 = this.f4345a;
                this.f4345a = jVar2.a();
                k.a(jVar2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.b.g.c
    /* renamed from: c */
    public b e(long j) {
        boolean z;
        long j2;
        if (j == 0) {
            return b(48);
        }
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < TimeUtils.NANOS_PER_MS ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (z) {
            i++;
        }
        j c2 = c(i);
        byte[] bArr = c2.f4355a;
        int i2 = c2.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        c2.c += i;
        this.b = i + this.b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.f4345a != null) {
            j jVar = this.f4345a.g;
            return (jVar.c + i > 2048 || !jVar.e) ? jVar.a(k.a()) : jVar;
        }
        this.f4345a = k.a();
        j jVar2 = this.f4345a;
        j jVar3 = this.f4345a;
        j jVar4 = this.f4345a;
        jVar3.g = jVar4;
        jVar2.f = jVar4;
        return jVar4;
    }

    public boolean c() {
        return this.b == 0;
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
        byte[] bArr = c2.f4355a;
        int i = c2.c;
        for (int i2 = (c2.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b = numberOfTrailingZeros + this.b;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (b.this.b > 0) {
                    return b.this.f() & 255;
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
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f4345a.g;
        return (jVar.c >= 2048 || !jVar.e) ? j : j - (jVar.c - jVar.b);
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.b != bVar.b) {
                return false;
            }
            if (this.b == 0) {
                return true;
            }
            j jVar = this.f4345a;
            j jVar2 = bVar.f4345a;
            int i = jVar.b;
            int i2 = jVar2.b;
            while (j < this.b) {
                long min = Math.min(jVar.c - i, jVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    byte b = jVar.f4355a[i];
                    int i5 = i2 + 1;
                    if (b != jVar2.f4355a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == jVar.c) {
                    jVar = jVar.f;
                    i = jVar.b;
                }
                if (i2 == jVar2.c) {
                    jVar2 = jVar2.f;
                    i2 = jVar2.b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        j jVar = this.f4345a;
        int i = jVar.b;
        int i2 = jVar.c;
        int i3 = i + 1;
        byte b = jVar.f4355a[i];
        this.b--;
        if (i3 == i2) {
            this.f4345a = jVar.a();
            k.a(jVar);
        } else {
            jVar.b = i3;
        }
        return b;
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
            return a(this.b, o.f4358a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        j jVar = this.f4345a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.b;
            int i3 = jVar.c;
            while (i2 < i3) {
                i2++;
                i = jVar.f4355a[i2] + (i * 31);
            }
            jVar = jVar.f;
        } while (jVar != this.f4345a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        bVar.f4345a = new j(this.f4345a);
        j jVar = bVar.f4345a;
        j jVar2 = bVar.f4345a;
        j jVar3 = bVar.f4345a;
        jVar2.g = jVar3;
        jVar.f = jVar3;
        for (j jVar4 = this.f4345a.f; jVar4 != this.f4345a; jVar4 = jVar4.f) {
            bVar.f4345a.g.a(new j(jVar4));
        }
        bVar.b = this.b;
        return bVar;
    }

    public String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(this.f4345a.f4355a, this.f4345a.b, this.f4345a.c - this.f4345a.b);
            for (j jVar = this.f4345a.f; jVar != this.f4345a; jVar = jVar.f) {
                messageDigest.update(jVar.f4355a, jVar.b, jVar.c - jVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), e.a(messageDigest.digest()).c());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
