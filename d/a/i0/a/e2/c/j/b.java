package d.a.i0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.i0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends h<e> {
    @NonNull
    public final String[] m;
    public final Context n;
    public boolean o;
    public boolean p;
    public d.a.i0.a.e2.c.f r;
    public final String s;
    public final boolean t;
    public boolean q = false;
    public boolean u = false;

    /* renamed from: d.a.i0.a.e2.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0611b extends d.a.i0.a.e2.c.e {

        /* renamed from: d.a.i0.a.e2.c.j.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f41569e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.e2.c.f f41570f;

            /* renamed from: d.a.i0.a.e2.c.j.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0612a implements d.a.i0.a.e2.c.a {
                public C0612a() {
                }

                @Override // d.a.i0.a.e2.c.a
                public void onResult(boolean z) {
                    b bVar = b.this;
                    bVar.p = z;
                    bVar.u = !z;
                    C0611b.this.d();
                }
            }

            public a(Activity activity, d.a.i0.a.e2.c.f fVar) {
                this.f41569e = activity;
                this.f41570f = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f41569e.isFinishing()) {
                    return;
                }
                d.a.i0.a.e2.c.d.t(this.f41569e, b.this.N(), this.f41570f, null, new C0612a());
            }
        }

        public C0611b() {
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            b bVar = b.this;
            d.a.i0.a.e2.c.f fVar = bVar.r;
            if (fVar == null) {
                d.a.i0.a.e2.c.d.j("Illegal ScopeInfo", Boolean.TRUE);
                b.this.e(new OAuthException(10001));
                k.p(10001, null);
                return true;
            } else if (fVar.f41523d) {
                bVar.e(new OAuthException(10005));
                k.p(10005, fVar);
                return true;
            } else if (bVar.t || !bVar.p) {
                return true;
            } else {
                if (!bVar.o && fVar.j < 0) {
                    bVar.s(new e(false, null));
                    b.this.e(new OAuthException(10005));
                    return true;
                } else if (fVar.j > 0) {
                    b.this.s(new e(true, null));
                    b.this.d();
                    return true;
                } else if (b.this.N().d0()) {
                    d.a.i0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                    b.this.e(new OAuthException(10005));
                    return true;
                } else {
                    Activity Z = b.this.Z();
                    if (Z == null) {
                        d.a.i0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                        b.this.e(new OAuthException(10005));
                        return true;
                    }
                    d.a.i0.a.e2.c.d.k(new a(Z, fVar));
                    return false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.i0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.f> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.i0.a.e2.c.f fVar) {
                if (d.a.i0.a.e2.c.c.f41500f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ListPreparation result: ");
                    sb.append(fVar == null ? StringUtil.NULL_STRING : fVar);
                    Log.i("aiapps-oauth", sb.toString());
                }
                c cVar = c.this;
                b.this.r = fVar;
                if (fVar == null) {
                    cVar.e(new Exception("no such scope"));
                    return;
                }
                if (fVar.c()) {
                    b bVar = b.this;
                    if (!bVar.q) {
                        bVar.i(new d());
                        c.this.d();
                    }
                }
                b bVar2 = b.this;
                bVar2.i(new C0611b());
                c.this.d();
            }
        }

        public c() {
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            String[] strArr = b.this.m;
            if (strArr != null && strArr.length <= 1) {
                d.a.i0.a.n1.q.c.a.i(strArr[0], new a());
                return false;
            }
            d();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.i0.a.e2.c.e implements d.a.i0.a.m.a {
        public d() {
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            b bVar = b.this;
            bVar.q = true;
            if (bVar.N().j().e(b.this.n)) {
                d.a.i0.a.e2.c.d.j("LoginPreparation: isLogin true", Boolean.FALSE);
                b bVar2 = b.this;
                bVar2.i(new c());
                return true;
            }
            d.a.i0.a.a2.e N = b.this.N();
            if (N.d0()) {
                d.a.i0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            Activity Z = b.this.Z();
            if (Z == null) {
                d.a.i0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            if (!d.a.i0.a.a2.d.g().r().j().e(Z)) {
                k.N(b.this.l, "passLogin");
            }
            N.j().f(Z, null, this);
            return false;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            d.a.i0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.i0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.i0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.i0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                b bVar = b.this;
                bVar.i(new c());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f41576a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f41577b;

        public e(boolean z, String str) {
            this.f41576a = str == null ? "" : str;
            this.f41577b = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.f41577b), this.f41576a);
        }
    }

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.n = context;
        this.o = z;
        this.m = strArr == null ? new String[0] : strArr;
        this.s = str;
        this.p = z2;
        this.t = z3;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.AUTHORIZE;
    }

    @Override // d.a.i0.a.e2.c.j.h
    public void J() {
        super.J();
        if (this.u) {
            e(new OAuthException(10003));
            this.u = false;
        }
        if (TextUtils.isEmpty(this.s)) {
            d.a.i0.a.n1.q.c.a.f();
        }
    }

    public Activity Z() {
        Context context = this.n;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        return Q.x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.e2.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: a0 */
    public e n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.a.i0.a.e2.c.d.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt != 0) {
            if (11001 == optInt) {
                d.a.i0.a.e2.c.d.l(c2);
                d.a.i0.a.e2.c.d.s("Authorize", c2.toString());
            }
            if (d.a.i0.a.e2.c.c.f41500f) {
                throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
            }
        }
        JSONObject jSONObject2 = c2.getJSONObject("data");
        return new e(this.p, jSONObject2 != null ? jSONObject2.optString("code", "") : "");
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean k() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", N().D());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", N().D());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.i0.a.e2.c.d.g());
            String l = d.a.i0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject2.put("host_api_key", l);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.m) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.p));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.s)) {
                jSONObject.put("provider_appkey", this.s);
            }
        } catch (JSONException e2) {
            if (d.a.i0.a.e2.c.c.f41500f) {
                e2.printStackTrace();
            }
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean l() {
        i(new c());
        return super.l();
    }

    @Override // d.a.i0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.i0.a.c1.a.n().C(this.n, hVar.C());
    }
}
