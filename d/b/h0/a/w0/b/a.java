package d.b.h0.a.w0.b;

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
import d.b.h0.a.a2.g.h;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.l;
import d.b.h0.l.l.k.b;
import d.b.h0.l.m.i.g;
import d.b.h0.n.n;
import d.b.h0.n.q;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class a implements d.b.h0.l.b {

    /* renamed from: d.b.h0.a.w0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0903a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f47574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.l.m.i.f f47575f;

        /* renamed from: d.b.h0.a.w0.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0904a extends d.b.h0.a.e0.p.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f47576a;

            public C0904a(AtomicInteger atomicInteger) {
                this.f47576a = atomicInteger;
            }

            @Override // d.b.h0.a.e0.p.a
            public void c() {
                if (this.f47576a.get() == 0) {
                    g.a().c(RunnableC0903a.this.f47575f);
                }
            }

            @Override // d.b.h0.a.e0.p.a
            public void d(d.b.h0.l.k.a aVar) {
                int i;
                super.d(aVar);
                if (aVar == null || (i = aVar.f49635a) == 1010 || i == 1015) {
                    return;
                }
                this.f47576a.incrementAndGet();
            }

            @Override // d.b.h0.a.e0.p.a
            public void f() {
                if (this.f47576a.get() == 0) {
                    g.a().c(RunnableC0903a.this.f47575f);
                }
            }
        }

        public RunnableC0903a(a aVar, Set set, d.b.h0.l.m.i.f fVar) {
            this.f47574e = set;
            this.f47575f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (String str : this.f47574e) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new b.a(str, 0));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d.b.h0.a.e0.h.a.a.b(arrayList, "3", new C0904a(atomicInteger));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a2.g.b f47578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47579f;

        public b(a aVar, d.b.h0.a.a2.g.b bVar, JSONObject jSONObject) {
            this.f47578e = bVar;
            this.f47579f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.g1.o.a.h().r(this.f47578e, this.f47579f);
        }
    }

    @Override // d.b.h0.l.b
    public String A() {
        return ProcessUtils.getCurProcessName();
    }

    @Override // d.b.h0.l.b
    public d.b.h0.l.l.f B() {
        return d.b.h0.a.r1.d.e().y();
    }

    @Override // d.b.h0.l.b
    public String C() {
        return d.b.h0.a.l0.b.c(0);
    }

    @Override // d.b.h0.l.b
    public CookieManager a() {
        return d.b.h0.a.w0.a.m().a();
    }

    @Override // d.b.h0.l.b
    public String b() {
        return l.a();
    }

    @Override // d.b.h0.l.b
    public boolean isDebug() {
        return k.f45772a;
    }

    @Override // d.b.h0.l.b
    public String l() {
        return d.b.h0.a.b2.b.f(0);
    }

    @Override // d.b.h0.l.b
    public String m() {
        return d.b.h0.a.b2.b.f(1);
    }

    @Override // d.b.h0.l.b
    public void n(JSONArray jSONArray, String str, String str2) {
        d.b.h0.a.t1.k.g0.a.c().l(jSONArray, str, str2);
    }

    @Override // d.b.h0.l.b
    public String o() {
        return d.b.h0.a.w0.a.O().c(AppRuntime.getAppContext());
    }

    @Override // d.b.h0.l.b
    public void p(d.b.h0.l.m.h.a aVar) {
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
            if (d.b.h0.a.r1.e.x) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            q qVar = new q("0", jSONObject);
            qVar.e();
            n.k().s(qVar);
        } catch (JSONException e2) {
            if (d.b.h0.a.r1.e.x) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.h0.l.b
    public String q() {
        return k0.z();
    }

    @Override // d.b.h0.l.b
    public String r() {
        return d.b.h0.a.w0.a.l().F();
    }

    @Override // d.b.h0.l.b
    public String s() {
        return d.b.h0.a.w0.a.k().g();
    }

    @Override // d.b.h0.l.b
    public String t() {
        return d.b.h0.a.l0.b.c(1);
    }

    @Override // d.b.h0.l.b
    public String u() {
        return d.b.h0.a.w0.a.N().c();
    }

    @Override // d.b.h0.l.b
    public void v(d.b.h0.l.m.i.f fVar) {
        Set<String> b2;
        if (fVar == null || (b2 = fVar.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new RunnableC0903a(this, b2, fVar), "preloadPkg", 2);
    }

    @Override // d.b.h0.l.b
    public String w() {
        return d.b.h0.a.b0.c.l();
    }

    @Override // d.b.h0.l.b
    public void x(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        if (pMSAppInfo == null) {
            if (d.b.h0.a.r1.e.x) {
                Log.e("SwanAppUpdateManager", "pms app info is null");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appKey;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            int i = pMSAppInfo.type;
            d.b.h0.a.a2.g.b b2 = h.b(d.b.h0.a.a2.b.e(str, i));
            b2.putBoolean("swan_service_update_degraded", z);
            if (d.b.h0.a.r1.e.x) {
                Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
            }
            if (!d.b.h0.a.j1.m.c.i()) {
                if (d.b.h0.a.r1.e.x) {
                    Log.e("SwanAppUpdateManager", "async update ab is closed");
                    return;
                }
                return;
            }
            p.l(new b(this, b2, jSONObject), "parseAccreditList");
        } else if (d.b.h0.a.r1.e.x) {
            Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
        }
    }

    @Override // d.b.h0.l.b
    public String y() {
        return d.b.h0.q.b.b(AppRuntime.getAppContext()).a();
    }

    @Override // d.b.h0.l.b
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
            d.b.h0.a.z1.b.j("874", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
