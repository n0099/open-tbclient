package d.b.h0.a.e0.p;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.i2.e0;
import d.b.h0.a.i2.p;
import d.b.h0.l.l.j.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes2.dex */
public class d extends j {
    public static final boolean l = d.b.h0.a.k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.l.r.f f44863g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.a.e0.p.a f44864h;
    public final List<d.b.h0.l.k.g> i;
    public d.b.h0.l.h.a<a.C1052a> j;
    public d.b.h0.l.h.c<d.b.h0.l.k.g> k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.b.h0.l.i.a.h().b(null, d.this.i, null, null, null);
            if (b2 && d.this.f44864h != null) {
                for (d.b.h0.l.k.g gVar : d.this.i) {
                    d.this.f44864h.e(gVar);
                }
            }
            if (d.l) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.h0.l.h.a<a.C1052a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1052a f44867e;

            public a(a.C1052a c1052a) {
                this.f44867e = c1052a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.R(this.f44867e)) {
                    if (d.this.f44864h != null) {
                        d.this.f44864h.b(this.f44867e);
                    }
                    d.b.h0.a.e0.p.p.a.c(this.f44867e.f49703f.appId);
                }
            }
        }

        public b() {
        }

        @Override // d.b.h0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return d.this.g(bundle, set);
        }

        @Override // d.b.h0.l.h.a
        public void m(a.C1052a c1052a, PMSAppInfo pMSAppInfo, d.b.h0.l.k.a aVar) {
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f49635a + ",msg: " + aVar.f49636b);
            if (d.this.f44864h != null) {
                d.this.f44864h.d(aVar);
            }
            if (aVar == null || aVar.f49635a != 1010) {
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1052a == null ? null : c1052a.f49703f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.S(pMSAppInfo2, pMSAppInfo);
            if (d.b.h0.a.e0.p.p.a.m(aVar)) {
                d.b.h0.a.e0.p.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.b.h0.l.h.a
        public void o(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            d.this.S(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.c
        /* renamed from: p */
        public String j(a.C1052a c1052a) {
            if (c1052a == null) {
                return null;
            }
            int i = c1052a.f49700c;
            if (i == 0) {
                return d.b.h0.a.e0.p.r.a.g();
            }
            if (i == 1) {
                return d.b.h0.a.e0.p.r.a.j();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: q */
        public void l(a.C1052a c1052a, d.b.h0.l.k.a aVar) {
            super.l(c1052a, aVar);
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
            aVar2.j(11L);
            aVar2.h((long) aVar.f49635a);
            aVar2.c("批量下载，主包下载失败：" + c1052a.f49699b);
            aVar2.e(aVar.toString());
            if (c1052a.f49698a != 0) {
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1052a.f49701d == null) {
            } else {
                d.this.f44863g.i(c1052a.f49701d);
                d.b.h0.a.e0.p.c.c().a(c1052a.f49701d, PMSDownloadType.BATCH, aVar2);
                d.b.h0.p.d.g(c1052a.f49701d.f49638a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: r */
        public void b(a.C1052a c1052a) {
            super.b(c1052a);
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1052a.f49701d.i);
            a aVar = new a(c1052a);
            p.k(aVar, c1052a.f49701d.f49644g + " 下载完成，执行签名校验-重命名-解压-DB");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: s */
        public void a(a.C1052a c1052a) {
            super.a(c1052a);
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1052a.f49701d.f49639b + "/" + c1052a.f49701d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: t */
        public void i(a.C1052a c1052a) {
            super.i(c1052a);
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1052a.f49699b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: u */
        public void n(a.C1052a c1052a) {
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1052a.f49699b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44870f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f44869e = pMSAppInfo;
            this.f44870f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f44869e;
            if (pMSAppInfo != null) {
                pMSAppInfo.n(d.this.I());
                this.f44870f.b(this.f44869e);
            } else {
                this.f44870f.n(d.this.I());
            }
            this.f44870f.k();
            if (d.b.h0.l.i.a.h().k(this.f44870f)) {
                d.b.h0.a.e0.p.r.a.o(this.f44870f);
            }
        }
    }

    /* renamed from: d.b.h0.a.e0.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0701d extends k<d> {
        public C0701d(d dVar) {
            super(dVar);
        }

        @Override // d.b.h0.a.e0.p.k
        public void p(@NonNull d.b.h0.l.k.g gVar, @Nullable d.b.h0.a.f2.a aVar) {
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

    @Override // d.b.h0.l.h.g
    public void B(d.b.h0.l.k.a aVar) {
        super.B(aVar);
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.b.h0.a.e0.p.a aVar2 = this.f44864h;
        if (aVar2 != null) {
            aVar2.a(aVar.f49635a);
        }
    }

    @Override // d.b.h0.l.h.g
    public void C() {
        super.C();
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.b.h0.l.h.g
    public void D() {
        super.D();
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.b.h0.l.h.g
    public void E() {
        super.E();
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.b.h0.a.e0.p.a aVar = this.f44864h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // d.b.h0.l.h.g
    public void F(d.b.h0.l.r.f fVar) {
        super.F(fVar);
        this.f44863g = fVar;
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.k());
    }

    @Override // d.b.h0.a.e0.p.j
    public int J() {
        return 7;
    }

    public final boolean R(a.C1052a c1052a) {
        if (c1052a == null || c1052a.f49701d == null || c1052a.f49703f == null) {
            return false;
        }
        if (!e0.a(new File(c1052a.f49701d.f49638a), c1052a.f49701d.m)) {
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.b.h0.a.f2.a m = d.b.h0.a.e0.p.r.a.m(c1052a.f49701d, this);
        if (m != null) {
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
            return false;
        }
        c1052a.f49703f.k();
        d.b.h0.a.e0.p.r.a.k(c1052a.f49703f, c1052a.f49701d);
        c1052a.f49703f.n(I());
        if (!d.b.h0.l.i.a.h().a(c1052a.f49701d, c1052a.f49703f)) {
            d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f44863g.j(c1052a.f49701d);
        if (!c1052a.f49704g) {
            d.b.h0.a.e0.p.r.a.o(c1052a.f49703f);
        }
        d.b.h0.a.e0.p.r.a.b(c1052a.f49701d);
        return true;
    }

    public final void S(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo == null) {
            return;
        }
        p.k(new c(pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // d.b.h0.l.h.g, d.b.h0.l.h.d
    public void h() {
        super.h();
        d.b.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (l) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.i.isEmpty()) {
            p.k(new a(), "SwanAppBatchDownloadCallback");
        }
        d.b.h0.a.e0.p.a aVar = this.f44864h;
        if (aVar != null) {
            aVar.f();
        }
        d.b.h0.a.j0.c d2 = d.b.h0.a.j0.e.c().d();
        d.b.h0.a.j0.j.c k = d.b.h0.a.j0.j.c.k();
        k.h(7);
        d2.q(null, k.j());
    }

    @Override // d.b.h0.l.h.g
    public d.b.h0.l.h.a<a.C1052a> u() {
        return this.j;
    }

    @Override // d.b.h0.l.h.g
    public d.b.h0.l.h.c<d.b.h0.l.k.g> z() {
        return this.k;
    }

    public d(d.b.h0.a.e0.p.a aVar) {
        this.j = new b();
        this.k = new C0701d(this);
        this.f44864h = aVar;
        this.i = new Vector();
    }
}
