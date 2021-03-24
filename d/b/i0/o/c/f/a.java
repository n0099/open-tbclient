package d.b.i0.o.c.f;

import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f57189c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f57187a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f57190d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f57191e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f57192f = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.o.c.c f57188b = new d.b.i0.o.c.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f57189c = downloadCacheKey;
    }

    @Override // d.b.i0.o.c.f.c
    public void a(String str, int i) {
        if (this.f57189c == null) {
            return;
        }
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.a(this.f57189c, this.f57190d);
        }
    }

    @Override // d.b.i0.o.c.f.c
    public void b(String str) {
        if (this.f57189c == null) {
            return;
        }
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.d(this.f57189c);
        }
    }

    @Override // d.b.i0.o.c.f.c
    public void c(String str, int i) {
        if (this.f57189c == null) {
            return;
        }
        this.f57190d = i;
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setPercent(i);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.g(this.f57189c, this.f57190d);
        }
    }

    @Override // d.b.i0.o.c.f.c
    public void d(String str, StopStatus stopStatus) {
        if (this.f57189c == null) {
            return;
        }
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.e(this.f57189c, stopStatus);
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f57187a) {
            add = this.f57192f.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f57192f.isEmpty();
    }

    public void g() {
        if (this.f57189c == null) {
            return;
        }
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(this.f57189c);
        this.f57188b.a(710, this.f57189c.mPackageName, b2.getExtInfo());
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.f(this.f57189c);
        }
    }

    public void h() {
        if (this.f57189c == null) {
            return;
        }
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.b(this.f57189c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f57187a) {
            remove = this.f57192f.remove(dVar);
        }
        return remove;
    }

    public void j(String str, int i, @Nullable String str2, String str3) {
        this.f57188b.b(str, i, str2, str3);
    }

    public void k(int i) {
        this.f57191e = i;
    }

    public int l() {
        return this.f57191e;
    }

    @Override // d.b.i0.o.c.f.c
    public void onSuccess(String str, String str2) {
        if (this.f57189c == null) {
            return;
        }
        AdDownloadData b2 = d.b.i0.o.c.d.c().b(this.f57189c);
        this.f57188b.a(704, this.f57189c.mPackageName, b2.getExtInfo());
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        d.b.i0.o.c.d.c().b(this.f57189c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f57192f) {
            dVar.c(this.f57189c, str2, false);
        }
    }
}
