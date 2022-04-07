package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public interface uj5 {
    public static final AtomicReference<uj5> a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    sj5 c();

    void d(String str);
}
