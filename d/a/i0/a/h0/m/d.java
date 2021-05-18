package d.a.i0.a.h0.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.a1.e;
import d.a.i0.a.v2.j0;
import d.a.i0.a.v2.q;
import d.a.i0.n.i.l.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d extends j {
    public static final boolean o = d.a.i0.a.k.f43025a;
    public static final boolean p;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.n.o.f f42147g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.a.h0.m.a f42148h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.i0.n.h.g> f42149i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.i0.n.f.a<a.C1067a> m;
    public d.a.i0.n.f.c<d.a.i0.n.h.g> n;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.a.i0.n.g.a.h().b(null, d.this.f42149i, null, null, null);
            if (b2) {
                for (d.a.i0.n.h.g gVar : d.this.f42149i) {
                    if (d.this.f42148h != null) {
                        d.this.f42148h.f(gVar);
                    }
                    d.this.W();
                }
            }
            if (d.o) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.f42149i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.i0.n.f.a<a.C1067a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1067a f42152e;

            public a(a.C1067a c1067a) {
                this.f42152e = c1067a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.V(this.f42152e)) {
                    d.this.W();
                    if (d.this.f42148h != null) {
                        d.this.f42148h.c(this.f42152e);
                    }
                    d.a.i0.a.h0.m.p.a.c(this.f42152e.f47910f.appId);
                }
                d.a.i0.a.n0.h.b.f(this.f42152e.f47906b);
            }
        }

        public b() {
        }

        @Override // d.a.i0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            if (pMSAppInfo.l()) {
                d.a.i0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return d.this.m(bundle, set);
        }

        @Override // d.a.i0.n.f.a
        public void o(a.C1067a c1067a, PMSAppInfo pMSAppInfo, d.a.i0.n.h.a aVar) {
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f47826a + ",msg: " + aVar.f47827b);
            if (d.this.f42148h != null) {
                d.this.f42148h.e(aVar);
            }
            if (aVar.f47826a != 1010) {
                d.this.k = true;
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1067a == null ? null : c1067a.f47910f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.X(pMSAppInfo2, pMSAppInfo);
            if (!d.a.i0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                return;
            }
            d.a.i0.a.h0.m.p.a.c(pMSAppInfo2.appId);
        }

        @Override // d.a.i0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            if (pMSAppInfo != null && pMSAppInfo.l()) {
                d.a.i0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
            d.this.X(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: q */
        public String d(a.C1067a c1067a) {
            if (c1067a == null) {
                return null;
            }
            int i2 = c1067a.f47907c;
            if (i2 == 0) {
                return d.a.i0.a.h0.m.r.a.g();
            }
            if (i2 == 1) {
                return d.a.i0.a.h0.m.r.a.i();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void e(a.C1067a c1067a, d.a.i0.n.h.a aVar) {
            super.e(c1067a, aVar);
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.a.i0.a.n0.h.b.f(c1067a.f47906b);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f47826a);
            aVar2.c("批量下载，主包下载失败：" + c1067a.f47906b);
            aVar2.e(aVar.toString());
            if (c1067a.f47905a != 0) {
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1067a.f47908d == null) {
            } else {
                d.this.f42147g.j(c1067a.f47908d);
                d.a.i0.a.h0.m.c.c().a(c1067a.f47908d, PMSDownloadType.BATCH, aVar2);
                d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1067a.f47908d.f47830a);
                d.a.i0.t.d.j(c1067a.f47908d.f47830a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: s */
        public void i(a.C1067a c1067a) {
            super.i(c1067a);
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1067a.f47908d.f47838i);
            d.this.l.add(c1067a.f47906b);
            a aVar = new a(c1067a);
            String str = c1067a.f47908d.f47836g + " 下载完成，执行签名校验-重命名-解压-DB";
            if (d.p) {
                ExecutorUtilsExt.postOnSerial(aVar, str);
            } else {
                q.j(aVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: t */
        public void a(a.C1067a c1067a) {
            super.a(c1067a);
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1067a.f47908d.f47831b + "/" + c1067a.f47908d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: u */
        public void c(a.C1067a c1067a) {
            super.c(c1067a);
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1067a.f47906b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: v */
        public void f(a.C1067a c1067a) {
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1067a.f47906b);
            }
            d.a.i0.a.n0.h.b.f(c1067a.f47906b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42155f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f42154e = pMSAppInfo;
            this.f42155f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f42154e;
            if (pMSAppInfo != null) {
                pMSAppInfo.o(d.this.I());
                this.f42155f.b(this.f42154e);
            } else {
                this.f42155f.o(d.this.I());
            }
            this.f42155f.k();
            if (d.a.i0.n.g.a.h().k(this.f42155f)) {
                d.a.i0.a.h0.m.r.a.n(this.f42155f);
            }
        }
    }

    /* renamed from: d.a.i0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0666d extends k<d> {
        public C0666d(d dVar) {
            super(dVar);
        }

        @Override // d.a.i0.a.h0.m.k
        public void p(@NonNull d.a.i0.n.h.g gVar, @Nullable d.a.i0.a.q2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.f42149i.add(gVar);
            } else if (d.o) {
                Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
            d.a.i0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void e(d.a.i0.n.h.g gVar, d.a.i0.n.h.a aVar) {
            super.q(gVar, aVar);
            d.a.i0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: u */
        public void f(d.a.i0.n.h.g gVar) {
            super.f(gVar);
            d.a.i0.a.n0.h.b.f(gVar.o);
        }
    }

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
        p = false;
    }

    public d() {
        this(null);
    }

    @Override // d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        super.B(aVar);
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.a.i0.a.h0.m.a aVar2 = this.f42148h;
        if (aVar2 != null) {
            aVar2.b(aVar.f47826a);
        }
    }

    @Override // d.a.i0.n.f.g
    public void C() {
        super.C();
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.a.i0.n.f.g
    public void D() {
        super.D();
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.a.i0.n.f.g
    public void E() {
        super.E();
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.a.i0.a.h0.m.a aVar = this.f42148h;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // d.a.i0.n.f.g
    public void F(d.a.i0.n.o.f fVar) {
        super.F(fVar);
        this.f42147g = fVar;
        d.a.i0.a.n0.h.b.e(fVar);
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
    }

    @Override // d.a.i0.a.h0.m.j
    public int J() {
        return 7;
    }

    public final boolean V(a.C1067a c1067a) {
        if (c1067a == null || c1067a.f47908d == null || c1067a.f47910f == null) {
            return false;
        }
        if (!j0.a(new File(c1067a.f47908d.f47830a), c1067a.f47908d.m)) {
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.a.i0.a.q2.a l = d.a.i0.a.h0.m.r.a.l(c1067a.f47908d, this);
        if (l != null) {
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
            return false;
        }
        c1067a.f47910f.k();
        d.a.i0.a.h0.m.r.a.j(c1067a.f47910f, c1067a.f47908d);
        c1067a.f47910f.o(I());
        if (!d.a.i0.n.g.a.h().a(c1067a.f47908d, c1067a.f47910f)) {
            d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f42147g.k(c1067a.f47908d);
        if (!c1067a.f47911g) {
            d.a.i0.a.h0.m.r.a.n(c1067a.f47910f);
        }
        d.a.i0.a.h0.m.r.a.b(c1067a.f47908d);
        d.a.i0.n.h.f fVar = c1067a.f47908d;
        if (fVar != null) {
            d.a.i0.a.a2.n.d.c(e.C0550e.i(fVar.f47836g, String.valueOf(fVar.f47838i)).getAbsolutePath(), true);
        }
        d.a.i0.n.h.f fVar2 = c1067a.f47908d;
        if (fVar2 != null && fVar2.f47837h == 0) {
            d.a.i0.a.h0.l.g.n.a i2 = d.a.i0.a.h0.l.g.n.a.i();
            d.a.i0.n.h.f fVar3 = c1067a.f47908d;
            i2.f(fVar3.f47836g, fVar3.f47838i);
        }
        return true;
    }

    public final void W() {
        d.a.i0.a.h0.m.a aVar;
        int incrementAndGet = this.j.incrementAndGet();
        int l = this.f42147g.l();
        if (o) {
            Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
        }
        if (incrementAndGet != l || this.k || (aVar = this.f42148h) == null) {
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

    @Override // d.a.i0.n.f.g, d.a.i0.n.f.d
    public void b() {
        super.b();
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (o) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.f42149i.isEmpty()) {
            q.j(new a(), "SwanAppBatchDownloadCallback");
        }
        d.a.i0.a.h0.m.a aVar = this.f42148h;
        if (aVar != null) {
            aVar.g();
        }
        if (d.a.i0.a.n0.h.c.a()) {
            return;
        }
        d.a.i0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
        d.a.i0.a.n0.d d2 = d.a.i0.a.n0.f.c().d();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
        d.a.i0.a.n0.l.c l = d.a.i0.a.n0.l.c.l();
        l.i(7);
        d2.t(copyOnWriteArraySet, false, l.k());
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.a<a.C1067a> u() {
        return this.m;
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<d.a.i0.n.h.g> z() {
        return this.n;
    }

    public d(d.a.i0.a.h0.m.a aVar) {
        this.m = new b();
        this.n = new C0666d(this);
        this.f42148h = aVar;
        this.f42149i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
