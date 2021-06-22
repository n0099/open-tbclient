package d.a.o0.e2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1353c f57712a;

    /* renamed from: b  reason: collision with root package name */
    public int f57713b;

    /* renamed from: c  reason: collision with root package name */
    public int f57714c;

    /* renamed from: d  reason: collision with root package name */
    public float f57715d;

    /* renamed from: e  reason: collision with root package name */
    public float f57716e;

    /* renamed from: f  reason: collision with root package name */
    public float f57717f;

    /* renamed from: g  reason: collision with root package name */
    public int f57718g;

    /* renamed from: h  reason: collision with root package name */
    public int f57719h;

    /* renamed from: i  reason: collision with root package name */
    public b f57720i;
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

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f57722b;

        /* renamed from: g  reason: collision with root package name */
        public int f57727g;

        /* renamed from: h  reason: collision with root package name */
        public int f57728h;

        /* renamed from: i  reason: collision with root package name */
        public int f57729i;
        public int j;
        public InterfaceC1353c k;

        /* renamed from: a  reason: collision with root package name */
        public int f57721a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57723c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57724d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57725e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57726f = false;

        public b(Bitmap bitmap) {
            this.f57722b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i2, int i3) {
            this.f57729i = i2;
            this.j = i3;
            return this;
        }

        public b n(InterfaceC1353c interfaceC1353c) {
            this.k = interfaceC1353c;
            return this;
        }

        public b o(int i2, int i3, boolean z) {
            this.f57727g = i2;
            this.f57728h = i3;
            this.f57722b = c.a(this.f57722b, i2, i3);
            this.f57724d = z;
            return this;
        }

        public b p(int i2, boolean z) {
            this.f57721a = i2;
            this.f57723c = z;
            return this;
        }

        public b q(int i2, boolean z, boolean z2) {
            this.f57725e = z;
            this.f57726f = z2;
            return this;
        }
    }

    /* renamed from: d.a.o0.e2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1353c {
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
        float f2 = this.f57716e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f57715d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f57715d = (float) (this.f57715d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f57715d;
        int i2 = this.j;
        int i3 = this.o;
        if (f2 > i2 - i3) {
            this.f57715d = i2 - i3;
        }
    }

    public final void e() {
        this.f57716e += this.f57717f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.f57720i.f57722b;
        } else {
            InterfaceC1353c interfaceC1353c = this.f57712a;
            if (interfaceC1353c != null) {
                nextInt = interfaceC1353c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i2 = this.p;
            this.u = a(this.f57720i.f57722b, (int) (i2 > 0 ? Math.max(i2, this.f57720i.f57722b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f57720i.f57722b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f57717f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f57713b;
        } else {
            this.f57717f = this.f57713b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f57714c) / 50.0d);
        } else {
            this.l = this.f57714c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i2, int i3) {
        this.f57720i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f57718g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f57719h = nextInt;
        this.f57715d = this.f57718g;
        this.f57716e = nextInt;
        this.m = bVar.f57723c;
        this.n = bVar.f57724d;
        this.f57712a = bVar.k;
        this.p = bVar.f57729i;
        this.q = bVar.j;
        this.o = bVar.f57727g;
        int unused = bVar.f57728h;
        this.r = bVar.f57725e;
        this.s = bVar.f57726f;
        this.f57713b = bVar.f57721a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.f57720i = bVar;
        this.u = bVar.f57722b;
        this.o = bVar.f57727g;
        int unused = bVar.f57728h;
        this.p = bVar.f57729i;
        this.f57712a = bVar.k;
        this.q = bVar.j;
        this.f57713b = bVar.f57721a;
        this.n = bVar.f57724d;
        this.r = bVar.f57725e;
        this.s = bVar.f57726f;
        this.m = bVar.f57723c;
    }
}
