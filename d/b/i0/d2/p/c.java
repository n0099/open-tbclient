package d.b.i0.d2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1240c f54724a;

    /* renamed from: b  reason: collision with root package name */
    public int f54725b;

    /* renamed from: c  reason: collision with root package name */
    public int f54726c;

    /* renamed from: d  reason: collision with root package name */
    public float f54727d;

    /* renamed from: e  reason: collision with root package name */
    public float f54728e;

    /* renamed from: f  reason: collision with root package name */
    public float f54729f;

    /* renamed from: g  reason: collision with root package name */
    public int f54730g;

    /* renamed from: h  reason: collision with root package name */
    public int f54731h;
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
        public Bitmap f54733b;

        /* renamed from: g  reason: collision with root package name */
        public int f54738g;

        /* renamed from: h  reason: collision with root package name */
        public int f54739h;
        public int i;
        public int j;
        public InterfaceC1240c k;

        /* renamed from: a  reason: collision with root package name */
        public int f54732a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f54734c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54735d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f54736e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54737f = false;

        public b(Bitmap bitmap) {
            this.f54733b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i, int i2) {
            this.i = i;
            this.j = i2;
            return this;
        }

        public b n(InterfaceC1240c interfaceC1240c) {
            this.k = interfaceC1240c;
            return this;
        }

        public b o(int i, int i2, boolean z) {
            this.f54738g = i;
            this.f54739h = i2;
            this.f54733b = c.a(this.f54733b, i, i2);
            this.f54735d = z;
            return this;
        }

        public b p(int i, boolean z) {
            this.f54732a = i;
            this.f54734c = z;
            return this;
        }

        public b q(int i, boolean z, boolean z2) {
            this.f54736e = z;
            this.f54737f = z2;
            return this;
        }
    }

    /* renamed from: d.b.i0.d2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1240c {
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
        float f2 = this.f54728e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f54727d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f54727d = (float) (this.f54727d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f54727d;
        int i = this.j;
        int i2 = this.o;
        if (f2 > i - i2) {
            this.f54727d = i - i2;
        }
    }

    public final void e() {
        this.f54728e += this.f54729f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.i.f54733b;
        } else {
            InterfaceC1240c interfaceC1240c = this.f54724a;
            if (interfaceC1240c != null) {
                nextInt = interfaceC1240c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i = this.p;
            this.u = a(this.i.f54733b, (int) (i > 0 ? Math.max(i, this.i.f54733b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.i.f54733b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f54729f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f54725b;
        } else {
            this.f54729f = this.f54725b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f54726c) / 50.0d);
        } else {
            this.l = this.f54726c / 50.0f;
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
        this.f54730g = random.nextInt((i * 8) / 9);
        int nextInt = this.t.nextInt(i2) - i2;
        this.f54731h = nextInt;
        this.f54727d = this.f54730g;
        this.f54728e = nextInt;
        this.m = bVar.f54734c;
        this.n = bVar.f54735d;
        this.f54724a = bVar.k;
        this.p = bVar.i;
        this.q = bVar.j;
        this.o = bVar.f54738g;
        int unused = bVar.f54739h;
        this.r = bVar.f54736e;
        this.s = bVar.f54737f;
        this.f54725b = bVar.f54732a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.i = bVar;
        this.u = bVar.f54733b;
        this.o = bVar.f54738g;
        int unused = bVar.f54739h;
        this.p = bVar.i;
        this.f54724a = bVar.k;
        this.q = bVar.j;
        this.f54725b = bVar.f54732a;
        this.n = bVar.f54735d;
        this.r = bVar.f54736e;
        this.s = bVar.f54737f;
        this.m = bVar.f54734c;
    }
}
