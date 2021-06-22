package d.a.m0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46357a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f46358b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.m0.a.p.e.b> f46359c = new TreeMap();

    /* renamed from: d.a.m0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0758a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.f46357a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            a.l(f.V().getActivity());
            if (a.f46357a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.m0.a.h0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f46361b;

        public b(d dVar, boolean z) {
            this.f46360a = dVar;
            this.f46361b = z;
        }

        @Override // d.a.m0.a.h0.b
        public void a(String str) {
            if (a.f46357a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f46360a.f46364a.b() + " url: " + str);
            }
            if (!d.a.m0.a.u1.a.a.C() || !g.N().g0()) {
                a.j(this.f46360a, this.f46361b);
            } else {
                a.k(this.f46360a, this.f46361b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46362a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f46363b;

        public c(d dVar, boolean z) {
            this.f46362a = dVar;
            this.f46363b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (a.f46357a) {
                Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
            }
            a.j(this.f46362a, this.f46363b);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.a.p.e.b f46364a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46365b;

        /* renamed from: d  reason: collision with root package name */
        public long f46367d;

        /* renamed from: e  reason: collision with root package name */
        public long f46368e;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f46366c = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f46369f = true;
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onReady();
    }

    public static void d() {
        f46358b.clear();
        f46359c.clear();
    }

    public static d e(Context context, boolean z) {
        d dVar = new d();
        dVar.f46367d = System.currentTimeMillis();
        dVar.f46365b = false;
        dVar.f46364a = g.N().y0(context, new b(dVar, z));
        return dVar;
    }

    public static d f(@Nullable Activity activity) {
        return g(activity, false);
    }

    public static d g(@Nullable Activity activity, boolean z) {
        if (f46357a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f46358b.isEmpty()) {
            return e(i(activity), false);
        }
        if (f46357a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f46358b.getFirst());
        }
        d removeFirst = f46358b.removeFirst();
        d.a.m0.a.p.e.b bVar = removeFirst.f46364a;
        if (bVar != null && activity != null) {
            bVar.e(activity);
        }
        if (f46357a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            q0.Y(new RunnableC0758a(), 600L);
        }
        return removeFirst;
    }

    public static d.a.m0.a.p.e.b h(@NonNull String str) {
        d.a.m0.a.p.e.b bVar = f46359c.get(str != null ? str : "");
        if (bVar != null) {
            f46359c.remove(str);
        }
        return bVar;
    }

    public static Context i(Context context) {
        if (context == null) {
            return d.a.m0.a.c1.a.b();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.a.m0.a.c1.a.b() : context;
    }

    public static void j(@NonNull d dVar, boolean z) {
        if (z && dVar.f46369f) {
            d.a.m0.a.h0.t.c.a.h(dVar.f46364a);
        }
        dVar.f46368e = System.currentTimeMillis();
        dVar.f46365b = true;
        if (dVar.f46366c.isEmpty()) {
            return;
        }
        Iterator<e> it = dVar.f46366c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onReady();
            }
        }
        dVar.f46366c.clear();
    }

    public static void k(@NonNull d dVar, boolean z) {
        d.a.m0.a.e0.f.d.f.k().o(dVar.f46364a, new c(dVar, z));
    }

    public static void l(Context context) {
        if (f46358b.size() < 2) {
            if (f46357a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f46358b.add(e(i(context), true));
        } else if (f46357a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f46357a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f46358b.size());
        }
    }

    public static void m(@NonNull String str, d.a.m0.a.p.e.b bVar) {
        Map<String, d.a.m0.a.p.e.b> map = f46359c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void n(d dVar, e eVar) {
        if (eVar == null) {
            return;
        }
        if (dVar.f46365b) {
            eVar.onReady();
            return;
        }
        dVar.f46366c.add(eVar);
        dVar.f46369f = false;
    }
}
