package d.a.n0.e2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1349c f57587a;

    /* renamed from: b  reason: collision with root package name */
    public int f57588b;

    /* renamed from: c  reason: collision with root package name */
    public int f57589c;

    /* renamed from: d  reason: collision with root package name */
    public float f57590d;

    /* renamed from: e  reason: collision with root package name */
    public float f57591e;

    /* renamed from: f  reason: collision with root package name */
    public float f57592f;

    /* renamed from: g  reason: collision with root package name */
    public int f57593g;

    /* renamed from: h  reason: collision with root package name */
    public int f57594h;

    /* renamed from: i  reason: collision with root package name */
    public b f57595i;
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
        public Bitmap f57597b;

        /* renamed from: g  reason: collision with root package name */
        public int f57602g;

        /* renamed from: h  reason: collision with root package name */
        public int f57603h;

        /* renamed from: i  reason: collision with root package name */
        public int f57604i;
        public int j;
        public InterfaceC1349c k;

        /* renamed from: a  reason: collision with root package name */
        public int f57596a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f57598c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57599d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57600e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f57601f = false;

        public b(Bitmap bitmap) {
            this.f57597b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i2, int i3) {
            this.f57604i = i2;
            this.j = i3;
            return this;
        }

        public b n(InterfaceC1349c interfaceC1349c) {
            this.k = interfaceC1349c;
            return this;
        }

        public b o(int i2, int i3, boolean z) {
            this.f57602g = i2;
            this.f57603h = i3;
            this.f57597b = c.a(this.f57597b, i2, i3);
            this.f57599d = z;
            return this;
        }

        public b p(int i2, boolean z) {
            this.f57596a = i2;
            this.f57598c = z;
            return this;
        }

        public b q(int i2, boolean z, boolean z2) {
            this.f57600e = z;
            this.f57601f = z2;
            return this;
        }
    }

    /* renamed from: d.a.n0.e2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1349c {
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
        float f2 = this.f57591e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f57590d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f57590d = (float) (this.f57590d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f57590d;
        int i2 = this.j;
        int i3 = this.o;
        if (f2 > i2 - i3) {
            this.f57590d = i2 - i3;
        }
    }

    public final void e() {
        this.f57591e += this.f57592f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.f57595i.f57597b;
        } else {
            InterfaceC1349c interfaceC1349c = this.f57587a;
            if (interfaceC1349c != null) {
                nextInt = interfaceC1349c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i2 = this.p;
            this.u = a(this.f57595i.f57597b, (int) (i2 > 0 ? Math.max(i2, this.f57595i.f57597b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f57595i.f57597b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f57592f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f57588b;
        } else {
            this.f57592f = this.f57588b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f57589c) / 50.0d);
        } else {
            this.l = this.f57589c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i2, int i3) {
        this.f57595i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f57593g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f57594h = nextInt;
        this.f57590d = this.f57593g;
        this.f57591e = nextInt;
        this.m = bVar.f57598c;
        this.n = bVar.f57599d;
        this.f57587a = bVar.k;
        this.p = bVar.f57604i;
        this.q = bVar.j;
        this.o = bVar.f57602g;
        int unused = bVar.f57603h;
        this.r = bVar.f57600e;
        this.s = bVar.f57601f;
        this.f57588b = bVar.f57596a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.f57595i = bVar;
        this.u = bVar.f57597b;
        this.o = bVar.f57602g;
        int unused = bVar.f57603h;
        this.p = bVar.f57604i;
        this.f57587a = bVar.k;
        this.q = bVar.j;
        this.f57588b = bVar.f57596a;
        this.n = bVar.f57599d;
        this.r = bVar.f57600e;
        this.s = bVar.f57601f;
        this.m = bVar.f57598c;
    }
}
