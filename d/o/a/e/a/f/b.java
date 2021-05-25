package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes7.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f67077b;

    /* renamed from: c  reason: collision with root package name */
    public int f67078c;

    /* renamed from: d  reason: collision with root package name */
    public String f67079d;

    /* renamed from: e  reason: collision with root package name */
    public String f67080e;

    /* renamed from: f  reason: collision with root package name */
    public String f67081f;

    /* renamed from: g  reason: collision with root package name */
    public String f67082g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f67083h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f67077b = context.getApplicationContext();
        } else {
            this.f67077b = d.l();
        }
        this.f67078c = i2;
        this.f67079d = str;
        this.f67080e = str2;
        this.f67081f = str3;
        this.f67082g = str4;
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
        if (downloadInfo == null || this.f67077b == null) {
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
        if (downloadInfo == null || this.f67077b == null || !downloadInfo.e() || downloadInfo.c1()) {
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
        if (this.f67083h == null && (context = this.f67077b) != null) {
            return new a(context, this.f67078c, this.f67079d, this.f67080e, this.f67081f, this.f67082g);
        }
        return this.f67083h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f67077b = d.l();
        this.f67083h = aVar;
    }
}
