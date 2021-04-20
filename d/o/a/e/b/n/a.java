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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public DownloadInfo f68184a;

    /* renamed from: b  reason: collision with root package name */
    public h f68185b;

    /* renamed from: c  reason: collision with root package name */
    public i f68186c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<g, d.o.a.e.b.f.b> f68187d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<g> f68188e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f68189f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f68190g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<d.o.a.e.b.f.b> f68191h;
    public d i;
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
    /* loaded from: classes6.dex */
    public class C1886a implements i {
        public C1886a(a aVar) {
        }

        @Override // d.o.a.e.b.g.i
        public int a(long j) {
            return 1;
        }
    }

    public a() {
        this.f68187d = new ConcurrentHashMap();
        this.f68188e = new SparseArray<>();
        this.r = false;
        this.t = new ArrayList();
        this.m = new DownloadInfo.b();
        this.f68189f = new SparseArray<>();
        this.f68190g = new SparseArray<>();
        this.f68191h = new SparseArray<>();
    }

    public h A() {
        return this.f68185b;
    }

    public final void A0() {
        if (this.f68184a.O0() > 0) {
            k(new C1886a(this));
        }
    }

    public i B() {
        return this.f68186c;
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
                synchronized (this.f68189f) {
                    m(this.f68189f, sparseArray);
                }
            } else if (gVar == g.SUB) {
                synchronized (this.f68190g) {
                    m(this.f68190g, sparseArray);
                }
            } else if (gVar == g.NOTIFICATION) {
                synchronized (this.f68191h) {
                    m(this.f68191h, sparseArray);
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

    public p E(int i) {
        synchronized (this.t) {
            if (i < this.t.size()) {
                return this.t.get(i);
            }
            return null;
        }
    }

    public void E0(d dVar) {
        this.i = dVar;
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
        DownloadInfo downloadInfo = this.f68184a;
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
        return this.f68184a;
    }

    public a H0(int i, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f68190g) {
                this.f68190g.put(i, bVar);
            }
            this.f68187d.put(g.SUB, bVar);
            synchronized (this.f68188e) {
                this.f68188e.put(i, g.SUB);
            }
        }
        return this;
    }

    public d.o.a.e.b.f.b I(g gVar, int i) {
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null || i < 0) {
            return null;
        }
        synchronized (K) {
            if (i < K.size()) {
                return K.get(K.keyAt(i));
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
            return this.f68189f;
        }
        if (gVar == g.SUB) {
            return this.f68190g;
        }
        if (gVar == g.NOTIFICATION) {
            return this.f68191h;
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
        return this.i;
    }

    public r R() {
        return this.p;
    }

    public d.o.a.e.b.f.b S(g gVar) {
        return this.f68187d.get(gVar);
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

    public a Y(int i, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f68189f) {
                this.f68189f.put(i, bVar);
            }
            this.f68187d.put(g.MAIN, bVar);
            synchronized (this.f68188e) {
                this.f68188e.put(i, g.MAIN);
            }
        }
        return this;
    }

    public a Z(int i) {
        this.m.O(i);
        return this;
    }

    public final void a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
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

    public void c(int i, d.o.a.e.b.f.b bVar, g gVar, boolean z) {
        Map<g, d.o.a.e.b.f.b> map;
        if (bVar == null) {
            return;
        }
        if (z && (map = this.f68187d) != null) {
            map.put(gVar, bVar);
            synchronized (this.f68188e) {
                this.f68188e.put(i, gVar);
            }
        }
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null) {
            return;
        }
        synchronized (K) {
            K.put(i, bVar);
        }
    }

    public a c0(int i) {
        this.m.S(i);
        return this;
    }

    public void d() {
        d.o.a.e.b.c.a.g("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        e(g.MAIN);
        e(g.SUB);
        d.o.a.e.b.e.a.e(this.l, this.f68184a, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public a d0(y yVar) {
        this.l = yVar;
        return this;
    }

    public final void e(g gVar) {
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        synchronized (K) {
            for (int i = 0; i < K.size(); i++) {
                d.o.a.e.b.f.b bVar = K.get(K.keyAt(i));
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

    public a g(int i) {
        this.m.L(i);
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
        DownloadInfo downloadInfo = this.f68184a;
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
        this.f68185b = hVar;
        return this;
    }

    public a j0(boolean z) {
        this.m.p0(z);
        return this;
    }

    public a k(i iVar) {
        this.f68186c = iVar;
        return this;
    }

    public a k0(boolean z) {
        this.m.k0(z);
        return this;
    }

    public void l(a aVar) {
        for (Map.Entry<g, d.o.a.e.b.f.b> entry : aVar.f68187d.entrySet()) {
            if (entry != null && !this.f68187d.containsKey(entry.getKey())) {
                this.f68187d.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (aVar.f68189f.size() != 0) {
                synchronized (this.f68189f) {
                    u0(this.f68189f, aVar.f68189f);
                    a(aVar.f68189f, this.f68189f);
                }
            }
            if (aVar.f68190g.size() != 0) {
                synchronized (this.f68190g) {
                    u0(this.f68190g, aVar.f68190g);
                    a(aVar.f68190g, this.f68190g);
                }
            }
            if (aVar.f68191h.size() != 0) {
                synchronized (this.f68191h) {
                    u0(this.f68191h, aVar.f68191h);
                    a(aVar.f68191h, this.f68191h);
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
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
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
        this.f68184a = this.m.C();
        if (d.o.a.e.b.g.d.I0().b(this.f68184a.c0()) == null) {
            d.o.a.e.b.e.a.h(this, null, 0);
        }
        A0();
        e.c().j(this);
        DownloadInfo downloadInfo = this.f68184a;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.c0();
    }

    public a p0(d dVar) {
        this.i = dVar;
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

    public a r0(int i, d.o.a.e.b.f.b bVar) {
        if (bVar != null) {
            synchronized (this.f68191h) {
                this.f68191h.put(i, bVar);
            }
            this.f68187d.put(g.NOTIFICATION, bVar);
            synchronized (this.f68188e) {
                this.f68188e.put(i, g.NOTIFICATION);
            }
        }
        return this;
    }

    public a s(int i) {
        this.m.V(i);
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
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    public a v(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.m.z(list);
        return this;
    }

    public void v0(int i, d.o.a.e.b.f.b bVar, g gVar, boolean z) {
        int indexOfValue;
        SparseArray<d.o.a.e.b.f.b> K = K(gVar);
        if (K == null) {
            if (z && this.f68187d.containsKey(gVar)) {
                this.f68187d.remove(gVar);
                return;
            }
            return;
        }
        synchronized (K) {
            if (z) {
                if (this.f68187d.containsKey(gVar)) {
                    bVar = this.f68187d.get(gVar);
                    this.f68187d.remove(gVar);
                }
                if (bVar != null && (indexOfValue = K.indexOfValue(bVar)) >= 0 && indexOfValue < K.size()) {
                    K.removeAt(indexOfValue);
                }
            } else {
                K.remove(i);
                synchronized (this.f68188e) {
                    g gVar2 = this.f68188e.get(i);
                    if (gVar2 != null && this.f68187d.containsKey(gVar2)) {
                        this.f68187d.remove(gVar2);
                        this.f68188e.remove(i);
                    }
                }
            }
        }
    }

    public a w(int[] iArr) {
        this.m.J(iArr);
        return this;
    }

    public a w0(int i) {
        this.m.E(i);
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
        this.f68184a = downloadInfo;
    }
}
