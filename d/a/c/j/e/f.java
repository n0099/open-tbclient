package d.a.c.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.a.c.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f39257b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.j.f.a f39258c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f39259d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39260e;

    /* renamed from: f  reason: collision with root package name */
    public b f39261f;

    /* renamed from: g  reason: collision with root package name */
    public int f39262g;

    /* renamed from: h  reason: collision with root package name */
    public View f39263h;

    /* renamed from: a  reason: collision with root package name */
    public int f39256a = 1;

    /* renamed from: i  reason: collision with root package name */
    public Handler f39264i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f39261f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f39266e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f39267f;

        public b(Context context) {
            this.f39267f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.f39264i.removeCallbacks(fVar.j);
            Scroller scroller = this.f39267f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f39267f.forceFinished(true);
            }
            View view = f.this.f39263h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f39258c != null) {
                f.this.f39258c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.f39264i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f39263h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i2, int i3) {
            if (f.this.f39263h == null || this.f39267f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f39266e = 0;
            this.f39267f.startScroll(0, 0, 0, i2, i3);
            f.this.f39263h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f39263h == null || (scroller = this.f39267f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f39267f.timePassed() >= f.this.f39262g) {
                computeScrollOffset = false;
            }
            int currY = this.f39267f.getCurrY();
            int i2 = currY - this.f39266e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !f.this.c(i2);
                    this.f39266e = currY;
                }
                if (!z) {
                    f.this.f39263h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.f39264i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.f39264i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        this.f39260e = true;
        int abs = Math.abs(i2 - i3);
        this.f39257b = i3;
        if (abs < this.f39256a) {
            this.f39260e = false;
        }
        this.f39261f = new b(context);
        this.f39262g = i4;
    }

    public final boolean c(int i2) {
        boolean z;
        int paddingTop = this.f39263h.getPaddingTop() - Math.abs(i2);
        int i3 = this.f39257b;
        if (paddingTop <= i3) {
            paddingTop = i3;
            z = false;
        } else {
            z = true;
        }
        View view = this.f39263h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f39263h.getPaddingRight(), this.f39263h.getPaddingBottom());
        c.a aVar = this.f39259d;
        if (aVar != null) {
            aVar.a(null, this.f39263h.getPaddingLeft(), this.f39263h.getPaddingRight(), this.f39263h.getPaddingTop() - this.f39257b, this.f39263h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.a.c.j.f.a aVar) {
        this.f39258c = aVar;
    }

    public void e(c.a aVar) {
        this.f39259d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f39260e || (bVar = this.f39261f) == null) {
            return;
        }
        this.f39263h = view;
        bVar.d(Math.abs(this.f39257b), this.f39262g);
        this.f39264i.postDelayed(this.j, this.f39262g);
    }
}
