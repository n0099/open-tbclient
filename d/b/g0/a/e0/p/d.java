package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.i2.e0;
import d.b.g0.a.i2.p;
import d.b.g0.l.l.j.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes3.dex */
public class d extends j {
    public static final boolean l = d.b.g0.a.k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.l.r.f f44141g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.e0.p.a f44142h;
    public final List<d.b.g0.l.k.g> i;
    public d.b.g0.l.h.a<a.C1019a> j;
    public d.b.g0.l.h.c<d.b.g0.l.k.g> k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.b.g0.l.i.a.h().b(null, d.this.i, null, null, null);
            if (b2 && d.this.f44142h != null) {
                for (d.b.g0.l.k.g gVar : d.this.i) {
                    d.this.f44142h.e(gVar);
                }
            }
            if (d.l) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.g0.l.h.a<a.C1019a> {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1019a f44145e;

            public a(a.C1019a c1019a) {
                this.f44145e = c1019a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.S(this.f44145e)) {
                    if (d.this.f44142h != null) {
                        d.this.f44142h.b(this.f44145e);
                    }
                    d.b.g0.a.e0.p.p.a.c(this.f44145e.f48981f.appId);
                }
            }
        }

        public b() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return d.this.g(bundle, set);
        }

        @Override // d.b.g0.l.h.a
        public void m(a.C1019a c1019a, PMSAppInfo pMSAppInfo, d.b.g0.l.k.a aVar) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f48913a + ",msg: " + aVar.f48914b);
            if (d.this.f44142h != null) {
                d.this.f44142h.d(aVar);
            }
            if (aVar == null || aVar.f48913a != 1010) {
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1019a == null ? null : c1019a.f48981f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.T(pMSAppInfo2, pMSAppInfo);
            if (d.b.g0.a.e0.p.p.a.m(aVar)) {
                d.b.g0.a.e0.p.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.b.g0.l.h.a
        public void n(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            d.this.T(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: p */
        public String j(a.C1019a c1019a) {
            if (c1019a == null) {
                return null;
            }
            int i = c1019a.f48978c;
            if (i == 0) {
                return d.b.g0.a.e0.p.r.a.g();
            }
            if (i == 1) {
                return d.b.g0.a.e0.p.r.a.j();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void l(a.C1019a c1019a, d.b.g0.l.k.a aVar) {
            super.l(c1019a, aVar);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(11L);
            aVar2.h((long) aVar.f48913a);
            aVar2.c("批量下载，主包下载失败：" + c1019a.f48977b);
            aVar2.e(aVar.toString());
            if (c1019a.f48976a != 0) {
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1019a.f48979d == null) {
            } else {
                d.this.f44141g.i(c1019a.f48979d);
                d.b.g0.a.e0.p.c.c().a(c1019a.f48979d, PMSDownloadType.BATCH, aVar2);
                d.b.g0.p.d.g(c1019a.f48979d.f48916a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void b(a.C1019a c1019a) {
            super.b(c1019a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1019a.f48979d.i);
            a aVar = new a(c1019a);
            p.k(aVar, c1019a.f48979d.f48922g + " 下载完成，执行签名校验-重命名-解压-DB");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: s */
        public void a(a.C1019a c1019a) {
            super.a(c1019a);
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1019a.f48979d.f48917b + "/" + c1019a.f48979d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: t */
        public void i(a.C1019a c1019a) {
            super.i(c1019a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1019a.f48977b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: u */
        public void o(a.C1019a c1019a) {
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1019a.f48977b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44148f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f44147e = pMSAppInfo;
            this.f44148f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f44147e;
            if (pMSAppInfo != null) {
                pMSAppInfo.n(d.this.J());
                this.f44148f.b(this.f44147e);
            } else {
                this.f44148f.n(d.this.J());
            }
            this.f44148f.k();
            if (d.b.g0.l.i.a.h().k(this.f44148f)) {
                d.b.g0.a.e0.p.r.a.o(this.f44148f);
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0668d extends k<d> {
        public C0668d(d dVar) {
            super(dVar);
        }

        @Override // d.b.g0.a.e0.p.k
        public void p(@NonNull d.b.g0.l.k.g gVar, @Nullable d.b.g0.a.f2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.i.add(gVar);
            } else if (d.l) {
                Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
        }
    }

    public d() {
        this(null);
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.g> A() {
        return this.k;
    }

    @Override // d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.b.g0.a.e0.p.a aVar2 = this.f44142h;
        if (aVar2 != null) {
            aVar2.a(aVar.f48913a);
        }
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        super.D();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.b.g0.a.e0.p.a aVar = this.f44142h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // d.b.g0.l.h.g
    public void G(d.b.g0.l.r.f fVar) {
        super.G(fVar);
        this.f44141g = fVar;
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.k());
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 7;
    }

    public final boolean S(a.C1019a c1019a) {
        if (c1019a == null || c1019a.f48979d == null || c1019a.f48981f == null) {
            return false;
        }
        if (!e0.a(new File(c1019a.f48979d.f48916a), c1019a.f48979d.m)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.b.g0.a.f2.a m = d.b.g0.a.e0.p.r.a.m(c1019a.f48979d, this);
        if (m != null) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
            return false;
        }
        c1019a.f48981f.k();
        d.b.g0.a.e0.p.r.a.k(c1019a.f48981f, c1019a.f48979d);
        c1019a.f48981f.n(J());
        if (!d.b.g0.l.i.a.h().a(c1019a.f48979d, c1019a.f48981f)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f44141g.j(c1019a.f48979d);
        if (!c1019a.f48982g) {
            d.b.g0.a.e0.p.r.a.o(c1019a.f48981f);
        }
        d.b.g0.a.e0.p.r.a.b(c1019a.f48979d);
        return true;
    }

    public final void T(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo == null) {
            return;
        }
        p.k(new c(pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // d.b.g0.l.h.g, d.b.g0.l.h.d
    public void h() {
        super.h();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (l) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.i.isEmpty()) {
            p.k(new a(), "SwanAppBatchDownloadCallback");
        }
        d.b.g0.a.e0.p.a aVar = this.f44142h;
        if (aVar != null) {
            aVar.f();
        }
        d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
        d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
        k.h(7);
        d2.q(null, k.j());
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.a<a.C1019a> v() {
        return this.j;
    }

    public d(d.b.g0.a.e0.p.a aVar) {
        this.j = new b();
        this.k = new C0668d(this);
        this.f44142h = aVar;
        this.i = new Vector();
    }
}
