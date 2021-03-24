package d.b.i0.o.c.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import d.b.i0.o.c.f.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f57194a = new AtomicReference<>();

    c a();

    void b(String str);

    void c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    void d(String str);
}
