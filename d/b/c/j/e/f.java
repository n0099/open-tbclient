package d.b.c.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.b.c.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f43121b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.j.f.a f43122c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f43123d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43124e;

    /* renamed from: f  reason: collision with root package name */
    public b f43125f;

    /* renamed from: g  reason: collision with root package name */
    public int f43126g;

    /* renamed from: h  reason: collision with root package name */
    public View f43127h;

    /* renamed from: a  reason: collision with root package name */
    public int f43120a = 1;
    public Handler i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f43125f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f43129e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f43130f;

        public b(Context context) {
            this.f43130f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.i.removeCallbacks(fVar.j);
            Scroller scroller = this.f43130f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f43130f.forceFinished(true);
            }
            View view = f.this.f43127h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f43122c != null) {
                f.this.f43122c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f43127h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i, int i2) {
            if (f.this.f43127h == null || this.f43130f == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.f43129e = 0;
            this.f43130f.startScroll(0, 0, 0, i, i2);
            f.this.f43127h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f43127h == null || (scroller = this.f43130f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f43130f.timePassed() >= f.this.f43126g) {
                computeScrollOffset = false;
            }
            int currY = this.f43130f.getCurrY();
            int i = currY - this.f43129e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !f.this.c(i);
                    this.f43129e = currY;
                }
                if (!z) {
                    f.this.f43127h.post(this);
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
        this.f43124e = true;
        int abs = Math.abs(i - i2);
        this.f43121b = i2;
        if (abs < this.f43120a) {
            this.f43124e = false;
        }
        this.f43125f = new b(context);
        this.f43126g = i3;
    }

    public final boolean c(int i) {
        boolean z;
        int paddingTop = this.f43127h.getPaddingTop() - Math.abs(i);
        int i2 = this.f43121b;
        if (paddingTop <= i2) {
            paddingTop = i2;
            z = false;
        } else {
            z = true;
        }
        View view = this.f43127h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f43127h.getPaddingRight(), this.f43127h.getPaddingBottom());
        c.a aVar = this.f43123d;
        if (aVar != null) {
            aVar.a(null, this.f43127h.getPaddingLeft(), this.f43127h.getPaddingRight(), this.f43127h.getPaddingTop() - this.f43121b, this.f43127h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.b.c.j.f.a aVar) {
        this.f43122c = aVar;
    }

    public void e(c.a aVar) {
        this.f43123d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f43124e || (bVar = this.f43125f) == null) {
            return;
        }
        this.f43127h = view;
        bVar.d(Math.abs(this.f43121b), this.f43126g);
        this.i.postDelayed(this.j, this.f43126g);
    }
}
