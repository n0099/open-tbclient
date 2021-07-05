package d.a.q0.h.z;

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
/* loaded from: classes8.dex */
public class c extends d.a.q0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.l0.c f53704b;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53705a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53706b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f53707c;

        /* renamed from: d.a.q0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1181a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f53708e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f53709f;

            public RunnableC1181a(a aVar, JSONObject jSONObject) {
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
                this.f53709f = aVar;
                this.f53708e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53709f.f53706b, true, this.f53708e);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f53710e;

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
                this.f53710e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f53710e;
                    d.a.q0.h.m0.c.a(aVar.f53706b, false, aVar.f53705a);
                }
            }
        }

        public a(c cVar, d.a.q0.h.z.g.c cVar2, d.a.q0.a.y.b.a aVar) {
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
            this.f53707c = cVar;
            this.f53705a = cVar2;
            this.f53706b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f53707c.f53704b.post(new RunnableC1181a(this, jSONObject));
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
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53705a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.q0.h.m0.c.c("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f53705a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53705a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f53707c.f53704b.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ResponseCallback<d.a.q0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53712b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f53713c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.h.z.g.c f53714e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f53715f;

            public a(b bVar, d.a.q0.h.z.g.c cVar) {
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
                this.f53715f = bVar;
                this.f53714e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53715f.f53712b, true, this.f53714e);
                }
            }
        }

        /* renamed from: d.a.q0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1182b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f53716e;

            public RunnableC1182b(b bVar) {
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
                this.f53716e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f53716e;
                    d.a.q0.h.m0.c.a(bVar.f53712b, false, bVar.f53711a);
                }
            }
        }

        public b(c cVar, d.a.q0.h.z.g.c cVar2, d.a.q0.a.y.b.a aVar) {
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
            this.f53713c = cVar;
            this.f53711a = cVar2;
            this.f53712b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.q0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on success ");
                }
                this.f53713c.f53704b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.q0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53711a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                d.a.q0.h.z.g.c cVar2 = this.f53711a;
                cVar2.errNo = "0";
                cVar2.errMsg = d.a.q0.h.m0.c.c("removeUserCloudStorage", "ok");
                return this.f53711a;
            }
            return (d.a.q0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f53711a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53711a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f53713c.f53704b.post(new RunnableC1182b(this));
            }
        }
    }

    /* renamed from: d.a.q0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1183c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53717a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53718b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f53719c;

        /* renamed from: d.a.q0.h.z.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f53720e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C1183c f53721f;

            public a(C1183c c1183c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1183c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53721f = c1183c;
                this.f53720e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53721f.f53718b, true, this.f53720e);
                }
            }
        }

        /* renamed from: d.a.q0.h.z.c$c$b */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1183c f53722e;

            public b(C1183c c1183c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1183c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53722e = c1183c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C1183c c1183c = this.f53722e;
                    d.a.q0.h.m0.c.a(c1183c.f53718b, false, c1183c.f53717a);
                }
            }
        }

        public C1183c(c cVar, d.a.q0.h.z.g.c cVar2, d.a.q0.a.y.b.a aVar) {
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
            this.f53719c = cVar;
            this.f53717a = cVar2;
            this.f53718b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f53719c.f53704b.post(new a(this, jSONObject));
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
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53717a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.q0.h.m0.c.c("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f53717a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53717a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f53719c.f53704b.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends ResponseCallback<d.a.q0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53723a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53724b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f53725c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.h.z.g.c f53726e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f53727f;

            public a(d dVar, d.a.q0.h.z.g.c cVar) {
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
                this.f53727f = dVar;
                this.f53726e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53727f.f53724b, true, this.f53726e);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f53728e;

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
                this.f53728e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f53728e;
                    d.a.q0.h.m0.c.a(dVar.f53724b, false, dVar.f53723a);
                }
            }
        }

        public d(c cVar, d.a.q0.h.z.g.c cVar2, d.a.q0.a.y.b.a aVar) {
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
            this.f53725c = cVar;
            this.f53723a = cVar2;
            this.f53724b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.q0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f53725c.f53704b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.q0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53723a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                d.a.q0.h.z.g.c cVar2 = this.f53723a;
                cVar2.errNo = "0";
                cVar2.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "ok");
                return this.f53723a;
            }
            return (d.a.q0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.e("OpenDataApi", "on fail");
                }
                if (TextUtils.isEmpty(this.f53723a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53723a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f53725c.f53704b.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.z.g.c f53729a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53730b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53731c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f53732d;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f53733e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f53734f;

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
                this.f53734f = eVar;
                this.f53733e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h.m0.c.a(this.f53734f.f53731c, true, this.f53733e);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f53735e;

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
                this.f53735e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f53735e;
                    d.a.q0.h.m0.c.a(eVar.f53731c, false, eVar.f53729a);
                }
            }
        }

        public e(c cVar, d.a.q0.h.z.g.c cVar2, String str, d.a.q0.a.y.b.a aVar) {
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
            this.f53732d = cVar;
            this.f53729a = cVar2;
            this.f53730b = str;
            this.f53731c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "on success");
                }
                this.f53732d.f53704b.post(new a(this, jSONObject));
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
                if (d.a.q0.h.z.a.f53696a) {
                    Log.d("OpenDataApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (d.a.q0.h.z.a.f53696a) {
                        Log.d("OpenDataApi", "errno = " + optString);
                    }
                    d.a.q0.h.z.g.c cVar = this.f53729a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f53730b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", d.a.q0.h.m0.c.c(this.f53730b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (d.a.q0.h.z.a.f53696a) {
                    Log.e("OpenDataApi", "on fail");
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f53729a.errMsg)) {
                    d.a.q0.h.z.g.c cVar = this.f53729a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f53730b, exc.getMessage());
                }
                this.f53732d.f53704b.post(new b(this));
            }
        }
    }

    public c(@NonNull d.a.q0.a.l0.c cVar) {
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
        this.f53704b = cVar;
    }

    public final d.a.q0.h.z.g.b[] c(d.a.q0.a.y.b.a aVar, JsObject[] jsObjectArr, d.a.q0.h.z.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                d.a.q0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                d.a.q0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else {
                d.a.q0.h.z.g.b[] bVarArr = new d.a.q0.h.z.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    d.a.q0.a.y.b.a G = d.a.q0.a.y.b.a.G(jsObjectArr[i2]);
                    if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                        bVarArr[i2] = new d.a.q0.h.z.g.b();
                        bVarArr[i2].key = G.C("key");
                        bVarArr[i2].value = G.C("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                            d.a.q0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            d.a.q0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                        d.a.q0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (d.a.q0.h.z.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            d.a.q0.h.z.g.c cVar = new d.a.q0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.q0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                d.a.q0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (d.a.q0.h.z.a.f53696a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = d.a.q0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                d.a.q0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(d.a.q0.h.z.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", d.a.q0.a.a2.e.V());
                JSONArray jSONArray = new JSONArray();
                for (d.a.q0.h.z.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (d.a.q0.h.z.a.f53696a) {
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
                o = d.a.q0.h.t.a.b().o();
            } else if (i2 == 2) {
                o = d.a.q0.h.t.a.b().k();
            } else if (i2 == 3) {
                o = d.a.q0.h.t.a.b().p();
            } else if (i2 != 4) {
                o = i2 != 5 ? "" : d.a.q0.h.t.a.b().i();
            } else {
                o = d.a.q0.h.t.a.b().m();
            }
            if (TextUtils.isEmpty(o) && d.a.q0.h.z.a.f53696a) {
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
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
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
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.q0.h.z.g.c cVar = new d.a.q0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            d.a.q0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C1183c(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.q0.h.z.a.f53696a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            d.a.q0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
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
            if (d.a.q0.h.z.a.f53696a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", d.a.q0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (d.a.q0.h.z.a.f53696a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new d.a.q0.h.z.g.c(), G));
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
                jSONObject.put("ma_id", d.a.q0.a.a2.e.V());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (d.a.q0.h.z.a.f53696a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.q0.h.z.g.c cVar = new d.a.q0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            d.a.q0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (d.a.q0.h.z.a.f53696a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            d.a.q0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        d.a.q0.h.z.g.c cVar = new d.a.q0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            d.a.q0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            d.a.q0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (d.a.q0.h.z.a.f53696a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = d.a.q0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            d.a.q0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
