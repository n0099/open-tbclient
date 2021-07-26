package d.a.o0.a.u.e.j;

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
import d.a.o0.a.k;
import d.a.o0.a.v2.d0;
import d.a.o0.a.v2.o0;
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
    public static final String f48164f;

    /* renamed from: g  reason: collision with root package name */
    public static final MediaType f48165g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48166a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f48167b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f48168c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48169d;

    /* renamed from: e  reason: collision with root package name */
    public String f48170e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524902503, "Ld/a/o0/a/u/e/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1524902503, "Ld/a/o0/a/u/e/j/b;");
                return;
            }
        }
        boolean z = k.f46335a;
        f48164f = String.format("%s/ma/call", d.a.o0.a.d0.a.d());
        f48165g = d.a.o0.a.n1.f.f46829a;
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
        this.f48166a = f48164f + "?";
        this.f48167b = new HashMap();
        this.f48168c = new HashMap();
        this.f48169d = false;
        this.f48170e = "";
        d();
        e();
    }

    public final void a() {
        d.a.o0.a.a2.e Q;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = d.a.o0.a.a2.e.Q()) == null || (f0 = Q.L().f0()) == null) {
            return;
        }
        this.f48168c.put(IAdRequestParam.APV, String.valueOf(f0.versionCode));
    }

    public final void b() {
        d.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (Q = d.a.o0.a.a2.e.Q()) == null) {
            return;
        }
        int l = Q.l();
        String i2 = d.a.o0.a.m2.b.i(d.a.o0.a.g1.f.V().N(), l);
        if (l == 0) {
            this.f48168c.put("swan_ver", i2);
        } else if (l == 1) {
            this.f48168c.put("game_ver", i2);
        }
    }

    public void c(ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.f48169d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b2 = o0.b(this.f48166a, this.f48168c);
            this.f48166a = b2;
            this.f48166a = d.a.o0.a.d0.c.b(b2);
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(this.f48166a, RequestBody.create(f48165g, this.f48170e), responseCallback);
            aVar.f51099c = this.f48167b;
            aVar.f51103g = true;
            d.a.o0.a.e0.d.g("CallServiceRequest", "Start request cloud ability: " + this.f48168c.get("service"));
            d.a.o0.m.e.a.g().e(aVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.a.o0.d.c.a() == null) {
                d.a.o0.a.e0.d.b("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.f48168c.put("host_os", d.a.o0.t.a.f());
            this.f48168c.put("host_os_ver", d.a.o0.t.a.g());
            this.f48168c.put("host_app", d.a.o0.d.c.a().c());
            this.f48168c.put("host_app_ver", d.a.o0.d.c.a().i());
            this.f48168c.put("sdk_ver", d.a.o0.d.c.a().b());
            this.f48168c.put("ua", d.a.o0.t.i.b(d.a.o0.d.c.a().i()));
            this.f48168c.put("ut", d.a.o0.a.d0.c.f());
            this.f48168c.put("network", d.a.o0.t.a.e());
            this.f48168c.put("bundle_Id", d.a.o0.a.a2.d.g().getAppId());
            this.f48168c.put("cuid", d.a.o0.d.c.a().h());
            this.f48168c.put("uuid", d.a.o0.d.c.a().e());
            Map<String, String> map = this.f48168c;
            map.put("sid", d.a.o0.a.c1.a.Z().k() + "");
            this.f48168c.put("source", "swan_sdk");
            this.f48168c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48167b.put("mnpunion", String.valueOf(d.a.o0.a.s.a.f.f47712d.f() ? 2 : 0));
            this.f48167b.put("Referer", d0.b());
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.f48170e = "";
            } else {
                this.f48170e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f48168c.put("service", str);
        this.f48169d = true;
    }
}
