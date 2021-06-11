package d.a.n0.f2.b.a;

import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f58504a;

    /* renamed from: b  reason: collision with root package name */
    public int f58505b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f58506c;

    /* renamed from: d  reason: collision with root package name */
    public int f58507d;

    /* renamed from: e  reason: collision with root package name */
    public int f58508e;

    /* renamed from: f  reason: collision with root package name */
    public int f58509f;

    /* renamed from: g  reason: collision with root package name */
    public int f58510g;

    /* renamed from: i  reason: collision with root package name */
    public int f58512i;
    public int p;
    public int q;
    public int r;
    public int v;

    /* renamed from: h  reason: collision with root package name */
    public int f58511h = 12;
    public int j = 4096;
    public int[] k = new int[5003];
    public int[] l = new int[5003];
    public int m = 5003;
    public int n = 0;
    public boolean o = false;
    public int s = 0;
    public int t = 0;
    public int[] u = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, RevenueServerConst.GetUserCouponStoreResponse, 4095, 8191, 16383, 32767, 65535};
    public byte[] w = new byte[256];

    public b(int i2, int i3, byte[] bArr, int i4) {
        this.f58504a = i2;
        this.f58505b = i3;
        this.f58506c = bArr;
        this.f58507d = Math.max(2, i4);
    }

    public final int a(int i2) {
        return (1 << i2) - 1;
    }

    public void b(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.w;
        int i2 = this.v;
        int i3 = i2 + 1;
        this.v = i3;
        bArr[i2] = b2;
        if (i3 >= 254) {
            g(outputStream);
        }
    }

    public void c(OutputStream outputStream) throws IOException {
        d(this.m);
        int i2 = this.q;
        this.n = i2 + 2;
        this.o = true;
        i(i2, outputStream);
    }

    public void d(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.k[i3] = -1;
        }
    }

    public void e(int i2, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.p = i2;
        int i3 = 0;
        this.o = false;
        this.f58510g = i2;
        this.f58512i = a(i2);
        int i4 = 1 << (i2 - 1);
        this.q = i4;
        this.r = i4 + 1;
        this.n = i4 + 2;
        this.v = 0;
        int h2 = h();
        for (int i5 = this.m; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.m;
        d(i7);
        i(this.q, outputStream);
        while (true) {
            int h3 = h();
            if (h3 != -1) {
                int i8 = (h3 << this.f58511h) + h2;
                int i9 = (h3 << i6) ^ h2;
                int[] iArr2 = this.k;
                if (iArr2[i9] == i8) {
                    h2 = this.l[i9];
                } else {
                    if (iArr2[i9] >= 0) {
                        int i10 = i7 - i9;
                        if (i9 == 0) {
                            i10 = 1;
                        }
                        do {
                            i9 -= i10;
                            if (i9 < 0) {
                                i9 += i7;
                            }
                            iArr = this.k;
                            if (iArr[i9] == i8) {
                                h2 = this.l[i9];
                                break;
                            }
                        } while (iArr[i9] >= 0);
                    }
                    i(h2, outputStream);
                    int i11 = this.n;
                    if (i11 < this.j) {
                        int[] iArr3 = this.l;
                        this.n = i11 + 1;
                        iArr3[i9] = i11;
                        this.k[i9] = i8;
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
        outputStream.write(this.f58507d);
        this.f58508e = this.f58504a * this.f58505b;
        this.f58509f = 0;
        e(this.f58507d + 1, outputStream);
        outputStream.write(0);
    }

    public void g(OutputStream outputStream) throws IOException {
        int i2 = this.v;
        if (i2 > 0) {
            outputStream.write(i2);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    public final int h() {
        int i2 = this.f58508e;
        if (i2 == 0) {
            return -1;
        }
        this.f58508e = i2 - 1;
        byte[] bArr = this.f58506c;
        int i3 = this.f58509f;
        this.f58509f = i3 + 1;
        return bArr[i3] & 255;
    }

    public void i(int i2, OutputStream outputStream) throws IOException {
        int i3 = this.s;
        int[] iArr = this.u;
        int i4 = this.t;
        int i5 = i3 & iArr[i4];
        this.s = i5;
        if (i4 > 0) {
            this.s = i5 | (i2 << i4);
        } else {
            this.s = i2;
        }
        this.t += this.f58510g;
        while (this.t >= 8) {
            b((byte) (this.s & 255), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.f58512i || this.o) {
            if (this.o) {
                int i6 = this.p;
                this.f58510g = i6;
                this.f58512i = a(i6);
                this.o = false;
            } else {
                int i7 = this.f58510g + 1;
                this.f58510g = i7;
                if (i7 == this.f58511h) {
                    this.f58512i = this.j;
                } else {
                    this.f58512i = a(i7);
                }
            }
        }
        if (i2 == this.r) {
            while (this.t > 0) {
                b((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            g(outputStream);
        }
    }
}
