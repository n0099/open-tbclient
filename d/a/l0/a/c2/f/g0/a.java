package d.a.l0.a.c2.f.g0;

import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.h;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.m;
/* loaded from: classes3.dex */
public abstract class a extends m implements d.a.l0.a.v2.e1.b<i.a> {

    /* renamed from: f  reason: collision with root package name */
    public int f44706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44707g;

    public a(h hVar) {
        super(hVar);
        this.f44706f = 0;
        this.f44707g = false;
    }

    public static void g(String str) {
        d.a.l0.a.v1.b.b E = d.a.l0.a.v1.b.c.E("swan_kill_to_client");
        E.J(str);
        E.L();
    }

    public static void h(String str, int i2) {
        if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
            a B = d.a.l0.a.a2.d.g().B();
            B.f44706f = i2;
            B.e(str);
            return;
        }
        d.a.l0.a.v1.b.b v = d.a.l0.a.v1.b.c.E("swan_forbidden_kill_on_server").y("mAppId", str).v("ipc_forbidden_flag", i2);
        v.K(true);
        v.L();
    }

    public abstract void e(String str);

    public void f() {
        if (this.f44707g) {
            return;
        }
        d.a.l0.a.a2.b bVar = new d.a.l0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f44707g = true;
    }
}
