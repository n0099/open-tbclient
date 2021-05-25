package d.a.n0.e2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1293c f53898a;

    /* renamed from: b  reason: collision with root package name */
    public int f53899b;

    /* renamed from: c  reason: collision with root package name */
    public int f53900c;

    /* renamed from: d  reason: collision with root package name */
    public float f53901d;

    /* renamed from: e  reason: collision with root package name */
    public float f53902e;

    /* renamed from: f  reason: collision with root package name */
    public float f53903f;

    /* renamed from: g  reason: collision with root package name */
    public int f53904g;

    /* renamed from: h  reason: collision with root package name */
    public int f53905h;

    /* renamed from: i  reason: collision with root package name */
    public b f53906i;
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
        public Bitmap f53908b;

        /* renamed from: g  reason: collision with root package name */
        public int f53913g;

        /* renamed from: h  reason: collision with root package name */
        public int f53914h;

        /* renamed from: i  reason: collision with root package name */
        public int f53915i;
        public int j;
        public InterfaceC1293c k;

        /* renamed from: a  reason: collision with root package name */
        public int f53907a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53909c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f53910d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53911e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f53912f = false;

        public b(Bitmap bitmap) {
            this.f53908b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i2, int i3) {
            this.f53915i = i2;
            this.j = i3;
            return this;
        }

        public b n(InterfaceC1293c interfaceC1293c) {
            this.k = interfaceC1293c;
            return this;
        }

        public b o(int i2, int i3, boolean z) {
            this.f53913g = i2;
            this.f53914h = i3;
            this.f53908b = c.a(this.f53908b, i2, i3);
            this.f53910d = z;
            return this;
        }

        public b p(int i2, boolean z) {
            this.f53907a = i2;
            this.f53909c = z;
            return this;
        }

        public b q(int i2, boolean z, boolean z2) {
            this.f53911e = z;
            this.f53912f = z2;
            return this;
        }
    }

    /* renamed from: d.a.n0.e2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1293c {
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
        float f2 = this.f53902e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f53901d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f53901d = (float) (this.f53901d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f53901d;
        int i2 = this.j;
        int i3 = this.o;
        if (f2 > i2 - i3) {
            this.f53901d = i2 - i3;
        }
    }

    public final void e() {
        this.f53902e += this.f53903f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.f53906i.f53908b;
        } else {
            InterfaceC1293c interfaceC1293c = this.f53898a;
            if (interfaceC1293c != null) {
                nextInt = interfaceC1293c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i2 = this.p;
            this.u = a(this.f53906i.f53908b, (int) (i2 > 0 ? Math.max(i2, this.f53906i.f53908b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f53906i.f53908b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f53903f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f53899b;
        } else {
            this.f53903f = this.f53899b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f53900c) / 50.0d);
        } else {
            this.l = this.f53900c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i2, int i3) {
        this.f53906i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f53904g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f53905h = nextInt;
        this.f53901d = this.f53904g;
        this.f53902e = nextInt;
        this.m = bVar.f53909c;
        this.n = bVar.f53910d;
        this.f53898a = bVar.k;
        this.p = bVar.f53915i;
        this.q = bVar.j;
        this.o = bVar.f53913g;
        int unused = bVar.f53914h;
        this.r = bVar.f53911e;
        this.s = bVar.f53912f;
        this.f53899b = bVar.f53907a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.f53906i = bVar;
        this.u = bVar.f53908b;
        this.o = bVar.f53913g;
        int unused = bVar.f53914h;
        this.p = bVar.f53915i;
        this.f53898a = bVar.k;
        this.q = bVar.j;
        this.f53899b = bVar.f53907a;
        this.n = bVar.f53910d;
        this.r = bVar.f53911e;
        this.s = bVar.f53912f;
        this.m = bVar.f53909c;
    }
}
