package com.ss.android.socialbase.downloader.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.c.b;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.t;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class f implements ServiceConnection, t {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13100b;
    private static int c;
    private static long d = 0;
    private Future<?> arH;
    @Nullable
    private c qeT;
    private a qeV;
    private Handler e = new Handler(Looper.getMainLooper());
    private b qeU = null;
    private Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (!f.f13100b && f.this.qeV != null) {
                f.this.qeV.a();
            }
        }
    };
    private CountDownLatch qeW = new CountDownLatch(1);

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.c.f.2.run():void] */
    static /* synthetic */ a a(f fVar) {
        return fVar.qeV;
    }

    public f() {
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), this);
    }

    public void a(a aVar) {
        this.qeV = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f13100b = true;
        this.e.removeCallbacks(this.h);
        try {
            this.qeT = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.arH = com.ss.android.socialbase.downloader.downloader.b.eGk().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (f.this.qeU != null && f.this.qeT != null) {
                        f.this.qeT.a(f.this.qeU);
                    }
                    f.this.qeW.countDown();
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.c.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.f13100b = false;
                                if (!f.this.f() && f.this.qeV != null) {
                                    f.this.e.postDelayed(f.this.h, 2000L);
                                }
                            }
                        }, 0);
                    } catch (Throwable th2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.qeT = null;
        f13100b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (Build.VERSION.SDK_INT < 26 && !f13100b) {
            if (c > 5) {
                com.ss.android.socialbase.downloader.f.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - d < 15000) {
                com.ss.android.socialbase.downloader.f.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            c++;
            d = currentTimeMillis;
            this.e.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eGC(), f.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray2, final d dVar) {
        com.ss.android.socialbase.downloader.downloader.b.eGk().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.4
            @Override // java.lang.Runnable
            public void run() {
                Future future;
                boolean z = false;
                f.this.a(new b.a() { // from class: com.ss.android.socialbase.downloader.c.f.4.1
                    @Override // com.ss.android.socialbase.downloader.c.b
                    public void a(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.m.d.a(sparseArray, map);
                        com.ss.android.socialbase.downloader.m.d.a(sparseArray2, map2);
                        dVar.a();
                        f.this.a((b) null);
                    }
                });
                try {
                    if (!f.this.qeW.await(5000L, TimeUnit.MILLISECONDS)) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (z && (future = f.this.arH) != null) {
                    future.cancel(true);
                }
                f.this.a();
                if (z && dVar != null) {
                    dVar.a();
                }
            }
        });
    }

    public void a(b bVar) {
        synchronized (this) {
            if (this.qeT != null) {
                try {
                    this.qeT.a(bVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.qeU = bVar;
            }
        }
    }

    public void a() {
        try {
            if (this.qeT != null) {
                this.qeT.a();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.b(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        try {
            if (this.qeT != null) {
                return this.qeT.a(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        try {
            if (this.qeT != null) {
                return this.qeT.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        try {
            if (this.qeT != null) {
                return this.qeT.c(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        try {
            if (this.qeT != null) {
                return this.qeT.d(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.c(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        try {
            if (this.qeT != null) {
                this.qeT.d(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.qeT != null) {
                this.qeT.a(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.qeT != null) {
                this.qeT.b(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        try {
            if (this.qeT != null) {
                this.qeT.a(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        try {
            if (this.qeT != null) {
                this.qeT.a(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        try {
            if (this.qeT != null) {
                this.qeT.a(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        try {
            if (this.qeT != null) {
                return this.qeT.a(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.qeT != null) {
                return this.qeT.a(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.e(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.f(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            if (this.qeT != null) {
                this.qeT.b();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.g(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        try {
            if (this.qeT != null) {
                return this.qeT.a(i, j, str, str2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        try {
            if (this.qeT != null) {
                return this.qeT.a(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        try {
            if (this.qeT != null) {
                return this.qeT.b(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.h(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        try {
            if (this.qeT != null) {
                return this.qeT.c(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        try {
            if (this.qeT != null) {
                return this.qeT.d(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.i(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        try {
            if (this.qeT != null) {
                return this.qeT.j(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean c() {
        try {
            if (this.qeT != null) {
                return this.qeT.c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean d() {
        try {
            if (this.qeT != null) {
                return this.qeT.d();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.qeT != null) {
                this.qeT.b(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.qeT != null) {
                this.qeT.a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.qeT != null) {
                this.qeT.b(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
