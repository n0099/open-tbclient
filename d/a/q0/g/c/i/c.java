package d.a.q0.g.c.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.a2.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.k;
import d.a.q0.a.v2.q0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f52998a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054552509, "Ld/a/q0/g/c/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1054552509, "Ld/a/q0/g/c/i/c;");
                return;
            }
        }
        f52998a = k.f49133a;
    }

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, aVar) == null) {
            String l = b.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (f52998a) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b bVar = new b();
            bVar.m(aVar);
            bVar.f49120b = l;
            bVar.f49123e = str3;
            bVar.v = str;
            bVar.l = q0.D();
            if (e.Q() != null) {
                b.a L = e.Q().L();
                bVar.f49119a = d.a.q0.a.j2.k.m(L.G());
                bVar.f49124f = L.H();
                bVar.f49121c = L.T();
            }
            bVar.t = str4;
            d.a.q0.a.j2.k.u("1245", bVar);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            c(str, str2, "");
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            String l = b.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            b bVar = new b();
            bVar.f49120b = l;
            bVar.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            bVar.a("packageName", str3);
            d.a.q0.a.j2.k.u("1245", bVar);
        }
    }

    public static void d(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String c2 = d.a.q0.h.t.a.b().c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", d.a.q0.a.c1.a.a0().i(d.a.q0.a.c1.a.b()));
                jSONObject.put("type", i2);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", d.a.q0.a.c1.a.m().a());
                jSONObject.put("version", q0.D());
                jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.q0.m.e.a.h(d.a.q0.a.c1.a.b()).postRequest().cookieManager(d.a.q0.a.c1.a.p().a())).url(c2)).requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
