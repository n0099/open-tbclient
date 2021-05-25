package d.a.l0.a.h0.m.q;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.l0.a.a1.e;
import d.a.l0.a.h0.m.c;
import d.a.l0.a.h0.m.j;
import d.a.l0.a.k;
import d.a.l0.a.v2.j0;
import d.a.l0.n.f.c;
import d.a.l0.n.h.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends j {
    public static final boolean k = k.f43199a;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.h0.m.b f42407g;

    /* renamed from: h  reason: collision with root package name */
    public String f42408h;

    /* renamed from: i  reason: collision with root package name */
    public String f42409i;
    public c<g> j = new C0684a();

    /* renamed from: d.a.l0.a.h0.m.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0684a extends d.a.l0.n.f.b<g> {
        public C0684a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            return d.a.l0.a.h0.m.r.b.a(a.this.f42409i);
        }

        @Override // d.a.l0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: o */
        public void e(g gVar, d.a.l0.n.h.a aVar) {
            super.e(gVar, aVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f48002a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            a.this.R(3, aVar2);
            d.a.l0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            super.i(gVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.T(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.n.f.b, d.a.l0.n.f.c
        /* renamed from: q */
        public void f(g gVar) {
            super.f(gVar);
            if (a.k) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.U(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.InterfaceC0676c {
        public b() {
        }

        @Override // d.a.l0.a.h0.m.c.InterfaceC0676c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.S();
        }

        @Override // d.a.l0.a.h0.m.c.InterfaceC0676c
        public void b(PMSDownloadType pMSDownloadType, d.a.l0.a.q2.a aVar) {
            a.this.R(0, aVar);
        }
    }

    public a(String str, String str2, d.a.l0.a.h0.m.b bVar) {
        this.f42408h = str;
        this.f42407g = bVar;
        this.f42409i = e.C0561e.i(str, str2).getPath();
    }

    @Override // d.a.l0.n.f.g
    public void B(d.a.l0.n.h.a aVar) {
        super.B(aVar);
        d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
        aVar2.j(12L);
        aVar2.h(aVar.f48002a);
        aVar2.c(aVar.f48003b);
        aVar2.p(aVar.f48004c);
        R(1, aVar2);
    }

    @Override // d.a.l0.n.f.g
    public void E() {
        super.E();
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(12L);
        aVar.h(2901L);
        aVar.c("Server无包");
        R(2, aVar);
    }

    public final void R(int i2, d.a.l0.a.q2.a aVar) {
        d.a.l0.a.h0.m.b bVar = this.f42407g;
        if (bVar != null) {
            bVar.b(i2, aVar);
        }
    }

    public final void S() {
        d.a.l0.a.h0.m.b bVar = this.f42407g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void T(g gVar) {
        if (!j0.a(new File(gVar.f48006a), gVar.m)) {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            R(4, aVar);
            d.a.l0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.a.l0.a.h0.m.r.b.h(new File(gVar.f48006a), new File(this.f42409i, gVar.p))) {
            if (k) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.o = this.f42408h;
            d.a.l0.n.g.a.h().l(gVar);
            S();
            d.a.l0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            R(5, aVar2);
            d.a.l0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void U(g gVar) {
        d.a.l0.a.h0.m.c.c().d(gVar, new b());
    }

    @Override // d.a.l0.n.f.g
    public d.a.l0.n.f.c<g> z() {
        return this.j;
    }
}
