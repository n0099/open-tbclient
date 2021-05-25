package d.a.l0.a.u.e.o;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45175g = d.a.l0.a.k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f45176h;

    /* renamed from: i  reason: collision with root package name */
    public static d.a.l0.a.y0.k.g.a f45177i;
    public static boolean j;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f45178a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.l0.a.y0.k.g.a> f45179b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f45180c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<Integer> f45181d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.g1.h f45182e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.t0.a f45183f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.a.l0.a.t0.a {
        public a() {
        }

        @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4 && k.this.f45181d != null && k.this.g()) {
                k.this.f45181d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static k e() {
        if (f45176h == null) {
            synchronized (k.class) {
                if (f45176h == null) {
                    f45176h = new k();
                }
            }
        }
        return f45176h;
    }

    public void b(d.a.l0.a.y0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f45179b.put(aVar.c(), aVar);
    }

    public void c() {
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
        f45177i = null;
        j = false;
    }

    public d.a.l0.a.y0.k.g.a d() {
        if (f45175g && f45177i != null) {
            Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + f45177i.c());
        }
        return f45177i;
    }

    public boolean f() {
        boolean z = true;
        z = (!(d() != null && d().j0() == null) || j) ? false : false;
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
        return z;
    }

    public boolean g() {
        int i2 = this.f45180c;
        return i2 == 90 || i2 == -90;
    }

    public void h() {
        d.a.l0.a.v2.e1.b<Integer> bVar;
        if (g() && (bVar = this.f45181d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        if (g()) {
            if (f45175g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.a.l0.a.z1.b.a.f();
            d.a.l0.a.z1.b.a.k(true);
        } else if (f45175g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f45175g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.a.l0.a.y0.k.g.a> hashMap = this.f45179b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f45179b.keySet()) {
            if (str2.equals(str)) {
                if (f45175g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.a.l0.a.y0.k.g.a aVar = this.f45179b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.T().c(aVar.c());
                }
            }
        }
    }

    public void k(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f45178a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void l() {
        d.a.l0.a.g1.f.V().getActivity().registerCallback(this.f45183f);
    }

    public void m() {
        synchronized (this) {
            w();
            v();
            this.f45178a = null;
            this.f45179b.clear();
            this.f45181d = null;
        }
        f45176h = null;
    }

    public void n(d.a.l0.a.y0.k.g.a aVar) {
        if (aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f45177i = null;
            j = false;
        }
    }

    public void o() {
        this.f45181d = null;
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap = this.f45178a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f45178a.keySet().size();
            if (f45175g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f45179b.remove(str);
    }

    public void r() {
        d.a.l0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
        j = true;
    }

    public void s(d.a.l0.a.y0.k.g.a aVar) {
        if (f45175g) {
            Log.i("SwanInlinePlayerManager", "setCacheVideo: " + aVar.toString());
        }
        f45177i = aVar;
    }

    public void t(int i2) {
        this.f45180c = i2;
    }

    public void u(d.a.l0.a.v2.e1.b<Integer> bVar) {
        this.f45181d = bVar;
    }

    public void v() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        d.a.l0.a.t0.a aVar = this.f45183f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void w() {
        d.a.l0.a.g1.h hVar = this.f45182e;
        if (hVar != null) {
            d.a.l0.a.g1.i.f(hVar);
            this.f45182e = null;
        }
    }
}
