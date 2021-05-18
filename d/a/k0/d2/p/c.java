package d.a.k0.d2.p;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.Random;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1274c f53685a;

    /* renamed from: b  reason: collision with root package name */
    public int f53686b;

    /* renamed from: c  reason: collision with root package name */
    public int f53687c;

    /* renamed from: d  reason: collision with root package name */
    public float f53688d;

    /* renamed from: e  reason: collision with root package name */
    public float f53689e;

    /* renamed from: f  reason: collision with root package name */
    public float f53690f;

    /* renamed from: g  reason: collision with root package name */
    public int f53691g;

    /* renamed from: h  reason: collision with root package name */
    public int f53692h;

    /* renamed from: i  reason: collision with root package name */
    public b f53693i;
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
        public Bitmap f53695b;

        /* renamed from: g  reason: collision with root package name */
        public int f53700g;

        /* renamed from: h  reason: collision with root package name */
        public int f53701h;

        /* renamed from: i  reason: collision with root package name */
        public int f53702i;
        public int j;
        public InterfaceC1274c k;

        /* renamed from: a  reason: collision with root package name */
        public int f53694a = 10;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53696c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f53697d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f53698e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f53699f = false;

        public b(Bitmap bitmap) {
            this.f53695b = bitmap;
        }

        public c l() {
            return new c(this);
        }

        public b m(int i2, int i3) {
            this.f53702i = i2;
            this.j = i3;
            return this;
        }

        public b n(InterfaceC1274c interfaceC1274c) {
            this.k = interfaceC1274c;
            return this;
        }

        public b o(int i2, int i3, boolean z) {
            this.f53700g = i2;
            this.f53701h = i3;
            this.f53695b = c.a(this.f53695b, i2, i3);
            this.f53697d = z;
            return this;
        }

        public b p(int i2, boolean z) {
            this.f53694a = i2;
            this.f53696c = z;
            return this;
        }

        public b q(int i2, boolean z, boolean z2) {
            this.f53698e = z;
            this.f53699f = z2;
            return this;
        }
    }

    /* renamed from: d.a.k0.d2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1274c {
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
        float f2 = this.f53689e;
        if (f2 > this.k) {
            return;
        }
        canvas.drawBitmap(this.u, this.f53688d, f2, paint);
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        this.f53688d = (float) (this.f53688d + (Math.sin(this.l) * 10.0d));
        if (this.s) {
            this.l = (float) (this.l + ((this.t.nextBoolean() ? -1 : 1) * Math.random() * 0.0025d));
        }
        float f2 = this.f53688d;
        int i2 = this.j;
        int i3 = this.o;
        if (f2 > i2 - i3) {
            this.f53688d = i2 - i3;
        }
    }

    public final void e() {
        this.f53689e += this.f53690f;
    }

    public final void f() {
        float nextInt;
        if (!this.n) {
            this.u = this.f53693i.f53695b;
        } else {
            InterfaceC1274c interfaceC1274c = this.f53685a;
            if (interfaceC1274c != null) {
                nextInt = interfaceC1274c.a();
            } else {
                nextInt = (this.t.nextInt(10) + 1) * 0.1f;
            }
            int i2 = this.p;
            this.u = a(this.f53693i.f53695b, (int) (i2 > 0 ? Math.max(i2, this.f53693i.f53695b.getWidth() * nextInt) : 0.0f), (int) (this.q > 0 ? Math.max(nextInt * this.f53693i.f53695b.getHeight(), this.q) : 0.0f));
        }
        this.u.getWidth();
        this.u.getHeight();
    }

    public final void g() {
        if (this.m) {
            this.f53690f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.f53686b;
        } else {
            this.f53690f = this.f53686b;
        }
    }

    public final void h() {
        if (this.r) {
            this.l = (float) ((((this.t.nextBoolean() ? -1 : 1) * Math.random()) * this.f53687c) / 50.0d);
        } else {
            this.l = this.f53687c / 50.0f;
        }
        float f2 = this.l;
        if (f2 > 1.5707964f) {
            this.l = 1.5707964f;
        } else if (f2 < -1.5707964f) {
            this.l = -1.5707964f;
        }
    }

    public c(b bVar, int i2, int i3) {
        this.f53693i = bVar;
        this.j = i2;
        this.k = i3;
        Random random = new Random();
        this.t = random;
        this.f53691g = random.nextInt((i2 * 8) / 9);
        int nextInt = this.t.nextInt(i3) - i3;
        this.f53692h = nextInt;
        this.f53688d = this.f53691g;
        this.f53689e = nextInt;
        this.m = bVar.f53696c;
        this.n = bVar.f53697d;
        this.f53685a = bVar.k;
        this.p = bVar.f53702i;
        this.q = bVar.j;
        this.o = bVar.f53700g;
        int unused = bVar.f53701h;
        this.r = bVar.f53698e;
        this.s = bVar.f53699f;
        this.f53686b = bVar.f53694a;
        g();
        f();
        h();
    }

    public c(b bVar) {
        this.f53693i = bVar;
        this.u = bVar.f53695b;
        this.o = bVar.f53700g;
        int unused = bVar.f53701h;
        this.p = bVar.f53702i;
        this.f53685a = bVar.k;
        this.q = bVar.j;
        this.f53686b = bVar.f53694a;
        this.n = bVar.f53697d;
        this.r = bVar.f53698e;
        this.s = bVar.f53699f;
        this.m = bVar.f53696c;
    }
}
