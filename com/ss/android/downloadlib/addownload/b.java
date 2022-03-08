package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static volatile b a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f57994b = null;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public boolean b() {
        return j.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void a(Context context, DownloadInfo downloadInfo) {
        if (b() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f57994b == null) {
                this.f57994b = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f57994b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.1
                @Override // java.lang.Runnable
                public void run() {
                    j.c().a(3, j.getContext(), null, "下载失败，请重试！", null, 0);
                    e a2 = com.ss.android.downloadlib.f.a().a(url);
                    if (a2 != null) {
                        a2.g();
                    }
                }
            });
        }
    }
}
