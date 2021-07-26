package d.a.o0.h.z;

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
/* loaded from: classes7.dex */
public class b extends d.a.o0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.l0.c f50899b;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<d.a.o0.h.z.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50900a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50901b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50902c;

        /* renamed from: d.a.o0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1137a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.h.z.g.a f50903e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f50904f;

            public RunnableC1137a(a aVar, d.a.o0.h.z.g.a aVar2) {
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
                this.f50904f = aVar;
                this.f50903e = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50904f.f50901b, true, this.f50903e);
                }
            }
        }

        /* renamed from: d.a.o0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1138b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f50905e;

            public RunnableC1138b(a aVar) {
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
                this.f50905e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f50905e;
                    d.a.o0.h.m0.c.a(aVar.f50901b, false, aVar.f50900a);
                }
            }
        }

        public a(b bVar, d.a.o0.h.z.g.c cVar, d.a.o0.a.y.b.a aVar) {
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
            this.f50902c = bVar;
            this.f50900a = cVar;
            this.f50901b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.o0.h.z.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.f50902c.f50899b.post(new RunnableC1137a(this, aVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.o0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50900a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                d.a.o0.h.z.g.a aVar = new d.a.o0.h.z.g.a();
                aVar.result = !TextUtils.equals(optString2, "0");
                aVar.errNo = "0";
                aVar.errMsg = d.a.o0.h.m0.c.c("checkIsUserAdvisedToRest", "ok");
                return aVar;
            }
            return (d.a.o0.h.z.g.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f50900a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50900a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.f50902c.f50899b.post(new RunnableC1138b(this));
            }
        }
    }

    public b(@NonNull d.a.o0.a.l0.c cVar) {
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
        this.f50899b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null || this.f50899b == null) {
            return;
        }
        d.a.o0.h.z.g.c cVar = new d.a.o0.h.z.g.c();
        try {
            int d2 = G.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.o0.a.a2.e.V());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (d.a.o0.h.z.a.f50898a) {
                    e2.printStackTrace();
                }
            }
            a(d.a.o0.h.t.a.b().e(), jSONObject.toString(), new a(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.o0.h.z.a.f50898a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.b("checkIsUserAdvisedToRest", e3);
            d.a.o0.h.m0.c.a(G, false, cVar);
        }
    }
}
