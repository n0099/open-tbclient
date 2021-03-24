package d.b.b.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.b.b.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f42383b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.j.f.a f42384c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f42385d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42386e;

    /* renamed from: f  reason: collision with root package name */
    public b f42387f;

    /* renamed from: g  reason: collision with root package name */
    public int f42388g;

    /* renamed from: h  reason: collision with root package name */
    public View f42389h;

    /* renamed from: a  reason: collision with root package name */
    public int f42382a = 1;
    public Handler i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f42387f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f42391e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f42392f;

        public b(Context context) {
            this.f42392f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.i.removeCallbacks(fVar.j);
            Scroller scroller = this.f42392f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f42392f.forceFinished(true);
            }
            View view = f.this.f42389h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f42384c != null) {
                f.this.f42384c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f42389h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i, int i2) {
            if (f.this.f42389h == null || this.f42392f == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.f42391e = 0;
            this.f42392f.startScroll(0, 0, 0, i, i2);
            f.this.f42389h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f42389h == null || (scroller = this.f42392f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f42392f.timePassed() >= f.this.f42388g) {
                computeScrollOffset = false;
            }
            int currY = this.f42392f.getCurrY();
            int i = currY - this.f42391e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !f.this.c(i);
                    this.f42391e = currY;
                }
                if (!z) {
                    f.this.f42389h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i, int i2, int i3) {
        this.f42386e = true;
        int abs = Math.abs(i - i2);
        this.f42383b = i2;
        if (abs < this.f42382a) {
            this.f42386e = false;
        }
        this.f42387f = new b(context);
        this.f42388g = i3;
    }

    public final boolean c(int i) {
        boolean z;
        int paddingTop = this.f42389h.getPaddingTop() - Math.abs(i);
        int i2 = this.f42383b;
        if (paddingTop <= i2) {
            paddingTop = i2;
            z = false;
        } else {
            z = true;
        }
        View view = this.f42389h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f42389h.getPaddingRight(), this.f42389h.getPaddingBottom());
        c.a aVar = this.f42385d;
        if (aVar != null) {
            aVar.a(null, this.f42389h.getPaddingLeft(), this.f42389h.getPaddingRight(), this.f42389h.getPaddingTop() - this.f42383b, this.f42389h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.b.b.j.f.a aVar) {
        this.f42384c = aVar;
    }

    public void e(c.a aVar) {
        this.f42385d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f42386e || (bVar = this.f42387f) == null) {
            return;
        }
        this.f42389h = view;
        bVar.d(Math.abs(this.f42383b), this.f42388g);
        this.i.postDelayed(this.j, this.f42388g);
    }
}
