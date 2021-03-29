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
    public static final boolean f44300a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<c> f44301b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.b.g0.a.p.d.b> f44302c = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f44300a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            b.h(f.V().getActivity());
            if (b.f44300a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0684b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f44303a;

        public C0684b(c cVar) {
            this.f44303a = cVar;
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            if (b.f44300a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f44303a.f44304a.c() + " url: " + str);
            }
            this.f44303a.f44308e = System.currentTimeMillis();
            c cVar = this.f44303a;
            cVar.f44305b = true;
            if (cVar.f44306c.isEmpty()) {
                return;
            }
            Iterator<d> it = this.f44303a.f44306c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.f44303a.f44306c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.p.d.b f44304a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44305b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d> f44306c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public long f44307d;

        /* renamed from: e  reason: collision with root package name */
        public long f44308e;
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onReady();
    }

    public static void b() {
        f44301b.clear();
        f44302c.clear();
    }

    public static c c(Context context) {
        c cVar = new c();
        cVar.f44307d = System.currentTimeMillis();
        cVar.f44305b = false;
        cVar.f44304a = d.b.g0.a.e0.w.d.L().r0(context, new C0684b(cVar));
        return cVar;
    }

    public static c d(@Nullable Activity activity) {
        return e(activity, false);
    }

    public static c e(@Nullable Activity activity, boolean z) {
        if (f44300a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f44301b.isEmpty()) {
            return c(g(activity));
        }
        if (f44300a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f44301b.getFirst());
        }
        c removeFirst = f44301b.removeFirst();
        d.b.g0.a.p.d.b bVar = removeFirst.f44304a;
        if (bVar != null && activity != null) {
            bVar.d(activity);
        }
        if (f44300a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            k0.U(new a(), 600L);
        }
        return removeFirst;
    }

    public static d.b.g0.a.p.d.b f(@NonNull String str) {
        d.b.g0.a.p.d.b bVar = f44302c.get(str != null ? str : "");
        if (bVar != null) {
            f44302c.remove(str);
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
        if (f44301b.size() < 2) {
            if (f44300a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f44301b.add(c(g(context)));
        } else if (f44300a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f44300a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f44301b.size());
        }
    }

    public static void i(@NonNull String str, d.b.g0.a.p.d.b bVar) {
        Map<String, d.b.g0.a.p.d.b> map = f44302c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void j(c cVar, d dVar) {
        if (dVar == null) {
            return;
        }
        if (cVar.f44305b) {
            dVar.onReady();
        } else {
            cVar.f44306c.add(dVar);
        }
    }
}
