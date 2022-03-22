package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a extends AbsDownloadListener implements s {
    public static final String a = "a";

    public void a(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
