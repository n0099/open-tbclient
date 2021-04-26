package d.a.h0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.c f44098e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44099f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44100g;

        public a(d.a.h0.a.e0.l.c cVar, String str, String str2) {
            this.f44098e = cVar;
            this.f44099f = str;
            this.f44100g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.e0.l.c cVar = this.f44098e;
            boolean z = true;
            if (!((cVar == null || !cVar.i2(this.f44099f, true)) ? false : false)) {
                d.a.h0.a.c0.c.b("Api-NavigationBar", "set title fail");
                c.this.c(this.f44100g, new d.a.h0.a.t.e.b(1001));
            }
            c.this.c(this.f44100g, new d.a.h0.a.t.e.b(0));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.c f44102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44103f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44104g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44105h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44106i;

        public b(d.a.h0.a.e0.l.c cVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f44102e = cVar;
            this.f44103f = str;
            this.f44104g = str2;
            this.f44105h = str3;
            this.f44106i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.e0.l.c cVar = this.f44102e;
            if (cVar != null && cVar.p2(this.f44103f, true)) {
                if (!this.f44102e.g2(SwanAppConfigData.s(this.f44105h), true)) {
                    d.a.h0.a.c0.c.b("Api-NavigationBar", "set title background fail");
                    c.this.c(this.f44104g, new d.a.h0.a.t.e.b(1001));
                    return;
                }
                JSONObject jSONObject = this.f44106i;
                if (jSONObject != null) {
                    this.f44102e.e2(jSONObject.optInt("duration"), this.f44106i.optString("timingFunc"));
                    d.a.h0.a.c0.c.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.c(this.f44104g, new d.a.h0.a.t.e.b(0));
                return;
            }
            d.a.h0.a.c0.c.b("Api-NavigationBar", "set title color fail");
            c.this.c(this.f44104g, new d.a.h0.a.t.e.b(1001));
        }
    }

    /* renamed from: d.a.h0.a.t.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0778c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.c f44107e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44109g;

        public RunnableC0778c(d.a.h0.a.e0.l.c cVar, String str, boolean z) {
            this.f44107e = cVar;
            this.f44108f = str;
            this.f44109g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean J1;
            d.a.h0.a.e0.l.c cVar = this.f44107e;
            if (cVar == null) {
                d.a.h0.a.c0.c.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.c(this.f44108f, new d.a.h0.a.t.e.b(1001));
                return;
            }
            if (this.f44109g) {
                J1 = cVar.x2();
            } else {
                J1 = cVar.J1();
            }
            if (!J1) {
                String str = this.f44109g ? "show" : "hide";
                d.a.h0.a.c0.c.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.c(this.f44108f, new d.a.h0.a.t.e.b(1001));
                return;
            }
            c.this.c(this.f44108f, new d.a.h0.a.t.e.b(0));
        }
    }

    public c(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final d.a.h0.a.t.e.b q(String str, boolean z) {
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.a.h0.a.t.e.b(1001);
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.a.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new RunnableC0778c(W.m(), optString, z));
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b r(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return q(str, false);
    }

    public d.a.h0.a.t.e.b s(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.a.h0.a.t.e.b(1001);
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.a.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new b(W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b t(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "paramsJson is null");
            return new d.a.h0.a.t.e.b(1001);
        }
        String optString = jSONObject.optString("title");
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.a.h0.a.t.e.b(1001);
        }
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.a.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(W.m(), optString, optString2));
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b u(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O != null && O.Z()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.a.h0.a.t.e.b(1001, "ui operation does not supported when app is invisible.");
        }
        return q(str, true);
    }
}
