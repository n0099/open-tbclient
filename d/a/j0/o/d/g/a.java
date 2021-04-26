package d.a.j0.o.d.g;

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
    public final DownloadCacheKey f57098c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f57096a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f57099d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f57100e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f57101f = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.j0.o.d.c f57097b = new d.a.j0.o.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f57098c = downloadCacheKey;
    }

    @Override // d.a.j0.o.d.g.c
    public void a(String str, int i2) {
        if (this.f57098c == null) {
            return;
        }
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.c(this.f57098c, this.f57099d);
        }
    }

    @Override // d.a.j0.o.d.g.c
    public void b(String str, StopStatus stopStatus) {
        if (this.f57098c == null) {
            return;
        }
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.f(this.f57098c, stopStatus);
        }
    }

    @Override // d.a.j0.o.d.g.c
    public void c(String str) {
        if (this.f57098c == null) {
            return;
        }
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.e(this.f57098c);
        }
    }

    @Override // d.a.j0.o.d.g.c
    public void d(String str, int i2) {
        if (this.f57098c == null) {
            return;
        }
        this.f57099d = i2;
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setPercent(i2);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.g(this.f57098c, this.f57099d);
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f57096a) {
            add = this.f57101f.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f57101f.isEmpty();
    }

    public void g() {
        if (this.f57098c == null) {
            return;
        }
        AdDownloadData b2 = d.a.j0.o.d.d.c().b(this.f57098c);
        this.f57097b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f57098c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.b(this.f57098c);
        }
    }

    public void h() {
        if (this.f57098c == null) {
            return;
        }
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.d(this.f57098c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f57096a) {
            remove = this.f57101f.remove(dVar);
        }
        return remove;
    }

    public void j(int i2, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f57097b.b(i2, str, str2, adDownloadData);
    }

    public void k(int i2) {
        this.f57100e = i2;
    }

    public int l() {
        return this.f57100e;
    }

    @Override // d.a.j0.o.d.g.c
    public void onSuccess(String str, String str2) {
        if (this.f57098c == null) {
            return;
        }
        AdDownloadData b2 = d.a.j0.o.d.d.c().b(this.f57098c);
        this.f57097b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f57098c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        d.a.j0.o.d.d.c().b(this.f57098c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f57101f) {
            dVar.a(this.f57098c, str2, false);
        }
    }
}
