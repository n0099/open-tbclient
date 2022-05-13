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
import com.repackage.ba4;
import com.repackage.y03;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f42 extends e42 implements ba4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<fx2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(f42 f42Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f42Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(fx2 fx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fx2Var) == null) {
                this.a.onFail(fx2Var.N());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ba4.a, nf3<y03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ba4.a a;
        public final boolean b;
        public boolean c;
        public final /* synthetic */ f42 d;

        public b(f42 f42Var, ba4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f42Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f42Var;
            this.c = false;
            this.a = aVar;
            this.b = aVar != null;
            if (f42.b) {
                f42Var.N("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // com.repackage.ba4.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (f42.b) {
                        f42 f42Var = this.d;
                        f42Var.N("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e) {
                        this.a.a(str, str2, jSONObject);
                    }
                }
            }
        }

        @Override // com.repackage.ba4.a
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (f42.b) {
                        f42 f42Var = this.d;
                        f42Var.N("IpcHttpCallbackWrapper#onSuccess", "valid=" + e + " statusCode=" + i + " response=" + str);
                    }
                    if (e) {
                        c();
                        this.a.b(str, i);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.c = true;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: d */
        public void onCallback(y03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (f42.b) {
                        f42 f42Var = this.d;
                        f42Var.N("IpcHttpCallbackWrapper#onCallback", "valid=" + e + " msg=" + aVar);
                    }
                    if (e) {
                        String o = aVar.o("pms_http_with_ipc_key_action", "");
                        char c = 65535;
                        switch (o.hashCode()) {
                            case -2080875416:
                                if (o.equals("pms_http_with_ipc_action_success")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -898655015:
                                if (o.equals("pms_http_with_ipc_action_fail")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -480804291:
                                if (o.equals("pms_http_with_ipc_action_on_start")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1737801345:
                                if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            a(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), ud3.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        } else if (c == 1) {
                            b(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                        } else if (c == 2) {
                            onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                        } else if (c == 3) {
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
                    if (this.b) {
                        z = this.c ? false : true;
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.ba4.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (f42.b) {
                        f42 f42Var = this.d;
                        f42Var.N("IpcHttpCallbackWrapper#onFail", "valid=" + e + " exception=" + exc);
                    }
                    if (e) {
                        c();
                        ba4.a aVar = this.a;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // com.repackage.ba4.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean e = e();
                    if (f42.b) {
                        f42 f42Var = this.d;
                        f42Var.N("IpcHttpCallbackWrapper#onStart", "valid=" + e);
                    }
                    if (e) {
                        this.a.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755757875, "Lcom/repackage/f42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755757875, "Lcom/repackage/f42;");
                return;
            }
        }
        b = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f42(z03 z03Var) {
        super(z03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void L(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ba4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (b) {
                M("ipcHttp");
            }
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            b bVar = new b(this, aVar);
            fx2 z = gx2.P("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            fx2 u = z.z("pms_http_with_ipc_key_url", str2).z("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).u("pms_http_with_ipc_key_url_param_map", e42.I(map)).u("pms_http_with_ipc_key_header_param_map", e42.I(map2));
            u.K(true);
            u.G(bVar);
            u.F(new a(this, bVar));
            if (b) {
                N("ipcHttp", "session=" + u);
            }
            u.call(i42.b0);
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b) {
            Log.i("PmsHttpForClient", str);
        }
    }

    public final void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            M(str + ": " + str2);
        }
    }

    @Override // com.repackage.e42, com.repackage.ba4
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, ba4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (b) {
                M("buildJsonPostRequest");
            }
            L("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // com.repackage.e42, com.repackage.ba4
    public void j(String str, Map<String, String> map, Map<String, String> map2, ba4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (b) {
                M("buildGetRequest");
            }
            String b2 = uu2.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            L("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        }
    }
}
