package d.a.c.k.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import d.a.c.k.e.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public int f43041b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.k.f.a f43042c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f43043d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43044e;

    /* renamed from: f  reason: collision with root package name */
    public b f43045f;

    /* renamed from: g  reason: collision with root package name */
    public int f43046g;

    /* renamed from: h  reason: collision with root package name */
    public View f43047h;

    /* renamed from: a  reason: collision with root package name */
    public int f43040a = 1;

    /* renamed from: i  reason: collision with root package name */
    public Handler f43048i = new Handler();
    public Runnable j = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = f.this.f43045f;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f43050e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f43051f;

        public b(Context context) {
            this.f43051f = new Scroller(context);
        }

        public final void b() {
            f fVar = f.this;
            fVar.f43048i.removeCallbacks(fVar.j);
            Scroller scroller = this.f43051f;
            if (scroller != null) {
                scroller.abortAnimation();
                this.f43051f.forceFinished(true);
            }
            View view = f.this.f43047h;
            if (view != null) {
                view.removeCallbacks(this);
            }
            if (f.this.f43042c != null) {
                f.this.f43042c.onOver();
            }
        }

        public final void c() {
            f fVar = f.this;
            Handler handler = fVar.f43048i;
            if (handler != null) {
                handler.removeCallbacks(fVar.j);
            }
            View view = f.this.f43047h;
            if (view != null) {
                view.removeCallbacks(this);
            }
        }

        public void d(int i2, int i3) {
            if (f.this.f43047h == null || this.f43051f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f43050e = 0;
            this.f43051f.startScroll(0, 0, 0, i2, i3);
            f.this.f43047h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            if (f.this.f43047h == null || (scroller = this.f43051f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f43051f.timePassed() >= f.this.f43046g) {
                computeScrollOffset = false;
            }
            int currY = this.f43051f.getCurrY();
            int i2 = currY - this.f43050e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !f.this.c(i2);
                    this.f43050e = currY;
                }
                if (!z) {
                    f.this.f43047h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = f.this;
                fVar.f43048i.removeCallbacks(fVar.j);
                f fVar2 = f.this;
                fVar2.f43048i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        this.f43044e = true;
        int abs = Math.abs(i2 - i3);
        this.f43041b = i3;
        if (abs < this.f43040a) {
            this.f43044e = false;
        }
        this.f43045f = new b(context);
        this.f43046g = i4;
    }

    public final boolean c(int i2) {
        boolean z;
        int paddingTop = this.f43047h.getPaddingTop() - Math.abs(i2);
        int i3 = this.f43041b;
        if (paddingTop <= i3) {
            paddingTop = i3;
            z = false;
        } else {
            z = true;
        }
        View view = this.f43047h;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.f43047h.getPaddingRight(), this.f43047h.getPaddingBottom());
        c.a aVar = this.f43043d;
        if (aVar != null) {
            aVar.a(null, this.f43047h.getPaddingLeft(), this.f43047h.getPaddingRight(), this.f43047h.getPaddingTop() - this.f43041b, this.f43047h.getPaddingBottom());
        }
        return z;
    }

    public void d(d.a.c.k.f.a aVar) {
        this.f43042c = aVar;
    }

    public void e(c.a aVar) {
        this.f43043d = aVar;
    }

    public void f(View view) {
        b bVar;
        if (!this.f43044e || (bVar = this.f43045f) == null) {
            return;
        }
        this.f43047h = view;
        bVar.d(Math.abs(this.f43041b), this.f43046g);
        this.f43048i.postDelayed(this.j, this.f43046g);
    }
}
