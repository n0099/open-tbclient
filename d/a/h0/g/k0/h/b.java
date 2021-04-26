package d.a.h0.g.k0.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.i2.h0;
import d.a.h0.a.z0.f;
import d.a.h0.g.i0.e;
import d.a.h0.g.k0.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f46471g = e.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f46472h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f46473a;

    /* renamed from: b  reason: collision with root package name */
    public int f46474b;

    /* renamed from: c  reason: collision with root package name */
    public int f46475c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46476d;

    /* renamed from: e  reason: collision with root package name */
    public int f46477e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f46478f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f46479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.k0.h.a f46480f;

        public a(View view, d.a.h0.g.k0.h.a aVar) {
            this.f46479e = view;
            this.f46480f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f46479e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i2 = rect.bottom - rect.top;
            int l = h0.l(AppRuntime.getAppContext());
            int s = h0.s();
            if (!b.this.f46476d) {
                b.this.f46476d = true;
                b.this.f46475c = (l - i2) - s;
                if (b.this.f46475c < 0) {
                    b.this.f46475c = 0;
                }
            }
            if (i2 > 0) {
                if (i2 >= b.this.f46477e || this.f46479e.getHeight() - i2 <= 200) {
                    if (i2 <= b.this.f46477e || this.f46479e.getHeight() - i2 >= 200) {
                        return;
                    }
                    b.this.f46477e = i2;
                    b.this.s(this.f46480f);
                    return;
                }
                b.this.f46477e = i2;
                b.this.f46474b = i2 - b.f46471g;
                b bVar = b.this;
                bVar.f46473a = ((l - i2) - s) - bVar.f46475c;
                if (b.this.f46473a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f46480f, bVar2.f46473a, b.this.f46474b)) {
                        return;
                    }
                    b.this.s(this.f46480f);
                }
            }
        }
    }

    public static b p() {
        if (f46472h == null) {
            synchronized (b.class) {
                if (f46472h == null) {
                    f46472h = new b();
                }
            }
        }
        return f46472h;
    }

    public final void m(View view, d.a.h0.g.k0.h.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f46477e = view.getHeight();
        this.f46478f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f46478f);
    }

    public boolean n(d.a.h0.g.k0.h.a aVar) {
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

    public final d.a.h0.a.e1.d.a.a o() {
        d.a.h0.a.e1.d.a.a aVar = new d.a.h0.a.e1.d.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.a.h0.a.e1.d.a.a q(int i2) {
        d.a.h0.a.e1.d.a.a aVar = new d.a.h0.a.e1.d.a.a();
        aVar.l(true);
        aVar.n(i2);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final boolean r(View view) {
        d Y = f.V().Y();
        return Y != null && Y.g(view);
    }

    public boolean s(d.a.h0.g.k0.h.a aVar) {
        d Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout e2 = Y.e();
        if (e2 != null && this.f46478f != null) {
            e2.getViewTreeObserver().removeOnGlobalLayoutListener(this.f46478f);
        }
        aVar.h();
        this.f46478f = null;
        this.f46473a = -1;
        this.f46474b = -1;
        this.f46475c = -1;
        this.f46476d = false;
        this.f46477e = -1;
        return Y.m(aVar.f());
    }

    public final boolean t(d.a.h0.g.k0.h.a aVar, int i2, int i3) {
        d Y = f.V().Y();
        boolean z = Y != null && Y.q(aVar.f(), q(i3));
        if (z) {
            aVar.k(i2);
        }
        return z;
    }
}
