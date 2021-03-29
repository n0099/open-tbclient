package d.b.g0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46187g = d.b.g0.a.k.f45051a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f46188h;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46189a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.b.g0.a.s0.k.g.a> f46190b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f46191c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<Integer> f46192d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.z0.h f46193e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.o0.a f46194f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.a.o0.a {
        public a() {
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.f46192d != null && j.this.d()) {
                j.this.f46192d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static j c() {
        if (f46188h == null) {
            synchronized (j.class) {
                if (f46188h == null) {
                    f46188h = new j();
                }
            }
        }
        return f46188h;
    }

    public void b(d.b.g0.a.s0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f46190b.put(aVar.c(), aVar);
    }

    public boolean d() {
        int i = this.f46191c;
        return i == 90 || i == -90;
    }

    public void e() {
        d.b.g0.a.i2.u0.b<Integer> bVar;
        if (d() && (bVar = this.f46192d) != null) {
            bVar.onCallback(0);
        }
    }

    public void f() {
        if (d()) {
            if (f46187g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.b.g0.a.q1.b.a.f();
            d.b.g0.a.q1.b.a.k(true);
        } else if (f46187g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46187g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.b.g0.a.s0.k.g.a> hashMap = this.f46190b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f46190b.keySet()) {
            if (str2.equals(str)) {
                if (f46187g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.b.g0.a.s0.k.g.a aVar = this.f46190b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.t().b(aVar.c());
                }
            }
        }
    }

    public void h(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f46189a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void i() {
        d.b.g0.a.z0.f.V().getActivity().registerCallback(this.f46194f);
    }

    public void j() {
        synchronized (this) {
            q();
            p();
            this.f46189a = null;
            this.f46190b.clear();
            this.f46192d = null;
        }
        f46188h = null;
    }

    public void k() {
        this.f46192d = null;
    }

    public void l(String str) {
        HashMap<String, Boolean> hashMap = this.f46189a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f46189a.keySet().size();
            if (f46187g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46190b.remove(str);
    }

    public void n(int i) {
        this.f46191c = i;
    }

    public void o(d.b.g0.a.i2.u0.b<Integer> bVar) {
        this.f46192d = bVar;
    }

    public void p() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        d.b.g0.a.o0.a aVar = this.f46194f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void q() {
        d.b.g0.a.z0.h hVar = this.f46193e;
        if (hVar != null) {
            d.b.g0.a.z0.i.f(hVar);
            this.f46193e = null;
        }
    }
}
