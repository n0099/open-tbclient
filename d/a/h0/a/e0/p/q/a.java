package d.a.h0.a.e0.p.q;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.h0.a.e0.p.c;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import d.a.h0.l.h.c;
import d.a.h0.l.k.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends j {
    public static final boolean k = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.a.e0.p.b f42249g;

    /* renamed from: h  reason: collision with root package name */
    public String f42250h;

    /* renamed from: i  reason: collision with root package name */
    public String f42251i;
    public c<g> j = new C0647a();

    /* renamed from: d.a.h0.a.e0.p.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0647a extends d.a.h0.l.h.b<g> {
        public C0647a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(g gVar) {
            return d.a.h0.a.e0.p.r.b.a(a.this.f42251i);
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(g gVar, d.a.h0.l.k.a aVar) {
            super.f(gVar, aVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
            }
            a.this.R(3);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f47144a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            d.a.h0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(g gVar) {
            super.i(gVar);
            if (a.k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
            }
            a.this.T(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void g(g gVar) {
            super.g(gVar);
            if (a.k) {
                Log.i("SwanAppSubPkgDownload", "onDownloading");
            }
            a.this.U(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.InterfaceC0639c {
        public b() {
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.S();
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            a.this.R(0);
        }
    }

    public a(String str, String str2, d.a.h0.a.e0.p.b bVar) {
        this.f42250h = str;
        this.f42249g = bVar;
        this.f42251i = d.e.h(str, str2).getPath();
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        R(1);
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        R(2);
    }

    public final void R(int i2) {
        d.a.h0.a.e0.p.b bVar = this.f42249g;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public final void S() {
        d.a.h0.a.e0.p.b bVar = this.f42249g;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void T(g gVar) {
        if (!e0.a(new File(gVar.f47147a), gVar.m)) {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            R(4);
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            d.a.h0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.a.h0.a.e0.p.r.b.h(new File(gVar.f47147a), new File(this.f42251i, gVar.p))) {
            if (k) {
                Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            gVar.o = this.f42250h;
            d.a.h0.l.i.a.h().l(gVar);
            S();
            d.a.h0.a.e0.p.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (k) {
                Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            R(5);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            d.a.h0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void U(g gVar) {
        d.a.h0.a.e0.p.c.c().d(gVar, new b());
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<g> z() {
        return this.j;
    }
}
