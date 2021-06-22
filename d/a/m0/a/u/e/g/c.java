package d.a.m0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.m0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.d f48708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48710g;

        public a(d.a.m0.a.h0.g.d dVar, String str, String str2) {
            this.f48708e = dVar;
            this.f48709f = str;
            this.f48710g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.h0.g.d dVar = this.f48708e;
            boolean z = true;
            if (!((dVar == null || !dVar.o2(this.f48709f, true)) ? false : false)) {
                d.a.m0.a.e0.d.b("Api-NavigationBar", "set title fail");
                c.this.d(this.f48710g, new d.a.m0.a.u.h.b(1001));
            }
            c.this.d(this.f48710g, new d.a.m0.a.u.h.b(0));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.d f48712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48714g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48715h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48716i;

        public b(d.a.m0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f48712e = dVar;
            this.f48713f = str;
            this.f48714g = str2;
            this.f48715h = str3;
            this.f48716i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.h0.g.d dVar = this.f48712e;
            if (dVar != null && dVar.v2(this.f48713f, true)) {
                if (!this.f48712e.m2(SwanAppConfigData.s(this.f48715h), true)) {
                    d.a.m0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                    c.this.d(this.f48714g, new d.a.m0.a.u.h.b(1001));
                    return;
                }
                JSONObject jSONObject = this.f48716i;
                if (jSONObject != null) {
                    this.f48712e.k2(jSONObject.optInt("duration"), this.f48716i.optString("timingFunc"));
                    d.a.m0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.d(this.f48714g, new d.a.m0.a.u.h.b(0));
                return;
            }
            d.a.m0.a.e0.d.b("Api-NavigationBar", "set title color fail");
            c.this.d(this.f48714g, new d.a.m0.a.u.h.b(1001));
        }
    }

    /* renamed from: d.a.m0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0903c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.d f48717e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48718f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48719g;

        public RunnableC0903c(d.a.m0.a.h0.g.d dVar, String str, boolean z) {
            this.f48717e = dVar;
            this.f48718f = str;
            this.f48719g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean O1;
            d.a.m0.a.h0.g.d dVar = this.f48717e;
            if (dVar == null) {
                d.a.m0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.d(this.f48718f, new d.a.m0.a.u.h.b(1001));
                return;
            }
            if (this.f48719g) {
                O1 = dVar.D2();
            } else {
                O1 = dVar.O1();
            }
            if (!O1) {
                String str = this.f48719g ? "show" : "hide";
                d.a.m0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.d(this.f48718f, new d.a.m0.a.u.h.b(1001));
                return;
            }
            c.this.d(this.f48718f, new d.a.m0.a.u.h.b(0));
        }
    }

    public c(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final d.a.m0.a.u.h.b r(String str, boolean z) {
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.m0.a.u.h.b(1001);
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.m0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new RunnableC0903c(W.m(), optString, z));
        return new d.a.m0.a.u.h.b(0);
    }

    public d.a.m0.a.u.h.b s(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return r(str, false);
    }

    public d.a.m0.a.u.h.b t(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.m0.a.u.h.b(1001);
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.m0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new b(W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
        return new d.a.m0.a.u.h.b(0);
    }

    public d.a.m0.a.u.h.b u(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
            return new d.a.m0.a.u.h.b(1001);
        }
        String optString = jSONObject.optString("title");
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.m0.a.u.h.b(1001);
        }
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.m0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.m0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new a(W.m(), optString, optString2));
        return new d.a.m0.a.u.h.b(0);
    }

    public d.a.m0.a.u.h.b v(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q != null && Q.d0()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.a.m0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
        }
        return r(str, true);
    }
}
