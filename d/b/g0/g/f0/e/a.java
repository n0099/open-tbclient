package d.b.g0.g.f0.e;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.b.g0.a.e0.p.c;
import d.b.g0.a.e0.p.j;
import d.b.g0.a.i2.e0;
import d.b.g0.a.k;
import d.b.g0.g.f0.b;
import d.b.g0.g.q.a;
import d.b.g0.l.h.c;
import d.b.g0.l.k.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean l = k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public b.a f48145g;

    /* renamed from: h  reason: collision with root package name */
    public String f48146h;
    public String i;
    public String j;
    public c<g> k = new C0963a();

    /* renamed from: d.b.g0.g.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0963a extends d.b.g0.l.h.b<g> {
        public C0963a() {
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
            return d.b.g0.a.e0.p.r.b.c(a.this.j);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: n */
        public void l(g gVar, d.b.g0.l.k.a aVar) {
            super.l(gVar, aVar);
            if (a.l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.T(2103);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f48913a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(g gVar) {
            super.b(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.W(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void a(g gVar) {
            super.a(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.k + ":" + gVar.f48917b);
            }
            a.this.U(gVar.f48917b, gVar.k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void o(g gVar) {
            super.o(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloading");
            }
            a.this.X(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC0667c {
        public b() {
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0667c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.V();
        }

        @Override // d.b.g0.a.e0.p.c.InterfaceC0667c
        public void b(PMSDownloadType pMSDownloadType, d.b.g0.a.f2.a aVar) {
            a.this.T(2103);
        }
    }

    public a(String str, String str2, String str3, b.a aVar) {
        this.f48146h = str;
        this.i = str3;
        this.f48145g = aVar;
        this.j = a.d.h(str, str2).getPath();
    }

    @Override // d.b.g0.l.h.g
    public d.b.g0.l.h.c<g> A() {
        return this.k;
    }

    @Override // d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        if (l) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        T(2103);
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        if (l) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        T(2102);
    }

    public final void T(int i) {
        b.a aVar = this.f48145g;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    public final void U(long j, long j2) {
        if (this.f48145g == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            double d2 = j;
            Double.isNaN(d2);
            double d3 = j2;
            Double.isNaN(d3);
            int floor = (int) Math.floor((d2 * 100.0d) / d3);
            if (floor != 100) {
                if (l) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.f48145g.a(floor, j, j2);
                return;
            }
            return;
        }
        T(2114);
    }

    public final void V() {
        b.a aVar = this.f48145g;
        if (aVar != null) {
            aVar.success();
        }
    }

    public final void W(g gVar) {
        if (!e0.a(new File(gVar.f48916a), gVar.m)) {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            T(2104);
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.b.g0.a.e0.p.r.b.h(new File(gVar.f48916a), new File(this.j, this.i))) {
            if (l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            V();
            gVar.o = this.f48146h;
            d.b.g0.l.i.a.h().l(gVar);
            d.b.g0.a.e0.p.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            T(2105);
            d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            d.b.g0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void X(g gVar) {
        d.b.g0.a.e0.p.c.c().d(gVar, new b());
    }
}
