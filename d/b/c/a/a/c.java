package d.b.c.a.a;

import com.baidu.android.imsdk.internal.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class c implements d, e, Cloneable, ByteChannel {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f64431g = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: e  reason: collision with root package name */
    public n f64432e;

    /* renamed from: f  reason: collision with root package name */
    public long f64433f;

    /* loaded from: classes5.dex */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f64433f, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f64433f > 0) {
                return cVar.h() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            return c.this.d(bArr, i2, i3);
        }
    }

    public c A() {
        return this;
    }

    public c B(int i2) {
        n D = D(4);
        byte[] bArr = D.f64459a;
        int i3 = D.f64461c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        D.f64461c = i6 + 1;
        this.f64433f += 4;
        return this;
    }

    public String C(long j) throws EOFException {
        return s(j, s.f64472a);
    }

    public n D(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            n nVar = this.f64432e;
            if (nVar == null) {
                n a2 = o.a();
                this.f64432e = a2;
                a2.f64465g = a2;
                a2.f64464f = a2;
                return a2;
            }
            n nVar2 = nVar.f64465g;
            if (nVar2.f64461c + i2 > 8192 || !nVar2.f64463e) {
                n a3 = o.a();
                nVar2.c(a3);
                return a3;
            }
            return nVar2;
        }
        throw new IllegalArgumentException();
    }

    public final com.bytedance.sdk.a.a.f E(int i2) {
        if (i2 == 0) {
            return com.bytedance.sdk.a.a.f.f27669b;
        }
        return new com.bytedance.sdk.a.a.q(this, i2);
    }

    public String F(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (u(j2) == 13) {
                String C = C(j2);
                g(2L);
                return C;
            }
        }
        String C2 = C(j);
        g(1L);
        return C2;
    }

    public final long G() {
        long j = this.f64433f;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.f64432e.f64465g;
        int i2 = nVar.f64461c;
        return (i2 >= 8192 || !nVar.f64463e) ? j : j - (i2 - nVar.f64460b);
    }

    public c H(long j) {
        if (j == 0) {
            w(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n D = D(numberOfTrailingZeros);
        byte[] bArr = D.f64459a;
        int i2 = D.f64461c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f64431g[(int) (15 & j)];
            j >>>= 4;
        }
        D.f64461c += numberOfTrailingZeros;
        this.f64433f += numberOfTrailingZeros;
        return this;
    }

    public com.bytedance.sdk.a.a.f I() {
        return new com.bytedance.sdk.a.a.f(K());
    }

    public String J() {
        try {
            return s(this.f64433f, s.f64472a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] K() {
        try {
            return f(this.f64433f);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void L() {
        try {
            g(this.f64433f);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: M */
    public c clone() {
        c cVar = new c();
        if (this.f64433f == 0) {
            return cVar;
        }
        n a2 = this.f64432e.a();
        cVar.f64432e = a2;
        a2.f64465g = a2;
        a2.f64464f = a2;
        n nVar = this.f64432e;
        while (true) {
            nVar = nVar.f64464f;
            if (nVar != this.f64432e) {
                cVar.f64432e.f64465g.c(nVar.a());
            } else {
                cVar.f64433f = this.f64433f;
                return cVar;
            }
        }
    }

    public final com.bytedance.sdk.a.a.f N() {
        long j = this.f64433f;
        if (j <= 2147483647L) {
            return E((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f64433f);
    }

    @Override // d.b.c.a.a.e
    public void a(long j) throws EOFException {
        if (this.f64433f < j) {
            throw new EOFException();
        }
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d b(String str) throws IOException {
        p(str);
        return this;
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.e
    public c c() {
        return this;
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d c(byte[] bArr) throws IOException {
        x(bArr);
        return this;
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int d(byte[] bArr, int i2, int i3) {
        s.c(bArr.length, i2, i3);
        n nVar = this.f64432e;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i3, nVar.f64461c - nVar.f64460b);
        System.arraycopy(nVar.f64459a, nVar.f64460b, bArr, i2, min);
        int i4 = nVar.f64460b + min;
        nVar.f64460b = i4;
        this.f64433f -= min;
        if (i4 == nVar.f64461c) {
            this.f64432e = nVar.e();
            o.b(nVar);
        }
        return min;
    }

    @Override // d.b.c.a.a.e
    public boolean e() {
        return this.f64433f == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j = this.f64433f;
            if (j != cVar.f64433f) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            n nVar = this.f64432e;
            n nVar2 = cVar.f64432e;
            int i2 = nVar.f64460b;
            int i3 = nVar2.f64460b;
            while (j2 < this.f64433f) {
                long min = Math.min(nVar.f64461c - i2, nVar2.f64461c - i3);
                int i4 = 0;
                while (i4 < min) {
                    int i5 = i2 + 1;
                    int i6 = i3 + 1;
                    if (nVar.f64459a[i2] != nVar2.f64459a[i3]) {
                        return false;
                    }
                    i4++;
                    i2 = i5;
                    i3 = i6;
                }
                if (i2 == nVar.f64461c) {
                    nVar = nVar.f64464f;
                    i2 = nVar.f64460b;
                }
                if (i3 == nVar2.f64461c) {
                    nVar2 = nVar2.f64464f;
                    i3 = nVar2.f64460b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // d.b.c.a.a.e
    public InputStream f() {
        return new a();
    }

    @Override // d.b.c.a.a.d, d.b.c.a.a.p, java.io.Flushable
    public void flush() {
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d g(int i2) throws IOException {
        B(i2);
        return this;
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d h(int i2) throws IOException {
        z(i2);
        return this;
    }

    public int hashCode() {
        n nVar = this.f64432e;
        if (nVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = nVar.f64461c;
            for (int i4 = nVar.f64460b; i4 < i3; i4++) {
                i2 = (i2 * 31) + nVar.f64459a[i4];
            }
            nVar = nVar.f64464f;
        } while (nVar != this.f64432e);
        return i2;
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d i(int i2) throws IOException {
        w(i2);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // d.b.c.a.a.e
    public int j() {
        long j = this.f64433f;
        if (j >= 4) {
            n nVar = this.f64432e;
            int i2 = nVar.f64460b;
            int i3 = nVar.f64461c;
            if (i3 - i2 < 4) {
                return ((h() & 255) << 24) | ((h() & 255) << 16) | ((h() & 255) << 8) | (h() & 255);
            }
            byte[] bArr = nVar.f64459a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            this.f64433f = j - 4;
            if (i9 == i3) {
                this.f64432e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f64460b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.f64433f);
    }

    @Override // d.b.c.a.a.e
    public short k() {
        return s.b(i());
    }

    @Override // d.b.c.a.a.e
    public int l() {
        return s.a(j());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[EDGE_INSN: B:42:0x00a3->B:38:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // d.b.c.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() {
        int i2;
        int i3;
        if (this.f64433f != 0) {
            int i4 = 0;
            long j = 0;
            boolean z = false;
            do {
                n nVar = this.f64432e;
                byte[] bArr = nVar.f64459a;
                int i5 = nVar.f64460b;
                int i6 = nVar.f64461c;
                while (i5 < i6) {
                    byte b2 = bArr[i5];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 >= 65 && b2 <= 70) {
                            i2 = b2 - 65;
                        } else if (i4 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                        } else {
                            z = true;
                            if (i5 != i6) {
                                this.f64432e = nVar.e();
                                o.b(nVar);
                            } else {
                                nVar.f64460b = i5;
                            }
                            if (!z) {
                                break;
                            }
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b2 - 48;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        c cVar = new c();
                        cVar.H(j);
                        cVar.w(b2);
                        throw new NumberFormatException("Number too large: " + cVar.J());
                    }
                    j = (j << 4) | i3;
                    i5++;
                    i4++;
                }
                if (i5 != i6) {
                }
                if (!z) {
                }
            } while (this.f64432e != null);
            this.f64433f -= i4;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public final c n(c cVar, long j, long j2) {
        if (cVar != null) {
            s.c(this.f64433f, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f64433f += j2;
            n nVar = this.f64432e;
            while (true) {
                int i2 = nVar.f64461c;
                int i3 = nVar.f64460b;
                if (j < i2 - i3) {
                    break;
                }
                j -= i2 - i3;
                nVar = nVar.f64464f;
            }
            while (j2 > 0) {
                n a2 = nVar.a();
                int i4 = (int) (a2.f64460b + j);
                a2.f64460b = i4;
                a2.f64461c = Math.min(i4 + ((int) j2), a2.f64461c);
                n nVar2 = cVar.f64432e;
                if (nVar2 == null) {
                    a2.f64465g = a2;
                    a2.f64464f = a2;
                    cVar.f64432e = a2;
                } else {
                    nVar2.f64465g.c(a2);
                }
                j2 -= a2.f64461c - a2.f64460b;
                nVar = nVar.f64464f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c o(com.bytedance.sdk.a.a.f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // d.b.c.a.a.e
    public String p() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    public c q(String str, int i2, int i3) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                }
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        n D = D(1);
                        byte[] bArr = D.f64459a;
                        int i4 = D.f64461c - i2;
                        int min = Math.min(i3, 8192 - i4);
                        int i5 = i2 + 1;
                        bArr[i2 + i4] = (byte) charAt;
                        while (i5 < min) {
                            char charAt2 = str.charAt(i5);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i5 + i4] = (byte) charAt2;
                            i5++;
                        }
                        int i6 = D.f64461c;
                        int i7 = (i4 + i5) - i6;
                        D.f64461c = i6 + i7;
                        this.f64433f += i7;
                        i2 = i5;
                    } else {
                        if (charAt < 2048) {
                            w((charAt >> 6) | 192);
                            w((charAt & '?') | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i8 = i2 + 1;
                            char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                w((i9 >> 18) | 240);
                                w(((i9 >> 12) & 63) | 128);
                                w(((i9 >> 6) & 63) | 128);
                                w((i9 & 63) | 128);
                                i2 += 2;
                            } else {
                                w(63);
                                i2 = i8;
                            }
                        } else {
                            w((charAt >> '\f') | 224);
                            w(((charAt >> 6) & 63) | 128);
                            w((charAt & '?') | 128);
                        }
                        i2++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public c r(String str, int i2, int i3, Charset charset) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                } else if (charset != null) {
                    if (charset.equals(s.f64472a)) {
                        q(str, i2, i3);
                        return this;
                    }
                    byte[] bytes = str.substring(i2, i3).getBytes(charset);
                    y(bytes, 0, bytes.length);
                    return this;
                } else {
                    throw new IllegalArgumentException("charset == null");
                }
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        n nVar = this.f64432e;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.f64461c - nVar.f64460b);
        byteBuffer.put(nVar.f64459a, nVar.f64460b, min);
        int i2 = nVar.f64460b + min;
        nVar.f64460b = i2;
        this.f64433f -= min;
        if (i2 == nVar.f64461c) {
            this.f64432e = nVar.e();
            o.b(nVar);
        }
        return min;
    }

    public String s(long j, Charset charset) throws EOFException {
        s.c(this.f64433f, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                n nVar = this.f64432e;
                if (nVar.f64460b + j > nVar.f64461c) {
                    return new String(f(j), charset);
                }
                String str = new String(nVar.f64459a, nVar.f64460b, (int) j, charset);
                int i2 = (int) (nVar.f64460b + j);
                nVar.f64460b = i2;
                this.f64433f -= j;
                if (i2 == nVar.f64461c) {
                    this.f64432e = nVar.e();
                    o.b(nVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    public boolean t(long j, com.bytedance.sdk.a.a.f fVar, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.f64433f - j < i3 || fVar.g() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (u(i4 + j) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return N().toString();
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d u() throws IOException {
        A();
        return this;
    }

    public final long v() {
        return this.f64433f;
    }

    public c w(int i2) {
        n D = D(1);
        byte[] bArr = D.f64459a;
        int i3 = D.f64461c;
        D.f64461c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f64433f++;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                n D = D(1);
                int min = Math.min(i2, 8192 - D.f64461c);
                byteBuffer.get(D.f64459a, D.f64461c, min);
                i2 -= min;
                D.f64461c += min;
            }
            this.f64433f += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c x(byte[] bArr) {
        if (bArr != null) {
            y(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c y(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            s.c(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                n D = D(1);
                int min = Math.min(i4 - i2, 8192 - D.f64461c);
                System.arraycopy(bArr, i2, D.f64459a, D.f64461c, min);
                i2 += min;
                D.f64461c += min;
            }
            this.f64433f += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c z(int i2) {
        n D = D(2);
        byte[] bArr = D.f64459a;
        int i3 = D.f64461c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        D.f64461c = i4 + 1;
        this.f64433f += 2;
        return this;
    }

    @Override // d.b.c.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int d2 = d(bArr, i2, bArr.length - i2);
            if (d2 == -1) {
                throw new EOFException();
            }
            i2 += d2;
        }
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            s.c(cVar.f64433f, 0L, j);
            while (j > 0) {
                n nVar = cVar.f64432e;
                if (j < nVar.f64461c - nVar.f64460b) {
                    n nVar2 = this.f64432e;
                    n nVar3 = nVar2 != null ? nVar2.f64465g : null;
                    if (nVar3 != null && nVar3.f64463e) {
                        if ((nVar3.f64461c + j) - (nVar3.f64462d ? 0 : nVar3.f64460b) <= 8192) {
                            cVar.f64432e.d(nVar3, (int) j);
                            cVar.f64433f -= j;
                            this.f64433f += j;
                            return;
                        }
                    }
                    cVar.f64432e = cVar.f64432e.b((int) j);
                }
                n nVar4 = cVar.f64432e;
                long j2 = nVar4.f64461c - nVar4.f64460b;
                cVar.f64432e = nVar4.e();
                n nVar5 = this.f64432e;
                if (nVar5 == null) {
                    this.f64432e = nVar4;
                    nVar4.f64465g = nVar4;
                    nVar4.f64464f = nVar4;
                } else {
                    nVar5.f64465g.c(nVar4);
                    nVar4.f();
                }
                cVar.f64433f -= j2;
                this.f64433f += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d c(byte[] bArr, int i2, int i3) throws IOException {
        y(bArr, i2, i3);
        return this;
    }

    @Override // d.b.c.a.a.e
    public String e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long e2 = e((byte) 10, 0L, j2);
            if (e2 != -1) {
                return F(e2);
            }
            if (j2 < v() && u(j2 - 1) == 13 && u(j2) == 10) {
                return F(j2);
            }
            c cVar = new c();
            n(cVar, 0L, Math.min(32L, v()));
            throw new EOFException("\\n not found: limit=" + Math.min(v(), j) + " content=" + cVar.I().e() + Typography.ellipsis);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // d.b.c.a.a.e
    public byte[] f(long j) throws EOFException {
        s.c(this.f64433f, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // d.b.c.a.a.e
    public void g(long j) throws EOFException {
        n nVar;
        while (j > 0) {
            if (this.f64432e != null) {
                int min = (int) Math.min(j, nVar.f64461c - nVar.f64460b);
                long j2 = min;
                this.f64433f -= j2;
                j -= j2;
                n nVar2 = this.f64432e;
                int i2 = nVar2.f64460b + min;
                nVar2.f64460b = i2;
                if (i2 == nVar2.f64461c) {
                    this.f64432e = nVar2.e();
                    o.b(nVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // d.b.c.a.a.d
    public /* synthetic */ d h(long j) throws IOException {
        H(j);
        return this;
    }

    @Override // d.b.c.a.a.e
    public short i() {
        long j = this.f64433f;
        if (j >= 2) {
            n nVar = this.f64432e;
            int i2 = nVar.f64460b;
            int i3 = nVar.f64461c;
            if (i3 - i2 < 2) {
                return (short) (((h() & 255) << 8) | (h() & 255));
            }
            byte[] bArr = nVar.f64459a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f64433f = j - 2;
            if (i5 == i3) {
                this.f64432e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f64460b = i5;
            }
            return (short) i6;
        }
        throw new IllegalStateException("size < 2: " + this.f64433f);
    }

    @Override // d.b.c.a.a.e
    public long k(byte b2) {
        return e(b2, 0L, Long.MAX_VALUE);
    }

    public long l(q qVar) throws IOException {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = qVar.a(this, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
        }
    }

    public c p(String str) {
        q(str, 0, str.length());
        return this;
    }

    public final byte u(long j) {
        int i2;
        s.c(this.f64433f, j, 1L);
        long j2 = this.f64433f;
        if (j2 - j > j) {
            n nVar = this.f64432e;
            while (true) {
                int i3 = nVar.f64461c;
                int i4 = nVar.f64460b;
                long j3 = i3 - i4;
                if (j < j3) {
                    return nVar.f64459a[i4 + ((int) j)];
                }
                j -= j3;
                nVar = nVar.f64464f;
            }
        } else {
            long j4 = j - j2;
            n nVar2 = this.f64432e;
            do {
                nVar2 = nVar2.f64465g;
                int i5 = nVar2.f64461c;
                i2 = nVar2.f64460b;
                j4 += i5 - i2;
            } while (j4 < 0);
            return nVar2.f64459a[i2 + ((int) j4)];
        }
    }

    @Override // d.b.c.a.a.e
    public com.bytedance.sdk.a.a.f c(long j) throws EOFException {
        return new com.bytedance.sdk.a.a.f(f(j));
    }

    @Override // d.b.c.a.a.e
    public byte h() {
        long j = this.f64433f;
        if (j != 0) {
            n nVar = this.f64432e;
            int i2 = nVar.f64460b;
            int i3 = nVar.f64461c;
            int i4 = i2 + 1;
            byte b2 = nVar.f64459a[i2];
            this.f64433f = j - 1;
            if (i4 == i3) {
                this.f64432e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f64460b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // d.b.c.a.a.q
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j >= 0) {
                long j2 = this.f64433f;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                cVar.b(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return r.f64468d;
    }

    public long e(byte b2, long j, long j2) {
        n nVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f64433f;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (nVar = this.f64432e) == null) {
                return -1L;
            }
            long j5 = this.f64433f;
            if (j5 - j < j) {
                while (j5 > j) {
                    nVar = nVar.f64465g;
                    j5 -= nVar.f64461c - nVar.f64460b;
                }
            } else {
                while (true) {
                    long j6 = (nVar.f64461c - nVar.f64460b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    nVar = nVar.f64464f;
                    j3 = j6;
                }
                j5 = j3;
            }
            long j7 = j;
            while (j5 < j4) {
                byte[] bArr = nVar.f64459a;
                int min = (int) Math.min(nVar.f64461c, (nVar.f64460b + j4) - j5);
                for (int i2 = (int) ((nVar.f64460b + j7) - j5); i2 < min; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - nVar.f64460b) + j5;
                    }
                }
                j5 += nVar.f64461c - nVar.f64460b;
                nVar = nVar.f64464f;
                j7 = j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f64433f), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // d.b.c.a.a.e
    public String i(Charset charset) {
        try {
            return s(this.f64433f, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // d.b.c.a.a.e
    public boolean j(long j, com.bytedance.sdk.a.a.f fVar) {
        return t(j, fVar, 0, fVar.g());
    }

    public c m(int i2) {
        if (i2 < 128) {
            w(i2);
        } else if (i2 < 2048) {
            w((i2 >> 6) | 192);
            w((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                w(63);
            } else {
                w((i2 >> 12) | 224);
                w(((i2 >> 6) & 63) | 128);
                w((i2 & 63) | 128);
            }
        } else if (i2 <= 1114111) {
            w((i2 >> 18) | 240);
            w(((i2 >> 12) & 63) | 128);
            w(((i2 >> 6) & 63) | 128);
            w((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }
}
