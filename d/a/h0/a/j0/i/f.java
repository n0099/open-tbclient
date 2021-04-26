package d.a.h0.a.j0.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import d.a.h0.a.e0.p.c;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import d.a.h0.a.j0.i.d;
import d.a.h0.a.k;
import d.a.h0.l.k.i;
import h.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f extends j implements d.a.h0.l.n.a.a, d.a.h0.l.m.k.c {
    public static final boolean q = k.f43101a;
    public static int r = 0;
    public static final PMSDownloadType s = PMSDownloadType.SO_LIB;

    /* renamed from: g  reason: collision with root package name */
    public String f42896g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f42897h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<i> f42898i;
    public d.a.h0.l.r.f j;
    public final d.a.h0.l.l.k.g k;
    public d.a.h0.l.h.c<i> l;
    public final d.a.h0.a.j0.i.d o;
    public final Map<String, d.a.h0.a.j0.i.e> m = new HashMap();
    public final Map<String, d.a.h0.l.o.a> n = new HashMap();
    public final d.a.h0.l.m.c<JSONArray> p = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.l.m.c<JSONArray> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.m.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            if (jSONArray == null || f.this.m.isEmpty()) {
                return;
            }
            for (d.a.h0.a.j0.i.e eVar : f.this.m.values()) {
                if (eVar != null && eVar.r(f.this)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.j0.i.e> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.j0.i.e eVar) {
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "onCallback: SoUpdating=" + eVar);
            }
            if (eVar != null) {
                f.this.o.c(eVar.k(), eVar.o());
            }
            f.this.Y(null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.i2.u0.b<d.a.h0.a.j0.i.e> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.j0.i.e eVar) {
            if (eVar != null) {
                f.this.o.d(eVar.k(), eVar.m());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0639c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f42902a;

        public d(i iVar) {
            this.f42902a = iVar;
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void a(PMSDownloadType pMSDownloadType) {
            f.this.j.j(this.f42902a);
            if (f.this.f42897h != null) {
                f.this.f42897h.onNext(this.f42902a);
                f.this.f42897h.onCompleted();
            }
        }

        @Override // d.a.h0.a.e0.p.c.InterfaceC0639c
        public void b(PMSDownloadType pMSDownloadType, d.a.h0.a.f2.a aVar) {
            f.this.j.i(this.f42902a);
            if (f.this.f42897h != null) {
                f.this.f42897h.onError(new PkgDownloadError(this.f42902a, aVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a<i> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.j<? super i> jVar) {
            f.this.f42897h = jVar;
        }
    }

    /* renamed from: d.a.h0.a.j0.i.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0678f extends h.j<i> {
        public C0678f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(i iVar) {
            if (f.q) {
                String str = f.this.f42896g;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }

        @Override // h.e
        public void onCompleted() {
            if (f.q) {
                Log.e(f.this.f42896g, "PkgDlSubscriber 包下载完成");
            }
            f.this.d0(null);
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (f.q) {
                String str = f.this.f42896g;
                Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
            }
            f.this.d0(new Exception("failed by Download error = ", th));
        }

        public /* synthetic */ C0678f(f fVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.a.h0.l.h.b<i> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(i iVar) {
            String f2 = d.a.h0.a.j0.i.c.f42874d.f(iVar);
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "SoDlCallback getDownloadPath: so=" + iVar.f47153g + " path=" + f2);
            }
            return f2;
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(i iVar, d.a.h0.l.k.a aVar) {
            super.f(iVar, aVar);
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "SoDlCallback onDownloadError: so=" + iVar.f47153g + " err=" + aVar);
            }
            f.this.j.i(iVar);
            d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f47144a);
            aVar2.c("so包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f42897h != null) {
                f.this.f42897h.onError(new PkgDownloadError(iVar, aVar2));
            }
            d.a.h0.a.e0.p.c.c().a(iVar, f.s, aVar2);
            d.a.h0.p.d.g(iVar.f47147a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(i iVar) {
            d.a.h0.l.o.a aVar;
            super.i(iVar);
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.p;
            if (TextUtils.isEmpty(str2) && (aVar = (d.a.h0.l.o.a) f.this.n.get(iVar.f47153g)) != null) {
                str2 = aVar.f47292a;
            }
            d.a.h0.a.j0.i.e Z = f.this.Z(str2);
            if (Z != null) {
                boolean a2 = e0.a(new File(iVar.f47147a), iVar.m);
                if (f.q) {
                    String str3 = f.this.f42896g;
                    Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + iVar.f47153g + " checkSign=" + a2);
                }
                if (a2) {
                    d.a.h0.l.i.a.h().l(iVar);
                    if (f.q) {
                        String str4 = f.this.f42896g;
                        Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2);
                    }
                }
                Z.q();
            }
            f.this.j.j(iVar);
            if (f.this.f42897h != null) {
                f.this.f42897h.onNext(iVar);
                f.this.f42897h.onCompleted();
            }
            d.a.h0.a.e0.p.c.c().b(iVar, f.s);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void a(i iVar) {
            super.a(iVar);
            d.a.h0.l.o.a aVar = (d.a.h0.l.o.a) f.this.n.get(iVar.f47153g);
            d.a.h0.a.j0.i.e Z = f.this.Z(aVar == null ? null : aVar.f47292a);
            if (Z != null) {
                Z.x(new d.b(iVar.f47148b, iVar.k));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void d(i iVar) {
            super.d(iVar);
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "SoDlCallback onDownloadStart: so=" + iVar.f47153g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: s */
        public void g(i iVar) {
            super.g(iVar);
            if (f.q) {
                String str = f.this.f42896g;
                Log.i(str, "SoDlCallback onDownloading: so=" + iVar.f47153g);
            }
            f.this.e0(iVar);
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this();
        }
    }

    public f(d.a.h0.l.l.k.g gVar, d.a.h0.a.j0.i.d dVar) {
        this.f42896g = "SwanSoUpdater";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42896g);
        int i2 = r;
        r = i2 + 1;
        sb.append(i2);
        String sb2 = sb.toString();
        this.f42896g = sb2;
        if (q) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                d.a.h0.a.j0.i.a a2 = d.a.h0.a.j0.i.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    d.a.h0.a.j0.i.e q2 = d.a.h0.a.j0.i.c.f42874d.q(this, e2);
                    b bVar = new b();
                    c cVar = new c();
                    q2.u(bVar);
                    q2.v(cVar);
                    this.m.put(e2, q2);
                    this.n.putAll(d.a.h0.l.o.a.b(e2));
                }
            }
        }
        if (q) {
            String str = this.f42896g;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.m.size());
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        if (q) {
            String str = this.f42896g;
            Log.e(str, "onFetchError: " + aVar.toString());
        }
        d0(new Exception("failed by fetch error = " + aVar));
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        super.D();
        if (q) {
            Log.e(this.f42896g, "onFetchSuccess:");
        }
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        if (q) {
            Log.e(this.f42896g, "onNoPackage:");
        }
        d0(null);
    }

    @Override // d.a.h0.l.h.g
    public void F(d.a.h0.l.r.f fVar) {
        if (q) {
            String str = this.f42896g;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepareDownload: countSet.size=");
            sb.append(fVar == null ? 0 : fVar.k());
            Log.i(str, sb.toString());
        }
        super.F(fVar);
        if (fVar == null) {
            return;
        }
        this.j = fVar;
        if (fVar.h()) {
            return;
        }
        b0();
    }

    public final void Y(Exception exc) {
        if (q) {
            String str = this.f42896g;
            Log.i(str, "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.a.h0.a.j0.i.e eVar : this.m.values()) {
            if (!eVar.n()) {
                if (q) {
                    String str2 = this.f42896g;
                    Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                    return;
                }
                return;
            }
        }
        c0(exc);
    }

    public final d.a.h0.a.j0.i.e Z(String str) {
        d.a.h0.a.j0.i.e eVar = this.m.get(str);
        if (eVar == null || !eVar.r(this)) {
            return null;
        }
        return eVar;
    }

    public final h.j<i> a0() {
        if (this.f42898i == null) {
            this.f42898i = new C0678f(this, null);
        }
        return this.f42898i;
    }

    public final void b0() {
        ArrayList arrayList = new ArrayList();
        if (this.j.e()) {
            arrayList.add(h.d.b(new e()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.l(arrayList).z(a0());
    }

    public final void c0(Exception exc) {
        if (q) {
            String str = this.f42896g;
            Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
        }
        d.a.h0.a.j0.i.d dVar = this.o;
        if (dVar != null) {
            dVar.b(exc);
        }
    }

    public final void d0(Exception exc) {
        if (q) {
            String str = this.f42896g;
            Log.i(str, "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.a.h0.a.j0.i.e eVar : this.m.values()) {
            if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                if (q) {
                    String str2 = this.f42896g;
                    Log.i(str2, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.q();
            }
        }
        Y(exc);
    }

    public final void e0(i iVar) {
        d.a.h0.a.e0.p.c.c().d(iVar, new d(iVar));
    }

    public final void f0(i iVar) {
        if (q) {
            String str = this.f42896g;
            Log.i(str, "SoNodeHandler updateBestSo start so=" + iVar);
        }
        if (iVar == null) {
            if (q) {
                Log.i(this.f42896g, "SoNodeHandler updateBestSo end by null so");
                return;
            }
            return;
        }
        d.a.h0.l.o.a aVar = this.n.get(iVar.f47153g);
        if (aVar == null) {
            if (q) {
                String str2 = this.f42896g;
                Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f47153g);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.p)) {
            iVar.p = aVar.f47292a;
        }
        d.a.h0.a.j0.i.e Z = Z(iVar.p);
        if (Z == null) {
            if (q) {
                String str3 = this.f42896g;
                Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p);
                return;
            }
            return;
        }
        if (iVar.q == null) {
            iVar.q = aVar.f47294c;
        }
        if (!AbiType.currentAbi().compat(iVar.q)) {
            if (q) {
                Log.i(this.f42896g, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i l = Z.l();
        i j = Z.j();
        long max = Math.max(j != null ? j.f47155i : 0L, l == null ? 0L : l.f47155i);
        long j2 = iVar.f47155i;
        if (j2 < max) {
            if (q) {
                Log.i(this.f42896g, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f47155i)));
            }
        } else if (j2 > max) {
            if (q) {
                String str4 = this.f42896g;
                Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f47155i);
            }
            Z.w(this, iVar);
        } else {
            if (j == null || !j.q.compat(iVar.q)) {
                if (q) {
                    String str5 = this.f42896g;
                    Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + iVar.q);
                }
                Z.w(this, iVar);
            }
            if (q) {
                Log.i(this.f42896g, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // d.a.h0.l.n.a.a
    @Nullable
    public d.a.h0.l.l.k.g getRequest() {
        return this.k;
    }

    @Override // d.a.h0.l.n.a.a
    public d.a.h0.l.m.c<JSONArray> h() {
        return this.p;
    }

    @Override // d.a.h0.l.m.k.c
    public void handle() {
        d.a.h0.l.m.k.a aVar = new d.a.h0.l.m.k.a();
        d.a.h0.l.r.f fVar = new d.a.h0.l.r.f();
        if (q) {
            Log.i(this.f42896g, "SoNodeHandler handle for loop start");
        }
        for (d.a.h0.a.j0.i.e eVar : this.m.values()) {
            if (eVar.r(this)) {
                f0(eVar.l());
                i j = eVar.j();
                if (eVar.p() && j != null) {
                    if (q) {
                        String str = this.f42896g;
                        Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                    }
                    d.a.h0.l.m.k.b.b(j, fVar);
                    if (aVar.f47286d == null) {
                        aVar.f47286d = new ArrayList();
                    }
                    aVar.f47286d.add(j);
                } else {
                    if (q) {
                        Log.i(this.f42896g, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.q();
                }
            }
        }
        if (q) {
            Log.i(this.f42896g, "SoNodeHandler handle for loop end");
            String str2 = this.f42896g;
            Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fVar.k());
        }
        if (fVar.k() == 0) {
            if (q) {
                Log.i(this.f42896g, "SoNodeHandler handle end by no pkg");
            }
            E();
            return;
        }
        if (q) {
            Log.i(this.f42896g, "SoNodeHandler handle end by start dl");
        }
        F(fVar);
        d.a.h0.l.l.h.a.e(aVar, this);
    }

    @Override // d.a.h0.l.m.k.c
    public void l(JSONObject jSONObject) {
        if (q) {
            String str = this.f42896g;
            Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
        }
        if (jSONObject != null) {
            f0((i) d.a.h0.l.r.e.i(jSONObject, new i()));
        }
    }

    @Override // d.a.h0.l.n.a.a
    public d.a.h0.l.h.g o() {
        return this;
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.m.k.c v(String str) {
        return TextUtils.equals("so", str) ? this : super.v(str);
    }

    @Override // d.a.h0.l.h.g
    public d.a.h0.l.h.c<i> y() {
        if (this.l == null) {
            this.l = new g(this, null);
        }
        return this.l;
    }
}
