package d.p.a.e.b.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.h;
/* loaded from: classes6.dex */
public class m extends d.p.a.e.b.g.c implements ServiceConnection {
    public static final String p = m.class.getSimpleName();
    public com.ss.android.socialbase.downloader.downloader.h m;
    public d.p.a.e.b.g.n n;
    public int o = -1;

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(p, "downloader process sync database on main process!");
            d.p.a.e.b.j.a.k("fix_sigbus_downloader_db", true);
        }
        d.p.a.e.b.c.a.g(p, "onBind IndependentDownloadBinder");
        return new com.ss.android.socialbase.downloader.impls.m();
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void b(d.p.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        d.p.a.e.b.g.e.c().h(aVar.G(), true);
        a c2 = d.p.a.e.b.g.d.c();
        if (c2 != null) {
            c2.m(aVar);
        }
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void d(d.p.a.e.b.g.n nVar) {
        this.n = nVar;
    }

    @Override // d.p.a.e.b.g.c
    public void e(Context context, ServiceConnection serviceConnection) {
        try {
            d.p.a.e.b.c.a.g(p, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (d.p.a.e.b.l.e.D()) {
                intent.putExtra("fix_downloader_db_sigbus", d.p.a.e.b.j.a.r().l("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void f() {
        if (this.m == null) {
            e(d.p.a.e.b.g.d.l(), this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.m = null;
        d.p.a.e.b.g.n nVar = this.n;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d.p.a.e.b.c.a.g(p, "onServiceConnected ");
        this.m = h.a.a(iBinder);
        d.p.a.e.b.g.n nVar = this.n;
        if (nVar != null) {
            nVar.a(iBinder);
        }
        String str = p;
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.m != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.f68113f.size());
        d.p.a.e.b.c.a.g(str, sb.toString());
        if (this.m != null) {
            d.p.a.e.b.g.e.c().p();
            this.f68114g = true;
            this.i = false;
            int i = this.o;
            if (i != -1) {
                try {
                    this.m.l(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            synchronized (this.f68113f) {
                if (this.m != null) {
                    SparseArray<d.p.a.e.b.n.a> clone = this.f68113f.clone();
                    this.f68113f.clear();
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        d.p.a.e.b.n.a aVar = clone.get(clone.keyAt(i2));
                        if (aVar != null) {
                            try {
                                this.m.a(com.ss.android.socialbase.downloader.i.f.G(aVar));
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        d.p.a.e.b.c.a.g(p, "onServiceDisconnected ");
        this.m = null;
        this.f68114g = false;
        d.p.a.e.b.g.n nVar = this.n;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void a(d.p.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = p;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.m == null);
        d.p.a.e.b.c.a.g(str, sb.toString());
        if (this.m == null) {
            f(aVar);
            e(d.p.a.e.b.g.d.l(), this);
            return;
        }
        if (this.f68113f.get(aVar.G()) != null) {
            synchronized (this.f68113f) {
                if (this.f68113f.get(aVar.G()) != null) {
                    this.f68113f.remove(aVar.G());
                }
            }
        }
        try {
            this.m.a(com.ss.android.socialbase.downloader.i.f.G(aVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        synchronized (this.f68113f) {
            SparseArray<d.p.a.e.b.n.a> clone = this.f68113f.clone();
            this.f68113f.clear();
            if (d.p.a.e.b.g.d.c() != null) {
                for (int i = 0; i < clone.size(); i++) {
                    if (clone.get(clone.keyAt(i)) != null) {
                        try {
                            this.m.a(com.ss.android.socialbase.downloader.i.f.G(aVar));
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void a(int i) {
        com.ss.android.socialbase.downloader.downloader.h hVar = this.m;
        if (hVar == null) {
            this.o = i;
            return;
        }
        try {
            hVar.l(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
