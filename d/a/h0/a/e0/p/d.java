package d.a.h0.a.e0.p;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.i2.e0;
import d.a.h0.a.i2.p;
import d.a.h0.l.l.j.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes2.dex */
public class d extends j {
    public static final boolean l = d.a.h0.a.k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.l.r.f f42164g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.a.e0.p.a f42165h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.h0.l.k.g> f42166i;
    public d.a.h0.l.h.a<a.C0991a> j;
    public d.a.h0.l.h.c<d.a.h0.l.k.g> k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.a.h0.l.i.a.h().b(null, d.this.f42166i, null, null, null);
            if (b2 && d.this.f42165h != null) {
                for (d.a.h0.l.k.g gVar : d.this.f42166i) {
                    d.this.f42165h.e(gVar);
                }
            }
            if (d.l) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.f42166i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.h0.l.h.a<a.C0991a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C0991a f42169e;

            public a(a.C0991a c0991a) {
                this.f42169e = c0991a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.R(this.f42169e)) {
                    if (d.this.f42165h != null) {
                        d.this.f42165h.b(this.f42169e);
                    }
                    d.a.h0.a.e0.p.p.a.c(this.f42169e.f47215f.appId);
                }
            }
        }

        public b() {
        }

        @Override // d.a.h0.l.h.a
        public void l(a.C0991a c0991a, PMSAppInfo pMSAppInfo, d.a.h0.l.k.a aVar) {
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f47144a + ",msg: " + aVar.f47145b);
            if (d.this.f42165h != null) {
                d.this.f42165h.d(aVar);
            }
            if (aVar == null || aVar.f47144a != 1010) {
                return;
            }
            PMSAppInfo pMSAppInfo2 = c0991a == null ? null : c0991a.f47215f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.S(pMSAppInfo2, pMSAppInfo);
            if (d.a.h0.a.e0.p.p.a.m(aVar)) {
                d.a.h0.a.e0.p.p.a.c(pMSAppInfo2.appId);
            }
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return d.this.m(bundle, set);
        }

        @Override // d.a.h0.l.h.a
        public void o(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            d.this.S(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: p */
        public String e(a.C0991a c0991a) {
            if (c0991a == null) {
                return null;
            }
            int i2 = c0991a.f47212c;
            if (i2 == 0) {
                return d.a.h0.a.e0.p.r.a.g();
            }
            if (i2 == 1) {
                return d.a.h0.a.e0.p.r.a.j();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void f(a.C0991a c0991a, d.a.h0.l.k.a aVar) {
            super.f(c0991a, aVar);
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(11L);
            aVar2.h((long) aVar.f47144a);
            aVar2.c("批量下载，主包下载失败：" + c0991a.f47211b);
            aVar2.e(aVar.toString());
            if (c0991a.f47210a != 0) {
                if (d.l) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c0991a.f47213d == null) {
            } else {
                d.this.f42164g.i(c0991a.f47213d);
                d.a.h0.a.e0.p.c.c().a(c0991a.f47213d, PMSDownloadType.BATCH, aVar2);
                d.a.h0.p.d.g(c0991a.f47213d.f47147a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void i(a.C0991a c0991a) {
            super.i(c0991a);
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c0991a.f47213d.f47155i);
            a aVar = new a(c0991a);
            p.k(aVar, c0991a.f47213d.f47153g + " 下载完成，执行签名校验-重命名-解压-DB");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: s */
        public void a(a.C0991a c0991a) {
            super.a(c0991a);
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c0991a.f47213d.f47148b + "/" + c0991a.f47213d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: t */
        public void d(a.C0991a c0991a) {
            super.d(c0991a);
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c0991a.f47211b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: u */
        public void g(a.C0991a c0991a) {
            if (d.l) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c0991a.f47211b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42172f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f42171e = pMSAppInfo;
            this.f42172f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f42171e;
            if (pMSAppInfo != null) {
                pMSAppInfo.n(d.this.I());
                this.f42172f.b(this.f42171e);
            } else {
                this.f42172f.n(d.this.I());
            }
            this.f42172f.k();
            if (d.a.h0.l.i.a.h().k(this.f42172f)) {
                d.a.h0.a.e0.p.r.a.o(this.f42172f);
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0640d extends k<d> {
        public C0640d(d dVar) {
            super(dVar);
        }

        @Override // d.a.h0.a.e0.p.k
        public void p(@NonNull d.a.h0.l.k.g gVar, @Nullable d.a.h0.a.f2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.f42166i.add(gVar);
            } else if (d.l) {
                Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
        }
    }

    public d() {
        this(null);
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.a.h0.a.e0.p.a aVar2 = this.f42165h;
        if (aVar2 != null) {
            aVar2.a(aVar.f47144a);
        }
    }

    @Override // d.a.h0.l.h.g
    public void C() {
        super.C();
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        super.D();
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.a.h0.a.e0.p.a aVar = this.f42165h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // d.a.h0.l.h.g
    public void F(d.a.h0.l.r.f fVar) {
        super.F(fVar);
        this.f42164g = fVar;
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.k());
    }

    @Override // d.a.h0.a.e0.p.j
    public int J() {
        return 7;
    }

    public final boolean R(a.C0991a c0991a) {
        if (c0991a == null || c0991a.f47213d == null || c0991a.f47215f == null) {
            return false;
        }
        if (!e0.a(new File(c0991a.f47213d.f47147a), c0991a.f47213d.m)) {
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.a.h0.a.f2.a m = d.a.h0.a.e0.p.r.a.m(c0991a.f47213d, this);
        if (m != null) {
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
            return false;
        }
        c0991a.f47215f.k();
        d.a.h0.a.e0.p.r.a.k(c0991a.f47215f, c0991a.f47213d);
        c0991a.f47215f.n(I());
        if (!d.a.h0.l.i.a.h().a(c0991a.f47213d, c0991a.f47215f)) {
            d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f42164g.j(c0991a.f47213d);
        if (!c0991a.f47216g) {
            d.a.h0.a.e0.p.r.a.o(c0991a.f47215f);
        }
        d.a.h0.a.e0.p.r.a.b(c0991a.f47213d);
        return true;
    }

    public final void S(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo == null) {
            return;
        }
        p.k(new c(pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // d.a.h0.l.h.g, d.a.h0.l.h.d
    public void c() {
        super.c();
        d.a.h0.a.c0.c.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (l) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.f42166i.isEmpty()) {
            p.k(new a(), "SwanAppBatchDownloadCallback");
        }
        d.a.h0.a.e0.p.a aVar = this.f42165h;
        if (aVar != null) {
            aVar.f();
        }
        d.a.h0.a.j0.c d2 = d.a.h0.a.j0.e.c().d();
        d.a.h0.a.j0.j.c k = d.a.h0.a.j0.j.c.k();
        k.h(7);
        d2.q(null, k.j());
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.a<a.C0991a> u() {
        return this.j;
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<d.a.h0.l.k.g> z() {
        return this.k;
    }

    public d(d.a.h0.a.e0.p.a aVar) {
        this.j = new b();
        this.k = new C0640d(this);
        this.f42165h = aVar;
        this.f42166i = new Vector();
    }
}
