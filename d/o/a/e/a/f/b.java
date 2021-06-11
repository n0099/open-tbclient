package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes7.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f70863b;

    /* renamed from: c  reason: collision with root package name */
    public int f70864c;

    /* renamed from: d  reason: collision with root package name */
    public String f70865d;

    /* renamed from: e  reason: collision with root package name */
    public String f70866e;

    /* renamed from: f  reason: collision with root package name */
    public String f70867f;

    /* renamed from: g  reason: collision with root package name */
    public String f70868g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f70869h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f70863b = context.getApplicationContext();
        } else {
            this.f70863b = d.l();
        }
        this.f70864c = i2;
        this.f70865d = str;
        this.f70866e = str2;
        this.f70867f = str3;
        this.f70868g = str4;
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
        if (downloadInfo == null || this.f70863b == null) {
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
        if (downloadInfo == null || this.f70863b == null || !downloadInfo.e() || downloadInfo.c1()) {
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
        if (this.f70869h == null && (context = this.f70863b) != null) {
            return new a(context, this.f70864c, this.f70865d, this.f70866e, this.f70867f, this.f70868g);
        }
        return this.f70869h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f70863b = d.l();
        this.f70869h = aVar;
    }
}
