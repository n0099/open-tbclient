package d.a.m0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.k;
import d.a.m0.a.m1.i.a;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47252a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f47253b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f47254c = true;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47255e;

        /* renamed from: d.a.m0.a.m1.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0801a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f47256e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f47257f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f47258g;

            public RunnableC0801a(a aVar, int i2, Bitmap bitmap, Rect rect) {
                this.f47256e = i2;
                this.f47257f = bitmap;
                this.f47258g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.m1.i.a a2 = a.C0802a.a("simple_parser");
                a2.c(this.f47256e);
                if (a2.a(this.f47257f, this.f47258g)) {
                    return;
                }
                f.h();
            }
        }

        public a(String str) {
            this.f47255e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.h0.g.g swanAppFragmentManager;
            d.a.m0.a.h0.g.f o;
            SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.e().execute(new RunnableC0801a(this, c.d(o), p, c.b(p, o, d.a.m0.a.g1.f.V().C(this.f47255e))), "SwanNAArrivalCheck");
        }
    }

    public static void b(String str) {
        q0.X(new a(str));
    }

    public static void c() {
        d.a.m0.a.h0.g.g W;
        if (f47252a) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (d.a.m0.a.j2.e.f() || (W = d.a.m0.a.g1.f.V().W()) == null) {
            return;
        }
        d.a.m0.a.h0.g.f o = W.o();
        d.a.m0.a.p.e.j.d dVar = null;
        if (o != null) {
            d.a.m0.a.p.e.b b3 = o.b3();
            if (b3 == null) {
                return;
            }
            d.a.m0.a.p.e.e m = b3.m();
            if (m != null) {
                dVar = m.O();
            } else {
                dVar = b3.O();
            }
        }
        if (dVar == null || dVar.f47783b <= 0) {
            return;
        }
        d.a.m0.a.j2.e.a(dVar);
    }

    public static void d() {
        if (d.a.m0.a.j2.e.h()) {
            return;
        }
        d.a.m0.a.h0.g.f J = d.a.m0.a.g1.f.V().J();
        if (J == null) {
            if (f47252a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(J)) {
            if (f47252a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (f47252a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(J.g3());
        }
    }

    public static void e(String str) {
        f47253b = str;
    }

    public static boolean f(d.a.m0.a.h0.g.f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(f47253b, fVar.g3());
        if (f47252a) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
        }
        return equals;
    }

    public static boolean g() {
        return f47254c;
    }

    public static void h() {
        d.a.m0.a.j2.e.o(d.a.m0.a.a2.e.i() != null ? d.a.m0.a.a2.e.i().N() : null);
    }

    public static void i() {
    }

    public static void j(boolean z) {
        if (f47252a) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && d.a.m0.a.j2.e.j()) {
            if (f47252a) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            f47254c = false;
        }
        if (!z) {
            d();
        }
        d.a.m0.a.j2.e.G();
        c();
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || z) {
            return;
        }
        d.a.m0.a.j2.e.q(i2.N());
    }

    public static void k() {
        f47253b = "";
        f47254c = true;
    }
}
