package d.b.b.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.b.b.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f42384b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.j.f.a f42385c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f42386d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42387e;

    /* renamed from: f  reason: collision with root package name */
    public b f42388f;

    /* renamed from: g  reason: collision with root package name */
    public int f42389g;

    /* renamed from: h  reason: collision with root package name */
    public View f42390h;

    /* renamed from: a  reason: collision with root package name */
    public int f42383a = 1;
    public Handler i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f42388f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f42392e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f42393f;

        public b(Context context) {
            this.f42393f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.i.removeCallbacks(fVar.j);
            Scroller scroller = this.f42393f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f42393f.forceFinished(true);
            }
            View view = f.this.f42390h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f42385c != null) {
                f.this.f42385c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f42390h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i, int i2) {
            if (f.this.f42390h == null || this.f42393f == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.f42392e = 0;
            this.f42393f.startScroll(0, 0, 0, i, i2);
            f.this.f42390h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f42390h == null || (scroller = this.f42393f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f42393f.timePassed() >= f.this.f42389g) {
                computeScrollOffset = false;
            }
            int currY = this.f42393f.getCurrY();
            int i = currY - this.f42392e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !f.this.c(i);
                    this.f42392e = currY;
                }
                if (!z) {
                    f.this.f42390h.post(this);
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
        this.f42387e = true;
        int abs = Math.abs(i - i2);
        this.f42384b = i2;
        if (abs < this.f42383a) {
            this.f42387e = false;
        }
        this.f42388f = new b(context);
        this.f42389g = i3;
    }

    public final boolean c(int i) {
        boolean z;
        int paddingTop = this.f42390h.getPaddingTop() - Math.abs(i);
        int i2 = this.f42384b;
        if (paddingTop <= i2) {
            paddingTop = i2;
            z = false;
        } else {
            z = true;
        }
        View view = this.f42390h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f42390h.getPaddingRight(), this.f42390h.getPaddingBottom());
        c.a aVar = this.f42386d;
        if (aVar != null) {
            aVar.a(null, this.f42390h.getPaddingLeft(), this.f42390h.getPaddingRight(), this.f42390h.getPaddingTop() - this.f42384b, this.f42390h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.b.b.j.f.a aVar) {
        this.f42385c = aVar;
    }

    public void e(c.a aVar) {
        this.f42386d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f42387e || (bVar = this.f42388f) == null) {
            return;
        }
        this.f42390h = view;
        bVar.d(Math.abs(this.f42384b), this.f42389g);
        this.i.postDelayed(this.j, this.f42389g);
    }
}
