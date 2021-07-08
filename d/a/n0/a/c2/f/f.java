package d.a.n0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.n1.o.a;
import d.a.n0.a.v2.q0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends d.a.n0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f43599f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43600e;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43601a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43603c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43604d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f43606f;

        public a(f fVar, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43606f = fVar;
            this.f43601a = callbackHandler;
            this.f43602b = str;
            this.f43603c = str2;
            this.f43604d = str3;
            this.f43605e = str4;
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f43601a.handleSchemeDispatchCallback(this.f43602b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
                SwanAppNetworkUtils.a(d.a.n0.m.e.a.g().getOkHttpClient(), this.f43603c);
                this.f43606f.q(this.f43604d);
            }
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || System.currentTimeMillis() - this.f43606f.p(this.f43604d) <= 500) {
                return;
            }
            if (i2 <= 100) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("progress", i2);
                    jSONObject.put("totalBytesWritten", j);
                    jSONObject.put("totalBytesExpectedToWrite", j2);
                    this.f43601a.handleSchemeDispatchCallback(this.f43605e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e2) {
                    if (a0.f43581b) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f43606f.f46319c.put(this.f43604d, Long.valueOf(System.currentTimeMillis()));
        }

        @Override // d.a.n0.a.n1.o.a.b
        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.f43601a.handleSchemeDispatchCallback(this.f43602b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
                SwanAppNetworkUtils.a(d.a.n0.m.e.a.g().getOkHttpClient(), this.f43603c);
                this.f43606f.q(this.f43604d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43613g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43614h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43615i;
        public final /* synthetic */ f j;

        public b(f fVar, CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str, str2, str3, str4, str5, str6, str7, str8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = fVar;
            this.f43607a = callbackHandler;
            this.f43608b = str;
            this.f43609c = str2;
            this.f43610d = str3;
            this.f43611e = str4;
            this.f43612f = str5;
            this.f43613g = str6;
            this.f43614h = str7;
            this.f43615i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                d.a.n0.a.g1.f.V().S();
                this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                this.j.q(this.f43609c);
                if (SwanAppNetworkUtils.i(null)) {
                    d.a.n0.a.j2.k.s(0, this.f43610d, 0, iOException.getMessage(), this.f43611e, this.f43612f);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String y;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!TextUtils.isEmpty(this.f43613g)) {
                    y = this.j.y(this.f43613g);
                } else {
                    y = f.A(response, this.f43614h);
                }
                if (TextUtils.isEmpty(y)) {
                    this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                    return;
                }
                if (a0.f43581b) {
                    Log.d("DownloadFileAction", "the real file path is " + y);
                }
                this.j.r(this.f43615i, response.headers());
                if (TextUtils.isEmpty(this.f43613g)) {
                    str = d.a.n0.a.g1.f.V().I().h(y);
                } else {
                    str = this.f43613g;
                }
                if (TextUtils.isEmpty(str)) {
                    this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                    return;
                }
                int code = response.code();
                String message = response.message();
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", code);
                        jSONObject.put(TextUtils.isEmpty(this.f43613g) ? "tempFilePath" : "filePath", str);
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(y);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (d.a.n0.t.g.a(byteStream, file)) {
                            this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } else {
                            this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                        }
                    } catch (Exception e2) {
                        if (a0.f43581b) {
                            e2.printStackTrace();
                        }
                        this.f43607a.handleSchemeDispatchCallback(this.f43608b, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                    }
                    this.j.q(this.f43609c);
                    d.a.n0.a.g1.f.V().S();
                    if (a0.f43581b) {
                        Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + this.f43610d + ", msg=" + message);
                    }
                    d.a.n0.a.j2.k.s(code, this.f43610d, 0, message, this.f43611e, this.f43612f);
                } catch (Throwable th) {
                    this.j.q(this.f43609c);
                    d.a.n0.a.g1.f.V().S();
                    throw th;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(232846600, "Ld/a/n0/a/c2/f/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(232846600, "Ld/a/n0/a/c2/f/f;");
                return;
            }
        }
        f43599f = new AtomicLong(System.currentTimeMillis());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/downloadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.n0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43600e = 0;
    }

    @Nullable
    public static String A(Response response, String str) {
        InterceptResult invokeLL;
        String str2;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, response, str)) == null) {
            String header = response.header("Content-Disposition", null);
            if (!TextUtils.isEmpty(header)) {
                String e2 = d.a.n0.a.v2.s.e(header);
                if (!TextUtils.isEmpty(e2) && (lastIndexOf = e2.lastIndexOf(".") + 1) > 0) {
                    str = e2.substring(lastIndexOf);
                }
            } else {
                String header2 = response.header("Content-Type", null);
                if (!TextUtils.isEmpty(header2)) {
                    String[] split = header2.split(";");
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String c2 = d.a.n0.a.v2.s.c(split[i2]);
                        if (!TextUtils.isEmpty(c2)) {
                            str = c2;
                            break;
                        }
                        i2++;
                    }
                }
            }
            long andIncrement = f43599f.getAndIncrement();
            StringBuilder sb = new StringBuilder();
            sb.append(andIncrement);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            sb.append(str2);
            return d.a.n0.a.g1.f.V().I().c(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String optString4 = a2.optString("filePath");
            if (!TextUtils.isEmpty(optString4) && d.a.n0.t.d.w(optString4)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
                return false;
            }
            String V = d.a.n0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = d.a.n0.a.u.e.j.h.a(V);
            Request x = x(a2, a3);
            if (x == null) {
                unitedSchemeEntity.result = t(this.f43600e);
                return false;
            }
            String httpUrl = x.url().toString();
            String z = z(httpUrl);
            JSONObject optJSONObject = a2.optJSONObject("header");
            d.a.n0.a.n1.o.b bVar = new d.a.n0.a.n1.o.b();
            HashMap<String, String> m = d.a.n0.a.n1.a.m(optJSONObject, true);
            String optString5 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString5)) {
                d.a.n0.n.h.h h2 = d.a.n0.a.t1.g.b.h(optString5);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", d.a.n0.a.t1.g.a.b(h2));
            }
            bVar.a(m);
            d.a.n0.a.g1.f.V().b0();
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.f46319c.put(valueOf, 0L);
            d.a.n0.a.n1.o.a aVar = new d.a.n0.a.n1.o.a();
            aVar.b(new a(this, callbackHandler, optString3, a3, valueOf, optString));
            String l = d.a.n0.a.j2.k.l();
            String h3 = q0.n().h();
            if (SwanAppNetworkUtils.i(null)) {
                d.a.n0.a.j2.k.x(httpUrl, 0);
            }
            OkHttpClient.Builder i2 = d.a.n0.m.e.a.g().i();
            i2.addNetworkInterceptor(new d.a.n0.a.n1.o.d());
            d.a.n0.m.e.a.g().v(i2);
            i2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(d.a.n0.a.n1.o.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(this, callbackHandler, optString3, valueOf, httpUrl, l, h3, optString4, z, optString2));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        InterceptResult invokeLL;
        HttpUrl f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = d.a.n0.a.u.e.j.h.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f2.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c2 = d.a.n0.a.b2.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.f43600e = c2;
            if (c2 != 0) {
                return null;
            }
            return new Request.Builder().url(httpUrl).tag(str).build();
        }
        return (Request) invokeLL.objValue;
    }

    @Nullable
    public final String y(@NonNull String str) {
        InterceptResult invokeL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String i2 = d.a.n0.a.g1.f.V().I().i(str);
            if (i2 == null || i2.endsWith(File.separator) || (parentFile = new File(i2).getParentFile()) == null || !parentFile.exists()) {
                return null;
            }
            return i2;
        }
        return (String) invokeL.objValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
                return null;
            }
            return d.a.n0.t.d.s(parse.getPath());
        }
        return (String) invokeL.objValue;
    }
}
