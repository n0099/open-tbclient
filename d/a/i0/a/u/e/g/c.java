package d.a.i0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.d f44750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44751f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44752g;

        public a(d.a.i0.a.h0.g.d dVar, String str, String str2) {
            this.f44750e = dVar;
            this.f44751f = str;
            this.f44752g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.h0.g.d dVar = this.f44750e;
            boolean z = true;
            if (!((dVar == null || !dVar.o2(this.f44751f, true)) ? false : false)) {
                d.a.i0.a.e0.d.b("Api-NavigationBar", "set title fail");
                c.this.d(this.f44752g, new d.a.i0.a.u.h.b(1001));
            }
            c.this.d(this.f44752g, new d.a.i0.a.u.h.b(0));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.d f44754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44755f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44756g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44757h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44758i;

        public b(d.a.i0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f44754e = dVar;
            this.f44755f = str;
            this.f44756g = str2;
            this.f44757h = str3;
            this.f44758i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.h0.g.d dVar = this.f44754e;
            if (dVar != null && dVar.v2(this.f44755f, true)) {
                if (!this.f44754e.m2(SwanAppConfigData.s(this.f44757h), true)) {
                    d.a.i0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                    c.this.d(this.f44756g, new d.a.i0.a.u.h.b(1001));
                    return;
                }
                JSONObject jSONObject = this.f44758i;
                if (jSONObject != null) {
                    this.f44754e.k2(jSONObject.optInt("duration"), this.f44758i.optString("timingFunc"));
                    d.a.i0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.d(this.f44756g, new d.a.i0.a.u.h.b(0));
                return;
            }
            d.a.i0.a.e0.d.b("Api-NavigationBar", "set title color fail");
            c.this.d(this.f44756g, new d.a.i0.a.u.h.b(1001));
        }
    }

    /* renamed from: d.a.i0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0833c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.d f44759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44760f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44761g;

        public RunnableC0833c(d.a.i0.a.h0.g.d dVar, String str, boolean z) {
            this.f44759e = dVar;
            this.f44760f = str;
            this.f44761g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean O1;
            d.a.i0.a.h0.g.d dVar = this.f44759e;
            if (dVar == null) {
                d.a.i0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.d(this.f44760f, new d.a.i0.a.u.h.b(1001));
                return;
            }
            if (this.f44761g) {
                O1 = dVar.D2();
            } else {
                O1 = dVar.O1();
            }
            if (!O1) {
                String str = this.f44761g ? "show" : "hide";
                d.a.i0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.d(this.f44760f, new d.a.i0.a.u.h.b(1001));
                return;
            }
            c.this.d(this.f44760f, new d.a.i0.a.u.h.b(0));
        }
    }

    public c(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public final d.a.i0.a.u.h.b r(String str, boolean z) {
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.i0.a.u.h.b(1001);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new RunnableC0833c(W.m(), optString, z));
        return new d.a.i0.a.u.h.b(0);
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return r(str, false);
    }

    public d.a.i0.a.u.h.b t(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.i0.a.u.h.b(1001);
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new b(W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
        return new d.a.i0.a.u.h.b(0);
    }

    public d.a.i0.a.u.h.b u(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-NavigationBar", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject == null) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
            return new d.a.i0.a.u.h.b(1001);
        }
        String optString = jSONObject.optString("title");
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W == null) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "manager is null");
            return new d.a.i0.a.u.h.b(1001);
        }
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.i0.a.e0.d.b("Api-NavigationBar", "callback is null");
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new a(W.m(), optString, optString2));
        return new d.a.i0.a.u.h.b(0);
    }

    public d.a.i0.a.u.h.b v(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q != null && Q.d0()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.a.i0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
        }
        return r(str, true);
    }
}
