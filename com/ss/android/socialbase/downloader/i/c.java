package com.ss.android.socialbase.downloader.i;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes8.dex */
public class c {
    public static void a(int i, SparseArray sparseArray, boolean z, DownloadInfo downloadInfo, BaseException baseException) {
        SparseArray clone;
        if (z && sparseArray != null) {
            try {
                if (sparseArray.size() > 0) {
                    synchronized (sparseArray) {
                        clone = sparseArray.clone();
                    }
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        IDownloadListener iDownloadListener = (IDownloadListener) clone.get(clone.keyAt(i2));
                        if (iDownloadListener != null) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 4) {
                                        if (i != 5) {
                                            if (i != 6) {
                                                if (i != 7) {
                                                    if (i != 11) {
                                                        switch (i) {
                                                            case -7:
                                                                if (iDownloadListener instanceof AbsDownloadListener) {
                                                                    ((AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                                                    break;
                                                                } else {
                                                                    continue;
                                                                }
                                                            case -6:
                                                                iDownloadListener.onFirstSuccess(downloadInfo);
                                                                continue;
                                                            case -5:
                                                            case -2:
                                                                iDownloadListener.onPause(downloadInfo);
                                                                continue;
                                                            case -4:
                                                                iDownloadListener.onCanceled(downloadInfo);
                                                                continue;
                                                            case -3:
                                                                iDownloadListener.onSuccessed(downloadInfo);
                                                                continue;
                                                            case -1:
                                                                iDownloadListener.onFailed(downloadInfo, baseException);
                                                                continue;
                                                            default:
                                                                continue;
                                                        }
                                                    } else if (iDownloadListener instanceof s) {
                                                        ((s) iDownloadListener).a(downloadInfo);
                                                    }
                                                } else {
                                                    iDownloadListener.onRetryDelay(downloadInfo, baseException);
                                                }
                                            } else {
                                                iDownloadListener.onFirstStart(downloadInfo);
                                            }
                                        } else {
                                            iDownloadListener.onRetry(downloadInfo, baseException);
                                        }
                                    } else {
                                        iDownloadListener.onProgress(downloadInfo);
                                    }
                                } else {
                                    iDownloadListener.onStart(downloadInfo);
                                }
                            } else {
                                iDownloadListener.onPrepare(downloadInfo);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
