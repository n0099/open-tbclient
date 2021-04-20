package d.b.i0.o.d.g;

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
    public final DownloadCacheKey f58654c;

    /* renamed from: a  reason: collision with root package name */
    public final Object f58652a = new Object();

    /* renamed from: d  reason: collision with root package name */
    public int f58655d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f58656e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d> f58657f = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.o.d.c f58653b = new d.b.i0.o.d.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.f58654c = downloadCacheKey;
    }

    @Override // d.b.i0.o.d.g.c
    public void a(String str, int i) {
        if (this.f58654c == null) {
            return;
        }
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.a(this.f58654c, this.f58655d);
        }
    }

    @Override // d.b.i0.o.d.g.c
    public void b(String str) {
        if (this.f58654c == null) {
            return;
        }
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.d(this.f58654c);
        }
    }

    @Override // d.b.i0.o.d.g.c
    public void c(String str, int i) {
        if (this.f58654c == null) {
            return;
        }
        this.f58655d = i;
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setPercent(i);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.g(this.f58654c, this.f58655d);
        }
    }

    @Override // d.b.i0.o.d.g.c
    public void d(String str, StopStatus stopStatus) {
        if (this.f58654c == null) {
            return;
        }
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.e(this.f58654c, stopStatus);
        }
    }

    public boolean e(d dVar) {
        boolean add;
        synchronized (this.f58652a) {
            add = this.f58657f.add(dVar);
        }
        return add;
    }

    public boolean f() {
        return this.f58657f.isEmpty();
    }

    public void g() {
        if (this.f58654c == null) {
            return;
        }
        AdDownloadData b2 = d.b.i0.o.d.d.c().b(this.f58654c);
        this.f58653b.b(SDKLogTypeConstants.TYPE_FOR_XUZHANG, this.f58654c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b2.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.f(this.f58654c);
        }
    }

    public void h() {
        if (this.f58654c == null) {
            return;
        }
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.b(this.f58654c);
        }
    }

    public boolean i(d dVar) {
        boolean remove;
        synchronized (this.f58652a) {
            remove = this.f58657f.remove(dVar);
        }
        return remove;
    }

    public void j(int i, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        this.f58653b.b(i, str, str2, adDownloadData);
    }

    public void k(int i) {
        this.f58656e = i;
    }

    public int l() {
        return this.f58656e;
    }

    @Override // d.b.i0.o.d.g.c
    public void onSuccess(String str, String str2) {
        if (this.f58654c == null) {
            return;
        }
        AdDownloadData b2 = d.b.i0.o.d.d.c().b(this.f58654c);
        this.f58653b.b(SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, this.f58654c.mPackageName, b2.getExtInfo(), b2);
        b2.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b2.extra().setPercent(100);
        d.b.i0.o.d.d.c().b(this.f58654c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (d dVar : this.f58657f) {
            dVar.c(this.f58654c, str2, false);
        }
    }
}
