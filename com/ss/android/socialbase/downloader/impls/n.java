package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes4.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public static final String f60216e = n.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.i f60217f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.n f60218g;

    /* renamed from: h  reason: collision with root package name */
    public int f60219h = -1;

    private void g() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.a) {
                clone = this.a.clone();
                this.a.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.c.C() == null) {
                return;
            }
            for (int i2 = 0; i2 < clone.size(); i2++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i2));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        try {
                            this.f60217f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.c.a.a(f60216e, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.c.a.b(f60216e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = f60216e;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.f60217f == null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f60217f == null) {
            a(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
            return;
        }
        g();
        try {
            this.f60217f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.d.a().a(downloadTask.getDownloadId(), true);
        a C = com.ss.android.socialbase.downloader.downloader.c.C();
        if (C != null) {
            C.a(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f60217f = null;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f60218g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.ss.android.socialbase.downloader.c.a.b(f60216e, "onServiceConnected ");
        this.f60217f = i.a.a(iBinder);
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f60218g;
        if (nVar != null) {
            nVar.a(iBinder);
        }
        String str = f60216e;
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.f60217f != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.a.size());
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f60217f != null) {
            com.ss.android.socialbase.downloader.downloader.d.a().b();
            this.f59994b = true;
            this.f59996d = false;
            int i2 = this.f60219h;
            if (i2 != -1) {
                try {
                    this.f60217f.l(i2);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f60217f != null) {
                g();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.c.a.b(f60216e, "onServiceDisconnected ");
        this.f60217f = null;
        this.f59994b = false;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f60218g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.c.a.b(f60216e, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.c.a.b(f60216e, "stopService");
        this.f59994b = false;
        Intent intent = new Intent(context, IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(com.ss.android.socialbase.downloader.downloader.n nVar) {
        this.f60218g = nVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(int i2) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.f60217f;
        if (iVar == null) {
            this.f60219h = i2;
            return;
        }
        try {
            iVar.l(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        if (this.f60217f == null) {
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
        }
    }
}
