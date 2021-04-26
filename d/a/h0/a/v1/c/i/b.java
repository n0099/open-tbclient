package d.a.h0.a.v1.c.i;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends h<e> {
    @NonNull
    public final String[] l;
    public final Context m;
    public boolean n;
    public boolean o;
    public d.a.h0.a.v1.c.e q;
    public final String r;
    public final boolean s;
    public boolean p = false;
    public boolean t = false;

    /* renamed from: d.a.h0.a.v1.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0837b extends d.a.h0.a.v1.c.d {

        /* renamed from: d.a.h0.a.v1.c.i.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f44959e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.v1.c.e f44960f;

            /* renamed from: d.a.h0.a.v1.c.i.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0838a implements d.a.h0.a.v1.c.a {
                public C0838a() {
                }

                @Override // d.a.h0.a.v1.c.a
                public void onResult(boolean z) {
                    b bVar = b.this;
                    bVar.o = z;
                    bVar.t = !z;
                    C0837b.this.d();
                }
            }

            public a(Activity activity, d.a.h0.a.v1.c.e eVar) {
                this.f44959e = activity;
                this.f44960f = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f44959e.isFinishing()) {
                    return;
                }
                d.a.h0.a.v1.c.c.q(this.f44959e, b.this.G(), this.f44960f, null, new C0838a());
            }
        }

        public C0837b() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            b bVar = b.this;
            d.a.h0.a.v1.c.e eVar = bVar.q;
            if (eVar == null) {
                d.a.h0.a.v1.c.c.j("Illegal ScopeInfo", Boolean.TRUE);
                b.this.e(new OAuthException(10001));
                d.a.h0.a.z1.h.q(10001, null);
                return true;
            } else if (eVar.f44913d) {
                bVar.e(new OAuthException(10005));
                d.a.h0.a.z1.h.q(10005, eVar);
                return true;
            } else if (bVar.s || !bVar.o) {
                return true;
            } else {
                if (!bVar.n && eVar.j < 0) {
                    bVar.r(new e(false, null));
                    b.this.e(new OAuthException(10005));
                    return true;
                } else if (eVar.j > 0) {
                    b.this.r(new e(true, null));
                    b.this.d();
                    return true;
                } else if (b.this.G().Z()) {
                    d.a.h0.a.v1.c.c.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                    b.this.e(new OAuthException(10005));
                    return true;
                } else {
                    Activity R = b.this.R();
                    if (R == null) {
                        d.a.h0.a.v1.c.c.j("login error context is not activity.", Boolean.TRUE);
                        b.this.e(new OAuthException(10005));
                        return true;
                    }
                    d.a.h0.a.v1.c.c.k(new a(R, eVar));
                    return false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.h0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.e> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.a.h0.a.v1.c.e eVar) {
                if (d.a.h0.a.v1.c.b.f44890f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ListPreparation result: ");
                    sb.append(eVar == null ? StringUtil.NULL_STRING : eVar);
                    Log.i("aiapps-oauth", sb.toString());
                }
                c cVar = c.this;
                b.this.q = eVar;
                if (eVar == null) {
                    cVar.e(new Exception("no such scope"));
                    return;
                }
                if (eVar.c()) {
                    b bVar = b.this;
                    if (!bVar.p) {
                        bVar.i(new d());
                        c.this.d();
                    }
                }
                b bVar2 = b.this;
                bVar2.i(new C0837b());
                c.this.d();
            }
        }

        public c() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            String[] strArr = b.this.l;
            if (strArr != null && strArr.length <= 1) {
                d.a.h0.a.g1.o.c.a.i(strArr[0], new a());
                return false;
            }
            d();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.h0.a.v1.c.d implements d.a.h0.a.m.a {
        public d() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            b bVar = b.this;
            bVar.p = true;
            if (bVar.G().i().e(b.this.m)) {
                d.a.h0.a.v1.c.c.j("LoginPreparation: isLogin true", Boolean.FALSE);
                b bVar2 = b.this;
                bVar2.i(new c());
                return true;
            }
            d.a.h0.a.r1.e G = b.this.G();
            if (G.Z()) {
                d.a.h0.a.v1.c.c.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            Activity R = b.this.R();
            if (R == null) {
                d.a.h0.a.v1.c.c.j("login error context is not activity.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            G.i().f(R, null, this);
            return false;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            d.a.h0.a.v1.c.c.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.h0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.h0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                b bVar = b.this;
                bVar.i(new c());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f44966a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44967b;

        public e(boolean z, String str) {
            this.f44966a = str == null ? "" : str;
            this.f44967b = z;
        }

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.f44967b), this.f44966a);
        }
    }

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        this.m = context;
        this.n = z;
        this.l = strArr == null ? new String[0] : strArr;
        this.r = str;
        this.o = z2;
        this.s = z3;
    }

    @Override // d.a.h0.a.v1.c.i.h
    public void E() {
        super.E();
        if (this.t) {
            e(new OAuthException(10003));
            this.t = false;
        }
        if (TextUtils.isEmpty(this.r)) {
            d.a.h0.a.g1.o.c.a.f();
        }
    }

    public Activity R() {
        Context context = this.m;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        return O.v();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.v1.c.b
    /* renamed from: S */
    public e n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.a.h0.a.v1.c.c.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt == 0) {
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new e(this.o, jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean k() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", G().f43823f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1831h, G().B());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            String j = d.a.h0.a.w0.a.l().j();
            if (!TextUtils.isEmpty(j)) {
                jSONObject2.put("host_api_key", j);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (String str : this.l) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("permit", Boolean.toString(this.o));
                jSONObject3.put(str, jSONObject4);
            }
            jSONObject.put("accredits", jSONObject3);
            if (!TextUtils.isEmpty(this.r)) {
                jSONObject.put("provider_appkey", this.r);
            }
        } catch (JSONException e2) {
            if (d.a.h0.a.v1.c.b.f44890f) {
                e2.printStackTrace();
            }
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean l() {
        i(new c());
        return super.l();
    }

    @Override // d.a.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.a.h0.a.w0.a.l().J(this.m, hVar.A());
    }
}
