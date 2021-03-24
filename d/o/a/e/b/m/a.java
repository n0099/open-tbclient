package d.o.a.e.b.m;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import d.o.a.e.b.f.y;
import d.o.a.e.b.k.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes7.dex */
public abstract class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f67117a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f67118b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f67119c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f67120d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.n.a> f67121e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.g<Integer, d.o.a.e.b.n.a> f67122f = new com.ss.android.socialbase.downloader.i.g<>();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<Long> f67123g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public final LinkedBlockingDeque<d.o.a.e.b.n.a> f67124h = new LinkedBlockingDeque<>();
    public final d.o.a.e.b.k.g j = new d.o.a.e.b.k.g(Looper.getMainLooper(), this);
    public final d.o.a.e.b.g.j i = d.o.a.e.b.g.d.I0();

    /* renamed from: d.o.a.e.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1847a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f67125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SparseArray f67127g;

        public RunnableC1847a(a aVar, SparseArray sparseArray, DownloadInfo downloadInfo, SparseArray sparseArray2) {
            this.f67125e = sparseArray;
            this.f67126f = downloadInfo;
            this.f67127g = sparseArray2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SparseArray sparseArray;
            SparseArray sparseArray2 = this.f67125e;
            if (sparseArray2 != null) {
                synchronized (sparseArray2) {
                    for (int i = 0; i < this.f67125e.size(); i++) {
                        d.o.a.e.b.f.b bVar = (d.o.a.e.b.f.b) this.f67125e.get(this.f67125e.keyAt(i));
                        if (bVar != null) {
                            bVar.k(this.f67126f);
                        }
                    }
                }
            }
            DownloadInfo downloadInfo = this.f67126f;
            if (downloadInfo == null || !downloadInfo.e() || (sparseArray = this.f67127g) == null) {
                return;
            }
            synchronized (sparseArray) {
                for (int i2 = 0; i2 < this.f67127g.size(); i2++) {
                    d.o.a.e.b.f.b bVar2 = (d.o.a.e.b.f.b) this.f67127g.get(this.f67127g.keyAt(i2));
                    if (bVar2 != null) {
                        bVar2.k(this.f67126f);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67128e;

        public b(a aVar, int i) {
            this.f67128e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.b.p.b.a().m(this.f67128e);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f67130f;

        public c(int i, boolean z) {
            this.f67129e = i;
            this.f67130f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B(this.f67129e);
            a.this.E(this.f67129e, this.f67130f);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67132e;

        public d(a aVar, int i) {
            this.f67132e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.b.p.b.a().m(this.f67132e);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f67134f;

        public e(int i, boolean z) {
            this.f67133e = i;
            this.f67134f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B(this.f67133e);
            a.this.F(this.f67133e, this.f67134f);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.e.b.f.b f67136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67137f;

        public f(a aVar, d.o.a.e.b.f.b bVar, DownloadInfo downloadInfo) {
            this.f67136e = bVar;
            this.f67137f = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f67136e != null) {
                if (this.f67137f.H0() == -3) {
                    this.f67136e.b(this.f67137f);
                } else if (this.f67137f.H0() == -1) {
                    this.f67136e.e(this.f67137f, new BaseException(1000, "try add listener for failed task"));
                }
            }
        }
    }

    public final boolean A(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.k3()) {
            return downloadInfo.L1();
        }
        return false;
    }

    public abstract d.o.a.e.b.k.c B(int i);

    public void C(int i, boolean z) {
        DownloadInfo b2 = this.i.b(i);
        if (b2 != null) {
            l(b2);
        }
        this.j.post(new d(this, i));
        d.o.a.e.b.g.d.R(new e(i, z), true);
    }

    public DownloadInfo D(int i) {
        DownloadInfo b2 = this.i.b(i);
        if (b2 == null) {
            synchronized (this.f67117a) {
                d.o.a.e.b.n.a aVar = this.f67117a.get(i);
                if (aVar != null) {
                    b2 = aVar.H();
                }
            }
        }
        return b2;
    }

    public final synchronized void E(int i, boolean z) {
        d.o.a.e.b.c.a.g("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        DownloadInfo b2 = this.i.b(i);
        if (b2 != null) {
            if (z) {
                d.o.a.e.b.l.e.u(b2);
            } else {
                d.o.a.e.b.l.e.m0(b2.N0(), b2.M0());
            }
            b2.q();
        }
        try {
            this.i.f(i);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        c(i, -4);
        if (this.f67119c.get(i) != null) {
            this.f67119c.remove(i);
        }
        if (this.f67118b.get(i) != null) {
            this.f67118b.remove(i);
        }
        synchronized (this.f67122f) {
            this.f67122f.remove(Integer.valueOf(i));
        }
        d.o.a.e.b.j.a.p(i);
    }

    public final void F(int i, boolean z) {
        try {
            DownloadInfo b2 = this.i.b(i);
            if (b2 != null) {
                d.o.a.e.b.l.e.y(b2, z);
                b2.q();
            }
            try {
                this.i.d(i);
                this.i.a(b2);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.f67119c.get(i) != null) {
                this.f67119c.remove(i);
            }
            if (this.f67118b.get(i) != null) {
                this.f67118b.remove(i);
            }
            synchronized (this.f67122f) {
                this.f67122f.remove(Integer.valueOf(i));
            }
            d.o.a.e.b.j.a.p(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean G(int i) {
        d.o.a.e.b.c.a.g("AbsDownloadEngine", "pause id=" + i);
        DownloadInfo b2 = this.i.b(i);
        if (b2 == null || b2.H0() != 11) {
            synchronized (this.f67117a) {
                t(i);
            }
            if (b2 == null) {
                synchronized (this.f67117a) {
                    d.o.a.e.b.n.a aVar = this.f67117a.get(i);
                    if (aVar != null) {
                        new d.o.a.e.b.g.g(aVar, this.j).u();
                        return true;
                    }
                }
            } else {
                l(b2);
                if (b2.H0() == 1) {
                    synchronized (this.f67117a) {
                        d.o.a.e.b.n.a aVar2 = this.f67117a.get(i);
                        if (aVar2 != null) {
                            new d.o.a.e.b.g.g(aVar2, this.j).u();
                            return true;
                        }
                    }
                } else if (d.o.a.e.b.d.a.b(b2.H0())) {
                    b2.a3(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized boolean H(int i) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar != null) {
            DownloadInfo H = aVar.H();
            if (H != null) {
                H.p2(false);
            }
            m(aVar);
        } else {
            I(i);
        }
        return true;
    }

    public synchronized boolean I(int i) {
        d.o.a.e.b.n.a aVar = this.f67119c.get(i);
        if (aVar == null) {
            aVar = this.f67120d.get(i);
        }
        if (aVar != null) {
            DownloadInfo H = aVar.H();
            if (H != null) {
                H.p2(false);
            }
            m(aVar);
            return true;
        }
        return false;
    }

    public synchronized d.o.a.e.b.f.i J(int i) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar != null) {
            return aVar.P();
        }
        d.o.a.e.b.n.a aVar2 = this.f67118b.get(i);
        if (aVar2 != null) {
            return aVar2.P();
        }
        d.o.a.e.b.n.a aVar3 = this.f67119c.get(i);
        if (aVar3 != null) {
            return aVar3.P();
        }
        d.o.a.e.b.n.a aVar4 = this.f67120d.get(i);
        if (aVar4 != null) {
            return aVar4.P();
        }
        d.o.a.e.b.n.a aVar5 = this.f67121e.get(i);
        if (aVar5 != null) {
            return aVar5.P();
        }
        return null;
    }

    public synchronized d.o.a.e.b.f.d K(int i) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar != null) {
            return aVar.Q();
        }
        d.o.a.e.b.n.a aVar2 = this.f67118b.get(i);
        if (aVar2 != null) {
            return aVar2.Q();
        }
        d.o.a.e.b.n.a aVar3 = this.f67119c.get(i);
        if (aVar3 != null) {
            return aVar3.Q();
        }
        d.o.a.e.b.n.a aVar4 = this.f67120d.get(i);
        if (aVar4 != null) {
            return aVar4.Q();
        }
        d.o.a.e.b.n.a aVar5 = this.f67121e.get(i);
        if (aVar5 != null) {
            return aVar5.Q();
        }
        return null;
    }

    public synchronized u L(int i) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar != null) {
            return aVar.L();
        }
        d.o.a.e.b.n.a aVar2 = this.f67118b.get(i);
        if (aVar2 != null) {
            return aVar2.L();
        }
        d.o.a.e.b.n.a aVar3 = this.f67119c.get(i);
        if (aVar3 != null) {
            return aVar3.L();
        }
        d.o.a.e.b.n.a aVar4 = this.f67120d.get(i);
        if (aVar4 != null) {
            return aVar4.L();
        }
        d.o.a.e.b.n.a aVar5 = this.f67121e.get(i);
        if (aVar5 != null) {
            return aVar5.L();
        }
        return null;
    }

    public synchronized boolean M(int i) {
        DownloadInfo H;
        d.o.a.e.b.n.a aVar = this.f67120d.get(i);
        if (aVar != null && (H = aVar.H()) != null) {
            if (H.g()) {
                n(aVar, false);
            }
            return true;
        }
        DownloadInfo b2 = this.i.b(i);
        if (b2 != null && b2.g()) {
            n(new d.o.a.e.b.n.a(b2), false);
        }
        return false;
    }

    public synchronized boolean N(int i) {
        DownloadInfo H;
        d.o.a.e.b.n.a aVar = this.f67121e.get(i);
        if (aVar == null || (H = aVar.H()) == null) {
            return false;
        }
        if (H.c()) {
            m(aVar);
        }
        return true;
    }

    public synchronized void O(int i) {
        DownloadInfo H;
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar != null && (H = aVar.H()) != null) {
            H.y2(true);
            m(aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.f67119c.get(r2) != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean P(int i) {
        boolean z;
        if (i != 0) {
            if (this.f67117a.get(i) == null) {
            }
            z = true;
        }
        z = false;
        return z;
    }

    public final d.o.a.e.b.n.a Q(int i) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar == null) {
            d.o.a.e.b.n.a aVar2 = this.f67119c.get(i);
            if (aVar2 == null) {
                d.o.a.e.b.n.a aVar3 = this.f67118b.get(i);
                if (aVar3 == null) {
                    d.o.a.e.b.n.a aVar4 = this.f67120d.get(i);
                    return aVar4 == null ? this.f67121e.get(i) : aVar4;
                }
                return aVar3;
            }
            return aVar2;
        }
        return aVar;
    }

    public final void R(int i) {
        if (this.f67124h.isEmpty()) {
            return;
        }
        synchronized (this.f67124h) {
            d.o.a.e.b.n.a first = this.f67124h.getFirst();
            if (first != null && first.G() == i) {
                this.f67124h.poll();
            }
            if (this.f67124h.isEmpty()) {
                return;
            }
            d.o.a.e.b.n.a first2 = this.f67124h.getFirst();
            if (first2 != null) {
                n(first2, true);
            }
        }
    }

    public abstract List<Integer> a();

    @Override // d.o.a.e.b.k.g.a
    public void a(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (a.class) {
            d.o.a.e.b.n.a aVar = this.f67117a.get(i);
            if (aVar == null) {
                return;
            }
            h(message.what, baseException, aVar);
            c(i, message.what);
        }
    }

    public List<DownloadInfo> b(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a2 = this.i.a(str);
        if (a2 == null || a2.isEmpty()) {
            synchronized (this.f67117a) {
                arrayList = new ArrayList();
                int size = this.f67117a.size();
                for (int i = 0; i < size; i++) {
                    d.o.a.e.b.n.a valueAt = this.f67117a.valueAt(i);
                    if (valueAt != null && valueAt.H() != null && str.equals(valueAt.H().T0())) {
                        arrayList.add(valueAt.H());
                    }
                }
            }
            return arrayList;
        }
        return a2;
    }

    public synchronized void c(int i, int i2) {
        if (i2 != -7) {
            if (i2 == -6) {
                this.f67118b.put(i, this.f67117a.get(i));
                this.f67117a.remove(i);
            } else if (i2 == -4) {
                this.f67117a.remove(i);
                R(i);
            } else if (i2 == -3) {
                this.f67118b.put(i, this.f67117a.get(i));
                this.f67117a.remove(i);
                R(i);
            } else if (i2 != -1) {
                if (i2 == 7) {
                    d.o.a.e.b.n.a aVar = this.f67117a.get(i);
                    if (aVar != null) {
                        if (this.f67120d.get(i) == null) {
                            this.f67120d.put(i, aVar);
                        }
                        this.f67117a.remove(i);
                    }
                    R(i);
                } else if (i2 == 8) {
                    d.o.a.e.b.n.a aVar2 = this.f67117a.get(i);
                    if (aVar2 != null && this.f67121e.get(i) == null) {
                        this.f67121e.put(i, aVar2);
                    }
                    R(i);
                }
            }
        }
        d.o.a.e.b.n.a aVar3 = this.f67117a.get(i);
        if (aVar3 != null) {
            if (this.f67119c.get(i) == null) {
                this.f67119c.put(i, aVar3);
            }
            this.f67117a.remove(i);
        }
        R(i);
    }

    public synchronized void d(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        d.o.a.e.b.n.a Q = Q(i);
        if (Q == null) {
            Q = this.f67122f.get(Integer.valueOf(i));
        }
        if (Q != null) {
            Q.v0(i2, bVar, gVar, z);
        }
    }

    public synchronized void e(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        DownloadInfo b2;
        d.o.a.e.b.n.a Q = Q(i);
        if (Q != null) {
            Q.c(i2, bVar, gVar, z);
            DownloadInfo H = Q.H();
            if (z2 && H != null && !p(i) && (gVar == com.ss.android.socialbase.downloader.constants.g.MAIN || gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION)) {
                boolean z3 = true;
                if (gVar == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION && !H.e()) {
                    z3 = false;
                }
                if (z3) {
                    this.j.post(new f(this, bVar, H));
                }
            }
        } else if (d.o.a.e.b.l.a.a(32768) && (b2 = this.i.b(i)) != null && b2.H0() != -3) {
            d.o.a.e.b.n.a aVar = this.f67122f.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new d.o.a.e.b.n.a(b2);
                synchronized (this.f67122f) {
                    this.f67122f.put(Integer.valueOf(i), aVar);
                }
            }
            aVar.c(i2, bVar, gVar, z);
        }
    }

    public abstract void f(int i, long j);

    public void g(int i, d.o.a.e.b.f.d dVar) {
        synchronized (this.f67117a) {
            d.o.a.e.b.n.a aVar = this.f67117a.get(i);
            if (aVar != null) {
                aVar.E0(dVar);
            }
        }
    }

    public final void h(int i, BaseException baseException, d.o.a.e.b.n.a aVar) {
        if (aVar != null) {
            DownloadInfo H = aVar.H();
            SparseArray<d.o.a.e.b.f.b> K = aVar.K(com.ss.android.socialbase.downloader.constants.g.MAIN);
            SparseArray<d.o.a.e.b.f.b> K2 = aVar.K(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION);
            boolean z = aVar.i() || H.c1();
            d.o.a.e.b.l.c.a(i, K, true, H, baseException);
            d.o.a.e.b.l.c.a(i, K2, z, H, baseException);
        }
    }

    public abstract void i(int i, d.o.a.e.b.n.a aVar);

    public abstract void j(d.o.a.e.b.k.c cVar);

    public final void l(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.H0() == 7 || downloadInfo.C0() != com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE) {
                    downloadInfo.a3(5);
                    downloadInfo.V2(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE);
                    d.o.a.e.b.c.a.g("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void m(d.o.a.e.b.n.a aVar) {
        DownloadInfo H;
        if (aVar == null || (H = aVar.H()) == null) {
            return;
        }
        H.p2(false);
        if (H.N() != com.ss.android.socialbase.downloader.constants.f.ENQUEUE_NONE) {
            y(aVar);
        } else {
            n(aVar, true);
        }
    }

    public final void n(d.o.a.e.b.n.a aVar, boolean z) {
        DownloadInfo H;
        int i;
        DownloadInfo H2;
        d.o.a.e.b.n.a remove;
        if (aVar == null || (H = aVar.H()) == null) {
            return;
        }
        if (H.p1()) {
            y O = aVar.O();
            d.o.a.e.b.e.a.e(O, H, new BaseException(1003, "downloadInfo is Invalid, url is " + H.T0() + " name is " + H.q0() + " savePath is " + H.F0()), H.H0());
            return;
        }
        boolean z2 = false;
        if (d.o.a.e.b.j.a.d(H.c0()).b("no_net_opt", 0) == 1 && !d.o.a.e.b.l.e.p0(d.o.a.e.b.g.d.l()) && !H.s1()) {
            new d.o.a.e.b.g.g(aVar, this.j).g(new BaseException(1049, "network_not_available"));
            return;
        }
        int c0 = H.c0();
        if (z) {
            l(H);
        }
        synchronized (this.f67119c) {
            if (this.f67119c.get(c0) != null) {
                this.f67119c.remove(c0);
            }
        }
        synchronized (this.f67118b) {
            if (this.f67118b.get(c0) != null) {
                this.f67118b.remove(c0);
            }
        }
        synchronized (this.f67120d) {
            if (this.f67120d.get(c0) != null) {
                this.f67120d.remove(c0);
            }
        }
        synchronized (this.f67121e) {
            if (this.f67121e.get(c0) != null) {
                this.f67121e.remove(c0);
            }
        }
        if (p(c0) && !H.c()) {
            d.o.a.e.b.c.a.g("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            if (H.b1()) {
                aVar.d();
            }
            d.o.a.e.b.e.a.e(aVar.O(), H, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), H.H0());
            return;
        }
        if (H.c()) {
            H.f2(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
        }
        if (d.o.a.e.b.l.a.a(32768)) {
            synchronized (this.f67122f) {
                remove = this.f67122f.remove(Integer.valueOf(c0));
            }
            if (remove != null) {
                aVar.l(remove);
            }
        }
        synchronized (this.f67117a) {
            Long l = this.f67123g.get(c0);
            long longValue = l != null ? l.longValue() : 0L;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - longValue < 50) {
                d.o.a.e.b.n.a aVar2 = this.f67117a.get(c0);
                if (aVar2 == null || (H2 = aVar2.H()) == null) {
                    i = 0;
                } else {
                    i = H2.H0();
                    if (i == 0 || d.o.a.e.b.d.a.b(i)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    d.o.a.e.b.c.a.g("AbsDownloadEngine", "can add listener, oldTaskStatus is :" + i);
                    if (i >= 0 && i < 2) {
                        aVar.d();
                    } else if (H.b1()) {
                        aVar.d();
                    } else {
                        d.o.a.e.b.e.a.e(aVar.O(), H, new BaseException(1003, "has another same task within 50 milliseconds and addListenerToSameTask is false"), H.H0());
                        this.f67117a.put(c0, aVar);
                        this.f67123g.put(c0, Long.valueOf(uptimeMillis));
                        i(c0, aVar);
                    }
                } else {
                    this.f67117a.put(c0, aVar);
                    this.f67123g.put(c0, Long.valueOf(uptimeMillis));
                    i(c0, aVar);
                }
            } else {
                this.f67117a.put(c0, aVar);
                this.f67123g.put(c0, Long.valueOf(uptimeMillis));
                i(c0, aVar);
            }
        }
    }

    public synchronized void o(List<String> list) {
        DownloadInfo H;
        try {
            boolean d0 = d.o.a.e.b.l.a.a(1048576) ? d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l()) : true;
            for (int i = 0; i < this.f67119c.size(); i++) {
                d.o.a.e.b.n.a aVar = this.f67119c.get(this.f67119c.keyAt(i));
                if (aVar != null && (H = aVar.H()) != null && H.m0() != null && list.contains(H.m0()) && (!H.K1() || d0)) {
                    H.g2(true);
                    H.Y2(true);
                    m(aVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract boolean p(int i);

    public boolean q(int i, boolean z) {
        d.o.a.e.b.n.a aVar = this.f67117a.get(i);
        if (aVar == null && d.o.a.e.b.l.a.a(65536)) {
            aVar = Q(i);
        }
        if (aVar != null) {
            if (!d.o.a.e.b.j.a.d(i).q("fix_on_cancel_call_twice", true)) {
                new d.o.a.e.b.g.g(aVar, this.j).s();
            }
            DownloadInfo H = aVar.H();
            this.j.post(new RunnableC1847a(this, aVar.K(com.ss.android.socialbase.downloader.constants.g.MAIN), H, aVar.K(com.ss.android.socialbase.downloader.constants.g.NOTIFICATION)));
        }
        DownloadInfo b2 = this.i.b(i);
        if (d.o.a.e.b.l.a.a(65536)) {
            if (b2 != null) {
                b2.a3(-4);
            }
        } else if (b2 != null && d.o.a.e.b.d.a.b(b2.H0())) {
            b2.a3(-4);
        }
        w(i, z);
        return true;
    }

    public List<DownloadInfo> r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : a()) {
            DownloadInfo D = D(num.intValue());
            if (D != null && str.equals(D.m0())) {
                arrayList.add(D);
            }
        }
        return arrayList;
    }

    public void s() {
        List<Integer> a2 = a();
        if (a2 == null) {
            return;
        }
        for (Integer num : a2) {
            G(num.intValue());
        }
    }

    public abstract void t(int i);

    public synchronized void u(int i, int i2, d.o.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        e(i, i2, bVar, gVar, z, true);
    }

    public void v(int i, long j) {
        DownloadInfo b2 = this.i.b(i);
        if (b2 != null) {
            b2.f3(j);
        }
        f(i, j);
    }

    public void w(int i, boolean z) {
        DownloadInfo b2 = this.i.b(i);
        if (b2 != null) {
            l(b2);
        }
        this.j.post(new b(this, i));
        d.o.a.e.b.g.d.R(new c(i, z), true);
    }

    public final void y(d.o.a.e.b.n.a aVar) {
        DownloadInfo H;
        if (aVar == null || (H = aVar.H()) == null) {
            return;
        }
        try {
            synchronized (this.f67124h) {
                if (this.f67124h.isEmpty()) {
                    n(aVar, true);
                    this.f67124h.put(aVar);
                } else if (H.N() == com.ss.android.socialbase.downloader.constants.f.ENQUEUE_TAIL) {
                    if (this.f67124h.getFirst().G() == aVar.G() && p(aVar.G())) {
                        return;
                    }
                    Iterator<d.o.a.e.b.n.a> it = this.f67124h.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        d.o.a.e.b.n.a next = it.next();
                        if (next != null && next.G() == aVar.G()) {
                            it.remove();
                            break;
                        }
                    }
                    this.f67124h.put(aVar);
                    new d.o.a.e.b.g.g(aVar, this.j).b();
                } else {
                    d.o.a.e.b.n.a first = this.f67124h.getFirst();
                    if (first.G() == aVar.G() && p(aVar.G())) {
                        return;
                    }
                    G(first.G());
                    n(aVar, true);
                    if (first.G() != aVar.G()) {
                        this.f67124h.putFirst(aVar);
                    }
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized void z(List<String> list) {
        DownloadInfo H;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l())) {
            for (int i = 0; i < this.f67117a.size(); i++) {
                d.o.a.e.b.n.a aVar = this.f67117a.get(this.f67117a.keyAt(i));
                if (aVar != null && (H = aVar.H()) != null && H.m0() != null && list.contains(H.m0()) && A(H)) {
                    H.g2(true);
                    H.Y2(true);
                    m(aVar);
                    H.p2(true);
                    d.o.a.e.b.g.q m = d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).m();
                    if (m != null) {
                        m.a(H, 5, 2);
                    }
                }
            }
        }
    }
}
