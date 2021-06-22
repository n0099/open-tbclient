package d.a.m0.b.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends d.a.m0.a.e2.c.j.b {
    public String v;

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.f> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.m0.a.e2.c.f fVar) {
                if (d.a.m0.a.e2.c.c.f45458f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ListPreparation result: ");
                    sb.append(fVar == null ? StringUtil.NULL_STRING : fVar);
                    Log.i("aiapps-oauth", sb.toString());
                }
                o.this.r = fVar;
                if (fVar == null) {
                    b.this.e(new Exception("no such scope"));
                    return;
                }
                if (fVar.c() && !o.this.q) {
                    o oVar = o.this;
                    oVar.i(new c());
                } else {
                    o oVar2 = o.this;
                    oVar2.i(new b.C0681b());
                }
                b.this.d();
            }
        }

        public b() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            if (TextUtils.isEmpty(o.this.s)) {
                if (o.this.m.length <= 1) {
                    d.a.m0.a.n1.q.c.a.i(o.this.m[0], new a());
                    return false;
                }
                d();
                return false;
            }
            d();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.m0.a.e2.c.e implements d.a.m0.a.m.a {
        public c() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            o.this.q = true;
            if (o.this.N().j().e(o.this.n)) {
                d.a.m0.a.e2.c.d.j("LoginPreparation: isLogin true", Boolean.FALSE);
                o oVar = o.this;
                oVar.i(new d());
                return true;
            }
            d.a.m0.a.a2.e N = o.this.N();
            if (!N.d0()) {
                if (o.this.n instanceof Activity) {
                    N.j().f((Activity) o.this.n, null, this);
                    return false;
                }
                d.a.m0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            d.a.m0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
            e(new OAuthException(10004));
            return true;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            d.a.m0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
            if (i2 == -2) {
                d.a.m0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i2 != 0) {
                d.a.m0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.a.m0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                o oVar = o.this;
                oVar.i(new d());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.m0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.m0.a.v2.e1.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    d.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    o.this.v = string;
                    o oVar = o.this;
                    oVar.i(new b());
                    d.this.d();
                    return;
                }
                d.this.e(new OAuthException("empty stoken", 10001));
            }
        }

        public d() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            d.a.m0.b.j.a.t(o.this.n, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public o(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        if (z2) {
            z();
        }
    }

    @Override // d.a.m0.a.e2.c.j.b, d.a.m0.a.e2.c.j.h
    public void J() {
        super.J();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.e2.c.j.b, d.a.m0.a.e2.c.c
    /* renamed from: a0 */
    public b.e n(JSONObject jSONObject) throws JSONException {
        Context context = this.n;
        if (context instanceof Activity) {
            d.a.m0.b.j.a.E((Activity) context, jSONObject);
        } else if (d.a.m0.a.e2.c.c.f45458f) {
            Log.d("SearchBoxAuthorize", Log.getStackTraceString(new Exception("context is not activity.")));
        }
        return super.n(jSONObject);
    }

    @Override // d.a.m0.a.e2.c.j.b, d.a.m0.a.e2.c.c
    public boolean k() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", N().D());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", N().D());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.m0.a.e2.c.d.g());
            jSONObject2.put("stoken", this.v);
            String l = d.a.m0.a.c1.a.n().l();
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
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.m0.a.e2.c.j.b, d.a.m0.a.e2.c.c
    public boolean l() {
        if (N().j().e(this.n)) {
            i(new d());
            return true;
        }
        i(new b());
        return true;
    }
}
