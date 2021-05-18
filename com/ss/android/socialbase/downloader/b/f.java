package com.ss.android.socialbase.downloader.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.s;
import d.o.a.e.b.i.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class f implements ServiceConnection, s {
    public static boolean l;
    public static int m;
    public static long n;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.c f35974e;

    /* renamed from: h  reason: collision with root package name */
    public d f35977h;
    public Future<?> j;

    /* renamed from: f  reason: collision with root package name */
    public Handler f35975f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f35976g = null;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f35978i = new a();
    public CountDownLatch k = new CountDownLatch(1);

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.l || f.this.f35977h == null) {
                return;
            }
            f.this.f35977h.a();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IBinder f35985e;

        /* loaded from: classes7.dex */
        public class a implements IBinder.DeathRecipient {
            public a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                boolean unused = f.l = false;
                if (f.this.v() || f.this.f35977h == null) {
                    return;
                }
                f.this.f35975f.postDelayed(f.this.f35978i, 2000L);
            }
        }

        public b(IBinder iBinder) {
            this.f35985e = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (f.this.f35976g != null && f.this.f35974e != null) {
                        f.this.f35974e.a(f.this.f35976g);
                    }
                    f.this.k.countDown();
                    this.f35985e.linkToDeath(new a(), 0);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.a(d.o.a.e.b.g.d.l(), f.this);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public f() {
        SqlDownloadCacheService.a(d.o.a.e.b.g.d.l(), this);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.b.run():void] */
    public static /* synthetic */ d a(f fVar) {
        return fVar.f35977h;
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(int i2, Map<Long, i> map) {
        return false;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.b(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> c(String str) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.c(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> d(String str) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.d(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean e(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.e(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean f(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.f(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo g(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.g(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo h(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.h(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo i(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.i(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo j(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.j(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.o.a.e.b.g.j
    /* renamed from: k */
    public ArrayList<i> n(int i2) {
        return null;
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, i> l(int i2) {
        return null;
    }

    public void l() {
        try {
            if (this.f35974e != null) {
                this.f35974e.a();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void m(int i2) {
    }

    public void m(com.ss.android.socialbase.downloader.b.b bVar) {
        synchronized (this) {
            if (this.f35974e != null) {
                try {
                    this.f35974e.a(bVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f35976g = bVar;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l = true;
        this.f35975f.removeCallbacks(this.f35978i);
        try {
            this.f35974e = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.j = d.o.a.e.b.g.d.w0().submit(new b(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f35974e = null;
        l = false;
    }

    public final boolean v() {
        if (Build.VERSION.SDK_INT < 26 && !l) {
            if (m > 5) {
                d.o.a.e.b.c.a.i("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - n < 15000) {
                d.o.a.e.b.c.a.i("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            m++;
            n = currentTimeMillis;
            this.f35975f.postDelayed(new c(), 1000L);
            return true;
        }
        return false;
    }

    @Override // d.o.a.e.b.g.s
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d.o.a.e.b.b.b bVar) {
        d.o.a.e.b.g.d.w0().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                d.o.a.e.b.b.b bVar2;
                Future future;
                f.this.m(new b.a() { // from class: com.ss.android.socialbase.downloader.b.f.4.1
                    @Override // com.ss.android.socialbase.downloader.b.b
                    public void a(Map map, Map map2) {
                        d.o.a.e.b.l.e.t(sparseArray, map);
                        d.o.a.e.b.l.e.t(sparseArray2, map2);
                        bVar.a();
                        f.this.m((com.ss.android.socialbase.downloader.b.b) null);
                    }
                });
                try {
                    z = !f.this.k.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = f.this.j) != null) {
                    future.cancel(true);
                }
                f.this.l();
                if (!z || (bVar2 = bVar) == null) {
                    return;
                }
                bVar2.a();
            }
        });
    }

    public void n(d dVar) {
        this.f35977h = dVar;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> a(String str) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.a(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> b(String str) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.b(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.c(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void d(int i2) {
        try {
            if (this.f35974e != null) {
                this.f35974e.d(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.f35974e != null) {
                this.f35974e.a(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.f35974e != null) {
                this.f35974e.b(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo c(int i2, long j) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.c(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo d(int i2, long j) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.d(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, long j) {
        try {
            if (this.f35974e != null) {
                this.f35974e.a(i2, i3, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b() {
        try {
            if (this.f35974e != null) {
                this.f35974e.b();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean c() {
        try {
            if (this.f35974e != null) {
                return this.f35974e.c();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean d() {
        try {
            if (this.f35974e != null) {
                return this.f35974e.d();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, long j) {
        try {
            if (this.f35974e != null) {
                this.f35974e.a(i2, i3, i4, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2, long j) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.b(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.f35974e != null) {
                this.f35974e.a(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(DownloadInfo downloadInfo) {
        try {
            if (this.f35974e != null) {
                this.f35974e.b(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, int i3) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.a(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.f35974e != null) {
                this.f35974e.b(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(DownloadInfo downloadInfo) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.a(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j, String str, String str2) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.a(i2, j, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j) {
        try {
            if (this.f35974e != null) {
                return this.f35974e.a(i2, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.f35974e != null) {
                this.f35974e.a(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
