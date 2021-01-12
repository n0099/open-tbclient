package com.qq.e.comm.plugin.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.plugin.a.r;
import com.qq.e.comm.plugin.a.s;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class m implements SVSD, r.a {
    private static final ArrayList<String> e = new ArrayList<>();
    private static final HashMap<String, ReentrantLock> f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final Service f11627a;

    /* renamed from: b  reason: collision with root package name */
    private r f11628b;
    private final Context c;
    private final ConcurrentHashMap<String, Intent> d = new ConcurrentHashMap<>();
    private boolean g;
    private boolean h;
    private final k i;

    /* loaded from: classes3.dex */
    private class a extends s.a {
        private a() {
        }

        @Override // com.qq.e.comm.plugin.a.s
        public int a(c cVar) throws RemoteException {
            return m.this.i.a(cVar);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public int a(String str) throws RemoteException {
            return com.qq.e.comm.plugin.a.d.b.a().a(m.this.c, str);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public List<c> a() throws RemoteException {
            return m.this.i.b();
        }

        @Override // com.qq.e.comm.plugin.a.s
        public boolean a(int i) throws RemoteException {
            return m.this.i.a(i);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public boolean a(int i, int i2) throws RemoteException {
            return m.this.i.a(i, i2);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public boolean a(int i, int i2, long j) throws RemoteException {
            return m.this.i.a(i, i2, j);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public boolean a(int i, String str, int i2) throws RemoteException {
            return m.this.i.a(i, str, i2);
        }

        @Override // com.qq.e.comm.plugin.a.s
        public List<c> b() throws RemoteException {
            return m.this.i.d();
        }
    }

    public m(Service service) {
        this.f11627a = service;
        this.c = service.getApplicationContext();
        this.i = new k(this.c);
    }

    private ReentrantLock a(String str) {
        if (f.containsKey(str)) {
            return f.get(str);
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        f.put(str, reentrantLock);
        return reentrantLock;
    }

    private void a(Intent intent) {
        if (this.h || !j.c(intent)) {
            return;
        }
        this.i.a();
        this.h = true;
    }

    private void a(final c cVar, final int i, final Intent intent) {
        ReentrantLock a2 = a(cVar.h());
        if (a2.isLocked()) {
            GDTLogger.d("there is already a download worker running");
            return;
        }
        e.add(cVar.h());
        new q(new o(this.c, cVar, intent, a2), new p(this.c, cVar), cVar) { // from class: com.qq.e.comm.plugin.a.m.1
            @Override // com.qq.e.comm.plugin.a.q
            public void a(int i2, String str) {
                if (i2 == 11) {
                    m.this.d.put(cVar.g(), intent);
                }
                if (m.this.d.isEmpty() && m.this.c()) {
                    m.this.a(i);
                }
            }
        }.b();
    }

    private void b(Intent intent) {
        if (this.g || !j.b(intent)) {
            return;
        }
        for (c cVar : this.i.c()) {
            if (!e.contains(cVar.h())) {
                this.i.a(cVar.m(), 0);
            }
        }
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        try {
            for (c cVar : this.i.e()) {
                if (cVar.o() != 8) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    private void d() {
        if (this.f11628b == null) {
            this.f11628b = new r(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.c.registerReceiver(this.f11628b, intentFilter);
            GDTLogger.d("注册网络状态广播接收器");
        }
    }

    private void e() {
        if (this.f11628b != null) {
            this.c.unregisterReceiver(this.f11628b);
            this.f11628b = null;
            GDTLogger.d("取消网络状态广播接收器");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g();
        this.i.a();
    }

    private void g() {
        if (this.d.isEmpty()) {
            return;
        }
        try {
            for (Intent intent : this.d.values()) {
                j.a(intent, false);
                this.f11627a.startService(intent);
            }
            this.d.clear();
        } catch (Throwable th) {
            String th2 = th.toString();
            GDTLogger.e(th2);
            com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
            dVar.a("msg", th2);
            u.a(100252, this.d.size(), null, dVar);
        }
    }

    @Override // com.qq.e.comm.plugin.a.r.a
    public void a() {
        com.qq.e.comm.plugin.util.s.f12589a.submit(new Runnable() { // from class: com.qq.e.comm.plugin.a.m.2
            @Override // java.lang.Runnable
            public void run() {
                m.this.f();
            }
        });
    }

    void a(int i) {
        this.f11627a.stopSelf(i);
    }

    @Override // com.qq.e.comm.plugin.a.r.a
    public void b() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public IBinder onBind(Intent intent) {
        GDTLogger.d("OnBind ");
        return new a();
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onCreate() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onDestroy() {
        f.clear();
        e();
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onLowMemory() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onRebind(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            a(intent);
            b(intent);
            c a2 = c.a(j.a(intent));
            if (a2 != null && !com.qq.e.comm.plugin.a.d.d.b(com.qq.e.comm.plugin.a.d.b.a().a(this.c, a2.h()))) {
                d();
                boolean d = j.d(intent);
                if (d) {
                    a2.d(2);
                } else {
                    a2.e(2);
                }
                if (d && !this.d.isEmpty()) {
                    this.d.remove(a2.g());
                }
                a(a2, i2, intent);
            }
        }
        return 2;
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTaskRemoved(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTrimMemory(int i) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public boolean onUnbind(Intent intent) {
        return true;
    }
}
