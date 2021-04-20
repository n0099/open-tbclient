package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes6.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f67847b;

    /* renamed from: c  reason: collision with root package name */
    public int f67848c;

    /* renamed from: d  reason: collision with root package name */
    public String f67849d;

    /* renamed from: e  reason: collision with root package name */
    public String f67850e;

    /* renamed from: f  reason: collision with root package name */
    public String f67851f;

    /* renamed from: g  reason: collision with root package name */
    public String f67852g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f67853h;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f67847b = context.getApplicationContext();
        } else {
            this.f67847b = d.l();
        }
        this.f67848c = i;
        this.f67849d = str;
        this.f67850e = str2;
        this.f67851f = str3;
        this.f67852g = str4;
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f67847b == null) {
            return;
        }
        if (downloadInfo.e() && !downloadInfo.c1()) {
            super.b(downloadInfo);
        }
        d.o.a.e.a.h.a.a(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.c(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.d(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void e(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f67847b == null || !downloadInfo.e() || downloadInfo.c1()) {
            return;
        }
        super.e(downloadInfo, baseException);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.f(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.l(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n
    public d.o.a.e.b.p.a n() {
        Context context;
        if (this.f67853h == null && (context = this.f67847b) != null) {
            return new a(context, this.f67848c, this.f67849d, this.f67850e, this.f67851f, this.f67852g);
        }
        return this.f67853h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f67847b = d.l();
        this.f67853h = aVar;
    }
}
