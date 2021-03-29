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
/* loaded from: classes2.dex */
public final class a {
    public static final boolean n = k.f45051a;
    public static final Map<String, a> o = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Activity f46833a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46834b;

    /* renamed from: c  reason: collision with root package name */
    public final String f46835c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46836d;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f46839g;
    public d.b.g0.a.r1.e i;
    public final d.b.g0.a.f2.a j;
    public boolean k;
    public boolean l;
    public final d.b.g0.a.i2.t0.a m;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<a>> f46837e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public TaskState f46838f = TaskState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46840h = false;

    /* renamed from: d.b.g0.a.v1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0868a extends d.b.g0.a.i2.t0.a {
        public C0868a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

        /* renamed from: d.b.g0.a.v1.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0869a implements d.b.g0.a.v1.c.a {
            public C0869a() {
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
            if (hVar != null && hVar.c() && (jSONObject = hVar.f46808a) != null) {
                d.b.g0.a.c0.c.a("OpenData", "opendata=", jSONObject);
                a.this.j.b(hVar.f46808a.optInt("errno", 10001));
                a.this.j.e(hVar.f46808a.optString("errmsg", "internal error"));
                if (0 != a.this.j.g()) {
                    d.b.g0.a.v1.c.c.j("by errno", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.u();
                    a.this.s(10001);
                    return;
                }
                JSONObject optJSONObject = hVar.f46808a.optJSONObject("data");
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
                a.this.f46839g = optJSONObject.optJSONObject("opendata");
                if (!a.this.f46836d && (i = e2.j) < 0) {
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
                        if (!a.this.f46840h && e2.c()) {
                            if (!TextUtils.equals(e2.f46769b, "mobile") || d.b.g0.a.r.a.f.f45697d.e()) {
                                a.this.z();
                                return;
                            } else {
                                a.this.A();
                                return;
                            }
                        } else if (TextUtils.equals(e2.f46769b, "mobile") && a.this.l) {
                            a.this.C(true);
                            return;
                        } else {
                            a aVar = a.this;
                            d.b.g0.a.v1.c.c.q(aVar.f46833a, aVar.i, e2, a.this.f46839g, new C0869a());
                            return;
                        }
                    }
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                    a.this.u();
                    a.this.t(10005, e2);
                    return;
                } else {
                    a.this.f46839g = optJSONObject.optJSONObject("opendata");
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

    /* loaded from: classes2.dex */
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
                a.this.f46840h = true;
                a.this.l = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                a.this.f46840h = true;
                a.this.D();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.i2.u0.b<h<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46846e;

        public e(boolean z) {
            this.f46846e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<a.b> hVar) {
            a.b bVar;
            if (!this.f46846e && !a.this.k) {
                a.this.u();
            } else if (hVar != null && hVar.c() && (bVar = hVar.f46808a) != null && bVar.f46813c != null) {
                a aVar = a.this;
                aVar.f46839g = bVar.f46813c;
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.f46837e) {
                for (d.b.g0.a.i2.u0.b bVar : a.this.f46837e) {
                    bVar.onCallback(a.this);
                }
                a.this.f46837e.clear();
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
        this.m = new C0868a();
        this.f46833a = activity;
        this.f46834b = str;
        this.f46835c = str2;
        this.f46836d = z;
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
        this.f46840h = this.i.z().e(this.f46833a);
        D();
    }

    public final void C(boolean z) {
        if (TextUtils.isEmpty(this.f46835c)) {
            d.b.g0.a.v1.c.i.a a2 = d.b.g0.a.r1.d.e().o().a().a().a(this.f46833a, z, this.f46834b, this.f46835c);
            a2.p(new e(z));
            a2.a();
            return;
        }
        d.b.g0.a.v1.c.i.b e2 = d.b.g0.a.r1.d.e().o().a().a().e(this.f46833a, true, z, new String[]{this.f46834b}, this.f46835c, true);
        e2.p(new f());
        e2.a();
    }

    public final void D() {
        d.b.g0.a.v1.c.i.g c2 = d.b.g0.a.r1.d.e().o().a().a().c(this.f46833a, this.f46834b, this.f46835c, this.f46836d, this.f46840h);
        c2.p(new b());
        c2.a();
    }

    public final void E(d.b.g0.a.i2.u0.b<a> bVar) {
        d.b.g0.a.c0.c.g("OpenData", "start session : " + this.f46834b);
        this.f46838f = TaskState.CALLING;
        this.k = TextUtils.equals(this.f46834b, "snsapi_userinfo");
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
        y.R().f46662f.d(this.m);
    }

    public final a q(d.b.g0.a.i2.u0.b<a> bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.f46837e) {
            this.f46837e.add(bVar);
        }
        return this;
    }

    public final void s(int i) {
        t(i, d.b.g0.a.v1.c.e.d(this.f46834b, new JSONObject()));
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
                jSONObject.put("scope", eVar.f46769b);
                jSONObject.put("scopeData", eVar.f46768a);
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
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f46834b, Boolean.valueOf(x()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
        if (this.f46839g != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f46839g));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f46838f));
        return sb.toString();
    }

    public final void u() {
        this.m.a();
        synchronized (o) {
            o.remove(w(this.f46834b, this.f46836d));
        }
        this.f46838f = TaskState.FINISHED;
        if (this.f46839g == null && 0 == this.j.a()) {
            if (this.f46840h) {
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            } else {
                this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
            }
        }
        d.b.g0.a.c0.c.g("OpenData", "onFinish" + toString());
        d.b.g0.a.v1.c.c.k(new g());
    }

    public boolean x() {
        return TaskState.FINISHED == this.f46838f && 0 == this.j.a() && this.f46839g != null;
    }

    public boolean y() {
        return TaskState.FINISHED == this.f46838f && this.f46839g != null;
    }

    public final void z() {
        this.i.z().f(this.f46833a, null, new d());
    }
}
