package d.a.c.k.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.a.c.k.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f42938b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.k.f.a f42939c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f42940d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42941e;

    /* renamed from: f  reason: collision with root package name */
    public b f42942f;

    /* renamed from: g  reason: collision with root package name */
    public int f42943g;

    /* renamed from: h  reason: collision with root package name */
    public View f42944h;

    /* renamed from: a  reason: collision with root package name */
    public int f42937a = 1;

    /* renamed from: i  reason: collision with root package name */
    public Handler f42945i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f42942f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f42947e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f42948f;

        public b(Context context) {
            this.f42948f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.f42945i.removeCallbacks(fVar.j);
            Scroller scroller = this.f42948f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f42948f.forceFinished(true);
            }
            View view = f.this.f42944h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f42939c != null) {
                f.this.f42939c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.f42945i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f42944h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i2, int i3) {
            if (f.this.f42944h == null || this.f42948f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f42947e = 0;
            this.f42948f.startScroll(0, 0, 0, i2, i3);
            f.this.f42944h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f42944h == null || (scroller = this.f42948f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f42948f.timePassed() >= f.this.f42943g) {
                computeScrollOffset = false;
            }
            int currY = this.f42948f.getCurrY();
            int i2 = currY - this.f42947e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !f.this.c(i2);
                    this.f42947e = currY;
                }
                if (!z) {
                    f.this.f42944h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.f42945i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.f42945i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        this.f42941e = true;
        int abs = Math.abs(i2 - i3);
        this.f42938b = i3;
        if (abs < this.f42937a) {
            this.f42941e = false;
        }
        this.f42942f = new b(context);
        this.f42943g = i4;
    }

    public final boolean c(int i2) {
        boolean z;
        int paddingTop = this.f42944h.getPaddingTop() - Math.abs(i2);
        int i3 = this.f42938b;
        if (paddingTop <= i3) {
            paddingTop = i3;
            z = false;
        } else {
            z = true;
        }
        View view = this.f42944h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f42944h.getPaddingRight(), this.f42944h.getPaddingBottom());
        c.a aVar = this.f42940d;
        if (aVar != null) {
            aVar.a(null, this.f42944h.getPaddingLeft(), this.f42944h.getPaddingRight(), this.f42944h.getPaddingTop() - this.f42938b, this.f42944h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.a.c.k.f.a aVar) {
        this.f42939c = aVar;
    }

    public void e(c.a aVar) {
        this.f42940d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f42941e || (bVar = this.f42942f) == null) {
            return;
        }
        this.f42944h = view;
        bVar.d(Math.abs(this.f42938b), this.f42943g);
        this.f42945i.postDelayed(this.j, this.f42943g);
    }
}
