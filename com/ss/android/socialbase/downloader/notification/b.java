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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f13254b = new HashSet();
    private final SparseArray<a> d = new SparseArray<>();
    private static volatile b qiT = null;
    private static final Object c = new Object();

    private b() {
    }

    public static b eIJ() {
        if (qiT == null) {
            synchronized (b.class) {
                if (qiT == null) {
                    qiT = new b();
                }
            }
        }
        return qiT;
    }

    public void a(int i) {
        c h = f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).h(i);
        if (h != null) {
            a(h);
            b(h);
        }
    }

    void a(c cVar) {
        k eGs = com.ss.android.socialbase.downloader.downloader.b.eGs();
        if (eGs != null && cVar.aQ()) {
            cVar.e(3);
            try {
                eGs.a(cVar);
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
        return cVar.aQ() && b(cVar.eHl());
    }

    static boolean b(int i) {
        return i == 1 || i == 3;
    }

    public void a(int i, int i2, Notification notification) {
        Context eGC = com.ss.android.socialbase.downloader.downloader.b.eGC();
        if (eGC != null && i != 0 && notification != null) {
            try {
                Intent intent = new Intent(eGC, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
                intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                eGC.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(int i) {
        Context eGC = com.ss.android.socialbase.downloader.downloader.b.eGC();
        if (eGC != null && i != 0) {
            try {
                Intent intent = new Intent(eGC, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                eGC.startService(intent);
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

    public a Sb(int i) {
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

    public a Sc(int i) {
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
    public SparseArray<a> eIK() {
        SparseArray<a> sparseArray;
        synchronized (this.d) {
            sparseArray = this.d;
        }
        return sparseArray;
    }

    public void f(int i) {
        Sb(i);
        if (i != 0) {
            eIJ().c(i);
        }
    }
}
