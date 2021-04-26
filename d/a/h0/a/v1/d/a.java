package d.a.h0.a.v1.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.a.h0.a.k;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.a;
import d.a.h0.a.v1.c.i.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static final boolean n = k.f43101a;
    public static final Map<String, a> o = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Activity f44978a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44979b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44980c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44981d;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f44984g;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.a.r1.e f44986i;
    public final d.a.h0.a.f2.a j;
    public boolean k;
    public boolean l;
    public final d.a.h0.a.i2.t0.a m;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.a.h0.a.i2.u0.b<a>> f44982e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public TaskState f44983f = TaskState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44985h = false;

    /* renamed from: d.a.h0.a.v1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0839a extends d.a.h0.a.i2.t0.a {
        public C0839a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: d.a.h0.a.v1.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0840a implements d.a.h0.a.v1.c.a {
            public C0840a() {
            }

            @Override // d.a.h0.a.v1.c.a
            public void onResult(boolean z) {
                if (!z) {
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                a.this.C(z);
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<JSONObject> hVar) {
            JSONObject jSONObject;
            int i2;
            if (hVar != null && hVar.c() && (jSONObject = hVar.f44952a) != null) {
                d.a.h0.a.c0.c.a("OpenData", "opendata=", jSONObject);
                a.this.j.b(hVar.f44952a.optInt("errno", 10001));
                a.this.j.e(hVar.f44952a.optString("errmsg", "internal error"));
                if (0 != a.this.j.g()) {
                    d.a.h0.a.v1.c.c.j("by errno", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.f44952a.optJSONObject("data");
                if (optJSONObject == null) {
                    d.a.h0.a.v1.c.c.j("by data parse", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                d.a.h0.a.v1.c.e e2 = d.a.h0.a.v1.c.e.e(optJSONObject.optJSONObject("scope"));
                if (e2 == null) {
                    d.a.h0.a.v1.c.c.j("illegal scope", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                a.this.f44984g = optJSONObject.optJSONObject("opendata");
                if (!a.this.f44981d && (i2 = e2.j) < 0) {
                    if (i2 == -2) {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    } else {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        a.this.t(10005, e2);
                    }
                    a.this.u();
                    return;
                } else if (e2.j <= 0) {
                    if (!a.this.f44986i.Z()) {
                        if (!a.this.f44985h && e2.c()) {
                            if (!TextUtils.equals(e2.f44911b, "mobile") || d.a.h0.a.r.a.f.f43778d.e()) {
                                a.this.z();
                                return;
                            } else {
                                a.this.A();
                                return;
                            }
                        } else if (TextUtils.equals(e2.f44911b, "mobile") && a.this.l) {
                            a.this.C(true);
                            return;
                        } else {
                            a aVar = a.this;
                            d.a.h0.a.v1.c.c.q(aVar.f44978a, aVar.f44986i, e2, a.this.f44984g, new C0840a());
                            return;
                        }
                    }
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                    a.this.u();
                    a.this.t(10005, e2);
                    return;
                } else {
                    a.this.f44984g = optJSONObject.optJSONObject("opendata");
                    a.this.u();
                    return;
                }
            }
            d.a.h0.a.v1.c.c.j("bad MaOpenData response", Boolean.TRUE);
            a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            a.this.u();
            a.this.s(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.m.a {
        public c() {
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            d.a.h0.a.v1.c.c.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else if (i2 != 0) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else {
                d.a.h0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f44985h = true;
                a.this.l = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.m.a {
        public d() {
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            d.a.h0.a.v1.c.c.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else if (i2 != 0) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else {
                d.a.h0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f44985h = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.i2.u0.b<h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44992e;

        public e(boolean z) {
            this.f44992e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<a.b> hVar) {
            a.b bVar;
            if (!this.f44992e && !a.this.k) {
                a.this.u();
            } else if (hVar != null && hVar.c() && (bVar = hVar.f44952a) != null && bVar.f44957c != null) {
                a aVar = a.this;
                aVar.f44984g = bVar.f44957c;
                aVar.u();
            } else {
                d.a.h0.a.f2.a aVar2 = a.this.j;
                aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                aVar2.e("bad Accredit response");
                a.this.u();
                a.this.s(10002);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.a.i2.u0.b<h<b.e>> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (hVar == null || !hVar.c()) {
                d.a.h0.a.f2.a aVar = a.this.j;
                aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                aVar.e("bad authorize response");
                a.this.s(10002);
            }
            a.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.f44982e) {
                for (d.a.h0.a.i2.u0.b bVar : a.this.f44982e) {
                    bVar.onCallback(a.this);
                }
                a.this.f44982e.clear();
            }
        }
    }

    public a(Activity activity, String str, String str2, boolean z) {
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = new C0839a();
        this.f44978a = activity;
        this.f44979b = str;
        this.f44980c = str2;
        this.f44981d = z;
    }

    public static void r() {
        synchronized (o) {
            o.clear();
        }
    }

    public static void v(Activity activity, String str, String str2, boolean z, d.a.h0.a.i2.u0.b<a> bVar) {
        synchronized (o) {
            String w = w(str, z);
            a aVar = o.get(w);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                o.put(w, aVar2);
                aVar2.E(bVar);
            } else {
                d.a.h0.a.c0.c.g("OpenData", "reuse session : " + aVar.toString());
                aVar.q(bVar);
            }
        }
    }

    public static String w(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(z ? "1" : "0");
        return sb.toString();
    }

    public final void A() {
        d.a.h0.a.w0.a.O().g(new c());
    }

    public final void B() {
        this.f44985h = this.f44986i.i().e(this.f44978a);
        D();
    }

    public final void C(boolean z) {
        if (TextUtils.isEmpty(this.f44980c)) {
            d.a.h0.a.v1.c.i.a a2 = d.a.h0.a.r1.d.e().w().a().b().a(this.f44978a, z, this.f44979b, this.f44980c);
            a2.p(new e(z));
            a2.a();
            return;
        }
        d.a.h0.a.v1.c.i.b d2 = d.a.h0.a.r1.d.e().w().a().b().d(this.f44978a, true, z, new String[]{this.f44979b}, this.f44980c, true);
        d2.p(new f());
        d2.a();
    }

    public final void D() {
        d.a.h0.a.v1.c.i.g c2 = d.a.h0.a.r1.d.e().w().a().b().c(this.f44978a, this.f44979b, this.f44980c, this.f44981d, this.f44985h);
        c2.p(new b());
        c2.a();
    }

    public final void E(d.a.h0.a.i2.u0.b<a> bVar) {
        d.a.h0.a.c0.c.g("OpenData", "start session : " + this.f44979b);
        this.f44983f = TaskState.CALLING;
        this.k = TextUtils.equals(this.f44979b, "snsapi_userinfo");
        q(bVar);
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        this.f44986i = h2;
        if (h2 == null) {
            d.a.h0.a.v1.c.c.j("SwanApp is null", Boolean.TRUE);
            this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            u();
            s(10001);
            return;
        }
        h2.R().f44797f.d(this.m);
    }

    public final a q(d.a.h0.a.i2.u0.b<a> bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.f44982e) {
            this.f44982e.add(bVar);
        }
        return this;
    }

    public final void s(int i2) {
        t(i2, d.a.h0.a.v1.c.e.d(this.f44979b, new JSONObject()));
    }

    public final void t(int i2, d.a.h0.a.v1.c.e eVar) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            if (n) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
        dVar.o(i2);
        dVar.r(O.L());
        dVar.q(d.a.h0.a.z1.h.n(O.j()));
        dVar.m(O.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", O.getAppId());
            jSONObject.put("msg", d.a.h0.a.v1.c.c.f(i2));
            if (eVar != null) {
                jSONObject.put("scope", eVar.f44911b);
                jSONObject.put("scopeData", eVar.f44910a);
            }
        } catch (JSONException e2) {
            if (n) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        d.a.h0.a.z1.h.H(dVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f44979b, Boolean.valueOf(x()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
        if (this.f44984g != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f44984g));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f44983f));
        return sb.toString();
    }

    public final void u() {
        this.m.a();
        synchronized (o) {
            o.remove(w(this.f44979b, this.f44981d));
        }
        this.f44983f = TaskState.FINISHED;
        if (this.f44984g == null && 0 == this.j.a()) {
            if (this.f44985h) {
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            } else {
                this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
            }
        }
        d.a.h0.a.c0.c.g("OpenData", "onFinish" + toString());
        d.a.h0.a.v1.c.c.k(new g());
    }

    public boolean x() {
        return TaskState.FINISHED == this.f44983f && 0 == this.j.a() && this.f44984g != null;
    }

    public boolean y() {
        return TaskState.FINISHED == this.f44983f && this.f44984g != null;
    }

    public final void z() {
        this.f44986i.i().f(this.f44978a, null, new d());
    }
}
