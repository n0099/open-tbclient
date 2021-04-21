package d.b.h0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.c f46722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46723f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46724g;

        public a(d.b.h0.a.e0.l.c cVar, String str, String str2) {
            this.f46722e = cVar;
            this.f46723f = str;
            this.f46724g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e0.l.c cVar = this.f46722e;
            boolean z = true;
            if (!((cVar == null || !cVar.j2(this.f46723f, true)) ? false : false)) {
                d.b.h0.a.c0.c.b("Api-NavigationBar", "set title fail");
                c.this.c(this.f46724g, new d.b.h0.a.t.e.b(1001));
            }
            c.this.c(this.f46724g, new d.b.h0.a.t.e.b(0));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.c f46726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46727f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46728g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46729h;
        public final /* synthetic */ JSONObject i;

        public b(d.b.h0.a.e0.l.c cVar, String str, String str2, String str3, JSONObject jSONObject) {
            this.f46726e = cVar;
            this.f46727f = str;
            this.f46728g = str2;
            this.f46729h = str3;
            this.i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e0.l.c cVar = this.f46726e;
            if (cVar != null && cVar.q2(this.f46727f, true)) {
                if (!this.f46726e.h2(SwanAppConfigData.s(this.f46729h), true)) {
                    d.b.h0.a.c0.c.b("Api-NavigationBar", "set title background fail");
                    c.this.c(this.f46728g, new d.b.h0.a.t.e.b(1001));
                    return;
                }
                JSONObject jSONObject = this.i;
                if (jSONObject != null) {
                    this.f46726e.f2(jSONObject.optInt("duration"), this.i.optString("timingFunc"));
                    d.b.h0.a.c0.c.g("Api-NavigationBar", "set action bar animator");
                }
                c.this.c(this.f46728g, new d.b.h0.a.t.e.b(0));
                return;
            }
            d.b.h0.a.c0.c.b("Api-NavigationBar", "set title color fail");
            c.this.c(this.f46728g, new d.b.h0.a.t.e.b(1001));
        }
    }

    /* renamed from: d.b.h0.a.t.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0839c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.l.c f46730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46731f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46732g;

        public RunnableC0839c(d.b.h0.a.e0.l.c cVar, String str, boolean z) {
            this.f46730e = cVar;
            this.f46731f = str;
            this.f46732g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean K1;
            d.b.h0.a.e0.l.c cVar = this.f46730e;
            if (cVar == null) {
                d.b.h0.a.c0.c.b("Api-NavigationBar", "swanAppFragment is null");
                c.this.c(this.f46731f, new d.b.h0.a.t.e.b(1001));
                return;
            }
            if (this.f46732g) {
                K1 = cVar.y2();
            } else {
                K1 = cVar.K1();
            }
            if (!K1) {
                String str = this.f46732g ? "show" : "hide";
                d.b.h0.a.c0.c.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                c.this.c(this.f46731f, new d.b.h0.a.t.e.b(1001));
                return;
            }
            c.this.c(this.f46731f, new d.b.h0.a.t.e.b(0));
        }
    }

    public c(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final d.b.h0.a.t.e.b q(String str, boolean z) {
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.h0.a.t.e.b(1001);
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new RunnableC0839c(W.m(), optString, z));
        return new d.b.h0.a.t.e.b(0);
    }

    public d.b.h0.a.t.e.b r(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return q(str, false);
    }

    public d.b.h0.a.t.e.b s(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.h0.a.t.e.b(1001);
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new b(W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
        return new d.b.h0.a.t.e.b(0);
    }

    public d.b.h0.a.t.e.b t(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-NavigationBar", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject == null) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "paramsJson is null");
            return new d.b.h0.a.t.e.b(1001);
        }
        String optString = jSONObject.optString("title");
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "manager is null");
            return new d.b.h0.a.t.e.b(1001);
        }
        String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("Api-NavigationBar", "callback is null");
            return new d.b.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(W.m(), optString, optString2));
        return new d.b.h0.a.t.e.b(0);
    }

    public d.b.h0.a.t.e.b u(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O != null && O.Z()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
            }
            return new d.b.h0.a.t.e.b(1001, "ui operation does not supported when app is invisible.");
        }
        return q(str, true);
    }
}
