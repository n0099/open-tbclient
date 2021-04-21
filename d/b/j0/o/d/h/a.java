package d.b.j0.o.d.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import d.b.j0.o.d.g.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f59080a = new AtomicReference<>();

    c a();

    void b(String str);

    void c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    void d(String str);
}
