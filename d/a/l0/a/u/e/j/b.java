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
    public static final String f45034f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f45035g;

    /* renamed from: a  reason: collision with root package name */
    public String f45036a = f45034f + "?";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f45037b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f45038c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f45039d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f45040e = "";

    static {
        boolean z = k.f43199a;
        f45034f = String.format("%s/ma/call", d.a.l0.a.d0.a.d());
        f45035g = d.a.l0.a.n1.f.f43693a;
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
        this.f45038c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.l0.a.m2.b.i(d.a.l0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f45038c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f45038c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        if (!this.f45039d) {
            responseCallback.onFail(new InvalidParameterException("no service has been set"));
            return;
        }
        String b2 = o0.b(this.f45036a, this.f45038c);
        this.f45036a = b2;
        this.f45036a = d.a.l0.a.d0.c.b(b2);
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(this.f45036a, RequestBody.create(f45035g, this.f45040e), responseCallback);
        aVar.f47971c = this.f45037b;
        aVar.f47975g = true;
        d.a.l0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f45038c.get("service"));
        d.a.l0.m.e.a.g().e(aVar);
    }

    public final void d() {
        if (d.a.l0.d.c.a() == null) {
            d.a.l0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
            return;
        }
        this.f45038c.put("host_os", d.a.l0.t.a.f());
        this.f45038c.put("host_os_ver", d.a.l0.t.a.g());
        this.f45038c.put("host_app", d.a.l0.d.c.a().c());
        this.f45038c.put("host_app_ver", d.a.l0.d.c.a().i());
        this.f45038c.put("sdk_ver", d.a.l0.d.c.a().b());
        this.f45038c.put("ua", d.a.l0.t.i.b(d.a.l0.d.c.a().i()));
        this.f45038c.put("ut", d.a.l0.a.d0.c.f());
        this.f45038c.put("network", d.a.l0.t.a.e());
        this.f45038c.put("bundle_Id", d.a.l0.a.a2.d.g().getAppId());
        this.f45038c.put("cuid", d.a.l0.d.c.a().h());
        this.f45038c.put("uuid", d.a.l0.d.c.a().e());
        Map<String, String> map = this.f45038c;
        map.put("sid", d.a.l0.a.c1.a.Z().k() + "");
        this.f45038c.put("source", "swan_sdk");
        this.f45038c.put("timestamp", String.valueOf(System.currentTimeMillis()));
        b();
        a();
    }

    public final void e() {
        this.f45037b.put("mnpunion", String.valueOf(d.a.l0.a.s.a.f.f44582d.f() ? 2 : 0));
        this.f45037b.put("Referer", d0.b());
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f45040e = "";
        } else {
            this.f45040e = jSONObject.toString();
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f45038c.put("service", str);
        this.f45039d = true;
    }
}
