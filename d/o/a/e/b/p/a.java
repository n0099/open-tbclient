package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67264a;

    /* renamed from: b  reason: collision with root package name */
    public long f67265b;

    /* renamed from: c  reason: collision with root package name */
    public long f67266c;

    /* renamed from: d  reason: collision with root package name */
    public String f67267d;

    /* renamed from: e  reason: collision with root package name */
    public int f67268e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f67269f;

    /* renamed from: g  reason: collision with root package name */
    public int f67270g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67271h;
    public Notification i;

    public a(int i, String str) {
        this.f67264a = i;
        this.f67267d = str;
    }

    public int a() {
        return this.f67264a;
    }

    public void b(int i, BaseException baseException, boolean z) {
        c(i, baseException, z, false);
    }

    public void c(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f67268e != i) {
            this.f67268e = i;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f67265b = j;
    }

    public void e(long j, long j2) {
        this.f67265b = j;
        this.f67266c = j2;
        this.f67268e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f67264a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f67264a, this.f67268e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67264a = downloadInfo.c0();
        this.f67267d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f67271h = z;
    }

    public long j() {
        return this.f67265b;
    }

    public void k(long j) {
        this.f67266c = j;
    }

    public long l() {
        return this.f67266c;
    }

    public String m() {
        return this.f67267d;
    }

    public int n() {
        return this.f67268e;
    }

    public long o() {
        if (this.f67269f == 0) {
            this.f67269f = System.currentTimeMillis();
        }
        return this.f67269f;
    }

    public synchronized void p() {
        this.f67270g++;
    }

    public int q() {
        return this.f67270g;
    }

    public boolean r() {
        return this.f67271h;
    }
}
