package d.a.l0.a.s.a;

import android.os.Bundle;
import d.a.l0.a.j2.k;
import d.a.l0.a.p.d.x0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.l0.a.m.a f48253a;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.l0.a.m.c f48254b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f48255c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f48256d;

    static {
        f fVar = new f();
        f48256d = fVar;
        Intrinsics.checkNotNullExpressionValue(fVar.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
    }

    public final void a(String value, String ceresId) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(ceresId, "ceresId");
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46862b = g.h();
        eVar.f46865e = value;
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
        eVar.a("appkey", g2.getAppId());
        k.v(g.g(), ceresId, eVar);
    }

    public final void b() {
        d.f48251a.b();
        h.f48267b.d();
        j(false);
    }

    public final boolean c() {
        return f48255c;
    }

    public final d.a.l0.a.m.a d() {
        return f48253a;
    }

    public final d.a.l0.a.m.c e() {
        return f48254b;
    }

    public final boolean f() {
        if (g.i() == null) {
            k();
        }
        Boolean i2 = g.i();
        Intrinsics.checkNotNull(i2);
        return i2.booleanValue();
    }

    public final boolean g() {
        if (g.i() == null) {
            k();
        }
        if (!Intrinsics.areEqual(g.i(), Boolean.FALSE)) {
            String a2 = d.f48251a.a();
            if (!(a2 == null || StringsKt__StringsJVMKt.isBlank(a2))) {
                String a3 = h.f48267b.a();
                if (!(a3 == null || StringsKt__StringsJVMKt.isBlank(a3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean h() {
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void i(d.a.l0.a.m.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (g.i() == null) {
            k();
        }
        Intrinsics.areEqual(g.i(), Boolean.FALSE);
        if (g()) {
            listener.onResult(0);
            return;
        }
        x0 m = d.a.l0.a.c1.a.m();
        Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
        String a2 = d.a.l0.t.i.a("https://ossapi.baidu.com/oss/static/open_source_login_v3.html", "hostName", m.a());
        d.a.l0.a.c1.d.k u0 = d.a.l0.a.c1.a.u0();
        Intrinsics.checkNotNull(u0);
        String a3 = d.a.l0.t.i.a(a2, "zid", u0.a(d.a.l0.a.c1.a.b()));
        x0 m2 = d.a.l0.a.c1.a.m();
        Intrinsics.checkNotNullExpressionValue(m2, "SwanAppRuntime.getConfig()");
        String a4 = d.a.l0.t.i.a(a3, "appKey", m2.b());
        d.a.l0.a.h0.g.k.Q2("allianceLogin", d.a.l0.a.l1.b.e(a4, a4));
        f48253a = listener;
        f48255c = false;
        a(g.e(), g.b());
    }

    public final void j(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("status", z);
        d.a.l0.a.v1.b.d.a(c.class, bundle);
    }

    public final void k() {
        Boolean bool;
        try {
            Intrinsics.checkNotNullExpressionValue(Class.forName("com.baidu.sapi2.SapiAccountManager"), "Class.forName(\"com.baidu…api2.SapiAccountManager\")");
            bool = Boolean.FALSE;
        } catch (ClassNotFoundException unused) {
            bool = Boolean.TRUE;
        }
        g.j(bool);
    }

    public final void l(boolean z) {
        f48255c = z;
    }

    public final void m(d.a.l0.a.m.c cVar) {
        f48254b = cVar;
    }
}
