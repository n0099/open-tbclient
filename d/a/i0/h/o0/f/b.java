package d.a.i0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.g1.f;
import d.a.i0.a.p.b.a.n;
import d.a.i0.a.v2.n0;
import d.a.i0.h.m0.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f47401g = g.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f47402h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f47403a;

    /* renamed from: b  reason: collision with root package name */
    public int f47404b;

    /* renamed from: c  reason: collision with root package name */
    public int f47405c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47406d;

    /* renamed from: e  reason: collision with root package name */
    public int f47407e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47408f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.o0.f.a f47410f;

        public a(View view, d.a.i0.h.o0.f.a aVar) {
            this.f47409e = view;
            this.f47410f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f47409e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            int n = n0.n(AppRuntime.getAppContext());
            int u = n0.u();
            if (!b.this.f47406d) {
                b.this.f47406d = true;
                b.this.f47405c = (n - i2) - u;
                if (b.this.f47405c < 0) {
                    b.this.f47405c = 0;
                }
            }
            if (i2 > 0) {
                if (i2 >= b.this.f47407e || this.f47409e.getHeight() - i2 <= 200) {
                    if (i2 <= b.this.f47407e || this.f47409e.getHeight() - i2 >= 200) {
                        return;
                    }
                    b.this.f47407e = i2;
                    b.this.s(this.f47410f);
                    return;
                }
                b.this.f47407e = i2;
                b.this.f47404b = i2 - b.f47401g;
                b bVar = b.this;
                bVar.f47403a = ((n - i2) - u) - bVar.f47405c;
                if (b.this.f47403a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f47410f, bVar2.f47403a, b.this.f47404b)) {
                        return;
                    }
                    b.this.s(this.f47410f);
                }
            }
        }
    }

    public static b p() {
        if (f47402h == null) {
            synchronized (b.class) {
                if (f47402h == null) {
                    f47402h = new b();
                }
            }
        }
        return f47402h;
    }

    public final void m(View view, d.a.i0.h.o0.f.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f47407e = view.getHeight();
        this.f47408f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f47408f);
    }

    public boolean n(d.a.i0.h.o0.f.a aVar) {
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

    public final d.a.i0.a.l1.e.a.a o() {
        d.a.i0.a.l1.e.a.a aVar = new d.a.i0.a.l1.e.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.a.i0.a.l1.e.a.a q(int i2) {
        d.a.i0.a.l1.e.a.a aVar = new d.a.i0.a.l1.e.a.a();
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

    public boolean s(d.a.i0.h.o0.f.a aVar) {
        n Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout rootView = Y.getRootView();
        if (rootView != null && this.f47408f != null) {
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47408f);
        }
        aVar.h();
        this.f47408f = null;
        this.f47403a = -1;
        this.f47404b = -1;
        this.f47405c = -1;
        this.f47406d = false;
        this.f47407e = -1;
        return Y.removeView(aVar.f());
    }

    public final boolean t(d.a.i0.h.o0.f.a aVar, int i2, int i3) {
        n Y = f.V().Y();
        boolean z = Y != null && Y.a(aVar.f(), q(i3));
        if (z) {
            aVar.k(i2);
        }
        return z;
    }
}
