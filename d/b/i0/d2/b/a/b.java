package d.b.i0.d2.b.a;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54104a;

    /* renamed from: b  reason: collision with root package name */
    public int f54105b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f54106c;

    /* renamed from: d  reason: collision with root package name */
    public int f54107d;

    /* renamed from: e  reason: collision with root package name */
    public int f54108e;

    /* renamed from: f  reason: collision with root package name */
    public int f54109f;

    /* renamed from: g  reason: collision with root package name */
    public int f54110g;
    public int i;
    public int p;
    public int q;
    public int r;
    public int v;

    /* renamed from: h  reason: collision with root package name */
    public int f54111h = 12;
    public int j = 4096;
    public int[] k = new int[5003];
    public int[] l = new int[5003];
    public int m = 5003;
    public int n = 0;
    public boolean o = false;
    public int s = 0;
    public int t = 0;
    public int[] u = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    public byte[] w = new byte[256];

    public b(int i, int i2, byte[] bArr, int i3) {
        this.f54104a = i;
        this.f54105b = i2;
        this.f54106c = bArr;
        this.f54107d = Math.max(2, i3);
    }

    public final int a(int i) {
        return (1 << i) - 1;
    }

    public void b(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.w;
        int i = this.v;
        int i2 = i + 1;
        this.v = i2;
        bArr[i] = b2;
        if (i2 >= 254) {
            g(outputStream);
        }
    }

    public void c(OutputStream outputStream) throws IOException {
        d(this.m);
        int i = this.q;
        this.n = i + 2;
        this.o = true;
        i(i, outputStream);
    }

    public void d(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = -1;
        }
    }

    public void e(int i, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.p = i;
        int i2 = 0;
        this.o = false;
        this.f54110g = i;
        this.i = a(i);
        int i3 = 1 << (i - 1);
        this.q = i3;
        this.r = i3 + 1;
        this.n = i3 + 2;
        this.v = 0;
        int h2 = h();
        for (int i4 = this.m; i4 < 65536; i4 *= 2) {
            i2++;
        }
        int i5 = 8 - i2;
        int i6 = this.m;
        d(i6);
        i(this.q, outputStream);
        while (true) {
            int h3 = h();
            if (h3 != -1) {
                int i7 = (h3 << this.f54111h) + h2;
                int i8 = (h3 << i5) ^ h2;
                int[] iArr2 = this.k;
                if (iArr2[i8] == i7) {
                    h2 = this.l[i8];
                } else {
                    if (iArr2[i8] >= 0) {
                        int i9 = i6 - i8;
                        if (i8 == 0) {
                            i9 = 1;
                        }
                        do {
                            i8 -= i9;
                            if (i8 < 0) {
                                i8 += i6;
                            }
                            iArr = this.k;
                            if (iArr[i8] == i7) {
                                h2 = this.l[i8];
                                break;
                            }
                        } while (iArr[i8] >= 0);
                    }
                    i(h2, outputStream);
                    int i10 = this.n;
                    if (i10 < this.j) {
                        int[] iArr3 = this.l;
                        this.n = i10 + 1;
                        iArr3[i8] = i10;
                        this.k[i8] = i7;
                    } else {
                        c(outputStream);
                    }
                    h2 = h3;
                }
            } else {
                i(h2, outputStream);
                i(this.r, outputStream);
                return;
            }
        }
    }

    public void f(OutputStream outputStream) throws IOException {
        outputStream.write(this.f54107d);
        this.f54108e = this.f54104a * this.f54105b;
        this.f54109f = 0;
        e(this.f54107d + 1, outputStream);
        outputStream.write(0);
    }

    public void g(OutputStream outputStream) throws IOException {
        int i = this.v;
        if (i > 0) {
            outputStream.write(i);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    public final int h() {
        int i = this.f54108e;
        if (i == 0) {
            return -1;
        }
        this.f54108e = i - 1;
        byte[] bArr = this.f54106c;
        int i2 = this.f54109f;
        this.f54109f = i2 + 1;
        return bArr[i2] & 255;
    }

    public void i(int i, OutputStream outputStream) throws IOException {
        int i2 = this.s;
        int[] iArr = this.u;
        int i3 = this.t;
        int i4 = i2 & iArr[i3];
        this.s = i4;
        if (i3 > 0) {
            this.s = i4 | (i << i3);
        } else {
            this.s = i;
        }
        this.t += this.f54110g;
        while (this.t >= 8) {
            b((byte) (this.s & 255), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.i || this.o) {
            if (this.o) {
                int i5 = this.p;
                this.f54110g = i5;
                this.i = a(i5);
                this.o = false;
            } else {
                int i6 = this.f54110g + 1;
                this.f54110g = i6;
                if (i6 == this.f54111h) {
                    this.i = this.j;
                } else {
                    this.i = a(i6);
                }
            }
        }
        if (i == this.r) {
            while (this.t > 0) {
                b((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            g(outputStream);
        }
    }
}
