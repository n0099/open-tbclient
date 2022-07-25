package com.repackage;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class yy3 extends ny3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> h;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ oy3 d;
        public final /* synthetic */ yy3 e;

        public a(yy3 yy3Var, String str, long j, String str2, oy3 oy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy3Var, str, Long.valueOf(j), str2, oy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yy3Var;
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = oy3Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.d.cancelTag(this.e.c);
                this.e.X(this.a, 0, iOException.getMessage(), this.b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.e.X(this.a, response.code(), response.message(), this.b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new az3(this.e.J(response.headers()));
                    this.e.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (ny3.e) {
                        e.printStackTrace();
                    }
                }
                String str = this.c;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                        c = 0;
                    }
                } else if (str.equals("text")) {
                    c = 1;
                }
                if (c != 0) {
                    this.e.Y(this.a, response);
                } else {
                    this.e.W(this.a, response);
                }
                int code = response.code();
                String message = response.message();
                if (ny3.e) {
                    Log.d("RequestTask", "onResponse: id:" + this.e.c + ",respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                b73.O(code, this.a, 1, message, this.b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755125506, "Lcom/repackage/yy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755125506, "Lcom/repackage/yy3;");
                return;
            }
        }
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy3(s72 s72Var, ps1 ps1Var) {
        super(s72Var, ps1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s72Var, ps1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s72) objArr2[0], (ps1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    @NonNull
    public static String V(@NonNull ps1 ps1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ps1Var)) == null) {
            String lowerCase = ps1Var.B("responseType").toLowerCase(Locale.US);
            return !h.contains(lowerCase) ? "text" : lowerCase;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.ny3
    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.D(str, i2, str2);
            b14.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = A();
            if (TextUtils.isEmpty(A)) {
                if (ny3.e) {
                    Log.d("RequestTask", "buildRequest url =" + A);
                }
                return null;
            }
            String B = this.b.B("method");
            if (TextUtils.isEmpty(B)) {
                B = "GET";
            }
            String upperCase = B.toUpperCase(Locale.US);
            if (!i.contains(upperCase)) {
                D(A, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            H(builder, this.b.w("header"), hashMap, true);
            if (ny3.e) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            Object C = this.b.C("data", null);
            if (C == null) {
                C = this.b.t("data", null);
            }
            boolean z = C != null;
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(A).method(upperCase, null).tag(this.c).build();
            }
            RequestBody T = (z || HttpMethod.requiresRequestBody(upperCase)) ? T(C, hashMap) : null;
            if (HttpMethod.requiresRequestBody(upperCase) && T == null) {
                return null;
            }
            return builder.url(A).method(upperCase, T).tag(this.c).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody T(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get(Headers.CONTENT_TYPE);
            MediaType mediaType = pr2.a;
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
                if (ny3.e) {
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
            String V = V(this.b);
            String httpUrl = request.url().toString();
            if (i03.M() == null) {
                D("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b73.B(httpUrl, 1, null);
            oy3 oy3Var = (oy3) i03.M().i0();
            oy3Var.call(request, new a(this, httpUrl, currentTimeMillis, V, oy3Var));
        }
    }

    public final void W(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, response) == null) || response == null) {
            return;
        }
        try {
            wy3 wy3Var = new wy3();
            wy3Var.statusCode = response.code();
            wy3Var.header = J(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                wy3Var.data = new JsArrayBuffer(bytes, bytes.length);
            }
            E(wy3Var);
        } catch (IOException | JSONException e) {
            if (ny3.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            D(str, -1, e.getMessage());
        }
    }

    public final void X(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (ny3.e) {
                Log.d("RequestTask", "onFailure: " + str2);
            }
            if ("Canceled".equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str3 = str2;
            D(str, i2, str3);
            if (SwanAppNetworkUtils.i(null)) {
                b73.O(i2, str, 1, str3, j, System.currentTimeMillis());
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
            zy3 zy3Var = new zy3();
            zy3Var.statusCode = response.code();
            zy3Var.header = J(response.headers());
            if (body != null) {
                zy3Var.data = body.string();
                if (ny3.e) {
                    Log.d("RequestTask", "onStringResponse = " + zy3Var.data);
                }
            }
            E(zy3Var);
        } catch (IOException | JSONException e) {
            if (ny3.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            D(str, -1, e.getMessage());
        }
    }

    public void start() {
        Request S;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.b == null || (S = S()) == null) {
            return;
        }
        U(S);
    }
}
