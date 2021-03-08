package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class DownloadService extends Service {
    private static final String b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected p f7815a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.f7815a = b.eGx();
        this.f7815a.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.f.a.b(b, "onBind downloadServiceHandler != null:" + (this.f7815a != null));
        if (this.f7815a != null) {
            return this.f7815a.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(b, "DownloadService onStartCommand");
        }
        this.f7815a.c();
        ExecutorService eGo = b.eGo();
        if (eGo != null) {
            eGo.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.f7815a != null) {
                        DownloadService.this.f7815a.a(intent, i, i2);
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
            com.ss.android.socialbase.downloader.f.a.b(b, "Service onDestroy");
        }
        if (this.f7815a != null) {
            this.f7815a.d();
            this.f7815a = null;
        }
        super.onDestroy();
    }
}
