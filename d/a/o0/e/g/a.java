package d.a.o0.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.p.d.u;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.w;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class a implements u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49654a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.o0.e.s.c<JSONObject> f49655b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f49656c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(269485077, "Ld/a/o0/e/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(269485077, "Ld/a/o0/e/g/a;");
                return;
            }
        }
        f49654a = k.f46335a;
        f49655b = new d.a.o0.e.s.c<>();
        f49656c = TimeUnit.MINUTES.toMillis(2L);
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
            }
        }
    }

    @Override // d.a.o0.a.p.d.u
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
        }
    }

    @Override // d.a.o0.a.p.d.u
    public File b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            return null;
        }
        return (File) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.u
    public JSONObject c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (f49654a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList params=" + str);
            }
            String str2 = d.a.o0.a.a2.d.g().getAppId() + d.a.o0.a.a2.d.g().r().j().c(context);
            JSONObject c2 = f49655b.c(str2);
            if (f49654a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList k=" + str2);
            }
            if (c2 != null) {
                if (f49654a) {
                    Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with cache=" + c2);
                }
                return c2;
            } else if (q0.N()) {
                return null;
            } else {
                JSONObject f2 = f(context, str);
                if (f49654a) {
                    Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with request=" + f2);
                }
                return f49655b.a(str2, f2, f49656c);
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.u
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f49655b.b();
        }
    }

    public final JSONObject e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            w.f(jSONObject2, "pa_type", 7);
            w.f(jSONObject2, "pa_unread_sums", Integer.valueOf(i2));
            jSONArray.put(jSONObject2);
            w.f(jSONObject, "un_read_list", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r9 = r4.optString("pa_uid");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        ResponseBody responseBody;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, context, str)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
        ResponseBody responseBody2 = null;
        if (Q == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    str2 = null;
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject.optInt("pa_type") == 7) {
                    break;
                }
                i3++;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String n = d.a.o0.a.c1.a.n().n();
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a(n, new Request.Builder().url(n).post(new FormBody.Builder().add("appkey", Q.D()).add(com.alipay.sdk.cons.b.k, str2).build()).build().body(), null);
            aVar.f51102f = true;
            aVar.f51103g = true;
            aVar.f51104h = true;
            aVar.f51098b = "POST";
            HttpRequestBuilder a2 = d.a.o0.m.e.b.a(aVar);
            d.a.o0.m.e.a.g().t(a2, aVar);
            try {
                Response executeSync = a2.build().executeSync();
                if (!executeSync.isSuccessful()) {
                    d.a.o0.t.d.d(null);
                    return null;
                }
                responseBody = executeSync.body();
                if (responseBody == null) {
                    d.a.o0.t.d.d(responseBody);
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(responseBody.string());
                    if (!"0".equals(jSONObject.optString("errno"))) {
                        d.a.o0.t.d.d(responseBody);
                        return null;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null) {
                        i2 = optJSONObject2.optInt("num");
                    }
                    JSONObject e2 = e(i2);
                    d.a.o0.a.c1.a.G().g(e2);
                    d.a.o0.t.d.d(responseBody);
                    return e2;
                } catch (IOException | JSONException unused) {
                    d.a.o0.t.d.d(responseBody);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    responseBody2 = responseBody;
                    d.a.o0.t.d.d(responseBody2);
                    throw th;
                }
            } catch (IOException | JSONException unused2) {
                responseBody = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (JSONException unused3) {
        }
    }
}
