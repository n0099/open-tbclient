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
    private static boolean f13098b;
    private static int c;
    private static long d = 0;
    private Future<?> arR;
    @Nullable
    private c pUo;
    private a pUq;
    private Handler e = new Handler(Looper.getMainLooper());
    private b pUp = null;
    private Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (!f.f13098b && f.this.pUq != null) {
                f.this.pUq.a();
            }
        }
    };
    private CountDownLatch pUr = new CountDownLatch(1);

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.c.f.2.run():void] */
    static /* synthetic */ a a(f fVar) {
        return fVar.pUq;
    }

    public f() {
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eEd(), this);
    }

    public void a(a aVar) {
        this.pUq = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f13098b = true;
        this.e.removeCallbacks(this.h);
        try {
            this.pUo = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.arR = com.ss.android.socialbase.downloader.downloader.b.eDL().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (f.this.pUp != null && f.this.pUo != null) {
                        f.this.pUo.a(f.this.pUp);
                    }
                    f.this.pUr.countDown();
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.c.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.f13098b = false;
                                if (!f.this.f() && f.this.pUq != null) {
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
        this.pUo = null;
        f13098b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        if (Build.VERSION.SDK_INT < 26 && !f13098b) {
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
                    SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.b.eEd(), f.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.g.b>> sparseArray2, final d dVar) {
        com.ss.android.socialbase.downloader.downloader.b.eDL().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.f.4
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
                    if (!f.this.pUr.await(5000L, TimeUnit.MILLISECONDS)) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (z && (future = f.this.arR) != null) {
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
            if (this.pUo != null) {
                try {
                    this.pUo.a(bVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.pUp = bVar;
            }
        }
    }

    public void a() {
        try {
            if (this.pUo != null) {
                this.pUo.a();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.b(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        try {
            if (this.pUo != null) {
                return this.pUo.a(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        try {
            if (this.pUo != null) {
                return this.pUo.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        try {
            if (this.pUo != null) {
                return this.pUo.c(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        try {
            if (this.pUo != null) {
                return this.pUo.d(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.g.b> c(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.c(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void d(int i) {
        try {
            if (this.pUo != null) {
                this.pUo.d(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.pUo != null) {
                this.pUo.a(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.b bVar) {
        try {
            if (this.pUo != null) {
                this.pUo.b(bVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, long j) {
        try {
            if (this.pUo != null) {
                this.pUo.a(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, long j) {
        try {
            if (this.pUo != null) {
                this.pUo.a(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, int i2, int i3, int i4) {
        try {
            if (this.pUo != null) {
                this.pUo.a(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, int i2) {
        try {
            if (this.pUo != null) {
                return this.pUo.a(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.pUo != null) {
                return this.pUo.a(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean e(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.e(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean f(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.f(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b() {
        try {
            if (this.pUo != null) {
                this.pUo.b();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c g(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.g(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j, String str, String str2) {
        try {
            if (this.pUo != null) {
                return this.pUo.a(i, j, str, str2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c a(int i, long j) {
        try {
            if (this.pUo != null) {
                return this.pUo.a(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c b(int i, long j) {
        try {
            if (this.pUo != null) {
                return this.pUo.b(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c h(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.h(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c c(int i, long j) {
        try {
            if (this.pUo != null) {
                return this.pUo.c(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c d(int i, long j) {
        try {
            if (this.pUo != null) {
                return this.pUo.d(i, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c i(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.i(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public com.ss.android.socialbase.downloader.g.c j(int i) {
        try {
            if (this.pUo != null) {
                return this.pUo.j(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean c() {
        try {
            if (this.pUo != null) {
                return this.pUo.c();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean d() {
        try {
            if (this.pUo != null) {
                return this.pUo.d();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(com.ss.android.socialbase.downloader.g.c cVar) {
        try {
            if (this.pUo != null) {
                this.pUo.b(cVar);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.pUo != null) {
                this.pUo.a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void b(int i, List<com.ss.android.socialbase.downloader.g.b> list) {
        try {
            if (this.pUo != null) {
                this.pUo.b(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
