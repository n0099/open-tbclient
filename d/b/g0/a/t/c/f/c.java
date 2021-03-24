package d.b.g0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46001f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46002g;

        public a(d.b.g0.a.e0.l.c cVar, String str, String str2) {
            this.f46000e = cVar;
            this.f46001f = str;
            this.f46002g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.c cVar = this.f46000e;
            boolean z = true;
            if (!((cVar == null || !cVar.j2(this.f46001f, true)) ? false : false)) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "set title fail");
                c.this.c(this.f46002g, new d.b.g0.a.t.e.b(1001));
            }
            c.this.c(this.f46002g, new d.b.g0.a.t.e.b(0));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46005f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46006g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46007h;
        public final /* synthetic */ JSONObject i;

        public b(d.b.g0.a.e0.l.c cVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f46004e = cVar;
            this.f46005f = str;
            this.f46006g = str2;
            this.f46007h = str3;
            this.i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.c cVar = this.f46004e;
            if (cVar != null && cVar.q2(this.f46005f, true)) {
                if (!this.f46004e.h2(SwanAppConfigData.s(this.f46007h), true)) {
                    d.b.g0.a.c0.c.b("Api-NavigationBar", "set title background fail");
                    c.this.c(this.f46006g, new d.b.g0.a.t.e.b(1001));
                    return;
                }
                JSONObject jSONObject = this.i;
                if (jSONObject != null) {
                    this.f46004e.f2(jSONObject.optInt("duration"), this.i.optString("timingFunc"));
                    d.b.g0.a.c0.c.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.c(this.f46006g, new d.b.g0.a.t.e.b(0));
                return;
            }
            d.b.g0.a.c0.c.b("Api-NavigationBar", "set title color fail");
            c.this.c(this.f46006g, new d.b.g0.a.t.e.b(1001));
        }
    }

    /* renamed from: d.b.g0.a.t.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0806c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46010g;

        public RunnableC0806c(d.b.g0.a.e0.l.c cVar, String str, boolean z) {
            this.f46008e = cVar;
            this.f46009f = str;
            this.f46010g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean K1;
            d.b.g0.a.e0.l.c cVar = this.f46008e;
            if (cVar == null) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.c(this.f46009f, new d.b.g0.a.t.e.b(1001));
                return;
            }
            if (this.f46010g) {
                K1 = cVar.y2();
            } else {
                K1 = cVar.K1();
            }
            if (!K1) {
                String str = this.f46010g ? "show" : "hide";
                d.b.g0.a.c0.c.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.c(this.f46009f, new d.b.g0.a.t.e.b(1001));
                return;
            }
            c.this.c(this.f46009f, new d.b.g0.a.t.e.b(0));
        }
    }

    public c(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final d.b.g0.a.t.e.b q(String str, boolean z) {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.g0.a.t.e.b(1001);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new RunnableC0806c(W.m(), optString, z));
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return q(str, false);
    }

    public d.b.g0.a.t.e.b s(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.g0.a.t.e.b(1001);
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new b(W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b t(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "paramsJson is null");
            return new d.b.g0.a.t.e.b(1001);
        }
        String optString = jSONObject.optString("title");
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.g0.a.t.e.b(1001);
        }
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(W.m(), optString, optString2));
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null && O.Z()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.b.g0.a.t.e.b(1001, "ui operation does not supported when app is invisible.");
        }
        return q(str, true);
    }
}
