package d.o.a.e.b.g;

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
/* loaded from: classes7.dex */
public abstract class c implements o {
    public static final String l = "c";

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Service> f71088e;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f71091h;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f71089f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71090g = false;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f71092i = false;
    public Handler j = new Handler(Looper.getMainLooper());
    public Runnable k = new a();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.g(c.l, "tryDownload: 2 try");
            }
            if (c.this.f71090g) {
                return;
            }
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.g(c.l, "tryDownload: 2 error");
            }
            c.this.e(d.l(), null);
        }
    }

    @Override // d.o.a.e.b.g.o
    public void a(Intent intent, int i2, int i3) {
    }

    @Override // d.o.a.e.b.g.o
    public boolean a() {
        return this.f71090g;
    }

    @Override // d.o.a.e.b.g.o
    public void b(d.o.a.e.b.n.a aVar) {
    }

    @Override // d.o.a.e.b.g.o
    public boolean b() {
        String str = l;
        d.o.a.e.b.c.a.h(str, "isServiceForeground = " + this.f71091h);
        return this.f71091h;
    }

    @Override // d.o.a.e.b.g.o
    public void c() {
    }

    @Override // d.o.a.e.b.g.o
    public void c(WeakReference weakReference) {
        this.f71088e = weakReference;
    }

    @Override // d.o.a.e.b.g.o
    public void d() {
        this.f71090g = false;
    }

    @Override // d.o.a.e.b.g.o
    public void d(n nVar) {
    }

    public abstract void e(Context context, ServiceConnection serviceConnection);

    public void f(d.o.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = l;
        d.o.a.e.b.c.a.g(str, "pendDownloadTask pendingTasks.size:" + this.f71089f.size() + " downloadTask.getDownloadId():" + aVar.G());
        if (this.f71089f.get(aVar.G()) == null) {
            synchronized (this.f71089f) {
                if (this.f71089f.get(aVar.G()) == null) {
                    this.f71089f.put(aVar.G(), aVar);
                }
            }
        }
        String str2 = l;
        d.o.a.e.b.c.a.g(str2, "after pendDownloadTask pendingTasks.size:" + this.f71089f.size());
    }

    public void g() {
        SparseArray<d.o.a.e.b.n.a> clone;
        String str = l;
        d.o.a.e.b.c.a.g(str, "resumePendingTask pendingTasks.size:" + this.f71089f.size());
        synchronized (this.f71089f) {
            clone = this.f71089f.clone();
            this.f71089f.clear();
        }
        d.o.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            for (int i2 = 0; i2 < clone.size(); i2++) {
                d.o.a.e.b.n.a aVar = clone.get(clone.keyAt(i2));
                if (aVar != null) {
                    c2.m(aVar);
                }
            }
        }
    }

    @Override // d.o.a.e.b.g.o
    public IBinder a(Intent intent) {
        d.o.a.e.b.c.a.g(l, "onBind Abs");
        return new Binder();
    }

    @Override // d.o.a.e.b.g.o
    public void a(int i2, Notification notification) {
        WeakReference<Service> weakReference = this.f71088e;
        if (weakReference != null && weakReference.get() != null) {
            String str = l;
            d.o.a.e.b.c.a.h(str, "startForeground  id = " + i2 + ", service = " + this.f71088e.get() + ",  isServiceAlive = " + this.f71090g);
            try {
                this.f71088e.get().startForeground(i2, notification);
                this.f71091h = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        d.o.a.e.b.c.a.i(l, "startForeground: downloadService is null, do nothing!");
    }

    @Override // d.o.a.e.b.g.o
    public void f() {
        if (this.f71090g) {
            return;
        }
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(l, "startService");
        }
        e(d.l(), null);
    }

    @Override // d.o.a.e.b.g.o
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f71088e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = l;
        d.o.a.e.b.c.a.h(str, "stopForeground  service = " + this.f71088e.get() + ",  isServiceAlive = " + this.f71090g);
        try {
            this.f71091h = false;
            this.f71088e.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.o
    public void a(d.o.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f71090g) {
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.g(l, "tryDownload but service is not alive");
            }
            if (d.o.a.e.b.l.a.a(262144)) {
                synchronized (this.f71089f) {
                    f(aVar);
                    if (!this.f71092i) {
                        if (d.o.a.e.b.c.a.e()) {
                            d.o.a.e.b.c.a.g(l, "tryDownload: 1");
                        }
                        e(d.l(), null);
                        this.f71092i = true;
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
        if (this.f71089f.get(aVar.G()) != null) {
            synchronized (this.f71089f) {
                if (this.f71089f.get(aVar.G()) != null) {
                    this.f71089f.remove(aVar.G());
                }
            }
        }
        d.o.a.e.b.m.a c2 = d.c();
        if (c2 != null) {
            c2.m(aVar);
        }
        g();
    }

    @Override // d.o.a.e.b.g.o
    public void a(int i2) {
        d.o.a.e.b.c.a.a(i2);
    }
}
