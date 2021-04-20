package d.b.i0.o.d.g;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes4.dex */
public interface d {
    void a(@NonNull DownloadCacheKey downloadCacheKey, int i);

    void b(@NonNull DownloadCacheKey downloadCacheKey);

    void c(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z);

    void d(@NonNull DownloadCacheKey downloadCacheKey);

    void e(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus);

    void f(@NonNull DownloadCacheKey downloadCacheKey);

    void g(@NonNull DownloadCacheKey downloadCacheKey, int i);
}
