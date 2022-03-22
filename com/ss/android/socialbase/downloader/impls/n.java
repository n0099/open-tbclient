package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes7.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public static final String f43433e = n.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.i f43434f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.n f43435g;

    /* renamed from: h  reason: collision with root package name */
    public int f43436h = -1;

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
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        try {
                            this.f43434f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.c.a.a(f43433e, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(f43433e, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.c.a.b(f43433e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = f43433e;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.f43434f == null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f43434f == null) {
            a(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
            return;
        }
        g();
        try {
            this.f43434f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
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
        this.f43434f = null;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f43435g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.ss.android.socialbase.downloader.c.a.b(f43433e, "onServiceConnected ");
        this.f43434f = i.a.a(iBinder);
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f43435g;
        if (nVar != null) {
            nVar.a(iBinder);
        }
        String str = f43433e;
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.f43434f != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.a.size());
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f43434f != null) {
            com.ss.android.socialbase.downloader.downloader.d.a().b();
            this.f43239b = true;
            this.f43241d = false;
            int i = this.f43436h;
            if (i != -1) {
                try {
                    this.f43434f.l(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f43434f != null) {
                g();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.c.a.b(f43433e, "onServiceDisconnected ");
        this.f43434f = null;
        this.f43239b = false;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.f43435g;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.c.a.b(f43433e, "bindService");
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
        com.ss.android.socialbase.downloader.c.a.b(f43433e, "stopService");
        this.f43239b = false;
        Intent intent = new Intent(context, IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(com.ss.android.socialbase.downloader.downloader.n nVar) {
        this.f43435g = nVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(int i) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.f43434f;
        if (iVar == null) {
            this.f43436h = i;
            return;
        }
        try {
            iVar.l(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void startService() {
        if (this.f43434f == null) {
            startService(com.ss.android.socialbase.downloader.downloader.c.N(), this);
        }
    }
}
