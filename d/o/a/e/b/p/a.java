package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66781a;

    /* renamed from: b  reason: collision with root package name */
    public long f66782b;

    /* renamed from: c  reason: collision with root package name */
    public long f66783c;

    /* renamed from: d  reason: collision with root package name */
    public String f66784d;

    /* renamed from: e  reason: collision with root package name */
    public int f66785e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f66786f;

    /* renamed from: g  reason: collision with root package name */
    public int f66787g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66788h;

    /* renamed from: i  reason: collision with root package name */
    public Notification f66789i;

    public a(int i2, String str) {
        this.f66781a = i2;
        this.f66784d = str;
    }

    public int a() {
        return this.f66781a;
    }

    public void b(int i2, BaseException baseException, boolean z) {
        c(i2, baseException, z, false);
    }

    public void c(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f66785e != i2) {
            this.f66785e = i2;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f66782b = j;
    }

    public void e(long j, long j2) {
        this.f66782b = j;
        this.f66783c = j2;
        this.f66785e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f66781a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f66781a, this.f66785e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f66781a = downloadInfo.c0();
        this.f66784d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f66788h = z;
    }

    public long j() {
        return this.f66782b;
    }

    public void k(long j) {
        this.f66783c = j;
    }

    public long l() {
        return this.f66783c;
    }

    public String m() {
        return this.f66784d;
    }

    public int n() {
        return this.f66785e;
    }

    public long o() {
        if (this.f66786f == 0) {
            this.f66786f = System.currentTimeMillis();
        }
        return this.f66786f;
    }

    public synchronized void p() {
        this.f66787g++;
    }

    public int q() {
        return this.f66787g;
    }

    public boolean r() {
        return this.f66788h;
    }
}
