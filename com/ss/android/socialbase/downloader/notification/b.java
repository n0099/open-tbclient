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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f60309c;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f60310e = new Object();
    public final long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, Long> f60311b = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Set<String> f60312d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<a> f60313f = new SparseArray<>();

    public static b a() {
        if (f60309c == null) {
            synchronized (b.class) {
                if (f60309c == null) {
                    f60309c = new b();
                }
            }
        }
        return f60309c;
    }

    public static boolean b(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility());
    }

    public void b(DownloadInfo downloadInfo) {
        if (c(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    public a d(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f60313f) {
            aVar = this.f60313f.get(i2);
            if (aVar != null) {
                this.f60313f.remove(i2);
                com.ss.android.socialbase.downloader.c.a.a("removeNotificationId " + i2);
            }
        }
        return aVar;
    }

    public a e(int i2) {
        a aVar;
        if (i2 == 0) {
            return null;
        }
        synchronized (this.f60313f) {
            aVar = this.f60313f.get(i2);
        }
        return aVar;
    }

    public void f(int i2) {
        d(i2);
        if (i2 != 0) {
            a().c(i2);
        }
    }

    public void c(int i2) {
        Context N = c.N();
        if (N == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(N, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            N.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f60313f) {
            sparseArray = this.f60313f;
        }
        return sparseArray;
    }

    public void a(int i2) {
        DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(i2);
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo);
        b(downloadInfo);
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

    public void a(int i2, int i3, Notification notification) {
        Context N = c.N();
        if (N == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.f60311b) {
                Long l = this.f60311b.get(Integer.valueOf(i2));
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                }
                this.f60311b.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(N, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i3);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            N.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f60313f) {
            this.f60313f.put(aVar.a(), aVar);
        }
    }
}
