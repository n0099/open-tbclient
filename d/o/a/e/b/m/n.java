package d.o.a.e.b.m;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.util.List;
/* loaded from: classes7.dex */
public class n implements d.o.a.e.b.g.m, d.o.a.e.b.g.n {

    /* renamed from: d  reason: collision with root package name */
    public static final String f71191d = "n";

    /* renamed from: a  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.h f71192a;

    /* renamed from: b  reason: collision with root package name */
    public d.o.a.e.b.g.o<IndependentProcessDownloadService> f71193b;

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.e.b.g.m f71194c = new o();

    /* loaded from: classes7.dex */
    public class a implements d.o.a.e.b.f.k {
        public a(n nVar) {
        }

        @Override // d.o.a.e.b.f.k
        public void a(int i2, int i3) {
            if (i3 != 1) {
                if (i3 == 2) {
                    d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).b(i2);
                    return;
                }
                return;
            }
            d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).v(i2);
            List<com.ss.android.socialbase.downloader.model.b> i4 = l.a(false).i(i2);
            if (i4 != null) {
                l.a(true).a(i2, d.o.a.e.b.l.e.p(i4));
            }
        }
    }

    public n() {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> K0 = d.o.a.e.b.g.d.K0();
        this.f71193b = K0;
        K0.d(this);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // d.o.a.e.b.g.m
    public boolean b(int i2) {
        if (this.f71192a == null) {
            return false;
        }
        try {
            return this.f71192a.b(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.c(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d(int i2) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.d(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public long e(int i2) {
        if (this.f71192a == null) {
            return 0L;
        }
        try {
            return this.f71192a.e(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // d.o.a.e.b.g.m
    public int f(int i2) {
        if (this.f71192a == null) {
            return 0;
        }
        try {
            return this.f71192a.f(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean g(int i2) {
        if (this.f71192a == null) {
            return false;
        }
        try {
            return this.f71192a.g(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo h(int i2) {
        if (this.f71192a == null) {
            return this.f71194c.h(i2);
        }
        try {
            return this.f71192a.h(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        if (this.f71192a == null) {
            return this.f71194c.i(i2);
        }
        try {
            return this.f71192a.i(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void j(int i2) {
        if (this.f71192a == null) {
            this.f71194c.j(i2);
            return;
        }
        try {
            this.f71192a.j(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void k(int i2) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f71193b;
        if (oVar != null) {
            oVar.a(i2);
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean l(int i2) {
        if (this.f71192a == null) {
            return false;
        }
        try {
            return this.f71192a.k(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public int m(int i2) {
        if (this.f71192a == null) {
            return d.o.a.e.b.g.e.c().m(i2);
        }
        try {
            return this.f71192a.m(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean n(int i2) {
        if (this.f71192a == null) {
            return this.f71194c.n(i2);
        }
        try {
            return this.f71192a.n(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void o(int i2) {
        if (this.f71192a == null) {
            this.f71194c.o(i2);
            return;
        }
        try {
            this.f71192a.o(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean p(int i2) {
        if (this.f71192a == null) {
            return this.f71194c.p(i2);
        }
        try {
            return this.f71192a.p(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.d q(int i2) {
        if (this.f71192a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.d(this.f71192a.q(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public d.o.a.e.b.f.i r(int i2) {
        if (this.f71192a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.f(this.f71192a.r(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public u s(int i2) {
        if (this.f71192a != null) {
            try {
                return com.ss.android.socialbase.downloader.i.f.w(this.f71192a.s(i2));
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, boolean z) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public DownloadInfo b(String str, String str2) {
        return h(a(str, str2));
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> c(String str) {
        if (this.f71192a == null) {
            return this.f71194c.c(str);
        }
        try {
            return this.f71192a.c(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a(i2, i3, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> e(String str) {
        if (this.f71192a != null) {
            try {
                return this.f71192a.d(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.g.m
    public void f(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.b(i2, i3, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void g(int i2, int i3, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a(i2, i3, com.ss.android.socialbase.downloader.i.f.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.SUB), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.n
    public void h() {
        this.f71192a = null;
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> b(String str) {
        if (this.f71192a == null) {
            return this.f71194c.b(str);
        }
        try {
            return this.f71192a.b(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a() {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> d(String str) {
        if (this.f71192a == null) {
            return this.f71194c.d(str);
        }
        try {
            return this.f71192a.e(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean e() {
        if (this.f71192a == null) {
            return this.f71194c.e();
        }
        try {
            return this.f71192a.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void f() {
        if (this.f71192a == null) {
            this.f71194c.f();
            return;
        }
        try {
            this.f71192a.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean g() {
        return this.f71192a != null;
    }

    @Override // d.o.a.e.b.g.m
    public boolean c() {
        return d.o.a.e.b.g.d.m();
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2, boolean z) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.d(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public List<DownloadInfo> a(String str) {
        if (this.f71192a == null) {
            return this.f71194c.a(str);
        }
        try {
            return this.f71192a.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(List<String> list) {
        if (this.f71192a == null) {
            this.f71194c.b(list);
            return;
        }
        try {
            this.f71192a.b(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void d() {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar = this.f71193b;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void e(d.o.a.e.b.f.k kVar) {
        if (this.f71192a != null) {
            try {
                this.f71192a.a(com.ss.android.socialbase.downloader.i.f.h(kVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f71192a == null) {
            return this.f71194c.c(downloadInfo);
        }
        try {
            return this.f71192a.b(downloadInfo);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public int a(String str, String str2) {
        return d.o.a.e.b.g.d.s(str, str2);
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i2, boolean z) {
        if (this.f71192a == null) {
            this.f71194c.b(i2, z);
            return;
        }
        try {
            this.f71192a.b(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(List<String> list) {
        if (this.f71192a == null) {
            this.f71194c.a(list);
            return;
        }
        try {
            this.f71192a.a(list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void c(int i2, d.o.a.e.b.f.d dVar) {
        if (this.f71192a != null) {
            try {
                this.f71192a.a(i2, com.ss.android.socialbase.downloader.i.f.c(dVar));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean b() {
        if (this.f71192a == null) {
            d.o.a.e.b.c.a.i(f71191d, "isServiceForeground, aidlService is null");
            return false;
        }
        d.o.a.e.b.c.a.h(f71191d, "aidlService.isServiceForeground");
        try {
            return this.f71192a.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public boolean a(DownloadInfo downloadInfo) {
        if (this.f71192a == null) {
            return this.f71194c.a(downloadInfo);
        }
        try {
            this.f71192a.a(downloadInfo);
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, Notification notification) {
        if (this.f71192a == null) {
            d.o.a.e.b.c.a.i(f71191d, "startForeground, aidlService is null");
            return;
        }
        String str = f71191d;
        d.o.a.e.b.c.a.h(str, "aidlService.startForeground, id = " + i2);
        try {
            this.f71192a.a(i2, notification);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void b(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f71193b) == null) {
            return;
        }
        oVar.a(aVar);
    }

    @Override // d.o.a.e.b.g.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f71192a == null) {
            this.f71194c.b(i2, list);
            return;
        }
        try {
            this.f71192a.a(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(boolean z, boolean z2) {
        if (this.f71192a == null) {
            d.o.a.e.b.c.a.i(f71191d, "stopForeground, aidlService is null");
            return;
        }
        d.o.a.e.b.c.a.h(f71191d, "aidlService.stopForeground");
        try {
            this.f71192a.a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(d.o.a.e.b.n.a aVar) {
        d.o.a.e.b.g.o<IndependentProcessDownloadService> oVar;
        if (aVar == null || (oVar = this.f71193b) == null) {
            return;
        }
        oVar.b(aVar);
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.b(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        if (this.f71192a == null) {
            this.f71194c.a(bVar);
            return;
        }
        try {
            this.f71192a.a(bVar);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, long j) {
        if (this.f71192a == null) {
            this.f71194c.a(i2, i3, j);
            return;
        }
        try {
            this.f71192a.a(i2, i3, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, int i4, long j) {
        if (this.f71192a == null) {
            this.f71194c.a(i2, i3, i4, j);
            return;
        }
        try {
            this.f71192a.a(i2, i3, i4, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3, int i4, int i5) {
        if (this.f71192a == null) {
            this.f71194c.a(i2, i3, i4, i5);
            return;
        }
        try {
            this.f71192a.a(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, int i3) {
        if (this.f71192a != null) {
            try {
                this.f71192a.a(i2, i3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.o.a.e.b.g.n
    public void a(IBinder iBinder) {
        this.f71192a = h.a.a(iBinder);
        if (d.o.a.e.b.l.e.D()) {
            e(new a(this));
        }
    }

    @Override // d.o.a.e.b.g.m
    public void a(int i2, long j) {
        if (this.f71192a == null) {
            return;
        }
        try {
            this.f71192a.a(i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
