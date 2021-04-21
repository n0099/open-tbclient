package d.p.a.e.b.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68100a = "a";

    @Override // d.p.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onSuccessed -- " + downloadInfo.q0() + " " + downloadInfo.S1());
    }

    @Override // d.p.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null || downloadInfo.Q0() == 0) {
            return;
        }
        d.p.a.e.b.c.a.g(f68100a, String.format("onProgress %s %.2f%%", downloadInfo.q0(), Float.valueOf((((float) downloadInfo.E()) / ((float) downloadInfo.Q0())) * 100.0f)));
    }

    @Override // d.p.a.e.b.f.b
    public void d(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onPause -- " + downloadInfo.q0());
    }

    @Override // d.p.a.e.b.f.b
    public void e(DownloadInfo downloadInfo, BaseException baseException) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.q0();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        d.p.a.e.b.c.a.g(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // d.p.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onStart -- " + downloadInfo.q0());
    }

    @Override // d.p.a.e.b.f.b
    public void g(DownloadInfo downloadInfo, BaseException baseException) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.q0();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        d.p.a.e.b.c.a.g(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // d.p.a.e.b.f.b
    public void h(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onFirstStart -- " + downloadInfo.q0());
    }

    @Override // d.p.a.e.b.f.b
    public void i(DownloadInfo downloadInfo, BaseException baseException) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.q0();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        d.p.a.e.b.c.a.g(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    @Override // d.p.a.e.b.f.b
    public void j(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onFirstSuccess -- " + downloadInfo.q0());
    }

    @Override // d.p.a.e.b.f.b
    public void k(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onCanceled -- " + downloadInfo.q0());
    }

    @Override // d.p.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onPrepare -- " + downloadInfo.q0());
    }

    public void m(DownloadInfo downloadInfo) {
        if (!d.p.a.e.b.c.a.e() || downloadInfo == null) {
            return;
        }
        String str = f68100a;
        d.p.a.e.b.c.a.g(str, " onIntercept -- " + downloadInfo.q0());
    }
}
