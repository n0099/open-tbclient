package d.a.l0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.g1.f;
import d.a.l0.a.p.b.a.n;
import d.a.l0.a.v2.n0;
import d.a.l0.h.m0.g;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f51251g = g.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f51252h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f51253a;

    /* renamed from: b  reason: collision with root package name */
    public int f51254b;

    /* renamed from: c  reason: collision with root package name */
    public int f51255c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51256d;

    /* renamed from: e  reason: collision with root package name */
    public int f51257e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f51258f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f51259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.o0.f.a f51260f;

        public a(View view, d.a.l0.h.o0.f.a aVar) {
            this.f51259e = view;
            this.f51260f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f51259e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            int n = n0.n(AppRuntime.getAppContext());
            int u = n0.u();
            if (!b.this.f51256d) {
                b.this.f51256d = true;
                b.this.f51255c = (n - i2) - u;
                if (b.this.f51255c < 0) {
                    b.this.f51255c = 0;
                }
            }
            if (i2 > 0) {
                if (i2 >= b.this.f51257e || this.f51259e.getHeight() - i2 <= 200) {
                    if (i2 <= b.this.f51257e || this.f51259e.getHeight() - i2 >= 200) {
                        return;
                    }
                    b.this.f51257e = i2;
                    b.this.s(this.f51260f);
                    return;
                }
                b.this.f51257e = i2;
                b.this.f51254b = i2 - b.f51251g;
                b bVar = b.this;
                bVar.f51253a = ((n - i2) - u) - bVar.f51255c;
                if (b.this.f51253a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f51260f, bVar2.f51253a, b.this.f51254b)) {
                        return;
                    }
                    b.this.s(this.f51260f);
                }
            }
        }
    }

    public static b p() {
        if (f51252h == null) {
            synchronized (b.class) {
                if (f51252h == null) {
                    f51252h = new b();
                }
            }
        }
        return f51252h;
    }

    public final void m(View view, d.a.l0.h.o0.f.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f51257e = view.getHeight();
        this.f51258f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f51258f);
    }

    public boolean n(d.a.l0.h.o0.f.a aVar) {
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

    public final d.a.l0.a.l1.e.a.a o() {
        d.a.l0.a.l1.e.a.a aVar = new d.a.l0.a.l1.e.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.a.l0.a.l1.e.a.a q(int i2) {
        d.a.l0.a.l1.e.a.a aVar = new d.a.l0.a.l1.e.a.a();
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

    public boolean s(d.a.l0.h.o0.f.a aVar) {
        n Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout rootView = Y.getRootView();
        if (rootView != null && this.f51258f != null) {
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f51258f);
        }
        aVar.h();
        this.f51258f = null;
        this.f51253a = -1;
        this.f51254b = -1;
        this.f51255c = -1;
        this.f51256d = false;
        this.f51257e = -1;
        return Y.removeView(aVar.f());
    }

    public final boolean t(d.a.l0.h.o0.f.a aVar, int i2, int i3) {
        n Y = f.V().Y();
        boolean z = Y != null && Y.a(aVar.f(), q(i3));
        if (z) {
            aVar.k(i2);
        }
        return z;
    }
}
