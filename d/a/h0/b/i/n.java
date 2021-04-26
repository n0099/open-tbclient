package d.a.h0.b.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.h0.a.v1.c.i.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends d.a.h0.a.v1.c.i.a {
    public String o;

    /* loaded from: classes3.dex */
    public class b extends d.a.h0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.a.h0.a.i2.u0.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    b.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    n.this.o = string;
                    b.this.d();
                    return;
                }
                b.this.e(new OAuthException("empty stoken", 10001));
            }
        }

        public b() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            d.a.h0.b.i.a.t(n.this.m, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public n(Activity activity, boolean z, String str, String str2) {
        super(activity, z, str, str2);
        if (z) {
            z();
        }
    }

    @Override // d.a.h0.a.v1.c.i.a, d.a.h0.a.v1.c.i.h
    public void E() {
        super.E();
        d.a.h0.a.g1.o.c.a.f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.v1.c.b
    /* renamed from: I */
    public a.b n(JSONObject jSONObject) throws JSONException {
        d.a.h0.b.i.a.G(this.m, jSONObject);
        return super.I(jSONObject);
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", G().f43823f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.alipay.sdk.cons.b.f1831h, G().B());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.h0.a.v1.c.c.g());
            jSONObject2.put("stoken", this.o);
            String j = d.a.h0.a.w0.a.l().j();
            if (!TextUtils.isEmpty(j)) {
                jSONObject2.put("host_api_key", j);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.n));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.l, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.h0.a.v1.c.b
    public boolean l() {
        i(new b());
        return true;
    }
}
