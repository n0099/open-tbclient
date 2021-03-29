package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes7.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f66854b;

    /* renamed from: c  reason: collision with root package name */
    public int f66855c;

    /* renamed from: d  reason: collision with root package name */
    public String f66856d;

    /* renamed from: e  reason: collision with root package name */
    public String f66857e;

    /* renamed from: f  reason: collision with root package name */
    public String f66858f;

    /* renamed from: g  reason: collision with root package name */
    public String f66859g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f66860h;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f66854b = context.getApplicationContext();
        } else {
            this.f66854b = d.l();
        }
        this.f66855c = i;
        this.f66856d = str;
        this.f66857e = str2;
        this.f66858f = str3;
        this.f66859g = str4;
    }

    @Override // d.o.a.e.b.f.n, d.o.a.e.b.f.a, d.o.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f66854b == null) {
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
        if (downloadInfo == null || this.f66854b == null || !downloadInfo.e() || downloadInfo.c1()) {
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
        if (this.f66860h == null && (context = this.f66854b) != null) {
            return new a(context, this.f66855c, this.f66856d, this.f66857e, this.f66858f, this.f66859g);
        }
        return this.f66860h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f66854b = d.l();
        this.f66860h = aVar;
    }
}
