package d.b.g0.a.o1;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.g0.a.p.c.m0;
import d.b.g0.a.r1.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.e;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static a f45428a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f45429b = new c();

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes2.dex */
    public static final class b<MsgType> implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f45430e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public final void onCallback(h<JSONObject> it) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f46808a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f45429b.b();
                if (optJSONObject != null) {
                    String openId = optJSONObject.optString("openid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f45429b.c(null, openId);
                        return;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(openId, "openId");
                    d e2 = d.e();
                    Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
                    String appId = e2.getAppId();
                    m0 k = d.b.g0.a.w0.a.k();
                    Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
                    b2.a(openId, appId, k.g());
                }
            }
        }
    }

    /* renamed from: d.b.g0.a.o1.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0751c<MsgType> implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final C0751c f45431e = new C0751c();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public final void onCallback(h<JSONObject> it) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f46808a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f45429b.b();
                if (optJSONObject != null) {
                    String swanId = optJSONObject.optString("swanid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f45429b.c(swanId, null);
                        return;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(swanId, "swanId");
                    d e2 = d.e();
                    Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
                    String appId = e2.getAppId();
                    m0 k = d.b.g0.a.w0.a.k();
                    Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
                    b2.b(swanId, appId, k.g());
                }
            }
        }
    }

    public final a b() {
        return f45428a;
    }

    public final void c(String str, String str2) {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.b.g0.a.n1.c.e.a q = e2.q();
        if (q != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            d e3 = d.e();
            Intrinsics.checkExpressionValueIsNotNull(e3, "Swan.get()");
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, e3.getAppId());
            m0 k = d.b.g0.a.w0.a.k();
            Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", k.g());
            q.I(bundle, d.b.g0.a.o1.b.class);
        }
    }

    public final void d() {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.b.g0.a.p.a o = e2.o();
        Intrinsics.checkExpressionValueIsNotNull(o, "Swan.get().adaptationProducer");
        d.b.g0.a.v1.c.i.d f2 = o.a().a().f(d.e());
        f2.p(b.f45430e);
        f2.a();
    }

    public final void e() {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.b.g0.a.p.a o = e2.o();
        Intrinsics.checkExpressionValueIsNotNull(o, "Swan.get().adaptationProducer");
        e d2 = o.a().a().d(d.e());
        d2.p(C0751c.f45431e);
        d2.a();
    }
}
