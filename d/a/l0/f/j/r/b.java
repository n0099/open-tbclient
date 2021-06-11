package d.a.l0.f.j.r;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.service.AsInstallService;
import com.baidubce.AbstractBceClient;
import d.a.l0.a.j2.k;
import d.a.l0.a.j2.p.e;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f50625a = new b();

    public static b n() {
        return f50625a;
    }

    public void a(String str) {
        e eVar = new e();
        eVar.f46862b = "beforeConfigRequest";
        eVar.f46865e = str;
        k.g(eVar);
    }

    public void b(String str, String str2, String str3, String str4) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str5 = z != null ? z.configName : "";
        String str6 = z != null ? z.targetAppPackageId : "";
        String str7 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = str;
        eVar.f46867g = "gbview";
        eVar.f46865e = str2;
        eVar.a("gameAppkey", str3);
        eVar.a("gamePosition", str4);
        eVar.a("configName", str5);
        eVar.a("targetPackageName", str6);
        eVar.a("targetDownloadUrl", str7);
        k.g(eVar);
    }

    public void c(String str) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str2 = z != null ? z.configName : "";
        String str3 = z != null ? z.targetAppPackageId : "";
        String str4 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = str;
        eVar.f46867g = "gbview";
        eVar.a("configName", str2);
        eVar.a("targetPackageName", str3);
        eVar.a("targetDownloadUrl", str4);
        if (str3.equals(d.a.l0.f.j.m.c.f50548a)) {
            if (q0.F(d.a.l0.a.c1.a.b(), str3)) {
                eVar.a("isGamenowInstalled", "1");
            } else {
                eVar.a("isGamenowInstalled", "2");
            }
        }
        k.g(eVar);
    }

    public void d(String str, boolean z, String str2) {
        e eVar = new e();
        eVar.f46862b = "request";
        eVar.f46867g = "wdview";
        eVar.a("requestStatus", str);
        eVar.a("isFromNet", z ? "0" : "1");
        eVar.a("errMsg", str2);
        k.g(eVar);
        if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.b.g0) || (TextUtils.equals(str, IntentConfig.START) && !z)) {
            o();
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str7 = z != null ? z.configName : "";
        String str8 = z != null ? z.targetAppPackageId : "";
        String str9 = z != null ? z.targetAppDownloadUrl : "";
        if (!TextUtils.equals(str8, d.a.l0.f.j.m.c.f50548a)) {
            str6 = str9;
        }
        e eVar = new e();
        eVar.f46862b = str;
        eVar.f46867g = str2;
        eVar.f46865e = str3;
        eVar.a("gameAppkey", str4);
        eVar.a("gamePosition", str5);
        eVar.a("configName", str7);
        eVar.a("targetPackageName", str8);
        eVar.a("targetDownloadUrl", str6);
        k.g(eVar);
    }

    public void f(String str, a aVar, String str2, String str3, String str4) {
        JSONObject d2 = w.d(str3);
        c cVar = new c();
        cVar.g(aVar);
        cVar.f46862b = str;
        cVar.f46867g = d2.optString("from_view");
        cVar.f46865e = d2.optString("from_value");
        cVar.a("configName", d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
        cVar.a("targetPackageName", str2);
        cVar.a("targetDownloadUrl", str4);
        k.g(cVar);
    }

    public void g(String str, a aVar, String str2, String str3, int i2, String str4) {
        JSONObject d2 = w.d(str3);
        long optLong = d2.optLong("download_finish_time");
        long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
        c cVar = new c();
        cVar.g(aVar);
        cVar.f46865e = d2.optString("from_value");
        cVar.f46862b = str;
        cVar.f46867g = d2.optString("from_view");
        cVar.a("error_code", Integer.valueOf(i2));
        cVar.a("configName", d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
        if (elapsedRealtime != 0) {
            cVar.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
        }
        cVar.a("targetPackageName", str2);
        cVar.a("targetDownloadUrl", str4);
        if (TextUtils.equals(str, "package_expired")) {
            cVar.a("downloadStatus", d2.optString("download_status"));
        }
        if (TextUtils.equals(str, "analysisFailed")) {
            long optLong2 = d2.optLong("download_current_bytes");
            long optLong3 = d2.optLong("download_total_bytes");
            cVar.a("downloadCurrentBytes", Long.valueOf(optLong2));
            cVar.a("downloadTotalBytes", Long.valueOf(optLong3));
        }
        k.u("936", cVar);
    }

    public void h(String str, a aVar, String str2, String str3, String str4) {
        g(str, aVar, str2, str3, 0, str4);
    }

    public void i(int i2) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str = z != null ? z.configName : "";
        String str2 = z != null ? z.targetAppPackageId : "";
        String str3 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = "guideClick";
        eVar.f46867g = "wdview";
        eVar.a("guideViewNum", String.valueOf(i2));
        eVar.a("configName", str);
        eVar.a("targetPackageName", str2);
        eVar.a("targetDownloadUrl", str3);
        k.g(eVar);
    }

    public void j(String str, int i2, int i3) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str2 = z != null ? z.configName : "";
        String str3 = z != null ? z.targetAppPackageId : "";
        String str4 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = "wdDialogClick";
        eVar.f46867g = "wdview";
        eVar.f46865e = str;
        eVar.a("coinsThisTime", String.valueOf(i2));
        eVar.a("coinsTotal", String.valueOf(i3));
        eVar.a("configName", str2);
        eVar.a("targetPackageName", str3);
        eVar.a("targetDownloadUrl", str4);
        k.g(eVar);
    }

    public void k(int i2, int i3) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str = z != null ? z.configName : "";
        String str2 = z != null ? z.targetAppPackageId : "";
        String str3 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = "wdDialogShow";
        eVar.f46867g = "wdview";
        eVar.a("coinsThisTime", String.valueOf(i2));
        eVar.a("coinsTotal", String.valueOf(i3));
        eVar.a("configName", str);
        eVar.a("targetPackageName", str2);
        eVar.a("targetDownloadUrl", str3);
        if (str2.equals(d.a.l0.f.j.m.c.f50548a)) {
            if (q0.F(d.a.l0.a.c1.a.b(), str2)) {
                eVar.a("isGamenowInstalled", "1");
            } else {
                eVar.a("isGamenowInstalled", "2");
            }
        }
        k.g(eVar);
    }

    public void l() {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str = z != null ? z.configName : "";
        String str2 = z != null ? z.targetAppPackageId : "";
        String str3 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46862b = "guideShow";
        eVar.f46867g = "wdview";
        eVar.a("configName", str);
        eVar.a("targetPackageName", str2);
        eVar.a("targetDownloadUrl", str3);
        k.g(eVar);
    }

    public void m(String str, String str2, int i2) {
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        String str3 = z != null ? z.configName : "";
        String str4 = z != null ? z.targetAppPackageId : "";
        String str5 = z != null ? z.targetAppDownloadUrl : "";
        e eVar = new e();
        eVar.f46867g = str;
        eVar.f46865e = str2;
        eVar.a("configName", str3);
        eVar.a("targetPackageName", str4);
        eVar.a("targetDownloadUrl", str5);
        eVar.a("GamenowDownloadStatus", Integer.valueOf(i2));
        k.g(eVar);
    }

    public final void o() {
        d.a.l0.a.h0.c.a.b.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
    }

    public void p(int i2, String str, String str2, String str3) {
        String c2 = d.a.l0.h.t.a.b().c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            jSONObject.put("type", i2);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            jSONObject.put("host", d.a.l0.a.c1.a.m().a());
            jSONObject.put("version", q0.D());
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, str);
            jSONObject.put("appid", str2);
            jSONObject.put("url", str3);
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.l0.m.e.a.h(d.a.l0.a.c1.a.b()).postRequest().cookieManager(d.a.l0.a.c1.a.p().a())).url(c2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
        } catch (Exception unused) {
        }
    }

    public void q(int i2, String str, String str2, int i3, String str3, long j, long j2) {
        String c2 = d.a.l0.h.t.a.b().c();
        JSONObject jSONObject = new JSONObject();
        String str4 = TextUtils.equals(str, d.a.l0.f.j.m.c.f50548a) ? "2101000000" : "";
        d.a.l0.f.j.b bVar = d.a.l0.f.j.b.o;
        if (bVar != null && bVar.z() != null && !TextUtils.isEmpty(d.a.l0.f.j.b.o.z().gamenowChannel)) {
            str4 = d.a.l0.f.j.b.o.z().gamenowChannel;
        }
        try {
            jSONObject.put("error_code", i2);
            jSONObject.put("time", System.currentTimeMillis() / 1000);
            jSONObject.put("packagename", str);
            jSONObject.put("downloadurl", str2);
            jSONObject.put("channel", str4);
            jSONObject.put("currentBytes", j);
            jSONObject.put("totalBytes", j2);
            jSONObject.put("errorReason", i3);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("fileMd5", str3);
            }
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.l0.m.e.a.h(d.a.l0.a.c1.a.b()).postRequest().cookieManager(d.a.l0.a.c1.a.p().a())).url(c2)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
        } catch (Exception unused) {
        }
    }
}
