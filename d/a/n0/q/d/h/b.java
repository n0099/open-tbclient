package d.a.n0.q.d.h;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import d.a.n0.q.d.e;
/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.q.d.g.a f58231a;

    public b(@NonNull d.a.n0.q.d.g.a aVar) {
        this.f58231a = aVar;
    }

    @Override // d.a.n0.q.d.h.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        this.f58231a.g(100);
        this.f58231a.h(b2.extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        this.f58231a.g(100);
        this.f58231a.h(b2.extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void c(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        this.f58231a.h(e.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        this.f58231a.g(100);
        this.f58231a.h(b2.extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.f58231a.h(e.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.f58231a.h(e.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.n0.q.d.h.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        this.f58231a.g(e.c().b(downloadCacheKey).extra().getPercent());
    }
}
