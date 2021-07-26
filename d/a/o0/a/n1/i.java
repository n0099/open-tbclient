package d.a.o0.a.n1;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.v2.q0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class i extends d.a.o0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f46837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46838g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46839h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f46840i;
        public final /* synthetic */ c j;

        public a(i iVar, String str, HttpUrl httpUrl, String str2, int i2, long j, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, httpUrl, str2, Integer.valueOf(i2), Long.valueOf(j), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46836e = str;
            this.f46837f = httpUrl;
            this.f46838g = str2;
            this.f46839h = i2;
            this.f46840i = j;
            this.j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.o0.a.j2.k.z(this.f46838g, this.f46839h, null, this.f46840i, System.currentTimeMillis());
                if (exc instanceof IOException) {
                    this.j.onFailure(null, (IOException) exc);
                } else {
                    this.j.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                d.a.o0.a.h0.q.b.g().u(this.f46836e, this.f46837f, networkStatRecord);
                d.a.o0.a.j2.k.z(this.f46838g, this.f46839h, networkStatRecord, this.f46840i, System.currentTimeMillis());
                this.j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46842f;

        public b(i iVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46841e = callbackHandler;
            this.f46842f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f46841e.handleSchemeDispatchCallback(this.f46842f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.a.a2.e f46843a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f46844b;

        /* renamed from: c  reason: collision with root package name */
        public String f46845c;

        /* renamed from: d  reason: collision with root package name */
        public String f46846d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f46847e;

        /* renamed from: f  reason: collision with root package name */
        public String f46848f;

        /* renamed from: g  reason: collision with root package name */
        public long f46849g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f46850h;

        public c(@NonNull i iVar, @NonNull d.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, eVar, jSONObject, str, str2, callbackHandler, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46850h = iVar;
            this.f46843a = eVar;
            this.f46844b = jSONObject;
            this.f46845c = str;
            this.f46846d = str2;
            this.f46847e = callbackHandler;
            this.f46848f = str3;
            this.f46849g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a0.f44085b) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                int G = this.f46843a.N().G();
                String l = d.a.o0.a.j2.k.l();
                String h2 = q0.n().h();
                SwanAppNetworkUtils.a(d.a.o0.m.e.a.g().getOkHttpClient(), this.f46846d);
                this.f46847e.handleSchemeDispatchCallback(this.f46848f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                d.a.o0.a.j2.k.K(0, this.f46845c, G, iOException.getMessage(), l, h2, this.f46849g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!d.a.o0.a.j2.k.n(this.f46845c)) {
                    d.a.o0.a.l2.b.l().x(this.f46845c, response.headers("Set-cookie"));
                }
                String B = d.a.o0.a.u.e.j.g.B(this.f46844b);
                String D = d.a.o0.a.u.e.j.g.D(this.f46844b);
                int G = this.f46843a.N().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = d.a.o0.a.j2.k.l();
                String h2 = q0.n().h();
                String optString = this.f46844b.optString("cb");
                try {
                    long C = d.a.o0.a.u.e.j.g.C(response);
                    if (C <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", d.a.o0.a.n1.a.s(response.headers()));
                        d.a.o0.a.u.e.j.g.J(jSONObject, response.body(), B, D);
                        this.f46850h.y(jSONObject);
                        this.f46847e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        d.a.o0.a.u.e.j.g.K(this.f46843a, this.f46845c, C, currentTimeMillis);
                        this.f46847e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (a0.f44085b) {
                        Log.d("RequestAction", Log.getStackTraceString(e2));
                    }
                    this.f46847e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (a0.f44085b) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f46845c + ", msg=" + message);
                }
                d.a.o0.a.j2.k.K(code, this.f46845c, G, message, l, h2, this.f46849g, System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/request");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull d.a.o0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> u = d.a.o0.a.u.e.j.g.u(a2, str);
            HttpRequest httpRequest = (HttpRequest) u.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) u.second).intValue());
                return false;
            }
            z(eVar, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
            }
            if (k(eVar, unitedSchemeEntity)) {
                String a2 = d.a.o0.a.u.e.j.h.a(eVar.f43885f);
                if (A(eVar, unitedSchemeEntity, callbackHandler, a2)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean x(@NonNull d.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, jSONObject, str, str2, callbackHandler, str3})) == null) ? d.a.o0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(this, eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3)) : invokeCommon.booleanValue;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    public final void z(@NonNull d.a.o0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, eVar.N().G(), System.currentTimeMillis(), new c(this, eVar, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.o0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
