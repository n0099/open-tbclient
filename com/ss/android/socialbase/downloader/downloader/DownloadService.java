package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13423b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected p f13424a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.f13424a = b.eHg();
        this.f13424a.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.f.a.b(f13423b, "onBind downloadServiceHandler != null:" + (this.f13424a != null));
        if (this.f13424a != null) {
            return this.f13424a.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13423b, "DownloadService onStartCommand");
        }
        this.f13424a.c();
        ExecutorService eGX = b.eGX();
        if (eGX != null) {
            eGX.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.f13424a != null) {
                        DownloadService.this.f13424a.a(intent, i, i2);
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
            com.ss.android.socialbase.downloader.f.a.b(f13423b, "Service onDestroy");
        }
        if (this.f13424a != null) {
            this.f13424a.d();
            this.f13424a = null;
        }
        super.onDestroy();
    }
}
