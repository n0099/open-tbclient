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
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42573a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f42574b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.l0.a.p.e.b> f42575c = new TreeMap();

    /* renamed from: d.a.l0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0699a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.f42573a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            a.l(f.V().getActivity());
            if (a.f42573a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.l0.a.h0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42576a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42577b;

        public b(d dVar, boolean z) {
            this.f42576a = dVar;
            this.f42577b = z;
        }

        @Override // d.a.l0.a.h0.b
        public void a(String str) {
            if (a.f42573a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f42576a.f42580a.b() + " url: " + str);
            }
            if (!d.a.l0.a.u1.a.a.C() || !g.N().g0()) {
                a.j(this.f42576a, this.f42577b);
            } else {
                a.k(this.f42576a, this.f42577b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f42578a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42579b;

        public c(d dVar, boolean z) {
            this.f42578a = dVar;
            this.f42579b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            if (a.f42573a) {
                Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
            }
            a.j(this.f42578a, this.f42579b);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.a.p.e.b f42580a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42581b;

        /* renamed from: d  reason: collision with root package name */
        public long f42583d;

        /* renamed from: e  reason: collision with root package name */
        public long f42584e;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f42582c = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public boolean f42585f = true;
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onReady();
    }

    public static void d() {
        f42574b.clear();
        f42575c.clear();
    }

    public static d e(Context context, boolean z) {
        d dVar = new d();
        dVar.f42583d = System.currentTimeMillis();
        dVar.f42581b = false;
        dVar.f42580a = g.N().y0(context, new b(dVar, z));
        return dVar;
    }

    public static d f(@Nullable Activity activity) {
        return g(activity, false);
    }

    public static d g(@Nullable Activity activity, boolean z) {
        if (f42573a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f42574b.isEmpty()) {
            return e(i(activity), false);
        }
        if (f42573a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f42574b.getFirst());
        }
        d removeFirst = f42574b.removeFirst();
        d.a.l0.a.p.e.b bVar = removeFirst.f42580a;
        if (bVar != null && activity != null) {
            bVar.e(activity);
        }
        if (f42573a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            q0.Y(new RunnableC0699a(), 600L);
        }
        return removeFirst;
    }

    public static d.a.l0.a.p.e.b h(@NonNull String str) {
        d.a.l0.a.p.e.b bVar = f42575c.get(str != null ? str : "");
        if (bVar != null) {
            f42575c.remove(str);
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
        if (z && dVar.f42585f) {
            d.a.l0.a.h0.t.c.a.h(dVar.f42580a);
        }
        dVar.f42584e = System.currentTimeMillis();
        dVar.f42581b = true;
        if (dVar.f42582c.isEmpty()) {
            return;
        }
        Iterator<e> it = dVar.f42582c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.onReady();
            }
        }
        dVar.f42582c.clear();
    }

    public static void k(@NonNull d dVar, boolean z) {
        d.a.l0.a.e0.f.d.f.k().o(dVar.f42580a, new c(dVar, z));
    }

    public static void l(Context context) {
        if (f42574b.size() < 2) {
            if (f42573a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f42574b.add(e(i(context), true));
        } else if (f42573a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f42573a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f42574b.size());
        }
    }

    public static void m(@NonNull String str, d.a.l0.a.p.e.b bVar) {
        Map<String, d.a.l0.a.p.e.b> map = f42575c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void n(d dVar, e eVar) {
        if (eVar == null) {
            return;
        }
        if (dVar.f42581b) {
            eVar.onReady();
            return;
        }
        dVar.f42582c.add(eVar);
        dVar.f42585f = false;
    }
}
