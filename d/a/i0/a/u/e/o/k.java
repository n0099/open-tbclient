package d.a.i0.a.u.e.o;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44999g = d.a.i0.a.k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f45000h;

    /* renamed from: i  reason: collision with root package name */
    public static d.a.i0.a.y0.k.g.a f45001i;
    public static boolean j;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f45002a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.i0.a.y0.k.g.a> f45003b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f45004c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.v2.e1.b<Integer> f45005d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.g1.h f45006e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.t0.a f45007f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.a.i0.a.t0.a {
        public a() {
        }

        @Override // d.a.i0.a.t0.a, d.a.i0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4 && k.this.f45005d != null && k.this.g()) {
                k.this.f45005d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static k e() {
        if (f45000h == null) {
            synchronized (k.class) {
                if (f45000h == null) {
                    f45000h = new k();
                }
            }
        }
        return f45000h;
    }

    public void b(d.a.i0.a.y0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f45003b.put(aVar.c(), aVar);
    }

    public void c() {
        d.a.i0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
        f45001i = null;
        j = false;
    }

    public d.a.i0.a.y0.k.g.a d() {
        if (f44999g && f45001i != null) {
            Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + f45001i.c());
        }
        return f45001i;
    }

    public boolean f() {
        boolean z = true;
        z = (!(d() != null && d().j0() == null) || j) ? false : false;
        d.a.i0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
        return z;
    }

    public boolean g() {
        int i2 = this.f45004c;
        return i2 == 90 || i2 == -90;
    }

    public void h() {
        d.a.i0.a.v2.e1.b<Integer> bVar;
        if (g() && (bVar = this.f45005d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        if (g()) {
            if (f44999g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.a.i0.a.z1.b.a.f();
            d.a.i0.a.z1.b.a.k(true);
        } else if (f44999g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f44999g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.a.i0.a.y0.k.g.a> hashMap = this.f45003b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f45003b.keySet()) {
            if (str2.equals(str)) {
                if (f44999g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.a.i0.a.y0.k.g.a aVar = this.f45003b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.T().c(aVar.c());
                }
            }
        }
    }

    public void k(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f45002a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void l() {
        d.a.i0.a.g1.f.V().getActivity().registerCallback(this.f45007f);
    }

    public void m() {
        synchronized (this) {
            w();
            v();
            this.f45002a = null;
            this.f45003b.clear();
            this.f45005d = null;
        }
        f45000h = null;
    }

    public void n(d.a.i0.a.y0.k.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            d.a.i0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f45001i = null;
            j = false;
        }
    }

    public void o() {
        this.f45005d = null;
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap = this.f45002a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f45002a.keySet().size();
            if (f44999g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f45003b.remove(str);
    }

    public void r() {
        d.a.i0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
        j = true;
    }

    public void s(d.a.i0.a.y0.k.g.a aVar) {
        if (f44999g) {
            Log.i("SwanInlinePlayerManager", "setCacheVideo: " + aVar.toString());
        }
        f45001i = aVar;
    }

    public void t(int i2) {
        this.f45004c = i2;
    }

    public void u(d.a.i0.a.v2.e1.b<Integer> bVar) {
        this.f45005d = bVar;
    }

    public void v() {
        SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
        d.a.i0.a.t0.a aVar = this.f45007f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void w() {
        d.a.i0.a.g1.h hVar = this.f45006e;
        if (hVar != null) {
            d.a.i0.a.g1.i.f(hVar);
            this.f45006e = null;
        }
    }
}
