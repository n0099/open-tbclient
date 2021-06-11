package d.a.l0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
import d.a.l0.a.v2.d0;
import d.a.l0.a.v2.o0;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f48708f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f48709g;

    /* renamed from: a  reason: collision with root package name */
    public String f48710a = f48708f + "?";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f48711b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48712c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f48713d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f48714e = "";

    static {
        boolean z = k.f46875a;
        f48708f = String.format("%s/ma/call", d.a.l0.a.d0.a.d());
        f48709g = d.a.l0.a.n1.f.f47369a;
    }

    public b() {
        d();
        e();
    }

    public final void a() {
        PMSAppInfo f0;
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f48712c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.l0.a.m2.b.i(d.a.l0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f48712c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f48712c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        if (!this.f48713d) {
            responseCallback.onFail(new InvalidParameterException("no service has been set"));
            return;
        }
        String b2 = o0.b(this.f48710a, this.f48712c);
        this.f48710a = b2;
        this.f48710a = d.a.l0.a.d0.c.b(b2);
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(this.f48710a, RequestBody.create(f48709g, this.f48714e), responseCallback);
        aVar.f51645c = this.f48711b;
        aVar.f51649g = true;
        d.a.l0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f48712c.get("service"));
        d.a.l0.m.e.a.g().e(aVar);
    }

    public final void d() {
        if (d.a.l0.d.c.a() == null) {
            d.a.l0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
            return;
        }
        this.f48712c.put("host_os", d.a.l0.t.a.f());
        this.f48712c.put("host_os_ver", d.a.l0.t.a.g());
        this.f48712c.put("host_app", d.a.l0.d.c.a().c());
        this.f48712c.put("host_app_ver", d.a.l0.d.c.a().i());
        this.f48712c.put("sdk_ver", d.a.l0.d.c.a().b());
        this.f48712c.put("ua", d.a.l0.t.i.b(d.a.l0.d.c.a().i()));
        this.f48712c.put("ut", d.a.l0.a.d0.c.f());
        this.f48712c.put("network", d.a.l0.t.a.e());
        this.f48712c.put("bundle_Id", d.a.l0.a.a2.d.g().getAppId());
        this.f48712c.put("cuid", d.a.l0.d.c.a().h());
        this.f48712c.put("uuid", d.a.l0.d.c.a().e());
        Map<String, String> map = this.f48712c;
        map.put("sid", d.a.l0.a.c1.a.Z().k() + "");
        this.f48712c.put("source", "swan_sdk");
        this.f48712c.put("timestamp", String.valueOf(System.currentTimeMillis()));
        b();
        a();
    }

    public final void e() {
        this.f48711b.put("mnpunion", String.valueOf(d.a.l0.a.s.a.f.f48256d.f() ? 2 : 0));
        this.f48711b.put("Referer", d0.b());
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f48714e = "";
        } else {
            this.f48714e = jSONObject.toString();
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48712c.put("service", str);
        this.f48713d = true;
    }
}
