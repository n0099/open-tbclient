package com.repackage;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes7.dex */
public interface s89 extends Runnable {

    /* loaded from: classes7.dex */
    public interface a {
        void b(DownloadException downloadException);

        void onConnectCanceled();

        void onConnectPaused();

        void onConnected(long j, long j2, boolean z);

        void onConnecting();
    }

    void cancel();

    boolean isCanceled();

    boolean isPaused();

    void pause();
}
