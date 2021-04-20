package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f68257a;

    /* renamed from: b  reason: collision with root package name */
    public long f68258b;

    /* renamed from: c  reason: collision with root package name */
    public long f68259c;

    /* renamed from: d  reason: collision with root package name */
    public String f68260d;

    /* renamed from: e  reason: collision with root package name */
    public int f68261e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f68262f;

    /* renamed from: g  reason: collision with root package name */
    public int f68263g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68264h;
    public Notification i;

    public a(int i, String str) {
        this.f68257a = i;
        this.f68260d = str;
    }

    public int a() {
        return this.f68257a;
    }

    public void b(int i, BaseException baseException, boolean z) {
        c(i, baseException, z, false);
    }

    public void c(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f68261e != i) {
            this.f68261e = i;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f68258b = j;
    }

    public void e(long j, long j2) {
        this.f68258b = j;
        this.f68259c = j2;
        this.f68261e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f68257a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f68257a, this.f68261e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f68257a = downloadInfo.c0();
        this.f68260d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f68264h = z;
    }

    public long j() {
        return this.f68258b;
    }

    public void k(long j) {
        this.f68259c = j;
    }

    public long l() {
        return this.f68259c;
    }

    public String m() {
        return this.f68260d;
    }

    public int n() {
        return this.f68261e;
    }

    public long o() {
        if (this.f68262f == 0) {
            this.f68262f = System.currentTimeMillis();
        }
        return this.f68262f;
    }

    public synchronized void p() {
        this.f68263g++;
    }

    public int q() {
        return this.f68263g;
    }

    public boolean r() {
        return this.f68264h;
    }
}
