package d.b.g0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.f1.h.a;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44426a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f44427b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f44428c = true;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44429e;

        /* renamed from: d.b.g0.a.f1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0690a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f44430e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f44431f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f44432g;

            public RunnableC0690a(a aVar, int i, Bitmap bitmap, Rect rect) {
                this.f44430e = i;
                this.f44431f = bitmap;
                this.f44432g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.f1.h.a a2 = a.C0691a.a("simple_parser");
                a2.c(this.f44430e);
                if (a2.a(this.f44431f, this.f44432g)) {
                    return;
                }
                e.h();
            }
        }

        public a(String str) {
            this.f44429e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.f swanAppFragmentManager;
            d.b.g0.a.e0.l.e o;
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap n = h0.n();
            p.f().execute(new RunnableC0690a(this, c.d(o), n, c.b(n, o, d.b.g0.a.z0.f.V().m(this.f44429e))), "SwanNAArrivalCheck");
        }
    }

    public static void b(String str) {
        k0.T(new a(str));
    }

    public static void c() {
        d.b.g0.a.e0.l.f W;
        if (f44426a) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (d.b.g0.a.z1.e.e() || (W = d.b.g0.a.z0.f.V().W()) == null) {
            return;
        }
        d.b.g0.a.e0.l.e o = W.o();
        d.b.g0.a.p.d.j.d dVar = null;
        if (o != null) {
            d.b.g0.a.p.d.b T2 = o.T2();
            if (T2 == null) {
                return;
            }
            d.b.g0.a.p.d.e n = T2.n();
            if (n != null) {
                dVar = n.z();
            } else {
                dVar = T2.z();
            }
        }
        if (dVar == null || dVar.f45453b <= 0) {
            return;
        }
        d.b.g0.a.z1.e.a(dVar);
    }

    public static void d() {
        if (d.b.g0.a.z1.e.g()) {
            return;
        }
        d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
        if (A == null) {
            if (f44426a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(A)) {
            if (f44426a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (f44426a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(A.X2());
        }
    }

    public static void e(String str) {
        f44427b = str;
    }

    public static boolean f(d.b.g0.a.e0.l.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(f44427b, eVar.X2());
        if (f44426a) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
        }
        return equals;
    }

    public static boolean g() {
        return f44428c;
    }

    public static void h() {
        d.b.g0.a.z1.e.l(d.b.g0.a.r1.e.y() != null ? d.b.g0.a.r1.e.y().L() : null);
    }

    public static void i() {
    }

    public static void j(boolean z) {
        if (f44426a) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && d.b.g0.a.z1.e.h()) {
            if (f44426a) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            f44428c = false;
        }
        if (!z) {
            d();
        }
        d.b.g0.a.z1.e.C();
        c();
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || z) {
            return;
        }
        d.b.g0.a.z1.e.n(y.L());
    }

    public static void k() {
        f44427b = "";
        f44428c = true;
    }
}
