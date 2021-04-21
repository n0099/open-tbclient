package d.p.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f68404a;

    /* renamed from: b  reason: collision with root package name */
    public long f68405b;

    /* renamed from: c  reason: collision with root package name */
    public long f68406c;

    /* renamed from: d  reason: collision with root package name */
    public String f68407d;

    /* renamed from: e  reason: collision with root package name */
    public int f68408e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f68409f;

    /* renamed from: g  reason: collision with root package name */
    public int f68410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68411h;
    public Notification i;

    public a(int i, String str) {
        this.f68404a = i;
        this.f68407d = str;
    }

    public int a() {
        return this.f68404a;
    }

    public void b(int i, BaseException baseException, boolean z) {
        c(i, baseException, z, false);
    }

    public void c(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f68408e != i) {
            this.f68408e = i;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f68405b = j;
    }

    public void e(long j, long j2) {
        this.f68405b = j;
        this.f68406c = j2;
        this.f68408e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f68404a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f68404a, this.f68408e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f68404a = downloadInfo.c0();
        this.f68407d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f68411h = z;
    }

    public long j() {
        return this.f68405b;
    }

    public void k(long j) {
        this.f68406c = j;
    }

    public long l() {
        return this.f68406c;
    }

    public String m() {
        return this.f68407d;
    }

    public int n() {
        return this.f68408e;
    }

    public long o() {
        if (this.f68409f == 0) {
            this.f68409f = System.currentTimeMillis();
        }
        return this.f68409f;
    }

    public synchronized void p() {
        this.f68410g++;
    }

    public int q() {
        return this.f68410g;
    }

    public boolean r() {
        return this.f68411h;
    }
}
