package d.b.c0.a.f;

import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class b extends Thread {
    public int A;
    public Bitmap B;
    public Bitmap C;
    public c D;
    public boolean E;
    public byte[] F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public short[] M;
    public byte[] N;
    public byte[] O;
    public byte[] P;
    public c Q;
    public int R;
    public a S;
    public byte[] T;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f43033e;

    /* renamed from: f  reason: collision with root package name */
    public int f43034f;

    /* renamed from: g  reason: collision with root package name */
    public int f43035g;

    /* renamed from: h  reason: collision with root package name */
    public int f43036h;
    public boolean i;
    public int j;
    public int[] k;
    public int[] l;
    public int[] m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public b(byte[] bArr, a aVar) {
        this.D = null;
        this.E = false;
        this.F = new byte[256];
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = 0;
        this.S = null;
        this.T = null;
        this.T = bArr;
        this.S = aVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00c0 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v25, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        short s;
        int i6 = this.v * this.w;
        byte[] bArr = this.P;
        if (bArr == null || bArr.length < i6) {
            this.P = new byte[i6];
        }
        if (this.M == null) {
            this.M = new short[4096];
        }
        if (this.N == null) {
            this.N = new byte[4096];
        }
        if (this.O == null) {
            this.O = new byte[4097];
        }
        int j = j();
        int i7 = 1 << j;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = j + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            this.M[i12] = 0;
            this.N[i12] = (byte) i12;
        }
        int i13 = i10;
        int i14 = i9;
        int i15 = i11;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i17 < i6) {
            if (i18 != 0) {
                i = i10;
                i2 = i8;
                int i25 = i23;
                i3 = i7;
                i4 = i25;
            } else if (i19 >= i13) {
                int i26 = i20 & i15;
                i20 >>= i13;
                i19 -= i13;
                if (i26 > i14 || i26 == i8) {
                    break;
                } else if (i26 == i7) {
                    i13 = i10;
                    i14 = i9;
                    i15 = i11;
                    i16 = -1;
                } else if (i16 == -1) {
                    this.O[i18] = this.N[i26];
                    i16 = i26;
                    i23 = i16;
                    i18++;
                    i10 = i10;
                } else {
                    i = i10;
                    if (i26 == i14) {
                        i5 = i26;
                        this.O[i18] = (byte) i23;
                        s = i16;
                        i18++;
                    } else {
                        i5 = i26;
                        s = i5;
                    }
                    while (s > i7) {
                        this.O[i18] = this.N[s];
                        s = this.M[s];
                        i18++;
                        i7 = i7;
                    }
                    i3 = i7;
                    byte[] bArr2 = this.N;
                    i4 = bArr2[s] & 255;
                    if (i14 >= 4096) {
                        break;
                    }
                    int i27 = i18 + 1;
                    i2 = i8;
                    byte b2 = (byte) i4;
                    this.O[i18] = b2;
                    this.M[i14] = (short) i16;
                    bArr2[i14] = b2;
                    i14++;
                    if ((i14 & i15) == 0 && i14 < 4096) {
                        i13++;
                        i15 += i14;
                    }
                    i18 = i27;
                    i16 = i5;
                }
            } else {
                if (i21 == 0) {
                    i21 = k();
                    if (i21 <= 0) {
                        break;
                    }
                    i22 = 0;
                }
                i20 += (this.F[i22] & 255) << i19;
                i19 += 8;
                i22++;
                i21--;
            }
            i18--;
            this.P[i24] = this.O[i18];
            i17++;
            i24++;
            i7 = i3;
            i8 = i2;
            i23 = i4;
            i10 = i;
        }
        for (int i28 = i24; i28 < i6; i28++) {
            this.P[i28] = 0;
        }
    }

    public final boolean b() {
        return this.f43034f != 0;
    }

    public void c() {
        c cVar = this.Q;
        while (cVar != null) {
            cVar.f43037a = null;
            cVar = this.Q.f43039c;
            this.Q = cVar;
        }
        InputStream inputStream = this.f43033e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
            this.f43033e = null;
        }
        this.T = null;
    }

    public c d(int i) {
        c cVar = this.Q;
        int i2 = 0;
        while (cVar != null) {
            if (i2 == i) {
                return cVar;
            }
            cVar = cVar.f43039c;
            i2++;
        }
        return null;
    }

    public int e() {
        return this.R;
    }

    public Bitmap f(int i) {
        c d2 = d(i);
        if (d2 == null) {
            return null;
        }
        return d2.f43037a;
    }

    public Bitmap g() {
        return f(0);
    }

    public final void h() {
        this.f43034f = 0;
        this.R = 0;
        this.Q = null;
        this.k = null;
        this.l = null;
    }

    public c i() {
        if (!this.E) {
            this.E = true;
            return this.Q;
        }
        if (this.f43034f == 0) {
            c cVar = this.D.f43039c;
            if (cVar != null) {
                this.D = cVar;
            }
        } else {
            c cVar2 = this.D.f43039c;
            this.D = cVar2;
            if (cVar2 == null) {
                this.D = this.Q;
            }
        }
        return this.D;
    }

    public final int j() {
        try {
            return this.f43033e.read();
        } catch (Exception unused) {
            this.f43034f = 1;
            return 0;
        }
    }

    public final int k() {
        int j = j();
        this.G = j;
        int i = 0;
        if (j > 0) {
            while (i < this.G) {
                try {
                    int read = this.f43033e.read(this.F, i, this.G - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception unused) {
                }
            }
            if (i < this.G) {
                this.f43034f = 1;
            }
        }
        return i;
    }

    public final int l() {
        this.f43033e = new ByteArrayInputStream(this.T);
        this.T = null;
        return u();
    }

    public final int[] m(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.f43033e.read(bArr);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 < i3) {
            this.f43034f = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i4 = i7 + 1;
        }
        return iArr;
    }

    public final void n() {
        boolean z = false;
        while (!z && !b()) {
            int j = j();
            if (j != 0) {
                if (j == 33) {
                    int j2 = j();
                    if (j2 == 249) {
                        o();
                    } else if (j2 != 255) {
                        x();
                    } else {
                        k();
                        String str = "";
                        for (int i = 0; i < 11; i++) {
                            str = str + ((char) this.F[i]);
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            s();
                        } else {
                            x();
                        }
                    }
                } else if (j == 44) {
                    q();
                } else if (j != 59) {
                    this.f43034f = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    public final void o() {
        j();
        int j = j();
        int i = (j & 28) >> 2;
        this.H = i;
        if (i == 0) {
            this.H = 1;
        }
        this.J = (j & 1) != 0;
        this.K = t() * 10;
        this.L = j();
        j();
    }

    public final void p() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) j());
        }
        if (!str.startsWith("GIF")) {
            this.f43034f = 1;
            return;
        }
        r();
        if (!this.i || b()) {
            return;
        }
        int[] m = m(this.j);
        this.k = m;
        this.o = m[this.n];
    }

    public final void q() {
        int[] iArr;
        this.t = t();
        this.u = t();
        this.v = t();
        this.w = t();
        int j = j();
        int i = 0;
        this.q = (j & 128) != 0;
        this.r = (j & 64) != 0;
        int i2 = 2 << (j & 7);
        this.s = i2;
        if (this.q) {
            int[] m = m(i2);
            this.l = m;
            this.m = m;
        } else {
            this.m = this.k;
            if (this.n == this.L) {
                this.o = 0;
            }
        }
        if (this.J) {
            int[] iArr2 = this.m;
            int i3 = this.L;
            int i4 = iArr2[i3];
            iArr2[i3] = 0;
            i = i4;
        }
        if (this.m == null) {
            this.f43034f = 1;
        }
        if (b()) {
            return;
        }
        a();
        x();
        if (b()) {
            return;
        }
        this.R++;
        this.B = Bitmap.createBitmap(this.f43035g, this.f43036h, Bitmap.Config.ARGB_4444);
        w();
        c cVar = this.Q;
        if (cVar == null) {
            c cVar2 = new c(this.B, this.K);
            this.Q = cVar2;
            this.D = cVar2;
        } else {
            while (true) {
                c cVar3 = cVar.f43039c;
                if (cVar3 == null) {
                    break;
                }
                cVar = cVar3;
            }
            cVar.f43039c = new c(this.B, this.K);
        }
        if (this.J && (iArr = this.m) != null) {
            iArr[this.L] = i;
        }
        v();
        this.S.a(true, this.R);
    }

    public final void r() {
        this.f43035g = t();
        this.f43036h = t();
        int j = j();
        this.i = (j & 128) != 0;
        this.j = 2 << (j & 7);
        this.n = j();
        j();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.f43033e != null) {
                u();
            } else if (this.T != null) {
                l();
            }
        } catch (Exception unused) {
        }
    }

    public final void s() {
        do {
            k();
            byte[] bArr = this.F;
            if (bArr[0] == 1) {
                byte b2 = bArr[1];
                byte b3 = bArr[2];
            }
            if (this.G <= 0) {
                return;
            }
        } while (!b());
    }

    public final int t() {
        return j() | (j() << 8);
    }

    public final int u() {
        h();
        if (this.f43033e != null) {
            p();
            if (!b()) {
                n();
                if (this.R < 0) {
                    this.f43034f = 1;
                    this.S.a(false, -1);
                } else {
                    this.f43034f = -1;
                    this.S.a(true, -1);
                }
            }
            try {
                this.f43033e.close();
            } catch (Exception unused) {
            }
        } else {
            this.f43034f = 2;
            this.S.a(false, -1);
        }
        return this.f43034f;
    }

    public final void v() {
        this.I = this.H;
        this.x = this.t;
        this.y = this.u;
        this.z = this.v;
        this.A = this.w;
        this.C = this.B;
        this.p = this.o;
        this.H = 0;
        this.J = false;
        this.K = 0;
        this.l = null;
    }

    public final void w() {
        int i;
        int[] iArr = new int[this.f43035g * this.f43036h];
        int i2 = this.I;
        int i3 = 0;
        if (i2 > 0) {
            if (i2 == 3) {
                int i4 = this.R - 2;
                if (i4 > 0) {
                    this.C = f(i4 - 1);
                } else {
                    this.C = null;
                }
            }
            Bitmap bitmap = this.C;
            if (bitmap != null) {
                int i5 = this.f43035g;
                bitmap.getPixels(iArr, 0, i5, 0, 0, i5, this.f43036h);
                if (this.I == 2) {
                    int i6 = !this.J ? this.p : 0;
                    for (int i7 = 0; i7 < this.A; i7++) {
                        int i8 = ((this.y + i7) * this.f43035g) + this.x;
                        int i9 = this.z + i8;
                        while (i8 < i9) {
                            iArr[i8] = i6;
                            i8++;
                        }
                    }
                }
            }
        }
        int i10 = 8;
        int i11 = 0;
        int i12 = 1;
        while (true) {
            int i13 = this.w;
            if (i3 < i13) {
                if (this.r) {
                    if (i11 >= i13) {
                        i12++;
                        if (i12 == 2) {
                            i11 = 4;
                        } else if (i12 == 3) {
                            i10 = 4;
                            i11 = 2;
                        } else if (i12 == 4) {
                            i10 = 2;
                            i11 = 1;
                        }
                    }
                    i = i11 + i10;
                } else {
                    i = i11;
                    i11 = i3;
                }
                int i14 = i11 + this.u;
                if (i14 < this.f43036h) {
                    int i15 = this.f43035g;
                    int i16 = i14 * i15;
                    int i17 = this.t + i16;
                    int i18 = this.v + i17;
                    if (i16 + i15 < i18) {
                        i18 = i16 + i15;
                    }
                    int i19 = this.v * i3;
                    while (i17 < i18) {
                        int i20 = i19 + 1;
                        int i21 = this.m[this.P[i19] & 255];
                        if (i21 != 0) {
                            iArr[i17] = i21;
                        }
                        i17++;
                        i19 = i20;
                    }
                }
                i3++;
                i11 = i;
            } else {
                try {
                    this.B = Bitmap.createBitmap(iArr, this.f43035g, this.f43036h, Bitmap.Config.ARGB_4444);
                    return;
                } catch (OutOfMemoryError unused) {
                    return;
                }
            }
        }
    }

    public final void x() {
        do {
            k();
            if (this.G <= 0) {
                return;
            }
        } while (!b());
    }

    public b(InputStream inputStream, a aVar) {
        this.D = null;
        this.E = false;
        this.F = new byte[256];
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = 0;
        this.S = null;
        this.T = null;
        this.f43033e = inputStream;
        this.S = aVar;
    }
}
