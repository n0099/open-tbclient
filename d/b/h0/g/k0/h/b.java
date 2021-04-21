package d.b.h0.g.k0.h;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.i2.h0;
import d.b.h0.a.z0.f;
import d.b.h0.g.i0.e;
import d.b.h0.g.k0.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f48995g = e.a(42.0f);

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f48996h = null;

    /* renamed from: a  reason: collision with root package name */
    public int f48997a;

    /* renamed from: b  reason: collision with root package name */
    public int f48998b;

    /* renamed from: c  reason: collision with root package name */
    public int f48999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49000d;

    /* renamed from: e  reason: collision with root package name */
    public int f49001e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f49002f = null;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.k0.h.a f49004f;

        public a(View view, d.b.h0.g.k0.h.a aVar) {
            this.f49003e = view;
            this.f49004f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            View view = this.f49003e;
            if (view == null) {
                return;
            }
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int l = h0.l(AppRuntime.getAppContext());
            int s = h0.s();
            if (!b.this.f49000d) {
                b.this.f49000d = true;
                b.this.f48999c = (l - i) - s;
                if (b.this.f48999c < 0) {
                    b.this.f48999c = 0;
                }
            }
            if (i > 0) {
                if (i >= b.this.f49001e || this.f49003e.getHeight() - i <= 200) {
                    if (i <= b.this.f49001e || this.f49003e.getHeight() - i >= 200) {
                        return;
                    }
                    b.this.f49001e = i;
                    b.this.s(this.f49004f);
                    return;
                }
                b.this.f49001e = i;
                b.this.f48998b = i - b.f48995g;
                b bVar = b.this;
                bVar.f48997a = ((l - i) - s) - bVar.f48999c;
                if (b.this.f48997a > 0) {
                    b bVar2 = b.this;
                    if (bVar2.t(this.f49004f, bVar2.f48997a, b.this.f48998b)) {
                        return;
                    }
                    b.this.s(this.f49004f);
                }
            }
        }
    }

    public static b p() {
        if (f48996h == null) {
            synchronized (b.class) {
                if (f48996h == null) {
                    f48996h = new b();
                }
            }
        }
        return f48996h;
    }

    public final void m(View view, d.b.h0.g.k0.h.a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        this.f49001e = view.getHeight();
        this.f49002f = new a(view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f49002f);
    }

    public boolean n(d.b.h0.g.k0.h.a aVar) {
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

    public final d.b.h0.a.e1.d.a.a o() {
        d.b.h0.a.e1.d.a.a aVar = new d.b.h0.a.e1.d.a.a();
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-2);
        return aVar;
    }

    public final d.b.h0.a.e1.d.a.a q(int i) {
        d.b.h0.a.e1.d.a.a aVar = new d.b.h0.a.e1.d.a.a();
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

    public boolean s(d.b.h0.g.k0.h.a aVar) {
        d Y = f.V().Y();
        if (Y == null) {
            return false;
        }
        FrameLayout e2 = Y.e();
        if (e2 != null && this.f49002f != null) {
            e2.getViewTreeObserver().removeOnGlobalLayoutListener(this.f49002f);
        }
        aVar.h();
        this.f49002f = null;
        this.f48997a = -1;
        this.f48998b = -1;
        this.f48999c = -1;
        this.f49000d = false;
        this.f49001e = -1;
        return Y.m(aVar.f());
    }

    public final boolean t(d.b.h0.g.k0.h.a aVar, int i, int i2) {
        d Y = f.V().Y();
        boolean z = Y != null && Y.q(aVar.f(), q(i2));
        if (z) {
            aVar.k(i);
        }
        return z;
    }
}
