package d.b.g0.a.w0.b;

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
import d.b.g0.a.a2.g.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.l;
import d.b.g0.l.l.k.b;
import d.b.g0.l.m.i.g;
import d.b.g0.n.n;
import d.b.g0.n.q;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.b.g0.l.b {

    /* renamed from: d.b.g0.a.w0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0870a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f46852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.l.m.i.f f46853f;

        /* renamed from: d.b.g0.a.w0.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0871a extends d.b.g0.a.e0.p.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f46854a;

            public C0871a(AtomicInteger atomicInteger) {
                this.f46854a = atomicInteger;
            }

            @Override // d.b.g0.a.e0.p.a
            public void c() {
                if (this.f46854a.get() == 0) {
                    g.a().c(RunnableC0870a.this.f46853f);
                }
            }

            @Override // d.b.g0.a.e0.p.a
            public void d(d.b.g0.l.k.a aVar) {
                int i;
                super.d(aVar);
                if (aVar == null || (i = aVar.f48913a) == 1010 || i == 1015) {
                    return;
                }
                this.f46854a.incrementAndGet();
            }

            @Override // d.b.g0.a.e0.p.a
            public void f() {
                if (this.f46854a.get() == 0) {
                    g.a().c(RunnableC0870a.this.f46853f);
                }
            }
        }

        public RunnableC0870a(a aVar, Set set, d.b.g0.l.m.i.f fVar) {
            this.f46852e = set;
            this.f46853f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (String str : this.f46852e) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new b.a(str, 0));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.b.g0.a.e0.h.a.a.b(arrayList, "3", new C0871a(atomicInteger));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a2.g.b f46856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46857f;

        public b(a aVar, d.b.g0.a.a2.g.b bVar, JSONObject jSONObject) {
            this.f46856e = bVar;
            this.f46857f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.g1.o.a.h().r(this.f46856e, this.f46857f);
        }
    }

    @Override // d.b.g0.l.b
    public String A() {
        return ProcessUtils.getCurProcessName();
    }

    @Override // d.b.g0.l.b
    public d.b.g0.l.l.f B() {
        return d.b.g0.a.r1.d.e().y();
    }

    @Override // d.b.g0.l.b
    public String C() {
        return d.b.g0.a.l0.b.c(0);
    }

    @Override // d.b.g0.l.b
    public CookieManager a() {
        return d.b.g0.a.w0.a.m().a();
    }

    @Override // d.b.g0.l.b
    public String b() {
        return l.a();
    }

    @Override // d.b.g0.l.b
    public boolean isDebug() {
        return k.f45050a;
    }

    @Override // d.b.g0.l.b
    public String l() {
        return d.b.g0.a.b2.b.f(0);
    }

    @Override // d.b.g0.l.b
    public String m() {
        return d.b.g0.a.b2.b.f(1);
    }

    @Override // d.b.g0.l.b
    public void n(JSONArray jSONArray, String str, String str2) {
        d.b.g0.a.t1.k.g0.a.c().l(jSONArray, str, str2);
    }

    @Override // d.b.g0.l.b
    public String o() {
        return d.b.g0.a.w0.a.O().c(AppRuntime.getAppContext());
    }

    @Override // d.b.g0.l.b
    public void p(d.b.g0.l.m.h.a aVar) {
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
            if (d.b.g0.a.r1.e.x) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.k().s(qVar);
        } catch (JSONException e2) {
            if (d.b.g0.a.r1.e.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.g0.l.b
    public String q() {
        return k0.z();
    }

    @Override // d.b.g0.l.b
    public String r() {
        return d.b.g0.a.w0.a.l().F();
    }

    @Override // d.b.g0.l.b
    public String s() {
        return d.b.g0.a.w0.a.k().g();
    }

    @Override // d.b.g0.l.b
    public String t() {
        return d.b.g0.a.l0.b.c(1);
    }

    @Override // d.b.g0.l.b
    public String u() {
        return d.b.g0.a.w0.a.N().c();
    }

    @Override // d.b.g0.l.b
    public void v(d.b.g0.l.m.i.f fVar) {
        Set<String> b2;
        if (fVar == null || (b2 = fVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new RunnableC0870a(this, b2, fVar), "preloadPkg", 2);
    }

    @Override // d.b.g0.l.b
    public String w() {
        return d.b.g0.a.b0.c.l();
    }

    @Override // d.b.g0.l.b
    public void x(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        if (pMSAppInfo == null) {
            if (d.b.g0.a.r1.e.x) {
                Log.e("SwanAppUpdateManager", "pms app info is null");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appKey;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            int i = pMSAppInfo.type;
            d.b.g0.a.a2.g.b b2 = h.b(d.b.g0.a.a2.b.e(str, i));
            b2.putBoolean("swan_service_update_degraded", z);
            if (d.b.g0.a.r1.e.x) {
                Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
            }
            if (!d.b.g0.a.j1.m.c.i()) {
                if (d.b.g0.a.r1.e.x) {
                    Log.e("SwanAppUpdateManager", "async update ab is closed");
                    return;
                }
                return;
            }
            p.l(new b(this, b2, jSONObject), "parseAccreditList");
        } else if (d.b.g0.a.r1.e.x) {
            Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
        }
    }

    @Override // d.b.g0.l.b
    public String y() {
        return d.b.g0.q.b.b(AppRuntime.getAppContext()).a();
    }

    @Override // d.b.g0.l.b
    public void z(String str, String str2, String str3, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str);
            jSONObject2.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("page", str3);
            }
            jSONObject2.put("value", String.valueOf(i));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            d.b.g0.a.z1.b.j("874", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
