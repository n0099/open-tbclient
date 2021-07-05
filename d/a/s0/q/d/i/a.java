package d.a.s0.q.d.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import d.a.s0.q.d.h.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f64710a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c c();

    void d(String str);
}
