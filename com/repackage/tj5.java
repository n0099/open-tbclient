package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes7.dex */
public interface tj5 {
    void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z);

    void b(@NonNull DownloadCacheKey downloadCacheKey);

    void c(@NonNull DownloadCacheKey downloadCacheKey, int i);

    void d(@NonNull DownloadCacheKey downloadCacheKey);

    void e(@NonNull DownloadCacheKey downloadCacheKey);

    void f(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus);

    void g(@NonNull DownloadCacheKey downloadCacheKey, int i);
}
