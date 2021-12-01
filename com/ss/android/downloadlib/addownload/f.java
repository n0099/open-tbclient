package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
/* loaded from: classes2.dex */
public interface f {
    f a(long j2);

    f a(IDownloadButtonClickListener iDownloadButtonClickListener);

    f a(u uVar);

    void a();

    void a(boolean z);

    boolean a(int i2);

    f b(int i2, DownloadStatusChangeListener downloadStatusChangeListener);

    f b(Context context);

    f b(DownloadController downloadController);

    f b(DownloadEventConfig downloadEventConfig);

    f b(DownloadModel downloadModel);

    void b(int i2);

    boolean b();

    long d();

    void h();
}
