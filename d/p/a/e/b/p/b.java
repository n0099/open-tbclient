package d.p.a.e.b.p;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import d.p.a.e.b.g.d;
import d.p.a.e.b.g.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f68412c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Long> f68413a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f68414b;

    public b() {
        new HashSet();
        this.f68414b = new SparseArray<>();
    }

    public static b a() {
        if (f68412c == null) {
            synchronized (b.class) {
                if (f68412c == null) {
                    f68412c = new b();
                }
            }
        }
        return f68412c;
    }

    public static boolean h(int i) {
        return i == 1 || i == 3;
    }

    public static boolean j(DownloadInfo downloadInfo) {
        return downloadInfo.m1() && h(downloadInfo.s0());
    }

    public void b(int i) {
        DownloadInfo f2 = d.p.a.e.b.g.a.l(d.l()).f(i);
        if (f2 == null) {
            return;
        }
        d(f2);
        g(f2);
    }

    public void c(int i, int i2, Notification notification) {
        Context l = d.l();
        if (l == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.f68413a) {
                Long l2 = this.f68413a.get(Integer.valueOf(i));
                long currentTimeMillis = System.currentTimeMillis();
                if (l2 != null && Math.abs(currentTimeMillis - l2.longValue()) < 1000) {
                    return;
                }
                this.f68413a.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
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
        synchronized (this.f68414b) {
            this.f68414b.put(aVar.a(), aVar);
        }
    }

    public SparseArray<a> f() {
        SparseArray<a> sparseArray;
        synchronized (this.f68414b) {
            sparseArray = this.f68414b;
        }
        return sparseArray;
    }

    public void g(DownloadInfo downloadInfo) {
        if (j(downloadInfo)) {
            m(downloadInfo.c0());
        }
    }

    public void i(int i) {
        Context l = d.l();
        if (l == null || i == 0) {
            return;
        }
        try {
            Intent intent = new Intent(l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            l.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a k(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f68414b) {
            aVar = this.f68414b.get(i);
            if (aVar != null) {
                this.f68414b.remove(i);
                d.p.a.e.b.c.a.b("removeNotificationId " + i);
            }
        }
        return aVar;
    }

    public a l(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f68414b) {
            aVar = this.f68414b.get(i);
        }
        return aVar;
    }

    public void m(int i) {
        k(i);
        if (i != 0) {
            a().i(i);
        }
    }
}
