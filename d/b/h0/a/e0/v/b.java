package d.b.h0.a.e0.v;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.e0.g;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.z0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45021a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<c> f45022b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.b.h0.a.p.d.b> f45023c = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f45021a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            b.h(f.V().getActivity());
            if (b.f45021a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* renamed from: d.b.h0.a.e0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0716b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f45024a;

        public C0716b(c cVar) {
            this.f45024a = cVar;
        }

        @Override // d.b.h0.a.e0.g
        public void a(String str) {
            if (b.f45021a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f45024a.f45025a.c() + " url: " + str);
            }
            this.f45024a.f45029e = System.currentTimeMillis();
            c cVar = this.f45024a;
            cVar.f45026b = true;
            if (cVar.f45027c.isEmpty()) {
                return;
            }
            Iterator<d> it = this.f45024a.f45027c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.f45024a.f45027c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.h0.a.p.d.b f45025a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f45026b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d> f45027c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public long f45028d;

        /* renamed from: e  reason: collision with root package name */
        public long f45029e;
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onReady();
    }

    public static void b() {
        f45022b.clear();
        f45023c.clear();
    }

    public static c c(Context context) {
        c cVar = new c();
        cVar.f45028d = System.currentTimeMillis();
        cVar.f45026b = false;
        cVar.f45025a = d.b.h0.a.e0.w.d.L().r0(context, new C0716b(cVar));
        return cVar;
    }

    public static c d(@Nullable Activity activity) {
        return e(activity, false);
    }

    public static c e(@Nullable Activity activity, boolean z) {
        if (f45021a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f45022b.isEmpty()) {
            return c(g(activity));
        }
        if (f45021a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f45022b.getFirst());
        }
        c removeFirst = f45022b.removeFirst();
        d.b.h0.a.p.d.b bVar = removeFirst.f45025a;
        if (bVar != null && activity != null) {
            bVar.d(activity);
        }
        if (f45021a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            k0.U(new a(), 600L);
        }
        return removeFirst;
    }

    public static d.b.h0.a.p.d.b f(@NonNull String str) {
        d.b.h0.a.p.d.b bVar = f45023c.get(str != null ? str : "");
        if (bVar != null) {
            f45023c.remove(str);
        }
        return bVar;
    }

    public static Context g(Context context) {
        if (context == null) {
            return d.b.h0.a.w0.a.c();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.b.h0.a.w0.a.c() : context;
    }

    public static void h(Context context) {
        if (f45022b.size() < 2) {
            if (f45021a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f45022b.add(c(g(context)));
        } else if (f45021a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f45021a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f45022b.size());
        }
    }

    public static void i(@NonNull String str, d.b.h0.a.p.d.b bVar) {
        Map<String, d.b.h0.a.p.d.b> map = f45023c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void j(c cVar, d dVar) {
        if (dVar == null) {
            return;
        }
        if (cVar.f45026b) {
            dVar.onReady();
        } else {
            cVar.f45027c.add(dVar);
        }
    }
}
