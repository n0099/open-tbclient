package d.a.i0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.k;
import d.a.i0.a.v2.d0;
import d.a.i0.a.v2.o0;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final String f44858f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f44859g;

    /* renamed from: a  reason: collision with root package name */
    public String f44860a = f44858f + "?";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f44861b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f44862c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f44863d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f44864e = "";

    static {
        boolean z = k.f43025a;
        f44858f = String.format("%s/ma/call", d.a.i0.a.d0.a.d());
        f44859g = d.a.i0.a.n1.f.f43519a;
    }

    public b() {
        d();
        e();
    }

    public final void a() {
        PMSAppInfo f0;
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f44862c.put("app_ver", String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.i0.a.m2.b.i(d.a.i0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f44862c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f44862c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        if (!this.f44863d) {
            responseCallback.onFail(new InvalidParameterException("no service has been set"));
            return;
        }
        String b2 = o0.b(this.f44860a, this.f44862c);
        this.f44860a = b2;
        this.f44860a = d.a.i0.a.d0.c.b(b2);
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(this.f44860a, RequestBody.create(f44859g, this.f44864e), responseCallback);
        aVar.f47795c = this.f44861b;
        aVar.f47799g = true;
        d.a.i0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f44862c.get("service"));
        d.a.i0.m.e.a.g().e(aVar);
    }

    public final void d() {
        if (d.a.i0.d.c.a() == null) {
            d.a.i0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
            return;
        }
        this.f44862c.put("host_os", d.a.i0.t.a.f());
        this.f44862c.put("host_os_ver", d.a.i0.t.a.g());
        this.f44862c.put("host_app", d.a.i0.d.c.a().c());
        this.f44862c.put("host_app_ver", d.a.i0.d.c.a().i());
        this.f44862c.put("sdk_ver", d.a.i0.d.c.a().b());
        this.f44862c.put("ua", d.a.i0.t.i.b(d.a.i0.d.c.a().i()));
        this.f44862c.put("ut", d.a.i0.a.d0.c.f());
        this.f44862c.put("network", d.a.i0.t.a.e());
        this.f44862c.put("bundle_Id", d.a.i0.a.a2.d.g().getAppId());
        this.f44862c.put("cuid", d.a.i0.d.c.a().h());
        this.f44862c.put("uuid", d.a.i0.d.c.a().e());
        Map<String, String> map = this.f44862c;
        map.put("sid", d.a.i0.a.c1.a.Z().k() + "");
        this.f44862c.put("source", "swan_sdk");
        this.f44862c.put("timestamp", String.valueOf(System.currentTimeMillis()));
        b();
        a();
    }

    public final void e() {
        this.f44861b.put("mnpunion", String.valueOf(d.a.i0.a.s.a.f.f44406d.f() ? 2 : 0));
        this.f44861b.put("Referer", d0.b());
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f44864e = "";
        } else {
            this.f44864e = jSONObject.toString();
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f44862c.put("service", str);
        this.f44863d = true;
    }
}
