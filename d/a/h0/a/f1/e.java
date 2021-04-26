package d.a.h0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.f1.h.a;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42458a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f42459b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f42460c = true;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42461e;

        /* renamed from: d.a.h0.a.f1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0661a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f42462e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f42463f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f42464g;

            public RunnableC0661a(a aVar, int i2, Bitmap bitmap, Rect rect) {
                this.f42462e = i2;
                this.f42463f = bitmap;
                this.f42464g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.f1.h.a a2 = a.C0662a.a("simple_parser");
                a2.c(this.f42462e);
                if (a2.a(this.f42463f, this.f42464g)) {
                    return;
                }
                e.h();
            }
        }

        public a(String str) {
            this.f42461e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.e0.l.f swanAppFragmentManager;
            d.a.h0.a.e0.l.e o;
            SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap n = h0.n();
            p.f().execute(new RunnableC0661a(this, c.d(o), n, c.b(n, o, d.a.h0.a.z0.f.V().C(this.f42461e))), "SwanNAArrivalCheck");
        }
    }

    public static void b(String str) {
        k0.T(new a(str));
    }

    public static void c() {
        d.a.h0.a.e0.l.f W;
        if (f42458a) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (d.a.h0.a.z1.e.e() || (W = d.a.h0.a.z0.f.V().W()) == null) {
            return;
        }
        d.a.h0.a.e0.l.e o = W.o();
        d.a.h0.a.p.d.j.d dVar = null;
        if (o != null) {
            d.a.h0.a.p.d.b S2 = o.S2();
            if (S2 == null) {
                return;
            }
            d.a.h0.a.p.d.e l = S2.l();
            if (l != null) {
                dVar = l.M();
            } else {
                dVar = S2.M();
            }
        }
        if (dVar == null || dVar.f43521b <= 0) {
            return;
        }
        d.a.h0.a.z1.e.a(dVar);
    }

    public static void d() {
        if (d.a.h0.a.z1.e.g()) {
            return;
        }
        d.a.h0.a.e0.l.e J = d.a.h0.a.z0.f.V().J();
        if (J == null) {
            if (f42458a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(J)) {
            if (f42458a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (f42458a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(J.W2());
        }
    }

    public static void e(String str) {
        f42459b = str;
    }

    public static boolean f(d.a.h0.a.e0.l.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(f42459b, eVar.W2());
        if (f42458a) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
        }
        return equals;
    }

    public static boolean g() {
        return f42460c;
    }

    public static void h() {
        d.a.h0.a.z1.e.l(d.a.h0.a.r1.e.h() != null ? d.a.h0.a.r1.e.h().L() : null);
    }

    public static void i() {
    }

    public static void j(boolean z) {
        if (f42458a) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && d.a.h0.a.z1.e.h()) {
            if (f42458a) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            f42460c = false;
        }
        if (!z) {
            d();
        }
        d.a.h0.a.z1.e.C();
        c();
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || z) {
            return;
        }
        d.a.h0.a.z1.e.n(h2.L());
    }

    public static void k() {
        f42459b = "";
        f42460c = true;
    }
}
