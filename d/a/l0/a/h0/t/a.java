package d.a.l0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46249a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f46250b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.l0.a.p.e.b> f46251c = new TreeMap();

    /* renamed from: d.a.l0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0755a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.f46249a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            a.l(f.V().getActivity());
            if (a.f46249a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a.l0.a.h0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46252a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f46253b;

        public b(d dVar, boolean z) {
            this.f46252a = dVar;
            this.f46253b = z;
        }

        @Override // d.a.l0.a.h0.b
        public void a(String str) {
            if (a.f46249a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f46252a.f46256a.b() + " url: " + str);
            }
            if (!d.a.l0.a.u1.a.a.C() || !g.N().g0()) {
                a.j(this.f46252a, this.f46253b);
            } else {
                a.k(this.f46252a, this.f46253b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f46254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f46255b;

        public c(d dVar, boolean z) {
            this.f46254a = dVar;
            this.f46255b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (a.f46249a) {
                Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
            }
            a.j(this.f46254a, this.f46255b);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.p.e.b f46256a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46257b;

        /* renamed from: d  reason: collision with root package name */
        public long f46259d;

        /* renamed from: e  reason: collision with root package name */
        public long f46260e;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f46258c = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f46261f = true;
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onReady();
    }

    public static void d() {
        f46250b.clear();
        f46251c.clear();
    }

    public static d e(Context context, boolean z) {
        d dVar = new d();
        dVar.f46259d = System.currentTimeMillis();
        dVar.f46257b = false;
        dVar.f46256a = g.N().y0(context, new b(dVar, z));
        return dVar;
    }

    public static d f(@Nullable Activity activity) {
        return g(activity, false);
    }

    public static d g(@Nullable Activity activity, boolean z) {
        if (f46249a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f46250b.isEmpty()) {
            return e(i(activity), false);
        }
        if (f46249a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f46250b.getFirst());
        }
        d removeFirst = f46250b.removeFirst();
        d.a.l0.a.p.e.b bVar = removeFirst.f46256a;
        if (bVar != null && activity != null) {
            bVar.e(activity);
        }
        if (f46249a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            q0.Y(new RunnableC0755a(), 600L);
        }
        return removeFirst;
    }

    public static d.a.l0.a.p.e.b h(@NonNull String str) {
        d.a.l0.a.p.e.b bVar = f46251c.get(str != null ? str : "");
        if (bVar != null) {
            f46251c.remove(str);
        }
        return bVar;
    }

    public static Context i(Context context) {
        if (context == null) {
            return d.a.l0.a.c1.a.b();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.a.l0.a.c1.a.b() : context;
    }

    public static void j(@NonNull d dVar, boolean z) {
        if (z && dVar.f46261f) {
            d.a.l0.a.h0.t.c.a.h(dVar.f46256a);
        }
        dVar.f46260e = System.currentTimeMillis();
        dVar.f46257b = true;
        if (dVar.f46258c.isEmpty()) {
            return;
        }
        Iterator<e> it = dVar.f46258c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onReady();
            }
        }
        dVar.f46258c.clear();
    }

    public static void k(@NonNull d dVar, boolean z) {
        d.a.l0.a.e0.f.d.f.k().o(dVar.f46256a, new c(dVar, z));
    }

    public static void l(Context context) {
        if (f46250b.size() < 2) {
            if (f46249a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f46250b.add(e(i(context), true));
        } else if (f46249a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f46249a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f46250b.size());
        }
    }

    public static void m(@NonNull String str, d.a.l0.a.p.e.b bVar) {
        Map<String, d.a.l0.a.p.e.b> map = f46251c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void n(d dVar, e eVar) {
        if (eVar == null) {
            return;
        }
        if (dVar.f46257b) {
            eVar.onReady();
            return;
        }
        dVar.f46258c.add(eVar);
        dVar.f46261f = false;
    }
}
