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
    public static final boolean o = d.a.l0.a.k.f46875a;
    public static final boolean p;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.n.o.f f45997g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.h0.m.a f45998h;

    /* renamed from: i  reason: collision with root package name */
    public final List<d.a.l0.n.h.g> f45999i;
    public AtomicInteger j;
    public boolean k;
    public final CopyOnWriteArraySet<String> l;
    public d.a.l0.n.f.a<a.C1134a> m;
    public d.a.l0.n.f.c<d.a.l0.n.h.g> n;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean b2 = d.a.l0.n.g.a.h().b(null, d.this.f45999i, null, null, null);
            if (b2) {
                for (d.a.l0.n.h.g gVar : d.this.f45999i) {
                    if (d.this.f45998h != null) {
                        d.this.f45998h.f(gVar);
                    }
                    d.this.W();
                }
            }
            if (d.o) {
                Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b2 + ", size=" + d.this.f45999i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.l0.n.f.a<a.C1134a> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a.C1134a f46002e;

            public a(a.C1134a c1134a) {
                this.f46002e = c1134a;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.V(this.f46002e)) {
                    d.this.W();
                    if (d.this.f45998h != null) {
                        d.this.f45998h.c(this.f46002e);
                    }
                    d.a.l0.a.h0.m.p.a.c(this.f46002e.f51760f.appId);
                }
                d.a.l0.a.n0.h.b.f(this.f46002e.f51756b);
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
        public void o(a.C1134a c1134a, PMSAppInfo pMSAppInfo, d.a.l0.n.h.a aVar) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onSingleFetchError: " + aVar.f51676a + ",msg: " + aVar.f51677b);
            if (d.this.f45998h != null) {
                d.this.f45998h.e(aVar);
            }
            if (aVar.f51676a != 1010) {
                d.this.k = true;
                return;
            }
            PMSAppInfo pMSAppInfo2 = c1134a == null ? null : c1134a.f51760f;
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
        public String d(a.C1134a c1134a) {
            if (c1134a == null) {
                return null;
            }
            int i2 = c1134a.f51757c;
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
        public void e(a.C1134a c1134a, d.a.l0.n.h.a aVar) {
            super.e(c1134a, aVar);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadError：" + aVar.toString());
            d.a.l0.a.n0.h.b.f(c1134a.f51756b);
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(11L);
            aVar2.h(aVar.f51676a);
            aVar2.c("批量下载，主包下载失败：" + c1134a.f51756b);
            aVar2.e(aVar.toString());
            if (c1134a.f51755a != 0) {
                if (d.o) {
                    Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + aVar2.toString());
                }
            } else if (c1134a.f51758d == null) {
            } else {
                d.this.f45997g.j(c1134a.f51758d);
                d.a.l0.a.h0.m.c.c().a(c1134a.f51758d, PMSDownloadType.BATCH, aVar2);
                d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "#onDownloadError del: " + c1134a.f51758d.f51680a);
                d.a.l0.t.d.j(c1134a.f51758d.f51680a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: s */
        public void i(a.C1134a c1134a) {
            super.i(c1134a);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onFileDownloaded: " + c1134a.f51758d.f51688i);
            d.this.l.add(c1134a.f51756b);
            a aVar = new a(c1134a);
            String str = c1134a.f51758d.f51686g + " 下载完成，执行签名校验-重命名-解压-DB";
            if (d.p) {
                ExecutorUtilsExt.postOnSerial(aVar, str);
            } else {
                q.j(aVar, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: t */
        public void a(a.C1134a c1134a) {
            super.a(c1134a);
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + c1134a.f51758d.f51681b + "/" + c1134a.f51758d.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: u */
        public void c(a.C1134a c1134a) {
            super.c(c1134a);
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onDownloadStart: " + c1134a.f51756b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: v */
        public void f(a.C1134a c1134a) {
            if (d.o) {
                Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + c1134a.f51756b);
            }
            d.a.l0.a.n0.h.b.f(c1134a.f51756b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f46005f;

        public c(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            this.f46004e = pMSAppInfo;
            this.f46005f = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PMSAppInfo pMSAppInfo = this.f46004e;
            if (pMSAppInfo != null) {
                pMSAppInfo.o(d.this.I());
                this.f46005f.b(this.f46004e);
            } else {
                this.f46005f.o(d.this.I());
            }
            this.f46005f.k();
            if (d.a.l0.n.g.a.h().k(this.f46005f)) {
                d.a.l0.a.h0.m.r.a.n(this.f46005f);
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0733d extends k<d> {
        public C0733d(d dVar) {
            super(dVar);
        }

        @Override // d.a.l0.a.h0.m.k
        public void p(@NonNull d.a.l0.n.h.g gVar, @Nullable d.a.l0.a.q2.a aVar) {
            super.p(gVar, aVar);
            if (aVar == null) {
                d.this.f45999i.add(gVar);
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
        d.a.l0.a.h0.m.a aVar2 = this.f45998h;
        if (aVar2 != null) {
            aVar2.b(aVar.f51676a);
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
        d.a.l0.a.h0.m.a aVar = this.f45998h;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // d.a.l0.n.f.g
    public void F(d.a.l0.n.o.f fVar) {
        super.F(fVar);
        this.f45997g = fVar;
        d.a.l0.a.n0.h.b.e(fVar);
        d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onPrepareDownload: " + fVar.l());
    }

    @Override // d.a.l0.a.h0.m.j
    public int J() {
        return 7;
    }

    public final boolean V(a.C1134a c1134a) {
        if (c1134a == null || c1134a.f51758d == null || c1134a.f51760f == null) {
            return false;
        }
        if (!j0.a(new File(c1134a.f51758d.f51680a), c1134a.f51758d.m)) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
            return false;
        }
        d.a.l0.a.q2.a l = d.a.l0.a.h0.m.r.a.l(c1134a.f51758d, this);
        if (l != null) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + l);
            return false;
        }
        c1134a.f51760f.k();
        d.a.l0.a.h0.m.r.a.j(c1134a.f51760f, c1134a.f51758d);
        c1134a.f51760f.o(I());
        if (!d.a.l0.n.g.a.h().a(c1134a.f51758d, c1134a.f51760f)) {
            d.a.l0.a.e0.d.h("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
            return false;
        }
        this.f45997g.k(c1134a.f51758d);
        if (!c1134a.f51761g) {
            d.a.l0.a.h0.m.r.a.n(c1134a.f51760f);
        }
        d.a.l0.a.h0.m.r.a.b(c1134a.f51758d);
        d.a.l0.n.h.f fVar = c1134a.f51758d;
        if (fVar != null) {
            d.a.l0.a.a2.n.d.c(e.C0617e.i(fVar.f51686g, String.valueOf(fVar.f51688i)).getAbsolutePath(), true);
        }
        d.a.l0.n.h.f fVar2 = c1134a.f51758d;
        if (fVar2 != null && fVar2.f51687h == 0) {
            d.a.l0.a.h0.l.g.n.a i2 = d.a.l0.a.h0.l.g.n.a.i();
            d.a.l0.n.h.f fVar3 = c1134a.f51758d;
            i2.f(fVar3.f51686g, fVar3.f51688i);
        }
        return true;
    }

    public final void W() {
        d.a.l0.a.h0.m.a aVar;
        int incrementAndGet = this.j.incrementAndGet();
        int l = this.f45997g.l();
        if (o) {
            Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + l + ",success num - " + incrementAndGet);
        }
        if (incrementAndGet != l || this.k || (aVar = this.f45998h) == null) {
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
        if (!this.f45999i.isEmpty()) {
            q.j(new a(), "SwanAppBatchDownloadCallback");
        }
        d.a.l0.a.h0.m.a aVar = this.f45998h;
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
    public d.a.l0.n.f.a<a.C1134a> u() {
        return this.m;
    }

    @Override // d.a.l0.n.f.g
    public d.a.l0.n.f.c<d.a.l0.n.h.g> z() {
        return this.n;
    }

    public d(d.a.l0.a.h0.m.a aVar) {
        this.m = new b();
        this.n = new C0733d(this);
        this.f45998h = aVar;
        this.f45999i = new Vector();
        this.j = new AtomicInteger(0);
        this.l = new CopyOnWriteArraySet<>();
    }
}
