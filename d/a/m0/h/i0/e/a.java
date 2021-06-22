package d.a.m0.h.i0.e;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.m0.a.h0.m.c;
import d.a.m0.a.h0.m.j;
import d.a.m0.a.k;
import d.a.m0.a.v2.j0;
import d.a.m0.h.i0.b;
import d.a.m0.h.s.a;
import d.a.m0.n.f.c;
import d.a.m0.n.h.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean l = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public b.a f51190g;

    /* renamed from: h  reason: collision with root package name */
    public String f51191h;

    /* renamed from: i  reason: collision with root package name */
    public String f51192i;
    public String j;
    public c<g> k = new C1086a();

    /* renamed from: d.a.m0.h.i0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1086a extends d.a.m0.n.f.b<g> {
        public C1086a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            return d.a.m0.a.h0.m.r.b.c(a.this.j);
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
            if (a.l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.S(2103);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f51784a);
            aVar2.c("分包下载失败");
            aVar2.e(aVar.toString());
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            super.i(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
            }
            a.this.V(gVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: q */
        public void a(g gVar) {
            super.a(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.k + ":" + gVar.f51789b);
            }
            a.this.T(gVar.f51789b, gVar.k);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.n.f.b, d.a.m0.n.f.c
        /* renamed from: r */
        public void f(g gVar) {
            super.f(gVar);
            if (a.l) {
                Log.i("SwanGameSubPkgDownload", "onDownloading");
            }
            a.this.W(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.InterfaceC0735c {
        public b() {
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void a(PMSDownloadType pMSDownloadType) {
            a.this.U();
        }

        @Override // d.a.m0.a.h0.m.c.InterfaceC0735c
        public void b(PMSDownloadType pMSDownloadType, d.a.m0.a.q2.a aVar) {
            a.this.S(2103);
        }
    }

    public a(String str, String str2, String str3, b.a aVar) {
        this.f51191h = str;
        this.f51192i = str3;
        this.f51190g = aVar;
        this.j = a.d.h(str, str2).getPath();
    }

    @Override // d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        super.B(aVar);
        if (l) {
            Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
        }
        S(2103);
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        if (l) {
            Log.i("SwanGameSubPkgDownload", "onNoPackage");
        }
        S(2102);
    }

    public final void S(int i2) {
        b.a aVar = this.f51190g;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public final void T(long j, long j2) {
        if (this.f51190g == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (l) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.f51190g.a(floor, j, j2);
                return;
            }
            return;
        }
        S(2114);
    }

    public final void U() {
        b.a aVar = this.f51190g;
        if (aVar != null) {
            aVar.success();
        }
    }

    public final void V(g gVar) {
        if (!j0.a(new File(gVar.f51788a), gVar.m)) {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
            }
            S(2104);
            d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
            aVar.j(12L);
            aVar.h(2300L);
            aVar.c("分包签名校验");
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
        } else if (d.a.m0.a.h0.m.r.b.h(new File(gVar.f51788a), new File(this.j, this.f51192i))) {
            if (l) {
                Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
            }
            U();
            gVar.o = this.f51191h;
            d.a.m0.n.g.a.h().l(gVar);
            d.a.m0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
        } else {
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
            }
            S(2105);
            d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(2320L);
            aVar2.c("分包解压失败");
            d.a.m0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
        }
    }

    public final void W(g gVar) {
        d.a.m0.a.h0.m.c.c().d(gVar, new b());
    }

    @Override // d.a.m0.n.f.g
    public d.a.m0.n.f.c<g> z() {
        return this.k;
    }
}
