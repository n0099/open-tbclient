package d.a.h0.a.e0.v;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.e0.g;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42327a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<c> f42328b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.h0.a.p.d.b> f42329c = new TreeMap();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f42327a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
            }
            b.h(f.V().getActivity());
            if (b.f42327a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0655b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f42330a;

        public C0655b(c cVar) {
            this.f42330a = cVar;
        }

        @Override // d.a.h0.a.e0.g
        public void a(String str) {
            if (b.f42327a) {
                Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f42330a.f42331a.c() + " url: " + str);
            }
            this.f42330a.f42335e = System.currentTimeMillis();
            c cVar = this.f42330a;
            cVar.f42332b = true;
            if (cVar.f42333c.isEmpty()) {
                return;
            }
            Iterator<d> it = this.f42330a.f42333c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.f42330a.f42333c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.h0.a.p.d.b f42331a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42332b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<d> f42333c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public long f42334d;

        /* renamed from: e  reason: collision with root package name */
        public long f42335e;
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onReady();
    }

    public static void b() {
        f42328b.clear();
        f42329c.clear();
    }

    public static c c(Context context) {
        c cVar = new c();
        cVar.f42334d = System.currentTimeMillis();
        cVar.f42332b = false;
        cVar.f42331a = d.a.h0.a.e0.w.d.L().r0(context, new C0655b(cVar));
        return cVar;
    }

    public static c d(@Nullable Activity activity) {
        return e(activity, false);
    }

    public static c e(@Nullable Activity activity, boolean z) {
        if (f42327a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
        }
        if (f42328b.isEmpty()) {
            return c(g(activity));
        }
        if (f42327a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f42328b.getFirst());
        }
        c removeFirst = f42328b.removeFirst();
        d.a.h0.a.p.d.b bVar = removeFirst.f42331a;
        if (bVar != null && activity != null) {
            bVar.e(activity);
        }
        if (f42327a) {
            Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
        }
        if (!z) {
            k0.U(new a(), 600L);
        }
        return removeFirst;
    }

    public static d.a.h0.a.p.d.b f(@NonNull String str) {
        d.a.h0.a.p.d.b bVar = f42329c.get(str != null ? str : "");
        if (bVar != null) {
            f42329c.remove(str);
        }
        return bVar;
    }

    public static Context g(Context context) {
        if (context == null) {
            return d.a.h0.a.w0.a.c();
        }
        return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.a.h0.a.w0.a.c() : context;
    }

    public static void h(Context context) {
        if (f42328b.size() < 2) {
            if (f42327a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
            }
            f42328b.add(c(g(context)));
        } else if (f42327a) {
            Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
        }
        if (f42327a) {
            Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f42328b.size());
        }
    }

    public static void i(@NonNull String str, d.a.h0.a.p.d.b bVar) {
        Map<String, d.a.h0.a.p.d.b> map = f42329c;
        if (str == null) {
            str = "";
        }
        map.put(str, bVar);
    }

    public static void j(c cVar, d dVar) {
        if (dVar == null) {
            return;
        }
        if (cVar.f42332b) {
            dVar.onReady();
        } else {
            cVar.f42333c.add(dVar);
        }
    }
}
