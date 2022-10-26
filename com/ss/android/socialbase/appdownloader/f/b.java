package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static void a(DownloadInfo downloadInfo) {
        b(downloadInfo);
    }

    public static void b(final DownloadInfo downloadInfo) {
        final int i;
        final Context N = com.ss.android.socialbase.downloader.downloader.c.N();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.c.b(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        if (z) {
            i = com.ss.android.socialbase.appdownloader.c.a(N, downloadInfo.getId(), false);
        } else {
            i = 2;
        }
        com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.f.b.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                com.ss.android.socialbase.appdownloader.c.d b = com.ss.android.socialbase.appdownloader.d.j().b();
                z downloadNotificationEventListener = Downloader.getInstance(N).getDownloadNotificationEventListener(downloadInfo.getId());
                if (b != null || downloadNotificationEventListener != null) {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        try {
                            PackageInfo a = com.ss.android.socialbase.appdownloader.c.a(downloadInfo, file);
                            if (a != null) {
                                if (i != 1 && !TextUtils.isEmpty(downloadInfo.getPackageName())) {
                                    str = downloadInfo.getPackageName();
                                } else {
                                    str = a.packageName;
                                }
                                String str2 = str;
                                if (b != null) {
                                    b.a(downloadInfo.getId(), 1, str2, -3, downloadInfo.getDownloadTime());
                                }
                                if (downloadNotificationEventListener != null) {
                                    downloadNotificationEventListener.a(1, downloadInfo, str2, "");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
