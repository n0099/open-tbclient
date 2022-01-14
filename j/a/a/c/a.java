package j.a.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f62202b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f62203c;

    /* renamed from: d  reason: collision with root package name */
    public static String f62204d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<Cookie>> a;

    /* renamed from: j.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C2306a implements CookieJar {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C2306a(a aVar) {
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
            this.a = aVar;
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) {
                List<Cookie> list = (List) this.a.a.get(httpUrl.host());
                return list != null ? list : new ArrayList();
            }
            return (List) invokeL.objValue;
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) {
                this.a.a.put(httpUrl.host(), list);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j.a.a.c.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f62205b;

        public b(a aVar, j.a.a.c.b.a aVar2, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
            this.f62205b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                boolean isCanceled = call.isCanceled();
                RLog.error("HttpCore", "onFailure isCanceled:" + isCanceled, new Object[0]);
                this.a.a(this.f62205b, isCanceled, iOException);
                RLog.error("HttpCore", "HttpCore -- enqueuePost--1-onFailure:" + iOException.getMessage(), new Object[0]);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                String unused = a.f62204d = response.body().string();
                try {
                    this.a.b(a.f62204d);
                    RLog.debug("HttpCore", "HttpCore -- enqueuePost-onResponse:" + a.f62204d);
                } catch (Exception e2) {
                    RLog.error("HttpCore", "HttpCore -- enqueuePost--2-onFailure:" + e2.getMessage(), new Object[0]);
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1304382675, "Lj/a/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1304382675, "Lj/a/a/c/a;");
                return;
            }
        }
        MediaType.parse("application/json;charset=utf-8");
        MediaType.parse("application/octet-stream");
        MediaType.parse("text/x-markdown;charset=utf-8");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().addInterceptor(new j.a.a.c.d.a(3)).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).cookieJar(new C2306a(this));
        cookieJar.dns(j.a.a.c.c.a.b());
        f62202b = cookieJar.build();
        RLog.info("HttpCore", "HttpCore -- init");
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f62203c == null) {
                synchronized (a.class) {
                    if (f62203c == null) {
                        f62203c = new a();
                    }
                }
            }
            return f62203c;
        }
        return (a) invokeV.objValue;
    }

    public static String i(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, map)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (map == null) {
                new HashMap();
            } else {
                boolean z = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (z && !str.contains("?")) {
                        z = false;
                        sb.append("?");
                    } else {
                        sb.append("&");
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    if (entry.getValue() == null) {
                        sb.append(" ");
                    } else {
                        sb.append(entry.getValue());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            String g2 = g(i2, i3);
            RLog.info("HttpCore", "cancelAllRequest appId:" + i2 + " useChannel:" + i3 + " requestTag：" + g2);
            OkHttpClient okHttpClient = f62202b;
            if (okHttpClient != null && okHttpClient.dispatcher() != null) {
                for (Call call : f62202b.dispatcher().queuedCalls()) {
                    if (g2.equals(call.request().tag())) {
                        RLog.info("HttpCore", "cancel queued call:" + call);
                        call.cancel();
                    }
                }
                for (Call call2 : f62202b.dispatcher().runningCalls()) {
                    if (g2.equals(call2.request().tag())) {
                        RLog.info("HttpCore", "cancel running call:" + call2);
                        call2.cancel();
                    }
                }
                return;
            }
            RLog.error("HttpCore", "cancelAllRequest error okHttpClient null", new Object[0]);
        }
    }

    public String e(String str, Map<String, String> map, int i2, int i3, String str2, String str3, String str4, String str5, int i4, j.a.a.c.b.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, map, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, Integer.valueOf(i4), aVar})) == null) {
            String g2 = g(i2, i3);
            RLog.info("HttpCore", "enqueuePost requestTag=" + g2);
            if (map == null) {
                map = new HashMap<>();
            }
            FormBody.Builder builder = new FormBody.Builder();
            h(map, builder);
            FormBody build = builder.build();
            String i5 = i(str, null);
            RLog.debug("HttpCore", "HttpCore -- enqueuePost--url:" + i5);
            Request.Builder url = new Request.Builder().url(i5);
            Request build2 = url.addHeader("X-AppId", i2 + "").addHeader("traceid", str2).addHeader("version", str3).addHeader("pakagename", str4).addHeader("X-HostId", str5).addHeader("X-AuthType", String.valueOf(i4)).tag(g2).post(build).build();
            try {
                f62202b.newCall(build2).enqueue(new b(this, aVar, build2));
            } catch (Exception e2) {
                e2.printStackTrace();
                RLog.error("HttpCore", "HttpCore -- enqueuePost--3-onFailure:" + e2.getMessage(), new Object[0]);
            }
            return f62204d;
        }
        return (String) invokeCommon.objValue;
    }

    public String g(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            return "payhttp:appId=" + i2 + "&userchanel=" + i3;
        }
        return (String) invokeII.objValue;
    }

    public final void h(Map<String, String> map, FormBody.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, map, builder) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
            }
        }
    }
}
