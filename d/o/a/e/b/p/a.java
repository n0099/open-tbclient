package d.o.a.e.b.p;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f67259a;

    /* renamed from: b  reason: collision with root package name */
    public long f67260b;

    /* renamed from: c  reason: collision with root package name */
    public long f67261c;

    /* renamed from: d  reason: collision with root package name */
    public String f67262d;

    /* renamed from: e  reason: collision with root package name */
    public int f67263e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f67264f;

    /* renamed from: g  reason: collision with root package name */
    public int f67265g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67266h;
    public Notification i;

    public a(int i, String str) {
        this.f67259a = i;
        this.f67262d = str;
    }

    public int a() {
        return this.f67259a;
    }

    public void b(int i, BaseException baseException, boolean z) {
        c(i, baseException, z, false);
    }

    public void c(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f67263e != i) {
            this.f67263e = i;
            g(baseException, z);
        }
    }

    public void d(long j) {
        this.f67260b = j;
    }

    public void e(long j, long j2) {
        this.f67260b = j;
        this.f67261c = j2;
        this.f67263e = 4;
        g(null, false);
    }

    public void f(Notification notification) {
        if (this.f67259a == 0 || notification == null) {
            return;
        }
        b.a().c(this.f67259a, this.f67263e, notification);
    }

    public abstract void g(BaseException baseException, boolean z);

    public void h(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f67259a = downloadInfo.c0();
        this.f67262d = downloadInfo.P0();
    }

    public void i(boolean z) {
        this.f67266h = z;
    }

    public long j() {
        return this.f67260b;
    }

    public void k(long j) {
        this.f67261c = j;
    }

    public long l() {
        return this.f67261c;
    }

    public String m() {
        return this.f67262d;
    }

    public int n() {
        return this.f67263e;
    }

    public long o() {
        if (this.f67264f == 0) {
            this.f67264f = System.currentTimeMillis();
        }
        return this.f67264f;
    }

    public synchronized void p() {
        this.f67265g++;
    }

    public int q() {
        return this.f67265g;
    }

    public boolean r() {
        return this.f67266h;
    }
}
