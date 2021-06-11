package d.a.l0.a.x1;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.l0.a.a2.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.e;
import d.a.l0.a.p.d.x0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static a f49434a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f49435b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f49436c = new c();

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public static final class b<MsgType> implements d.a.l0.a.v2.e1.b<i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f49437e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f45412a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f49436c.b();
                if (optJSONObject != null) {
                    String openId = optJSONObject.optString("openid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f49436c.d(null, openId);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(openId, "openId");
                    d g2 = d.g();
                    Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
                    String appId = g2.getAppId();
                    x0 m = d.a.l0.a.c1.a.m();
                    Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
                    b2.a(openId, appId, m.a());
                }
            }
        }
    }

    /* renamed from: d.a.l0.a.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0961c<MsgType> implements d.a.l0.a.v2.e1.b<i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final C0961c f49438e = new C0961c();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f45412a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f49436c.b();
                if (optJSONObject != null) {
                    String swanId = optJSONObject.optString("swanid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f49436c.d(swanId, null);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(swanId, "swanId");
                    d g2 = d.g();
                    Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
                    String appId = g2.getAppId();
                    x0 m = d.a.l0.a.c1.a.m();
                    Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
                    b2.b(swanId, appId, m.a());
                }
            }
        }
    }

    public final a b() {
        return f49434a;
    }

    public final boolean c() {
        return f49435b;
    }

    public final void d(String str, String str2) {
        d g2 = d.g();
        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
        d.a.l0.a.v1.c.e.a z = g2.z();
        if (z != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            d g3 = d.g();
            Intrinsics.checkNotNullExpressionValue(g3, "Swan.get()");
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g3.getAppId());
            x0 m = d.a.l0.a.c1.a.m();
            Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", m.a());
            z.K(bundle, d.a.l0.a.x1.b.class);
        }
    }

    public final void e() {
        d g2 = d.g();
        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
        d.a.l0.a.p.a y = g2.y();
        Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
        d.a.l0.a.e2.c.j.d f2 = y.a().b().f(d.g());
        f2.p(b.f49437e);
        f2.a();
    }

    public final void f() {
        d g2 = d.g();
        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
        d.a.l0.a.p.a y = g2.y();
        Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
        e e2 = y.a().b().e(d.g());
        e2.p(C0961c.f49438e);
        e2.a();
    }
}
