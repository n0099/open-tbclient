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
    public com.ss.android.socialbase.downloader.b.c f38757e;

    /* renamed from: h  reason: collision with root package name */
    public d f38760h;
    public Future<?> j;

    /* renamed from: f  reason: collision with root package name */
    public Handler f38758f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.b.b f38759g = null;
    public Runnable i = new a();
    public CountDownLatch k = new CountDownLatch(1);

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.l || f.this.f38760h == null) {
                return;
            }
            f.this.f38760h.a();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IBinder f38767e;

        /* loaded from: classes7.dex */
        public class a implements IBinder.DeathRecipient {
            public a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                boolean unused = f.l = false;
                if (f.this.v() || f.this.f38760h == null) {
                    return;
                }
                f.this.f38758f.postDelayed(f.this.i, 2000L);
            }
        }

        public b(IBinder iBinder) {
            this.f38767e = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (f.this.f38759g != null && f.this.f38757e != null) {
                        f.this.f38757e.a(f.this.f38759g);
                    }
                    f.this.k.countDown();
                    this.f38767e.linkToDeath(new a(), 0);
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
        return fVar.f38760h;
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(int i, Map<Long, i> map) {
        return false;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.b(i);
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
            if (this.f38757e != null) {
                return this.f38757e.c(str);
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
            if (this.f38757e != null) {
                return this.f38757e.d(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean e(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.e(i);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean f(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.f(i);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo g(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.g(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo h(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.h(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo i(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.i(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo j(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.j(i);
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
    public ArrayList<i> n(int i) {
        return null;
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, i> l(int i) {
        return null;
    }

    public void l() {
        try {
            if (this.f38757e != null) {
                this.f38757e.a();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void m(int i) {
    }

    public void m(com.ss.android.socialbase.downloader.b.b bVar) {
        synchronized (this) {
            if (this.f38757e != null) {
                try {
                    this.f38757e.a(bVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f38759g = bVar;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l = true;
        this.f38758f.removeCallbacks(this.i);
        try {
            this.f38757e = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.j = d.o.a.e.b.g.d.w0().submit(new b(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f38757e = null;
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
            this.f38758f.postDelayed(new c(), 1000L);
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
        this.f38760h = dVar;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> a(String str) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.a(str);
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
            if (this.f38757e != null) {
                return this.f38757e.b(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.c(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void d(int i) {
        try {
            if (this.f38757e != null) {
                this.f38757e.d(i);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.f38757e != null) {
                this.f38757e.a(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.f38757e != null) {
                this.f38757e.b(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo c(int i, long j) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.c(i, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo d(int i, long j) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.d(i, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, long j) {
        try {
            if (this.f38757e != null) {
                this.f38757e.a(i, i2, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b() {
        try {
            if (this.f38757e != null) {
                this.f38757e.b();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean c() {
        try {
            if (this.f38757e != null) {
                return this.f38757e.c();
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
            if (this.f38757e != null) {
                return this.f38757e.d();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, int i3, long j) {
        try {
            if (this.f38757e != null) {
                this.f38757e.a(i, i2, i3, j);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i, long j) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.b(i, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f38757e != null) {
                this.f38757e.a(i, i2, i3, i4);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(DownloadInfo downloadInfo) {
        try {
            if (this.f38757e != null) {
                this.f38757e.b(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i, int i2) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.a(i, i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.f38757e != null) {
                this.f38757e.b(i, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(DownloadInfo downloadInfo) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.a(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.a(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i, long j) {
        try {
            if (this.f38757e != null) {
                return this.f38757e.a(i, j);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.f38757e != null) {
                this.f38757e.a(i, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
