package d.p.a.e.b.g;

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
/* loaded from: classes6.dex */
public abstract class c implements o {
    public static final String l = "c";

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Service> f68112e;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f68115h;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<d.p.a.e.b.n.a> f68113f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f68114g = false;
    public volatile boolean i = false;
    public Handler j = new Handler(Looper.getMainLooper());
    public Runnable k = new a();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.g(c.l, "tryDownload: 2 try");
            }
            if (c.this.f68114g) {
                return;
            }
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.g(c.l, "tryDownload: 2 error");
            }
            c.this.e(d.l(), null);
        }
    }

    @Override // d.p.a.e.b.g.o
    public void a(Intent intent, int i, int i2) {
    }

    @Override // d.p.a.e.b.g.o
    public boolean a() {
        return this.f68114g;
    }

    @Override // d.p.a.e.b.g.o
    public void b(d.p.a.e.b.n.a aVar) {
    }

    @Override // d.p.a.e.b.g.o
    public boolean b() {
        String str = l;
        d.p.a.e.b.c.a.h(str, "isServiceForeground = " + this.f68115h);
        return this.f68115h;
    }

    @Override // d.p.a.e.b.g.o
    public void c() {
    }

    @Override // d.p.a.e.b.g.o
    public void c(WeakReference weakReference) {
        this.f68112e = weakReference;
    }

    @Override // d.p.a.e.b.g.o
    public void d() {
        this.f68114g = false;
    }

    @Override // d.p.a.e.b.g.o
    public void d(n nVar) {
    }

    public abstract void e(Context context, ServiceConnection serviceConnection);

    public void f(d.p.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = l;
        d.p.a.e.b.c.a.g(str, "pendDownloadTask pendingTasks.size:" + this.f68113f.size() + " downloadTask.getDownloadId():" + aVar.G());
        if (this.f68113f.get(aVar.G()) == null) {
            synchronized (this.f68113f) {
                if (this.f68113f.get(aVar.G()) == null) {
                    this.f68113f.put(aVar.G(), aVar);
                }
            }
        }
        String str2 = l;
        d.p.a.e.b.c.a.g(str2, "after pendDownloadTask pendingTasks.size:" + this.f68113f.size());
    }

    public void g() {
        SparseArray<d.p.a.e.b.n.a> clone;
        String str = l;
        d.p.a.e.b.c.a.g(str, "resumePendingTask pendingTasks.size:" + this.f68113f.size());
        synchronized (this.f68113f) {
            clone = this.f68113f.clone();
            this.f68113f.clear();
        }
        d.p.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            for (int i = 0; i < clone.size(); i++) {
                d.p.a.e.b.n.a aVar = clone.get(clone.keyAt(i));
                if (aVar != null) {
                    c2.m(aVar);
                }
            }
        }
    }

    @Override // d.p.a.e.b.g.o
    public IBinder a(Intent intent) {
        d.p.a.e.b.c.a.g(l, "onBind Abs");
        return new Binder();
    }

    @Override // d.p.a.e.b.g.o
    public void a(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f68112e;
        if (weakReference != null && weakReference.get() != null) {
            String str = l;
            d.p.a.e.b.c.a.h(str, "startForeground  id = " + i + ", service = " + this.f68112e.get() + ",  isServiceAlive = " + this.f68114g);
            try {
                this.f68112e.get().startForeground(i, notification);
                this.f68115h = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        d.p.a.e.b.c.a.i(l, "startForeground: downloadService is null, do nothing!");
    }

    @Override // d.p.a.e.b.g.o
    public void f() {
        if (this.f68114g) {
            return;
        }
        if (d.p.a.e.b.c.a.e()) {
            d.p.a.e.b.c.a.g(l, "startService");
        }
        e(d.l(), null);
    }

    @Override // d.p.a.e.b.g.o
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f68112e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = l;
        d.p.a.e.b.c.a.h(str, "stopForeground  service = " + this.f68112e.get() + ",  isServiceAlive = " + this.f68114g);
        try {
            this.f68115h = false;
            this.f68112e.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.p.a.e.b.g.o
    public void a(d.p.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f68114g) {
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.g(l, "tryDownload but service is not alive");
            }
            if (d.p.a.e.b.l.a.a(262144)) {
                synchronized (this.f68113f) {
                    f(aVar);
                    if (!this.i) {
                        if (d.p.a.e.b.c.a.e()) {
                            d.p.a.e.b.c.a.g(l, "tryDownload: 1");
                        }
                        e(d.l(), null);
                        this.i = true;
                    } else {
                        this.j.removeCallbacks(this.k);
                        this.j.postDelayed(this.k, 10L);
                    }
                }
                return;
            }
            f(aVar);
            e(d.l(), null);
            return;
        }
        if (this.f68113f.get(aVar.G()) != null) {
            synchronized (this.f68113f) {
                if (this.f68113f.get(aVar.G()) != null) {
                    this.f68113f.remove(aVar.G());
                }
            }
        }
        d.p.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.m(aVar);
        }
        g();
    }

    @Override // d.p.a.e.b.g.o
    public void a(int i) {
        d.p.a.e.b.c.a.a(i);
    }
}
