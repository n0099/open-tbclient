package d.a.c.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.a.c.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f39593b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.j.f.a f39594c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f39595d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39596e;

    /* renamed from: f  reason: collision with root package name */
    public b f39597f;

    /* renamed from: g  reason: collision with root package name */
    public int f39598g;

    /* renamed from: h  reason: collision with root package name */
    public View f39599h;

    /* renamed from: a  reason: collision with root package name */
    public int f39592a = 1;

    /* renamed from: i  reason: collision with root package name */
    public Handler f39600i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f39597f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f39602e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f39603f;

        public b(Context context) {
            this.f39603f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.f39600i.removeCallbacks(fVar.j);
            Scroller scroller = this.f39603f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f39603f.forceFinished(true);
            }
            View view = f.this.f39599h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f39594c != null) {
                f.this.f39594c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.f39600i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f39599h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i2, int i3) {
            if (f.this.f39599h == null || this.f39603f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f39602e = 0;
            this.f39603f.startScroll(0, 0, 0, i2, i3);
            f.this.f39599h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f39599h == null || (scroller = this.f39603f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f39603f.timePassed() >= f.this.f39598g) {
                computeScrollOffset = false;
            }
            int currY = this.f39603f.getCurrY();
            int i2 = currY - this.f39602e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !f.this.c(i2);
                    this.f39602e = currY;
                }
                if (!z) {
                    f.this.f39599h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.f39600i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.f39600i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        this.f39596e = true;
        int abs = Math.abs(i2 - i3);
        this.f39593b = i3;
        if (abs < this.f39592a) {
            this.f39596e = false;
        }
        this.f39597f = new b(context);
        this.f39598g = i4;
    }

    public final boolean c(int i2) {
        boolean z;
        int paddingTop = this.f39599h.getPaddingTop() - Math.abs(i2);
        int i3 = this.f39593b;
        if (paddingTop <= i3) {
            paddingTop = i3;
            z = false;
        } else {
            z = true;
        }
        View view = this.f39599h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f39599h.getPaddingRight(), this.f39599h.getPaddingBottom());
        c.a aVar = this.f39595d;
        if (aVar != null) {
            aVar.a(null, this.f39599h.getPaddingLeft(), this.f39599h.getPaddingRight(), this.f39599h.getPaddingTop() - this.f39593b, this.f39599h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.a.c.j.f.a aVar) {
        this.f39594c = aVar;
    }

    public void e(c.a aVar) {
        this.f39595d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f39596e || (bVar = this.f39597f) == null) {
            return;
        }
        this.f39599h = view;
        bVar.d(Math.abs(this.f39593b), this.f39598g);
        this.f39600i.postDelayed(this.j, this.f39598g);
    }
}
