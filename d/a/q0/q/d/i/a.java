package d.a.q0.q.d.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import d.a.q0.q.d.h.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f62090a = new AtomicReference<>();

    void a(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c c();

    void d(String str);
}
