package d.b.g0.a.v1.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.b.g0.a.k;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.a;
import d.b.g0.a.v1.c.i.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static final boolean n = k.f45443a;
    public static final Map<String, a> o = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Activity f47225a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47226b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47227c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47228d;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47231g;
    public d.b.g0.a.r1.e i;
    public final d.b.g0.a.f2.a j;
    public boolean k;
    public boolean l;
    public final d.b.g0.a.i2.t0.a m;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<a>> f47229e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public TaskState f47230f = TaskState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47232h = false;

    /* renamed from: d.b.g0.a.v1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0880a extends d.b.g0.a.i2.t0.a {
        public C0880a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: d.b.g0.a.v1.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0881a implements d.b.g0.a.v1.c.a {
            public C0881a() {
            }

            @Override // d.b.g0.a.v1.c.a
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
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<JSONObject> hVar) {
            JSONObject jSONObject;
            int i;
            if (hVar != null && hVar.c() && (jSONObject = hVar.f47200a) != null) {
                d.b.g0.a.c0.c.a("OpenData", "opendata=", jSONObject);
                a.this.j.b(hVar.f47200a.optInt("errno", 10001));
                a.this.j.e(hVar.f47200a.optString("errmsg", "internal error"));
                if (0 != a.this.j.g()) {
                    d.b.g0.a.v1.c.c.j("by errno", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.f47200a.optJSONObject("data");
                if (optJSONObject == null) {
                    d.b.g0.a.v1.c.c.j("by data parse", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                d.b.g0.a.v1.c.e e2 = d.b.g0.a.v1.c.e.e(optJSONObject.optJSONObject("scope"));
                if (e2 == null) {
                    d.b.g0.a.v1.c.c.j("illegal scope", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                a.this.f47231g = optJSONObject.optJSONObject("opendata");
                if (!a.this.f47228d && (i = e2.j) < 0) {
                    if (i == -2) {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    } else {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        a.this.t(10005, e2);
                    }
                    a.this.u();
                    return;
                } else if (e2.j <= 0) {
                    if (!a.this.i.Z()) {
                        if (!a.this.f47232h && e2.c()) {
                            if (!TextUtils.equals(e2.f47161b, "mobile") || d.b.g0.a.r.a.f.f46089d.e()) {
                                a.this.z();
                                return;
                            } else {
                                a.this.A();
                                return;
                            }
                        } else if (TextUtils.equals(e2.f47161b, "mobile") && a.this.l) {
                            a.this.C(true);
                            return;
                        } else {
                            a aVar = a.this;
                            d.b.g0.a.v1.c.c.q(aVar.f47225a, aVar.i, e2, a.this.f47231g, new C0881a());
                            return;
                        }
                    }
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                    a.this.u();
                    a.this.t(10005, e2);
                    return;
                } else {
                    a.this.f47231g = optJSONObject.optJSONObject("opendata");
                    a.this.u();
                    return;
                }
            }
            d.b.g0.a.v1.c.c.j("bad MaOpenData response", Boolean.TRUE);
            a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            a.this.u();
            a.this.s(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.m.a {
        public c() {
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            d.b.g0.a.v1.c.c.j("onResult :: " + i, Boolean.FALSE);
            if (i == -2) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else if (i != 0) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else {
                d.b.g0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f47232h = true;
                a.this.l = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.a.m.a {
        public d() {
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            d.b.g0.a.v1.c.c.j("onResult :: " + i, Boolean.FALSE);
            if (i == -2) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else if (i != 0) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.u();
            } else {
                d.b.g0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f47232h = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.i2.u0.b<h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47238e;

        public e(boolean z) {
            this.f47238e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<a.b> hVar) {
            a.b bVar;
            if (!this.f47238e && !a.this.k) {
                a.this.u();
            } else if (hVar != null && hVar.c() && (bVar = hVar.f47200a) != null && bVar.f47205c != null) {
                a aVar = a.this;
                aVar.f47231g = bVar.f47205c;
                aVar.u();
            } else {
                d.b.g0.a.f2.a aVar2 = a.this.j;
                aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                aVar2.e("bad Accredit response");
                a.this.u();
                a.this.s(10002);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.i2.u0.b<h<b.e>> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (hVar == null || !hVar.c()) {
                d.b.g0.a.f2.a aVar = a.this.j;
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
            synchronized (a.this.f47229e) {
                for (d.b.g0.a.i2.u0.b bVar : a.this.f47229e) {
                    bVar.onCallback(a.this);
                }
                a.this.f47229e.clear();
            }
        }
    }

    public a(Activity activity, String str, String str2, boolean z) {
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = new C0880a();
        this.f47225a = activity;
        this.f47226b = str;
        this.f47227c = str2;
        this.f47228d = z;
    }

    public static void r() {
        synchronized (o) {
            o.clear();
        }
    }

    public static void v(Activity activity, String str, String str2, boolean z, d.b.g0.a.i2.u0.b<a> bVar) {
        synchronized (o) {
            String w = w(str, z);
            a aVar = o.get(w);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z);
                o.put(w, aVar2);
                aVar2.E(bVar);
            } else {
                d.b.g0.a.c0.c.g("OpenData", "reuse session : " + aVar.toString());
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
        d.b.g0.a.w0.a.O().f(new c());
    }

    public final void B() {
        this.f47232h = this.i.z().e(this.f47225a);
        D();
    }

    public final void C(boolean z) {
        if (TextUtils.isEmpty(this.f47227c)) {
            d.b.g0.a.v1.c.i.a a2 = d.b.g0.a.r1.d.e().o().a().a().a(this.f47225a, z, this.f47226b, this.f47227c);
            a2.p(new e(z));
            a2.a();
            return;
        }
        d.b.g0.a.v1.c.i.b e2 = d.b.g0.a.r1.d.e().o().a().a().e(this.f47225a, true, z, new String[]{this.f47226b}, this.f47227c, true);
        e2.p(new f());
        e2.a();
    }

    public final void D() {
        d.b.g0.a.v1.c.i.g c2 = d.b.g0.a.r1.d.e().o().a().a().c(this.f47225a, this.f47226b, this.f47227c, this.f47228d, this.f47232h);
        c2.p(new b());
        c2.a();
    }

    public final void E(d.b.g0.a.i2.u0.b<a> bVar) {
        d.b.g0.a.c0.c.g("OpenData", "start session : " + this.f47226b);
        this.f47230f = TaskState.CALLING;
        this.k = TextUtils.equals(this.f47226b, "snsapi_userinfo");
        q(bVar);
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        this.i = y;
        if (y == null) {
            d.b.g0.a.v1.c.c.j("SwanApp is null", Boolean.TRUE);
            this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            u();
            s(10001);
            return;
        }
        y.R().f47054f.d(this.m);
    }

    public final a q(d.b.g0.a.i2.u0.b<a> bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.f47229e) {
            this.f47229e.add(bVar);
        }
        return this;
    }

    public final void s(int i) {
        t(i, d.b.g0.a.v1.c.e.d(this.f47226b, new JSONObject()));
    }

    public final void t(int i, d.b.g0.a.v1.c.e eVar) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            if (n) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
        dVar.o(i);
        dVar.r(O.L());
        dVar.q(d.b.g0.a.z1.h.n(O.h()));
        dVar.m(O.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", O.getAppId());
            jSONObject.put("msg", d.b.g0.a.v1.c.c.f(i));
            if (eVar != null) {
                jSONObject.put("scope", eVar.f47161b);
                jSONObject.put("scopeData", eVar.f47160a);
            }
        } catch (JSONException e2) {
            if (n) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        d.b.g0.a.z1.h.H(dVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f47226b, Boolean.valueOf(x()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
        if (this.f47231g != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f47231g));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f47230f));
        return sb.toString();
    }

    public final void u() {
        this.m.a();
        synchronized (o) {
            o.remove(w(this.f47226b, this.f47228d));
        }
        this.f47230f = TaskState.FINISHED;
        if (this.f47231g == null && 0 == this.j.a()) {
            if (this.f47232h) {
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            } else {
                this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
            }
        }
        d.b.g0.a.c0.c.g("OpenData", "onFinish" + toString());
        d.b.g0.a.v1.c.c.k(new g());
    }

    public boolean x() {
        return TaskState.FINISHED == this.f47230f && 0 == this.j.a() && this.f47231g != null;
    }

    public boolean y() {
        return TaskState.FINISHED == this.f47230f && this.f47231g != null;
    }

    public final void z() {
        this.i.z().f(this.f47225a, null, new d());
    }
}
