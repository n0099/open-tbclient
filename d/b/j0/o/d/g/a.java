package d.b.j0.o.d.g;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f59075c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f59073a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f59076d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f59077e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f59078f = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.b.j0.o.d.c f59074b = new d.b.j0.o.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f59075c = downloadCacheKey;
    }

    @Override // d.b.j0.o.d.g.c
    public void a(String str, int i) {
        if (this.f59075c == null) {
            return;
        }
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.a(this.f59075c, this.f59076d);
        }
    }

    @Override // d.b.j0.o.d.g.c
    public void b(String str) {
        if (this.f59075c == null) {
            return;
        }
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.d(this.f59075c);
        }
    }

    @Override // d.b.j0.o.d.g.c
    public void c(String str, int i) {
        if (this.f59075c == null) {
            return;
        }
        this.f59076d = i;
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setPercent(i);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.g(this.f59075c, this.f59076d);
        }
    }

    @Override // d.b.j0.o.d.g.c
    public void d(String str, StopStatus stopStatus) {
        if (this.f59075c == null) {
            return;
        }
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.e(this.f59075c, stopStatus);
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f59073a) {
            add = this.f59078f.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f59078f.isEmpty();
    }

    public void g() {
        if (this.f59075c == null) {
            return;
        }
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(this.f59075c);
        this.f59074b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f59075c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.f(this.f59075c);
        }
    }

    public void h() {
        if (this.f59075c == null) {
            return;
        }
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.b(this.f59075c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f59073a) {
            remove = this.f59078f.remove(dVar);
        }
        return remove;
    }

    public void j(int i, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f59074b.b(i, str, str2, adDownloadData);
    }

    public void k(int i) {
        this.f59077e = i;
    }

    public int l() {
        return this.f59077e;
    }

    @Override // d.b.j0.o.d.g.c
    public void onSuccess(String str, String str2) {
        if (this.f59075c == null) {
            return;
        }
        AdDownloadData b2 = d.b.j0.o.d.d.c().b(this.f59075c);
        this.f59074b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f59075c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        d.b.j0.o.d.d.c().b(this.f59075c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f59078f) {
            dVar.c(this.f59075c, str2, false);
        }
    }
}
