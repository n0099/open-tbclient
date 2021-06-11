package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f71296a;

    /* renamed from: b  reason: collision with root package name */
    public long f71297b;

    /* renamed from: c  reason: collision with root package name */
    public long f71298c;

    /* renamed from: d  reason: collision with root package name */
    public String f71299d;

    /* renamed from: e  reason: collision with root package name */
    public int f71300e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f71301f;

    /* renamed from: g  reason: collision with root package name */
    public int f71302g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71303h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f71304i;

    public a(int i2, String str) {
        this.f71296a = i2;
        this.f71299d = str;
    }

    public int a() {
        return this.f71296a;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        c(i2, baseException, z, false);
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f71300e != i2) {
            this.f71300e = i2;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f71297b = j;
    }

    public void e(long j, long j2) {
        this.f71297b = j;
        this.f71298c = j2;
        this.f71300e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f71296a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f71296a, this.f71300e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f71296a = downloadInfo.c0();
        this.f71299d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f71303h = z;
    }

    public long j() {
        return this.f71297b;
    }

    public void k(long j) {
        this.f71298c = j;
    }

    public long l() {
        return this.f71298c;
    }

    public String m() {
        return this.f71299d;
    }

    public int n() {
        return this.f71300e;
    }

    public long o() {
        if (this.f71301f == 0) {
            this.f71301f = System.currentTimeMillis();
        }
        return this.f71301f;
    }

    public synchronized void p() {
        this.f71302g++;
    }

    public int q() {
        return this.f71302g;
    }

    public boolean r() {
        return this.f71303h;
    }
}
