package d.b.g0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46579g = d.b.g0.a.k.f45443a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f46580h;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46581a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.b.g0.a.s0.k.g.a> f46582b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f46583c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<Integer> f46584d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.z0.h f46585e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.o0.a f46586f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.a.o0.a {
        public a() {
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.f46584d != null && j.this.d()) {
                j.this.f46584d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static j c() {
        if (f46580h == null) {
            synchronized (j.class) {
                if (f46580h == null) {
                    f46580h = new j();
                }
            }
        }
        return f46580h;
    }

    public void b(d.b.g0.a.s0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f46582b.put(aVar.c(), aVar);
    }

    public boolean d() {
        int i = this.f46583c;
        return i == 90 || i == -90;
    }

    public void e() {
        d.b.g0.a.i2.u0.b<Integer> bVar;
        if (d() && (bVar = this.f46584d) != null) {
            bVar.onCallback(0);
        }
    }

    public void f() {
        if (d()) {
            if (f46579g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.b.g0.a.q1.b.a.f();
            d.b.g0.a.q1.b.a.k(true);
        } else if (f46579g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46579g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.b.g0.a.s0.k.g.a> hashMap = this.f46582b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f46582b.keySet()) {
            if (str2.equals(str)) {
                if (f46579g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.b.g0.a.s0.k.g.a aVar = this.f46582b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.t().b(aVar.c());
                }
            }
        }
    }

    public void h(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f46581a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void i() {
        d.b.g0.a.z0.f.V().getActivity().registerCallback(this.f46586f);
    }

    public void j() {
        synchronized (this) {
            q();
            p();
            this.f46581a = null;
            this.f46582b.clear();
            this.f46584d = null;
        }
        f46580h = null;
    }

    public void k() {
        this.f46584d = null;
    }

    public void l(String str) {
        HashMap<String, Boolean> hashMap = this.f46581a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f46581a.keySet().size();
            if (f46579g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46582b.remove(str);
    }

    public void n(int i) {
        this.f46583c = i;
    }

    public void o(d.b.g0.a.i2.u0.b<Integer> bVar) {
        this.f46584d = bVar;
    }

    public void p() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        d.b.g0.a.o0.a aVar = this.f46586f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void q() {
        d.b.g0.a.z0.h hVar = this.f46585e;
        if (hVar != null) {
            d.b.g0.a.z0.i.f(hVar);
            this.f46585e = null;
        }
    }
}
