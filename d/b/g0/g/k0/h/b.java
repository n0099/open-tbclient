package d.b.g0.g.k0.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.i2.h0;
import d.b.g0.a.z0.f;
import d.b.g0.g.i0.e;
import d.b.g0.g.k0.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f48666g = e.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f48667h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f48668a;

    /* renamed from: b  reason: collision with root package name */
    public int f48669b;

    /* renamed from: c  reason: collision with root package name */
    public int f48670c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48671d;

    /* renamed from: e  reason: collision with root package name */
    public int f48672e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f48673f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.k0.h.a f48675f;

        public a(View view, d.b.g0.g.k0.h.a aVar) {
            this.f48674e = view;
            this.f48675f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f48674e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int l = h0.l(AppRuntime.getAppContext());
            int s = h0.s();
            if (!b.this.f48671d) {
                b.this.f48671d = true;
                b.this.f48670c = (l - i) - s;
                if (b.this.f48670c < 0) {
                    b.this.f48670c = 0;
                }
            }
            if (i > 0) {
                if (i >= b.this.f48672e || this.f48674e.getHeight() - i <= 200) {
                    if (i <= b.this.f48672e || this.f48674e.getHeight() - i >= 200) {
                        return;
                    }
                    b.this.f48672e = i;
                    b.this.s(this.f48675f);
                    return;
                }
                b.this.f48672e = i;
                b.this.f48669b = i - b.f48666g;
                b bVar = b.this;
                bVar.f48668a = ((l - i) - s) - bVar.f48670c;
                if (b.this.f48668a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f48675f, bVar2.f48668a, b.this.f48669b)) {
                        return;
                    }
                    b.this.s(this.f48675f);
                }
            }
        }
    }

    public static b p() {
        if (f48667h == null) {
            synchronized (b.class) {
                if (f48667h == null) {
                    f48667h = new b();
                }
            }
        }
        return f48667h;
    }

    public final void m(View view, d.b.g0.g.k0.h.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f48672e = view.getHeight();
        this.f48673f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f48673f);
    }

    public boolean n(d.b.g0.g.k0.h.a aVar) {
        d Y = f.V().Y();
        boolean z = (Y == null || r(aVar.f()) || !Y.f(aVar.f(), o())) ? false : true;
        if (z) {
            if (!aVar.l() || Y == null) {
                return false;
            }
            m(Y.e(), aVar);
        }
        return z;
    }

    public final d.b.g0.a.e1.d.a.a o() {
        d.b.g0.a.e1.d.a.a aVar = new d.b.g0.a.e1.d.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.b.g0.a.e1.d.a.a q(int i) {
        d.b.g0.a.e1.d.a.a aVar = new d.b.g0.a.e1.d.a.a();
        aVar.l(true);
        aVar.n(i);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final boolean r(View view) {
        d Y = f.V().Y();
        return Y != null && Y.g(view);
    }

    public boolean s(d.b.g0.g.k0.h.a aVar) {
        d Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout e2 = Y.e();
        if (e2 != null && this.f48673f != null) {
            e2.getViewTreeObserver().removeOnGlobalLayoutListener(this.f48673f);
        }
        aVar.h();
        this.f48673f = null;
        this.f48668a = -1;
        this.f48669b = -1;
        this.f48670c = -1;
        this.f48671d = false;
        this.f48672e = -1;
        return Y.m(aVar.f());
    }

    public final boolean t(d.b.g0.g.k0.h.a aVar, int i, int i2) {
        d Y = f.V().Y();
        boolean z = Y != null && Y.q(aVar.f(), q(i2));
        if (z) {
            aVar.k(i);
        }
        return z;
    }
}
