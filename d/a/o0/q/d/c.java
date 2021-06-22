package d.a.o0.q.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.o0.t2.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public void a(int i2, @Nullable String str, String str2) {
        boolean p = y.p(i2);
        boolean z = i2 == 1000;
        d.a.o0.t2.i0.c cVar = new d.a.o0.t2.i0.c();
        if (p) {
            cVar.c(z ? "APP" : "URL");
            if (!z) {
                cVar.l(i2);
            }
        } else {
            cVar.c("DOWNLOAD_BUTTON");
        }
        cVar.i(p ? SDKLogTypeConstants.CLOSE_GAME_TYPE : 2);
        cVar.h(p ? "DEEPLINK" : "DOWNLOAD_PAGE");
        if (!TextUtils.isEmpty(str)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str);
            cVar.r(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVar.t(str2);
        }
        d.a.o0.t2.i0.e.b().d(cVar);
    }

    public void b(int i2, @Nullable String str, String str2, @NonNull AdDownloadData adDownloadData) {
        c(adDownloadData.getPage(), i2, str, str2, adDownloadData.getDownloadUrl(), TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(adDownloadData.adId(), 0L));
    }

    public void c(String str, int i2, @Nullable String str2, String str3, String str4, long j) {
        d.a.o0.t2.i0.c cVar = new d.a.o0.t2.i0.c();
        cVar.i(i2);
        if (TextUtils.isEmpty(str)) {
            str = "DOWNLOAD_PAGE";
        }
        cVar.h(str);
        cVar.c("DOWNLOAD_BUTTON");
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.r(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.t(str3);
        }
        cVar.k(str2);
        cVar.o(str4);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_download_content_length", j);
            cVar.q(jSONObject.toString());
        } catch (JSONException unused) {
        }
        d.a.o0.t2.i0.e.b().d(cVar);
    }
}
