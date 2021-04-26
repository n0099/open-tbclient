package d.a.h0.a.w0.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.l;
import d.a.h0.l.l.k.b;
import d.a.h0.l.m.i.g;
import d.a.h0.n.n;
import d.a.h0.n.q;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements d.a.h0.l.b {

    /* renamed from: d.a.h0.a.w0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0842a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f44999e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.l.m.i.f f45000f;

        /* renamed from: d.a.h0.a.w0.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0843a extends d.a.h0.a.e0.p.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f45001a;

            public C0843a(AtomicInteger atomicInteger) {
                this.f45001a = atomicInteger;
            }

            @Override // d.a.h0.a.e0.p.a
            public void c() {
                if (this.f45001a.get() == 0) {
                    g.a().c(RunnableC0842a.this.f45000f);
                }
            }

            @Override // d.a.h0.a.e0.p.a
            public void d(d.a.h0.l.k.a aVar) {
                int i2;
                super.d(aVar);
                if (aVar == null || (i2 = aVar.f47144a) == 1010 || i2 == 1015) {
                    return;
                }
                this.f45001a.incrementAndGet();
            }

            @Override // d.a.h0.a.e0.p.a
            public void f() {
                if (this.f45001a.get() == 0) {
                    g.a().c(RunnableC0842a.this.f45000f);
                }
            }
        }

        public RunnableC0842a(a aVar, Set set, d.a.h0.l.m.i.f fVar) {
            this.f44999e = set;
            this.f45000f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (String str : this.f44999e) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new b.a(str, 0));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.a.h0.a.e0.h.a.a.b(arrayList, "3", new C0843a(atomicInteger));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a2.g.b f45003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45004f;

        public b(a aVar, d.a.h0.a.a2.g.b bVar, JSONObject jSONObject) {
            this.f45003e = bVar;
            this.f45004f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.g1.o.a.h().r(this.f45003e, this.f45004f);
        }
    }

    @Override // d.a.h0.l.b
    public void A(d.a.h0.l.m.i.f fVar) {
        Set<String> b2;
        if (fVar == null || (b2 = fVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new RunnableC0842a(this, b2, fVar), "preloadPkg", 2);
    }

    @Override // d.a.h0.l.b
    public String B() {
        return d.a.h0.a.b0.c.l();
    }

    @Override // d.a.h0.l.b
    public d.a.h0.l.l.f C() {
        return d.a.h0.a.r1.d.e().h();
    }

    @Override // d.a.h0.l.b
    public CookieManager a() {
        return d.a.h0.a.w0.a.m().a();
    }

    @Override // d.a.h0.l.b
    public String i() {
        return l.a();
    }

    @Override // d.a.h0.l.b
    public boolean isDebug() {
        return k.f43101a;
    }

    @Override // d.a.h0.l.b
    public String l() {
        return d.a.h0.a.b2.b.f(0);
    }

    @Override // d.a.h0.l.b
    public String m() {
        return d.a.h0.a.b2.b.f(1);
    }

    @Override // d.a.h0.l.b
    public void n(JSONArray jSONArray, String str, String str2) {
        d.a.h0.a.t1.k.g0.a.c().l(jSONArray, str, str2);
    }

    @Override // d.a.h0.l.b
    public String o() {
        return d.a.h0.a.w0.a.k().f();
    }

    @Override // d.a.h0.l.b
    public String p() {
        return d.a.h0.a.l0.b.c(1);
    }

    @Override // d.a.h0.l.b
    public String q() {
        return d.a.h0.a.w0.a.N().b();
    }

    @Override // d.a.h0.l.b
    public void r(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        if (pMSAppInfo == null) {
            if (d.a.h0.a.r1.e.x) {
                Log.e("SwanAppUpdateManager", "pms app info is null");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appKey;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            int i2 = pMSAppInfo.type;
            d.a.h0.a.a2.g.b b2 = h.b(d.a.h0.a.a2.b.e(str, i2));
            b2.putBoolean("swan_service_update_degraded", z);
            if (d.a.h0.a.r1.e.x) {
                Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i2 + " ; serviceDegraded = " + z);
            }
            if (!d.a.h0.a.j1.m.c.i()) {
                if (d.a.h0.a.r1.e.x) {
                    Log.e("SwanAppUpdateManager", "async update ab is closed");
                    return;
                }
                return;
            }
            p.l(new b(this, b2, jSONObject), "parseAccreditList");
        } else if (d.a.h0.a.r1.e.x) {
            Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
        }
    }

    @Override // d.a.h0.l.b
    public String s() {
        return d.a.h0.q.b.b(AppRuntime.getAppContext()).a();
    }

    @Override // d.a.h0.l.b
    public void t(String str, String str2, String str3, int i2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str);
            jSONObject2.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("page", str3);
            }
            jSONObject2.put("value", String.valueOf(i2));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            d.a.h0.a.z1.b.j("874", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.h0.l.b
    public String u() {
        return ProcessUtils.getCurProcessName();
    }

    @Override // d.a.h0.l.b
    public String v() {
        return d.a.h0.a.l0.b.c(0);
    }

    @Override // d.a.h0.l.b
    public String w() {
        return d.a.h0.a.w0.a.O().f(AppRuntime.getAppContext());
    }

    @Override // d.a.h0.l.b
    public void x(d.a.h0.l.m.h.a aVar) {
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
            if (d.a.h0.a.r1.e.x) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.k().s(qVar);
        } catch (JSONException e2) {
            if (d.a.h0.a.r1.e.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.h0.l.b
    public String y() {
        return k0.z();
    }

    @Override // d.a.h0.l.b
    public String z() {
        return d.a.h0.a.w0.a.l().o();
    }
}
