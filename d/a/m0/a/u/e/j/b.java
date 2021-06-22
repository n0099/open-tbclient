package d.a.m0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.k;
import d.a.m0.a.v2.d0;
import d.a.m0.a.v2.o0;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f48816f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f48817g;

    /* renamed from: a  reason: collision with root package name */
    public String f48818a = f48816f + "?";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f48819b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48820c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f48821d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f48822e = "";

    static {
        boolean z = k.f46983a;
        f48816f = String.format("%s/ma/call", d.a.m0.a.d0.a.d());
        f48817g = d.a.m0.a.n1.f.f47477a;
    }

    public b() {
        d();
        e();
    }

    public final void a() {
        PMSAppInfo f0;
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f48820c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.m0.a.m2.b.i(d.a.m0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f48820c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f48820c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        if (!this.f48821d) {
            responseCallback.onFail(new InvalidParameterException("no service has been set"));
            return;
        }
        String b2 = o0.b(this.f48818a, this.f48820c);
        this.f48818a = b2;
        this.f48818a = d.a.m0.a.d0.c.b(b2);
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(this.f48818a, RequestBody.create(f48817g, this.f48822e), responseCallback);
        aVar.f51753c = this.f48819b;
        aVar.f51757g = true;
        d.a.m0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f48820c.get("service"));
        d.a.m0.m.e.a.g().e(aVar);
    }

    public final void d() {
        if (d.a.m0.d.c.a() == null) {
            d.a.m0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
            return;
        }
        this.f48820c.put("host_os", d.a.m0.t.a.f());
        this.f48820c.put("host_os_ver", d.a.m0.t.a.g());
        this.f48820c.put("host_app", d.a.m0.d.c.a().c());
        this.f48820c.put("host_app_ver", d.a.m0.d.c.a().i());
        this.f48820c.put("sdk_ver", d.a.m0.d.c.a().b());
        this.f48820c.put("ua", d.a.m0.t.i.b(d.a.m0.d.c.a().i()));
        this.f48820c.put("ut", d.a.m0.a.d0.c.f());
        this.f48820c.put("network", d.a.m0.t.a.e());
        this.f48820c.put("bundle_Id", d.a.m0.a.a2.d.g().getAppId());
        this.f48820c.put("cuid", d.a.m0.d.c.a().h());
        this.f48820c.put("uuid", d.a.m0.d.c.a().e());
        Map<String, String> map = this.f48820c;
        map.put("sid", d.a.m0.a.c1.a.Z().k() + "");
        this.f48820c.put("source", "swan_sdk");
        this.f48820c.put("timestamp", String.valueOf(System.currentTimeMillis()));
        b();
        a();
    }

    public final void e() {
        this.f48819b.put("mnpunion", String.valueOf(d.a.m0.a.s.a.f.f48364d.f() ? 2 : 0));
        this.f48819b.put("Referer", d0.b());
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f48822e = "";
        } else {
            this.f48822e = jSONObject.toString();
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f48820c.put("service", str);
        this.f48821d = true;
    }
}
