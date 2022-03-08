package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface Downloader {

    /* loaded from: classes7.dex */
    public interface ProgressListener {
        void onDownloadProgress(Downloader downloader, float f2, long j2);
    }

    void download(@Nullable ProgressListener progressListener) throws InterruptedException, IOException;

    float getDownloadPercentage();

    long getDownloadedBytes();

    void init() throws InterruptedException, IOException;

    void remove() throws InterruptedException;
}
