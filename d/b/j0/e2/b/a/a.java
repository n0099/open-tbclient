package d.b.j0.e2.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.media.session.MediaSessionCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f56040a;

    /* renamed from: b  reason: collision with root package name */
    public int f56041b;

    /* renamed from: f  reason: collision with root package name */
    public int f56045f;
    public OutputStream j;
    public Bitmap k;
    public byte[] l;
    public byte[] m;
    public int n;
    public byte[] o;

    /* renamed from: c  reason: collision with root package name */
    public int f56042c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56043d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f56044e = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f56046g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f56047h = 0;
    public boolean i = false;
    public boolean[] p = new boolean[256];
    public int q = 7;
    public int r = -1;
    public boolean s = false;
    public boolean t = true;
    public boolean u = false;
    public int v = 10;

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.i) {
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
                if (this.f56046g >= 0) {
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
        int i = length / 3;
        this.m = new byte[i];
        c cVar = new c(bArr, length, this.v);
        this.o = cVar.h();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.o;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i3];
            int i4 = i3 + 2;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b2;
            this.p[i3 / 3] = false;
            i3 += 3;
        }
        int i5 = 0;
        while (i2 < i) {
            byte[] bArr3 = this.l;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int g2 = cVar.g(bArr3[i5] & 255, bArr3[i6] & 255, bArr3[i7] & 255);
            this.p[g2] = true;
            this.m[i2] = (byte) g2;
            i2++;
            i5 = i7 + 1;
        }
        this.l = null;
        this.n = 8;
        this.q = 7;
        int i8 = this.f56044e;
        if (i8 != -1) {
            this.f56045f = c(i8);
        }
    }

    public int c(int i) {
        byte[] bArr = this.o;
        if (bArr == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = 0;
        int i5 = (i >> 0) & 255;
        int length = bArr.length;
        int i6 = 0;
        int i7 = 16777216;
        while (i4 < length) {
            byte[] bArr2 = this.o;
            int i8 = i4 + 1;
            int i9 = i2 - (bArr2[i4] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (bArr2[i8] & 255);
            int i12 = i5 - (bArr2[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (this.p[i14] && i13 < i7) {
                i7 = i13;
                i6 = i14;
            }
            i4 = i10 + 1;
        }
        return i6;
    }

    public boolean d() {
        boolean z;
        if (this.i) {
            this.i = false;
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
            this.f56045f = 0;
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
        if (width != this.f56040a || height != this.f56041b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f56040a, this.f56041b, Bitmap.Config.RGB_565);
            new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
            this.k = createBitmap;
        }
        int[] e2 = e(this.k);
        this.l = new byte[e2.length * 3];
        for (int i = 0; i < e2.length; i++) {
            int i2 = e2[i];
            int i3 = i * 3;
            byte[] bArr = this.l;
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 0) & 255);
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            bArr[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    public void g(int i) {
        if (i >= 0) {
            this.f56046g = i;
        }
    }

    public void h(int i, int i2) {
        this.f56040a = i;
        this.f56041b = i2;
        if (i < 1) {
            this.f56040a = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
        }
        if (this.f56041b < 1) {
            this.f56041b = 240;
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
        this.i = z;
        return z;
    }

    public void j() throws IOException {
        int i;
        int i2;
        this.j.write(33);
        this.j.write(249);
        this.j.write(4);
        if (this.f56044e == -1) {
            i = 0;
            i2 = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        int i3 = this.r;
        if (i3 >= 0) {
            i2 = i3 & 7;
        }
        this.j.write(i | (i2 << 2) | 0 | 0);
        p(this.f56047h);
        this.j.write(this.f56045f);
        this.j.write(0);
    }

    public void k() throws IOException {
        this.j.write(44);
        p(this.f56042c);
        p(this.f56043d);
        p(this.f56040a);
        p(this.f56041b);
        if (this.t) {
            this.j.write(0);
        } else {
            this.j.write(this.q | 128);
        }
    }

    public void l() throws IOException {
        p(this.f56040a);
        p(this.f56041b);
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
        p(this.f56046g);
        this.j.write(0);
    }

    public void n() throws IOException {
        OutputStream outputStream = this.j;
        byte[] bArr = this.o;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.o.length;
        for (int i = 0; i < length; i++) {
            this.j.write(0);
        }
    }

    public void o() throws IOException {
        new b(this.f56040a, this.f56041b, this.m, this.n).f(this.j);
    }

    public void p(int i) throws IOException {
        this.j.write(i & 255);
        this.j.write((i >> 8) & 255);
    }

    public void q(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.j.write((byte) str.charAt(i));
        }
    }
}
