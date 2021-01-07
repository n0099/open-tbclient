package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13424b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected p f13425a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.f13425a = b.eHK();
        this.f13425a.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.f.a.b(f13424b, "onBind downloadServiceHandler != null:" + (this.f13425a != null));
        if (this.f13425a != null) {
            return this.f13425a.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13424b, "DownloadService onStartCommand");
        }
        this.f13425a.c();
        ExecutorService eHB = b.eHB();
        if (eHB != null) {
            eHB.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.f13425a != null) {
                        DownloadService.this.f13425a.a(intent, i, i2);
                    }
                }
            });
            return 3;
        }
        return 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13424b, "Service onDestroy");
        }
        if (this.f13425a != null) {
            this.f13425a.d();
            this.f13425a = null;
        }
        super.onDestroy();
    }
}
