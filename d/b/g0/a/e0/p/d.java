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
    public static final boolean l = d.b.g0.a.k.f45051a;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.l.r.f f44142g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.e0.p.a f44143h;
    public final List<d.b.g0.l.k.g> i;
    public d.b.g0.l.h.a<a.C1020a> j;
    public d.b.g0.l.h.c<d.b.g0.l.k.g> k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.b.g0.l.i.a.h().b(null, d.this.i, null, null, null);
            if (b2 && d.this.f44143h != null) {
                for (d.b.g0.l.k.g gVar : d.this.i) {
                    d.this.f44143h.e(gVar);
                }
            }
            if (d.l) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.l.h.a<a.C1020a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1020a f44146e;

            public a(a.C1020a c1020a) {
                this.f44146e = c1020a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.S(this.f44146e)) {
                    if (d.this.f44143h != null) {
                        d.this.f44143h.b(this.f44146e);
                    }
                    d.b.g0.a.e0.p.p.a.c(this.f44146e.f48982f.appId);
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
        public void m(a.C1020a c1020a, PMSAppInfo pMSAppInfo, d.b.g0.l.k.a aVar) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f48914a + ",msg: " + aVar.f48915b);
            if (d.this.f44143h != null) {
                d.this.f44143h.d(aVar);
            }
            if (aVar == null || aVar.f48914a != 1010) {
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1020a == null ? null : c1020a.f48982f;
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
        public String j(a.C1020a c1020a) {
            if (c1020a == null) {
                return null;
            }
            int i = c1020a.f48979c;
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
        public void l(a.C1020a c1020a, d.b.g0.l.k.a aVar) {
            super.l(c1020a, aVar);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(11L);
            aVar2.h((long) aVar.f48914a);
            aVar2.c("批量下载，主包下载失败：" + c1020a.f48978b);
            aVar2.e(aVar.toString());
            if (c1020a.f48977a != 0) {
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1020a.f48980d == null) {
            } else {
                d.this.f44142g.i(c1020a.f48980d);
                d.b.g0.a.e0.p.c.c().a(c1020a.f48980d, PMSDownloadType.BATCH, aVar2);
                d.b.g0.p.d.g(c1020a.f48980d.f48917a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void b(a.C1020a c1020a) {
            super.b(c1020a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1020a.f48980d.i);
            a aVar = new a(c1020a);
            p.k(aVar, c1020a.f48980d.f48923g + " 下载完成，执行签名校验-重命名-解压-DB");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: s */
        public void a(a.C1020a c1020a) {
            super.a(c1020a);
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1020a.f48980d.f48918b + "/" + c1020a.f48980d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: t */
        public void i(a.C1020a c1020a) {
            super.i(c1020a);
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1020a.f48978b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: u */
        public void o(a.C1020a c1020a) {
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1020a.f48978b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f44149f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f44148e = pMSAppInfo;
            this.f44149f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f44148e;
            if (pMSAppInfo != null) {
                pMSAppInfo.n(d.this.J());
                this.f44149f.b(this.f44148e);
            } else {
                this.f44149f.n(d.this.J());
            }
            this.f44149f.k();
            if (d.b.g0.l.i.a.h().k(this.f44149f)) {
                d.b.g0.a.e0.p.r.a.o(this.f44149f);
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0669d extends k<d> {
        public C0669d(d dVar) {
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
        d.b.g0.a.e0.p.a aVar2 = this.f44143h;
        if (aVar2 != null) {
            aVar2.a(aVar.f48914a);
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
        d.b.g0.a.e0.p.a aVar = this.f44143h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // d.b.g0.l.h.g
    public void G(d.b.g0.l.r.f fVar) {
        super.G(fVar);
        this.f44142g = fVar;
        d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.k());
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 7;
    }

    public final boolean S(a.C1020a c1020a) {
        if (c1020a == null || c1020a.f48980d == null || c1020a.f48982f == null) {
            return false;
        }
        if (!e0.a(new File(c1020a.f48980d.f48917a), c1020a.f48980d.m)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.b.g0.a.f2.a m = d.b.g0.a.e0.p.r.a.m(c1020a.f48980d, this);
        if (m != null) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
            return false;
        }
        c1020a.f48982f.k();
        d.b.g0.a.e0.p.r.a.k(c1020a.f48982f, c1020a.f48980d);
        c1020a.f48982f.n(J());
        if (!d.b.g0.l.i.a.h().a(c1020a.f48980d, c1020a.f48982f)) {
            d.b.g0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f44142g.j(c1020a.f48980d);
        if (!c1020a.f48983g) {
            d.b.g0.a.e0.p.r.a.o(c1020a.f48982f);
        }
        d.b.g0.a.e0.p.r.a.b(c1020a.f48980d);
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
        d.b.g0.a.e0.p.a aVar = this.f44143h;
        if (aVar != null) {
            aVar.f();
        }
        d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
        d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
        k.h(7);
        d2.q(null, k.j());
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.a<a.C1020a> v() {
        return this.j;
    }

    public d(d.b.g0.a.e0.p.a aVar) {
        this.j = new b();
        this.k = new C0669d(this);
        this.f44143h = aVar;
        this.i = new Vector();
    }
}
