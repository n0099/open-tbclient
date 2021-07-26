package d.a.o0.h.y;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
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
import d.a.o0.a.a2.d;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f50849i;
    public static final Set<String> j;
    public static final Set<String> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50850e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.y.b.a f50851f;

    /* renamed from: g  reason: collision with root package name */
    public String f50852g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.a.l0.c f50853h;

    /* renamed from: d.a.o0.h.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1134a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f50854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50855f;

        public RunnableC1134a(a aVar, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50855f = aVar;
            this.f50854e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.super.dispatchEvent(this.f50854e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f50856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f50857f;

        public b(a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50857f = aVar;
            this.f50856e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.h.m0.c.a(this.f50857f.f50851f, true, this.f50856e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50859f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f50860g;

        public c(a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50860g = aVar;
            this.f50858e = str;
            this.f50859f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.h.y.f.b bVar = new d.a.o0.h.y.f.b();
                bVar.errMsg = this.f50858e;
                bVar.statusCode = this.f50859f;
                d.a.o0.h.m0.c.a(this.f50860g.f50851f, false, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355908768, "Ld/a/o0/h/y/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355908768, "Ld/a/o0/h/y/a;");
                return;
            }
        }
        f50849i = k.f46335a;
        j = Sets.newHashSet("REFERER", "USER-AGENT");
        k = Sets.newHashSet("localhost", "127.0.0.1");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.l0.c cVar, d.a.o0.a.y.b.a aVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50850e = 0;
        this.f50853h = cVar;
        this.f50852g = z();
        this.f50851f = aVar;
    }

    public static void G(@NonNull Request.Builder builder, d.a.o0.a.y.b.a aVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, builder, aVar, map) == null) || aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str) && !j.contains(str.toUpperCase(Locale.US))) {
                String f2 = q0.f(aVar.I(str));
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
            String C = this.f50851f.C("url");
            if (this.f50851f != null && !TextUtils.isEmpty(this.f50852g)) {
                if (TextUtils.isEmpty(C)) {
                    D("", -1, "request:url is invalid");
                    return null;
                } else if (e.i() == null) {
                    D("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl F = F(C);
                    if (F == null) {
                        D(C, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = F.url().toString();
                    int c2 = d.a.o0.a.b2.a.b.c("request", url, "");
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl)) == null) ? (httpUrl == null || k.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true : invokeL.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e i2 = e.i();
            return i2 != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", i2.D(), i2.K()) : "";
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, str2) == null) {
            this.f50853h.postOnJSThread(new c(this, str2, i2));
        }
    }

    public void E(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.f50853h.postOnJSThread(new b(this, obj));
        }
    }

    public HttpUrl F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (d.g().x() == null) {
                if (B(parse)) {
                    return parse;
                }
                return null;
            } else if ((f50849i && d.a.o0.a.u1.a.a.o()) || B(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void H(@NonNull Request.Builder builder, d.a.o0.a.y.b.a aVar, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{builder, aVar, map, Boolean.valueOf(z)}) == null) {
            G(builder, aVar, map);
            if (z) {
                builder.header("Referer", C());
            }
        }
    }

    public void I(d.a.o0.a.y.b.a aVar) {
        d.a.o0.a.y.b.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (aVar2 = this.f50851f) == null) {
            return;
        }
        aVar2.H("success", aVar.v("success"));
        this.f50851f.H(com.baidu.pass.biometrics.face.liveness.b.a.g0, aVar.v(com.baidu.pass.biometrics.face.liveness.b.a.g0));
        this.f50851f.H(XAdRemoteEvent.COMPLETE, aVar.v(XAdRemoteEvent.COMPLETE));
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
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(values.get(i2));
                        if (i2 == size - 1) {
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f50851f == null || e.i() == null) {
            return;
        }
        e.i().X().cancelTag(this.f50852g);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSEvent)) == null) {
            this.f50853h.postOnJSThread(new RunnableC1134a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String V = e.V();
            if (TextUtils.isEmpty(V)) {
                return "";
            }
            return V + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }
}
