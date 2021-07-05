package d.a.q0.a.n1;

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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.v2.q0;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class i extends d.a.q0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HttpUrl f49635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49636g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f49637h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f49638i;
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
            this.f49634e = str;
            this.f49635f = httpUrl;
            this.f49636g = str2;
            this.f49637h = i2;
            this.f49638i = j;
            this.j = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.q0.a.j2.k.z(this.f49636g, this.f49637h, null, this.f49638i, System.currentTimeMillis());
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
                d.a.q0.a.h0.q.b.g().u(this.f49634e, this.f49635f, networkStatRecord);
                d.a.q0.a.j2.k.z(this.f49636g, this.f49637h, networkStatRecord, this.f49638i, System.currentTimeMillis());
                this.j.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49640f;

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
            this.f49639e = callbackHandler;
            this.f49640f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49639e.handleSchemeDispatchCallback(this.f49640f, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.q0.a.a2.e f49641a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f49642b;

        /* renamed from: c  reason: collision with root package name */
        public String f49643c;

        /* renamed from: d  reason: collision with root package name */
        public String f49644d;

        /* renamed from: e  reason: collision with root package name */
        public CallbackHandler f49645e;

        /* renamed from: f  reason: collision with root package name */
        public String f49646f;

        /* renamed from: g  reason: collision with root package name */
        public long f49647g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f49648h;

        public c(@NonNull i iVar, @NonNull d.a.q0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
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
            this.f49648h = iVar;
            this.f49641a = eVar;
            this.f49642b = jSONObject;
            this.f49643c = str;
            this.f49644d = str2;
            this.f49645e = callbackHandler;
            this.f49646f = str3;
            this.f49647g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (a0.f46883b) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                int G = this.f49641a.N().G();
                String l = d.a.q0.a.j2.k.l();
                String h2 = q0.n().h();
                SwanAppNetworkUtils.a(d.a.q0.m.e.a.g().getOkHttpClient(), this.f49644d);
                this.f49645e.handleSchemeDispatchCallback(this.f49646f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                d.a.q0.a.j2.k.K(0, this.f49643c, G, iOException.getMessage(), l, h2, this.f49647g, System.currentTimeMillis());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!d.a.q0.a.j2.k.n(this.f49643c)) {
                    d.a.q0.a.l2.b.l().x(this.f49643c, response.headers("Set-cookie"));
                }
                String B = d.a.q0.a.u.e.j.g.B(this.f49642b);
                String D = d.a.q0.a.u.e.j.g.D(this.f49642b);
                int G = this.f49641a.N().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = d.a.q0.a.j2.k.l();
                String h2 = q0.n().h();
                String optString = this.f49642b.optString("cb");
                try {
                    long C = d.a.q0.a.u.e.j.g.C(response);
                    if (C <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", d.a.q0.a.n1.a.s(response.headers()));
                        d.a.q0.a.u.e.j.g.J(jSONObject, response.body(), B, D);
                        this.f49648h.y(jSONObject);
                        this.f49645e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        d.a.q0.a.u.e.j.g.K(this.f49641a, this.f49643c, C, currentTimeMillis);
                        this.f49645e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (a0.f46883b) {
                        Log.d("RequestAction", Log.getStackTraceString(e2));
                    }
                    this.f49645e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (a0.f46883b) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.f49643c + ", msg=" + message);
                }
                d.a.q0.a.j2.k.K(code, this.f49643c, G, message, l, h2, this.f49647g, System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.q0.a.c2.e eVar) {
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
                super((d.a.q0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull d.a.q0.a.a2.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> u = d.a.q0.a.u.e.j.g.u(a2, str);
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
            }
            if (k(eVar, unitedSchemeEntity)) {
                String a2 = d.a.q0.a.u.e.j.h.a(eVar.f46683f);
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

    public final boolean x(@NonNull d.a.q0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, jSONObject, str, str2, callbackHandler, str3})) == null) ? d.a.q0.a.c1.a.d().i(eVar, jSONObject, str, str2, new c(this, eVar, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3)) : invokeCommon.booleanValue;
    }

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    public final void z(@NonNull d.a.q0.a.a2.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
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
    public i(d.a.q0.a.c2.e eVar, String str) {
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
                super((d.a.q0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
