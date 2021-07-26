package d.a.o0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.j.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static final String k;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47187c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47188d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47189e;

    /* renamed from: f  reason: collision with root package name */
    public String f47190f;

    /* renamed from: g  reason: collision with root package name */
    public String f47191g;

    /* renamed from: h  reason: collision with root package name */
    public String f47192h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f47193i;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f47197h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f47198i;

        public a(f fVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, jSONObject, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47198i = fVar;
            this.f47194e = callbackHandler;
            this.f47195f = jSONObject;
            this.f47196g = context;
            this.f47197h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.o0.a.e2.c.d.h(iVar)) {
                    d.a.o0.a.e2.c.d.p(iVar, this.f47194e, this.f47198i.f47192h);
                    return;
                }
                this.f47198i.f47193i = new JSONObject();
                if (this.f47195f.optInt("loadCts") == 1) {
                    this.f47198i.u(this.f47196g);
                    f fVar = this.f47198i;
                    fVar.w(this.f47197h, fVar.f47190f, this.f47194e, "master");
                    f fVar2 = this.f47198i;
                    fVar2.w(this.f47197h, fVar2.f47191g, this.f47194e, "slave");
                    this.f47198i.f47189e = true;
                    return;
                }
                this.f47198i.f47189e = false;
                d.a.o0.a.u1.a.a.Q(false);
                d.a.o0.a.u1.a.a.X();
                this.f47194e.handleSchemeDispatchCallback(this.f47198i.f47192h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f47199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47200b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47201c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f47202d;

        public b(f fVar, d.a.o0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47202d = fVar;
            this.f47199a = eVar;
            this.f47200b = str;
            this.f47201c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.o0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f47201c.handleSchemeDispatchCallback(this.f47202d.f47192h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                if (response.code() == 200 && response.body() != null) {
                    this.f47202d.s(this.f47199a, response, this.f47200b, this.f47201c);
                } else {
                    d.a.o0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f47201c.handleSchemeDispatchCallback(this.f47202d.f47192h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47204b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f47205c;

        public c(f fVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47205c = fVar;
            this.f47203a = str;
            this.f47204b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.o0.a.e0.d.b("setCtsConfig", "download cts file fail");
                this.f47204b.handleSchemeDispatchCallback(this.f47205c.f47192h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                f fVar = this.f47205c;
                fVar.v(response, this.f47203a, fVar.f47192h, this.f47204b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1291068223, "Ld/a/o0/a/p0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1291068223, "Ld/a/o0/a/p0/f/d/f;");
                return;
            }
        }
        j = String.format("?swanjs_version=%s", d.a.o0.a.m2.b.h(0));
        k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setCtsConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47187c = false;
        this.f47188d = false;
        this.f47189e = false;
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.o0.a.e0.d.b("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                d.a.o0.a.e0.d.b("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f47192h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    d.a.o0.a.e0.d.b("setCtsConfig", "loadCts is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, a2, context, eVar));
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void s(d.a.o0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f47192h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f47192h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, d.a.o0.a.a2.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(d.a.o0.a.c1.a.n().m(str), new c(this, str2, callbackHandler));
            aVar.f51102f = true;
            aVar.f51103g = false;
            aVar.f51104h = true;
            d.a.o0.m.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (d.a.o0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(d.a.o0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f47190f = jSONObject.optString("master");
                    this.f47191g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f47190f)) {
                        this.f47190f = k;
                    }
                    if (TextUtils.isEmpty(this.f47191g)) {
                        this.f47191g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f47190f = k;
                    this.f47191g = l;
                    return;
                }
            }
            this.f47190f = k;
            this.f47191g = l;
        }
    }

    public final void v(Response response, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, str2, callbackHandler) == null) {
            if (response.code() == 200 && response.body() != null) {
                try {
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_cts");
                    File file2 = new File(file, str + ".js");
                    if (d.a.o0.t.g.a(byteStream, file2)) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(file2);
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != -1081267614) {
                            if (hashCode == 109519319 && str.equals("slave")) {
                                c2 = 1;
                            }
                        } else if (str.equals("master")) {
                            c2 = 0;
                        }
                        if (c2 == 0) {
                            this.f47193i.put("master", jSONArray);
                            this.f47187c = true;
                            x(this.f47193i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            d.a.o0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.f47193i.put("slave", jSONArray);
                            this.f47188d = true;
                            x(this.f47193i, callbackHandler, str2);
                            return;
                        }
                    }
                    d.a.o0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    d.a.o0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            d.a.o0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(d.a.o0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f51102f = true;
            aVar.f51103g = false;
            aVar.f51104h = true;
            d.a.o0.m.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f47187c && this.f47188d && this.f47189e) {
            d.a.o0.a.u1.a.a.Q(true);
            d.a.o0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f47188d = false;
            this.f47187c = false;
            d.a.o0.a.u1.a.a.X();
        }
    }
}
