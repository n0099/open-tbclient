package d.a.c.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.a.c.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f40348b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.j.f.a f40349c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f40350d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40351e;

    /* renamed from: f  reason: collision with root package name */
    public b f40352f;

    /* renamed from: g  reason: collision with root package name */
    public int f40353g;

    /* renamed from: h  reason: collision with root package name */
    public View f40354h;

    /* renamed from: a  reason: collision with root package name */
    public int f40347a = 1;

    /* renamed from: i  reason: collision with root package name */
    public Handler f40355i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f40352f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f40357e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f40358f;

        public b(Context context) {
            this.f40358f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.f40355i.removeCallbacks(fVar.j);
            Scroller scroller = this.f40358f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f40358f.forceFinished(true);
            }
            View view = f.this.f40354h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f40349c != null) {
                f.this.f40349c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.f40355i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f40354h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i2, int i3) {
            if (f.this.f40354h == null || this.f40358f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f40357e = 0;
            this.f40358f.startScroll(0, 0, 0, i2, i3);
            f.this.f40354h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f40354h == null || (scroller = this.f40358f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f40358f.timePassed() >= f.this.f40353g) {
                computeScrollOffset = false;
            }
            int currY = this.f40358f.getCurrY();
            int i2 = currY - this.f40357e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !f.this.c(i2);
                    this.f40357e = currY;
                }
                if (!z) {
                    f.this.f40354h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.f40355i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.f40355i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        this.f40351e = true;
        int abs = Math.abs(i2 - i3);
        this.f40348b = i3;
        if (abs < this.f40347a) {
            this.f40351e = false;
        }
        this.f40352f = new b(context);
        this.f40353g = i4;
    }

    public final boolean c(int i2) {
        boolean z;
        int paddingTop = this.f40354h.getPaddingTop() - Math.abs(i2);
        int i3 = this.f40348b;
        if (paddingTop <= i3) {
            paddingTop = i3;
            z = false;
        } else {
            z = true;
        }
        View view = this.f40354h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f40354h.getPaddingRight(), this.f40354h.getPaddingBottom());
        c.a aVar = this.f40350d;
        if (aVar != null) {
            aVar.a(null, this.f40354h.getPaddingLeft(), this.f40354h.getPaddingRight(), this.f40354h.getPaddingTop() - this.f40348b, this.f40354h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.a.c.j.f.a aVar) {
        this.f40349c = aVar;
    }

    public void e(c.a aVar) {
        this.f40350d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f40351e || (bVar = this.f40352f) == null) {
            return;
        }
        this.f40354h = view;
        bVar.d(Math.abs(this.f40348b), this.f40353g);
        this.f40355i.postDelayed(this.j, this.f40353g);
    }
}
