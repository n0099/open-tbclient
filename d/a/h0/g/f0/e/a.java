package d.a.h0.g.f0.e;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.h0.a.e0.p.c;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import d.a.h0.a.k;
import d.a.h0.g.f0.b;
import d.a.h0.g.q.a;
import d.a.h0.l.h.c;
import d.a.h0.l.k.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean l = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public b.a f46339g;

    /* renamed from: h  reason: collision with root package name */
    public String f46340h;

    /* renamed from: i  reason: collision with root package name */
    public String f46341i;
    public String j;
    public c<g> k = new C0935a();

    /* renamed from: d.a.h0.g.f0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0935a extends d.a.h0.l.h.b<g> {
        public C0935a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(g gVar) {
            return d.a.h0.a.e0.p.r.b.c(a.this.j);
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
            if (a.l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.S(2103);
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
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.V(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void a(g gVar) {
            super.a(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.k + ":" + gVar.f47148b);
            }
            a.this.T(gVar.f47148b, gVar.k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(g gVar) {
            super.g(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloading");
            }
            a.this.W(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC0639c {
        public b() {
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.U();
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            a.this.S(2103);
        }
    }

    public a(String str, String str2, String str3, b.a aVar) {
        this.f46340h = str;
        this.f46341i = str3;
        this.f46339g = aVar;
        this.j = a.d.h(str, str2).getPath();
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        if (l) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        S(2103);
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        if (l) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        S(2102);
    }

    public final void S(int i2) {
        b.a aVar = this.f46339g;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public final void T(long j, long j2) {
        if (this.f46339g == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (l) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.f46339g.a(floor, j, j2);
                return;
            }
            return;
        }
        S(2114);
    }

    public final void U() {
        b.a aVar = this.f46339g;
        if (aVar != null) {
            aVar.success();
        }
    }

    public final void V(g gVar) {
        if (!e0.a(new File(gVar.f47147a), gVar.m)) {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            S(2104);
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            d.a.h0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.a.h0.a.e0.p.r.b.h(new File(gVar.f47147a), new File(this.j, this.f46341i))) {
            if (l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            U();
            gVar.o = this.f46340h;
            d.a.h0.l.i.a.h().l(gVar);
            d.a.h0.a.e0.p.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            S(2105);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            d.a.h0.a.e0.p.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void W(g gVar) {
        d.a.h0.a.e0.p.c.c().d(gVar, new b());
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<g> z() {
        return this.k;
    }
}
