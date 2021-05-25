package d.a.n0.q.d.h;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import d.a.n0.q.d.e;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f58228c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f58226a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f58229d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f58230e = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.q.d.c f58227b = new d.a.n0.q.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f58228c = downloadCacheKey;
    }

    @Override // d.a.n0.q.d.h.c
    public void a(String str, int i2) {
        if (this.f58228c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f58228c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.c(this.f58228c, b2.getPercent());
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void b(String str, StopStatus stopStatus) {
        if (this.f58228c == null) {
            return;
        }
        e.c().b(this.f58228c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.f(this.f58228c, stopStatus);
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void c(String str) {
        if (this.f58228c == null) {
            return;
        }
        e.c().b(this.f58228c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.e(this.f58228c);
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void d(String str, int i2) {
        if (this.f58228c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f58228c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.g(this.f58228c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f58226a) {
            add = this.f58230e.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f58230e.isEmpty();
    }

    public void g() {
        if (this.f58228c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f58228c);
        this.f58227b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f58228c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.b(this.f58228c);
        }
    }

    public void h() {
        if (this.f58228c == null) {
            return;
        }
        e.c().b(this.f58228c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.d(this.f58228c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f58226a) {
            remove = this.f58230e.remove(dVar);
        }
        return remove;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f58227b.b(i2, str, str2, adDownloadData);
    }

    public void k(int i2) {
        this.f58229d = i2;
    }

    public int l() {
        return this.f58229d;
    }

    @Override // d.a.n0.q.d.h.c
    public void onSuccess(String str, String str2) {
        if (this.f58228c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f58228c);
        this.f58227b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f58228c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        e.c().b(this.f58228c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f58230e) {
            dVar.a(this.f58228c, str2, false);
        }
    }
}
