package d.p.a.e.b.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public abstract class n extends a implements t {
    @Override // d.p.a.e.b.f.t
    public void a(DownloadInfo downloadInfo) {
        o(11, downloadInfo, null, true);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        super.b(downloadInfo);
        o(-3, downloadInfo, null, false);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        super.c(downloadInfo);
        q(downloadInfo);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void d(DownloadInfo downloadInfo) {
        super.d(downloadInfo);
        o(-2, downloadInfo, null, false);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void e(DownloadInfo downloadInfo, BaseException baseException) {
        super.e(downloadInfo, baseException);
        o(-1, downloadInfo, baseException, false);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        super.f(downloadInfo);
        o(2, downloadInfo, null, false);
    }

    @Override // d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        super.l(downloadInfo);
        p(downloadInfo);
        o(1, downloadInfo, null, true);
    }

    public abstract d.p.a.e.b.p.a n();

    public final void o(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.e() || i == 4) {
            return;
        }
        d.p.a.e.b.p.a l = d.p.a.e.b.p.b.a().l(downloadInfo.c0());
        if (l == null) {
            l = n();
        }
        l.k(downloadInfo.Q0());
        if (i == -3) {
            l.d(downloadInfo.Q0());
        } else {
            l.d(downloadInfo.E());
        }
        l.b(i, baseException, z);
    }

    public final void p(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.e()) {
            return;
        }
        d.p.a.e.b.p.a l = d.p.a.e.b.p.b.a().l(downloadInfo.c0());
        if (l == null) {
            d.p.a.e.b.p.b.a().e(n());
            return;
        }
        l.h(downloadInfo);
    }

    public final void q(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.e() && downloadInfo.H0() == 4) {
            d.p.a.e.b.p.a l = d.p.a.e.b.p.b.a().l(downloadInfo.c0());
            if (l == null) {
                l = n();
            }
            l.e(downloadInfo.E(), downloadInfo.Q0());
        }
    }
}
