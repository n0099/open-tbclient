package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    public static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onFirstSuccess -- " + downloadInfo.getName());
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onIntercept -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((((float) downloadInfo.getCurBytes()) / ((float) downloadInfo.getTotalBytes())) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.c.a.b(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.c.a.a() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        com.ss.android.socialbase.downloader.c.a.b(str, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }
}
