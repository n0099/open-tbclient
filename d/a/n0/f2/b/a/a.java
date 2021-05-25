package d.a.n0.f2.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.media.session.MediaSessionCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f54806a;

    /* renamed from: b  reason: collision with root package name */
    public int f54807b;

    /* renamed from: f  reason: collision with root package name */
    public int f54811f;
    public OutputStream j;
    public Bitmap k;
    public byte[] l;
    public byte[] m;
    public int n;
    public byte[] o;

    /* renamed from: c  reason: collision with root package name */
    public int f54808c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54809d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54810e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f54812g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f54813h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54814i = false;
    public boolean[] p = new boolean[256];
    public int q = 7;
    public int r = -1;
    public boolean s = false;
    public boolean t = true;
    public boolean u = false;
    public int v = 10;

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.f54814i) {
            return false;
        }
        try {
            if (!this.u) {
                h(bitmap.getWidth(), bitmap.getHeight());
            }
            this.k = bitmap;
            f();
            b();
            if (this.t) {
                l();
                n();
                if (this.f54812g >= 0) {
                    m();
                }
            }
            j();
            k();
            if (!this.t) {
                n();
            }
            o();
            this.t = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void b() {
        byte[] bArr = this.l;
        int length = bArr.length;
        int i2 = length / 3;
        this.m = new byte[i2];
        c cVar = new c(bArr, length, this.v);
        this.o = cVar.h();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr2 = this.o;
            if (i4 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i4];
            int i5 = i4 + 2;
            bArr2[i4] = bArr2[i5];
            bArr2[i5] = b2;
            this.p[i4 / 3] = false;
            i4 += 3;
        }
        int i6 = 0;
        while (i3 < i2) {
            byte[] bArr3 = this.l;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int g2 = cVar.g(bArr3[i6] & 255, bArr3[i7] & 255, bArr3[i8] & 255);
            this.p[g2] = true;
            this.m[i3] = (byte) g2;
            i3++;
            i6 = i8 + 1;
        }
        this.l = null;
        this.n = 8;
        this.q = 7;
        int i9 = this.f54810e;
        if (i9 != -1) {
            this.f54811f = c(i9);
        }
    }

    public int c(int i2) {
        byte[] bArr = this.o;
        if (bArr == null) {
            return -1;
        }
        int i3 = (i2 >> 16) & 255;
        int i4 = (i2 >> 8) & 255;
        int i5 = 0;
        int i6 = (i2 >> 0) & 255;
        int length = bArr.length;
        int i7 = 0;
        int i8 = 16777216;
        while (i5 < length) {
            byte[] bArr2 = this.o;
            int i9 = i5 + 1;
            int i10 = i3 - (bArr2[i5] & 255);
            int i11 = i9 + 1;
            int i12 = i4 - (bArr2[i9] & 255);
            int i13 = i6 - (bArr2[i11] & 255);
            int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
            int i15 = i11 / 3;
            if (this.p[i15] && i14 < i8) {
                i8 = i14;
                i7 = i15;
            }
            i5 = i11 + 1;
        }
        return i7;
    }

    public boolean d() {
        boolean z;
        if (this.f54814i) {
            this.f54814i = false;
            try {
                this.j.write(59);
                this.j.flush();
                if (this.s) {
                    this.j.close();
                }
                z = true;
            } catch (IOException unused) {
                z = false;
            }
            this.f54811f = 0;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.o = null;
            this.s = false;
            this.t = true;
            return z;
        }
        return false;
    }

    public int[] e(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    public void f() {
        int width = this.k.getWidth();
        int height = this.k.getHeight();
        if (width != this.f54806a || height != this.f54807b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f54806a, this.f54807b, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
            this.k = createBitmap;
        }
        int[] e2 = e(this.k);
        this.l = new byte[e2.length * 3];
        for (int i2 = 0; i2 < e2.length; i2++) {
            int i3 = e2[i2];
            int i4 = i2 * 3;
            byte[] bArr = this.l;
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i3 >> 0) & 255);
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            bArr[i5 + 1] = (byte) ((i3 >> 16) & 255);
        }
    }

    public void g(int i2) {
        if (i2 >= 0) {
            this.f54812g = i2;
        }
    }

    public void h(int i2, int i3) {
        this.f54806a = i2;
        this.f54807b = i3;
        if (i2 < 1) {
            this.f54806a = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        }
        if (this.f54807b < 1) {
            this.f54807b = 240;
        }
        this.u = true;
    }

    public boolean i(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.s = false;
        this.j = outputStream;
        try {
            q("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.f54814i = z;
        return z;
    }

    public void j() throws IOException {
        int i2;
        int i3;
        this.j.write(33);
        this.j.write(249);
        this.j.write(4);
        if (this.f54810e == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = 1;
            i3 = 2;
        }
        int i4 = this.r;
        if (i4 >= 0) {
            i3 = i4 & 7;
        }
        this.j.write(i2 | (i3 << 2) | 0 | 0);
        p(this.f54813h);
        this.j.write(this.f54811f);
        this.j.write(0);
    }

    public void k() throws IOException {
        this.j.write(44);
        p(this.f54808c);
        p(this.f54809d);
        p(this.f54806a);
        p(this.f54807b);
        if (this.t) {
            this.j.write(0);
        } else {
            this.j.write(this.q | 128);
        }
    }

    public void l() throws IOException {
        p(this.f54806a);
        p(this.f54807b);
        this.j.write(this.q | 240);
        this.j.write(0);
        this.j.write(0);
    }

    public void m() throws IOException {
        this.j.write(33);
        this.j.write(255);
        this.j.write(11);
        q("NETSCAPE2.0");
        this.j.write(3);
        this.j.write(1);
        p(this.f54812g);
        this.j.write(0);
    }

    public void n() throws IOException {
        OutputStream outputStream = this.j;
        byte[] bArr = this.o;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.o.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.j.write(0);
        }
    }

    public void o() throws IOException {
        new b(this.f54806a, this.f54807b, this.m, this.n).f(this.j);
    }

    public void p(int i2) throws IOException {
        this.j.write(i2 & 255);
        this.j.write((i2 >> 8) & 255);
    }

    public void q(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.j.write((byte) str.charAt(i2));
        }
    }
}
