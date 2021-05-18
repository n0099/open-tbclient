package d.o.a.d.f.d;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.n;
import d.o.a.d.n.j;
import d.o.a.d.n.k;
import d.o.a.e.b.f.r;
import d.o.a.e.b.f.s;
/* loaded from: classes7.dex */
public class a implements s {

    /* renamed from: a  reason: collision with root package name */
    public int f66735a;

    @Override // d.o.a.e.b.f.s
    public boolean a(long j, long j2, r rVar) {
        long j3;
        d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(this.f66735a);
        if (e(d2)) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a().h();
            long d3 = k.d(0L);
            b();
            long d4 = k.d(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (d4 < j2) {
                long f2 = f(d2);
                if (f2 > 0) {
                    d4 = k.d(0L);
                }
                j3 = f2;
            } else {
                j3 = 0;
            }
            j.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + d4 + ", cleaned = " + (d4 - d3), null);
            d(d3, d4, j2, currentTimeMillis2, j3);
            if (d4 < j2) {
                return false;
            }
            if (rVar != null) {
                rVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    public final void b() {
        d.o.a.a.a.a.e y = n.y();
        if (y != null) {
            y.a();
        }
        c.a();
        c.e();
    }

    public void c(int i2) {
        this.f66735a = i2;
    }

    public final void d(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66735a);
        if (f2 == null) {
            return;
        }
        try {
            d.o.a.d.e.d().m(f2, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean e(d.o.a.e.b.j.a aVar) {
        if (aVar.b("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().g() >= aVar.c("clear_space_min_time_interval", 600000L);
    }

    public final long f(d.o.a.e.b.j.a aVar) {
        long c2 = aVar.c("clear_space_sleep_time", 0L);
        if (c2 <= 0) {
            return 0L;
        }
        if (c2 > 5000) {
            c2 = 5000;
        }
        j.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + c2, null);
        try {
            Thread.sleep(c2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        j.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return c2;
    }
}
