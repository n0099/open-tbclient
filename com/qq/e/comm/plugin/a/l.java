package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.s;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final l f11923a = new l();

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.a.d.c f11924b;
    private boolean c = false;
    private s d;
    private BroadcastReceiver e;
    private ServiceConnection f;
    private final k g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            l.this.d = s.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            l.this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final com.qq.e.comm.plugin.a.d.c f11926a;

        b(com.qq.e.comm.plugin.a.d.c cVar) {
            this.f11926a = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f11926a.a(intent.getStringExtra("package"), intent.getIntExtra("status", 0), intent.getIntExtra("progress", 0), intent.getLongExtra("totalSize", 0L));
            } catch (Throwable th) {
                GDTLogger.w("StatusBroadCastReceiver#onReceive", th);
            }
        }
    }

    private l() {
        if (MultiProcessFlag.isMultiProcess()) {
            f();
        }
        this.g = new k(GDTADManager.getInstance().getAppContext());
    }

    public static l a() {
        return f11923a;
    }

    private c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<c> d = d();
        if (d == null || d.isEmpty()) {
            return null;
        }
        for (c cVar : d) {
            if (cVar != null && str.equals(cVar.h())) {
                return cVar;
            }
        }
        GDTLogger.d("Not find task matched name: " + str);
        return null;
    }

    private void f() {
        this.c = true;
        Context appContext = GDTADManager.getInstance().getAppContext();
        Intent c = j.c(appContext);
        this.f = new a();
        appContext.bindService(c, this.f, 1);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(appContext.getPackageName() + ".gdtdownload");
        this.f11924b = new com.qq.e.comm.plugin.a.d.c();
        this.e = new b(this.f11924b);
        appContext.registerReceiver(this.e, intentFilter);
    }

    private void g() {
        this.c = false;
        Context appContext = GDTADManager.getInstance().getAppContext();
        appContext.unbindService(this.f);
        appContext.unregisterReceiver(this.e);
    }

    public int a(String str) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(str);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke getStatus in another process", e);
                    return 0;
                }
            }
            return 0;
        }
        return com.qq.e.comm.plugin.a.d.b.a().a(GDTADManager.getInstance().getAppContext(), str);
    }

    public void a(c cVar) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        appContext.startService(j.a(appContext, cVar));
    }

    public void a(com.qq.e.comm.plugin.a.d.a aVar) {
        if (this.c) {
            this.f11924b.a(aVar);
        } else {
            com.qq.e.comm.plugin.a.d.b.a().a(aVar);
        }
    }

    public void a(String str, com.qq.e.comm.plugin.a.d.a aVar) {
        if (this.c) {
            this.f11924b.a(str, aVar);
        } else {
            com.qq.e.comm.plugin.a.d.b.a().a(str, aVar);
        }
    }

    public boolean a(int i) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(i);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke resumeTask in another process", e);
                    return false;
                }
            }
            return false;
        }
        return this.g.a(i);
    }

    public boolean a(int i, int i2) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(i, i2);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke pauseTask in another process", e);
                    return false;
                }
            }
            return false;
        }
        return this.g.a(i, i2);
    }

    public boolean a(int i, int i2, long j) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(i, i2, j);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke updateProgress in another process", e);
                    return false;
                }
            }
            return false;
        }
        return this.g.a(i, i2, j);
    }

    public boolean a(int i, String str, int i2) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(i, str, i2);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke rmTask in another process", e);
                    return false;
                }
            }
            return false;
        }
        return this.g.a(i, str, i2);
    }

    public boolean a(String str, int i) {
        c c = c(str);
        if (c == null) {
            return false;
        }
        return a(c.m(), i);
    }

    public int b(c cVar) {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a(cVar);
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke getDownloadingTask in another process", e);
                    return 0;
                }
            }
            return 0;
        }
        return this.g.a(cVar);
    }

    public void b() {
        try {
            Context appContext = GDTADManager.getInstance().getAppContext();
            appContext.startService(j.a(appContext));
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    public void b(com.qq.e.comm.plugin.a.d.a aVar) {
        if (this.c) {
            this.f11924b.b(aVar);
        } else {
            com.qq.e.comm.plugin.a.d.b.a().b(aVar);
        }
    }

    public void b(String str, com.qq.e.comm.plugin.a.d.a aVar) {
        if (this.c) {
            this.f11924b.b(str, aVar);
        } else {
            com.qq.e.comm.plugin.a.d.b.a().b(str, aVar);
        }
    }

    public boolean b(String str) {
        c c = c(str);
        if (c == null) {
            return false;
        }
        return a(c.m());
    }

    public void c() {
        try {
            Context appContext = GDTADManager.getInstance().getAppContext();
            appContext.startService(j.b(appContext));
        } catch (Throwable th) {
            GDTLogger.w(th.getMessage(), th);
        }
    }

    public List<c> d() {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.a();
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke getDownloadingTask in another process", e);
                    return null;
                }
            }
            return null;
        }
        return this.g.b();
    }

    public List<c> e() {
        if (this.c) {
            if (this.d != null) {
                try {
                    return this.d.b();
                } catch (RemoteException e) {
                    GDTLogger.e("Exception while invoke getDownloadingTask in another process", e);
                    return null;
                }
            }
            return null;
        }
        return this.g.d();
    }

    protected void finalize() throws Throwable {
        g();
        super.finalize();
    }
}
