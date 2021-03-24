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
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44299a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<c> f44300b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.b.g0.a.p.d.b> f44301c = new TreeMap();

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f44299a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            b.h(f.V().getActivity());
            if (b.f44299a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0683b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f44302a;

        public C0683b(c cVar) {
            this.f44302a = cVar;
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            if (b.f44299a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f44302a.f44303a.c() + " url: " + str);
            }
            this.f44302a.f44307e = System.currentTimeMillis();
            c cVar = this.f44302a;
            cVar.f44304b = true;
            if (cVar.f44305c.isEmpty()) {
                return;
            }
            Iterator<d> it = this.f44302a.f44305c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.f44302a.f44305c.clear();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.a.p.d.b f44303a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44304b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d> f44305c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public long f44306d;

        /* renamed from: e  reason: collision with root package name */
        public long f44307e;
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onReady();
    }

    public static void b() {
        f44300b.clear();
        f44301c.clear();
    }

    public static c c(Context context) {
        c cVar = new c();
        cVar.f44306d = System.currentTimeMillis();
        cVar.f44304b = false;
        cVar.f44303a = d.b.g0.a.e0.w.d.L().r0(context, new C0683b(cVar));
        return cVar;
    }

    public static c d(@Nullable Activity activity) {
        return e(activity, false);
    }

    public static c e(@Nullable Activity activity, boolean z) {
        if (f44299a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f44300b.isEmpty()) {
            return c(g(activity));
        }
        if (f44299a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f44300b.getFirst());
        }
        c removeFirst = f44300b.removeFirst();
        d.b.g0.a.p.d.b bVar = removeFirst.f44303a;
        if (bVar != null && activity != null) {
            bVar.d(activity);
        }
        if (f44299a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            k0.U(new a(), 600L);
        }
        return removeFirst;
    }

    public static d.b.g0.a.p.d.b f(@NonNull String str) {
        d.b.g0.a.p.d.b bVar = f44301c.get(str != null ? str : "");
        if (bVar != null) {
            f44301c.remove(str);
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
        if (f44300b.size() < 2) {
            if (f44299a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f44300b.add(c(g(context)));
        } else if (f44299a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f44299a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f44300b.size());
        }
    }

    public static void i(@NonNull String str, d.b.g0.a.p.d.b bVar) {
        Map<String, d.b.g0.a.p.d.b> map = f44301c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void j(c cVar, d dVar) {
        if (dVar == null) {
            return;
        }
        if (cVar.f44304b) {
            dVar.onReady();
        } else {
            cVar.f44305c.add(dVar);
        }
    }
}
