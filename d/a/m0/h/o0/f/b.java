package d.a.m0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.g1.f;
import d.a.m0.a.p.b.a.n;
import d.a.m0.a.v2.n0;
import d.a.m0.h.m0.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f51359g = g.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f51360h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f51361a;

    /* renamed from: b  reason: collision with root package name */
    public int f51362b;

    /* renamed from: c  reason: collision with root package name */
    public int f51363c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51364d;

    /* renamed from: e  reason: collision with root package name */
    public int f51365e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f51366f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f51367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.h.o0.f.a f51368f;

        public a(View view, d.a.m0.h.o0.f.a aVar) {
            this.f51367e = view;
            this.f51368f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f51367e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            int n = n0.n(AppRuntime.getAppContext());
            int u = n0.u();
            if (!b.this.f51364d) {
                b.this.f51364d = true;
                b.this.f51363c = (n - i2) - u;
                if (b.this.f51363c < 0) {
                    b.this.f51363c = 0;
                }
            }
            if (i2 > 0) {
                if (i2 >= b.this.f51365e || this.f51367e.getHeight() - i2 <= 200) {
                    if (i2 <= b.this.f51365e || this.f51367e.getHeight() - i2 >= 200) {
                        return;
                    }
                    b.this.f51365e = i2;
                    b.this.s(this.f51368f);
                    return;
                }
                b.this.f51365e = i2;
                b.this.f51362b = i2 - b.f51359g;
                b bVar = b.this;
                bVar.f51361a = ((n - i2) - u) - bVar.f51363c;
                if (b.this.f51361a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f51368f, bVar2.f51361a, b.this.f51362b)) {
                        return;
                    }
                    b.this.s(this.f51368f);
                }
            }
        }
    }

    public static b p() {
        if (f51360h == null) {
            synchronized (b.class) {
                if (f51360h == null) {
                    f51360h = new b();
                }
            }
        }
        return f51360h;
    }

    public final void m(View view, d.a.m0.h.o0.f.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f51365e = view.getHeight();
        this.f51366f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f51366f);
    }

    public boolean n(d.a.m0.h.o0.f.a aVar) {
        n Y = f.V().Y();
        boolean z = (Y == null || r(aVar.f()) || !Y.c(aVar.f(), o())) ? false : true;
        if (z) {
            if (!aVar.l() || Y == null) {
                return false;
            }
            m(Y.getRootView(), aVar);
        }
        return z;
    }

    public final d.a.m0.a.l1.e.a.a o() {
        d.a.m0.a.l1.e.a.a aVar = new d.a.m0.a.l1.e.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.a.m0.a.l1.e.a.a q(int i2) {
        d.a.m0.a.l1.e.a.a aVar = new d.a.m0.a.l1.e.a.a();
        aVar.l(true);
        aVar.n(i2);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final boolean r(View view) {
        n Y = f.V().Y();
        return Y != null && Y.d(view);
    }

    public boolean s(d.a.m0.h.o0.f.a aVar) {
        n Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout rootView = Y.getRootView();
        if (rootView != null && this.f51366f != null) {
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f51366f);
        }
        aVar.h();
        this.f51366f = null;
        this.f51361a = -1;
        this.f51362b = -1;
        this.f51363c = -1;
        this.f51364d = false;
        this.f51365e = -1;
        return Y.removeView(aVar.f());
    }

    public final boolean t(d.a.m0.h.o0.f.a aVar, int i2, int i3) {
        n Y = f.V().Y();
        boolean z = Y != null && Y.a(aVar.f(), q(i3));
        if (z) {
            aVar.k(i2);
        }
        return z;
    }
}
