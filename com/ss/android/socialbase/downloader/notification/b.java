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
/* loaded from: classes7.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f43559c;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f43560e = new Object();
    public final long a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, Long> f43561b = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Set<String> f43562d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<a> f43563f = new SparseArray<>();

    public static b a() {
        if (f43559c == null) {
            synchronized (b.class) {
                if (f43559c == null) {
                    f43559c = new b();
                }
            }
        }
        return f43559c;
    }

    public static boolean b(int i) {
        return i == 1 || i == 3;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility());
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
        synchronized (this.f43563f) {
            aVar = this.f43563f.get(i);
            if (aVar != null) {
                this.f43563f.remove(i);
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
        synchronized (this.f43563f) {
            aVar = this.f43563f.get(i);
        }
        return aVar;
    }

    public void f(int i) {
        d(i);
        if (i != 0) {
            a().c(i);
        }
    }

    public void c(int i) {
        Context N = c.N();
        if (N == null || i == 0) {
            return;
        }
        try {
            Intent intent = new Intent(N, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            N.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f43563f) {
            sparseArray = this.f43563f;
        }
        return sparseArray;
    }

    public void a(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(c.N()).getDownloadInfo(i);
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

    public void a(int i, int i2, Notification notification) {
        Context N = c.N();
        if (N == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.f43561b) {
                Long l = this.f43561b.get(Integer.valueOf(i));
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                }
                this.f43561b.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
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

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f43563f) {
            this.f43563f.put(aVar.a(), aVar);
        }
    }
}
