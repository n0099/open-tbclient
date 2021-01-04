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
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class a implements p {
    private static final String e = a.class.getSimpleName();
    protected volatile boolean c;
    private WeakReference<Service> f;

    /* renamed from: a  reason: collision with root package name */
    protected final SparseArray<com.ss.android.socialbase.downloader.g.d> f13429a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f13430b = false;
    protected volatile boolean d = false;
    private Handler g = new Handler(Looper.getMainLooper());
    private Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.f.a.a()) {
                com.ss.android.socialbase.downloader.f.a.b(a.e, "tryDownload: 2 try");
            }
            if (!a.this.f13430b) {
                if (com.ss.android.socialbase.downloader.f.a.a()) {
                    com.ss.android.socialbase.downloader.f.a.b(a.e, "tryDownload: 2 error");
                }
                a.this.a(b.eHp(), (ServiceConnection) null);
            }
        }
    };

    protected void a(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(WeakReference weakReference) {
        this.f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public boolean a() {
        return this.f13430b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public boolean b() {
        com.ss.android.socialbase.downloader.f.a.c(e, "isServiceForeground = " + this.c);
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public IBinder a(Intent intent) {
        com.ss.android.socialbase.downloader.f.a.b(e, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(int i, Notification notification) {
        if (this.f != null && this.f.get() != null) {
            com.ss.android.socialbase.downloader.f.a.c(e, "startForeground  id = " + i + ", service = " + this.f.get() + ",  isServiceAlive = " + this.f13430b);
            try {
                this.f.get().startForeground(i, notification);
                this.c = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.f.a.d(e, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(boolean z) {
        if (this.f != null && this.f.get() != null) {
            com.ss.android.socialbase.downloader.f.a.c(e, "stopForeground  service = " + this.f.get() + ",  isServiceAlive = " + this.f13430b);
            try {
                this.c = false;
                this.f.get().stopForeground(z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void d() {
        this.f13430b = false;
    }

    public void a(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(e, "pendDownloadTask pendingTasks.size:" + this.f13429a.size() + " downloadTask.getDownloadId():" + dVar.o());
            if (this.f13429a.get(dVar.o()) == null) {
                synchronized (this.f13429a) {
                    if (this.f13429a.get(dVar.o()) == null) {
                        this.f13429a.put(dVar.o(), dVar);
                    }
                }
            }
            com.ss.android.socialbase.downloader.f.a.b(e, "after pendDownloadTask pendingTasks.size:" + this.f13429a.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            if (!this.f13430b) {
                if (com.ss.android.socialbase.downloader.f.a.a()) {
                    com.ss.android.socialbase.downloader.f.a.b(e, "tryDownload but service is not alive");
                }
                if (com.ss.android.socialbase.downloader.m.a.a(262144)) {
                    synchronized (this.f13429a) {
                        a(dVar);
                        if (!this.d) {
                            if (com.ss.android.socialbase.downloader.f.a.a()) {
                                com.ss.android.socialbase.downloader.f.a.b(e, "tryDownload: 1");
                            }
                            a(b.eHp(), (ServiceConnection) null);
                            this.d = true;
                        } else {
                            this.g.removeCallbacks(this.h);
                            this.g.postDelayed(this.h, 10L);
                        }
                    }
                    return;
                }
                a(dVar);
                a(b.eHp(), (ServiceConnection) null);
                return;
            }
            if (this.f13429a.get(dVar.o()) != null) {
                synchronized (this.f13429a) {
                    if (this.f13429a.get(dVar.o()) != null) {
                        this.f13429a.remove(dVar.o());
                    }
                }
            }
            com.ss.android.socialbase.downloader.impls.a eHk = b.eHk();
            if (eHk != null) {
                eHk.a(dVar);
            }
            e();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void c(com.ss.android.socialbase.downloader.g.d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        SparseArray<com.ss.android.socialbase.downloader.g.d> clone;
        com.ss.android.socialbase.downloader.f.a.b(e, "resumePendingTask pendingTasks.size:" + this.f13429a.size());
        synchronized (this.f13429a) {
            clone = this.f13429a.clone();
            this.f13429a.clear();
        }
        com.ss.android.socialbase.downloader.impls.a eHk = b.eHk();
        if (eHk != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < clone.size()) {
                    com.ss.android.socialbase.downloader.g.d dVar = clone.get(clone.keyAt(i2));
                    if (dVar != null) {
                        eHk.a(dVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(o oVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a(int i) {
        com.ss.android.socialbase.downloader.f.a.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void f() {
        if (!this.f13430b) {
            if (com.ss.android.socialbase.downloader.f.a.a()) {
                com.ss.android.socialbase.downloader.f.a.b(e, "startService");
            }
            a(b.eHp(), (ServiceConnection) null);
        }
    }
}
