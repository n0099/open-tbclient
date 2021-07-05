package d.a.q0.h.y.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import d.a.q0.a.j2.k;
import d.a.q0.a.n1.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class c extends d.a.q0.h.y.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> l;
    public static final Set<String> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f53680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f53681c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.y.b f53682d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f53683e;

        public a(c cVar, String str, long j, String str2, d.a.q0.h.y.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Long.valueOf(j), str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53683e = cVar;
            this.f53679a = str;
            this.f53680b = j;
            this.f53681c = str2;
            this.f53682d = bVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f53682d.cancelTag(this.f53683e.f53650g);
                this.f53683e.X(this.f53679a, 0, iOException.getMessage(), this.f53680b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.f53683e.X(this.f53679a, response.code(), response.message(), this.f53680b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new e(this.f53683e.J(response.headers()));
                    this.f53683e.dispatchEvent(jSEvent);
                } catch (JSONException e2) {
                    if (d.a.q0.h.y.a.f53647i) {
                        e2.printStackTrace();
                    }
                }
                String str = this.f53681c;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                        c2 = 0;
                    }
                } else if (str.equals("text")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    this.f53683e.Y(this.f53679a, response);
                } else {
                    this.f53683e.W(this.f53679a, response);
                }
                int code = response.code();
                String message = response.message();
                if (d.a.q0.h.y.a.f53647i) {
                    Log.d("RequestTask", "onResponse: id:" + this.f53683e.f53650g + ",respCode: " + code + ", url=" + this.f53679a + ", msg=" + message);
                }
                k.J(code, this.f53679a, 1, message, this.f53680b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-867852503, "Ld/a/q0/h/y/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-867852503, "Ld/a/q0/h/y/f/c;");
                return;
            }
        }
        l = Sets.newHashSet("text", "arraybuffer");
        m = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d.a.q0.a.l0.c cVar, d.a.q0.a.y.b.a aVar) {
        super(cVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.q0.a.l0.c) objArr2[0], (d.a.q0.a.y.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53648e = 1;
    }

    @NonNull
    public static String V(@NonNull d.a.q0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) {
            String lowerCase = aVar.C("responseType").toLowerCase(Locale.US);
            return !l.contains(lowerCase) ? "text" : lowerCase;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.q0.h.y.a
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            d.a.q0.h.f0.e.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = A();
            if (TextUtils.isEmpty(A)) {
                if (d.a.q0.h.y.a.f53647i) {
                    Log.d("RequestTask", "buildRequest url =" + A);
                }
                return null;
            }
            String C = this.f53649f.C("method");
            if (TextUtils.isEmpty(C)) {
                C = "GET";
            }
            String upperCase = C.toUpperCase(Locale.US);
            if (!m.contains(upperCase)) {
                D(A, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            H(builder, this.f53649f.x("header"), hashMap, true);
            if (d.a.q0.h.y.a.f53647i) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            Object D = this.f53649f.D("data", null);
            if (D == null) {
                D = this.f53649f.u("data", null);
            }
            boolean z = D != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(A).method(upperCase, null).tag(this.f53650g).build();
            }
            RequestBody T = (z || HttpMethod.requiresRequestBody(upperCase)) ? T(D, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && T == null) {
                return null;
            }
            return builder.url(A).method(upperCase, T).tag(this.f53650g).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody T(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get("content-type");
            MediaType mediaType = f.f49627a;
            if (!TextUtils.isEmpty(str)) {
                mediaType = MediaType.parse(str);
            }
            if (obj instanceof JsArrayBuffer) {
                byte[] buffer = ((JsArrayBuffer) obj).buffer();
                if (buffer == null) {
                    return RequestBody.create(mediaType, "");
                }
                return RequestBody.create(mediaType, buffer);
            } else if (obj instanceof String) {
                if (d.a.q0.h.y.a.f53647i) {
                    Log.d("RequestTask", "createBody = " + obj);
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public void U(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String V = V(this.f53649f);
            String httpUrl = request.url().toString();
            if (d.a.q0.a.a2.e.i() == null) {
                D("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            k.y(httpUrl, 1, null);
            d.a.q0.h.y.b bVar = (d.a.q0.h.y.b) d.a.q0.a.a2.e.i().X();
            bVar.b(request, new a(this, httpUrl, currentTimeMillis, V, bVar));
        }
    }

    public final void W(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, response) == null) || response == null) {
            return;
        }
        try {
            d.a.q0.h.y.f.a aVar = new d.a.q0.h.y.f.a();
            aVar.statusCode = response.code();
            aVar.header = J(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                aVar.data = new JsArrayBuffer(bytes, bytes.length);
            }
            E(aVar);
        } catch (IOException | JSONException e2) {
            if (d.a.q0.h.y.a.f53647i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            D(str, -1, e2.getMessage());
        }
    }

    public final void X(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (d.a.q0.h.y.a.f53647i) {
                Log.d("RequestTask", "onFailure: " + str2);
            }
            if (ResponseException.CANCELED.equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str3 = str2;
            D(str, i2, str3);
            if (SwanAppNetworkUtils.i(null)) {
                k.J(i2, str, 1, str3, j, System.currentTimeMillis());
            }
        }
    }

    public final void Y(String str, Response response) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, response) == null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            d dVar = new d();
            dVar.statusCode = response.code();
            dVar.header = J(response.headers());
            if (body != null) {
                dVar.data = body.string();
                if (d.a.q0.h.y.a.f53647i) {
                    Log.d("RequestTask", "onStringResponse = " + dVar.data);
                }
            }
            E(dVar);
        } catch (IOException | JSONException e2) {
            if (d.a.q0.h.y.a.f53647i) {
                Log.d("RequestTask", Log.getStackTraceString(e2));
            }
            D(str, -1, e2.getMessage());
        }
    }

    public void start() {
        Request S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f53649f == null || (S = S()) == null) {
            return;
        }
        U(S);
    }
}
