package d.b.g0.a.e0.v;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.e0.g;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44692a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<c> f44693b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.b.g0.a.p.d.b> f44694c = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f44692a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            b.h(f.V().getActivity());
            if (b.f44692a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0696b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f44695a;

        public C0696b(c cVar) {
            this.f44695a = cVar;
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            if (b.f44692a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f44695a.f44696a.c() + " url: " + str);
            }
            this.f44695a.f44700e = System.currentTimeMillis();
            c cVar = this.f44695a;
            cVar.f44697b = true;
            if (cVar.f44698c.isEmpty()) {
                return;
            }
            Iterator<d> it = this.f44695a.f44698c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.f44695a.f44698c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.p.d.b f44696a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44697b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d> f44698c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public long f44699d;

        /* renamed from: e  reason: collision with root package name */
        public long f44700e;
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onReady();
    }

    public static void b() {
        f44693b.clear();
        f44694c.clear();
    }

    public static c c(Context context) {
        c cVar = new c();
        cVar.f44699d = System.currentTimeMillis();
        cVar.f44697b = false;
        cVar.f44696a = d.b.g0.a.e0.w.d.L().r0(context, new C0696b(cVar));
        return cVar;
    }

    public static c d(@Nullable Activity activity) {
        return e(activity, false);
    }

    public static c e(@Nullable Activity activity, boolean z) {
        if (f44692a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f44693b.isEmpty()) {
            return c(g(activity));
        }
        if (f44692a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f44693b.getFirst());
        }
        c removeFirst = f44693b.removeFirst();
        d.b.g0.a.p.d.b bVar = removeFirst.f44696a;
        if (bVar != null && activity != null) {
            bVar.d(activity);
        }
        if (f44692a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            k0.U(new a(), 600L);
        }
        return removeFirst;
    }

    public static d.b.g0.a.p.d.b f(@NonNull String str) {
        d.b.g0.a.p.d.b bVar = f44694c.get(str != null ? str : "");
        if (bVar != null) {
            f44694c.remove(str);
        }
        return bVar;
    }

    public static Context g(Context context) {
        if (context == null) {
            return d.b.g0.a.w0.a.c();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.b.g0.a.w0.a.c() : context;
    }

    public static void h(Context context) {
        if (f44693b.size() < 2) {
            if (f44692a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f44693b.add(c(g(context)));
        } else if (f44692a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f44692a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f44693b.size());
        }
    }

    public static void i(@NonNull String str, d.b.g0.a.p.d.b bVar) {
        Map<String, d.b.g0.a.p.d.b> map = f44694c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void j(c cVar, d dVar) {
        if (dVar == null) {
            return;
        }
        if (cVar.f44697b) {
            dVar.onReady();
        } else {
            cVar.f44698c.add(dVar);
        }
    }
}
