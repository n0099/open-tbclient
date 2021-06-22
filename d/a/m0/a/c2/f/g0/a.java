package d.a.m0.a.c2.f.g0;

import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.m0.a.a2.h;
import d.a.m0.a.a2.i;
import d.a.m0.a.a2.m;
/* loaded from: classes3.dex */
public abstract class a extends m implements d.a.m0.a.v2.e1.b<i.a> {

    /* renamed from: f  reason: collision with root package name */
    public int f44814f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44815g;

    public a(h hVar) {
        super(hVar);
        this.f44814f = 0;
        this.f44815g = false;
    }

    public static void g(String str) {
        d.a.m0.a.v1.b.b E = d.a.m0.a.v1.b.c.E("swan_kill_to_client");
        E.J(str);
        E.L();
    }

    public static void h(String str, int i2) {
        if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
            a B = d.a.m0.a.a2.d.g().B();
            B.f44814f = i2;
            B.e(str);
            return;
        }
        d.a.m0.a.v1.b.b v = d.a.m0.a.v1.b.c.E("swan_forbidden_kill_on_server").y("mAppId", str).v("ipc_forbidden_flag", i2);
        v.K(true);
        v.L();
    }

    public abstract void e(String str);

    public void f() {
        if (this.f44815g) {
            return;
        }
        d.a.m0.a.a2.b bVar = new d.a.m0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f44815g = true;
    }
}
