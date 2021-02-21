package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {
    private static final String e = n.class.getSimpleName();
    private static int i = 0;
    private static long j = 0;
    private int h = -1;
    private Handler k = new Handler(Looper.getMainLooper());
    private boolean l;
    private com.ss.android.socialbase.downloader.downloader.j qhp;
    private com.ss.android.socialbase.downloader.downloader.o qhq;
    private ServiceConnection qhr;

    static /* synthetic */ int k() {
        int i2 = i;
        i = i2 + 1;
        return i2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.f.a.b(e, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.m.d.a()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.k.a.eIF().a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            this.qhr = serviceConnection;
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(e, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.k.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.f.a.b(e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void b(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b(e, "tryDownload aidlService == null:" + (this.qhp == null));
            if (this.qhp == null) {
                a(dVar);
                a(com.ss.android.socialbase.downloader.downloader.b.eGC(), this);
                return;
            }
            if (this.f13132a.get(dVar.o()) != null) {
                synchronized (this.f13132a) {
                    if (this.f13132a.get(dVar.o()) != null) {
                        this.f13132a.remove(dVar.o());
                    }
                }
            }
            try {
                this.qhp.a(com.ss.android.socialbase.downloader.m.e.f(dVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            synchronized (this.f13132a) {
                SparseArray<com.ss.android.socialbase.downloader.g.d> clone = this.f13132a.clone();
                this.f13132a.clear();
                if (com.ss.android.socialbase.downloader.downloader.b.eGx() != null) {
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        if (clone.get(clone.keyAt(i2)) != null) {
                            try {
                                this.qhp.a(com.ss.android.socialbase.downloader.m.e.f(dVar));
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void c(com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.downloader.c.eGG().a(dVar.o(), true);
            a eGx = com.ss.android.socialbase.downloader.downloader.b.eGx();
            if (eGx != null) {
                eGx.a(dVar);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.ss.android.socialbase.downloader.f.a.b(e, "onServiceConnected ");
        this.qhp = j.a.a(iBinder);
        com.ss.android.socialbase.downloader.downloader.b.eGC();
        if (Build.VERSION.SDK_INT < 26 && com.ss.android.socialbase.downloader.m.a.a(512) && com.ss.android.socialbase.downloader.m.d.a()) {
            try {
                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.impls.n.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        com.ss.android.socialbase.downloader.f.a.d(n.e, "binderDied: mServiceConnection = " + n.this.qhr);
                        if (n.i < 5 && System.currentTimeMillis() - n.j > 15000) {
                            n.this.k.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.n.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.socialbase.downloader.f.a.b(n.e, "run: restart downloader process !!");
                                    n.this.l = true;
                                    try {
                                        n.this.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), n.this);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }, 1000L);
                            n.k();
                            long unused = n.j = System.currentTimeMillis();
                        }
                    }
                }, 0);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            if (this.l) {
                this.k.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.socialbase.downloader.downloader.b.eGk().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.n.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    n.this.l();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                        });
                    }
                }, 1000L);
                this.l = false;
            }
        }
        if (this.qhq != null) {
            this.qhq.a(iBinder);
        }
        com.ss.android.socialbase.downloader.f.a.b(e, "onServiceConnected aidlService!=null" + (this.qhp != null) + " pendingTasks.size:" + this.f13132a.size());
        if (this.qhp != null) {
            com.ss.android.socialbase.downloader.downloader.c.eGG().b();
            this.f13133b = true;
            this.d = false;
            if (this.h != -1) {
                try {
                    this.qhp.l(this.h);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                }
            }
            synchronized (this.f13132a) {
                if (this.qhp != null) {
                    SparseArray<com.ss.android.socialbase.downloader.g.d> clone = this.f13132a.clone();
                    this.f13132a.clear();
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        com.ss.android.socialbase.downloader.g.d dVar = clone.get(clone.keyAt(i2));
                        if (dVar != null) {
                            try {
                                this.qhp.a(com.ss.android.socialbase.downloader.m.e.f(dVar));
                            } catch (RemoteException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.f.a.b(e, "onServiceDisconnected ");
        this.qhp = null;
        this.f13133b = false;
        if (this.qhq != null) {
            this.qhq.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.qhp = null;
        if (this.qhq != null) {
            this.qhq.h();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void a(com.ss.android.socialbase.downloader.downloader.o oVar) {
        this.qhq = oVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void a(int i2) {
        if (this.qhp == null) {
            this.h = i2;
            return;
        }
        try {
            this.qhp.l(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.p
    public void f() {
        if (this.qhp == null) {
            a(com.ss.android.socialbase.downloader.downloader.b.eGC(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.ss.android.socialbase.downloader.downloader.m eGr;
        com.ss.android.socialbase.downloader.downloader.n CO;
        List<com.ss.android.socialbase.downloader.g.c> d;
        com.ss.android.socialbase.downloader.f.a.b(e, "resumeDownloaderProcessTaskForDied: ");
        if (com.ss.android.socialbase.downloader.downloader.b.eGC() != null && !TextUtils.isEmpty(com.ss.android.socialbase.downloader.b.e.f13074a) && (eGr = com.ss.android.socialbase.downloader.downloader.b.eGr()) != null && (CO = l.CO(true)) != null && (d = CO.d(com.ss.android.socialbase.downloader.b.e.f13074a)) != null && !d.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.ss.android.socialbase.downloader.g.c cVar : d) {
                if (cVar != null && cVar.ae() && cVar.w() == -5) {
                    arrayList.add(cVar);
                }
            }
            if (!arrayList.isEmpty()) {
                com.ss.android.socialbase.downloader.f.a.b(e, "resumeDownloaderProcessTaskForDied: resume size =" + arrayList.size());
                eGr.a(arrayList, 1);
            }
        }
    }
}
