package d.a.n0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.v2.d0;
import d.a.n0.a.v2.o0;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f47660f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f47661g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f47662a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f47663b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f47664c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47665d;

    /* renamed from: e  reason: collision with root package name */
    public String f47666e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231499496, "Ld/a/n0/a/u/e/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231499496, "Ld/a/n0/a/u/e/j/b;");
                return;
            }
        }
        boolean z = k.f45831a;
        f47660f = String.format("%s/ma/call", d.a.n0.a.d0.a.d());
        f47661g = d.a.n0.a.n1.f.f46325a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47662a = f47660f + "?";
        this.f47663b = new HashMap();
        this.f47664c = new HashMap();
        this.f47665d = false;
        this.f47666e = "";
        d();
        e();
    }

    public final void a() {
        d.a.n0.a.a2.e Q;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = d.a.n0.a.a2.e.Q()) == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f47664c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (Q = d.a.n0.a.a2.e.Q()) == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.n0.a.m2.b.i(d.a.n0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f47664c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f47664c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f47665d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.f47662a, this.f47664c);
            this.f47662a = b2;
            this.f47662a = d.a.n0.a.d0.c.b(b2);
            d.a.n0.m.d.a aVar = new d.a.n0.m.d.a(this.f47662a, RequestBody.create(f47661g, this.f47666e), responseCallback);
            aVar.f50595c = this.f47663b;
            aVar.f50599g = true;
            d.a.n0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f47664c.get("service"));
            d.a.n0.m.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.a.n0.d.c.a() == null) {
                d.a.n0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f47664c.put("host_os", d.a.n0.t.a.f());
            this.f47664c.put("host_os_ver", d.a.n0.t.a.g());
            this.f47664c.put("host_app", d.a.n0.d.c.a().c());
            this.f47664c.put("host_app_ver", d.a.n0.d.c.a().i());
            this.f47664c.put("sdk_ver", d.a.n0.d.c.a().b());
            this.f47664c.put("ua", d.a.n0.t.i.b(d.a.n0.d.c.a().i()));
            this.f47664c.put("ut", d.a.n0.a.d0.c.f());
            this.f47664c.put("network", d.a.n0.t.a.e());
            this.f47664c.put("bundle_Id", d.a.n0.a.a2.d.g().getAppId());
            this.f47664c.put("cuid", d.a.n0.d.c.a().h());
            this.f47664c.put("uuid", d.a.n0.d.c.a().e());
            Map<String, String> map = this.f47664c;
            map.put("sid", d.a.n0.a.c1.a.Z().k() + "");
            this.f47664c.put("source", "swan_sdk");
            this.f47664c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47663b.put("mnpunion", String.valueOf(d.a.n0.a.s.a.f.f47208d.f() ? 2 : 0));
            this.f47663b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f47666e = "";
            } else {
                this.f47666e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f47664c.put("service", str);
        this.f47665d = true;
    }
}
