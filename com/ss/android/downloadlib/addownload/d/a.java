package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements d {
    public static com.ss.android.downloadlib.addownload.a.c a;

    public static com.ss.android.downloadlib.addownload.a.c a() {
        return a;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(final com.ss.android.downloadad.api.a.b bVar, int i2, final c cVar) {
        DownloadInfo a2;
        if (bVar == null || bVar.ac() || !a(bVar) || (a2 = com.ss.android.downloadlib.g.a((Context) null).a(bVar.a())) == null) {
            return false;
        }
        long a3 = i.a(a2.getId(), a2.getCurBytes(), a2.getTotalBytes());
        long totalBytes = a2.getTotalBytes();
        if (a3 <= 0 || totalBytes <= 0 || totalBytes > a(bVar.s())) {
            return false;
        }
        a = new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.d.a.1
            @Override // com.ss.android.downloadlib.addownload.a.c
            public void a() {
                com.ss.android.downloadlib.addownload.a.c unused = a.a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
            }

            @Override // com.ss.android.downloadlib.addownload.a.c
            public void b() {
                com.ss.android.downloadlib.addownload.a.c unused = a.a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
                cVar.a(bVar);
            }
        };
        TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", a(totalBytes - a3)), "继续", "暂停");
        bVar.n(true);
        return true;
    }

    private int a(int i2) {
        return com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean a(com.ss.android.downloadad.api.a.a aVar) {
        return com.ss.android.downloadlib.g.e.a(aVar).a("pause_optimise_apk_size_switch", 0) == 1 && aVar.q();
    }

    public static String a(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j2 >= 1073741824) {
            return (j2 / 1073741824) + "G";
        } else if (j2 >= 1048576) {
            return (j2 / 1048576) + "M";
        } else {
            return decimalFormat.format(((float) j2) / 1048576.0f) + "M";
        }
    }
}
