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
    public final DownloadCacheKey f61919c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f61917a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f61920d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f61921e = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.q.d.c f61918b = new d.a.n0.q.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f61919c = downloadCacheKey;
    }

    @Override // d.a.n0.q.d.h.c
    public void a(String str, int i2) {
        if (this.f61919c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f61919c);
        b2.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.c(this.f61919c, b2.getPercent());
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void b(String str, StopStatus stopStatus) {
        if (this.f61919c == null) {
            return;
        }
        e.c().b(this.f61919c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.f(this.f61919c, stopStatus);
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void c(String str) {
        if (this.f61919c == null) {
            return;
        }
        e.c().b(this.f61919c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.e(this.f61919c);
        }
    }

    @Override // d.a.n0.q.d.h.c
    public void d(String str, int i2) {
        if (this.f61919c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f61919c);
        b2.extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.g(this.f61919c, b2.getPercent());
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f61917a) {
            add = this.f61921e.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f61921e.isEmpty();
    }

    public void g() {
        if (this.f61919c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f61919c);
        this.f61918b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f61919c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.b(this.f61919c);
        }
    }

    public void h() {
        if (this.f61919c == null) {
            return;
        }
        e.c().b(this.f61919c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.d(this.f61919c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f61917a) {
            remove = this.f61921e.remove(dVar);
        }
        return remove;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f61918b.b(i2, str, str2, adDownloadData);
    }

    public void k(int i2) {
        this.f61920d = i2;
    }

    public int l() {
        return this.f61920d;
    }

    @Override // d.a.n0.q.d.h.c
    public void onSuccess(String str, String str2) {
        if (this.f61919c == null) {
            return;
        }
        AdDownloadData b2 = e.c().b(this.f61919c);
        this.f61918b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f61919c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        e.c().b(this.f61919c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f61921e) {
            dVar.a(this.f61919c, str2, false);
        }
    }
}
