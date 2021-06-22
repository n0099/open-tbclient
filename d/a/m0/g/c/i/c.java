package d.a.m0.g.c.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidubce.AbstractBceClient;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50852a = k.f46983a;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String l = b.l(str2);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        if (f50852a) {
            Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b();
        bVar.m(aVar);
        bVar.f46970b = l;
        bVar.f46973e = str3;
        bVar.v = str;
        bVar.l = q0.D();
        if (e.Q() != null) {
            b.a L = e.Q().L();
            bVar.f46969a = d.a.m0.a.j2.k.m(L.G());
            bVar.f46974f = L.H();
            bVar.f46971c = L.T();
        }
        bVar.t = str4;
        d.a.m0.a.j2.k.u("1245", bVar);
    }

    public static void b(String str, String str2) {
        c(str, str2, "");
    }

    public static void c(String str, String str2, String str3) {
        String l = b.l(str);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        b bVar = new b();
        bVar.f46970b = l;
        bVar.a(InstallNotifyReceiver.OPPORTUNITY, str2);
        if (str3 == null) {
            str3 = "";
        }
        bVar.a("packageName", str3);
        d.a.m0.a.j2.k.u("1245", bVar);
    }

    public static void d(int i2, String str, String str2, String str3) {
        String c2 = d.a.m0.h.t.a.b().c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cuid", d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b()));
            jSONObject.put("type", i2);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            jSONObject.put("host", d.a.m0.a.c1.a.m().a());
            jSONObject.put("version", q0.D());
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, str);
            jSONObject.put("appid", str2);
            jSONObject.put("url", str3);
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.m0.m.e.a.h(d.a.m0.a.c1.a.b()).postRequest().cookieManager(d.a.m0.a.c1.a.p().a())).url(c2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
        } catch (Exception unused) {
        }
    }
}
