package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.g.c;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f13551b = new HashSet();
    private final SparseArray<a> d = new SparseArray<>();
    private static volatile b qbh = null;
    private static final Object c = new Object();

    private b() {
    }

    public static b eJw() {
        if (qbh == null) {
            synchronized (b.class) {
                if (qbh == null) {
                    qbh = new b();
                }
            }
        }
        return qbh;
    }

    public void a(int i) {
        c h = f.iA(com.ss.android.socialbase.downloader.downloader.b.eHp()).h(i);
        if (h != null) {
            a(h);
            b(h);
        }
    }

    void a(c cVar) {
        k eHf = com.ss.android.socialbase.downloader.downloader.b.eHf();
        if (eHf != null && cVar.aQ()) {
            cVar.e(3);
            try {
                eHf.a(cVar);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    void b(c cVar) {
        if (c(cVar)) {
            f(cVar.g());
        }
    }

    static boolean c(c cVar) {
        return cVar.aQ() && b(cVar.eHY());
    }

    static boolean b(int i) {
        return i == 1 || i == 3;
    }

    public void a(int i, int i2, Notification notification) {
        Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
        if (eHp != null && i != 0 && notification != null) {
            try {
                Intent intent = new Intent(eHp, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
                intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                eHp.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(int i) {
        Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
        if (eHp != null && i != 0) {
            try {
                Intent intent = new Intent(eHp, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                eHp.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.d) {
                this.d.put(aVar.a(), aVar);
            }
        }
    }

    public a SW(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.d) {
            aVar = this.d.get(i);
            if (aVar != null) {
                this.d.remove(i);
                com.ss.android.socialbase.downloader.f.a.a("removeNotificationId " + i);
            }
        }
        return aVar;
    }

    public a SX(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.d) {
            aVar = this.d.get(i);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<a> eJx() {
        SparseArray<a> sparseArray;
        synchronized (this.d) {
            sparseArray = this.d;
        }
        return sparseArray;
    }

    public void f(int i) {
        SW(i);
        if (i != 0) {
            eJw().c(i);
        }
    }
}
