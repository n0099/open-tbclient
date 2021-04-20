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
/* loaded from: classes2.dex */
public class d extends j {
    public static final boolean l = d.b.g0.a.k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.l.r.f f44534g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.e0.p.a f44535h;
    public final List<d.b.g0.l.k.g> i;
    public d.b.g0.l.h.a<a.C1032a> j;
    public d.b.g0.l.h.c<d.b.g0.l.k.g> k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.b.g0.l.i.a.h().b(null, d.this.i, null, null, null);
            if (b2 && d.this.f44535h != null) {
                for (d.b.g0.l.k.g gVar : d.this.i) {
                    d.this.f44535h.e(gVar);
                }
            }
            if (d.l) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.l.h.a<a.C1032a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1032a f44538e;

            public a(a.C1032a c1032a) {
                this.f44538e = c1032a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.R(this.f44538e)) {
                    if (d.this.f44535h != null) {
                        d.this.f44535h.b(this.f44538e);
                    }
                    d.b.g0.a.e0.p.p.a.c(this.f44538e.f49374f.appId);
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
        public void m(a.C1032a c1032a, PMSAppInfo pMSAppInfo, d.b.g0.l.k.a aVar) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f49306a + ",msg: " + aVar.f49307b);
            if (d.this.f44535h != null) {
                d.this.f44535h.d(aVar);
            }
            if (aVar == null || aVar.f49306a != 1010) {
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1032a == null ? null : c1032a.f49374f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.S(pMSAppInfo2, pMSAppInfo);
            if (d.b.g0.a.e0.p.p.a.m(aVar)) {
                d.b.g0.a.e0.p.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.b.g0.l.h.a
        public void o(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            d.this.S(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: p */
        public String j(a.C1032a c1032a) {
            if (c1032a == null) {
                return null;
            }
            int i = c1032a.f49371c;
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
        public void l(a.C1032a c1032a, d.b.g0.l.k.a aVar) {
            super.l(c1032a, aVar);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(11L);
            aVar2.h((long) aVar.f49306a);
            aVar2.c("批量下载，主包下载失败：" + c1032a.f49370b);
            aVar2.e(aVar.toString());
            if (c1032a.f49369a != 0) {
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1032a.f49372d == null) {
            } else {
                d.this.f44534g.i(c1032a.f49372d);
                d.b.g0.a.e0.p.c.c().a(c1032a.f49372d, PMSDownloadType.BATCH, aVar2);
                d.b.g0.p.d.g(c1032a.f49372d.f49309a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void b(a.C1032a c1032a) {
            super.b(c1032a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1032a.f49372d.i);
            a aVar = new a(c1032a);
            p.k(aVar, c1032a.f49372d.f49315g + " 下载完成，执行签名校验-重命名-解压-DB");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: s */
        public void a(a.C1032a c1032a) {
            super.a(c1032a);
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1032a.f49372d.f49310b + "/" + c1032a.f49372d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: t */
        public void i(a.C1032a c1032a) {
            super.i(c1032a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1032a.f49370b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: u */
        public void n(a.C1032a c1032a) {
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1032a.f49370b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44541f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f44540e = pMSAppInfo;
            this.f44541f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f44540e;
            if (pMSAppInfo != null) {
                pMSAppInfo.n(d.this.I());
                this.f44541f.b(this.f44540e);
            } else {
                this.f44541f.n(d.this.I());
            }
            this.f44541f.k();
            if (d.b.g0.l.i.a.h().k(this.f44541f)) {
                d.b.g0.a.e0.p.r.a.o(this.f44541f);
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0681d extends k<d> {
        public C0681d(d dVar) {
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
    public void B(d.b.g0.l.k.a aVar) {
        super.B(aVar);
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.b.g0.a.e0.p.a aVar2 = this.f44535h;
        if (aVar2 != null) {
            aVar2.a(aVar.f49306a);
        }
    }

    @Override // d.b.g0.l.h.g
    public void C() {
        super.C();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        super.D();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.b.g0.a.e0.p.a aVar = this.f44535h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // d.b.g0.l.h.g
    public void F(d.b.g0.l.r.f fVar) {
        super.F(fVar);
        this.f44534g = fVar;
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.k());
    }

    @Override // d.b.g0.a.e0.p.j
    public int J() {
        return 7;
    }

    public final boolean R(a.C1032a c1032a) {
        if (c1032a == null || c1032a.f49372d == null || c1032a.f49374f == null) {
            return false;
        }
        if (!e0.a(new File(c1032a.f49372d.f49309a), c1032a.f49372d.m)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.b.g0.a.f2.a m = d.b.g0.a.e0.p.r.a.m(c1032a.f49372d, this);
        if (m != null) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
            return false;
        }
        c1032a.f49374f.k();
        d.b.g0.a.e0.p.r.a.k(c1032a.f49374f, c1032a.f49372d);
        c1032a.f49374f.n(I());
        if (!d.b.g0.l.i.a.h().a(c1032a.f49372d, c1032a.f49374f)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f44534g.j(c1032a.f49372d);
        if (!c1032a.f49375g) {
            d.b.g0.a.e0.p.r.a.o(c1032a.f49374f);
        }
        d.b.g0.a.e0.p.r.a.b(c1032a.f49372d);
        return true;
    }

    public final void S(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
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
        d.b.g0.a.e0.p.a aVar = this.f44535h;
        if (aVar != null) {
            aVar.f();
        }
        d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
        d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
        k.h(7);
        d2.q(null, k.j());
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.a<a.C1032a> u() {
        return this.j;
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<d.b.g0.l.k.g> z() {
        return this.k;
    }

    public d(d.b.g0.a.e0.p.a aVar) {
        this.j = new b();
        this.k = new C0681d(this);
        this.f44535h = aVar;
        this.i = new Vector();
    }
}
