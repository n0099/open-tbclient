package d.a.i0.a.c2.f.g0;

import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.i0.a.a2.h;
import d.a.i0.a.a2.i;
import d.a.i0.a.a2.m;
/* loaded from: classes3.dex */
public abstract class a extends m implements d.a.i0.a.v2.e1.b<i.a> {

    /* renamed from: f  reason: collision with root package name */
    public int f40856f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40857g;

    public a(h hVar) {
        super(hVar);
        this.f40856f = 0;
        this.f40857g = false;
    }

    public static void g(String str) {
        d.a.i0.a.v1.b.b E = d.a.i0.a.v1.b.c.E("swan_kill_to_client");
        E.J(str);
        E.L();
    }

    public static void h(String str, int i2) {
        if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
            a B = d.a.i0.a.a2.d.g().B();
            B.f40856f = i2;
            B.e(str);
            return;
        }
        d.a.i0.a.v1.b.b v = d.a.i0.a.v1.b.c.E("swan_forbidden_kill_on_server").y("mAppId", str).v("ipc_forbidden_flag", i2);
        v.K(true);
        v.L();
    }

    public abstract void e(String str);

    public void f() {
        if (this.f40857g) {
            return;
        }
        d.a.i0.a.a2.b bVar = new d.a.i0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f40857g = true;
    }
}
