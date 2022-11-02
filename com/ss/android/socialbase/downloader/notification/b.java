package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static volatile b c;
    public static final Object e = new Object();
    public final long a = 1000;
    public final Map<Integer, Long> b = new HashMap();
    public final Set<String> d = new HashSet();
    public final SparseArray<a> f = new SparseArray<>();

    public static boolean b(int i) {
        return i == 1 || i == 3;
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f) {
            sparseArray = this.f;
        }
        return sparseArray;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        if (downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility())) {
            return true;
        }
        return false;
    }

    public void a(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo);
        b(downloadInfo);
    }

    public void b(DownloadInfo downloadInfo) {
        if (c(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    public a d(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(i);
            if (aVar != null) {
                this.f.remove(i);
                com.ss.android.socialbase.downloader.c.a.a("removeNotificationId " + i);
            }
        }
        return aVar;
    }

    public a e(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(i);
        }
        return aVar;
    }

    public void f(int i) {
        d(i);
        if (i != 0) {
            a().c(i);
        }
    }

    public void a(int i, int i2, Notification notification) {
        Context N = c.N();
        if (N != null && i != 0 && notification != null) {
            if (i2 == 4) {
                synchronized (this.b) {
                    Long l = this.b.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                        return;
                    }
                    this.b.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                }
            }
            try {
                Intent intent = new Intent(N, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
                intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
                N.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(DownloadInfo downloadInfo) {
        j x = c.x();
        if (x != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                x.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(int i) {
        Context N = c.N();
        if (N != null && i != 0) {
            try {
                Intent intent = new Intent(N, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                N.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f) {
            this.f.put(aVar.a(), aVar);
        }
    }
}
