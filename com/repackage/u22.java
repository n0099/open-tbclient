package com.repackage;

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
import com.repackage.kk2;
import com.repackage.lz2;
import com.repackage.o84;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class u22 extends r22 implements o84, ae3<lz2.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public a(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.repackage.u22.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o84.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.j(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public b(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.repackage.u22.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o84.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.a(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements o84.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ u22 b;

        public c(u22 u22Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u22Var;
            this.a = str;
        }

        @Override // com.repackage.o84.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.b.O(this.a, "pms_http_with_ipc_action_stat_record", new kk2.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
            }
        }

        @Override // com.repackage.o84.a
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                this.b.O(this.a, "pms_http_with_ipc_action_success", new kk2.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i));
            }
        }

        @Override // com.repackage.o84.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                u22 u22Var = this.b;
                String str = this.a;
                u22Var.P(str, "http: " + exc);
                if (u22.b) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // com.repackage.o84.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.O(this.a, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kk2.a c;
        public final /* synthetic */ u22 d;

        public d(u22 u22Var, String str, String str2, kk2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = u22Var;
            this.a = str;
            this.b = str2;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!tv2.J(this.a, "pms_http_with_ipc")) {
                    if (u22.b) {
                        this.d.S("callbackIpcSession", "return by topic pms_http_with_ipc");
                        return;
                    }
                    return;
                }
                sv2 z = tv2.Z(this.a).z("pms_http_with_ipc_key_action", this.b);
                kk2.a aVar = this.c;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (u22.b) {
                    u22 u22Var = this.d;
                    u22Var.S("callbackIpcSession", "ipcSession= " + z);
                }
                z.call();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o84.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312932, "Lcom/repackage/u22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312932, "Lcom/repackage/u22;");
                return;
            }
        }
        b = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u22(oz2 oz2Var) {
        super(oz2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oz2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gz2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ez2 ez2Var = new ez2();
        ez2Var.e(this, "event_messenger_call");
        v(ez2Var);
    }

    public final void N(String str, @NonNull lz2.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (b) {
                S("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (tv2.J(str, "pms_http_with_ipc")) {
                String n = aVar.n("pms_http_with_ipc_key_url");
                Map<String, String> H = r22.H(aVar.f("pms_http_with_ipc_key_url_param_map"));
                Map<String, String> H2 = r22.H(aVar.f("pms_http_with_ipc_key_header_param_map"));
                String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
                JSONObject jSONObject = null;
                try {
                    if (!TextUtils.isEmpty(n2)) {
                        jSONObject = new JSONObject(n2);
                    }
                } catch (JSONException e2) {
                    if (b) {
                        e2.printStackTrace();
                    }
                }
                try {
                    eVar.a(n, H, H2, jSONObject, new c(this, str));
                } catch (Exception e3) {
                    P(str, "catch: " + e3);
                    if (b) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public final void O(String str, String str2, kk2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (b) {
                S("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            bd3.e0(new d(this, str, str2, aVar));
        }
    }

    public final void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            O(str, "pms_http_with_ipc_action_fail", new kk2.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void Q(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (b) {
                S("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar == null || !tv2.I(aVar.D(), "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("ipc_session_id");
            if (b) {
                S("handleIpcMsg", "session=" + n);
            }
            if (TextUtils.isEmpty(n)) {
                return;
            }
            String n2 = aVar.n("pms_http_with_ipc_key_action");
            if (b) {
                S("handleIpcMsg", "action=" + n2);
            }
            if (TextUtils.isEmpty(n2)) {
                P(n, "empty action");
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
                N(n, aVar, new a(this));
            } else if (c2 != 1) {
                P(n, "no such action:" + n2);
            } else {
                N(n, aVar, new b(this));
            }
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && b) {
            Log.i("PmsHttpForService", str);
        }
    }

    public final void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            R(str + ": " + str2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ae3
    /* renamed from: T */
    public void onCallback(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            Q(aVar);
        }
    }
}
