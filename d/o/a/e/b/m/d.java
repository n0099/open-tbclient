package d.o.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.adp.plugin.PluginCenter;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.g.s;
import d.o.a.e.b.k.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d implements d.o.a.e.b.g.j {

    /* renamed from: f  reason: collision with root package name */
    public s f71275f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f71276g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f71277h;
    public d.o.a.e.b.k.g j;

    /* renamed from: i  reason: collision with root package name */
    public g.a f71278i = new a();

    /* renamed from: e  reason: collision with root package name */
    public final k f71274e = new k();

    /* loaded from: classes7.dex */
    public class a implements g.a {

        /* renamed from: d.o.a.e.b.m.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1954a implements Runnable {
            public RunnableC1954a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.l();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // d.o.a.e.b.k.g.a
        public void a(Message message) {
            if (message.what == 1) {
                d.o.a.e.b.g.d.w0().execute(new RunnableC1954a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.d {
        public b() {
        }

        @Override // com.ss.android.socialbase.downloader.b.f.d
        public void a() {
            d.this.f71275f = new com.ss.android.socialbase.downloader.b.e();
            Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.o.a.e.b.b.b {
        public c() {
        }

        @Override // d.o.a.e.b.b.b
        public void a() {
            d.this.m();
            d.this.k();
            d.o.a.e.b.g.d.z(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
        }
    }

    public d() {
        this.j = null;
        if (d.o.a.e.b.j.a.r().l("fix_sigbus_downloader_db")) {
            if (d.o.a.e.b.l.e.D()) {
                this.f71275f = new com.ss.android.socialbase.downloader.b.e();
            } else {
                com.ss.android.socialbase.downloader.b.f fVar = new com.ss.android.socialbase.downloader.b.f();
                fVar.n(new b());
                this.f71275f = fVar;
            }
        } else {
            this.f71275f = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f71276g = false;
        this.j = new d.o.a.e.b.k.g(Looper.getMainLooper(), this.f71278i);
        j();
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2) {
        return this.f71274e.b(i2);
    }

    @Override // d.o.a.e.b.g.j
    public boolean c() {
        return this.f71276g;
    }

    @Override // d.o.a.e.b.g.j
    public boolean d() {
        if (this.f71276g) {
            return true;
        }
        synchronized (this) {
            if (!this.f71276g) {
                d.o.a.e.b.c.a.i("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                d.o.a.e.b.c.a.i("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f71276g;
    }

    public k e() {
        return this.f71274e;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo g(int i2) {
        DownloadInfo g2 = this.f71274e.g(i2);
        h(g2);
        return g2;
    }

    public final void h(DownloadInfo downloadInfo) {
        g(downloadInfo, true);
    }

    public s i() {
        return this.f71275f;
    }

    public void j() {
        d.o.a.e.b.g.d.z(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        this.f71275f.a(this.f71274e.a(), this.f71274e.e(), new c());
    }

    public void k() {
        long j;
        if (d.o.a.e.b.j.a.r().l("task_resume_delay")) {
            j = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        } else {
            j = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.j.sendMessageDelayed(this.j.obtainMessage(1), j);
    }

    public void l() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        if (this.f71276g) {
            if (this.f71277h) {
                d.o.a.e.b.c.a.g("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f71277h = true;
            if (d.o.a.e.b.l.e.D()) {
                d.o.a.e.b.g.l H0 = d.o.a.e.b.g.d.H0();
                if (H0 != null) {
                    list = H0.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray<DownloadInfo> a2 = this.f71274e.a();
                if (a2 == null) {
                    return;
                }
                synchronized (a2) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        int keyAt = a2.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo = a2.get(keyAt)) != null) {
                            int z0 = downloadInfo.z0();
                            int I0 = downloadInfo.I0();
                            if (I0 >= 1 && I0 <= 11) {
                                d.o.a.e.b.e.a.d(d.o.a.e.b.g.d.p0(), downloadInfo, null, -5);
                            }
                            if (list != null && arrayList != null && downloadInfo.m0() != null && list.contains(downloadInfo.m0()) && (d.o.a.e.b.j.a.d(downloadInfo.c0()).m("enable_notification_ui") >= 2 || z0 != -2 || downloadInfo.L1())) {
                                downloadInfo.p2(false);
                                arrayList.add(downloadInfo);
                            }
                        }
                    }
                }
                if (H0 == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                H0.a(arrayList, 1);
            }
        }
    }

    public final void m() {
        synchronized (this) {
            this.f71276g = true;
            notifyAll();
        }
    }

    @Override // d.o.a.e.b.g.j
    public List<d.o.a.e.b.i.i> n(int i2) {
        List<d.o.a.e.b.i.i> n = this.f71274e.n(i2);
        return (n == null || n.size() == 0) ? this.f71275f.n(i2) : n;
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> a(String str) {
        return this.f71274e.a(str);
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> b(String str) {
        return this.f71274e.b(str);
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> c(String str) {
        return this.f71274e.c(str);
    }

    @Override // d.o.a.e.b.g.j
    public boolean e(int i2) {
        try {
            if (d.o.a.e.b.l.e.b0()) {
                d.o.a.e.b.g.m a2 = l.a(true);
                if (a2 != null) {
                    a2.n(i2);
                } else {
                    this.f71275f.e(i2);
                }
            } else {
                this.f71275f.e(i2);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.f71274e.e(i2);
    }

    @Override // d.o.a.e.b.g.j
    public boolean f(int i2) {
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.p(i2);
            } else {
                this.f71275f.f(i2);
            }
        } else {
            this.f71275f.f(i2);
        }
        return this.f71274e.f(i2);
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo h(int i2) {
        DownloadInfo h2 = this.f71274e.h(i2);
        h(h2);
        return h2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo i(int i2) {
        DownloadInfo i3 = this.f71274e.i(i2);
        h(i3);
        return i3;
    }

    @Override // d.o.a.e.b.g.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        this.f71274e.a(bVar);
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.a(bVar);
                return;
            } else {
                this.f71275f.a(bVar);
                return;
            }
        }
        this.f71275f.a(bVar);
    }

    @Override // d.o.a.e.b.g.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.a(bVar);
                return;
            } else {
                this.f71275f.a(bVar);
                return;
            }
        }
        this.f71275f.a(bVar);
    }

    @Override // d.o.a.e.b.g.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.f71274e.c(i2);
    }

    public final void g(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!d.o.a.e.b.l.e.b0()) {
            this.f71275f.a(downloadInfo);
        } else if (z) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.c(downloadInfo);
            } else {
                this.f71275f.a(downloadInfo);
            }
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo j(int i2) {
        DownloadInfo j = this.f71274e.j(i2);
        h(j);
        return j;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo c(int i2, long j) {
        DownloadInfo c2 = this.f71274e.c(i2, j);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return c2;
    }

    @Override // d.o.a.e.b.g.j
    public void m(int i2) {
        this.f71274e.m(i2);
        this.f71275f.m(i2);
    }

    @Override // d.o.a.e.b.g.j
    public void b() {
        try {
            this.f71274e.b();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.f();
                return;
            } else {
                this.f71275f.b();
                return;
            }
        }
        this.f71275f.b();
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, long j) {
        this.f71274e.a(i2, i3, j);
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.a(i2, i3, j);
                return;
            } else {
                this.f71275f.a(i2, i3, j);
                return;
            }
        }
        this.f71275f.a(i2, i3, j);
    }

    @Override // d.o.a.e.b.g.j
    public List<DownloadInfo> d(String str) {
        return this.f71274e.d(str);
    }

    @Override // d.o.a.e.b.g.j
    public void d(int i2) {
        this.f71274e.d(i2);
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.o(i2);
                return;
            } else {
                this.f71275f.d(i2);
                return;
            }
        }
        this.f71275f.d(i2);
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, long j) {
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.a(i2, i3, i4, j);
                return;
            } else {
                this.f71275f.a(i2, i3, i4, j);
                return;
            }
        }
        this.f71275f.a(i2, i3, i4, j);
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo b(int i2, long j) {
        DownloadInfo b2 = this.f71274e.b(i2, j);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return b2;
    }

    @Override // d.o.a.e.b.g.j
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f71274e.a(downloadInfo);
    }

    @Override // d.o.a.e.b.g.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            a(this.f71274e.b(i2));
            if (list == null) {
                list = this.f71274e.c(i2);
            }
            if (d.o.a.e.b.l.e.b0()) {
                d.o.a.e.b.g.m a2 = l.a(true);
                if (a2 != null) {
                    a2.b(i2, list);
                    return;
                } else {
                    this.f71275f.b(i2, list);
                    return;
                }
            }
            this.f71275f.b(i2, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo d(int i2, long j) {
        DownloadInfo d2 = this.f71274e.d(i2, j);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return d2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, int i3, int i4, int i5) {
        if (d.o.a.e.b.l.e.b0()) {
            d.o.a.e.b.g.m a2 = l.a(true);
            if (a2 != null) {
                a2.a(i2, i3, i4, i5);
                return;
            } else {
                this.f71275f.a(i2, i3, i4, i5);
                return;
            }
        }
        this.f71275f.a(i2, i3, i4, i5);
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, int i3) {
        DownloadInfo a2 = this.f71274e.a(i2, i3);
        h(a2);
        return a2;
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a2 = this.f71274e.a(downloadInfo);
        h(downloadInfo);
        return a2;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j, String str, String str2) {
        DownloadInfo a2 = this.f71274e.a(i2, j, str, str2);
        h(a2);
        return a2;
    }

    @Override // d.o.a.e.b.g.j
    public Map<Long, d.o.a.e.b.i.i> l(int i2) {
        Map<Long, d.o.a.e.b.i.i> l = this.f71274e.l(i2);
        if (l == null || l.isEmpty()) {
            Map<Long, d.o.a.e.b.i.i> l2 = this.f71275f.l(i2);
            this.f71274e.a(i2, l2);
            return l2;
        }
        return l;
    }

    @Override // d.o.a.e.b.g.j
    public DownloadInfo a(int i2, long j) {
        DownloadInfo a2 = this.f71274e.a(i2, j);
        g(a2, false);
        return a2;
    }

    @Override // d.o.a.e.b.g.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f71274e.a(i2, list);
        if (d.o.a.e.b.l.e.n0()) {
            this.f71275f.b(i2, list);
        }
    }

    @Override // d.o.a.e.b.g.j
    public boolean a(int i2, Map<Long, d.o.a.e.b.i.i> map) {
        this.f71274e.a(i2, map);
        this.f71275f.a(i2, map);
        return false;
    }
}
