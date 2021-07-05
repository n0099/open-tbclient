package d.a.q0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.l0.c f53697b;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<d.a.q0.h.z.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53699b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f53700c;

        /* renamed from: d.a.q0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1179a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.h.z.g.a f53701e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f53702f;

            public RunnableC1179a(a aVar, d.a.q0.h.z.g.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53702f = aVar;
                this.f53701e = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53702f.f53699b, true, this.f53701e);
                }
            }
        }

        /* renamed from: d.a.q0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1180b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f53703e;

            public RunnableC1180b(a aVar) {
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
                this.f53703e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f53703e;
                    d.a.q0.h.m0.c.a(aVar.f53699b, false, aVar.f53698a);
                }
            }
        }

        public a(b bVar, d.a.q0.h.z.g.c cVar, d.a.q0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53700c = bVar;
            this.f53698a = cVar;
            this.f53699b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.q0.h.z.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.f53700c.f53697b.post(new RunnableC1179a(this, aVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.q0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53698a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                d.a.q0.h.z.g.a aVar = new d.a.q0.h.z.g.a();
                aVar.result = !TextUtils.equals(optString2, "0");
                aVar.errNo = "0";
                aVar.errMsg = d.a.q0.h.m0.c.c("checkIsUserAdvisedToRest", "ok");
                return aVar;
            }
            return (d.a.q0.h.z.g.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f53698a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53698a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.f53700c.f53697b.post(new RunnableC1180b(this));
            }
        }
    }

    public b(@NonNull d.a.q0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53697b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null || this.f53697b == null) {
            return;
        }
        d.a.q0.h.z.g.c cVar = new d.a.q0.h.z.g.c();
        try {
            int d2 = G.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.q0.a.a2.e.V());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.a.q0.h.z.a.f53696a) {
                    e2.printStackTrace();
                }
            }
            a(d.a.q0.h.t.a.b().e(), jSONObject.toString(), new a(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.q0.h.z.a.f53696a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.b("checkIsUserAdvisedToRest", e3);
            d.a.q0.h.m0.c.a(G, false, cVar);
        }
    }
}
