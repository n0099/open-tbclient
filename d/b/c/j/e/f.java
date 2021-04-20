package d.b.c.j.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.b.c.j.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f42881b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.j.f.a f42882c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f42883d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42884e;

    /* renamed from: f  reason: collision with root package name */
    public b f42885f;

    /* renamed from: g  reason: collision with root package name */
    public int f42886g;

    /* renamed from: h  reason: collision with root package name */
    public View f42887h;

    /* renamed from: a  reason: collision with root package name */
    public int f42880a = 1;
    public Handler i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f42885f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f42889e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f42890f;

        public b(Context context) {
            this.f42890f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.i.removeCallbacks(fVar.j);
            Scroller scroller = this.f42890f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f42890f.forceFinished(true);
            }
            View view = f.this.f42887h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f42882c != null) {
                f.this.f42882c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f42887h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i, int i2) {
            if (f.this.f42887h == null || this.f42890f == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.f42889e = 0;
            this.f42890f.startScroll(0, 0, 0, i, i2);
            f.this.f42887h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f42887h == null || (scroller = this.f42890f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f42890f.timePassed() >= f.this.f42886g) {
                computeScrollOffset = false;
            }
            int currY = this.f42890f.getCurrY();
            int i = currY - this.f42889e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !f.this.c(i);
                    this.f42889e = currY;
                }
                if (!z) {
                    f.this.f42887h.post(this);
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
        this.f42884e = true;
        int abs = Math.abs(i - i2);
        this.f42881b = i2;
        if (abs < this.f42880a) {
            this.f42884e = false;
        }
        this.f42885f = new b(context);
        this.f42886g = i3;
    }

    public final boolean c(int i) {
        boolean z;
        int paddingTop = this.f42887h.getPaddingTop() - Math.abs(i);
        int i2 = this.f42881b;
        if (paddingTop <= i2) {
            paddingTop = i2;
            z = false;
        } else {
            z = true;
        }
        View view = this.f42887h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f42887h.getPaddingRight(), this.f42887h.getPaddingBottom());
        c.a aVar = this.f42883d;
        if (aVar != null) {
            aVar.a(null, this.f42887h.getPaddingLeft(), this.f42887h.getPaddingRight(), this.f42887h.getPaddingTop() - this.f42881b, this.f42887h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.b.c.j.f.a aVar) {
        this.f42882c = aVar;
    }

    public void e(c.a aVar) {
        this.f42883d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f42884e || (bVar = this.f42885f) == null) {
            return;
        }
        this.f42887h = view;
        bVar.d(Math.abs(this.f42881b), this.f42886g);
        this.i.postDelayed(this.j, this.f42886g);
    }
}
