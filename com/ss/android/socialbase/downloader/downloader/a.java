package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a implements o {

    /* renamed from: e  reason: collision with root package name */
    public static final String f59993e = "a";

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f59995c;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Service> f59997f;
    public final SparseArray<List<DownloadTask>> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f59994b = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f59996d = false;

    /* renamed from: g  reason: collision with root package name */
    public Handler f59998g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public Runnable f59999h = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.f59993e, "tryDownload: 2 try");
            }
            if (a.this.f59994b) {
                return;
            }
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.f59993e, "tryDownload: 2 error");
            }
            a.this.startService(c.N(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i2, int i3) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(n nVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(WeakReference weakReference) {
        this.f59997f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean b() {
        String str = f59993e;
        com.ss.android.socialbase.downloader.c.a.c(str, "isServiceForeground = " + this.f59995c);
        return this.f59995c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void d() {
        this.f59994b = false;
    }

    public void e() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.a) {
            String str = f59993e;
            com.ss.android.socialbase.downloader.c.a.b(str, "resumePendingTask pendingTasks.size:" + this.a.size());
            clone = this.a.clone();
            this.a.clear();
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            for (int i2 = 0; i2 < clone.size(); i2++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i2));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        String str2 = f59993e;
                        com.ss.android.socialbase.downloader.c.a.b(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                        C.a(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        if (this.f59994b) {
            return;
        }
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(f59993e, "startService");
        }
        startService(c.N(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean a() {
        return this.f59994b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        com.ss.android.socialbase.downloader.c.a.b(f59993e, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f59994b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(f59993e, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
                a(downloadTask);
                if (!this.f59996d) {
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(f59993e, "tryDownload: 1");
                    }
                    startService(c.N(), null);
                    this.f59996d = true;
                    return;
                }
                this.f59998g.removeCallbacks(this.f59999h);
                this.f59998g.postDelayed(this.f59999h, 10L);
                return;
            }
            a(downloadTask);
            startService(c.N(), null);
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b(f59993e, "tryDownload when isServiceAlive");
        e();
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            String str = f59993e;
            com.ss.android.socialbase.downloader.c.a.b(str, "tryDownload current task: " + downloadTask.getDownloadId());
            C.a(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2, Notification notification) {
        WeakReference<Service> weakReference = this.f59997f;
        if (weakReference != null && weakReference.get() != null) {
            String str = f59993e;
            com.ss.android.socialbase.downloader.c.a.c(str, "startForeground  id = " + i2 + ", service = " + this.f59997f.get() + ",  isServiceAlive = " + this.f59994b);
            try {
                this.f59997f.get().startForeground(i2, notification);
                this.f59995c = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.c.a.d(f59993e, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f59997f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = f59993e;
        com.ss.android.socialbase.downloader.c.a.c(str, "stopForeground  service = " + this.f59997f.get() + ",  isServiceAlive = " + this.f59994b);
        try {
            this.f59995c = false;
            this.f59997f.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.a) {
            String str = f59993e;
            com.ss.android.socialbase.downloader.c.a.b(str, "pendDownloadTask pendingTasks.size:" + this.a.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.a.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.a.put(downloadId, list);
            }
            String str2 = f59993e;
            com.ss.android.socialbase.downloader.c.a.b(str2, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            String str3 = f59993e;
            com.ss.android.socialbase.downloader.c.a.b(str3, "after pendDownloadTask pendingTasks.size:" + this.a.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        com.ss.android.socialbase.downloader.c.a.a(i2);
    }
}
