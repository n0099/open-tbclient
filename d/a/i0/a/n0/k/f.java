package d.a.i0.a.n0.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.utils.AbiType;
import d.a.i0.a.h;
import d.a.i0.a.h0.m.c;
import d.a.i0.a.h0.m.j;
import d.a.i0.a.k;
import d.a.i0.a.n0.k.d;
import d.a.i0.a.v2.j0;
import d.a.i0.a.v2.q0;
import d.a.i0.n.h.i;
import h.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f extends j implements d.a.i0.n.k.a.a, d.a.i0.n.j.k.c {
    public static final boolean q = k.f43025a;
    public static int r = 0;
    public static final PMSDownloadType s = PMSDownloadType.SO_LIB;

    /* renamed from: g  reason: collision with root package name */
    public String f43493g;

    /* renamed from: h  reason: collision with root package name */
    public h.j<? super i> f43494h;

    /* renamed from: i  reason: collision with root package name */
    public h.j<i> f43495i;
    public d.a.i0.n.o.f j;
    public final d.a.i0.n.i.m.g k;
    public d.a.i0.n.f.c<i> l;
    public final d.a.i0.a.n0.k.d o;
    public final Map<String, d.a.i0.a.n0.k.e> m = new HashMap();
    public final Map<String, d.a.i0.n.l.a> n = new HashMap();
    public final d.a.i0.n.j.c<JSONArray> p = new a();

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.n.j.c<JSONArray> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.j.c
        /* renamed from: b */
        public void a(@NonNull JSONArray jSONArray) {
            if (jSONArray == null || f.this.m.isEmpty()) {
                return;
            }
            for (d.a.i0.a.n0.k.e eVar : f.this.m.values()) {
                if (eVar != null && eVar.r(f.this)) {
                    eVar.a(jSONArray);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.b<d.a.i0.a.n0.k.e> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.n0.k.e eVar) {
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "onCallback: SoUpdating=" + eVar);
            }
            if (eVar != null) {
                f.this.o.c(eVar.k(), eVar.o());
            }
            f.this.Y(null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.v2.e1.b<d.a.i0.a.n0.k.e> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.n0.k.e eVar) {
            if (eVar != null) {
                f.this.o.d(eVar.k(), eVar.m());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0665c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f43499a;

        public d(i iVar) {
            this.f43499a = iVar;
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void a(PMSDownloadType pMSDownloadType) {
            f.this.j.k(this.f43499a);
            if (f.this.f43494h != null) {
                f.this.f43494h.onNext(this.f43499a);
                f.this.f43494h.onCompleted();
            }
        }

        @Override // d.a.i0.a.h0.m.c.InterfaceC0665c
        public void b(PMSDownloadType pMSDownloadType, d.a.i0.a.q2.a aVar) {
            f.this.j.j(this.f43499a);
            if (f.this.f43494h != null) {
                f.this.f43494h.onError(new PkgDownloadError(this.f43499a, aVar));
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
            f.this.f43494h = jVar;
        }
    }

    /* renamed from: d.a.i0.a.n0.k.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0751f extends h.j<i> {
        public C0751f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.e
        /* renamed from: b */
        public void onNext(i iVar) {
            if (f.q) {
                String str = f.this.f43493g;
                Log.e(str, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }

        @Override // h.e
        public void onCompleted() {
            if (f.q) {
                Log.e(f.this.f43493g, "PkgDlSubscriber 包下载完成");
            }
            f.this.d0(null);
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (f.q) {
                String str = f.this.f43493g;
                Log.e(str, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
            }
            f.this.d0(new Exception("failed by Download error = ", th));
        }

        public /* synthetic */ C0751f(f fVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.a.i0.n.f.b<i> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(i iVar) {
            String g2 = d.a.i0.a.n0.k.c.f43471d.g(iVar);
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "SoDlCallback getDownloadPath: so=" + iVar.f47836g + " path=" + g2);
            }
            return g2;
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return f.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(i iVar, d.a.i0.n.h.a aVar) {
            super.e(iVar, aVar);
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "SoDlCallback onDownloadError: so=" + iVar.f47836g + " err=" + aVar);
            }
            f.this.j.j(iVar);
            d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
            aVar2.j(13L);
            aVar2.h(aVar.f47826a);
            aVar2.c("so包下载失败");
            aVar2.e(aVar.toString());
            if (f.this.f43494h != null) {
                f.this.f43494h.onError(new PkgDownloadError(iVar, aVar2));
            }
            d.a.i0.a.h0.m.c.c().a(iVar, f.s, aVar2);
            d.a.i0.t.d.j(iVar.f47830a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(i iVar) {
            d.a.i0.n.l.a aVar;
            super.i(iVar);
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.p;
            if (TextUtils.isEmpty(str2) && (aVar = (d.a.i0.n.l.a) f.this.n.get(iVar.f47836g)) != null) {
                str2 = aVar.f48007a;
            }
            d.a.i0.a.n0.k.e Z = f.this.Z(str2);
            if (Z != null) {
                boolean a2 = j0.a(new File(iVar.f47830a), iVar.m);
                if (f.q) {
                    String str3 = f.this.f43493g;
                    Log.i(str3, "SoDlCallback onDownloadFinish: bundle=" + iVar.f47836g + " checkSign=" + a2);
                }
                boolean z = true;
                z = (f.q && !q0.G() && d.a.i0.a.u1.a.a.j() == 1) ? false : false;
                if (a2 || z) {
                    d.a.i0.n.g.a.h().l(iVar);
                    if (f.q) {
                        String str4 = f.this.f43493g;
                        Log.i(str4, "SoDlCallback onDownloadFinish: updating=" + Z + " libName=" + str2);
                    }
                }
                Z.q();
            }
            f.this.j.k(iVar);
            if (f.this.f43494h != null) {
                f.this.f43494h.onNext(iVar);
                f.this.f43494h.onCompleted();
            }
            d.a.i0.a.h0.m.c.c().b(iVar, f.s);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void a(i iVar) {
            super.a(iVar);
            d.a.i0.n.l.a aVar = (d.a.i0.n.l.a) f.this.n.get(iVar.f47836g);
            d.a.i0.a.n0.k.e Z = f.this.Z(aVar == null ? null : aVar.f48007a);
            if (Z != null) {
                Z.x(new d.b(iVar.f47831b, iVar.k));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void c(i iVar) {
            super.c(iVar);
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "SoDlCallback onDownloadStart: so=" + iVar.f47836g);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: s */
        public void f(i iVar) {
            super.f(iVar);
            if (f.q) {
                String str = f.this.f43493g;
                Log.i(str, "SoDlCallback onDownloading: so=" + iVar.f47836g);
            }
            f.this.e0(iVar);
        }

        public /* synthetic */ g(f fVar, a aVar) {
            this();
        }
    }

    public f(d.a.i0.n.i.m.g gVar, d.a.i0.a.n0.k.d dVar) {
        this.f43493g = "SwanSoUpdater";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43493g);
        int i2 = r;
        r = i2 + 1;
        sb.append(i2);
        String sb2 = sb.toString();
        this.f43493g = sb2;
        if (q) {
            Log.i(sb2, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.k = gVar;
        this.o = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.a().iterator();
            while (it.hasNext()) {
                String next = it.next();
                d.a.i0.a.n0.k.a a2 = d.a.i0.a.n0.k.b.a(next);
                if (a2 == null) {
                    dVar.c(next, false);
                } else if (a2.f()) {
                    dVar.c(next, true);
                } else {
                    String e2 = a2.e();
                    d.a.i0.a.n0.k.e t = d.a.i0.a.n0.k.c.f43471d.t(this, e2);
                    b bVar = new b();
                    c cVar = new c();
                    t.u(bVar);
                    t.v(cVar);
                    this.m.put(e2, t);
                    this.n.putAll(d.a.i0.n.l.a.b(e2));
                }
            }
        }
        if (q) {
            String str = this.f43493g;
            Log.i(str, "SoNodeHandler() start mUpdatings=" + this.m.size());
        }
        if (this.m.isEmpty()) {
            d0(null);
        }
    }

    @Override // d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        super.B(aVar);
        if (q) {
            String str = this.f43493g;
            Log.e(str, "onFetchError: " + aVar.toString());
        }
        d0(new Exception("failed by fetch error = " + aVar));
    }

    @Override // d.a.i0.n.f.g
    public void D() {
        super.D();
        if (q) {
            Log.e(this.f43493g, "onFetchSuccess:");
        }
    }

    @Override // d.a.i0.n.f.g
    public void E() {
        super.E();
        if (q) {
            Log.e(this.f43493g, "onNoPackage:");
        }
        d0(null);
    }

    @Override // d.a.i0.n.f.g
    public void F(d.a.i0.n.o.f fVar) {
        if (q) {
            String str = this.f43493g;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepareDownload: countSet.size=");
            sb.append(fVar == null ? 0 : fVar.l());
            Log.i(str, sb.toString());
        }
        super.F(fVar);
        if (fVar == null) {
            return;
        }
        this.j = fVar;
        if (fVar.i()) {
            return;
        }
        b0();
    }

    public final void Y(Exception exc) {
        if (q) {
            String str = this.f43493g;
            Log.i(str, "finishWithUpdatingCheck: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.a.i0.a.n0.k.e eVar : this.m.values()) {
            if (!eVar.n()) {
                if (q) {
                    String str2 = this.f43493g;
                    Log.i(str2, "finishWithUpdatingCheck: return by wait for=" + eVar);
                    return;
                }
                return;
            }
        }
        c0(exc);
    }

    public final d.a.i0.a.n0.k.e Z(String str) {
        d.a.i0.a.n0.k.e eVar = this.m.get(str);
        if (eVar == null || !eVar.r(this)) {
            return null;
        }
        return eVar;
    }

    public final h.j<i> a0() {
        if (this.f43495i == null) {
            this.f43495i = new C0751f(this, null);
        }
        return this.f43495i;
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
            String str = this.f43493g;
            Log.i(str, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
        }
        d.a.i0.a.n0.k.d dVar = this.o;
        if (dVar != null) {
            dVar.b(exc);
        }
    }

    public final void d0(Exception exc) {
        if (q) {
            String str = this.f43493g;
            Log.i(str, "notifyPmsFinish: updatings=" + this.m.size() + " e=" + exc);
        }
        for (d.a.i0.a.n0.k.e eVar : this.m.values()) {
            if (eVar != null && eVar.r(this) && !eVar.n() && !eVar.s()) {
                if (q) {
                    String str2 = this.f43493g;
                    Log.i(str2, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.q();
            }
        }
        Y(exc);
    }

    public final void e0(i iVar) {
        d.a.i0.a.h0.m.c.c().d(iVar, new d(iVar));
    }

    public final void f0(i iVar) {
        if (q) {
            String str = this.f43493g;
            Log.i(str, "SoNodeHandler updateBestSo start so=" + iVar);
        }
        if (iVar == null) {
            if (q) {
                Log.i(this.f43493g, "SoNodeHandler updateBestSo end by null so");
                return;
            }
            return;
        }
        d.a.i0.n.l.a aVar = this.n.get(iVar.f47836g);
        if (aVar == null) {
            if (q) {
                String str2 = this.f43493g;
                Log.i(str2, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.f47836g);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.p)) {
            iVar.p = aVar.f48007a;
        }
        d.a.i0.a.n0.k.e Z = Z(iVar.p);
        if (Z == null) {
            if (q) {
                String str3 = this.f43493g;
                Log.i(str3, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.p);
                return;
            }
            return;
        }
        if (iVar.q == null) {
            iVar.q = aVar.f48009c;
        }
        if (!AbiType.currentAbi().compat(iVar.q)) {
            if (q) {
                Log.i(this.f43493g, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i l = Z.l();
        i j = Z.j();
        long max = Math.max(j != null ? j.f47838i : 0L, l == null ? 0L : l.f47838i);
        long j2 = iVar.f47838i;
        if (j2 < max) {
            if (q) {
                Log.i(this.f43493g, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.f47838i)));
            }
        } else if (j2 > max) {
            if (q) {
                String str4 = this.f43493g;
                Log.i(str4, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.f47838i);
            }
            Z.w(this, iVar);
        } else {
            if (j == null || !j.q.compat(iVar.q)) {
                if (q) {
                    String str5 = this.f43493g;
                    Log.i(str5, "SoNodeHandler updateBestSo end by update abi update=" + iVar.q);
                }
                Z.w(this, iVar);
            }
            if (q) {
                Log.i(this.f43493g, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // d.a.i0.n.k.a.a
    public d.a.i0.n.j.c<JSONArray> g() {
        return this.p;
    }

    @Override // d.a.i0.n.k.a.a
    @Nullable
    public d.a.i0.n.i.m.g getRequest() {
        return this.k;
    }

    @Override // d.a.i0.n.j.k.c
    public void handle() {
        d.a.i0.n.j.k.a aVar = new d.a.i0.n.j.k.a();
        d.a.i0.n.o.f fVar = new d.a.i0.n.o.f();
        if (q) {
            Log.i(this.f43493g, "SoNodeHandler handle for loop start");
        }
        boolean z = true;
        if ((q && !q0.G() && d.a.i0.a.u1.a.a.j() == 1) ? false : false) {
            String i2 = d.a.i0.a.u1.a.a.i();
            if (!TextUtils.isEmpty(i2)) {
                try {
                    i iVar = (i) d.a.i0.n.o.e.i(new JSONObject(i2), new i());
                    iVar.f47836g = "so_zeus_armeabi";
                    f0(iVar);
                    d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_success)).F();
                } catch (JSONException e2) {
                    d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), AppRuntime.getAppContext().getString(h.swan_app_debug_so_info_error)).F();
                    e2.printStackTrace();
                }
            }
        }
        for (d.a.i0.a.n0.k.e eVar : this.m.values()) {
            if (eVar.r(this)) {
                f0(eVar.l());
                i j = eVar.j();
                if (eVar.p() && j != null) {
                    if (q) {
                        String str = this.f43493g;
                        Log.i(str, "SoNodeHandler handle for bestSo=" + j);
                    }
                    d.a.i0.n.j.k.b.b(j, fVar);
                    if (aVar.f48000d == null) {
                        aVar.f48000d = new ArrayList();
                    }
                    aVar.f48000d.add(j);
                } else {
                    if (q) {
                        Log.i(this.f43493g, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.q();
                }
            }
        }
        if (q) {
            Log.i(this.f43493g, "SoNodeHandler handle for loop end");
            String str2 = this.f43493g;
            Log.i(str2, "SoNodeHandler handle soSet.pkgSize()=" + fVar.l());
        }
        if (fVar.l() == 0) {
            if (q) {
                Log.i(this.f43493g, "SoNodeHandler handle end by no pkg");
            }
            E();
            return;
        }
        if (q) {
            Log.i(this.f43493g, "SoNodeHandler handle end by start dl");
        }
        F(fVar);
        d.a.i0.n.i.i.a.e(aVar, this);
    }

    @Override // d.a.i0.n.j.k.c
    public void l(JSONObject jSONObject) {
        if (q) {
            String str = this.f43493g;
            Log.i(str, "SoNodeHandler parseData start data=" + jSONObject);
        }
        if (jSONObject != null) {
            f0((i) d.a.i0.n.o.e.i(jSONObject, new i()));
        }
    }

    @Override // d.a.i0.n.k.a.a
    public d.a.i0.n.f.g o() {
        return this;
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.j.k.c v(String str) {
        return TextUtils.equals("so", str) ? this : super.v(str);
    }

    @Override // d.a.i0.n.f.g
    public d.a.i0.n.f.c<i> y() {
        if (this.l == null) {
            this.l = new g(this, null);
        }
        return this.l;
    }
}
