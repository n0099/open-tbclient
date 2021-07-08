package d.a.n0.a.h0.m.n;

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
import d.a.n0.a.a2.i;
import d.a.n0.a.a2.l;
import d.a.n0.a.f1.e.f.c;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import d.a.n0.n.i.g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d extends d.a.n0.a.h0.m.n.a implements g, d.a.n0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45021f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45022a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45022a = dVar;
        }

        @Override // d.a.n0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.f45022a.c(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45023a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45023a = dVar;
        }

        @Override // d.a.n0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.f45023a.a(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45025f;

        public c(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45025f = dVar;
            this.f45024e = str;
        }

        @Override // d.a.n0.n.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.f45025f.D(this.f45024e, "pms_http_with_ipc_action_stat_record", new c.a().y("pms_http_with_ipc_key_url", str).y("pms_http_with_ipc_key_response", str2).y("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
            }
        }

        @Override // d.a.n0.n.i.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                this.f45025f.D(this.f45024e, "pms_http_with_ipc_action_success", new c.a().y("pms_http_with_ipc_key_response", str).v("pms_http_with_ipc_key_status_code", i2));
            }
        }

        @Override // d.a.n0.n.i.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                d dVar = this.f45025f;
                String str = this.f45024e;
                dVar.E(str, "http: " + exc);
                if (d.f45021f) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // d.a.n0.n.i.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f45025f.D(this.f45024e, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.m.n.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0749d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45027f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f45028g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f45029h;

        public RunnableC0749d(d dVar, String str, String str2, c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45029h = dVar;
            this.f45026e = str;
            this.f45027f = str2;
            this.f45028g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.n0.a.v1.b.c.g(this.f45026e, "pms_http_with_ipc")) {
                    if (d.f45021f) {
                        this.f45029h.H("callbackIpcSession", "return by topic pms_http_with_ipc");
                        return;
                    }
                    return;
                }
                d.a.n0.a.v1.b.b y = d.a.n0.a.v1.b.c.O(this.f45026e).y("pms_http_with_ipc_key_action", this.f45027f);
                c.a aVar = this.f45028g;
                if (aVar != null) {
                    y.r(aVar.C());
                }
                if (d.f45021f) {
                    d dVar = this.f45029h;
                    dVar.H("callbackIpcSession", "ipcSession= " + y);
                }
                y.L();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(989926123, "Ld/a/n0/a/h0/m/n/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(989926123, "Ld/a/n0/a/h0/m/n/d;");
                return;
            }
        }
        f45021f = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(l lVar) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.a2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d.a.n0.a.a2.b bVar = new d.a.n0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    public final void D(String str, String str2, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, aVar) == null) {
            if (f45021f) {
                H("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            q0.b0(new RunnableC0749d(this, str, str2, aVar));
        }
    }

    public final void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            D(str, "pms_http_with_ipc_action_fail", new c.a().y("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void F(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f45021f) {
                H("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar == null || !d.a.n0.a.v1.b.c.f(aVar.C(), "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("ipc_session_id");
            if (f45021f) {
                H("handleIpcMsg", "session=" + n);
            }
            if (TextUtils.isEmpty(n)) {
                return;
            }
            String n2 = aVar.n("pms_http_with_ipc_key_action");
            if (f45021f) {
                H("handleIpcMsg", "action=" + n2);
            }
            if (TextUtils.isEmpty(n2)) {
                E(n, "empty action");
                return;
            }
            char c2 = 65535;
            int hashCode = n2.hashCode();
            if (hashCode != 646251642) {
                if (hashCode == 1779116731 && n2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                    c2 = 1;
                }
            } else if (n2.equals("pms_http_with_ipc_action_build_get_request")) {
                c2 = 0;
            }
            if (c2 == 0) {
                k(n, aVar, new a(this));
            } else if (c2 != 1) {
                E(n, "no such action:" + n2);
            } else {
                k(n, aVar, new b(this));
            }
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && f45021f) {
            Log.i("PmsHttpForService", str);
        }
    }

    public final void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            G(str + ": " + str2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.v2.e1.b
    /* renamed from: I */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            F(aVar);
        }
    }

    public final void k(String str, @NonNull i.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, aVar, eVar) == null) {
            if (f45021f) {
                H("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (d.a.n0.a.v1.b.c.g(str, "pms_http_with_ipc")) {
                String n = aVar.n("pms_http_with_ipc_key_url");
                Map<String, String> e2 = d.a.n0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_url_param_map"));
                Map<String, String> e3 = d.a.n0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_header_param_map"));
                String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
                JSONObject jSONObject = null;
                try {
                    if (!TextUtils.isEmpty(n2)) {
                        jSONObject = new JSONObject(n2);
                    }
                } catch (JSONException e4) {
                    if (f45021f) {
                        e4.printStackTrace();
                    }
                }
                try {
                    eVar.a(n, e2, e3, jSONObject, new c(this, str));
                } catch (Exception e5) {
                    E(str, "catch: " + e5);
                    if (f45021f) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
