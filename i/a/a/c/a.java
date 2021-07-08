package i.a.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f72761b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f72762c;

    /* renamed from: d  reason: collision with root package name */
    public static String f72763d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, List<Cookie>> f72764a;

    /* renamed from: i.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2082a implements CookieJar {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f72765a;

        public C2082a(a aVar) {
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
            this.f72765a = aVar;
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) {
                List<Cookie> list = (List) this.f72765a.f72764a.get(httpUrl.host());
                return list != null ? list : new ArrayList();
            }
            return (List) invokeL.objValue;
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) {
                this.f72765a.f72764a.put(httpUrl.host(), list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i.a.a.c.b.a f72766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f72767b;

        public b(a aVar, i.a.a.c.b.a aVar2, Request request) {
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
            this.f72766a = aVar2;
            this.f72767b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.f72766a.a(this.f72767b, iOException);
                RLog.error("HttpCore", "HttpCore -- enqueuePost--1-onFailure:" + iOException.getMessage(), new Object[0]);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                String unused = a.f72763d = response.body().string();
                try {
                    this.f72766a.b(a.f72763d);
                    RLog.debug("HttpCore", "HttpCore -- enqueuePost-onResponse:" + a.f72763d);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1500896180, "Li/a/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1500896180, "Li/a/a/c/a;");
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
        this.f72764a = new HashMap<>();
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().addInterceptor(new i.a.a.c.d.a(3)).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).cookieJar(new C2082a(this));
        cookieJar.dns(i.a.a.c.c.a.b());
        f72761b = cookieJar.build();
        RLog.info("HttpCore", "HttpCore -- init");
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f72762c == null) {
                synchronized (a.class) {
                    if (f72762c == null) {
                        f72762c = new a();
                    }
                }
            }
            return f72762c;
        }
        return (a) invokeV.objValue;
    }

    public static String g(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, map)) == null) {
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

    public String d(String str, Map<String, String> map, int i2, String str2, String str3, String str4, String str5, int i3, i.a.a.c.b.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, map, Integer.valueOf(i2), str2, str3, str4, str5, Integer.valueOf(i3), aVar})) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            FormBody.Builder builder = new FormBody.Builder();
            f(map, builder);
            FormBody build = builder.build();
            String g2 = g(str, null);
            RLog.debug("HttpCore", "HttpCore -- enqueuePost--url:" + g2);
            Request.Builder url = new Request.Builder().url(g2);
            Request build2 = url.addHeader("X-AppId", i2 + "").addHeader("traceid", str2).addHeader("version", str3).addHeader("pakagename", str4).addHeader("X-HostId", str5).addHeader("X-AuthType", String.valueOf(i3)).post(build).build();
            try {
                f72761b.newCall(build2).enqueue(new b(this, aVar, build2));
            } catch (Exception e2) {
                e2.printStackTrace();
                RLog.error("HttpCore", "HttpCore -- enqueuePost--3-onFailure:" + e2.getMessage(), new Object[0]);
            }
            return f72763d;
        }
        return (String) invokeCommon.objValue;
    }

    public final void f(Map<String, String> map, FormBody.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, builder) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
            }
        }
    }
}
