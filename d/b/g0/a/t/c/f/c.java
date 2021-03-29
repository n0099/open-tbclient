package d.b.g0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46002f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46003g;

        public a(d.b.g0.a.e0.l.c cVar, String str, String str2) {
            this.f46001e = cVar;
            this.f46002f = str;
            this.f46003g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.c cVar = this.f46001e;
            boolean z = true;
            if (!((cVar == null || !cVar.j2(this.f46002f, true)) ? false : false)) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "set title fail");
                c.this.c(this.f46003g, new d.b.g0.a.t.e.b(1001));
            }
            c.this.c(this.f46003g, new d.b.g0.a.t.e.b(0));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46007g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46008h;
        public final /* synthetic */ JSONObject i;

        public b(d.b.g0.a.e0.l.c cVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f46005e = cVar;
            this.f46006f = str;
            this.f46007g = str2;
            this.f46008h = str3;
            this.i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.c cVar = this.f46005e;
            if (cVar != null && cVar.q2(this.f46006f, true)) {
                if (!this.f46005e.h2(SwanAppConfigData.s(this.f46008h), true)) {
                    d.b.g0.a.c0.c.b("Api-NavigationBar", "set title background fail");
                    c.this.c(this.f46007g, new d.b.g0.a.t.e.b(1001));
                    return;
                }
                JSONObject jSONObject = this.i;
                if (jSONObject != null) {
                    this.f46005e.f2(jSONObject.optInt("duration"), this.i.optString("timingFunc"));
                    d.b.g0.a.c0.c.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.c(this.f46007g, new d.b.g0.a.t.e.b(0));
                return;
            }
            d.b.g0.a.c0.c.b("Api-NavigationBar", "set title color fail");
            c.this.c(this.f46007g, new d.b.g0.a.t.e.b(1001));
        }
    }

    /* renamed from: d.b.g0.a.t.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0807c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f46009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46011g;

        public RunnableC0807c(d.b.g0.a.e0.l.c cVar, String str, boolean z) {
            this.f46009e = cVar;
            this.f46010f = str;
            this.f46011g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean K1;
            d.b.g0.a.e0.l.c cVar = this.f46009e;
            if (cVar == null) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.c(this.f46010f, new d.b.g0.a.t.e.b(1001));
                return;
            }
            if (this.f46011g) {
                K1 = cVar.y2();
            } else {
                K1 = cVar.K1();
            }
            if (!K1) {
                String str = this.f46011g ? "show" : "hide";
                d.b.g0.a.c0.c.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.c(this.f46010f, new d.b.g0.a.t.e.b(1001));
                return;
            }
            c.this.c(this.f46010f, new d.b.g0.a.t.e.b(0));
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
            if (d.b.g0.a.t.b.d.f45929c) {
                d.b.g0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new RunnableC0807c(W.m(), optString, z));
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return q(str, false);
    }

    public d.b.g0.a.t.e.b s(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
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
            if (d.b.g0.a.t.b.d.f45929c) {
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
        if (d.b.g0.a.t.b.d.f45929c) {
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
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null && O.Z()) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.b.g0.a.t.e.b(1001, "ui operation does not supported when app is invisible.");
        }
        return q(str, true);
    }
}
