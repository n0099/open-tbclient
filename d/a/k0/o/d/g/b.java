package d.a.k0.o.d.g;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.k0.o.d.f.a f57809a;

    public b(@NonNull d.a.k0.o.d.f.a aVar) {
        this.f57809a = aVar;
    }

    @Override // d.a.k0.o.d.g.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        this.f57809a.e(100);
        this.f57809a.f(b2.extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        this.f57809a.e(100);
        this.f57809a.f(b2.extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void c(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        this.f57809a.f(d.a.k0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(downloadCacheKey);
        this.f57809a.e(100);
        this.f57809a.f(b2.extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.f57809a.f(d.a.k0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.f57809a.f(d.a.k0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.a.k0.o.d.g.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i2) {
        this.f57809a.e(d.a.k0.o.d.d.c().b(downloadCacheKey).extra().getPercent());
    }
}
