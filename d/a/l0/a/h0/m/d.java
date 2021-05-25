package d.a.l0.a.h0.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.v2.j0;
import d.a.l0.a.v2.q;
import d.a.l0.n.i.l.a;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d extends j {
    public static final boolean o = d.a.l0.a.k.f43199a;
    public static final boolean p;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.n.o.f f42321g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.h0.m.a f42322h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.l0.n.h.g> f42323i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.l0.n.f.a<a.C1078a> m;
    public d.a.l0.n.f.c<d.a.l0.n.h.g> n;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.a.l0.n.g.a.h().b(null, d.this.f42323i, null, null, null);
            if (b2) {
                for (d.a.l0.n.h.g gVar : d.this.f42323i) {
                    if (d.this.f42322h != null) {
                        d.this.f42322h.f(gVar);
                    }
                    d.this.W();
                }
            }
            if (d.o) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.f42323i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.l0.n.f.a<a.C1078a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1078a f42326e;

            public a(a.C1078a c1078a) {
                this.f42326e = c1078a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.V(this.f42326e)) {
                    d.this.W();
                    if (d.this.f42322h != null) {
                        d.this.f42322h.c(this.f42326e);
                    }
                    d.a.l0.a.h0.m.p.a.c(this.f42326e.f48086f.appId);
                }
                d.a.l0.a.n0.h.b.f(this.f42326e.f48082b);
            }
        }

        public b() {
        }

        @Override // d.a.l0.n.f.a
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            if (pMSAppInfo.l()) {
                d.a.l0.a.c2.f.g0.a.h(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // d.a.l0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return d.this.m(bundle, set);
        }

        @Override // d.a.l0.n.f.a
        public void o(a.C1078a c1078a, PMSAppInfo pMSAppInfo, d.a.l0.n.h.a aVar) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f48002a + ",msg: " + aVar.f48003b);
            if (d.this.f42322h != null) {
                d.this.f42322h.e(aVar);
            }
            if (aVar.f48002a != 1010) {
                d.this.k = true;
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1078a == null ? null : c1078a.f48086f;
            if (pMSAppInfo2 == null) {
                pMSAppInfo2 = pMSAppInfo;
            }
            d.this.X(pMSAppInfo2, pMSAppInfo);
            if (!d.a.l0.a.h0.m.p.a.m(aVar) || pMSAppInfo2 == null) {
                return;
            }
            d.a.l0.a.h0.m.p.a.c(pMSAppInfo2.appId);
        }

        @Override // d.a.l0.n.f.a
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            if (pMSAppInfo != null && pMSAppInfo.l()) {
                d.a.l0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
            d.this.X(pMSAppInfo, pMSAppInfo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.c
        /* renamed from: q */
        public String d(a.C1078a c1078a) {
            if (c1078a == null) {
                return null;
            }
            int i2 = c1078a.f48083c;
            if (i2 == 0) {
                return d.a.l0.a.h0.m.r.a.g();
            }
            if (i2 == 1) {
                return d.a.l0.a.h0.m.r.a.i();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: r */
        public void e(a.C1078a c1078a, d.a.l0.n.h.a aVar) {
            super.e(c1078a, aVar);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.a.l0.a.n0.h.b.f(c1078a.f48082b);
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f48002a);
            aVar2.c("批量下载，主包下载失败：" + c1078a.f48082b);
            aVar2.e(aVar.toString());
            if (c1078a.f48081a != 0) {
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1078a.f48084d == null) {
            } else {
                d.this.f42321g.j(c1078a.f48084d);
                d.a.l0.a.h0.m.c.c().a(c1078a.f48084d, PMSDownloadType.BATCH, aVar2);
                d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1078a.f48084d.f48006a);
                d.a.l0.t.d.j(c1078a.f48084d.f48006a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: s */
        public void i(a.C1078a c1078a) {
            super.i(c1078a);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1078a.f48084d.f48014i);
            d.this.l.add(c1078a.f48082b);
            a aVar = new a(c1078a);
            String str = c1078a.f48084d.f48012g + " 下载完成，执行签名校验-重命名-解压-DB";
            if (d.p) {
                ExecutorUtilsExt.postOnSerial(aVar, str);
            } else {
                q.j(aVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: t */
        public void a(a.C1078a c1078a) {
            super.a(c1078a);
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1078a.f48084d.f48007b + "/" + c1078a.f48084d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: u */
        public void c(a.C1078a c1078a) {
            super.c(c1078a);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1078a.f48082b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: v */
        public void f(a.C1078a c1078a) {
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1078a.f48082b);
            }
            d.a.l0.a.n0.h.b.f(c1078a.f48082b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f42329f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f42328e = pMSAppInfo;
            this.f42329f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f42328e;
            if (pMSAppInfo != null) {
                pMSAppInfo.o(d.this.I());
                this.f42329f.b(this.f42328e);
            } else {
                this.f42329f.o(d.this.I());
            }
            this.f42329f.k();
            if (d.a.l0.n.g.a.h().k(this.f42329f)) {
                d.a.l0.a.h0.m.r.a.n(this.f42329f);
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0677d extends k<d> {
        public C0677d(d dVar) {
            super(dVar);
        }

        @Override // d.a.l0.a.h0.m.k
        public void p(@NonNull d.a.l0.n.h.g gVar, @Nullable d.a.l0.a.q2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.f42323i.add(gVar);
            } else if (d.o) {
                Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + gVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar);
            }
            d.a.l0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: q */
        public void e(d.a.l0.n.h.g gVar, d.a.l0.n.h.a aVar) {
            super.q(gVar, aVar);
            d.a.l0.a.n0.h.b.f(gVar.o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: u */
        public void f(d.a.l0.n.h.g gVar) {
            super.f(gVar);
            d.a.l0.a.n0.h.b.f(gVar.o);
        }
    }

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_task_serial", false);
        p = false;
    }

    public d() {
        this(null);
    }

    @Override // d.a.l0.n.f.g
    public void B(d.a.l0.n.h.a aVar) {
        super.B(aVar);
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchError: " + aVar.toString());
        d.a.l0.a.h0.m.a aVar2 = this.f42322h;
        if (aVar2 != null) {
            aVar2.b(aVar.f48002a);
        }
    }

    @Override // d.a.l0.n.f.g
    public void C() {
        super.C();
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchStart");
    }

    @Override // d.a.l0.n.f.g
    public void D() {
        super.D();
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFetchSuccess");
    }

    @Override // d.a.l0.n.f.g
    public void E() {
        super.E();
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onNoPackage");
        d.a.l0.a.h0.m.a aVar = this.f42322h;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // d.a.l0.n.f.g
    public void F(d.a.l0.n.o.f fVar) {
        super.F(fVar);
        this.f42321g = fVar;
        d.a.l0.a.n0.h.b.e(fVar);
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
    }

    @Override // d.a.l0.a.h0.m.j
    public int J() {
        return 7;
    }

    public final boolean V(a.C1078a c1078a) {
        if (c1078a == null || c1078a.f48084d == null || c1078a.f48086f == null) {
            return false;
        }
        if (!j0.a(new File(c1078a.f48084d.f48006a), c1078a.f48084d.m)) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.a.l0.a.q2.a l = d.a.l0.a.h0.m.r.a.l(c1078a.f48084d, this);
        if (l != null) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
            return false;
        }
        c1078a.f48086f.k();
        d.a.l0.a.h0.m.r.a.j(c1078a.f48086f, c1078a.f48084d);
        c1078a.f48086f.o(I());
        if (!d.a.l0.n.g.a.h().a(c1078a.f48084d, c1078a.f48086f)) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f42321g.k(c1078a.f48084d);
        if (!c1078a.f48087g) {
            d.a.l0.a.h0.m.r.a.n(c1078a.f48086f);
        }
        d.a.l0.a.h0.m.r.a.b(c1078a.f48084d);
        d.a.l0.n.h.f fVar = c1078a.f48084d;
        if (fVar != null) {
            d.a.l0.a.a2.n.d.c(e.C0561e.i(fVar.f48012g, String.valueOf(fVar.f48014i)).getAbsolutePath(), true);
        }
        d.a.l0.n.h.f fVar2 = c1078a.f48084d;
        if (fVar2 != null && fVar2.f48013h == 0) {
            d.a.l0.a.h0.l.g.n.a i2 = d.a.l0.a.h0.l.g.n.a.i();
            d.a.l0.n.h.f fVar3 = c1078a.f48084d;
            i2.f(fVar3.f48012g, fVar3.f48014i);
        }
        return true;
    }

    public final void W() {
        d.a.l0.a.h0.m.a aVar;
        int incrementAndGet = this.j.incrementAndGet();
        int l = this.f42321g.l();
        if (o) {
            Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
        }
        if (incrementAndGet != l || this.k || (aVar = this.f42322h) == null) {
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

    @Override // d.a.l0.n.f.g, d.a.l0.n.f.d
    public void b() {
        super.b();
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        if (o) {
            Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
        }
        if (!this.f42323i.isEmpty()) {
            q.j(new a(), "SwanAppBatchDownloadCallback");
        }
        d.a.l0.a.h0.m.a aVar = this.f42322h;
        if (aVar != null) {
            aVar.g();
        }
        if (d.a.l0.a.n0.h.c.a()) {
            return;
        }
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.l);
        d.a.l0.a.n0.d d2 = d.a.l0.a.n0.f.c().d();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.l;
        d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
        l.i(7);
        d2.t(copyOnWriteArraySet, false, l.k());
    }

    @Override // d.a.l0.n.f.g
    public d.a.l0.n.f.a<a.C1078a> u() {
        return this.m;
    }

    @Override // d.a.l0.n.f.g
    public d.a.l0.n.f.c<d.a.l0.n.h.g> z() {
        return this.n;
    }

    public d(d.a.l0.a.h0.m.a aVar) {
        this.m = new b();
        this.n = new C0677d(this);
        this.f42322h = aVar;
        this.f42323i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
