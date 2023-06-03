package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
/* loaded from: classes10.dex */
public interface f {
    f a(long j);

    f a(IDownloadButtonClickListener iDownloadButtonClickListener);

    f a(OnItemClickListener onItemClickListener);

    void a();

    void a(boolean z);

    boolean a(int i);

    f b(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    f b(Context context);

    f b(DownloadController downloadController);

    f b(DownloadEventConfig downloadEventConfig);

    f b(DownloadModel downloadModel);

    void b(int i);

    boolean b();

    long d();

    void h();
}
