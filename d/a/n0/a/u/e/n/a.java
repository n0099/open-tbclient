package d.a.n0.a.u.e.n;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.u.c.d;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.u.e.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0931a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47773a;

        public C0931a(a aVar) {
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
                    return;
                }
            }
            this.f47773a = aVar;
        }

        @Override // d.a.n0.a.u.c.d.b
        public d.a.n0.a.u.h.b a(e eVar, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) ? this.f47773a.y(eVar, jSONObject, str) : (d.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47775b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47775b = aVar;
            this.f47774a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f47775b.v(this.f47774a, exc == null ? "" : exc.getMessage());
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
                this.f47775b.d(this.f47774a, this.f47775b.x(response));
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final Pair<Request, Integer> t(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, jSONObject)) == null) {
            RequestBody w = w(eVar, jSONObject);
            if (w == null) {
                return new Pair<>(null, 202);
            }
            return new Pair<>(new Request.Builder().url(d.a.n0.a.c1.a.R().b()).post(w).build(), 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public final void u(@NonNull Request request, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, str) == null) {
            d.a.n0.m.d.a aVar = new d.a.n0.m.d.a(request.url().toString(), request.body(), new b(this, str));
            aVar.f50601i = request.tag();
            aVar.f50598f = true;
            aVar.f50599g = true;
            aVar.f50600h = true;
            d.a.n0.m.e.a.g().e(aVar);
        }
    }

    public final void v(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d(str, new d.a.n0.a.u.h.b(500106, str2));
        }
    }

    public final RequestBody w(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, jSONObject)) == null) {
            String optString = jSONObject.optString("subscribeId");
            String D = eVar.D();
            String optString2 = jSONObject.optString("templateId");
            if (TextUtils.isEmpty(D) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new FormBody.Builder().add("appkey", D).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
        }
        return (RequestBody) invokeLL.objValue;
    }

    public d.a.n0.a.u.h.b x(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, response)) == null) {
            if (response != null && response.body() != null) {
                try {
                    String string = response.body().string();
                    if (d.f47438c) {
                        Log.i("Api-Subscription", string);
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString("errno");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (TextUtils.equals("0", optString) && optJSONObject != null) {
                        return new d.a.n0.a.u.h.b(0, optJSONObject, false);
                    }
                    return new d.a.n0.a.u.h.b(500106, "subscribe fail");
                } catch (Exception e2) {
                    if (d.f47438c) {
                        e2.printStackTrace();
                    }
                    return new d.a.n0.a.u.h.b(500106, Log.getStackTraceString(e2));
                }
            }
            return new d.a.n0.a.u.h.b(500106, "response body is null");
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.n0.a.u.h.b y(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, eVar, jSONObject, str)) == null) {
            Pair<Request, Integer> t = t(eVar, jSONObject);
            Request request = (Request) t.first;
            if (request == null) {
                return new d.a.n0.a.u.h.b(((Integer) t.second).intValue(), "params error");
            }
            u(request, str);
            return new d.a.n0.a.u.h.b(0, "success");
        }
        return (d.a.n0.a.u.h.b) invokeLLL.objValue;
    }

    public d.a.n0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (d.f47438c) {
                Log.d("Api-Subscription", "subscribe with json string:  " + str);
            }
            return j(str, true, new C0931a(this));
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
