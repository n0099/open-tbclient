package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f71400a;

    /* renamed from: b  reason: collision with root package name */
    public long f71401b;

    /* renamed from: c  reason: collision with root package name */
    public long f71402c;

    /* renamed from: d  reason: collision with root package name */
    public String f71403d;

    /* renamed from: e  reason: collision with root package name */
    public int f71404e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f71405f;

    /* renamed from: g  reason: collision with root package name */
    public int f71406g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71407h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f71408i;

    public a(int i2, String str) {
        this.f71400a = i2;
        this.f71403d = str;
    }

    public int a() {
        return this.f71400a;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        c(i2, baseException, z, false);
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f71404e != i2) {
            this.f71404e = i2;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f71401b = j;
    }

    public void e(long j, long j2) {
        this.f71401b = j;
        this.f71402c = j2;
        this.f71404e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f71400a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f71400a, this.f71404e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f71400a = downloadInfo.c0();
        this.f71403d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f71407h = z;
    }

    public long j() {
        return this.f71401b;
    }

    public void k(long j) {
        this.f71402c = j;
    }

    public long l() {
        return this.f71402c;
    }

    public String m() {
        return this.f71403d;
    }

    public int n() {
        return this.f71404e;
    }

    public long o() {
        if (this.f71405f == 0) {
            this.f71405f = System.currentTimeMillis();
        }
        return this.f71405f;
    }

    public synchronized void p() {
        this.f71406g++;
    }

    public int q() {
        return this.f71406g;
    }

    public boolean r() {
        return this.f71407h;
    }
}
