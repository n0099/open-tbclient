package com.meizu.cloud.pushsdk.networking.okio;

import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class b implements c, d, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    i a;
    long b;

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public b b() {
        return this;
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.networking.okio.b.1
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

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
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
        i iVar = this.a.g;
        if (iVar.c < 2048 && iVar.e) {
            return j - (iVar.c - iVar.b);
        }
        return j;
    }

    public byte f() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        i iVar = this.a;
        int i = iVar.b;
        int i2 = iVar.c;
        int i3 = i + 1;
        byte b = iVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = iVar.a();
            j.a(iVar);
        } else {
            iVar.b = i3;
        }
        return b;
    }

    public ByteString g() {
        return new ByteString(i());
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.d
    public String h() {
        try {
            return a(this.b, n.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        n.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        i iVar = this.a;
        if (iVar.b + j > iVar.c) {
            return new String(a(j), charset);
        }
        String str = new String(iVar.a, iVar.b, (int) j, charset);
        iVar.b = (int) (iVar.b + j);
        this.b -= j;
        if (iVar.b == iVar.c) {
            this.a = iVar.a();
            j.a(iVar);
            return str;
        }
        return str;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] a(long j) throws EOFException {
        n.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        n.a(bArr.length, i, i2);
        i iVar = this.a;
        if (iVar == null) {
            return -1;
        }
        int min = Math.min(i2, iVar.c - iVar.b);
        System.arraycopy(iVar.a, iVar.b, bArr, i, min);
        iVar.b += min;
        this.b -= min;
        if (iVar.b == iVar.c) {
            this.a = iVar.a();
            j.a(iVar);
            return min;
        }
        return min;
    }

    public void j() {
        try {
            b(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void b(long j) throws EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, this.a.c - this.a.b);
            this.b -= min;
            j -= min;
            i iVar = this.a;
            iVar.b = min + iVar.b;
            if (this.a.b == this.a.c) {
                i iVar2 = this.a;
                this.a = iVar2.a();
                j.a(iVar2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    /* renamed from: a */
    public b b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.networking.okio.c
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
                i c2 = c(1);
                byte[] bArr = c2.a;
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
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    /* renamed from: b */
    public b c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    /* renamed from: b */
    public b c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        n.a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            i c2 = c(1);
            int min = Math.min(i3 - i, 2048 - c2.c);
            System.arraycopy(bArr, i, c2.a, c2.c, min);
            i += min;
            c2.c = min + c2.c;
        }
        this.b += i2;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    public long a(l lVar) throws IOException {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = lVar.b(this, 2048L);
            if (b != -1) {
                j += b;
            } else {
                return j;
            }
        }
    }

    public b b(int i) {
        i c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.networking.okio.c
    /* renamed from: c */
    public b e(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return b(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= ErrDef.Feature.WEIGHT) {
            i = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < ErrDef.Platform.WEIGHT ? 7 : 8;
        } else if (j2 < 100) {
            i = j2 < 10 ? 1 : 2;
        } else {
            i = j2 < 1000 ? 3 : 4;
        }
        if (z) {
            i++;
        }
        i c2 = c(i);
        byte[] bArr = c2.a;
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

    public b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        i c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (c2.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b = numberOfTrailingZeros + this.b;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        if (this.a == null) {
            this.a = j.a();
            i iVar = this.a;
            i iVar2 = this.a;
            i iVar3 = this.a;
            iVar2.g = iVar3;
            iVar.f = iVar3;
            return iVar3;
        }
        i iVar4 = this.a.g;
        if (iVar4.c + i > 2048 || !iVar4.e) {
            return iVar4.a(j.a());
        }
        return iVar4;
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.k
    public void a(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        n.a(bVar.b, 0L, j);
        while (j > 0) {
            if (j < bVar.a.c - bVar.a.b) {
                i iVar = this.a != null ? this.a.g : null;
                if (iVar != null && iVar.e) {
                    if ((iVar.c + j) - (iVar.d ? 0 : iVar.b) <= 2048) {
                        bVar.a.a(iVar, (int) j);
                        bVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                bVar.a = bVar.a.a((int) j);
            }
            i iVar2 = bVar.a;
            long j2 = iVar2.c - iVar2.b;
            bVar.a = iVar2.a();
            if (this.a == null) {
                this.a = iVar2;
                i iVar3 = this.a;
                i iVar4 = this.a;
                i iVar5 = this.a;
                iVar4.g = iVar5;
                iVar3.f = iVar5;
            } else {
                this.a.g.a(iVar2).b();
            }
            bVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.l
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

    @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Flushable
    public void flush() {
    }

    @Override // com.meizu.cloud.pushsdk.networking.okio.k, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.networking.okio.l
    public void close() {
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
            i iVar = this.a;
            i iVar2 = bVar.a;
            int i = iVar.b;
            int i2 = iVar2.b;
            while (j < this.b) {
                long min = Math.min(iVar.c - i, iVar2.c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    byte b = iVar.a[i];
                    int i5 = i2 + 1;
                    if (b != iVar2.a[i2]) {
                        return false;
                    }
                    i3++;
                    i2 = i5;
                    i = i4;
                }
                if (i == iVar.c) {
                    iVar = iVar.f;
                    i = iVar.b;
                }
                if (i2 == iVar2.c) {
                    iVar2 = iVar2.f;
                    i2 = iVar2.b;
                }
                j += min;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        i iVar = this.a;
        if (iVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = iVar.b;
            int i3 = iVar.c;
            while (i2 < i3) {
                i2++;
                i = iVar.a[i2] + (i * 31);
            }
            iVar = iVar.f;
        } while (iVar != this.a);
        return i;
    }

    public String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            return String.format("Buffer[size=%s data=%s]", Long.valueOf(this.b), clone().g().hex());
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
            messageDigest.update(this.a.a, this.a.b, this.a.c - this.a.b);
            for (i iVar = this.a.f; iVar != this.a; iVar = iVar.f) {
                messageDigest.update(iVar.a, iVar.b, iVar.c - iVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", Long.valueOf(this.b), ByteString.of(messageDigest.digest()).hex());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: k */
    public b clone() {
        b bVar = new b();
        if (this.b == 0) {
            return bVar;
        }
        bVar.a = new i(this.a);
        i iVar = bVar.a;
        i iVar2 = bVar.a;
        i iVar3 = bVar.a;
        iVar2.g = iVar3;
        iVar.f = iVar3;
        for (i iVar4 = this.a.f; iVar4 != this.a; iVar4 = iVar4.f) {
            bVar.a.g.a(new i(iVar4));
        }
        bVar.b = this.b;
        return bVar;
    }
}
