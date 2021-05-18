package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes7.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f67034b;

    /* renamed from: c  reason: collision with root package name */
    public int f67035c;

    /* renamed from: d  reason: collision with root package name */
    public String f67036d;

    /* renamed from: e  reason: collision with root package name */
    public String f67037e;

    /* renamed from: f  reason: collision with root package name */
    public String f67038f;

    /* renamed from: g  reason: collision with root package name */
    public String f67039g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f67040h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f67034b = context.getApplicationContext();
        } else {
            this.f67034b = d.l();
        }
        this.f67035c = i2;
        this.f67036d = str;
        this.f67037e = str2;
        this.f67038f = str3;
        this.f67039g = str4;
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
        if (downloadInfo == null || this.f67034b == null) {
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
        if (downloadInfo == null || this.f67034b == null || !downloadInfo.e() || downloadInfo.c1()) {
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
        if (this.f67040h == null && (context = this.f67034b) != null) {
            return new a(context, this.f67035c, this.f67036d, this.f67037e, this.f67038f, this.f67039g);
        }
        return this.f67040h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f67034b = d.l();
        this.f67040h = aVar;
    }
}
