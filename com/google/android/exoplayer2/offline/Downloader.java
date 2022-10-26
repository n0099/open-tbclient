package com.google.android.exoplayer2.offline;

import java.io.IOException;
/* loaded from: classes7.dex */
public interface Downloader {

    /* loaded from: classes7.dex */
    public interface ProgressListener {
        void onDownloadProgress(Downloader downloader, float f, long j);
    }

    void download(ProgressListener progressListener) throws InterruptedException, IOException;

    float getDownloadPercentage();

    long getDownloadedBytes();

    void init() throws InterruptedException, IOException;

    void remove() throws InterruptedException;
}
