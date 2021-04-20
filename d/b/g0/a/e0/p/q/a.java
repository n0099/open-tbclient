package d.b.g0.a.e0.p.q;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.b.g0.a.e0.p.c;
import d.b.g0.a.e0.p.j;
import d.b.g0.a.i2.e0;
import d.b.g0.a.k;
import d.b.g0.a.u0.d;
import d.b.g0.l.h.c;
import d.b.g0.l.k.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends j {
    public static final boolean k = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.e0.p.b f44616g;

    /* renamed from: h  reason: collision with root package name */
    public String f44617h;
    public String i;
    public c<g> j = new C0688a();

    /* renamed from: d.b.g0.a.e0.p.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0688a extends d.b.g0.l.h.b<g> {
        public C0688a() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return a.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(g gVar) {
            return d.b.g0.a.e0.p.r.b.a(a.this.i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(g gVar, d.b.g0.l.k.a aVar) {
            super.l(gVar, aVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            a.this.R(3);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f49306a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(g gVar) {
            super.b(gVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.T(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void n(g gVar) {
            super.n(gVar);
            if (a.k) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.U(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.InterfaceC0680c {
        public b() {
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.S();
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0680c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            a.this.R(0);
        }
    }

    public a(String str, String str2, d.b.g0.a.e0.p.b bVar) {
        this.f44617h = str;
        this.f44616g = bVar;
        this.i = d.e.h(str, str2).getPath();
    }

    @Override // d.b.g0.l.h.g
    public void B(d.b.g0.l.k.a aVar) {
        super.B(aVar);
        R(1);
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        R(2);
    }

    public final void R(int i) {
        d.b.g0.a.e0.p.b bVar = this.f44616g;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public final void S() {
        d.b.g0.a.e0.p.b bVar = this.f44616g;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void T(g gVar) {
        if (!e0.a(new File(gVar.f49309a), gVar.m)) {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            R(4);
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.b.g0.a.e0.p.r.b.h(new File(gVar.f49309a), new File(this.i, gVar.p))) {
            if (k) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.o = this.f44617h;
            d.b.g0.l.i.a.h().l(gVar);
            S();
            d.b.g0.a.e0.p.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            R(5);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void U(g gVar) {
        d.b.g0.a.e0.p.c.c().d(gVar, new b());
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<g> z() {
        return this.j;
    }
}
