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
/* loaded from: classes3.dex */
public class f implements ServiceConnection, t {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f62211b;

    /* renamed from: c  reason: collision with root package name */
    public static int f62212c;

    /* renamed from: d  reason: collision with root package name */
    public static long f62213d;
    @Nullable
    public c a;

    /* renamed from: g  reason: collision with root package name */
    public c.a.InterfaceC2199a f62216g;

    /* renamed from: i  reason: collision with root package name */
    public Future<?> f62218i;

    /* renamed from: e  reason: collision with root package name */
    public Handler f62214e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public b f62215f = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f62217h = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.f62211b || f.this.f62216g == null) {
                return;
            }
            f.this.f62216g.a();
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public CountDownLatch f62219j = new CountDownLatch(1);

    public f() {
        SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), this);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.ss.android.socialbase.downloader.b.f.2.run():void] */
    public static /* synthetic */ c.a.InterfaceC2199a a(f fVar) {
        return fVar.f62216g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: a */
    public ArrayList<i> n(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, i> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        try {
            if (this.a != null) {
                return this.a.i(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        try {
            if (this.a != null) {
                return this.a.j(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f62211b = true;
        this.f62214e.removeCallbacks(this.f62217h);
        try {
            this.a = c.a.a(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f62218i = com.ss.android.socialbase.downloader.downloader.c.l().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (f.this.f62215f != null && f.this.a != null) {
                            f.this.a.a(f.this.f62215f);
                        }
                        f.this.f62219j.countDown();
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.b.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.f62211b = false;
                                if (f.this.g() || f.this.f62216g == null) {
                                    return;
                                }
                                f.this.f62214e.postDelayed(f.this.f62217h, 2000L);
                            }
                        }, 0);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
        f62211b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (Build.VERSION.SDK_INT < 26 && !f62211b) {
            if (f62212c > 5) {
                com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f62213d < 15000) {
                com.ss.android.socialbase.downloader.c.a.d("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            f62212c++;
            f62213d = currentTimeMillis;
            this.f62214e.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SqlDownloadCacheService.a(com.ss.android.socialbase.downloader.downloader.c.N(), f.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2) {
        try {
            if (this.a != null) {
                return this.a.b(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
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
        } catch (RemoteException e2) {
            e2.printStackTrace();
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
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i2) {
        try {
            if (this.a != null) {
                return this.a.e(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        try {
            if (this.a != null) {
                return this.a.h(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(c.a.InterfaceC2199a interfaceC2199a) {
        this.f62216g = interfaceC2199a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        try {
            if (this.a != null) {
                return this.a.f(i2);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
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
                    z = !f.this.f62219j.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = f.this.f62218i) != null) {
                    future.cancel(true);
                }
                f.this.a();
                if (!z || (dVar2 = dVar) == null) {
                    return;
                }
                dVar2.a();
            }
        });
    }

    public void a(b bVar) {
        synchronized (this) {
            if (this.a != null) {
                try {
                    this.a.a(bVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f62215f = bVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        try {
            if (this.a != null) {
                return this.a.b(str);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        try {
            if (this.a != null) {
                return this.a.c(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i2) {
        try {
            if (this.a != null) {
                this.a.d(i2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        try {
            if (this.a != null) {
                return this.a.e();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        try {
            if (this.a != null) {
                return this.a.b();
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        try {
            if (this.a != null) {
                this.a.c();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        try {
            if (this.a != null) {
                return this.a.d(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.a();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.a != null) {
                this.a.b(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        try {
            if (this.a != null) {
                return this.a.c(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        try {
            if (this.a != null) {
                return this.a.d();
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        try {
            if (this.a != null) {
                return this.a.g(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
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
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        try {
            if (this.a != null) {
                return this.a.b(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        try {
            if (this.a != null) {
                this.a.a(bVar);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        try {
            if (this.a != null) {
                this.a.b(downloadInfo);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, long j2) {
        try {
            if (this.a != null) {
                this.a.a(i2, i3, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.a != null) {
                this.a.b(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, long j2) {
        try {
            if (this.a != null) {
                this.a.a(i2, i3, i4, j2);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        try {
            if (this.a != null) {
                this.a.a(i2, i3, i4, i5);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, int i3) {
        try {
            if (this.a != null) {
                return this.a.a(i2, i3);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        try {
            if (this.a != null) {
                return this.a.a(downloadInfo);
            }
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        try {
            if (this.a != null) {
                return this.a.a(i2, j2, str, str2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        try {
            if (this.a != null) {
                return this.a.a(i2, j2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            if (this.a != null) {
                this.a.a(i2, list);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
