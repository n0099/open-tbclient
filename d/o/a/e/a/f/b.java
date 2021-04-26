package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes6.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f66348b;

    /* renamed from: c  reason: collision with root package name */
    public int f66349c;

    /* renamed from: d  reason: collision with root package name */
    public String f66350d;

    /* renamed from: e  reason: collision with root package name */
    public String f66351e;

    /* renamed from: f  reason: collision with root package name */
    public String f66352f;

    /* renamed from: g  reason: collision with root package name */
    public String f66353g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f66354h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f66348b = context.getApplicationContext();
        } else {
            this.f66348b = d.l();
        }
        this.f66349c = i2;
        this.f66350d = str;
        this.f66351e = str2;
        this.f66352f = str3;
        this.f66353g = str4;
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.b(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.c(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f66348b == null) {
            return;
        }
        if (downloadInfo.e() && !downloadInfo.c1()) {
            super.f(downloadInfo);
        }
        d.o.a.e.a.h.a.a(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void g(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.g(downloadInfo);
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void h(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f66348b == null || !downloadInfo.e() || downloadInfo.c1()) {
            return;
        }
        super.h(downloadInfo, baseException);
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
        if (this.f66354h == null && (context = this.f66348b) != null) {
            return new a(context, this.f66349c, this.f66350d, this.f66351e, this.f66352f, this.f66353g);
        }
        return this.f66354h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f66348b = d.l();
        this.f66354h = aVar;
    }
}
