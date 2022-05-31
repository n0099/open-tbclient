package com.repackage;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes6.dex */
public interface k59 extends Runnable {

    /* loaded from: classes6.dex */
    public interface a {
        void a(DownloadException downloadException);

        void onDownloadCanceled();

        void onDownloadCompleted(String str);

        void onDownloadPaused();

        void onDownloadProgress(long j, long j2);
    }

    void cancel();

    boolean isComplete();

    boolean isDownloading();

    void pause();
}
