package d.o.a.e.b.g;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f66985d;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<Boolean> f66986a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Handler f66987b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public volatile List<d.o.a.e.b.f.g> f66988c = new ArrayList();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f66989e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.n.a f66990f;

        public a(e eVar, m mVar, d.o.a.e.b.n.a aVar) {
            this.f66989e = mVar;
            this.f66990f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66989e.e(this.f66990f);
        }
    }

    public static e c() {
        if (f66985d == null) {
            synchronized (e.class) {
                f66985d = new e();
            }
        }
        return f66985d;
    }

    public List<DownloadInfo> A(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = d.o.a.e.b.m.l.a(false);
        List<DownloadInfo> e2 = a2 != null ? a2.e(str) : null;
        m a3 = d.o.a.e.b.m.l.a(true);
        return e(e2, a3 != null ? a3.e(str) : null, sparseArray);
    }

    public boolean B(int i) {
        m t = t(i);
        if (t == null) {
            return false;
        }
        return t.b(i);
    }

    public void C(int i) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.c(i);
    }

    public void D(int i) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.d(i);
    }

    public int E(int i) {
        m t = t(i);
        if (t == null) {
            return 0;
        }
        return t.f(i);
    }

    public boolean F(int i) {
        m t = t(i);
        if (t == null) {
            return false;
        }
        return t.g(i);
    }

    public DownloadInfo G(int i) {
        m t = t(i);
        if (t == null) {
            return null;
        }
        return t.h(i);
    }

    public d.o.a.e.b.f.d H(int i) {
        m t = t(i);
        if (t == null) {
            return null;
        }
        return t.q(i);
    }

    public d.o.a.e.b.f.i I(int i) {
        m t = t(i);
        if (t == null) {
            return null;
        }
        return t.r(i);
    }

    public boolean J(int i) {
        m t = t(i);
        if (t == null) {
            return false;
        }
        return t.l(i);
    }

    public void K(int i) {
        if (i == 0) {
            return;
        }
        r(i, true);
        m a2 = d.o.a.e.b.m.l.a(true);
        if (a2 == null) {
            return;
        }
        a2.d();
    }

    public u L(int i) {
        m t = t(i);
        if (t == null) {
            return null;
        }
        return t.s(i);
    }

    public int a(int i) {
        if (!d.o.a.e.b.l.e.n0() && d.o.a.e.b.m.l.a(true).g()) {
            return d.o.a.e.b.m.l.a(true).m(i);
        }
        return m(i);
    }

    public int b(String str, String str2) {
        return d.s(str, str2);
    }

    public List<DownloadInfo> d(String str) {
        List<DownloadInfo> a2 = d.o.a.e.b.m.l.a(false).a(str);
        List<DownloadInfo> a3 = d.o.a.e.b.m.l.a(true).a(str);
        if (a2 == null && a3 == null) {
            return null;
        }
        if (a2 == null || a3 == null) {
            return a2 != null ? a2 : a3;
        }
        ArrayList arrayList = new ArrayList(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    public final List<DownloadInfo> e(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.c0()) == null) {
                    sparseArray.put(downloadInfo.c0(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.c0()) == null) {
                    sparseArray.put(downloadInfo2.c0(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public void f(int i, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.g(i, bVar == null ? 0 : bVar.hashCode(), bVar, gVar, z);
    }

    public void g(int i, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.c(i, bVar.hashCode(), bVar, gVar, z, z2);
    }

    public void h(int i, boolean z) {
        r(i, z);
        if (!d.o.a.e.b.l.e.n0() && d.o.a.e.b.m.l.a(true).g()) {
            d.o.a.e.b.m.l.a(true).c(i, z);
        }
        if (d.i0() || d.o.a.e.b.l.e.n0() || d.o.a.e.b.l.e.D()) {
            return;
        }
        try {
            Intent intent = new Intent(d.l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            d.l().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void i(d.o.a.e.b.f.o oVar) {
        d.F(oVar);
    }

    public void j(d.o.a.e.b.n.a aVar) {
        m n = n(aVar);
        if (n == null) {
            if (aVar != null) {
                d.o.a.e.b.e.a.e(aVar.O(), aVar.H(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), aVar.H() != null ? aVar.H().H0() : 0);
            }
        } else if (aVar.W()) {
            this.f66987b.postDelayed(new a(this, n, aVar), 500L);
        } else {
            n.e(aVar);
        }
    }

    public void k(List<String> list) {
        m a2 = d.o.a.e.b.m.l.a(false);
        if (a2 != null) {
            a2.a(list);
        }
        m a3 = d.o.a.e.b.m.l.a(true);
        if (a3 != null) {
            a3.a(list);
        }
    }

    public boolean l(DownloadInfo downloadInfo) {
        m t;
        if (downloadInfo == null || (t = t(downloadInfo.c0())) == null) {
            return false;
        }
        return t.a(downloadInfo);
    }

    public synchronized int m(int i) {
        if (this.f66986a.get(i) == null) {
            return -1;
        }
        return this.f66986a.get(i).booleanValue() ? 1 : 0;
    }

    public final m n(d.o.a.e.b.n.a aVar) {
        DownloadInfo H;
        List<com.ss.android.socialbase.downloader.model.b> i;
        if (aVar == null || (H = aVar.H()) == null) {
            return null;
        }
        H.C1();
        boolean z = (d.o.a.e.b.l.e.n0() || !d.o.a.e.b.l.e.D()) ? true : true;
        int a2 = a(H.c0());
        if (a2 >= 0 && a2 != z) {
            try {
                if (a2 == 1) {
                    if (d.o.a.e.b.l.e.D()) {
                        d.o.a.e.b.m.l.a(true).a(H.c0());
                        DownloadInfo h2 = d.o.a.e.b.m.l.a(true).h(H.c0());
                        if (h2 != null) {
                            d.o.a.e.b.m.l.a(false).b(h2);
                        }
                        if (h2.B() > 1 && (i = d.o.a.e.b.m.l.a(true).i(H.c0())) != null) {
                            d.o.a.e.b.m.l.a(false).a(H.c0(), d.o.a.e.b.l.e.p(i));
                        }
                    }
                } else if (d.o.a.e.b.l.e.D()) {
                    d.o.a.e.b.m.l.a(false).a(H.c0());
                    List<com.ss.android.socialbase.downloader.model.b> i2 = d.o.a.e.b.m.l.a(false).i(H.c0());
                    if (i2 != null) {
                        d.o.a.e.b.m.l.a(true).a(H.c0(), d.o.a.e.b.l.e.p(i2));
                    }
                } else {
                    aVar.D0(true);
                    d.o.a.e.b.m.l.a(true).a(1, H.c0());
                }
            } catch (Throwable unused) {
            }
        }
        h(H.c0(), z);
        return d.o.a.e.b.m.l.a(z);
    }

    public DownloadInfo o(String str, String str2) {
        int b2 = b(str, str2);
        m t = t(b2);
        if (t == null) {
            return null;
        }
        return t.h(b2);
    }

    public void p() {
        synchronized (this.f66988c) {
            for (d.o.a.e.b.f.g gVar : this.f66988c) {
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
    }

    public void q(int i, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.f(i, bVar.hashCode(), bVar, gVar, z);
    }

    public synchronized void r(int i, boolean z) {
        this.f66986a.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public void s(List<String> list) {
        m a2 = d.o.a.e.b.m.l.a(false);
        if (a2 != null) {
            a2.b(list);
        }
        m a3 = d.o.a.e.b.m.l.a(true);
        if (a3 != null) {
            a3.b(list);
        }
    }

    public m t(int i) {
        boolean z = true;
        return d.o.a.e.b.m.l.a((a(i) != 1 || d.o.a.e.b.l.e.n0()) ? false : false);
    }

    public List<DownloadInfo> u(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = d.o.a.e.b.m.l.a(false);
        List<DownloadInfo> c2 = a2 != null ? a2.c(str) : null;
        m a3 = d.o.a.e.b.m.l.a(true);
        return e(c2, a3 != null ? a3.c(str) : null, sparseArray);
    }

    public void v() {
        m a2 = d.o.a.e.b.m.l.a(false);
        if (a2 != null) {
            a2.a();
        }
        m a3 = d.o.a.e.b.m.l.a(true);
        if (a3 != null) {
            a3.a();
        }
    }

    public void w(int i, boolean z) {
        if (d.o.a.e.b.l.e.D()) {
            if (d.o.a.e.b.l.a.a(8388608)) {
                m a2 = d.o.a.e.b.m.l.a(true);
                if (a2 != null) {
                    a2.a(i, z);
                }
                m a3 = d.o.a.e.b.m.l.a(false);
                if (a3 != null) {
                    a3.a(i, z);
                    return;
                }
                return;
            }
            m a4 = d.o.a.e.b.m.l.a(false);
            if (a4 != null) {
                a4.a(i, z);
            }
            m a5 = d.o.a.e.b.m.l.a(true);
            if (a5 != null) {
                a5.a(i, z);
                return;
            }
            return;
        }
        m t = t(i);
        if (t != null) {
            t.a(i, z);
        }
        d.o.a.e.b.m.l.a(true).a(2, i);
    }

    public List<DownloadInfo> x(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        m a2 = d.o.a.e.b.m.l.a(false);
        List<DownloadInfo> d2 = a2 != null ? a2.d(str) : null;
        m a3 = d.o.a.e.b.m.l.a(true);
        return e(d2, a3 != null ? a3.d(str) : null, sparseArray);
    }

    public void y(int i) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.a(i);
    }

    public void z(int i, boolean z) {
        m t = t(i);
        if (t == null) {
            return;
        }
        t.b(i, z);
    }
}
