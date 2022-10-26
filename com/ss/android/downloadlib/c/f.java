package com.ss.android.downloadlib.c;

import android.content.Context;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f implements com.ss.android.socialbase.appdownloader.c.d {
    public Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.a.b a;
        Context context = this.a;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 == 7) {
                            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_click", a);
                            return;
                        }
                        return;
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_continue", a);
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_pause", a);
                return;
            }
            com.ss.android.downloadlib.d.a.a().a("download_notification", "download_notification_install", com.ss.android.downloadlib.a.b(new JSONObject(), downloadInfo), a);
            return;
        }
        com.ss.android.downloadlib.a.a(downloadInfo, a);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
            com.ss.android.downloadlib.addownload.a.a().a(downloadInfo, a.b(), a.l(), a.e(), downloadInfo.getTitle(), a.d(), downloadInfo.getTargetFilePath());
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.a;
        if (context != null && (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) != null && downloadInfo.getStatus() == -3) {
            downloadInfo.setPackageName(str2);
            com.ss.android.downloadlib.addownload.b.a().a(this.a, downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        com.ss.android.downloadlib.a.a().a(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.f.a().a(downloadInfo);
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.d.a.a().a(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        return com.ss.android.downloadlib.addownload.b.a().b();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i, boolean z) {
        if (j.n() != null) {
            return j.n().a(z);
        }
        return false;
    }
}
