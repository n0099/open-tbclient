package d.a.h0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.swan.apps.SwanAppActivity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44295g = d.a.h0.a.k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f44296h;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f44297a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.h0.a.s0.k.g.a> f44298b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f44299c = -1;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.i2.u0.b<Integer> f44300d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.z0.h f44301e = null;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.o0.a f44302f = new a();

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.a.o0.a {
        public a() {
        }

        @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4 && j.this.f44300d != null && j.this.d()) {
                j.this.f44300d.onCallback(1);
                return true;
            }
            return false;
        }
    }

    public static j c() {
        if (f44296h == null) {
            synchronized (j.class) {
                if (f44296h == null) {
                    f44296h = new j();
                }
            }
        }
        return f44296h;
    }

    public void b(d.a.h0.a.s0.k.g.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.b())) {
            return;
        }
        this.f44298b.put(aVar.b(), aVar);
    }

    public boolean d() {
        int i2 = this.f44299c;
        return i2 == 90 || i2 == -90;
    }

    public void e() {
        d.a.h0.a.i2.u0.b<Integer> bVar;
        if (d() && (bVar = this.f44300d) != null) {
            bVar.onCallback(0);
        }
    }

    public void f() {
        if (d()) {
            if (f44295g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
            }
            d.a.h0.a.q1.b.a.f();
            d.a.h0.a.q1.b.a.k(true);
        } else if (f44295g) {
            Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            if (f44295g) {
                Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                return;
            }
            return;
        }
        HashMap<String, d.a.h0.a.s0.k.g.a> hashMap = this.f44298b;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.f44298b.keySet()) {
            if (str2.equals(str)) {
                if (f44295g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                }
            } else {
                d.a.h0.a.s0.k.g.a aVar = this.f44298b.get(str2);
                if (aVar != null) {
                    aVar.pause();
                    aVar.N().c(aVar.b());
                }
            }
        }
    }

    public void h(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.f44297a;
        if (hashMap != null) {
            hashMap.put(str, Boolean.valueOf(z));
        }
    }

    public void i() {
        d.a.h0.a.z0.f.V().getActivity().registerCallback(this.f44302f);
    }

    public void j() {
        synchronized (this) {
            q();
            p();
            this.f44297a = null;
            this.f44298b.clear();
            this.f44300d = null;
        }
        f44296h = null;
    }

    public void k() {
        this.f44300d = null;
    }

    public void l(String str) {
        HashMap<String, Boolean> hashMap = this.f44297a;
        if (hashMap != null) {
            hashMap.remove(str);
            int size = this.f44297a.keySet().size();
            if (f44295g) {
                Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
            }
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44298b.remove(str);
    }

    public void n(int i2) {
        this.f44299c = i2;
    }

    public void o(d.a.h0.a.i2.u0.b<Integer> bVar) {
        this.f44300d = bVar;
    }

    public void p() {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        d.a.h0.a.o0.a aVar = this.f44302f;
        if (aVar == null || activity == null) {
            return;
        }
        activity.unregisterCallback(aVar);
    }

    public void q() {
        d.a.h0.a.z0.h hVar = this.f44301e;
        if (hVar != null) {
            d.a.h0.a.z0.i.f(hVar);
            this.f44301e = null;
        }
    }
}
