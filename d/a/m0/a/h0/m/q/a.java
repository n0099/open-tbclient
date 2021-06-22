package d.a.m0.a.h0.m.q;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.m0.a.a1.e;
import d.a.m0.a.h0.m.c;
import d.a.m0.a.h0.m.j;
import d.a.m0.a.k;
import d.a.m0.a.v2.j0;
import d.a.m0.n.f.c;
import d.a.m0.n.h.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean k = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.h0.m.b f46191g;

    /* renamed from: h  reason: collision with root package name */
    public String f46192h;

    /* renamed from: i  reason: collision with root package name */
    public String f46193i;
    public c<g> j = new C0743a();

    /* renamed from: d.a.m0.a.h0.m.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0743a extends d.a.m0.n.f.b<g> {
        public C0743a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            return d.a.m0.a.h0.m.r.b.a(a.this.f46193i);
        }

        @Override // d.a.m0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: o */
        public void e(g gVar, d.a.m0.n.h.a aVar) {
            super.e(gVar, aVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f51784a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            a.this.R(3, aVar2);
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            super.i(gVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.T(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void f(g gVar) {
            super.f(gVar);
            if (a.k) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.U(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC0735c {
        public b() {
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.S();
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            a.this.R(0, aVar);
        }
    }

    public a(String str, String str2, d.a.m0.a.h0.m.b bVar) {
        this.f46192h = str;
        this.f46191g = bVar;
        this.f46193i = e.C0620e.i(str, str2).getPath();
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        super.B(aVar);
        d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
        aVar2.j(12L);
        aVar2.h(aVar.f51784a);
        aVar2.c(aVar.f51785b);
        aVar2.p(aVar.f51786c);
        R(1, aVar2);
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(12L);
        aVar.h(2901L);
        aVar.c("Server无包");
        R(2, aVar);
    }

    public final void R(int i2, d.a.m0.a.q2.a aVar) {
        d.a.m0.a.h0.m.b bVar = this.f46191g;
        if (bVar != null) {
            bVar.b(i2, aVar);
        }
    }

    public final void S() {
        d.a.m0.a.h0.m.b bVar = this.f46191g;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void T(g gVar) {
        if (!j0.a(new File(gVar.f51788a), gVar.m)) {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            R(4, aVar);
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.a.m0.a.h0.m.r.b.h(new File(gVar.f51788a), new File(this.f46193i, gVar.p))) {
            if (k) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.o = this.f46192h;
            d.a.m0.n.g.a.h().l(gVar);
            S();
            d.a.m0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            R(5, aVar2);
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void U(g gVar) {
        d.a.m0.a.h0.m.c.c().d(gVar, new b());
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<g> z() {
        return this.j;
    }
}
