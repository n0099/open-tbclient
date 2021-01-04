package com.ss.android.socialbase.downloader.downloader;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class IndependentProcessDownloadService extends DownloadService {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13427b = IndependentProcessDownloadService.class.getSimpleName();
    private static boolean c = false;
    private static int d = 0;
    private static long e = 0;
    private Handler f = new Handler(Looper.getMainLooper());
    private ServiceConnection g = new ServiceConnection() { // from class: com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean unused = IndependentProcessDownloadService.c = true;
            com.ss.android.socialbase.downloader.f.a.b(IndependentProcessDownloadService.f13427b, "onServiceConnected: ");
            try {
                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService.2.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        boolean unused2 = IndependentProcessDownloadService.c = false;
                        com.ss.android.socialbase.downloader.f.a.d(IndependentProcessDownloadService.f13427b, "binderDied:");
                        IndependentProcessDownloadService.this.b();
                    }
                }, 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            boolean unused = IndependentProcessDownloadService.c = false;
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        b.a(this);
        this.f13424a = b.eHh();
        this.f13424a.a(new WeakReference(this));
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (Build.VERSION.SDK_INT < 26 && com.ss.android.socialbase.downloader.m.a.a(512) && !c) {
            if (d > 5) {
                com.ss.android.socialbase.downloader.f.a.d(f13427b, "bindMainProcess: bind too many times!!! ");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - e < 15000) {
                com.ss.android.socialbase.downloader.f.a.d(f13427b, "bindMainProcess: time too short since last bind!!! ");
                return;
            }
            d++;
            e = currentTimeMillis;
            this.f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    IndependentProcessDownloadService.this.c();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.ss.android.socialbase.downloader.f.a.b(f13427b, "bindMainProcess: ");
        Intent intent = new Intent(this, DownloadService.class);
        try {
            bindService(intent, this.g, 1);
            startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
