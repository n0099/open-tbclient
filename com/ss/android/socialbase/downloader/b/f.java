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
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class f implements ServiceConnection, t {
    public static boolean b;
    public static int c;
    public static long d;
    @Nullable
    public c a;
    public c.a.InterfaceC0760a g;
    public Future<?> i;
    public Handler e = new Handler(Looper.getMainLooper());
    public b f = null;
    public Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (!f.b && f.this.g != null) {
                f.this.g.a();
            }
        }
    };
    public CountDownLatch j = new CountDownLatch(1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: a */
    public ArrayList<i> n(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i, Map<Long, i> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i) {
    }

    public f() {
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), this);
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.a();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        try {
            if (this.a != null) {
                return this.a.b();
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        try {
            if (this.a != null) {
                this.a.c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        try {
            if (this.a != null) {
                return this.a.d();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        try {
            if (this.a != null) {
                return this.a.e();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.2.run():void] */
    public static /* synthetic */ c.a.InterfaceC0760a a(f fVar) {
        return fVar.g;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i) {
        try {
            if (this.a != null) {
                return this.a.i(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i) {
        try {
            if (this.a != null) {
                return this.a.j(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
        b = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i) {
        try {
            if (this.a != null) {
                return this.a.b(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        try {
            if (this.a != null) {
                return this.a.c(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        try {
            if (this.a != null) {
                return this.a.d(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i) {
        try {
            if (this.a != null) {
                return this.a.e(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i) {
        try {
            if (this.a != null) {
                return this.a.f(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i) {
        try {
            if (this.a != null) {
                return this.a.g(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i) {
        try {
            if (this.a != null) {
                return this.a.h(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (Build.VERSION.SDK_INT >= 26 || b) {
            return false;
        }
        if (c > 5) {
            com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d < 15000) {
            com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        c++;
        d = currentTimeMillis;
        this.e.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), f.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, int i2) {
        try {
            if (this.a != null) {
                return this.a.a(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i, long j) {
        try {
            if (this.a != null) {
                return this.a.b(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i, long j) {
        try {
            if (this.a != null) {
                return this.a.c(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i, long j) {
        try {
            if (this.a != null) {
                return this.a.d(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        b = true;
        this.e.removeCallbacks(this.h);
        try {
            this.a = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.i = com.ss.android.socialbase.downloader.downloader.c.l().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (f.this.f != null && f.this.a != null) {
                            f.this.a.a(f.this.f);
                        }
                        f.this.j.countDown();
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.b.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.b = false;
                                if (!f.this.g() && f.this.g != null) {
                                    f.this.e.postDelayed(f.this.h, 2000L);
                                }
                            }
                        }, 0);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j) {
        try {
            if (this.a != null) {
                return this.a.a(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.a != null) {
                this.a.b(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        try {
            if (this.a != null) {
                return this.a.a(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        try {
            if (this.a != null) {
                return this.a.a(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        try {
            if (this.a != null) {
                return this.a.b(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        try {
            if (this.a != null) {
                return this.a.c(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i) {
        try {
            if (this.a != null) {
                this.a.d(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, int i4) {
        try {
            if (this.a != null) {
                this.a.a(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, long j) {
        try {
            if (this.a != null) {
                this.a.a(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, long j) {
        try {
            if (this.a != null) {
                this.a.a(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.a != null) {
                this.a.a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d dVar) {
        com.ss.android.socialbase.downloader.downloader.c.l().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                d dVar2;
                Future future;
                f.this.a(new b.a() { // from class: com.ss.android.socialbase.downloader.b.f.4.1
                    @Override // com.ss.android.socialbase.downloader.b.b
                    public void a(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.i.f.a(sparseArray, map);
                        com.ss.android.socialbase.downloader.i.f.a(sparseArray2, map2);
                        dVar.a();
                        f.this.a((b) null);
                    }
                });
                try {
                    z = !f.this.j.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = f.this.i) != null) {
                    future.cancel(true);
                }
                f.this.a();
                if (z && (dVar2 = dVar) != null) {
                    dVar2.a();
                }
            }
        });
    }

    public void a(b bVar) {
        synchronized (this) {
            if (this.a != null) {
                try {
                    this.a.a(bVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.f = bVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        try {
            if (this.a != null) {
                this.a.b(downloadInfo);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void a(c.a.InterfaceC0760a interfaceC0760a) {
        this.g = interfaceC0760a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.a != null) {
                this.a.b(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.a != null) {
                this.a.a(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        try {
            if (this.a != null) {
                return this.a.a(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
