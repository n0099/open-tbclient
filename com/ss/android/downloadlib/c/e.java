package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e implements com.ss.android.socialbase.downloader.d.c {
    @Override // com.ss.android.socialbase.downloader.d.c
    public void a(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a;
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = l.a(jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            l.a(jSONObject, "model_id", Long.valueOf(a.b()));
        }
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, a);
    }

    @Override // com.ss.android.socialbase.downloader.d.c
    public void b(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a;
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a(str, jSONObject, a);
    }
}
