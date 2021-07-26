package d.a.o0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.o0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.a.l0.c f50906b;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f50909c;

        /* renamed from: d.a.o0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1139a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f50910e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f50911f;

            public RunnableC1139a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50911f = aVar;
                this.f50910e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50911f.f50908b, true, this.f50910e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f50912e;

            public b(a aVar) {
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
                this.f50912e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f50912e;
                    d.a.o0.h.m0.c.a(aVar.f50908b, false, aVar.f50907a);
                }
            }
        }

        public a(c cVar, d.a.o0.h.z.g.c cVar2, d.a.o0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50909c = cVar;
            this.f50907a = cVar2;
            this.f50908b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f50909c.f50906b.post(new RunnableC1139a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50907a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.o0.h.m0.c.c("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f50907a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50907a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f50909c.f50906b.post(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback<d.a.o0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50914b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f50915c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.h.z.g.c f50916e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f50917f;

            public a(b bVar, d.a.o0.h.z.g.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50917f = bVar;
                this.f50916e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50917f.f50914b, true, this.f50916e);
                }
            }
        }

        /* renamed from: d.a.o0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1140b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f50918e;

            public RunnableC1140b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50918e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f50918e;
                    d.a.o0.h.m0.c.a(bVar.f50914b, false, bVar.f50913a);
                }
            }
        }

        public b(c cVar, d.a.o0.h.z.g.c cVar2, d.a.o0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50915c = cVar;
            this.f50913a = cVar2;
            this.f50914b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.o0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.f50915c.f50906b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.o0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50913a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                d.a.o0.h.z.g.c cVar2 = this.f50913a;
                cVar2.errNo = "0";
                cVar2.errMsg = d.a.o0.h.m0.c.c("removeUserCloudStorage", "ok");
                return this.f50913a;
            }
            return (d.a.o0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f50913a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50913a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f50915c.f50906b.post(new RunnableC1140b(this));
            }
        }
    }

    /* renamed from: d.a.o0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1141c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50919a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f50921c;

        /* renamed from: d.a.o0.h.z.c$c$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f50922e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1141c f50923f;

            public a(C1141c c1141c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1141c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50923f = c1141c;
                this.f50922e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50923f.f50920b, true, this.f50922e);
                }
            }
        }

        /* renamed from: d.a.o0.h.z.c$c$b */
        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1141c f50924e;

            public b(C1141c c1141c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1141c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50924e = c1141c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C1141c c1141c = this.f50924e;
                    d.a.o0.h.m0.c.a(c1141c.f50920b, false, c1141c.f50919a);
                }
            }
        }

        public C1141c(c cVar, d.a.o0.h.z.g.c cVar2, d.a.o0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50921c = cVar;
            this.f50919a = cVar2;
            this.f50920b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f50921c.f50906b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50919a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.o0.h.m0.c.c("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f50919a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50919a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f50921c.f50906b.post(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ResponseCallback<d.a.o0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f50927c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.h.z.g.c f50928e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f50929f;

            public a(d dVar, d.a.o0.h.z.g.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50929f = dVar;
                this.f50928e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50929f.f50926b, true, this.f50928e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f50930e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50930e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f50930e;
                    d.a.o0.h.m0.c.a(dVar.f50926b, false, dVar.f50925a);
                }
            }
        }

        public d(c cVar, d.a.o0.h.z.g.c cVar2, d.a.o0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50927c = cVar;
            this.f50925a = cVar2;
            this.f50926b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.o0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f50927c.f50906b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.o0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50925a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                d.a.o0.h.z.g.c cVar2 = this.f50925a;
                cVar2.errNo = "0";
                cVar2.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "ok");
                return this.f50925a;
            }
            return (d.a.o0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f50925a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50925a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f50927c.f50906b.post(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.h.z.g.c f50931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50933c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f50934d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f50935e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f50936f;

            public a(e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50936f = eVar;
                this.f50935e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.h.m0.c.a(this.f50936f.f50933c, true, this.f50935e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f50937e;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50937e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f50937e;
                    d.a.o0.h.m0.c.a(eVar.f50933c, false, eVar.f50931a);
                }
            }
        }

        public e(c cVar, d.a.o0.h.z.g.c cVar2, String str, d.a.o0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50934d = cVar;
            this.f50931a = cVar2;
            this.f50932b = str;
            this.f50933c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f50934d.f50906b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.o0.h.z.a.f50898a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.o0.h.z.a.f50898a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.o0.h.z.g.c cVar = this.f50931a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f50932b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.o0.h.m0.c.c(this.f50932b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.o0.h.z.a.f50898a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f50931a.errMsg)) {
                    d.a.o0.h.z.g.c cVar = this.f50931a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f50932b, exc.getMessage());
                }
                this.f50934d.f50906b.post(new b(this));
            }
        }
    }

    public c(@NonNull d.a.o0.a.l0.c cVar) {
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
        this.f50906b = cVar;
    }

    public final d.a.o0.h.z.g.b[] c(d.a.o0.a.y.b.a aVar, JsObject[] jsObjectArr, d.a.o0.h.z.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                d.a.o0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                d.a.o0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else {
                d.a.o0.h.z.g.b[] bVarArr = new d.a.o0.h.z.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObjectArr[i2]);
                    if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                        bVarArr[i2] = new d.a.o0.h.z.g.b();
                        bVarArr[i2].key = G.C("key");
                        bVarArr[i2].value = G.C("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                            d.a.o0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            d.a.o0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                        d.a.o0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (d.a.o0.h.z.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            d.a.o0.h.z.g.c cVar = new d.a.o0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.o0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                d.a.o0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.a.o0.h.z.a.f50898a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.o0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                d.a.o0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(d.a.o0.h.z.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.o0.a.a2.e.V());
                JSONArray jSONArray = new JSONArray();
                for (d.a.o0.h.z.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (d.a.o0.h.z.a.f50898a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String f(int i2) {
        InterceptResult invokeI;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 1) {
                o = d.a.o0.h.t.a.b().o();
            } else if (i2 == 2) {
                o = d.a.o0.h.t.a.b().k();
            } else if (i2 == 3) {
                o = d.a.o0.h.t.a.b().p();
            } else if (i2 != 4) {
                o = i2 != 5 ? "" : d.a.o0.h.t.a.b().i();
            } else {
                o = d.a.o0.h.t.a.b().m();
            }
            if (TextUtils.isEmpty(o) && d.a.o0.h.z.a.f50898a) {
                Log.e("OpenDataApi", "getUrlByType（）meet empty url !");
            }
            return o;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            if (i2 == null) {
                return false;
            }
            return i2.j().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d(jsObject, 5);
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.o0.h.z.g.c cVar = new d.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            d.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C1141c(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.o0.h.z.a.f50898a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            d.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h2 = G.h("swanIdList");
            if (h2 != null && h2.length > 0) {
                for (String str : h2) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (d.a.o0.h.z.a.f50898a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.o0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.a.o0.h.z.a.f50898a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new d.a.o0.h.z.g.c(), G));
    }

    public final void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public final void i(JsObject[] jsObjectArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObjectArr) == null) || jsObjectArr == null) {
            return;
        }
        for (JsObject jsObject : jsObjectArr) {
            h(jsObject);
        }
    }

    public final <T> void j(int i2, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, responseCallback) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (strArr.length > 0) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            try {
                jSONObject.put("ma_id", d.a.o0.a.a2.e.V());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (d.a.o0.h.z.a.f50898a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.o0.h.z.g.c cVar = new d.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            d.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.o0.h.z.a.f50898a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            d.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.o0.h.z.g.c cVar = new d.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            d.a.o0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            d.a.o0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.o0.h.z.a.f50898a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.o0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
