package d.a.m0.a.h0.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import d.a.m0.a.h0.m.c;
import d.a.m0.a.v2.w0;
import h.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class l extends j {
    public static final boolean n = d.a.m0.a.k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super d.a.m0.n.h.d> f46155g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.m0.n.h.b> f46156h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.n.o.f f46157i;
    public d.a.m0.a.v2.e1.b<Exception> j;
    public d.a.m0.n.f.c<d.a.m0.n.h.d> k;
    public d.a.m0.n.f.c<d.a.m0.n.h.b> l;
    public h.j<d.a.m0.n.h.e> m;

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.n.f.b<d.a.m0.n.h.d> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(d.a.m0.n.h.d dVar) {
            return l.this.W();
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return l.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(d.a.m0.n.h.d dVar, d.a.m0.n.h.a aVar) {
            super.e(dVar, aVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.f46157i.j(dVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f51784a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f46155g != null) {
                l.this.f46155g.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.a.m0.a.h0.m.c.c().a(dVar, l.this.U(), aVar2);
            d.a.m0.t.d.j(dVar.f51788a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(d.a.m0.n.h.d dVar) {
            super.i(dVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.f51796i);
            d.a.m0.a.q2.a b0 = l.this.b0(dVar);
            if (b0 == null) {
                l.this.f46157i.k(dVar);
                if (l.this.f46155g != null) {
                    l.this.f46155g.onNext(dVar);
                    l.this.f46155g.onCompleted();
                }
                d.a.m0.n.g.a.h().l(dVar);
                d.a.m0.a.h0.m.c.c().b(dVar, l.this.U());
                w0.a();
                return;
            }
            l.this.f46157i.j(dVar);
            if (l.this.f46155g != null) {
                l.this.f46155g.onError(new PkgDownloadError(dVar, b0));
            }
            d.a.m0.a.h0.m.c.c().a(dVar, l.this.U(), b0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(d.a.m0.n.h.d dVar) {
            super.c(dVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(d.a.m0.n.h.d dVar) {
            super.f(dVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "framework onDownloading");
            }
            l.this.f0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.n.f.b<d.a.m0.n.h.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(d.a.m0.n.h.b bVar) {
            return l.this.V();
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return l.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(d.a.m0.n.h.b bVar, d.a.m0.n.h.a aVar) {
            super.e(bVar, aVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.f46157i.j(bVar);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f51784a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f46156h != null) {
                l.this.f46156h.onError(new PkgDownloadError(bVar, aVar2));
            }
            d.a.m0.a.h0.m.c.c().a(bVar, l.this.U(), aVar2);
            d.a.m0.t.d.j(bVar.f51788a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(d.a.m0.n.h.b bVar) {
            super.i(bVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.f51796i);
            d.a.m0.a.q2.a a0 = l.this.a0(bVar);
            if (a0 == null) {
                l.this.f46157i.k(bVar);
                if (l.this.f46156h != null) {
                    l.this.f46156h.onNext(bVar);
                    l.this.f46156h.onCompleted();
                }
                d.a.m0.n.g.a.h().l(bVar);
                d.a.m0.a.h0.m.c.c().b(bVar, l.this.U());
                return;
            }
            l.this.f46157i.j(bVar);
            if (l.this.f46156h != null) {
                l.this.f46156h.onError(new PkgDownloadError(bVar, a0));
            }
            d.a.m0.a.h0.m.c.c().a(bVar, l.this.U(), a0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void c(d.a.m0.n.h.b bVar) {
            super.c(bVar);
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(d.a.m0.n.h.b bVar) {
            super.f(bVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "extension onDownloading");
            }
            l.this.e0(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.d f46160a;

        public c(d.a.m0.n.h.d dVar) {
            this.f46160a = dVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.f46157i.k(this.f46160a);
            if (l.this.f46155g != null) {
                l.this.f46155g.onNext(this.f46160a);
                l.this.f46155g.onCompleted();
            }
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            l.this.f46157i.j(this.f46160a);
            if (l.this.f46155g != null) {
                l.this.f46155g.onError(new PkgDownloadError(this.f46160a, aVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.InterfaceC0735c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.h.b f46162a;

        public d(d.a.m0.n.h.b bVar) {
            this.f46162a = bVar;
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.f46157i.k(this.f46162a);
            if (l.this.f46156h != null) {
                l.this.f46156h.onNext(this.f46162a);
                l.this.f46156h.onCompleted();
            }
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            l.this.f46157i.j(this.f46162a);
            if (l.this.f46156h != null) {
                l.this.f46156h.onError(new PkgDownloadError(this.f46162a, aVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a<d.a.m0.n.h.d> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.d> jVar) {
            l.this.f46155g = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a<d.a.m0.n.h.b> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.m0.n.h.b> jVar) {
            l.this.f46156h = jVar;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends h.j<d.a.m0.n.h.e> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.m0.n.h.e eVar) {
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.f51796i);
        }

        @Override // h.e
        public void onCompleted() {
            d.a.m0.a.e0.d.h("UpdateCoreCallback", "包下载完成");
            l.this.d0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.a.m0.a.e0.d.i("UpdateCoreCallback", "OnError", th);
            l.this.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
        }
    }

    public l(d.a.m0.a.v2.e1.b<Exception> bVar) {
        this.j = bVar;
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        super.B(aVar);
        d.a.m0.a.e0.d.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.f51784a == 1010) {
            d0();
            return;
        }
        c0(new PMSException("UpdateCoreCallback failed by fetch error = " + aVar, aVar));
    }

    @Override // d.a.m0.n.f.g
    public void D() {
        super.D();
        if (n) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        d.a.m0.a.e0.d.h("UpdateCoreCallback", "onNoPackage:");
        d0();
    }

    @Override // d.a.m0.n.f.g
    public void F(d.a.m0.n.o.f fVar) {
        super.F(fVar);
        if (fVar == null) {
            return;
        }
        this.f46157i = fVar;
        if (fVar.i()) {
            return;
        }
        Y();
    }

    public abstract int T();

    public abstract PMSDownloadType U();

    public abstract String V();

    public abstract String W();

    public final h.j<d.a.m0.n.h.e> X() {
        if (this.m == null) {
            this.m = new g();
        }
        return this.m;
    }

    public final void Y() {
        ArrayList arrayList = new ArrayList();
        if (this.f46157i.c()) {
            arrayList.add(h.d.b(new e()));
        }
        if (this.f46157i.b()) {
            arrayList.add(h.d.b(new f()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.l(arrayList).z(X());
    }

    public void Z(Exception exc) {
        d.a.m0.a.e0.d.i("UpdateCoreCallback", "notifyFinalCallback", exc);
        d.a.m0.a.v2.e1.b<Exception> bVar = this.j;
        if (bVar != null) {
            bVar.onCallback(exc);
        }
        this.j = null;
    }

    public abstract d.a.m0.a.q2.a a0(d.a.m0.n.h.b bVar);

    public abstract d.a.m0.a.q2.a b0(d.a.m0.n.h.d dVar);

    public void c0(Exception exc) {
        d.a.m0.a.e0.d.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        d.a.m0.n.n.a.d(T(), 0L);
        d.a.m0.d.d.b.a(0L);
        Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    public void d0() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.m0.a.e0.d.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        d.a.m0.n.n.a.d(T(), currentTimeMillis);
        Z(null);
    }

    public final void e0(d.a.m0.n.h.b bVar) {
        d.a.m0.a.h0.m.c.c().d(bVar, new d(bVar));
    }

    public final void f0(d.a.m0.n.h.d dVar) {
        d.a.m0.a.h0.m.c.c().d(dVar, new c(dVar));
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.b> q() {
        if (this.l == null) {
            this.l = new b();
        }
        return this.l;
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.d> r() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }
}
