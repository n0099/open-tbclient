package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import d.b.g0.a.e0.p.c;
import d.b.g0.a.i2.o0;
import h.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class l extends j {
    public static final boolean n = d.b.g0.a.k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super d.b.g0.l.k.d> f44582g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.b.g0.l.k.b> f44583h;
    public d.b.g0.l.r.f i;
    public d.b.g0.a.i2.u0.b<Exception> j;
    public d.b.g0.l.h.c<d.b.g0.l.k.d> k;
    public d.b.g0.l.h.c<d.b.g0.l.k.b> l;
    public h.j<d.b.g0.l.k.e> m;

    /* loaded from: classes2.dex */
    public class a extends d.b.g0.l.h.b<d.b.g0.l.k.d> {
        public a() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return l.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(d.b.g0.l.k.d dVar) {
            return l.this.W();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(d.b.g0.l.k.d dVar, d.b.g0.l.k.a aVar) {
            super.l(dVar, aVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.i.i(dVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f49306a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f44582g != null) {
                l.this.f44582g.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.b.g0.a.e0.p.c.c().a(dVar, l.this.U(), aVar2);
            d.b.g0.p.d.g(dVar.f49309a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(d.b.g0.l.k.d dVar) {
            super.b(dVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.i);
            d.b.g0.a.f2.a b0 = l.this.b0(dVar);
            if (b0 == null) {
                l.this.i.j(dVar);
                if (l.this.f44582g != null) {
                    l.this.f44582g.onNext(dVar);
                    l.this.f44582g.onCompleted();
                }
                d.b.g0.l.i.a.h().l(dVar);
                d.b.g0.a.e0.p.c.c().b(dVar, l.this.U());
                o0.a();
                return;
            }
            l.this.i.i(dVar);
            if (l.this.f44582g != null) {
                l.this.f44582g.onError(new PkgDownloadError(dVar, b0));
            }
            d.b.g0.a.e0.p.c.c().a(dVar, l.this.U(), b0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(d.b.g0.l.k.d dVar) {
            super.i(dVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(d.b.g0.l.k.d dVar) {
            super.n(dVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "framework onDownloading");
            }
            l.this.f0(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.l.h.b<d.b.g0.l.k.b> {
        public b() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return l.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(d.b.g0.l.k.b bVar) {
            return l.this.V();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(d.b.g0.l.k.b bVar, d.b.g0.l.k.a aVar) {
            super.l(bVar, aVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.i.i(bVar);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f49306a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f44583h != null) {
                l.this.f44583h.onError(new PkgDownloadError(bVar, aVar2));
            }
            d.b.g0.a.e0.p.c.c().a(bVar, l.this.U(), aVar2);
            d.b.g0.p.d.g(bVar.f49309a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(d.b.g0.l.k.b bVar) {
            super.b(bVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.i);
            d.b.g0.a.f2.a a0 = l.this.a0(bVar);
            if (a0 == null) {
                l.this.i.j(bVar);
                if (l.this.f44583h != null) {
                    l.this.f44583h.onNext(bVar);
                    l.this.f44583h.onCompleted();
                }
                d.b.g0.l.i.a.h().l(bVar);
                d.b.g0.a.e0.p.c.c().b(bVar, l.this.U());
                return;
            }
            l.this.i.i(bVar);
            if (l.this.f44583h != null) {
                l.this.f44583h.onError(new PkgDownloadError(bVar, a0));
            }
            d.b.g0.a.e0.p.c.c().a(bVar, l.this.U(), a0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(d.b.g0.l.k.b bVar) {
            super.i(bVar);
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(d.b.g0.l.k.b bVar) {
            super.n(bVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "extension onDownloading");
            }
            l.this.e0(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.d f44586a;

        public c(d.b.g0.l.k.d dVar) {
            this.f44586a = dVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.i.j(this.f44586a);
            if (l.this.f44582g != null) {
                l.this.f44582g.onNext(this.f44586a);
                l.this.f44582g.onCompleted();
            }
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            l.this.i.i(this.f44586a);
            if (l.this.f44582g != null) {
                l.this.f44582g.onError(new PkgDownloadError(this.f44586a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0680c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.k.b f44588a;

        public d(d.b.g0.l.k.b bVar) {
            this.f44588a = bVar;
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.i.j(this.f44588a);
            if (l.this.f44583h != null) {
                l.this.f44583h.onNext(this.f44588a);
                l.this.f44583h.onCompleted();
            }
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            l.this.i.i(this.f44588a);
            if (l.this.f44583h != null) {
                l.this.f44583h.onError(new PkgDownloadError(this.f44588a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a<d.b.g0.l.k.d> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.d> jVar) {
            l.this.f44582g = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a<d.b.g0.l.k.b> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.b.g0.l.k.b> jVar) {
            l.this.f44583h = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class g extends h.j<d.b.g0.l.k.e> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.b.g0.l.k.e eVar) {
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.i);
        }

        @Override // h.e
        public void onCompleted() {
            d.b.g0.a.c0.c.h("UpdateCoreCallback", "包下载完成");
            l.this.d0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.b.g0.a.c0.c.i("UpdateCoreCallback", "OnError", th);
            l.this.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
        }
    }

    public l(d.b.g0.a.i2.u0.b<Exception> bVar) {
        this.j = bVar;
    }

    @Override // d.b.g0.l.h.g
    public void B(d.b.g0.l.k.a aVar) {
        super.B(aVar);
        d.b.g0.a.c0.c.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.f49306a == 1010) {
            d0();
            return;
        }
        c0(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        super.D();
        if (n) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.c0.c.h("UpdateCoreCallback", "onNoPackage:");
        d0();
    }

    @Override // d.b.g0.l.h.g
    public void F(d.b.g0.l.r.f fVar) {
        super.F(fVar);
        if (fVar == null) {
            return;
        }
        this.i = fVar;
        if (fVar.h()) {
            return;
        }
        Y();
    }

    public abstract int T();

    public abstract PMSDownloadType U();

    public abstract String V();

    public abstract String W();

    public final h.j<d.b.g0.l.k.e> X() {
        if (this.m == null) {
            this.m = new g();
        }
        return this.m;
    }

    public final void Y() {
        ArrayList arrayList = new ArrayList();
        if (this.i.c()) {
            arrayList.add(h.d.c(new e()));
        }
        if (this.i.b()) {
            arrayList.add(h.d.c(new f()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.m(arrayList).B(X());
    }

    public void Z(Exception exc) {
        d.b.g0.a.c0.c.i("UpdateCoreCallback", "notifyFinalCallback", exc);
        d.b.g0.a.i2.u0.b<Exception> bVar = this.j;
        if (bVar != null) {
            bVar.onCallback(exc);
        }
        this.j = null;
    }

    public abstract d.b.g0.a.f2.a a0(d.b.g0.l.k.b bVar);

    public abstract d.b.g0.a.f2.a b0(d.b.g0.l.k.d dVar);

    public void c0(Exception exc) {
        d.b.g0.a.c0.c.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        d.b.g0.l.q.a.d(T(), 0L);
        Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    public void d0() {
        long currentTimeMillis = System.currentTimeMillis();
        d.b.g0.a.c0.c.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        d.b.g0.l.q.a.d(T(), currentTimeMillis);
        Z(null);
    }

    public final void e0(d.b.g0.l.k.b bVar) {
        d.b.g0.a.e0.p.c.c().d(bVar, new d(bVar));
    }

    public final void f0(d.b.g0.l.k.d dVar) {
        d.b.g0.a.e0.p.c.c().d(dVar, new c(dVar));
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.b> q() {
        if (this.l == null) {
            this.l = new b();
        }
        return this.l;
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.d> r() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }
}
