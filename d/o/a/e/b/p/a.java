package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67510a;

    /* renamed from: b  reason: collision with root package name */
    public long f67511b;

    /* renamed from: c  reason: collision with root package name */
    public long f67512c;

    /* renamed from: d  reason: collision with root package name */
    public String f67513d;

    /* renamed from: e  reason: collision with root package name */
    public int f67514e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f67515f;

    /* renamed from: g  reason: collision with root package name */
    public int f67516g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67517h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f67518i;

    public a(int i2, String str) {
        this.f67510a = i2;
        this.f67513d = str;
    }

    public int a() {
        return this.f67510a;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        c(i2, baseException, z, false);
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f67514e != i2) {
            this.f67514e = i2;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f67511b = j;
    }

    public void e(long j, long j2) {
        this.f67511b = j;
        this.f67512c = j2;
        this.f67514e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f67510a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f67510a, this.f67514e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67510a = downloadInfo.c0();
        this.f67513d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f67517h = z;
    }

    public long j() {
        return this.f67511b;
    }

    public void k(long j) {
        this.f67512c = j;
    }

    public long l() {
        return this.f67512c;
    }

    public String m() {
        return this.f67513d;
    }

    public int n() {
        return this.f67514e;
    }

    public long o() {
        if (this.f67515f == 0) {
            this.f67515f = System.currentTimeMillis();
        }
        return this.f67515f;
    }

    public synchronized void p() {
        this.f67516g++;
    }

    public int q() {
        return this.f67516g;
    }

    public boolean r() {
        return this.f67517h;
    }
}
