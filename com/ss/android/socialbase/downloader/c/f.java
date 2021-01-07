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
/* loaded from: classes4.dex */
public class f implements ServiceConnection, t {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13398b;
    private static int c;
    private static long d = 0;
    private Future<?> awD;
    @Nullable
    private c pYO;
    private a pYQ;
    private Handler e = new Handler(Looper.getMainLooper());
    private b pYP = null;
    private Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (!f.f13398b && f.this.pYQ != null) {
                f.this.pYQ.a();
            }
        }
    };
    private CountDownLatch pYR = new CountDownLatch(1);

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.c.f.2.run():void] */
    static /* synthetic */ a a(f fVar) {
        return fVar.pYQ;
    }

    public f() {
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eHT(), this);
    }

    public void a(a aVar) {
        this.pYQ = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f13398b = true;
        this.e.removeCallbacks(this.h);
        try {
            this.pYO = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.awD = com.ss.android.socialbase.downloader.downloader.b.eHB().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (f.this.pYP != null && f.this.pYO != null) {
                        f.this.pYO.a(f.this.pYP);
                    }
                    f.this.pYR.countDown();
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.c.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.f13398b = false;
                                if (!f.this.f() && f.this.pYQ != null) {
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
        this.pYO = null;
        f13398b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (Build.VERSION.SDK_INT < 26 && !f13398b) {
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
                    SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eHT(), f.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray2, final d dVar) {
        com.ss.android.socialbase.downloader.downloader.b.eHB().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.4
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
                    if (!f.this.pYR.await(5000L, TimeUnit.MILLISECONDS)) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (z && (future = f.this.awD) != null) {
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
            if (this.pYO != null) {
                try {
                    this.pYO.a(bVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.pYP = bVar;
            }
        }
    }

    public void a() {
        try {
            if (this.pYO != null) {
                this.pYO.a();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.b(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        try {
            if (this.pYO != null) {
                return this.pYO.a(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        try {
            if (this.pYO != null) {
                return this.pYO.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        try {
            if (this.pYO != null) {
                return this.pYO.c(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        try {
            if (this.pYO != null) {
                return this.pYO.d(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.c(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        try {
            if (this.pYO != null) {
                this.pYO.d(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.pYO != null) {
                this.pYO.a(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.pYO != null) {
                this.pYO.b(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        try {
            if (this.pYO != null) {
                this.pYO.a(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        try {
            if (this.pYO != null) {
                this.pYO.a(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        try {
            if (this.pYO != null) {
                this.pYO.a(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        try {
            if (this.pYO != null) {
                return this.pYO.a(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.pYO != null) {
                return this.pYO.a(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.e(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.f(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            if (this.pYO != null) {
                this.pYO.b();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.g(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        try {
            if (this.pYO != null) {
                return this.pYO.a(i, j, str, str2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        try {
            if (this.pYO != null) {
                return this.pYO.a(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        try {
            if (this.pYO != null) {
                return this.pYO.b(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.h(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        try {
            if (this.pYO != null) {
                return this.pYO.c(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        try {
            if (this.pYO != null) {
                return this.pYO.d(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.i(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        try {
            if (this.pYO != null) {
                return this.pYO.j(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean c() {
        try {
            if (this.pYO != null) {
                return this.pYO.c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean d() {
        try {
            if (this.pYO != null) {
                return this.pYO.d();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.pYO != null) {
                this.pYO.b(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.pYO != null) {
                this.pYO.a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.pYO != null) {
                this.pYO.b(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
