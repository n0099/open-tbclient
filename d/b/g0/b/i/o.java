package d.b.g0.b.i;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends d.b.g0.a.v1.c.i.b {
    public String u;

    /* loaded from: classes3.dex */
    public class b extends d.b.g0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.e> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(d.b.g0.a.v1.c.e eVar) {
                if (d.b.g0.a.v1.c.b.f46748f) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ListPreparation result: ");
                    sb.append(eVar == null ? StringUtil.NULL_STRING : eVar);
                    Log.i("aiapps-oauth", sb.toString());
                }
                o.this.q = eVar;
                if (eVar == null) {
                    b.this.e(new Exception("no such scope"));
                    return;
                }
                if (eVar.c() && !o.this.p) {
                    o oVar = o.this;
                    oVar.i(new c());
                } else {
                    o oVar2 = o.this;
                    oVar2.i(new b.C0866b());
                }
                b.this.d();
            }
        }

        public b() {
        }

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            if (TextUtils.isEmpty(o.this.r)) {
                if (o.this.l.length <= 1) {
                    d.b.g0.a.g1.o.c.a.i(o.this.l[0], new a());
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
    public class c extends d.b.g0.a.v1.c.d implements d.b.g0.a.m.a {
        public c() {
        }

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            o.this.p = true;
            if (o.this.G().z().e(o.this.m)) {
                d.b.g0.a.v1.c.c.j("LoginPreparation: isLogin true", Boolean.FALSE);
                o oVar = o.this;
                oVar.i(new d());
                return true;
            }
            d.b.g0.a.r1.e G = o.this.G();
            if (!G.Z()) {
                if (o.this.m instanceof Activity) {
                    G.z().f((Activity) o.this.m, null, this);
                    return false;
                }
                d.b.g0.a.v1.c.c.j("login error context is not activity.", Boolean.TRUE);
                e(new OAuthException(10004));
                return true;
            }
            d.b.g0.a.v1.c.c.j("this operation does not supported when app is invisible.", Boolean.TRUE);
            e(new OAuthException(10004));
            return true;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            d.b.g0.a.v1.c.c.j("onResult :: " + i, Boolean.FALSE);
            if (i == -2) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                e(new OAuthException(10004));
            } else if (i != 0) {
                d.b.g0.a.v1.c.c.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                e(new OAuthException(10004));
            } else {
                d.b.g0.a.v1.c.c.j("Login Preparation ok, is already login", Boolean.FALSE);
                o oVar = o.this;
                oVar.i(new d());
                d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.b.g0.a.i2.u0.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    d.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    o.this.u = string;
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

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            d.b.g0.b.i.a.t(o.this.m, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public o(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        super(context, z, z2, strArr, str, z3);
        if (z2) {
            z();
        }
    }

    @Override // d.b.g0.a.v1.c.i.b, d.b.g0.a.v1.c.i.h
    public void E() {
        super.E();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.v1.c.i.b, d.b.g0.a.v1.c.b
    /* renamed from: S */
    public b.e n(JSONObject jSONObject) throws JSONException {
        Context context = this.m;
        if (context instanceof Activity) {
            d.b.g0.b.i.a.G((Activity) context, jSONObject);
        } else if (d.b.g0.a.v1.c.b.f46748f) {
            Log.d("SearchBoxAuthorize", Log.getStackTraceString(new Exception("context is not activity.")));
        }
        return super.n(jSONObject);
    }

    @Override // d.b.g0.a.v1.c.i.b, d.b.g0.a.v1.c.b
    public boolean k() {
        String[] strArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", G().f45740f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1858h, G().B());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.b.g0.a.v1.c.c.g());
            jSONObject2.put("stoken", this.u);
            String x = d.b.g0.a.w0.a.l().x();
            if (!TextUtils.isEmpty(x)) {
                jSONObject2.put("host_api_key", x);
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
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.b.g0.a.v1.c.i.b, d.b.g0.a.v1.c.b
    public boolean l() {
        if (G().z().e(this.m)) {
            i(new d());
            return true;
        }
        i(new b());
        return true;
    }
}
