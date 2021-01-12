package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13124b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected p f13125a;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.f13125a = b.eDU();
        this.f13125a.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.f.a.b(f13124b, "onBind downloadServiceHandler != null:" + (this.f13125a != null));
        if (this.f13125a != null) {
            return this.f13125a.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.f.a.a()) {
            com.ss.android.socialbase.downloader.f.a.b(f13124b, "DownloadService onStartCommand");
        }
        this.f13125a.c();
        ExecutorService eDL = b.eDL();
        if (eDL != null) {
            eDL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadService.this.f13125a != null) {
                        DownloadService.this.f13125a.a(intent, i, i2);
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
            com.ss.android.socialbase.downloader.f.a.b(f13124b, "Service onDestroy");
        }
        if (this.f13125a != null) {
            this.f13125a.d();
            this.f13125a = null;
        }
        super.onDestroy();
    }
}
