package d.o.a.e.b.n;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.f;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.d;
import d.o.a.e.b.f.p;
import d.o.a.e.b.f.q;
import d.o.a.e.b.f.s;
import d.o.a.e.b.f.u;
import d.o.a.e.b.f.w;
import d.o.a.e.b.f.x;
import d.o.a.e.b.f.y;
import d.o.a.e.b.g.e;
import d.o.a.e.b.g.h;
import d.o.a.e.b.g.i;
import d.o.a.e.b.g.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public DownloadInfo f71221a;

    /* renamed from: b  reason: collision with root package name */
    public h f71222b;

    /* renamed from: c  reason: collision with root package name */
    public i f71223c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<g, d.o.a.e.b.f.b> f71224d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<g> f71225e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f71226f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f71227g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f71228h;

    /* renamed from: i  reason: collision with root package name */
    public d f71229i;
    public x j;
    public q k;
    public y l;
    public DownloadInfo.b m;
    public w n;
    public s o;
    public r p;
    public d.o.a.e.b.f.i q;
    public boolean r;
    public u s;
    public final List<p> t;

    /* renamed from: d.o.a.e.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1953a implements i {
        public C1953a(a aVar) {
        }

        @Override // d.o.a.e.b.g.i
        public int a(long j) {
            return 1;
        }
    }

    public a() {
        this.f71224d = new ConcurrentHashMap();
        this.f71225e = new SparseArray<>();
        this.r = false;
        this.t = new ArrayList();
        this.m = new DownloadInfo.b();
        this.f71226f = new SparseArray<>();
        this.f71227g = new SparseArray<>();
        this.f71228h = new SparseArray<>();
    }

    public h A() {
        return this.f71222b;
    }

    public final void A0() {
        if (this.f71221a.O0() > 0) {
            k(new C1953a(this));
        }
    }

    public i B() {
        return this.f71223c;
    }

    public a B0(List<p> list) {
        if (list != null && !list.isEmpty()) {
            for (p pVar : list) {
                b(pVar);
            }
        }
        return this;
    }

    public q C() {
        return this.k;
    }

    public void C0(SparseArray<d.o.a.e.b.f.b> sparseArray, g gVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (gVar == g.MAIN) {
                synchronized (this.f71226f) {
                    m(this.f71226f, sparseArray);
                }
            } else if (gVar == g.SUB) {
                synchronized (this.f71227g) {
                    m(this.f71227g, sparseArray);
                }
            } else if (gVar == g.NOTIFICATION) {
                synchronized (this.f71228h) {
                    m(this.f71228h, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public s D() {
        return this.o;
    }

    public void D0(boolean z) {
        this.r = z;
    }

    public p E(int i2) {
        synchronized (this.t) {
            if (i2 < this.t.size()) {
                return this.t.get(i2);
            }
            return null;
        }
    }

    public void E0(d dVar) {
        this.f71229i = dVar;
    }

    @NonNull
    public List<p> F() {
        return this.t;
    }

    public a F0(boolean z) {
        this.m.T(z);
        return this;
    }

    public int G() {
        DownloadInfo downloadInfo = this.f71221a;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.c0();
    }

    public a G0(boolean z) {
        this.m.a0(z);
        return this;
    }

    public DownloadInfo H() {
        return this.f71221a;
    }

    public a H0(int i2, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f71227g) {
                this.f71227g.put(i2, bVar);
            }
            this.f71224d.put(g.SUB, bVar);
            synchronized (this.f71225e) {
                this.f71225e.put(i2, g.SUB);
            }
        }
        return this;
    }

    public d.o.a.e.b.f.b I(g gVar, int i2) {
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null || i2 < 0) {
            return null;
        }
        synchronized (K) {
            if (i2 < K.size()) {
                return K.get(K.keyAt(i2));
            }
            return null;
        }
    }

    public a I0(long j) {
        this.m.F(j);
        return this;
    }

    public int J(g gVar) {
        int size;
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null) {
            return 0;
        }
        synchronized (K) {
            size = K.size();
        }
        return size;
    }

    public a J0(String str) {
        this.m.G(str);
        return this;
    }

    public SparseArray<d.o.a.e.b.f.b> K(g gVar) {
        if (gVar == g.MAIN) {
            return this.f71226f;
        }
        if (gVar == g.SUB) {
            return this.f71227g;
        }
        if (gVar == g.NOTIFICATION) {
            return this.f71228h;
        }
        return null;
    }

    public a K0(String str) {
        this.m.M(str);
        return this;
    }

    public u L() {
        return this.s;
    }

    public w M() {
        return this.n;
    }

    public x N() {
        return this.j;
    }

    public y O() {
        return this.l;
    }

    public d.o.a.e.b.f.i P() {
        return this.q;
    }

    public d Q() {
        return this.f71229i;
    }

    public r R() {
        return this.p;
    }

    public d.o.a.e.b.f.b S(g gVar) {
        return this.f71224d.get(gVar);
    }

    public a T(boolean z) {
        this.m.r0(z);
        return this;
    }

    public a U(String str) {
        this.m.o0(str);
        return this;
    }

    public a V(x xVar) {
        this.j = xVar;
        return this;
    }

    public boolean W() {
        return this.r;
    }

    public a X(d.o.a.e.b.f.b bVar) {
        if (bVar == null) {
            return this;
        }
        Y(bVar.hashCode(), bVar);
        return this;
    }

    public a Y(int i2, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f71226f) {
                this.f71226f.put(i2, bVar);
            }
            this.f71224d.put(g.MAIN, bVar);
            synchronized (this.f71225e) {
                this.f71225e.put(i2, g.MAIN);
            }
        }
        return this;
    }

    public a Z(int i2) {
        this.m.O(i2);
        return this;
    }

    public final void a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    public a a0(String str) {
        this.m.g0(str);
        return this;
    }

    public a b(p pVar) {
        synchronized (this.t) {
            if (pVar != null) {
                if (!this.t.contains(pVar)) {
                    this.t.add(pVar);
                    return this;
                }
            }
            return this;
        }
    }

    public a b0(String str) {
        this.m.Z(str);
        return this;
    }

    public void c(int i2, d.o.a.e.b.f.b bVar, g gVar, boolean z) {
        Map<g, d.o.a.e.b.f.b> map;
        if (bVar == null) {
            return;
        }
        if (z && (map = this.f71224d) != null) {
            map.put(gVar, bVar);
            synchronized (this.f71225e) {
                this.f71225e.put(i2, gVar);
            }
        }
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null) {
            return;
        }
        synchronized (K) {
            K.put(i2, bVar);
        }
    }

    public a c0(int i2) {
        this.m.S(i2);
        return this;
    }

    public void d() {
        d.o.a.e.b.c.a.g("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        e(g.MAIN);
        e(g.SUB);
        d.o.a.e.b.e.a.e(this.l, this.f71221a, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public a d0(y yVar) {
        this.l = yVar;
        return this;
    }

    public final void e(g gVar) {
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        synchronized (K) {
            for (int i2 = 0; i2 < K.size(); i2++) {
                d.o.a.e.b.f.b bVar = K.get(K.keyAt(i2));
                if (bVar != null) {
                    e.c().q(G(), bVar, gVar, false);
                }
            }
        }
    }

    public a e0(String str) {
        this.m.m0(str);
        return this;
    }

    public a f(boolean z) {
        this.m.X(z);
        return this;
    }

    public a f0(String str) {
        this.m.y(str);
        return this;
    }

    public a g(int i2) {
        this.m.L(i2);
        return this;
    }

    public a g0(boolean z) {
        this.m.u0(z);
        return this;
    }

    public a h(List<String> list) {
        this.m.H(list);
        return this;
    }

    public a h0(boolean z) {
        this.m.d0(z);
        return this;
    }

    public boolean i() {
        DownloadInfo downloadInfo = this.f71221a;
        if (downloadInfo != null) {
            return downloadInfo.e();
        }
        return false;
    }

    public a i0(boolean z) {
        this.m.Q(z);
        return this;
    }

    public a j(h hVar) {
        this.f71222b = hVar;
        return this;
    }

    public a j0(boolean z) {
        this.m.p0(z);
        return this;
    }

    public a k(i iVar) {
        this.f71223c = iVar;
        return this;
    }

    public a k0(boolean z) {
        this.m.k0(z);
        return this;
    }

    public void l(a aVar) {
        for (Map.Entry<g, d.o.a.e.b.f.b> entry : aVar.f71224d.entrySet()) {
            if (entry != null && !this.f71224d.containsKey(entry.getKey())) {
                this.f71224d.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (aVar.f71226f.size() != 0) {
                synchronized (this.f71226f) {
                    u0(this.f71226f, aVar.f71226f);
                    a(aVar.f71226f, this.f71226f);
                }
            }
            if (aVar.f71227g.size() != 0) {
                synchronized (this.f71227g) {
                    u0(this.f71227g, aVar.f71227g);
                    a(aVar.f71227g, this.f71227g);
                }
            }
            if (aVar.f71228h.size() != 0) {
                synchronized (this.f71228h) {
                    u0(this.f71228h, aVar.f71228h);
                    a(aVar.f71228h, this.f71228h);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a l0(boolean z) {
        this.m.h0(z);
        return this;
    }

    public final void m(SparseArray<d.o.a.e.b.f.b> sparseArray, SparseArray<d.o.a.e.b.f.b> sparseArray2) {
        sparseArray.clear();
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            d.o.a.e.b.f.b bVar = sparseArray2.get(keyAt);
            if (bVar != null) {
                sparseArray.put(keyAt, bVar);
            }
        }
    }

    public a m0(boolean z) {
        this.m.n0(z);
        return this;
    }

    public a n(q qVar) {
        this.k = qVar;
        return this;
    }

    public a n0(boolean z) {
        this.m.y0(z);
        return this;
    }

    public a o(s sVar) {
        this.o = sVar;
        return this;
    }

    public a o0(d.o.a.e.b.f.i iVar) {
        this.q = iVar;
        return this;
    }

    public int p() {
        this.f71221a = this.m.C();
        if (d.o.a.e.b.g.d.I0().b(this.f71221a.c0()) == null) {
            d.o.a.e.b.e.a.h(this, null, 0);
        }
        A0();
        e.c().j(this);
        DownloadInfo downloadInfo = this.f71221a;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.c0();
    }

    public a p0(d dVar) {
        this.f71229i = dVar;
        return this;
    }

    public a q(JSONObject jSONObject) {
        this.m.A(jSONObject);
        return this;
    }

    public a q0(d.o.a.e.b.f.b bVar) {
        if (bVar == null) {
            return this;
        }
        r0(bVar.hashCode(), bVar);
        return this;
    }

    public a r(f fVar) {
        this.m.x(fVar);
        return this;
    }

    public a r0(int i2, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f71228h) {
                this.f71228h.put(i2, bVar);
            }
            this.f71224d.put(g.NOTIFICATION, bVar);
            synchronized (this.f71225e) {
                this.f71225e.put(i2, g.NOTIFICATION);
            }
        }
        return this;
    }

    public a s(int i2) {
        this.m.V(i2);
        return this;
    }

    public a s0(boolean z) {
        this.m.B(z);
        return this;
    }

    public a t(long j) {
        this.m.w(j);
        return this;
    }

    public a t0(String str) {
        this.m.c0(str);
        return this;
    }

    public a u(String str) {
        this.m.W(str);
        return this;
    }

    public final void u0(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.remove(sparseArray2.keyAt(i2));
        }
    }

    public a v(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.m.z(list);
        return this;
    }

    public void v0(int i2, d.o.a.e.b.f.b bVar, g gVar, boolean z) {
        int indexOfValue;
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null) {
            if (z && this.f71224d.containsKey(gVar)) {
                this.f71224d.remove(gVar);
                return;
            }
            return;
        }
        synchronized (K) {
            if (z) {
                if (this.f71224d.containsKey(gVar)) {
                    bVar = this.f71224d.get(gVar);
                    this.f71224d.remove(gVar);
                }
                if (bVar != null && (indexOfValue = K.indexOfValue(bVar)) >= 0 && indexOfValue < K.size()) {
                    K.removeAt(indexOfValue);
                }
            } else {
                K.remove(i2);
                synchronized (this.f71225e) {
                    g gVar2 = this.f71225e.get(i2);
                    if (gVar2 != null && this.f71224d.containsKey(gVar2)) {
                        this.f71224d.remove(gVar2);
                        this.f71225e.remove(i2);
                    }
                }
            }
        }
    }

    public a w(int[] iArr) {
        this.m.J(iArr);
        return this;
    }

    public a w0(int i2) {
        this.m.E(i2);
        return this;
    }

    public a x(u uVar) {
        this.s = uVar;
        return this;
    }

    public a x0(String str) {
        this.m.j0(str);
        return this;
    }

    public a y(w wVar) {
        this.n = wVar;
        return this;
    }

    public a y0(r rVar) {
        this.p = rVar;
        return this;
    }

    public a z(boolean z) {
        this.m.I(z);
        return this;
    }

    public a z0(String str) {
        this.m.P(str);
        return this;
    }

    public a(DownloadInfo downloadInfo) {
        this();
        this.f71221a = downloadInfo;
    }
}
