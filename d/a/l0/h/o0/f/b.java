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
    public static final int f47577g = g.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f47578h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f47579a;

    /* renamed from: b  reason: collision with root package name */
    public int f47580b;

    /* renamed from: c  reason: collision with root package name */
    public int f47581c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47582d;

    /* renamed from: e  reason: collision with root package name */
    public int f47583e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f47584f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.h.o0.f.a f47586f;

        public a(View view, d.a.l0.h.o0.f.a aVar) {
            this.f47585e = view;
            this.f47586f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f47585e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            int n = n0.n(AppRuntime.getAppContext());
            int u = n0.u();
            if (!b.this.f47582d) {
                b.this.f47582d = true;
                b.this.f47581c = (n - i2) - u;
                if (b.this.f47581c < 0) {
                    b.this.f47581c = 0;
                }
            }
            if (i2 > 0) {
                if (i2 >= b.this.f47583e || this.f47585e.getHeight() - i2 <= 200) {
                    if (i2 <= b.this.f47583e || this.f47585e.getHeight() - i2 >= 200) {
                        return;
                    }
                    b.this.f47583e = i2;
                    b.this.s(this.f47586f);
                    return;
                }
                b.this.f47583e = i2;
                b.this.f47580b = i2 - b.f47577g;
                b bVar = b.this;
                bVar.f47579a = ((n - i2) - u) - bVar.f47581c;
                if (b.this.f47579a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f47586f, bVar2.f47579a, b.this.f47580b)) {
                        return;
                    }
                    b.this.s(this.f47586f);
                }
            }
        }
    }

    public static b p() {
        if (f47578h == null) {
            synchronized (b.class) {
                if (f47578h == null) {
                    f47578h = new b();
                }
            }
        }
        return f47578h;
    }

    public final void m(View view, d.a.l0.h.o0.f.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f47583e = view.getHeight();
        this.f47584f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f47584f);
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
        if (rootView != null && this.f47584f != null) {
            rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f47584f);
        }
        aVar.h();
        this.f47584f = null;
        this.f47579a = -1;
        this.f47580b = -1;
        this.f47581c = -1;
        this.f47582d = false;
        this.f47583e = -1;
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
