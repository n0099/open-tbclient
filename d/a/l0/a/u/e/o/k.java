package d.a.l0.a.u.e.o;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48849g = d.a.l0.a.k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f48850h;

    /* renamed from: i  reason: collision with root package name */
    public static d.a.l0.a.y0.k.g.a f48851i;
    public static boolean j;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f48852a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.l0.a.y0.k.g.a> f48853b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f48854c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<Integer> f48855d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.g1.h f48856e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.t0.a f48857f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.a.l0.a.t0.a {
        public a() {
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4 && k.this.f48855d != null && k.this.g()) {
                k.this.f48855d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static k e() {
        if (f48850h == null) {
            synchronized (k.class) {
                if (f48850h == null) {
                    f48850h = new k();
                }
            }
        }
        return f48850h;
    }

    public void b(d.a.l0.a.y0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f48853b.put(aVar.c(), aVar);
    }

    public void c() {
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
        f48851i = null;
        j = false;
    }

    public d.a.l0.a.y0.k.g.a d() {
        if (f48849g && f48851i != null) {
            Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + f48851i.c());
        }
        return f48851i;
    }

    public boolean f() {
        boolean z = true;
        z = (!(d() != null && d().g0() == null) || j) ? false : false;
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
        return z;
    }

    public boolean g() {
        int i2 = this.f48854c;
        return i2 == 90 || i2 == -90;
    }

    public void h() {
        d.a.l0.a.v2.e1.b<Integer> bVar;
        if (g() && (bVar = this.f48855d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        if (g()) {
            if (f48849g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.a.l0.a.z1.b.a.f();
            d.a.l0.a.z1.b.a.k(true);
        } else if (f48849g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f48849g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.a.l0.a.y0.k.g.a> hashMap = this.f48853b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f48853b.keySet()) {
            if (str2.equals(str)) {
                if (f48849g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.a.l0.a.y0.k.g.a aVar = this.f48853b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.Q().c(aVar.c());
                }
            }
        }
    }

    public void k(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f48852a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void l() {
        d.a.l0.a.g1.f.V().getActivity().registerCallback(this.f48857f);
    }

    public void m() {
        synchronized (this) {
            w();
            v();
            this.f48852a = null;
            this.f48853b.clear();
            this.f48855d = null;
        }
        f48850h = null;
    }

    public void n(d.a.l0.a.y0.k.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f48851i = null;
            j = false;
        }
    }

    public void o() {
        this.f48855d = null;
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap = this.f48852a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f48852a.keySet().size();
            if (f48849g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48853b.remove(str);
    }

    public void r() {
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
        j = true;
    }

    public void s(d.a.l0.a.y0.k.g.a aVar) {
        if (f48849g) {
            Log.i("SwanInlinePlayerManager", "setCacheVideo: " + aVar.toString());
        }
        f48851i = aVar;
    }

    public void t(int i2) {
        this.f48854c = i2;
    }

    public void u(d.a.l0.a.v2.e1.b<Integer> bVar) {
        this.f48855d = bVar;
    }

    public void v() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        d.a.l0.a.t0.a aVar = this.f48857f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void w() {
        d.a.l0.a.g1.h hVar = this.f48856e;
        if (hVar != null) {
            d.a.l0.a.g1.i.f(hVar);
            this.f48856e = null;
        }
    }
}
