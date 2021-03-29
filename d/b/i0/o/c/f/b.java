package d.b.i0.o.c.f;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes4.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.i0.o.c.e.a f57194a;

    public b(@NonNull d.b.i0.o.c.e.a aVar) {
        this.f57194a = aVar;
    }

    @Override // d.b.i0.o.c.f.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.f57194a.f(d.b.i0.o.c.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(downloadCacheKey);
        this.f57194a.e(100);
        this.f57194a.f(b2.extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void c(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(downloadCacheKey);
        this.f57194a.e(100);
        this.f57194a.f(b2.extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void d(@NonNull DownloadCacheKey downloadCacheKey) {
        this.f57194a.f(d.b.i0.o.c.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.f57194a.f(d.b.i0.o.c.d.c().b(downloadCacheKey).extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(downloadCacheKey);
        this.f57194a.e(100);
        this.f57194a.f(b2.extra().getStatus());
    }

    @Override // d.b.i0.o.c.f.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.f57194a.e(d.b.i0.o.c.d.c().b(downloadCacheKey).extra().getPercent());
    }
}
