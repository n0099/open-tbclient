package d.a.n0.a.p0.f.d;

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
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.j.b;
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
    public boolean f46683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46684d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46685e;

    /* renamed from: f  reason: collision with root package name */
    public String f46686f;

    /* renamed from: g  reason: collision with root package name */
    public String f46687g;

    /* renamed from: h  reason: collision with root package name */
    public String f46688h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f46689i;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f46693h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f46694i;

        public a(f fVar, CallbackHandler callbackHandler, JSONObject jSONObject, Context context, d.a.n0.a.a2.e eVar) {
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
            this.f46694i = fVar;
            this.f46690e = callbackHandler;
            this.f46691f = jSONObject;
            this.f46692g = context;
            this.f46693h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    d.a.n0.a.e2.c.d.p(iVar, this.f46690e, this.f46694i.f46688h);
                    return;
                }
                this.f46694i.f46689i = new JSONObject();
                if (this.f46691f.optInt("loadCts") == 1) {
                    this.f46694i.u(this.f46692g);
                    f fVar = this.f46694i;
                    fVar.w(this.f46693h, fVar.f46686f, this.f46690e, "master");
                    f fVar2 = this.f46694i;
                    fVar2.w(this.f46693h, fVar2.f46687g, this.f46690e, "slave");
                    this.f46694i.f46685e = true;
                    return;
                }
                this.f46694i.f46685e = false;
                d.a.n0.a.u1.a.a.Q(false);
                d.a.n0.a.u1.a.a.X();
                this.f46690e.handleSchemeDispatchCallback(this.f46694i.f46688h, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f46695a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46696b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46697c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f46698d;

        public b(f fVar, d.a.n0.a.a2.e eVar, String str, CallbackHandler callbackHandler) {
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
            this.f46698d = fVar;
            this.f46695a = eVar;
            this.f46696b = str;
            this.f46697c = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.n0.a.e0.d.b("SwanAppAction", "request Cts Server Address onFailure: " + exc.getMessage());
                this.f46697c.handleSchemeDispatchCallback(this.f46698d.f46688h, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
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
                    this.f46698d.s(this.f46695a, response, this.f46696b, this.f46697c);
                } else {
                    d.a.n0.a.e0.d.b("setCtsConfig", "request Cts Server Address fail,code is " + response.code());
                    this.f46697c.handleSchemeDispatchCallback(this.f46698d.f46688h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
        public final /* synthetic */ String f46699a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46700b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f46701c;

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
            this.f46701c = fVar;
            this.f46699a = str;
            this.f46700b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.n0.a.e0.d.b("setCtsConfig", "download cts file fail");
                this.f46700b.handleSchemeDispatchCallback(this.f46701c.f46688h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
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
                f fVar = this.f46701c;
                fVar.v(response, this.f46699a, fVar.f46688h, this.f46700b);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-785509598, "Ld/a/n0/a/p0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-785509598, "Ld/a/n0/a/p0/f/d/f;");
                return;
            }
        }
        j = String.format("?swanjs_version=%s", d.a.n0.a.m2.b.h(0));
        k = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=1";
        l = "https://smartprogram.baidu.com/batapi/engine" + j + "&type=2";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.n0.a.c2.e eVar) {
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
        this.f46683c = false;
        this.f46684d = false;
        this.f46685e = false;
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.n0.a.e0.d.b("setCtsConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (eVar == null) {
                d.a.n0.a.e0.d.b("setCtsConfig", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                this.f46688h = a2.optString("cb");
                if (!a2.has("loadCts")) {
                    d.a.n0.a.e0.d.b("setCtsConfig", "loadCts is null");
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

    public final void s(d.a.n0.a.a2.e eVar, Response response, String str, CallbackHandler callbackHandler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, response, str, callbackHandler) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (jSONObject.has("code") && jSONObject.optInt("code") == 0) {
                    t(jSONObject.optJSONArray("data").optString(0), str, eVar, callbackHandler);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(this.f46688h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(this.f46688h, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void t(String str, String str2, d.a.n0.a.a2.e eVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, eVar, callbackHandler) == null) {
            d.a.n0.m.d.a aVar = new d.a.n0.m.d.a(d.a.n0.a.c1.a.n().m(str), new c(this, str2, callbackHandler));
            aVar.f50598f = true;
            aVar.f50599g = false;
            aVar.f50600h = true;
            d.a.n0.m.e.a.g().d(aVar);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (d.a.n0.a.v2.h.a(context, "aiapps/debug_cts_url.json")) {
                try {
                    JSONObject jSONObject = new JSONObject(d.a.n0.a.v2.h.b(context, "aiapps/debug_cts_url.json"));
                    this.f46686f = jSONObject.optString("master");
                    this.f46687g = jSONObject.optString("slave");
                    if (TextUtils.isEmpty(this.f46686f)) {
                        this.f46686f = k;
                    }
                    if (TextUtils.isEmpty(this.f46687g)) {
                        this.f46687g = l;
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f46686f = k;
                    this.f46687g = l;
                    return;
                }
            }
            this.f46686f = k;
            this.f46687g = l;
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
                    if (d.a.n0.t.g.a(byteStream, file2)) {
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
                            this.f46689i.put("master", jSONArray);
                            this.f46683c = true;
                            x(this.f46689i, callbackHandler, str2);
                            return;
                        } else if (c2 != 1) {
                            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                            d.a.n0.a.e0.d.b("setCtsConfig", "error type, get cts url failed");
                            return;
                        } else {
                            this.f46689i.put("slave", jSONArray);
                            this.f46684d = true;
                            x(this.f46689i, callbackHandler, str2);
                            return;
                        }
                    }
                    d.a.n0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                } catch (Exception unused) {
                    d.a.n0.a.e0.d.b("setCtsConfig", "save cts file fail");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
            }
            d.a.n0.a.e0.d.b("setCtsConfig", "download cts file fail,code is " + response.code());
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    public final void w(d.a.n0.a.a2.e eVar, String str, CallbackHandler callbackHandler, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, eVar, str, callbackHandler, str2) == null) {
            d.a.n0.m.d.a aVar = new d.a.n0.m.d.a(str, new b(this, eVar, str2, callbackHandler));
            aVar.f50598f = true;
            aVar.f50599g = false;
            aVar.f50600h = true;
            d.a.n0.m.e.a.g().d(aVar);
        }
    }

    public final void x(JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, jSONObject, callbackHandler, str) == null) && this.f46683c && this.f46684d && this.f46685e) {
            d.a.n0.a.u1.a.a.Q(true);
            d.a.n0.a.k2.g.h.a().putString("ctsUrl", jSONObject.toString());
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            this.f46684d = false;
            this.f46683c = false;
            d.a.n0.a.u1.a.a.X();
        }
    }
}
