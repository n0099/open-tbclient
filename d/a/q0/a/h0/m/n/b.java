package d.a.q0.a.h0.m.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import d.a.q0.a.a2.j;
import d.a.q0.a.k;
import d.a.q0.a.v2.w;
import d.a.q0.n.i.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends d.a.q0.a.h0.m.n.a implements g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48317f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.v1.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0799b f48318e;

        public a(b bVar, C0799b c0799b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0799b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48318e = c0799b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.v1.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f48318e.onFail(bVar.P());
            }
        }
    }

    /* renamed from: d.a.q0.a.h0.m.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0799b implements g.a, d.a.q0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.a f48319e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f48320f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f48322h;

        public C0799b(b bVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48322h = bVar;
            this.f48321g = false;
            this.f48319e = aVar;
            this.f48320f = aVar != null;
            if (b.f48317f) {
                bVar.k("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // d.a.q0.n.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f48317f) {
                        b bVar = this.f48322h;
                        bVar.k("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e2 + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e2) {
                        this.f48319e.a(str, str2, jSONObject);
                    }
                }
            }
        }

        @Override // d.a.q0.n.i.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f48317f) {
                        b bVar = this.f48322h;
                        bVar.k("IpcHttpCallbackWrapper#onSuccess", "valid=" + e2 + " statusCode=" + i2 + " response=" + str);
                    }
                    if (e2) {
                        c();
                        this.f48319e.b(str, i2);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.f48321g = true;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f48317f) {
                        b bVar = this.f48322h;
                        bVar.k("IpcHttpCallbackWrapper#onCallback", "valid=" + e2 + " msg=" + aVar);
                    }
                    if (e2) {
                        String o = aVar.o("pms_http_with_ipc_key_action", "");
                        char c2 = 65535;
                        switch (o.hashCode()) {
                            case -2080875416:
                                if (o.equals("pms_http_with_ipc_action_success")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -898655015:
                                if (o.equals("pms_http_with_ipc_action_fail")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -480804291:
                                if (o.equals("pms_http_with_ipc_action_on_start")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 1737801345:
                                if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            a(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), w.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        } else if (c2 == 1) {
                            b(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                        } else if (c2 == 2) {
                            onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                        } else if (c2 == 3) {
                            onStart();
                        }
                    }
                }
            }
        }

        public synchronized boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.f48320f) {
                        z = this.f48321g ? false : true;
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.q0.n.i.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f48317f) {
                        b bVar = this.f48322h;
                        bVar.k("IpcHttpCallbackWrapper#onFail", "valid=" + e2 + " exception=" + exc);
                    }
                    if (e2) {
                        c();
                        g.a aVar = this.f48319e;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // d.a.q0.n.i.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f48317f) {
                        b bVar = this.f48322h;
                        bVar.k("IpcHttpCallbackWrapper#onStart", "valid=" + e2);
                    }
                    if (e2) {
                        this.f48319e.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-526749814, "Ld/a/q0/a/h0/m/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-526749814, "Ld/a/q0/a/h0/m/n/b;");
                return;
            }
        }
        f48317f = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(j jVar) {
        super(jVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.a2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.h0.m.n.a, d.a.q0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            if (f48317f) {
                j("buildJsonPostRequest");
            }
            i("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // d.a.q0.a.h0.m.n.a, d.a.q0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            if (f48317f) {
                j("buildGetRequest");
            }
            String a2 = d.a.q0.a.r1.l.d.a();
            if (a2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", a2);
            }
            i("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        }
    }

    public final void i(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (f48317f) {
                j("ipcHttp");
            }
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            C0799b c0799b = new C0799b(this, aVar);
            d.a.q0.a.v1.b.b y = d.a.q0.a.v1.b.c.E("pms_http_with_ipc").y("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            d.a.q0.a.v1.b.b t = y.y("pms_http_with_ipc_key_url", str2).y("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).t("pms_http_with_ipc_key_url_param_map", d.a.q0.a.h0.m.n.a.f(map)).t("pms_http_with_ipc_key_header_param_map", d.a.q0.a.h0.m.n.a.f(map2));
            t.K(true);
            t.G(c0799b);
            t.F(new a(this, c0799b));
            if (f48317f) {
                k("ipcHttp", "session=" + t);
            }
            t.M(e.d0);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && f48317f) {
            Log.i("PmsHttpForClient", str);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            j(str + ": " + str2);
        }
    }
}
