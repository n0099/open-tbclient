package d.a.k0.o.d.g;

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
    public final DownloadCacheKey f57805c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f57803a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f57806d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f57807e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f57808f = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.k0.o.d.c f57804b = new d.a.k0.o.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f57805c = downloadCacheKey;
    }

    @Override // d.a.k0.o.d.g.c
    public void a(String str, int i2) {
        if (this.f57805c == null) {
            return;
        }
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.c(this.f57805c, this.f57806d);
        }
    }

    @Override // d.a.k0.o.d.g.c
    public void b(String str, StopStatus stopStatus) {
        if (this.f57805c == null) {
            return;
        }
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.f(this.f57805c, stopStatus);
        }
    }

    @Override // d.a.k0.o.d.g.c
    public void c(String str) {
        if (this.f57805c == null) {
            return;
        }
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.e(this.f57805c);
        }
    }

    @Override // d.a.k0.o.d.g.c
    public void d(String str, int i2) {
        if (this.f57805c == null) {
            return;
        }
        this.f57806d = i2;
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.g(this.f57805c, this.f57806d);
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f57803a) {
            add = this.f57808f.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f57808f.isEmpty();
    }

    public void g() {
        if (this.f57805c == null) {
            return;
        }
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(this.f57805c);
        this.f57804b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f57805c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.b(this.f57805c);
        }
    }

    public void h() {
        if (this.f57805c == null) {
            return;
        }
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.d(this.f57805c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f57803a) {
            remove = this.f57808f.remove(dVar);
        }
        return remove;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f57804b.b(i2, str, str2, adDownloadData);
    }

    public void k(int i2) {
        this.f57807e = i2;
    }

    public int l() {
        return this.f57807e;
    }

    @Override // d.a.k0.o.d.g.c
    public void onSuccess(String str, String str2) {
        if (this.f57805c == null) {
            return;
        }
        AdDownloadData b2 = d.a.k0.o.d.d.c().b(this.f57805c);
        this.f57804b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f57805c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        d.a.k0.o.d.d.c().b(this.f57805c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f57808f) {
            dVar.a(this.f57805c, str2, false);
        }
    }
}
