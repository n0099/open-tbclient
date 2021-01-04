package com.meizu.cloud.pushsdk.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class b implements c, d, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: a  reason: collision with root package name */
    j f11491a;

    /* renamed from: b  reason: collision with root package name */
    long f11492b;

    public int a(byte[] bArr, int i, int i2) {
        o.a(bArr.length, i, i2);
        j jVar = this.f11491a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i2, jVar.c - jVar.f11508b);
        System.arraycopy(jVar.f11507a, jVar.f11508b, bArr, i, min);
        jVar.f11508b += min;
        this.f11492b -= min;
        if (jVar.f11508b == jVar.c) {
            this.f11491a = jVar.a();
            k.a(jVar);
            return min;
        }
        return min;
    }

    public long a() {
        return this.f11492b;
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
                byte[] bArr = c2.f11507a;
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
                this.f11492b += i5;
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
        o.a(this.f11492b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        j jVar = this.f11491a;
        if (jVar.f11508b + j > jVar.c) {
            return new String(a(j), charset);
        }
        String str = new String(jVar.f11507a, jVar.f11508b, (int) j, charset);
        jVar.f11508b = (int) (jVar.f11508b + j);
        this.f11492b -= j;
        if (jVar.f11508b == jVar.c) {
            this.f11491a = jVar.a();
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
        o.a(bVar.f11492b, 0L, j);
        while (j > 0) {
            if (j < bVar.f11491a.c - bVar.f11491a.f11508b) {
                j jVar = this.f11491a != null ? this.f11491a.g : null;
                if (jVar != null && jVar.e) {
                    if ((jVar.c + j) - (jVar.d ? 0 : jVar.f11508b) <= 2048) {
                        bVar.f11491a.a(jVar, (int) j);
                        bVar.f11492b -= j;
                        this.f11492b += j;
                        return;
                    }
                }
                bVar.f11491a = bVar.f11491a.a((int) j);
            }
            j jVar2 = bVar.f11491a;
            long j2 = jVar2.c - jVar2.f11508b;
            bVar.f11491a = jVar2.a();
            if (this.f11491a == null) {
                this.f11491a = jVar2;
                j jVar3 = this.f11491a;
                j jVar4 = this.f11491a;
                j jVar5 = this.f11491a;
                jVar4.g = jVar5;
                jVar3.f = jVar5;
            } else {
                this.f11491a.g.a(jVar2).b();
            }
            bVar.f11492b -= j2;
            this.f11492b += j2;
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
        o.a(this.f11492b, 0L, j);
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
        if (this.f11492b == 0) {
            return -1L;
        }
        if (j > this.f11492b) {
            j = this.f11492b;
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
        byte[] bArr = c2.f11507a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f11492b++;
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
            System.arraycopy(bArr, i, c2.f11507a, c2.c, min);
            i += min;
            c2.c = min + c2.c;
        }
        this.f11492b += i2;
        return this;
    }

    public void b(long j) throws EOFException {
        while (j > 0) {
            if (this.f11491a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.f11491a.c - this.f11491a.f11508b);
            this.f11492b -= min;
            j -= min;
            j jVar = this.f11491a;
            jVar.f11508b = min + jVar.f11508b;
            if (this.f11491a.f11508b == this.f11491a.c) {
                j jVar2 = this.f11491a;
                this.f11491a = jVar2.a();
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
        byte[] bArr = c2.f11507a;
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
        this.f11492b = i + this.f11492b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.f11491a != null) {
            j jVar = this.f11491a.g;
            return (jVar.c + i > 2048 || !jVar.e) ? jVar.a(k.a()) : jVar;
        }
        this.f11491a = k.a();
        j jVar2 = this.f11491a;
        j jVar3 = this.f11491a;
        j jVar4 = this.f11491a;
        jVar3.g = jVar4;
        jVar2.f = jVar4;
        return jVar4;
    }

    public boolean c() {
        return this.f11492b == 0;
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
        byte[] bArr = c2.f11507a;
        int i = c2.c;
        for (int i2 = (c2.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.f11492b = numberOfTrailingZeros + this.f11492b;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.b.g.b.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.f11492b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (b.this.f11492b > 0) {
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
        long j = this.f11492b;
        if (j == 0) {
            return 0L;
        }
        j jVar = this.f11491a.g;
        return (jVar.c >= 2048 || !jVar.e) ? j : j - (jVar.c - jVar.f11508b);
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f11492b != bVar.f11492b) {
                return false;
            }
            if (this.f11492b == 0) {
                return true;
            }
            j jVar = this.f11491a;
            j jVar2 = bVar.f11491a;
            int i = jVar.f11508b;
            int i2 = jVar2.f11508b;
            while (j < this.f11492b) {
                long min = Math.min(jVar.c - i, jVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (jVar.f11507a[i] != jVar2.f11507a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == jVar.c) {
                    jVar = jVar.f;
                    i = jVar.f11508b;
                }
                if (i2 == jVar2.c) {
                    jVar2 = jVar2.f;
                    i2 = jVar2.f11508b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public byte f() {
        if (this.f11492b == 0) {
            throw new IllegalStateException("size == 0");
        }
        j jVar = this.f11491a;
        int i = jVar.f11508b;
        int i2 = jVar.c;
        int i3 = i + 1;
        byte b2 = jVar.f11507a[i];
        this.f11492b--;
        if (i3 == i2) {
            this.f11491a = jVar.a();
            k.a(jVar);
        } else {
            jVar.f11508b = i3;
        }
        return b2;
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
            return a(this.f11492b, o.f11513a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        j jVar = this.f11491a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.c;
            for (int i3 = jVar.f11508b; i3 < i2; i3++) {
                i = (i * 31) + jVar.f11507a[i3];
            }
            jVar = jVar.f;
        } while (jVar != this.f11491a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.d
    public byte[] i() {
        try {
            return a(this.f11492b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.f11492b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.f11492b == 0) {
            return bVar;
        }
        bVar.f11491a = new j(this.f11491a);
        j jVar = bVar.f11491a;
        j jVar2 = bVar.f11491a;
        j jVar3 = bVar.f11491a;
        jVar2.g = jVar3;
        jVar.f = jVar3;
        for (j jVar4 = this.f11491a.f; jVar4 != this.f11491a; jVar4 = jVar4.f) {
            bVar.f11491a.g.a(new j(jVar4));
        }
        bVar.f11492b = this.f11492b;
        return bVar;
    }

    public String toString() {
        if (this.f11492b == 0) {
            return "Buffer[size=0]";
        }
        if (this.f11492b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.f11492b), clone().g().c());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(this.f11491a.f11507a, this.f11491a.f11508b, this.f11491a.c - this.f11491a.f11508b);
            for (j jVar = this.f11491a.f; jVar != this.f11491a; jVar = jVar.f) {
                messageDigest.update(jVar.f11507a, jVar.f11508b, jVar.c - jVar.f11508b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.f11492b), e.a(messageDigest.digest()).c());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }
}
