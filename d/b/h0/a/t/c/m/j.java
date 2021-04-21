package d.b.h0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46908g = d.b.h0.a.k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f46909h;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46910a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.b.h0.a.s0.k.g.a> f46911b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f46912c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.i2.u0.b<Integer> f46913d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.z0.h f46914e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.a.o0.a f46915f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.b.h0.a.o0.a {
        public a() {
        }

        @Override // d.b.h0.a.o0.a, d.b.h0.a.o0.b
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && j.this.f46913d != null && j.this.d()) {
                j.this.f46913d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static j c() {
        if (f46909h == null) {
            synchronized (j.class) {
                if (f46909h == null) {
                    f46909h = new j();
                }
            }
        }
        return f46909h;
    }

    public void b(d.b.h0.a.s0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f46911b.put(aVar.c(), aVar);
    }

    public boolean d() {
        int i = this.f46912c;
        return i == 90 || i == -90;
    }

    public void e() {
        d.b.h0.a.i2.u0.b<Integer> bVar;
        if (d() && (bVar = this.f46913d) != null) {
            bVar.onCallback(0);
        }
    }

    public void f() {
        if (d()) {
            if (f46908g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.b.h0.a.q1.b.a.f();
            d.b.h0.a.q1.b.a.k(true);
        } else if (f46908g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f46908g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.b.h0.a.s0.k.g.a> hashMap = this.f46911b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f46911b.keySet()) {
            if (str2.equals(str)) {
                if (f46908g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.b.h0.a.s0.k.g.a aVar = this.f46911b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.t().b(aVar.c());
                }
            }
        }
    }

    public void h(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f46910a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void i() {
        d.b.h0.a.z0.f.V().getActivity().registerCallback(this.f46915f);
    }

    public void j() {
        synchronized (this) {
            q();
            p();
            this.f46910a = null;
            this.f46911b.clear();
            this.f46913d = null;
        }
        f46909h = null;
    }

    public void k() {
        this.f46913d = null;
    }

    public void l(String str) {
        HashMap<String, Boolean> hashMap = this.f46910a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f46910a.keySet().size();
            if (f46908g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46911b.remove(str);
    }

    public void n(int i) {
        this.f46912c = i;
    }

    public void o(d.b.h0.a.i2.u0.b<Integer> bVar) {
        this.f46913d = bVar;
    }

    public void p() {
        SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
        d.b.h0.a.o0.a aVar = this.f46915f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void q() {
        d.b.h0.a.z0.h hVar = this.f46914e;
        if (hVar != null) {
            d.b.h0.a.z0.i.f(hVar);
            this.f46914e = null;
        }
    }
}
