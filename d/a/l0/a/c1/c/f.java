package d.a.l0.a.c1.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import d.a.l0.a.l;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.u0;
import d.a.l0.n.i.a;
import d.a.l0.n.i.m.b;
import d.a.l0.r.n;
import d.a.l0.r.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class f implements d.a.l0.n.a {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f40936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.n.j.i.j f40937f;

        /* renamed from: d.a.l0.a.c1.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0578a extends d.a.l0.a.h0.m.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f40938a;

            public C0578a(AtomicInteger atomicInteger) {
                this.f40938a = atomicInteger;
            }

            @Override // d.a.l0.a.h0.m.a
            public void d() {
                if (this.f40938a.get() == 0) {
                    d.a.l0.n.j.i.k.a().c(a.this.f40937f);
                }
            }

            @Override // d.a.l0.a.h0.m.a
            public void e(d.a.l0.n.h.a aVar) {
                int i2;
                super.e(aVar);
                if (aVar == null || (i2 = aVar.f48002a) == 1010 || i2 == 1015) {
                    return;
                }
                this.f40938a.incrementAndGet();
            }

            @Override // d.a.l0.a.h0.m.a
            public void g() {
                if (this.f40938a.get() == 0) {
                    d.a.l0.n.j.i.k.a().c(a.this.f40937f);
                }
            }
        }

        public a(f fVar, Set set, d.a.l0.n.j.i.j jVar) {
            this.f40936e = set;
            this.f40937f = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (String str : this.f40936e) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new b.a(str, 0));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.a.l0.a.h0.c.a.b.b(arrayList, "3", new C0578a(atomicInteger));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.k2.g.b f40940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40941f;

        public b(f fVar, d.a.l0.a.k2.g.b bVar, JSONObject jSONObject) {
            this.f40940e = bVar;
            this.f40941f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.n1.q.a.g().q(this.f40940e, this.f40941f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.h0.j.b<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.n.h.h f40942a;

        public c(f fVar, d.a.l0.n.h.h hVar) {
            this.f40942a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            d.a.l0.a.t1.d.a.a("download plugin result = " + bool);
            d.a.l0.a.t1.e.a.b(this.f40942a.f48012g);
        }
    }

    @Override // d.a.l0.n.a
    public void A(d.a.l0.n.j.h.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            JSONObject b2 = aVar.b();
            JSONArray a2 = aVar.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (d.a.l0.a.a2.e.y) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.f().o(qVar);
        } catch (JSONException e2) {
            if (d.a.l0.a.a2.e.y) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.l0.n.a
    public String B() {
        return d.a.l0.a.c1.a.n().p();
    }

    @Override // d.a.l0.n.a
    public int C(String str, int i2) {
        d.a.l0.a.c1.a.Z().getSwitch(str, i2);
        return i2;
    }

    @Override // d.a.l0.n.a
    public void D(d.a.l0.n.j.i.j jVar) {
        Set<String> b2;
        if (jVar == null || (b2 = jVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, jVar), "preloadPkg", 2);
    }

    @Override // d.a.l0.n.a
    public String E() {
        return d.a.l0.a.d0.c.m();
    }

    @Override // d.a.l0.n.a
    public String F(int i2) {
        return d.a.l0.a.m2.b.h(i2);
    }

    @Override // d.a.l0.n.a
    public void G(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        d.a.l0.a.j2.q.a.d(str, str2, str3, i2, jSONObject, z);
    }

    @Override // d.a.l0.n.a
    public d.a.l0.n.i.g H() {
        return d.a.l0.a.a2.d.g().j();
    }

    @Override // d.a.l0.n.a
    public boolean I(String str, boolean z) {
        d.a.l0.a.c1.a.Z().getSwitch(str, z);
        return z;
    }

    @Override // d.a.l0.n.a
    public float a() {
        return d.a.l0.a.c1.a.l().a();
    }

    @Override // d.a.l0.n.a
    public String b() {
        return l.a();
    }

    @Override // d.a.l0.n.a
    public String c() {
        return d.a.l0.a.c1.a.m().a();
    }

    @Override // d.a.l0.n.a
    public void d(byte[] bArr) {
        d.a.l0.a.c1.a.d().d(bArr);
    }

    @Override // d.a.l0.n.a
    public String e() {
        return d.a.l0.u.b.b(AppRuntime.getAppContext()).a();
    }

    @Override // d.a.l0.n.a
    public boolean f() {
        return d.a.l0.a.c1.a.w().f();
    }

    @Override // d.a.l0.n.a
    public CookieManager g() {
        return d.a.l0.a.c1.a.p().a();
    }

    @Override // d.a.l0.n.a
    public String h() {
        return d.a.l0.a.c1.a.a0().i(AppRuntime.getAppContext());
    }

    @Override // d.a.l0.n.a
    public String i() {
        return q0.D();
    }

    @Override // d.a.l0.n.a
    public boolean isDebug() {
        return d.a.l0.a.k.f43199a;
    }

    @Override // d.a.l0.n.a
    public d.a.l0.t.b j() {
        return d.a.l0.a.k2.g.h.b("swan_app_pms_sp");
    }

    @Override // d.a.l0.n.a
    public long k(int i2) {
        return d.a.l0.a.p0.b.d(i2);
    }

    @Override // d.a.l0.n.a
    public void l(JSONArray jSONArray, String str, String str2) {
        d.a.l0.a.c2.f.g0.d.b().n(jSONArray, str, str2);
    }

    @Override // d.a.l0.n.a
    public void m(String str, String str2, a.c cVar) {
        d.a.l0.a.c1.a.d().f(str, str2, cVar);
    }

    @Override // d.a.l0.n.a
    public d.a.l0.n.i.g n() {
        return new d.a.l0.a.h0.m.n.c(d.a.l0.a.a2.d.g());
    }

    @Override // d.a.l0.n.a
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        return new d.a.l0.a.v2.b1.b.a(z).c(jSONArray);
    }

    @Override // d.a.l0.n.a
    public void p(String str, JSONObject jSONObject, d.a.l0.n.h.f fVar, List<d.a.l0.n.h.g> list) {
        d.a.l0.a.l1.d.c.g(str, jSONObject, fVar, list);
    }

    @Override // d.a.l0.n.a
    public String q() {
        return d.a.l0.a.c1.a.Z().k();
    }

    @Override // d.a.l0.n.a
    public void r(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        if (pMSAppInfo == null) {
            if (d.a.l0.a.a2.e.y) {
                Log.e("SwanAppUpdateManager", "pms app info is null");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appKey;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            int i2 = pMSAppInfo.type;
            d.a.l0.a.k2.g.b b2 = d.a.l0.a.k2.g.h.b(d.a.l0.a.k2.b.u(str, i2));
            b2.putBoolean("swan_service_update_degraded", z);
            d.a.l0.a.e0.d.h("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i2 + " ; serviceDegraded = " + z);
            d.a.l0.a.v2.q.k(new b(this, b2, jSONObject), "parseAccreditList");
        } else if (d.a.l0.a.a2.e.y) {
            Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
        }
    }

    @Override // d.a.l0.n.a
    public void s(d.a.l0.n.j.k.a aVar, d.a.l0.n.o.f fVar) {
        Collection<d.a.l0.n.h.h> collection;
        if (aVar == null || (collection = aVar.f48177e) == null || fVar == null) {
            return;
        }
        for (d.a.l0.n.h.h hVar : collection) {
            d.a.l0.a.t1.a.a aVar2 = new d.a.l0.a.t1.a.a(hVar.f48012g, hVar.j, hVar.f48014i, new c(this, hVar));
            d.a.l0.n.j.k.a aVar3 = new d.a.l0.n.j.k.a();
            aVar3.f48177e = new ArrayList();
            d.a.l0.n.o.f fVar2 = new d.a.l0.n.o.f();
            d.a.l0.n.j.k.b.b(hVar, fVar2);
            aVar2.F(fVar2);
            aVar3.f48177e.clear();
            aVar3.f48177e.add(hVar);
            d.a.l0.n.i.i.a.e(aVar3, aVar2);
        }
    }

    @Override // d.a.l0.n.a
    public String t() {
        return d.a.l0.a.r1.l.d.a();
    }

    @Override // d.a.l0.n.a
    public String u(int i2) {
        return d.a.l0.a.p0.b.e(i2);
    }

    @Override // d.a.l0.n.a
    public String v() {
        return ProcessUtils.getCurProcessName();
    }

    @Override // d.a.l0.n.a
    public long w(int i2) {
        return d.a.l0.a.m2.b.f(i2);
    }

    @Override // d.a.l0.n.a
    public void x(String str, String str2) {
        d.a.l0.a.e0.d.h(str, str2);
    }

    @Override // d.a.l0.n.a
    public d.a.l0.n.i.j.b y() {
        return d.a.l0.a.c1.a.i0();
    }

    @Override // d.a.l0.n.a
    public void z() {
        u0.j().l();
    }
}
