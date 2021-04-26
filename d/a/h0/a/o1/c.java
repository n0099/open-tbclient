package d.a.h0.a.o1;

import android.os.Bundle;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.h0.a.p.c.m0;
import d.a.h0.a.r1.d;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.e;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static a f43496a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f43497b = new c();

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public static final class b<MsgType> implements d.a.h0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final b f43498e = new b();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public final void onCallback(h<JSONObject> it) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f44952a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f43497b.b();
                if (optJSONObject != null) {
                    String openId = optJSONObject.optString("openid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f43497b.c(null, openId);
                        return;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(openId, "openId");
                    d e2 = d.e();
                    Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
                    String appId = e2.getAppId();
                    m0 k = d.a.h0.a.w0.a.k();
                    Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
                    b2.a(openId, appId, k.f());
                }
            }
        }
    }

    /* renamed from: d.a.h0.a.o1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0722c<MsgType> implements d.a.h0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public static final C0722c f43499e = new C0722c();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public final void onCallback(h<JSONObject> it) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            if (it.c()) {
                JSONObject jSONObject = it.f44952a;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a b2 = c.f43497b.b();
                if (optJSONObject != null) {
                    String swanId = optJSONObject.optString("swanid");
                    if (b2 == null || !ProcessUtils.isMainProcess()) {
                        c.f43497b.c(swanId, null);
                        return;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(swanId, "swanId");
                    d e2 = d.e();
                    Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
                    String appId = e2.getAppId();
                    m0 k = d.a.h0.a.w0.a.k();
                    Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
                    b2.b(swanId, appId, k.f());
                }
            }
        }
    }

    public final a b() {
        return f43496a;
    }

    public final void c(String str, String str2) {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.a.h0.a.n1.c.e.a x = e2.x();
        if (x != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            d e3 = d.e();
            Intrinsics.checkExpressionValueIsNotNull(e3, "Swan.get()");
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, e3.getAppId());
            m0 k = d.a.h0.a.w0.a.k();
            Intrinsics.checkExpressionValueIsNotNull(k, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", k.f());
            x.I(bundle, d.a.h0.a.o1.b.class);
        }
    }

    public final void d() {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.a.h0.a.p.a w = e2.w();
        Intrinsics.checkExpressionValueIsNotNull(w, "Swan.get().adaptationProducer");
        d.a.h0.a.v1.c.i.d f2 = w.a().b().f(d.e());
        f2.p(b.f43498e);
        f2.a();
    }

    public final void e() {
        d e2 = d.e();
        Intrinsics.checkExpressionValueIsNotNull(e2, "Swan.get()");
        d.a.h0.a.p.a w = e2.w();
        Intrinsics.checkExpressionValueIsNotNull(w, "Swan.get().adaptationProducer");
        e e3 = w.a().b().e(d.e());
        e3.p(C0722c.f43499e);
        e3.a();
    }
}
