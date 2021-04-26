package d.a.h0.a.e0.p;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import d.a.h0.a.e0.p.c;
import d.a.h0.a.i2.o0;
import h.d;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class l extends j {
    public static final boolean n = d.a.h0.a.k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public h.j<? super d.a.h0.l.k.d> f42214g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super d.a.h0.l.k.b> f42215h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.l.r.f f42216i;
    public d.a.h0.a.i2.u0.b<Exception> j;
    public d.a.h0.l.h.c<d.a.h0.l.k.d> k;
    public d.a.h0.l.h.c<d.a.h0.l.k.b> l;
    public h.j<d.a.h0.l.k.e> m;

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.l.h.b<d.a.h0.l.k.d> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(d.a.h0.l.k.d dVar) {
            return l.this.W();
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return l.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(d.a.h0.l.k.d dVar, d.a.h0.l.k.a aVar) {
            super.f(dVar, aVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.f42216i.i(dVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f47144a);
            aVar2.c("Framework包下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f42214g != null) {
                l.this.f42214g.onError(new PkgDownloadError(dVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(dVar, l.this.U(), aVar2);
            d.a.h0.p.d.g(dVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(d.a.h0.l.k.d dVar) {
            super.i(dVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onFileDownloaded: " + dVar.f47155i);
            d.a.h0.a.f2.a b0 = l.this.b0(dVar);
            if (b0 == null) {
                l.this.f42216i.j(dVar);
                if (l.this.f42214g != null) {
                    l.this.f42214g.onNext(dVar);
                    l.this.f42214g.onCompleted();
                }
                d.a.h0.l.i.a.h().l(dVar);
                d.a.h0.a.e0.p.c.c().b(dVar, l.this.U());
                o0.a();
                return;
            }
            l.this.f42216i.i(dVar);
            if (l.this.f42214g != null) {
                l.this.f42214g.onError(new PkgDownloadError(dVar, b0));
            }
            d.a.h0.a.e0.p.c.c().a(dVar, l.this.U(), b0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(d.a.h0.l.k.d dVar) {
            super.d(dVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(d.a.h0.l.k.d dVar) {
            super.g(dVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "framework onDownloading");
            }
            l.this.f0(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.h0.l.h.b<d.a.h0.l.k.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(d.a.h0.l.k.b bVar) {
            return l.this.V();
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return l.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(d.a.h0.l.k.b bVar, d.a.h0.l.k.a aVar) {
            super.f(bVar, aVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onDownloadError:" + aVar);
            l.this.f42216i.i(bVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(14L);
            aVar2.h(aVar.f47144a);
            aVar2.c("Extension下载失败");
            aVar2.e(aVar.toString());
            if (l.this.f42215h != null) {
                l.this.f42215h.onError(new PkgDownloadError(bVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(bVar, l.this.U(), aVar2);
            d.a.h0.p.d.g(bVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(d.a.h0.l.k.b bVar) {
            super.i(bVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onFileDownloaded: " + bVar.f47155i);
            d.a.h0.a.f2.a a0 = l.this.a0(bVar);
            if (a0 == null) {
                l.this.f42216i.j(bVar);
                if (l.this.f42215h != null) {
                    l.this.f42215h.onNext(bVar);
                    l.this.f42215h.onCompleted();
                }
                d.a.h0.l.i.a.h().l(bVar);
                d.a.h0.a.e0.p.c.c().b(bVar, l.this.U());
                return;
            }
            l.this.f42216i.i(bVar);
            if (l.this.f42215h != null) {
                l.this.f42215h.onError(new PkgDownloadError(bVar, a0));
            }
            d.a.h0.a.e0.p.c.c().a(bVar, l.this.U(), a0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(d.a.h0.l.k.b bVar) {
            super.d(bVar);
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "onDownloadStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(d.a.h0.l.k.b bVar) {
            super.g(bVar);
            if (l.n) {
                Log.i("UpdateCoreCallback", "extension onDownloading");
            }
            l.this.e0(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.d f42219a;

        public c(d.a.h0.l.k.d dVar) {
            this.f42219a = dVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.f42216i.j(this.f42219a);
            if (l.this.f42214g != null) {
                l.this.f42214g.onNext(this.f42219a);
                l.this.f42214g.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            l.this.f42216i.i(this.f42219a);
            if (l.this.f42214g != null) {
                l.this.f42214g.onError(new PkgDownloadError(this.f42219a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.k.b f42221a;

        public d(d.a.h0.l.k.b bVar) {
            this.f42221a = bVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            l.this.f42216i.j(this.f42221a);
            if (l.this.f42215h != null) {
                l.this.f42215h.onNext(this.f42221a);
                l.this.f42215h.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            l.this.f42216i.i(this.f42221a);
            if (l.this.f42215h != null) {
                l.this.f42215h.onError(new PkgDownloadError(this.f42221a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a<d.a.h0.l.k.d> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.d> jVar) {
            l.this.f42214g = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a<d.a.h0.l.k.b> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super d.a.h0.l.k.b> jVar) {
            l.this.f42215h = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class g extends h.j<d.a.h0.l.k.e> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(d.a.h0.l.k.e eVar) {
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "单个包下载、业务层处理完成：" + eVar.f47155i);
        }

        @Override // h.e
        public void onCompleted() {
            d.a.h0.a.c0.c.h("UpdateCoreCallback", "包下载完成");
            l.this.d0();
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.a.h0.a.c0.c.i("UpdateCoreCallback", "OnError", th);
            l.this.c0(new Exception("UpdateCoreCallback failed by Download error = ", th));
        }
    }

    public l(d.a.h0.a.i2.u0.b<Exception> bVar) {
        this.j = bVar;
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        d.a.h0.a.c0.c.h("UpdateCoreCallback", "onFetchError: " + aVar.toString());
        if (aVar.f47144a == 1010) {
            d0();
            return;
        }
        c0(new Exception("UpdateCoreCallback failed by fetch error = " + aVar));
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        super.D();
        if (n) {
            Log.e("UpdateCoreCallback", "onFetchSuccess:");
        }
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        d.a.h0.a.c0.c.h("UpdateCoreCallback", "onNoPackage:");
        d0();
    }

    @Override // d.a.h0.l.h.g
    public void F(d.a.h0.l.r.f fVar) {
        super.F(fVar);
        if (fVar == null) {
            return;
        }
        this.f42216i = fVar;
        if (fVar.h()) {
            return;
        }
        Y();
    }

    public abstract int T();

    public abstract PMSDownloadType U();

    public abstract String V();

    public abstract String W();

    public final h.j<d.a.h0.l.k.e> X() {
        if (this.m == null) {
            this.m = new g();
        }
        return this.m;
    }

    public final void Y() {
        ArrayList arrayList = new ArrayList();
        if (this.f42216i.c()) {
            arrayList.add(h.d.b(new e()));
        }
        if (this.f42216i.b()) {
            arrayList.add(h.d.b(new f()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.l(arrayList).z(X());
    }

    public void Z(Exception exc) {
        d.a.h0.a.c0.c.i("UpdateCoreCallback", "notifyFinalCallback", exc);
        d.a.h0.a.i2.u0.b<Exception> bVar = this.j;
        if (bVar != null) {
            bVar.onCallback(exc);
        }
        this.j = null;
    }

    public abstract d.a.h0.a.f2.a a0(d.a.h0.l.k.b bVar);

    public abstract d.a.h0.a.f2.a b0(d.a.h0.l.k.d dVar);

    public void c0(Exception exc) {
        d.a.h0.a.c0.c.h("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
        d.a.h0.l.q.a.d(T(), 0L);
        Z(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
    }

    public void d0() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.h0.a.c0.c.h("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
        d.a.h0.l.q.a.d(T(), currentTimeMillis);
        Z(null);
    }

    public final void e0(d.a.h0.l.k.b bVar) {
        d.a.h0.a.e0.p.c.c().d(bVar, new d(bVar));
    }

    public final void f0(d.a.h0.l.k.d dVar) {
        d.a.h0.a.e0.p.c.c().d(dVar, new c(dVar));
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.b> q() {
        if (this.l == null) {
            this.l = new b();
        }
        return this.l;
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.d> r() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }
}
