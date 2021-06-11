package d.a.l0.a.e2.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.a.l0.a.e2.c.j.a;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.k;
import d.a.l0.a.p.d.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static final boolean p = k.f46875a;
    public static final Map<String, a> q = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Activity f45441a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45442b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45443c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45444d;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45447g;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.a.a2.e f45449i;
    public final d.a.l0.a.q2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final d.a.l0.a.v2.d1.a o;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<a>> f45445e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public TaskState f45446f = TaskState.INIT;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45448h = false;

    /* renamed from: d.a.l0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0680a implements Runnable {
        public RunnableC0680a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this.f45445e) {
                for (d.a.l0.a.v2.e1.b bVar : a.this.f45445e) {
                    bVar.onCallback(a.this);
                }
                a.this.f45445e.clear();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.l0.a.v2.d1.a {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.I();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<JSONObject>> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            if (iVar != null && iVar.c() && (jSONObject = iVar.f45412a) != null) {
                d.a.l0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                a.this.j.b(iVar.f45412a.optInt("errno", 10001));
                a.this.j.e(iVar.f45412a.optString("errmsg", "internal error"));
                if (0 != a.this.j.g()) {
                    d.a.l0.a.e2.c.d.j("by errno", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.B();
                    a.this.z(10001);
                    return;
                }
                JSONObject optJSONObject = iVar.f45412a.optJSONObject("data");
                if (optJSONObject == null) {
                    d.a.l0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.B();
                    a.this.z(10001);
                    return;
                }
                d.a.l0.a.e2.c.f e2 = d.a.l0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                if (e2 == null) {
                    d.a.l0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                    a.this.B();
                    a.this.z(10001);
                    return;
                }
                a.this.f45447g = optJSONObject.optJSONObject("opendata");
                if (!a.this.f45444d && (i2 = e2.j) < 0) {
                    if (i2 == -2) {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    } else {
                        a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        a.this.A(10005, e2);
                    }
                    a.this.B();
                    return;
                } else if (e2.j > 0) {
                    if (!a.this.f45448h || !TextUtils.equals(e2.f45371b, "mobile") || (jSONObject2 = a.this.f45447g) == null || jSONObject2.optInt("errno") != 1129) {
                        a.this.B();
                        return;
                    } else {
                        a.this.w(e2, false);
                        return;
                    }
                } else if (!a.this.f45449i.d0()) {
                    if (!a.this.f45448h && e2.c()) {
                        if (!TextUtils.equals(e2.f45371b, "mobile") || d.a.l0.a.s.a.f.f48256d.f()) {
                            a.this.G();
                        } else {
                            a.this.H();
                        }
                        d.a.l0.a.j2.k.N(a.this.n, "phoneNumberLogin");
                        return;
                    } else if (TextUtils.equals(e2.f45371b, "mobile")) {
                        a.this.v(e2);
                        return;
                    } else {
                        a.this.L(e2);
                        return;
                    }
                } else {
                    a.this.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                    a.this.B();
                    a.this.A(10005, e2);
                    return;
                }
            }
            d.a.l0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
            a.this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            a.this.B();
            a.this.z(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements n.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.e2.c.f f45453a;

        public d(d.a.l0.a.e2.c.f fVar) {
            this.f45453a = fVar;
        }

        @Override // d.a.l0.a.p.d.n.c
        public void a(boolean z) {
            d.a.l0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
            if (z) {
                a.this.L(this.f45453a);
            } else {
                a.this.w(this.f45453a, true);
            }
        }

        @Override // d.a.l0.a.p.d.n.c
        public void b() {
            d.a.l0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
            a.this.L(this.f45453a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements n.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45455a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.e2.c.f f45456b;

        /* renamed from: d.a.l0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0681a implements n.c {
            public C0681a() {
            }

            @Override // d.a.l0.a.p.d.n.c
            public void a(boolean z) {
                d.a.l0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + e.this.f45455a);
                if (z) {
                    a.this.m = true;
                    a.this.K();
                    return;
                }
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                a.this.B();
            }

            @Override // d.a.l0.a.p.d.n.c
            public void b() {
                d.a.l0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + e.this.f45455a);
                e eVar = e.this;
                if (eVar.f45455a) {
                    a.this.L(eVar.f45456b);
                } else {
                    a.this.B();
                }
            }
        }

        public e(boolean z, d.a.l0.a.e2.c.f fVar) {
            this.f45455a = z;
            this.f45456b = fVar;
        }

        @Override // d.a.l0.a.p.d.n.a
        public void onFinish() {
            d.a.l0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f45455a);
            d.a.l0.a.c1.a.a0().g(new C0681a());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.e2.c.a {
        public f() {
        }

        @Override // d.a.l0.a.e2.c.a
        public void onResult(boolean z) {
            if (!z) {
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
            }
            a.this.J(z);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.a.m.a {
        public g() {
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            d.a.l0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.l0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.B();
            } else if (i2 != 0) {
                d.a.l0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.B();
            } else {
                d.a.l0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f45448h = true;
                a.this.l = true;
                a.this.K();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.l0.a.m.a {
        public h() {
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            d.a.l0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.l0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.B();
            } else if (i2 != 0) {
                d.a.l0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                a.this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                a.this.B();
            } else {
                d.a.l0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                a.this.f45448h = true;
                a.this.K();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<a.b>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45462e;

        public i(boolean z) {
            this.f45462e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            if (!this.f45462e && !a.this.k) {
                a.this.B();
            } else if (iVar != null && iVar.c() && (bVar = iVar.f45412a) != null && bVar.f45417c != null) {
                a aVar = a.this;
                aVar.f45447g = bVar.f45417c;
                aVar.B();
            } else {
                d.a.l0.a.q2.a aVar2 = a.this.j;
                aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                aVar2.e("bad Accredit response");
                a.this.B();
                a.this.z(10002);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (iVar == null || !iVar.c()) {
                d.a.l0.a.q2.a aVar = a.this.j;
                aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                aVar.e("bad authorize response");
                a.this.z(10002);
            }
            a.this.B();
        }
    }

    public a(Activity activity, String str, String str2, boolean z, String str3) {
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b();
        this.f45441a = activity;
        this.f45442b = str;
        this.f45443c = str2;
        this.f45444d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, d.a.l0.a.v2.e1.b<a> bVar) {
        synchronized (q) {
            String D = D(str, z);
            a aVar = q.get(D);
            if (aVar == null) {
                a aVar2 = new a(activity, str, str2, z, str3);
                q.put(D, aVar2);
                aVar2.M(bVar);
            } else {
                d.a.l0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
                aVar.u(bVar);
            }
        }
    }

    public static String D(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(z ? "1" : "0");
        return sb.toString();
    }

    public static void x() {
        synchronized (q) {
            q.clear();
        }
    }

    public final void A(int i2, d.a.l0.a.e2.c.f fVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            if (p) {
                Log.e("OpenData", "failedStatistic-swanApp is null");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
        dVar.o(i2);
        dVar.r(Q.N());
        dVar.q(d.a.l0.a.j2.k.m(Q.l()));
        dVar.m(Q.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Q.getAppId());
            jSONObject.put("msg", d.a.l0.a.e2.c.d.f(i2));
            if (fVar != null) {
                jSONObject.put("scope", fVar.f45371b);
                jSONObject.put("scopeData", fVar.f45370a);
            }
        } catch (JSONException e2) {
            if (p) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        d.a.l0.a.j2.k.L(dVar);
    }

    public final void B() {
        this.o.a();
        synchronized (q) {
            q.remove(D(this.f45442b, this.f45444d));
        }
        this.f45446f = TaskState.FINISHED;
        if (this.f45447g == null && 0 == this.j.a()) {
            if (this.f45448h) {
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            } else {
                this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
            }
        }
        d.a.l0.a.e0.d.g("OpenData", "onFinish" + toString());
        d.a.l0.a.e2.c.d.k(new RunnableC0680a());
    }

    public boolean E() {
        return TaskState.FINISHED == this.f45446f && 0 == this.j.a() && this.f45447g != null;
    }

    public boolean F() {
        return TaskState.FINISHED == this.f45446f && this.f45447g != null;
    }

    public final void G() {
        this.f45449i.j().f(this.f45441a, null, new h());
    }

    public final void H() {
        d.a.l0.a.c1.a.a0().j(new g());
    }

    public final void I() {
        this.f45448h = this.f45449i.j().e(this.f45441a);
        K();
    }

    public final void J(boolean z) {
        if (TextUtils.isEmpty(this.f45443c)) {
            d.a.l0.a.e2.c.j.a a2 = d.a.l0.a.a2.d.g().y().a().b().a(this.f45441a, z, this.f45442b, this.f45443c);
            a2.r(this.n);
            a2.p(new i(z));
            a2.a();
            return;
        }
        d.a.l0.a.e2.c.j.b d2 = d.a.l0.a.a2.d.g().y().a().b().d(this.f45441a, true, z, new String[]{this.f45442b}, this.f45443c, true);
        d2.r(this.n);
        d2.p(new j());
        d2.a();
    }

    public final void K() {
        d.a.l0.a.j2.k.N(this.n, "requestOpenData");
        d.a.l0.a.e2.c.j.g c2 = d.a.l0.a.a2.d.g().y().a().b().c(this.f45441a, this.f45442b, this.f45443c, this.f45444d, this.f45448h);
        c2.r(this.n);
        c2.p(new c());
        c2.a();
    }

    public final void L(@NonNull d.a.l0.a.e2.c.f fVar) {
        d.a.l0.a.e2.c.d.t(this.f45441a, this.f45449i, fVar, this.f45447g, new f());
    }

    public final void M(d.a.l0.a.v2.e1.b<a> bVar) {
        d.a.l0.a.e0.d.g("OpenData", "start session : " + this.f45442b);
        this.f45446f = TaskState.CALLING;
        this.k = TextUtils.equals(this.f45442b, "snsapi_userinfo");
        u(bVar);
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        this.f45449i = i2;
        if (i2 == null) {
            d.a.l0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
            this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
            B();
            z(10001);
            return;
        }
        i2.T().f45244f.d(this.o);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f45442b, Boolean.valueOf(E()), super.toString()));
        sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
        if (this.f45447g != null) {
            sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f45447g));
        }
        sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f45446f));
        return sb.toString();
    }

    public final a u(d.a.l0.a.v2.e1.b<a> bVar) {
        if (bVar == null) {
            return this;
        }
        synchronized (this.f45445e) {
            this.f45445e.add(bVar);
        }
        return this;
    }

    public final void v(d.a.l0.a.e2.c.f fVar) {
        if (this.l) {
            J(true);
        } else if (this.m) {
            L(fVar);
        } else {
            y(fVar);
        }
    }

    public final void w(d.a.l0.a.e2.c.f fVar, boolean z) {
        d.a.l0.a.c1.a.a0().a(new e(z, fVar));
    }

    public final void y(d.a.l0.a.e2.c.f fVar) {
        d.a.l0.a.c1.a.a0().g(new d(fVar));
    }

    public final void z(int i2) {
        A(i2, d.a.l0.a.e2.c.f.d(this.f45442b, new JSONObject()));
    }
}
