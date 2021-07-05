package d.a.q0.b.n.i.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c1.d.d;
import d.a.q0.a.c2.f.a0;
import h.d;
import h.j;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.b.n.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1077a implements h.n.b<d.a.q0.b.n.i.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.b.n.i.b.a f52335e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f52336f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f52337g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f52338h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f52339i;

        public C1077a(a aVar, d.a.q0.b.n.i.b.a aVar2, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52339i = aVar;
            this.f52335e = aVar2;
            this.f52336f = context;
            this.f52337g = callbackHandler;
            this.f52338h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.a.q0.b.n.i.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                d.a.q0.b.n.i.c.a.b(this.f52335e, bVar);
                this.f52339i.t(this.f52336f, this.f52337g, this.f52338h, this.f52335e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.b<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f52340e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f52341f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52342g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.b.n.i.b.a f52343h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f52344i;

        public b(a aVar, Context context, CallbackHandler callbackHandler, String str, d.a.q0.b.n.i.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, callbackHandler, str, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52344i = aVar;
            this.f52340e = context;
            this.f52341f = callbackHandler;
            this.f52342g = str;
            this.f52343h = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                d.a.q0.a.e0.d.l("recommend", "get param(l) info fail: " + th.getMessage());
                this.f52344i.t(this.f52340e, this.f52341f, this.f52342g, this.f52343h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a<d.a.q0.b.n.i.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.q0.b.n.i.a.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1078a implements d.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f52345a;

            public C1078a(c cVar, j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52345a = jVar;
            }

            @Override // d.a.q0.a.c1.d.d.a
            public void a(d.a.q0.a.c2.f.k0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    d.a.q0.b.n.i.b.b bVar2 = new d.a.q0.b.n.i.b.b();
                    if (bVar != null && !TextUtils.isEmpty(bVar.f47061a)) {
                        bVar2.f52368a = bVar.f47061a;
                        bVar2.f52369b = bVar.f47063c;
                        bVar2.f52370c = bVar.f47062b;
                    } else {
                        bVar2.f52368a = "unknown";
                    }
                    this.f52345a.onNext(bVar2);
                    this.f52345a.onCompleted();
                }
            }

            @Override // d.a.q0.a.c1.d.d.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f52345a.onError(new Throwable());
                }
            }
        }

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super d.a.q0.b.n.i.b.b> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                d.a.q0.a.c1.a.E().b(BDLocation.BDLOCATION_GCJ02_TO_BD09, true, false, new C1078a(this, jVar));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.v2.e1.b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f52346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52347f;

        public d(a aVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52346e = callbackHandler;
            this.f52347f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    d.a.q0.a.e0.d.b("recommend", "response is null");
                    this.f52346e.handleSchemeDispatchCallback(this.f52347f, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                    return;
                }
                d.a.q0.a.e0.d.g("recommend", "recommend action execute success");
                this.f52346e.handleSchemeDispatchCallback(this.f52347f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f52348a;

        public e(a aVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52348a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("info", "on success but jsonObject is null");
                        jSONObject2.put("statusCode", i2);
                    } catch (JSONException e2) {
                        if (a0.f46883b) {
                            e2.printStackTrace();
                        }
                    }
                    d.a.q0.b.n.i.c.a.f(jSONObject2.toString());
                }
                this.f52348a.onCallback(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                d.a.q0.a.e0.d.g("recommend", "parse response");
                String str = StringUtil.NULL_STRING;
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", "parse response fail");
                            jSONObject.put("response code", response.code());
                            if (string != null) {
                                str = "empty";
                            }
                            jSONObject.put("response body", str);
                        } catch (JSONException e2) {
                            if (a0.f46883b) {
                                e2.printStackTrace();
                            }
                        }
                        d.a.q0.b.n.i.c.a.f(jSONObject.toString());
                        return null;
                    }
                    return new JSONObject(string);
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "parse response fail");
                    if (response == null) {
                        jSONObject2.put("response", StringUtil.NULL_STRING);
                    } else {
                        jSONObject2.put("response code", response.code());
                        if (response.body() == null) {
                            jSONObject2.put("response body", StringUtil.NULL_STRING);
                        } else {
                            jSONObject2.put("response", "unknown");
                        }
                    }
                } catch (JSONException e3) {
                    if (a0.f46883b) {
                        e3.printStackTrace();
                    }
                }
                d.a.q0.b.n.i.c.a.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                d.a.q0.a.e0.d.c("recommend", "http response with exception:", exc);
                this.f52348a.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e2) {
                    if (a0.f46883b) {
                        e2.printStackTrace();
                    }
                }
                d.a.q0.b.n.i.c.a.f(jSONObject.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.c2.e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (eVar == null) {
                d.a.q0.a.e0.d.b("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.q0.a.e0.d.b("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                d.a.q0.a.e0.d.g("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.a.q0.a.e0.d.b("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final d.a.q0.a.v2.e1.b<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) ? new d(this, callbackHandler, str) : (d.a.q0.a.v2.e1.b) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull d.a.q0.a.v2.e1.b<JSONObject> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? new e(this, bVar) : (ResponseCallback) invokeL.objValue;
    }

    public final h.d<d.a.q0.b.n.i.b.b> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (!d.a.q0.a.v2.d.h() || (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                return h.d.b(new c(this));
            }
            return null;
        }
        return (h.d) invokeL.objValue;
    }

    @NonNull
    public abstract String r();

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, callbackHandler, str, jSONObject) == null) {
            d.a.q0.a.e0.d.g("recommend", "get request params");
            d.a.q0.b.n.i.b.a aVar = new d.a.q0.b.n.i.b.a(context, jSONObject);
            h.d<d.a.q0.b.n.i.b.b> q = q(context);
            if (q != null) {
                q.E(60L, TimeUnit.MILLISECONDS).C(new C1077a(this, aVar, context, callbackHandler, str), new b(this, context, callbackHandler, str, aVar));
                return;
            }
            d.a.q0.a.e0.d.l("recommend", "get param(l) is null");
            t(context, callbackHandler, str, aVar);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.q0.b.n.i.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, aVar) == null) {
            d.a.q0.a.e0.d.g("recommend", "start real perform request");
            String v = d.a.q0.a.d0.c.v(r());
            d.a.q0.a.v2.e1.b<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            d.a.q0.a.e0.d.g("recommend", "encrypt request param");
            String a2 = d.a.q0.b.n.i.c.a.a(aVar.d());
            if (TextUtils.isEmpty(a2)) {
                d.a.q0.a.e0.d.b("recommend", "encrypt request param fail");
                o.onCallback(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (a0.f46883b) {
                        e2.printStackTrace();
                    }
                }
                d.a.q0.b.n.i.c.a.f(jSONObject.toString());
                return;
            }
            d.a.q0.a.e0.d.g("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
        }
    }
}
