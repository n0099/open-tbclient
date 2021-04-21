package d.b.j0.o.d.g;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.j0.o.d.f.a f59079a;

    public b(@NonNull d.b.j0.o.d.f.a aVar) {
        this.f59079a = aVar;
    }

    @Override // d.b.j0.o.d.g.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.f59079a.f(d.b.j0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(downloadCacheKey);
        this.f59079a.e(100);
        this.f59079a.f(b2.extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void c(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(downloadCacheKey);
        this.f59079a.e(100);
        this.f59079a.f(b2.extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        this.f59079a.f(d.b.j0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.f59079a.f(d.b.j0.o.d.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(downloadCacheKey);
        this.f59079a.e(100);
        this.f59079a.f(b2.extra().getStatus());
    }

    @Override // d.b.j0.o.d.g.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.f59079a.e(d.b.j0.o.d.d.c().b(downloadCacheKey).extra().getPercent());
    }
}
