package d.a.i0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42399a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f42400b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.i0.a.p.e.b> f42401c = new TreeMap();

    /* renamed from: d.a.i0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0688a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.f42399a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            a.l(f.V().getActivity());
            if (a.f42399a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.i0.a.h0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42402a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42403b;

        public b(d dVar, boolean z) {
            this.f42402a = dVar;
            this.f42403b = z;
        }

        @Override // d.a.i0.a.h0.b
        public void a(String str) {
            if (a.f42399a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f42402a.f42406a.b() + " url: " + str);
            }
            if (!d.a.i0.a.u1.a.a.C() || !g.N().g0()) {
                a.j(this.f42402a, this.f42403b);
            } else {
                a.k(this.f42402a, this.f42403b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42404a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42405b;

        public c(d dVar, boolean z) {
            this.f42404a = dVar;
            this.f42405b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (a.f42399a) {
                Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
            }
            a.j(this.f42404a, this.f42405b);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.a.p.e.b f42406a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42407b;

        /* renamed from: d  reason: collision with root package name */
        public long f42409d;

        /* renamed from: e  reason: collision with root package name */
        public long f42410e;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f42408c = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f42411f = true;
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onReady();
    }

    public static void d() {
        f42400b.clear();
        f42401c.clear();
    }

    public static d e(Context context, boolean z) {
        d dVar = new d();
        dVar.f42409d = System.currentTimeMillis();
        dVar.f42407b = false;
        dVar.f42406a = g.N().y0(context, new b(dVar, z));
        return dVar;
    }

    public static d f(@Nullable Activity activity) {
        return g(activity, false);
    }

    public static d g(@Nullable Activity activity, boolean z) {
        if (f42399a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f42400b.isEmpty()) {
            return e(i(activity), false);
        }
        if (f42399a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f42400b.getFirst());
        }
        d removeFirst = f42400b.removeFirst();
        d.a.i0.a.p.e.b bVar = removeFirst.f42406a;
        if (bVar != null && activity != null) {
            bVar.e(activity);
        }
        if (f42399a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            q0.Y(new RunnableC0688a(), 600L);
        }
        return removeFirst;
    }

    public static d.a.i0.a.p.e.b h(@NonNull String str) {
        d.a.i0.a.p.e.b bVar = f42401c.get(str != null ? str : "");
        if (bVar != null) {
            f42401c.remove(str);
        }
        return bVar;
    }

    public static Context i(Context context) {
        if (context == null) {
            return d.a.i0.a.c1.a.b();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.a.i0.a.c1.a.b() : context;
    }

    public static void j(@NonNull d dVar, boolean z) {
        if (z && dVar.f42411f) {
            d.a.i0.a.h0.t.c.a.h(dVar.f42406a);
        }
        dVar.f42410e = System.currentTimeMillis();
        dVar.f42407b = true;
        if (dVar.f42408c.isEmpty()) {
            return;
        }
        Iterator<e> it = dVar.f42408c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onReady();
            }
        }
        dVar.f42408c.clear();
    }

    public static void k(@NonNull d dVar, boolean z) {
        d.a.i0.a.e0.f.d.f.k().o(dVar.f42406a, new c(dVar, z));
    }

    public static void l(Context context) {
        if (f42400b.size() < 2) {
            if (f42399a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f42400b.add(e(i(context), true));
        } else if (f42399a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f42399a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f42400b.size());
        }
    }

    public static void m(@NonNull String str, d.a.i0.a.p.e.b bVar) {
        Map<String, d.a.i0.a.p.e.b> map = f42401c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void n(d dVar, e eVar) {
        if (eVar == null) {
            return;
        }
        if (dVar.f42407b) {
            eVar.onReady();
            return;
        }
        dVar.f42408c.add(eVar);
        dVar.f42411f = false;
    }
}
