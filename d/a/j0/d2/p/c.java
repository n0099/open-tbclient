package d.a.j0.d2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1202c f52978a;

    /* renamed from: b  reason: collision with root package name */
    public int f52979b;

    /* renamed from: c  reason: collision with root package name */
    public int f52980c;

    /* renamed from: d  reason: collision with root package name */
    public float f52981d;

    /* renamed from: e  reason: collision with root package name */
    public float f52982e;

    /* renamed from: f  reason: collision with root package name */
    public float f52983f;

    /* renamed from: g  reason: collision with root package name */
    public int f52984g;

    /* renamed from: h  reason: collision with root package name */
    public int f52985h;

    /* renamed from: i  reason: collision with root package name */
    public b f52986i;
    public int j;
    public int k;
    public float l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public Random t;
    public Bitmap u;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f52988b;

        /* renamed from: g  reason: collision with root package name */
        public int f52993g;

        /* renamed from: h  reason: collision with root package name */
        public int f52994h;

        /* renamed from: i  reason: collision with root package name */
        public int f52995i;
        public int j;
        public InterfaceC1202c k;

        /* renamed from: a  reason: collision with root package name */
        public int f52987a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52989c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52990d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52991e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f52992f = false;

        public b(Bitmap bitmap) {
            this.f52988b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i2, int i3) {
            this.f52995i = i2;
            this.j = i3;
            return this;
        }

        public b n(InterfaceC1202c interfaceC1202c) {
            this.k = interfaceC1202c;
            return this;
        }

        public b o(int i2, int i3, boolean z) {
            this.f52993g = i2;
            this.f52994h = i3;
            this.f52988b = c.a(this.f52988b, i2, i3);
            this.f52990d = z;
            return this;
        }

        public b p(int i2, boolean z) {
            this.f52987a = i2;
            this.f52989c = z;
            return this;
        }

        public b q(int i2, boolean z, boolean z2) {
            this.f52991e = z;
            this.f52992f = z2;
            return this;
        }
    }

    /* renamed from: d.a.j0.d2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1202c {
        float a();
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void b(Canvas canvas, Paint paint) {
        c();
        float f2 = this.f52982e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f52981d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f52981d = (float) (this.f52981d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f52981d;
        int i2 = this.j;
        int i3 = this.o;
        if (f2 > i2 - i3) {
            this.f52981d = i2 - i3;
        }
    }

    public final void e() {
        this.f52982e += this.f52983f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.f52986i.f52988b;
        } else {
            InterfaceC1202c interfaceC1202c = this.f52978a;
            if (interfaceC1202c != null) {
                nextInt = interfaceC1202c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i2 = this.p;
            this.u = a(this.f52986i.f52988b, (int) (i2 > 0 ? Math.max(i2, this.f52986i.f52988b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f52986i.f52988b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f52983f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f52979b;
        } else {
            this.f52983f = this.f52979b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f52980c) / 50.0d);
        } else {
            this.l = this.f52980c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i2, int i3) {
        this.f52986i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f52984g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f52985h = nextInt;
        this.f52981d = this.f52984g;
        this.f52982e = nextInt;
        this.m = bVar.f52989c;
        this.n = bVar.f52990d;
        this.f52978a = bVar.k;
        this.p = bVar.f52995i;
        this.q = bVar.j;
        this.o = bVar.f52993g;
        int unused = bVar.f52994h;
        this.r = bVar.f52991e;
        this.s = bVar.f52992f;
        this.f52979b = bVar.f52987a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.f52986i = bVar;
        this.u = bVar.f52988b;
        this.o = bVar.f52993g;
        int unused = bVar.f52994h;
        this.p = bVar.f52995i;
        this.f52978a = bVar.k;
        this.q = bVar.j;
        this.f52979b = bVar.f52987a;
        this.n = bVar.f52990d;
        this.r = bVar.f52991e;
        this.s = bVar.f52992f;
        this.m = bVar.f52989c;
    }
}
