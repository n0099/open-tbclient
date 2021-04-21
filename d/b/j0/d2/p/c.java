package d.b.j0.d2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1263c f55145a;

    /* renamed from: b  reason: collision with root package name */
    public int f55146b;

    /* renamed from: c  reason: collision with root package name */
    public int f55147c;

    /* renamed from: d  reason: collision with root package name */
    public float f55148d;

    /* renamed from: e  reason: collision with root package name */
    public float f55149e;

    /* renamed from: f  reason: collision with root package name */
    public float f55150f;

    /* renamed from: g  reason: collision with root package name */
    public int f55151g;

    /* renamed from: h  reason: collision with root package name */
    public int f55152h;
    public b i;
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
        public Bitmap f55154b;

        /* renamed from: g  reason: collision with root package name */
        public int f55159g;

        /* renamed from: h  reason: collision with root package name */
        public int f55160h;
        public int i;
        public int j;
        public InterfaceC1263c k;

        /* renamed from: a  reason: collision with root package name */
        public int f55153a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55155c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55156d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f55157e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f55158f = false;

        public b(Bitmap bitmap) {
            this.f55154b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i, int i2) {
            this.i = i;
            this.j = i2;
            return this;
        }

        public b n(InterfaceC1263c interfaceC1263c) {
            this.k = interfaceC1263c;
            return this;
        }

        public b o(int i, int i2, boolean z) {
            this.f55159g = i;
            this.f55160h = i2;
            this.f55154b = c.a(this.f55154b, i, i2);
            this.f55156d = z;
            return this;
        }

        public b p(int i, boolean z) {
            this.f55153a = i;
            this.f55155c = z;
            return this;
        }

        public b q(int i, boolean z, boolean z2) {
            this.f55157e = z;
            this.f55158f = z2;
            return this;
        }
    }

    /* renamed from: d.b.j0.d2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1263c {
        float a();
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void b(Canvas canvas, Paint paint) {
        c();
        float f2 = this.f55149e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f55148d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f55148d = (float) (this.f55148d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f55148d;
        int i = this.j;
        int i2 = this.o;
        if (f2 > i - i2) {
            this.f55148d = i - i2;
        }
    }

    public final void e() {
        this.f55149e += this.f55150f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.i.f55154b;
        } else {
            InterfaceC1263c interfaceC1263c = this.f55145a;
            if (interfaceC1263c != null) {
                nextInt = interfaceC1263c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i = this.p;
            this.u = a(this.i.f55154b, (int) (i > 0 ? Math.max(i, this.i.f55154b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.i.f55154b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f55150f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f55146b;
        } else {
            this.f55150f = this.f55146b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f55147c) / 50.0d);
        } else {
            this.l = this.f55147c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i, int i2) {
        this.i = bVar;
        this.j = i;
        this.k = i2;
        Random random = new Random();
        this.t = random;
        this.f55151g = random.nextInt((i * 8) / 9);
        int nextInt = this.t.nextInt(i2) - i2;
        this.f55152h = nextInt;
        this.f55148d = this.f55151g;
        this.f55149e = nextInt;
        this.m = bVar.f55155c;
        this.n = bVar.f55156d;
        this.f55145a = bVar.k;
        this.p = bVar.i;
        this.q = bVar.j;
        this.o = bVar.f55159g;
        int unused = bVar.f55160h;
        this.r = bVar.f55157e;
        this.s = bVar.f55158f;
        this.f55146b = bVar.f55153a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.i = bVar;
        this.u = bVar.f55154b;
        this.o = bVar.f55159g;
        int unused = bVar.f55160h;
        this.p = bVar.i;
        this.f55145a = bVar.k;
        this.q = bVar.j;
        this.f55146b = bVar.f55153a;
        this.n = bVar.f55156d;
        this.r = bVar.f55157e;
        this.s = bVar.f55158f;
        this.m = bVar.f55155c;
    }
}
