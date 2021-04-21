package d.b.h0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.f1.h.a;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45147a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f45148b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f45149c = true;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45150e;

        /* renamed from: d.b.h0.a.f1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0722a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f45151e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f45152f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f45153g;

            public RunnableC0722a(a aVar, int i, Bitmap bitmap, Rect rect) {
                this.f45151e = i;
                this.f45152f = bitmap;
                this.f45153g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.a.f1.h.a a2 = a.C0723a.a("simple_parser");
                a2.c(this.f45151e);
                if (a2.a(this.f45152f, this.f45153g)) {
                    return;
                }
                e.h();
            }
        }

        public a(String str) {
            this.f45150e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e0.l.f swanAppFragmentManager;
            d.b.h0.a.e0.l.e o;
            SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap n = h0.n();
            p.f().execute(new RunnableC0722a(this, c.d(o), n, c.b(n, o, d.b.h0.a.z0.f.V().m(this.f45150e))), "SwanNAArrivalCheck");
        }
    }

    public static void b(String str) {
        k0.T(new a(str));
    }

    public static void c() {
        d.b.h0.a.e0.l.f W;
        if (f45147a) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (d.b.h0.a.z1.e.e() || (W = d.b.h0.a.z0.f.V().W()) == null) {
            return;
        }
        d.b.h0.a.e0.l.e o = W.o();
        d.b.h0.a.p.d.j.d dVar = null;
        if (o != null) {
            d.b.h0.a.p.d.b T2 = o.T2();
            if (T2 == null) {
                return;
            }
            d.b.h0.a.p.d.e n = T2.n();
            if (n != null) {
                dVar = n.z();
            } else {
                dVar = T2.z();
            }
        }
        if (dVar == null || dVar.f46174b <= 0) {
            return;
        }
        d.b.h0.a.z1.e.a(dVar);
    }

    public static void d() {
        if (d.b.h0.a.z1.e.g()) {
            return;
        }
        d.b.h0.a.e0.l.e A = d.b.h0.a.z0.f.V().A();
        if (A == null) {
            if (f45147a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(A)) {
            if (f45147a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (f45147a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(A.X2());
        }
    }

    public static void e(String str) {
        f45148b = str;
    }

    public static boolean f(d.b.h0.a.e0.l.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(f45148b, eVar.X2());
        if (f45147a) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
        }
        return equals;
    }

    public static boolean g() {
        return f45149c;
    }

    public static void h() {
        d.b.h0.a.z1.e.l(d.b.h0.a.r1.e.y() != null ? d.b.h0.a.r1.e.y().L() : null);
    }

    public static void i() {
    }

    public static void j(boolean z) {
        if (f45147a) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && d.b.h0.a.z1.e.h()) {
            if (f45147a) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            f45149c = false;
        }
        if (!z) {
            d();
        }
        d.b.h0.a.z1.e.C();
        c();
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null || z) {
            return;
        }
        d.b.h0.a.z1.e.n(y.L());
    }

    public static void k() {
        f45148b = "";
        f45149c = true;
    }
}
