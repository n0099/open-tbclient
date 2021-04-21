package d.p.a.e.a.f;

import android.content.Context;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.f.n;
import d.p.a.e.b.g.d;
/* loaded from: classes6.dex */
public class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public Context f67994b;

    /* renamed from: c  reason: collision with root package name */
    public int f67995c;

    /* renamed from: d  reason: collision with root package name */
    public String f67996d;

    /* renamed from: e  reason: collision with root package name */
    public String f67997e;

    /* renamed from: f  reason: collision with root package name */
    public String f67998f;

    /* renamed from: g  reason: collision with root package name */
    public String f67999g;

    /* renamed from: h  reason: collision with root package name */
    public d.p.a.e.b.p.a f68000h;

    public b(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f67994b = context.getApplicationContext();
        } else {
            this.f67994b = d.l();
        }
        this.f67995c = i;
        this.f67996d = str;
        this.f67997e = str2;
        this.f67998f = str3;
        this.f67999g = str4;
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.f67994b == null) {
            return;
        }
        if (downloadInfo.e() && !downloadInfo.c1()) {
            super.b(downloadInfo);
        }
        d.p.a.e.a.h.a.a(downloadInfo);
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.c(downloadInfo);
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.d(downloadInfo);
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void e(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.f67994b == null || !downloadInfo.e() || downloadInfo.c1()) {
            return;
        }
        super.e(downloadInfo, baseException);
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void f(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.f(downloadInfo);
    }

    @Override // d.p.a.e.b.f.n, d.p.a.e.b.f.a, d.p.a.e.b.f.b
    public void l(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.c1()) {
            return;
        }
        super.l(downloadInfo);
    }

    @Override // d.p.a.e.b.f.n
    public d.p.a.e.b.p.a n() {
        Context context;
        if (this.f68000h == null && (context = this.f67994b) != null) {
            return new a(context, this.f67995c, this.f67996d, this.f67997e, this.f67998f, this.f67999g);
        }
        return this.f68000h;
    }

    public b(d.p.a.e.b.p.a aVar) {
        this.f67994b = d.l();
        this.f68000h = aVar;
    }
}
