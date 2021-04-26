package d.o.a.e.b.p;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import d.o.a.e.b.g.d;
import d.o.a.e.b.g.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f66790c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Long> f66791a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f66792b;

    public b() {
        new HashSet();
        this.f66792b = new SparseArray<>();
    }

    public static b a() {
        if (f66790c == null) {
            synchronized (b.class) {
                if (f66790c == null) {
                    f66790c = new b();
                }
            }
        }
        return f66790c;
    }

    public static boolean h(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public static boolean j(DownloadInfo downloadInfo) {
        return downloadInfo.m1() && h(downloadInfo.s0());
    }

    public void b(int i2) {
        DownloadInfo f2 = d.o.a.e.b.g.a.l(d.l()).f(i2);
        if (f2 == null) {
            return;
        }
        d(f2);
        g(f2);
    }

    public void c(int i2, int i3, Notification notification) {
        Context l = d.l();
        if (l == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.f66791a) {
                Long l2 = this.f66791a.get(Integer.valueOf(i2));
                long currentTimeMillis = System.currentTimeMillis();
                if (l2 != null && Math.abs(currentTimeMillis - l2.longValue()) < 1000) {
                    return;
                }
                this.f66791a.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i3);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            l.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d(DownloadInfo downloadInfo) {
        j I0 = d.I0();
        if (I0 != null && downloadInfo.m1()) {
            downloadInfo.P2(3);
            try {
                I0.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f66792b) {
            this.f66792b.put(aVar.a(), aVar);
        }
    }

    public SparseArray<a> f() {
        SparseArray<a> sparseArray;
        synchronized (this.f66792b) {
            sparseArray = this.f66792b;
        }
        return sparseArray;
    }

    public void g(DownloadInfo downloadInfo) {
        if (j(downloadInfo)) {
            m(downloadInfo.c0());
        }
    }

    public void i(int i2) {
        Context l = d.l();
        if (l == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            l.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a k(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f66792b) {
            aVar = this.f66792b.get(i2);
            if (aVar != null) {
                this.f66792b.remove(i2);
                d.o.a.e.b.c.a.b("removeNotificationId " + i2);
            }
        }
        return aVar;
    }

    public a l(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f66792b) {
            aVar = this.f66792b.get(i2);
        }
        return aVar;
    }

    public void m(int i2) {
        k(i2);
        if (i2 != 0) {
            a().i(i2);
        }
    }
}
