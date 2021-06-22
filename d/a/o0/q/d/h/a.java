package d.a.o0.q.d.h;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import d.a.o0.q.d.e;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final DownloadCacheKey f62044c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f62042a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f62045d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f62046e = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.q.d.c f62043b = new d.a.o0.q.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f62044c = downloadCacheKey;
    }

    @Override // d.a.o0.q.d.h.c
    public void a(String str, int i2) {
        if (this.f62044c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f62044c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.c(this.f62044c, b2.getPercent());
        }
    }

    @Override // d.a.o0.q.d.h.c
    public void b(String str, StopStatus stopStatus) {
        if (this.f62044c == null) {
            return;
        }
        e.c().b(this.f62044c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.f(this.f62044c, stopStatus);
        }
    }

    @Override // d.a.o0.q.d.h.c
    public void c(String str) {
        if (this.f62044c == null) {
            return;
        }
        e.c().b(this.f62044c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.e(this.f62044c);
        }
    }

    @Override // d.a.o0.q.d.h.c
    public void d(String str, int i2) {
        if (this.f62044c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f62044c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.g(this.f62044c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f62042a) {
            add = this.f62046e.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f62046e.isEmpty();
    }

    public void g() {
        if (this.f62044c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f62044c);
        this.f62043b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f62044c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.b(this.f62044c);
        }
    }

    public void h() {
        if (this.f62044c == null) {
            return;
        }
        e.c().b(this.f62044c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.d(this.f62044c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f62042a) {
            remove = this.f62046e.remove(dVar);
        }
        return remove;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f62043b.b(i2, str, str2, adDownloadData);
    }

    public void k(int i2) {
        this.f62045d = i2;
    }

    public int l() {
        return this.f62045d;
    }

    @Override // d.a.o0.q.d.h.c
    public void onSuccess(String str, String str2) {
        if (this.f62044c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f62044c);
        this.f62043b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f62044c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        e.c().b(this.f62044c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f62046e) {
            dVar.a(this.f62044c, str2, false);
        }
    }
}
