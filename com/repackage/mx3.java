package com.repackage;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mx3 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final Set<String> g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public or1 b;
    public String c;
    public r62 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;
        public final /* synthetic */ mx3 b;

        public a(mx3 mx3Var, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx3Var, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx3Var;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mx3.super.dispatchEvent(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;
        public final /* synthetic */ mx3 b;

        public b(mx3 mx3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx3Var;
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s14.call(this.b.b, true, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ mx3 c;

        public c(mx3 mx3Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx3Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mx3Var;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wx3 wx3Var = new wx3();
                wx3Var.errMsg = this.a;
                wx3Var.statusCode = this.b;
                s14.call(this.c.b, false, wx3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755483959, "Lcom/repackage/mx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755483959, "Lcom/repackage/mx3;");
                return;
            }
        }
        e = rf1.a;
        f = Sets.newHashSet("REFERER", "USER-AGENT");
        g = Sets.newHashSet("localhost", "127.0.0.1");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mx3(@NonNull r62 r62Var, or1 or1Var) {
        super(r62Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var, or1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.d = r62Var;
        this.c = z();
        this.b = or1Var;
    }

    public static void G(@NonNull Request.Builder builder, or1 or1Var, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, builder, or1Var, map) == null) || or1Var == null || or1Var.k() < 1) {
            return;
        }
        for (String str : or1Var.j()) {
            if (!TextUtils.isEmpty(str) && !f.contains(str.toUpperCase(Locale.US))) {
                String f2 = bd3.f(or1Var.H(str));
                if (!TextUtils.isEmpty(f2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(Locale.US), f2);
                    }
                    builder.header(str, f2);
                }
            }
        }
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String B = this.b.B("url");
            if (this.b != null && !TextUtils.isEmpty(this.c)) {
                if (TextUtils.isEmpty(B)) {
                    D("", -1, "request:url is invalid");
                    return null;
                } else if (hz2.L() == null) {
                    D("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl F = F(B);
                    if (F == null) {
                        D(B, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = F.url().toString();
                    int c2 = yz2.c("request", url, "");
                    if (c2 != 0) {
                        if (c2 == 1) {
                            D(url, -1, "request:host not in white list");
                            return null;
                        } else if (c2 != 2) {
                            D(url, -1, "request:host not in white list");
                            return null;
                        } else {
                            D(url, -1, "request:url header must be https or wss");
                            return null;
                        }
                    }
                    return url;
                }
            }
            D("", 0, "request:swanApp is null");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean B(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl)) == null) ? (httpUrl == null || g.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true : invokeL.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hz2 L = hz2.L();
            return L != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", L.N(), L.U()) : "";
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            this.d.postOnJSThread(new c(this, str2, i));
        }
    }

    public void E(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.d.postOnJSThread(new b(this, obj));
        }
    }

    public HttpUrl F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (gz2.J().x() == null) {
                if (B(parse)) {
                    return parse;
                }
                return null;
            } else if ((e && gv2.o()) || B(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void H(@NonNull Request.Builder builder, or1 or1Var, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{builder, or1Var, map, Boolean.valueOf(z)}) == null) {
            G(builder, or1Var, map);
            if (z) {
                builder.header("Referer", C());
            }
        }
    }

    public void I(or1 or1Var) {
        or1 or1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, or1Var) == null) || or1Var == null || (or1Var2 = this.b) == null) {
            return;
        }
        or1Var2.G("success", or1Var.u("success"));
        this.b.G(com.baidu.pass.biometrics.face.liveness.b.a.g0, or1Var.u(com.baidu.pass.biometrics.face.liveness.b.a.g0));
        this.b.G(TaskProcessData.keyComplete, or1Var.u(TaskProcessData.keyComplete));
    }

    public JSONObject J(Headers headers) throws JSONException {
        InterceptResult invokeL;
        List<String> values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(values.get(i));
                        if (i == size - 1) {
                            break;
                        }
                        sb.append(",");
                    }
                    jSONObject.put(str, sb.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @JavascriptInterface
    public void abort() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.b == null || hz2.L() == null) {
            return;
        }
        hz2.L().h0().cancelTag(this.c);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSEvent)) == null) {
            this.d.postOnJSThread(new a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String f0 = hz2.f0();
            if (TextUtils.isEmpty(f0)) {
                return "";
            }
            return f0 + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }
}
