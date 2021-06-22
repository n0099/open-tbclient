package d.a.m0.a.h0.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a1.e;
import d.a.m0.a.v2.j0;
import d.a.m0.a.v2.q;
import d.a.m0.n.i.l.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class d extends j {
    public static final boolean o = d.a.m0.a.k.f46983a;
    public static final boolean p;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.n.o.f f46105g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.a.h0.m.a f46106h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.m0.n.h.g> f46107i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.m0.n.f.a<a.C1137a> m;
    public d.a.m0.n.f.c<d.a.m0.n.h.g> n;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.a.m0.n.g.a.h().b(null, d.this.f46107i, null, null, null);
            if (b2) {
                for (d.a.m0.n.h.g gVar : d.this.f46107i) {
                    if (d.this.f46106h != null) {
                        d.this.f46106h.f(gVar);
                    }
                    d.this.W();
                }
            }
            if (d.o) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.f46107i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.n.f.a<a.C1137a> {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1137a f46110e;

            public a(a.C1137a c1137a) {
                this.f46110e = c1137a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.V(this.f46110e)) {
                    d.this.W();
                    if (d.this.f46106h != null) {
                        d.this.f46106h.c(this.f46110e);
                    }
                    d.a.m0.a.h0.m.p.a.c(this.f46110e.f51868f.appId);
                }
                d.a.m0.a.n0.h.b.f(this.f46110e.f51864b);
            }
        }

        public b() {
        }

        @Override // d.a.m0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            if (pMSAppInfo.l()) {
                d.a.m0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return d.this.m(bundle, set);
        }

        @Override // d.a.m0.n.f.a
        public void o(a.C1137a c1137a, PMSAppInfo pMSAppInfo, d.a.m0.n.h.a aVar) {
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f51784a + ",msg: " + aVar.f51785b);
            if (d.this.f46106h != null) {
                d.this.f46106h.e(aVar);
            }
            if (aVar.f51784a != 1010) {
                d.this.k = true;
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1137a == null ? null : c1137a.f51868f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.X(pMSAppInfo2, pMSAppInfo);
            if (!d.a.m0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                return;
            }
            d.a.m0.a.h0.m.p.a.c(pMSAppInfo2.appId);
        }

        @Override // d.a.m0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            if (pMSAppInfo != null && pMSAppInfo.l()) {
                d.a.m0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
            d.this.X(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: q */
        public String d(a.C1137a c1137a) {
            if (c1137a == null) {
                return null;
            }
            int i2 = c1137a.f51865c;
            if (i2 == 0) {
                return d.a.m0.a.h0.m.r.a.g();
            }
            if (i2 == 1) {
                return d.a.m0.a.h0.m.r.a.i();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void e(a.C1137a c1137a, d.a.m0.n.h.a aVar) {
            super.e(c1137a, aVar);
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.a.m0.a.n0.h.b.f(c1137a.f51864b);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f51784a);
            aVar2.c("批量下载，主包下载失败：" + c1137a.f51864b);
            aVar2.e(aVar.toString());
            if (c1137a.f51863a != 0) {
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1137a.f51866d == null) {
            } else {
                d.this.f46105g.j(c1137a.f51866d);
                d.a.m0.a.h0.m.c.c().a(c1137a.f51866d, PMSDownloadType.BATCH, aVar2);
                d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1137a.f51866d.f51788a);
                d.a.m0.t.d.j(c1137a.f51866d.f51788a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: s */
        public void i(a.C1137a c1137a) {
            super.i(c1137a);
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1137a.f51866d.f51796i);
            d.this.l.add(c1137a.f51864b);
            a aVar = new a(c1137a);
            String str = c1137a.f51866d.f51794g + " 下载完成，执行签名校验-重命名-解压-DB";
            if (d.p) {
                ExecutorUtilsExt.postOnSerial(aVar, str);
            } else {
                q.j(aVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: t */
        public void a(a.C1137a c1137a) {
            super.a(c1137a);
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1137a.f51866d.f51789b + "/" + c1137a.f51866d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: u */
        public void c(a.C1137a c1137a) {
            super.c(c1137a);
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1137a.f51864b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: v */
        public void f(a.C1137a c1137a) {
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1137a.f51864b);
            }
            d.a.m0.a.n0.h.b.f(c1137a.f51864b);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46113f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f46112e = pMSAppInfo;
            this.f46113f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f46112e;
            if (pMSAppInfo != null) {
                pMSAppInfo.o(d.this.I());
                this.f46113f.b(this.f46112e);
            } else {
                this.f46113f.o(d.this.I());
            }
            this.f46113f.k();
            if (d.a.m0.n.g.a.h().k(this.f46113f)) {
                d.a.m0.a.h0.m.r.a.n(this.f46113f);
            }
        }
    }

    /* renamed from: d.a.m0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0736d extends k<d> {
        public C0736d(d dVar) {
            super(dVar);
        }

        @Override // d.a.m0.a.h0.m.k
        public void p(@NonNull d.a.m0.n.h.g gVar, @Nullable d.a.m0.a.q2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.f46107i.add(gVar);
            } else if (d.o) {
                Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
            d.a.m0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void e(d.a.m0.n.h.g gVar, d.a.m0.n.h.a aVar) {
            super.q(gVar, aVar);
            d.a.m0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: u */
        public void f(d.a.m0.n.h.g gVar) {
            super.f(gVar);
            d.a.m0.a.n0.h.b.f(gVar.o);
        }
    }

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
        p = false;
    }

    public d() {
        this(null);
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        super.B(aVar);
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.a.m0.a.h0.m.a aVar2 = this.f46106h;
        if (aVar2 != null) {
            aVar2.b(aVar.f51784a);
        }
    }

    @Override // d.a.m0.n.f.g
    public void C() {
        super.C();
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.a.m0.n.f.g
    public void D() {
        super.D();
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.a.m0.a.h0.m.a aVar = this.f46106h;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // d.a.m0.n.f.g
    public void F(d.a.m0.n.o.f fVar) {
        super.F(fVar);
        this.f46105g = fVar;
        d.a.m0.a.n0.h.b.e(fVar);
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
    }

    @Override // d.a.m0.a.h0.m.j
    public int J() {
        return 7;
    }

    public final boolean V(a.C1137a c1137a) {
        if (c1137a == null || c1137a.f51866d == null || c1137a.f51868f == null) {
            return false;
        }
        if (!j0.a(new File(c1137a.f51866d.f51788a), c1137a.f51866d.m)) {
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.a.m0.a.q2.a l = d.a.m0.a.h0.m.r.a.l(c1137a.f51866d, this);
        if (l != null) {
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
            return false;
        }
        c1137a.f51868f.k();
        d.a.m0.a.h0.m.r.a.j(c1137a.f51868f, c1137a.f51866d);
        c1137a.f51868f.o(I());
        if (!d.a.m0.n.g.a.h().a(c1137a.f51866d, c1137a.f51868f)) {
            d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f46105g.k(c1137a.f51866d);
        if (!c1137a.f51869g) {
            d.a.m0.a.h0.m.r.a.n(c1137a.f51868f);
        }
        d.a.m0.a.h0.m.r.a.b(c1137a.f51866d);
        d.a.m0.n.h.f fVar = c1137a.f51866d;
        if (fVar != null) {
            d.a.m0.a.a2.n.d.c(e.C0620e.i(fVar.f51794g, String.valueOf(fVar.f51796i)).getAbsolutePath(), true);
        }
        d.a.m0.n.h.f fVar2 = c1137a.f51866d;
        if (fVar2 != null && fVar2.f51795h == 0) {
            d.a.m0.a.h0.l.g.n.a i2 = d.a.m0.a.h0.l.g.n.a.i();
            d.a.m0.n.h.f fVar3 = c1137a.f51866d;
            i2.f(fVar3.f51794g, fVar3.f51796i);
        }
        return true;
    }

    public final void W() {
        d.a.m0.a.h0.m.a aVar;
        int incrementAndGet = this.j.incrementAndGet();
        int l = this.f46105g.l();
        if (o) {
            Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
        }
        if (incrementAndGet != l || this.k || (aVar = this.f46106h) == null) {
            return;
        }
        aVar.a();
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        if (pMSAppInfo == null) {
            return;
        }
        q.j(new c(pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // d.a.m0.n.f.g, d.a.m0.n.f.d
    public void b() {
        super.b();
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (o) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.f46107i.isEmpty()) {
            q.j(new a(), "SwanAppBatchDownloadCallback");
        }
        d.a.m0.a.h0.m.a aVar = this.f46106h;
        if (aVar != null) {
            aVar.g();
        }
        if (d.a.m0.a.n0.h.c.a()) {
            return;
        }
        d.a.m0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
        d.a.m0.a.n0.d d2 = d.a.m0.a.n0.f.c().d();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
        d.a.m0.a.n0.l.c l = d.a.m0.a.n0.l.c.l();
        l.i(7);
        d2.t(copyOnWriteArraySet, false, l.k());
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.a<a.C1137a> u() {
        return this.m;
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<d.a.m0.n.h.g> z() {
        return this.n;
    }

    public d(d.a.m0.a.h0.m.a aVar) {
        this.m = new b();
        this.n = new C0736d(this);
        this.f46106h = aVar;
        this.f46107i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
