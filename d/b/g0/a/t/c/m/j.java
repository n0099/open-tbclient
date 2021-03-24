package d.b.g0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46186g = d.b.g0.a.k.f45050a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f46187h;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46188a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.b.g0.a.s0.k.g.a> f46189b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f46190c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<Integer> f46191d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.z0.h f46192e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.o0.a f46193f = new a();

    /* loaded from: classes3.dex */
    public class a extends d.b.g0.a.o0.a {
        public a() {
        }

        @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.f46191d != null && j.this.d()) {
                j.this.f46191d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static j c() {
        if (f46187h == null) {
            synchronized (j.class) {
                if (f46187h == null) {
                    f46187h = new j();
                }
            }
        }
        return f46187h;
    }

    public void b(d.b.g0.a.s0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f46189b.put(aVar.c(), aVar);
    }

    public boolean d() {
        int i = this.f46190c;
        return i == 90 || i == -90;
    }

    public void e() {
        d.b.g0.a.i2.u0.b<Integer> bVar;
        if (d() && (bVar = this.f46191d) != null) {
            bVar.onCallback(0);
        }
    }

    public void f() {
        if (d()) {
            if (f46186g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.b.g0.a.q1.b.a.f();
            d.b.g0.a.q1.b.a.k(true);
        } else if (f46186g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46186g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.b.g0.a.s0.k.g.a> hashMap = this.f46189b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f46189b.keySet()) {
            if (str2.equals(str)) {
                if (f46186g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.b.g0.a.s0.k.g.a aVar = this.f46189b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.t().b(aVar.c());
                }
            }
        }
    }

    public void h(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f46188a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void i() {
        d.b.g0.a.z0.f.V().getActivity().registerCallback(this.f46193f);
    }

    public void j() {
        synchronized (this) {
            q();
            p();
            this.f46188a = null;
            this.f46189b.clear();
            this.f46191d = null;
        }
        f46187h = null;
    }

    public void k() {
        this.f46191d = null;
    }

    public void l(String str) {
        HashMap<String, Boolean> hashMap = this.f46188a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f46188a.keySet().size();
            if (f46186g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46189b.remove(str);
    }

    public void n(int i) {
        this.f46190c = i;
    }

    public void o(d.b.g0.a.i2.u0.b<Integer> bVar) {
        this.f46191d = bVar;
    }

    public void p() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        d.b.g0.a.o0.a aVar = this.f46193f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void q() {
        d.b.g0.a.z0.h hVar = this.f46192e;
        if (hVar != null) {
            d.b.g0.a.z0.i.f(hVar);
            this.f46192e = null;
        }
    }
}
