package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67467a;

    /* renamed from: b  reason: collision with root package name */
    public long f67468b;

    /* renamed from: c  reason: collision with root package name */
    public long f67469c;

    /* renamed from: d  reason: collision with root package name */
    public String f67470d;

    /* renamed from: e  reason: collision with root package name */
    public int f67471e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f67472f;

    /* renamed from: g  reason: collision with root package name */
    public int f67473g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67474h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f67475i;

    public a(int i2, String str) {
        this.f67467a = i2;
        this.f67470d = str;
    }

    public int a() {
        return this.f67467a;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        c(i2, baseException, z, false);
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f67471e != i2) {
            this.f67471e = i2;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f67468b = j;
    }

    public void e(long j, long j2) {
        this.f67468b = j;
        this.f67469c = j2;
        this.f67471e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f67467a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f67467a, this.f67471e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67467a = downloadInfo.c0();
        this.f67470d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f67474h = z;
    }

    public long j() {
        return this.f67468b;
    }

    public void k(long j) {
        this.f67469c = j;
    }

    public long l() {
        return this.f67469c;
    }

    public String m() {
        return this.f67470d;
    }

    public int n() {
        return this.f67471e;
    }

    public long o() {
        if (this.f67472f == 0) {
            this.f67472f = System.currentTimeMillis();
        }
        return this.f67472f;
    }

    public synchronized void p() {
        this.f67473g++;
    }

    public int q() {
        return this.f67473g;
    }

    public boolean r() {
        return this.f67474h;
    }
}
