package d.o.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.n;
import d.o.a.e.b.g.d;
/* loaded from: classes7.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f70967b;

    /* renamed from: c  reason: collision with root package name */
    public int f70968c;

    /* renamed from: d  reason: collision with root package name */
    public String f70969d;

    /* renamed from: e  reason: collision with root package name */
    public String f70970e;

    /* renamed from: f  reason: collision with root package name */
    public String f70971f;

    /* renamed from: g  reason: collision with root package name */
    public String f70972g;

    /* renamed from: h  reason: collision with root package name */
    public d.o.a.e.b.p.a f70973h;

    public b(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f70967b = context.getApplicationContext();
        } else {
            this.f70967b = d.l();
        }
        this.f70968c = i2;
        this.f70969d = str;
        this.f70970e = str2;
        this.f70971f = str3;
        this.f70972g = str4;
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
        if (downloadInfo == null || this.f70967b == null) {
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
        if (downloadInfo == null || this.f70967b == null || !downloadInfo.e() || downloadInfo.c1()) {
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
        if (this.f70973h == null && (context = this.f70967b) != null) {
            return new a(context, this.f70968c, this.f70969d, this.f70970e, this.f70971f, this.f70972g);
        }
        return this.f70973h;
    }

    public b(d.o.a.e.b.p.a aVar) {
        this.f70967b = d.l();
        this.f70973h = aVar;
    }
}
