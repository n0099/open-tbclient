package d.b.j0.o.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.j0.s2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public void a(int i, @Nullable String str, String str2) {
        boolean p = w.p(i);
        boolean z = i == 1000;
        d.b.j0.s2.f0.c cVar = new d.b.j0.s2.f0.c();
        if (p) {
            cVar.c(z ? "APP" : "URL");
            if (!z) {
                cVar.m(i);
            }
        } else {
            cVar.c("DOWNLOAD_BUTTON");
        }
        cVar.j(p ? SDKLogTypeConstants.CLOSE_GAME_TYPE : 2);
        cVar.h(p ? "DEEPLINK" : "DOWNLOAD_PAGE");
        if (!TextUtils.isEmpty(str)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str);
            cVar.s(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVar.u(str2);
        }
        d.b.j0.s2.f0.e.b().d(cVar);
    }

    public void b(int i, @Nullable String str, String str2, @NonNull AdDownloadData adDownloadData) {
        c(adDownloadData.getPage(), i, str, str2, adDownloadData.getDownloadUrl(), TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(adDownloadData.adId(), 0L));
    }

    public void c(String str, int i, @Nullable String str2, String str3, String str4, long j) {
        d.b.j0.s2.f0.c cVar = new d.b.j0.s2.f0.c();
        cVar.j(i);
        if (TextUtils.isEmpty(str)) {
            str = "DOWNLOAD_PAGE";
        }
        cVar.h(str);
        cVar.c("DOWNLOAD_BUTTON");
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.s(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.u(str3);
        }
        cVar.l(str2);
        cVar.p(str4);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_download_content_length", j);
            cVar.r(jSONObject.toString());
        } catch (JSONException unused) {
        }
        d.b.j0.s2.f0.e.b().d(cVar);
    }
}
