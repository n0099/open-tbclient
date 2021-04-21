package d.b.h0.a.j0.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import d.b.h0.a.e0.p.c;
import d.b.h0.a.e0.p.j;
import d.b.h0.a.i2.e0;
import d.b.h0.a.j0.i.d;
import d.b.h0.a.k;
import d.b.h0.l.k.i;
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
public final class f extends j implements d.b.h0.l.n.a.a, d.b.h0.l.m.k.c {
    public static final boolean q = k.f45772a;
    public static int r = 0;
    public static final PMSDownloadType s = PMSDownloadType.SO_LIB;

    /* renamed from: g  reason: collision with root package name */
    public String f45574g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f45575h;
    public h.j<i> i;
    public d.b.h0.l.r.f j;
    public final d.b.h0.l.l.k.g k;
    public d.b.h0.l.h.c<i> l;
    public final d.b.h0.a.j0.i.d o;
    public final Map<String, d.b.h0.a.j0.i.e> m = new HashMap();
    public final Map<String, d.b.h0.l.o.a> n = new HashMap();
    public final d.b.h0.l.m.c<JSONArray> p = new a();

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.l.m.c<JSONArray> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.m.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            if (jSONArray == null || f.this.m.isEmpty()) {
                return;
            }
            for (d.b.h0.a.j0.i.e eVar : f.this.m.values()) {
                if (eVar != null && eVar.r(f.this)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.j0.i.e> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.j0.i.e eVar) {
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "onCallback: SoUpdating=" + eVar);
            }
            if (eVar != null) {
                f.this.o.c(eVar.k(), eVar.o());
            }
            f.this.Y(null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.i2.u0.b<d.b.h0.a.j0.i.e> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.j0.i.e eVar) {
            if (eVar != null) {
                f.this.o.d(eVar.k(), eVar.m());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0700c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f45579a;

        public d(i iVar) {
            this.f45579a = iVar;
        }

        @Override // d.b.h0.a.e0.p.c.InterfaceC0700c
        public void a(PMSDownloadType pMSDownloadType) {
            f.this.j.j(this.f45579a);
            if (f.this.f45575h != null) {
                f.this.f45575h.onNext(this.f45579a);
                f.this.f45575h.onCompleted();
            }
        }

        @Override // d.b.h0.a.e0.p.c.InterfaceC0700c
        public void b(PMSDownloadType pMSDownloadType, d.b.h0.a.f2.a aVar) {
            f.this.j.i(this.f45579a);
            if (f.this.f45575h != null) {
                f.this.f45575h.onError(new PkgDownloadError(this.f45579a, aVar));
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
            f.this.f45575h = jVar;
        }
    }

    /* renamed from: d.b.h0.a.j0.i.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0739f extends h.j<i> {
        public C0739f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(i iVar) {
            if (f.q) {
                String str = f.this.f45574g;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }

        @Override // h.e
        public void onCompleted() {
            if (f.q) {
                Log.e(f.this.f45574g, "PkgDlSubscriber 包下载完成");
            }
            f.this.d0(null);
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (f.q) {
                String str = f.this.f45574g;
                Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
            }
            f.this.d0(new Exception("failed by Download error = ", th));
        }

        public /* synthetic */ C0739f(f fVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.b.h0.l.h.b<i> {
        public g() {
        }

        @Override // d.b.h0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return f.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.c
        /* renamed from: m */
        public String j(i iVar) {
            String f2 = d.b.h0.a.j0.i.c.f45553d.f(iVar);
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "SoDlCallback getDownloadPath: so=" + iVar.f49644g + " path=" + f2);
            }
            return f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: o */
        public void l(i iVar, d.b.h0.l.k.a aVar) {
            super.l(iVar, aVar);
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "SoDlCallback onDownloadError: so=" + iVar.f49644g + " err=" + aVar);
            }
            f.this.j.i(iVar);
            d.b.h0.a.f2.a aVar2 = new d.b.h0.a.f2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f49635a);
            aVar2.c("so包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f45575h != null) {
                f.this.f45575h.onError(new PkgDownloadError(iVar, aVar2));
            }
            d.b.h0.a.e0.p.c.c().a(iVar, f.s, aVar2);
            d.b.h0.p.d.g(iVar.f49638a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: p */
        public void b(i iVar) {
            d.b.h0.l.o.a aVar;
            super.b(iVar);
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.p;
            if (TextUtils.isEmpty(str2) && (aVar = (d.b.h0.l.o.a) f.this.n.get(iVar.f49644g)) != null) {
                str2 = aVar.f49778a;
            }
            d.b.h0.a.j0.i.e Z = f.this.Z(str2);
            if (Z != null) {
                boolean a2 = e0.a(new File(iVar.f49638a), iVar.m);
                if (f.q) {
                    String str3 = f.this.f45574g;
                    Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + iVar.f49644g + " checkSign=" + a2);
                }
                if (a2) {
                    d.b.h0.l.i.a.h().l(iVar);
                    if (f.q) {
                        String str4 = f.this.f45574g;
                        Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2);
                    }
                }
                Z.q();
            }
            f.this.j.j(iVar);
            if (f.this.f45575h != null) {
                f.this.f45575h.onNext(iVar);
                f.this.f45575h.onCompleted();
            }
            d.b.h0.a.e0.p.c.c().b(iVar, f.s);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: q */
        public void a(i iVar) {
            super.a(iVar);
            d.b.h0.l.o.a aVar = (d.b.h0.l.o.a) f.this.n.get(iVar.f49644g);
            d.b.h0.a.j0.i.e Z = f.this.Z(aVar == null ? null : aVar.f49778a);
            if (Z != null) {
                Z.x(new d.b(iVar.f49639b, iVar.k));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: r */
        public void i(i iVar) {
            super.i(iVar);
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "SoDlCallback onDownloadStart: so=" + iVar.f49644g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: s */
        public void n(i iVar) {
            super.n(iVar);
            if (f.q) {
                String str = f.this.f45574g;
                Log.i(str, "SoDlCallback onDownloading: so=" + iVar.f49644g);
            }
            f.this.e0(iVar);
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this();
        }
    }

    public f(d.b.h0.l.l.k.g gVar, d.b.h0.a.j0.i.d dVar) {
        this.f45574g = "SwanSoUpdater";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f45574g);
        int i = r;
        r = i + 1;
        sb.append(i);
        String sb2 = sb.toString();
        this.f45574g = sb2;
        if (q) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                d.b.h0.a.j0.i.a a2 = d.b.h0.a.j0.i.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    d.b.h0.a.j0.i.e q2 = d.b.h0.a.j0.i.c.f45553d.q(this, e2);
                    b bVar = new b();
                    c cVar = new c();
                    q2.u(bVar);
                    q2.v(cVar);
                    this.m.put(e2, q2);
                    this.n.putAll(d.b.h0.l.o.a.b(e2));
                }
            }
        }
        if (q) {
            String str = this.f45574g;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.m.size());
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // d.b.h0.l.h.g
    public void B(d.b.h0.l.k.a aVar) {
        super.B(aVar);
        if (q) {
            String str = this.f45574g;
            Log.e(str, "onFetchError: " + aVar.toString());
        }
        d0(new Exception("failed by fetch error = " + aVar));
    }

    @Override // d.b.h0.l.h.g
    public void D() {
        super.D();
        if (q) {
            Log.e(this.f45574g, "onFetchSuccess:");
        }
    }

    @Override // d.b.h0.l.h.g
    public void E() {
        super.E();
        if (q) {
            Log.e(this.f45574g, "onNoPackage:");
        }
        d0(null);
    }

    @Override // d.b.h0.l.h.g
    public void F(d.b.h0.l.r.f fVar) {
        if (q) {
            String str = this.f45574g;
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
            String str = this.f45574g;
            Log.i(str, "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.b.h0.a.j0.i.e eVar : this.m.values()) {
            if (!eVar.n()) {
                if (q) {
                    String str2 = this.f45574g;
                    Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                    return;
                }
                return;
            }
        }
        c0(exc);
    }

    public final d.b.h0.a.j0.i.e Z(String str) {
        d.b.h0.a.j0.i.e eVar = this.m.get(str);
        if (eVar == null || !eVar.r(this)) {
            return null;
        }
        return eVar;
    }

    public final h.j<i> a0() {
        if (this.i == null) {
            this.i = new C0739f(this, null);
        }
        return this.i;
    }

    public final void b0() {
        ArrayList arrayList = new ArrayList();
        if (this.j.e()) {
            arrayList.add(h.d.c(new e()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        h.d.m(arrayList).B(a0());
    }

    public final void c0(Exception exc) {
        if (q) {
            String str = this.f45574g;
            Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
        }
        d.b.h0.a.j0.i.d dVar = this.o;
        if (dVar != null) {
            dVar.b(exc);
        }
    }

    public final void d0(Exception exc) {
        if (q) {
            String str = this.f45574g;
            Log.i(str, "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.b.h0.a.j0.i.e eVar : this.m.values()) {
            if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                if (q) {
                    String str2 = this.f45574g;
                    Log.i(str2, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.q();
            }
        }
        Y(exc);
    }

    @Override // d.b.h0.l.m.k.c
    public void e(JSONObject jSONObject) {
        if (q) {
            String str = this.f45574g;
            Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
        }
        if (jSONObject != null) {
            f0((i) d.b.h0.l.r.e.i(jSONObject, new i()));
        }
    }

    public final void e0(i iVar) {
        d.b.h0.a.e0.p.c.c().d(iVar, new d(iVar));
    }

    public final void f0(i iVar) {
        if (q) {
            String str = this.f45574g;
            Log.i(str, "SoNodeHandler updateBestSo start so=" + iVar);
        }
        if (iVar == null) {
            if (q) {
                Log.i(this.f45574g, "SoNodeHandler updateBestSo end by null so");
                return;
            }
            return;
        }
        d.b.h0.l.o.a aVar = this.n.get(iVar.f49644g);
        if (aVar == null) {
            if (q) {
                String str2 = this.f45574g;
                Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f49644g);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.p)) {
            iVar.p = aVar.f49778a;
        }
        d.b.h0.a.j0.i.e Z = Z(iVar.p);
        if (Z == null) {
            if (q) {
                String str3 = this.f45574g;
                Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p);
                return;
            }
            return;
        }
        if (iVar.q == null) {
            iVar.q = aVar.f49780c;
        }
        if (!AbiType.currentAbi().compat(iVar.q)) {
            if (q) {
                Log.i(this.f45574g, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i l = Z.l();
        i j = Z.j();
        long max = Math.max(j != null ? j.i : 0L, l == null ? 0L : l.i);
        long j2 = iVar.i;
        if (j2 < max) {
            if (q) {
                Log.i(this.f45574g, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.i)));
            }
        } else if (j2 > max) {
            if (q) {
                String str4 = this.f45574g;
                Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.i);
            }
            Z.w(this, iVar);
        } else {
            if (j == null || !j.q.compat(iVar.q)) {
                if (q) {
                    String str5 = this.f45574g;
                    Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + iVar.q);
                }
                Z.w(this, iVar);
            }
            if (q) {
                Log.i(this.f45574g, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // d.b.h0.l.n.a.a
    @Nullable
    public d.b.h0.l.l.k.g getRequest() {
        return this.k;
    }

    @Override // d.b.h0.l.m.k.c
    public void handle() {
        d.b.h0.l.m.k.a aVar = new d.b.h0.l.m.k.a();
        d.b.h0.l.r.f fVar = new d.b.h0.l.r.f();
        if (q) {
            Log.i(this.f45574g, "SoNodeHandler handle for loop start");
        }
        for (d.b.h0.a.j0.i.e eVar : this.m.values()) {
            if (eVar.r(this)) {
                f0(eVar.l());
                i j = eVar.j();
                if (eVar.p() && j != null) {
                    if (q) {
                        String str = this.f45574g;
                        Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                    }
                    d.b.h0.l.m.k.b.b(j, fVar);
                    if (aVar.f49772d == null) {
                        aVar.f49772d = new ArrayList();
                    }
                    aVar.f49772d.add(j);
                } else {
                    if (q) {
                        Log.i(this.f45574g, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.q();
                }
            }
        }
        if (q) {
            Log.i(this.f45574g, "SoNodeHandler handle for loop end");
            String str2 = this.f45574g;
            Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fVar.k());
        }
        if (fVar.k() == 0) {
            if (q) {
                Log.i(this.f45574g, "SoNodeHandler handle end by no pkg");
            }
            E();
            return;
        }
        if (q) {
            Log.i(this.f45574g, "SoNodeHandler handle end by start dl");
        }
        F(fVar);
        d.b.h0.l.l.h.a.e(aVar, this);
    }

    @Override // d.b.h0.l.n.a.a
    public d.b.h0.l.h.g m() {
        return this;
    }

    @Override // d.b.h0.l.n.a.a
    public d.b.h0.l.m.c<JSONArray> o() {
        return this.p;
    }

    @Override // d.b.h0.l.h.g
    public d.b.h0.l.m.k.c v(String str) {
        return TextUtils.equals("so", str) ? this : super.v(str);
    }

    @Override // d.b.h0.l.h.g
    public d.b.h0.l.h.c<i> y() {
        if (this.l == null) {
            this.l = new g(this, null);
        }
        return this.l;
    }
}
