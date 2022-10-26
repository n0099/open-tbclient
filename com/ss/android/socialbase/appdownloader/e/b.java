package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes8.dex */
public class b extends com.ss.android.socialbase.downloader.depend.d {
    public Context a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public com.ss.android.socialbase.downloader.notification.a g;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = com.ss.android.socialbase.downloader.downloader.c.N();
        }
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public b(com.ss.android.socialbase.downloader.notification.a aVar) {
        this.a = com.ss.android.socialbase.downloader.downloader.c.N();
        this.g = aVar;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onPause(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onPrepare(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onProgress(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onStart(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo != null && this.a != null) {
            if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
                super.onSuccessed(downloadInfo);
            }
            if (downloadInfo.isAutoInstall()) {
                com.ss.android.socialbase.appdownloader.f.b.a(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.d
    public com.ss.android.socialbase.downloader.notification.a a() {
        Context context;
        if (this.g == null && (context = this.a) != null) {
            return new a(context, this.b, this.c, this.d, this.e, this.f);
        }
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.depend.d, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo != null && this.a != null && downloadInfo.canShowNotification() && !downloadInfo.isAutoInstallWithoutNotification()) {
            super.onFailed(downloadInfo, baseException);
        }
    }
}
