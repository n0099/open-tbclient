package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class DownloadService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static final String f43234b = DownloadService.class.getSimpleName();
    public o a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f43234b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.a != null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        o oVar = this.a;
        if (oVar != null) {
            return oVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        o y = c.y();
        this.a = y;
        y.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f43234b, "Service onDestroy");
        }
        o oVar = this.a;
        if (oVar != null) {
            oVar.d();
            this.a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f43234b, "DownloadService onStartCommand");
        }
        this.a.c();
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    o oVar = DownloadService.this.a;
                    if (oVar != null) {
                        oVar.a(intent, i, i2);
                    }
                }
            });
        }
        return c.j() ? 2 : 3;
    }
}
