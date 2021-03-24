package d.c.c.a.a;

import com.baidu.android.imsdk.internal.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public final class c implements d, e, Cloneable, ByteChannel {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f65127g = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};

    /* renamed from: e  reason: collision with root package name */
    public n f65128e;

    /* renamed from: f  reason: collision with root package name */
    public long f65129f;

    /* loaded from: classes4.dex */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f65129f, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f65129f > 0) {
                return cVar.h() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return c.this.d(bArr, i, i2);
        }
    }

    public c A() {
        return this;
    }

    public c B(int i) {
        n D = D(4);
        byte[] bArr = D.f65154a;
        int i2 = D.f65156c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        D.f65156c = i5 + 1;
        this.f65129f += 4;
        return this;
    }

    public String C(long j) throws EOFException {
        return s(j, s.f65167a);
    }

    public n D(int i) {
        if (i >= 1 && i <= 8192) {
            n nVar = this.f65128e;
            if (nVar == null) {
                n a2 = o.a();
                this.f65128e = a2;
                a2.f65160g = a2;
                a2.f65159f = a2;
                return a2;
            }
            n nVar2 = nVar.f65160g;
            if (nVar2.f65156c + i > 8192 || !nVar2.f65158e) {
                n a3 = o.a();
                nVar2.c(a3);
                return a3;
            }
            return nVar2;
        }
        throw new IllegalArgumentException();
    }

    public final com.bytedance.sdk.a.a.f E(int i) {
        if (i == 0) {
            return com.bytedance.sdk.a.a.f.f27161b;
        }
        return new com.bytedance.sdk.a.a.q(this, i);
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
        long j = this.f65129f;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.f65128e.f65160g;
        int i = nVar.f65156c;
        return (i >= 8192 || !nVar.f65158e) ? j : j - (i - nVar.f65155b);
    }

    public c H(long j) {
        if (j == 0) {
            w(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n D = D(numberOfTrailingZeros);
        byte[] bArr = D.f65154a;
        int i = D.f65156c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f65127g[(int) (15 & j)];
            j >>>= 4;
        }
        D.f65156c += numberOfTrailingZeros;
        this.f65129f += numberOfTrailingZeros;
        return this;
    }

    public com.bytedance.sdk.a.a.f I() {
        return new com.bytedance.sdk.a.a.f(K());
    }

    public String J() {
        try {
            return s(this.f65129f, s.f65167a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] K() {
        try {
            return f(this.f65129f);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void L() {
        try {
            g(this.f65129f);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: M */
    public c clone() {
        c cVar = new c();
        if (this.f65129f == 0) {
            return cVar;
        }
        n a2 = this.f65128e.a();
        cVar.f65128e = a2;
        a2.f65160g = a2;
        a2.f65159f = a2;
        n nVar = this.f65128e;
        while (true) {
            nVar = nVar.f65159f;
            if (nVar != this.f65128e) {
                cVar.f65128e.f65160g.c(nVar.a());
            } else {
                cVar.f65129f = this.f65129f;
                return cVar;
            }
        }
    }

    public final com.bytedance.sdk.a.a.f N() {
        long j = this.f65129f;
        if (j <= 2147483647L) {
            return E((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f65129f);
    }

    @Override // d.c.c.a.a.e
    public void a(long j) throws EOFException {
        if (this.f65129f < j) {
            throw new EOFException();
        }
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d b(String str) throws IOException {
        p(str);
        return this;
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.e
    public c c() {
        return this;
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d c(byte[] bArr) throws IOException {
        x(bArr);
        return this;
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int d(byte[] bArr, int i, int i2) {
        s.c(bArr.length, i, i2);
        n nVar = this.f65128e;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i2, nVar.f65156c - nVar.f65155b);
        System.arraycopy(nVar.f65154a, nVar.f65155b, bArr, i, min);
        int i3 = nVar.f65155b + min;
        nVar.f65155b = i3;
        this.f65129f -= min;
        if (i3 == nVar.f65156c) {
            this.f65128e = nVar.e();
            o.b(nVar);
        }
        return min;
    }

    @Override // d.c.c.a.a.e
    public boolean e() {
        return this.f65129f == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j = this.f65129f;
            if (j != cVar.f65129f) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            n nVar = this.f65128e;
            n nVar2 = cVar.f65128e;
            int i = nVar.f65155b;
            int i2 = nVar2.f65155b;
            while (j2 < this.f65129f) {
                long min = Math.min(nVar.f65156c - i, nVar2.f65156c - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (nVar.f65154a[i] != nVar2.f65154a[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == nVar.f65156c) {
                    nVar = nVar.f65159f;
                    i = nVar.f65155b;
                }
                if (i2 == nVar2.f65156c) {
                    nVar2 = nVar2.f65159f;
                    i2 = nVar2.f65155b;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // d.c.c.a.a.e
    public InputStream f() {
        return new a();
    }

    @Override // d.c.c.a.a.d, d.c.c.a.a.p, java.io.Flushable
    public void flush() {
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d g(int i) throws IOException {
        B(i);
        return this;
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d h(int i) throws IOException {
        z(i);
        return this;
    }

    public int hashCode() {
        n nVar = this.f65128e;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.f65156c;
            for (int i3 = nVar.f65155b; i3 < i2; i3++) {
                i = (i * 31) + nVar.f65154a[i3];
            }
            nVar = nVar.f65159f;
        } while (nVar != this.f65128e);
        return i;
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d i(int i) throws IOException {
        w(i);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // d.c.c.a.a.e
    public int j() {
        long j = this.f65129f;
        if (j >= 4) {
            n nVar = this.f65128e;
            int i = nVar.f65155b;
            int i2 = nVar.f65156c;
            if (i2 - i < 4) {
                return ((h() & 255) << 24) | ((h() & 255) << 16) | ((h() & 255) << 8) | (h() & 255);
            }
            byte[] bArr = nVar.f65154a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f65129f = j - 4;
            if (i8 == i2) {
                this.f65128e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f65155b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f65129f);
    }

    @Override // d.c.c.a.a.e
    public short k() {
        return s.b(i());
    }

    @Override // d.c.c.a.a.e
    public int l() {
        return s.a(j());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3 A[EDGE_INSN: B:43:0x00a3->B:38:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // d.c.c.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m() {
        int i;
        int i2;
        if (this.f65129f != 0) {
            int i3 = 0;
            long j = 0;
            boolean z = false;
            do {
                n nVar = this.f65128e;
                byte[] bArr = nVar.f65154a;
                int i4 = nVar.f65155b;
                int i5 = nVar.f65156c;
                while (i4 < i5) {
                    byte b2 = bArr[i4];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i = b2 - 97;
                        } else if (b2 >= 65 && b2 <= 70) {
                            i = b2 - 65;
                        } else if (i3 == 0) {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                        } else {
                            z = true;
                            if (i4 != i5) {
                                this.f65128e = nVar.e();
                                o.b(nVar);
                            } else {
                                nVar.f65155b = i4;
                            }
                            if (!z) {
                                break;
                            }
                        }
                        i2 = i + 10;
                    } else {
                        i2 = b2 - 48;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        c cVar = new c();
                        cVar.H(j);
                        cVar.w(b2);
                        throw new NumberFormatException("Number too large: " + cVar.J());
                    }
                    j = (j << 4) | i2;
                    i4++;
                    i3++;
                }
                if (i4 != i5) {
                }
                if (!z) {
                }
            } while (this.f65128e != null);
            this.f65129f -= i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public final c n(c cVar, long j, long j2) {
        if (cVar != null) {
            s.c(this.f65129f, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f65129f += j2;
            n nVar = this.f65128e;
            while (true) {
                int i = nVar.f65156c;
                int i2 = nVar.f65155b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                nVar = nVar.f65159f;
            }
            while (j2 > 0) {
                n a2 = nVar.a();
                int i3 = (int) (a2.f65155b + j);
                a2.f65155b = i3;
                a2.f65156c = Math.min(i3 + ((int) j2), a2.f65156c);
                n nVar2 = cVar.f65128e;
                if (nVar2 == null) {
                    a2.f65160g = a2;
                    a2.f65159f = a2;
                    cVar.f65128e = a2;
                } else {
                    nVar2.f65160g.c(a2);
                }
                j2 -= a2.f65156c - a2.f65155b;
                nVar = nVar.f65159f;
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

    @Override // d.c.c.a.a.e
    public String p() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    public c q(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        n D = D(1);
                        byte[] bArr = D.f65154a;
                        int i3 = D.f65156c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = D.f65156c;
                        int i6 = (i3 + i4) - i5;
                        D.f65156c = i5 + i6;
                        this.f65129f += i6;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            w((charAt >> 6) | 192);
                            w((charAt & '?') | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                w((i8 >> 18) | 240);
                                w(((i8 >> 12) & 63) | 128);
                                w(((i8 >> 6) & 63) | 128);
                                w((i8 & 63) | 128);
                                i += 2;
                            } else {
                                w(63);
                                i = i7;
                            }
                        } else {
                            w((charAt >> '\f') | 224);
                            w(((charAt >> 6) & 63) | 128);
                            w((charAt & '?') | 128);
                        }
                        i++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public c r(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                } else if (charset != null) {
                    if (charset.equals(s.f65167a)) {
                        q(str, i, i2);
                        return this;
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    y(bytes, 0, bytes.length);
                    return this;
                } else {
                    throw new IllegalArgumentException("charset == null");
                }
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        n nVar = this.f65128e;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), nVar.f65156c - nVar.f65155b);
        byteBuffer.put(nVar.f65154a, nVar.f65155b, min);
        int i = nVar.f65155b + min;
        nVar.f65155b = i;
        this.f65129f -= min;
        if (i == nVar.f65156c) {
            this.f65128e = nVar.e();
            o.b(nVar);
        }
        return min;
    }

    public String s(long j, Charset charset) throws EOFException {
        s.c(this.f65129f, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                n nVar = this.f65128e;
                if (nVar.f65155b + j > nVar.f65156c) {
                    return new String(f(j), charset);
                }
                String str = new String(nVar.f65154a, nVar.f65155b, (int) j, charset);
                int i = (int) (nVar.f65155b + j);
                nVar.f65155b = i;
                this.f65129f -= j;
                if (i == nVar.f65156c) {
                    this.f65128e = nVar.e();
                    o.b(nVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    public boolean t(long j, com.bytedance.sdk.a.a.f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f65129f - j < i2 || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (u(i3 + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return N().toString();
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d u() throws IOException {
        A();
        return this;
    }

    public final long v() {
        return this.f65129f;
    }

    public c w(int i) {
        n D = D(1);
        byte[] bArr = D.f65154a;
        int i2 = D.f65156c;
        D.f65156c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f65129f++;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                n D = D(1);
                int min = Math.min(i, 8192 - D.f65156c);
                byteBuffer.get(D.f65154a, D.f65156c, min);
                i -= min;
                D.f65156c += min;
            }
            this.f65129f += remaining;
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

    public c y(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            s.c(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                n D = D(1);
                int min = Math.min(i3 - i, 8192 - D.f65156c);
                System.arraycopy(bArr, i, D.f65154a, D.f65156c, min);
                i += min;
                D.f65156c += min;
            }
            this.f65129f += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c z(int i) {
        n D = D(2);
        byte[] bArr = D.f65154a;
        int i2 = D.f65156c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        D.f65156c = i3 + 1;
        this.f65129f += 2;
        return this;
    }

    @Override // d.c.c.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int d2 = d(bArr, i, bArr.length - i);
            if (d2 == -1) {
                throw new EOFException();
            }
            i += d2;
        }
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            s.c(cVar.f65129f, 0L, j);
            while (j > 0) {
                n nVar = cVar.f65128e;
                if (j < nVar.f65156c - nVar.f65155b) {
                    n nVar2 = this.f65128e;
                    n nVar3 = nVar2 != null ? nVar2.f65160g : null;
                    if (nVar3 != null && nVar3.f65158e) {
                        if ((nVar3.f65156c + j) - (nVar3.f65157d ? 0 : nVar3.f65155b) <= 8192) {
                            cVar.f65128e.d(nVar3, (int) j);
                            cVar.f65129f -= j;
                            this.f65129f += j;
                            return;
                        }
                    }
                    cVar.f65128e = cVar.f65128e.b((int) j);
                }
                n nVar4 = cVar.f65128e;
                long j2 = nVar4.f65156c - nVar4.f65155b;
                cVar.f65128e = nVar4.e();
                n nVar5 = this.f65128e;
                if (nVar5 == null) {
                    this.f65128e = nVar4;
                    nVar4.f65160g = nVar4;
                    nVar4.f65159f = nVar4;
                } else {
                    nVar5.f65160g.c(nVar4);
                    nVar4.f();
                }
                cVar.f65129f -= j2;
                this.f65129f += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d c(byte[] bArr, int i, int i2) throws IOException {
        y(bArr, i, i2);
        return this;
    }

    @Override // d.c.c.a.a.e
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

    @Override // d.c.c.a.a.e
    public byte[] f(long j) throws EOFException {
        s.c(this.f65129f, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // d.c.c.a.a.e
    public void g(long j) throws EOFException {
        n nVar;
        while (j > 0) {
            if (this.f65128e != null) {
                int min = (int) Math.min(j, nVar.f65156c - nVar.f65155b);
                long j2 = min;
                this.f65129f -= j2;
                j -= j2;
                n nVar2 = this.f65128e;
                int i = nVar2.f65155b + min;
                nVar2.f65155b = i;
                if (i == nVar2.f65156c) {
                    this.f65128e = nVar2.e();
                    o.b(nVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // d.c.c.a.a.d
    public /* synthetic */ d h(long j) throws IOException {
        H(j);
        return this;
    }

    @Override // d.c.c.a.a.e
    public short i() {
        long j = this.f65129f;
        if (j >= 2) {
            n nVar = this.f65128e;
            int i = nVar.f65155b;
            int i2 = nVar.f65156c;
            if (i2 - i < 2) {
                return (short) (((h() & 255) << 8) | (h() & 255));
            }
            byte[] bArr = nVar.f65154a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f65129f = j - 2;
            if (i4 == i2) {
                this.f65128e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f65155b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f65129f);
    }

    @Override // d.c.c.a.a.e
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
        int i;
        s.c(this.f65129f, j, 1L);
        long j2 = this.f65129f;
        if (j2 - j > j) {
            n nVar = this.f65128e;
            while (true) {
                int i2 = nVar.f65156c;
                int i3 = nVar.f65155b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return nVar.f65154a[i3 + ((int) j)];
                }
                j -= j3;
                nVar = nVar.f65159f;
            }
        } else {
            long j4 = j - j2;
            n nVar2 = this.f65128e;
            do {
                nVar2 = nVar2.f65160g;
                int i4 = nVar2.f65156c;
                i = nVar2.f65155b;
                j4 += i4 - i;
            } while (j4 < 0);
            return nVar2.f65154a[i + ((int) j4)];
        }
    }

    @Override // d.c.c.a.a.e
    public com.bytedance.sdk.a.a.f c(long j) throws EOFException {
        return new com.bytedance.sdk.a.a.f(f(j));
    }

    @Override // d.c.c.a.a.e
    public byte h() {
        long j = this.f65129f;
        if (j != 0) {
            n nVar = this.f65128e;
            int i = nVar.f65155b;
            int i2 = nVar.f65156c;
            int i3 = i + 1;
            byte b2 = nVar.f65154a[i];
            this.f65129f = j - 1;
            if (i3 == i2) {
                this.f65128e = nVar.e();
                o.b(nVar);
            } else {
                nVar.f65155b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // d.c.c.a.a.q
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j >= 0) {
                long j2 = this.f65129f;
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

    @Override // d.c.c.a.a.p
    public r a() {
        return r.f65163d;
    }

    public long e(byte b2, long j, long j2) {
        n nVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f65129f;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (nVar = this.f65128e) == null) {
                return -1L;
            }
            long j5 = this.f65129f;
            if (j5 - j < j) {
                while (j5 > j) {
                    nVar = nVar.f65160g;
                    j5 -= nVar.f65156c - nVar.f65155b;
                }
            } else {
                while (true) {
                    long j6 = (nVar.f65156c - nVar.f65155b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    nVar = nVar.f65159f;
                    j3 = j6;
                }
                j5 = j3;
            }
            long j7 = j;
            while (j5 < j4) {
                byte[] bArr = nVar.f65154a;
                int min = (int) Math.min(nVar.f65156c, (nVar.f65155b + j4) - j5);
                for (int i = (int) ((nVar.f65155b + j7) - j5); i < min; i++) {
                    if (bArr[i] == b2) {
                        return (i - nVar.f65155b) + j5;
                    }
                }
                j5 += nVar.f65156c - nVar.f65155b;
                nVar = nVar.f65159f;
                j7 = j5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f65129f), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // d.c.c.a.a.e
    public String i(Charset charset) {
        try {
            return s(this.f65129f, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // d.c.c.a.a.e
    public boolean j(long j, com.bytedance.sdk.a.a.f fVar) {
        return t(j, fVar, 0, fVar.g());
    }

    public c m(int i) {
        if (i < 128) {
            w(i);
        } else if (i < 2048) {
            w((i >> 6) | 192);
            w((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                w(63);
            } else {
                w((i >> 12) | 224);
                w(((i >> 6) & 63) | 128);
                w((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            w((i >> 18) | 240);
            w(((i >> 12) & 63) | 128);
            w(((i >> 6) & 63) | 128);
            w((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }
}
