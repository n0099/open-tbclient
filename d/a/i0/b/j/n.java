package d.a.i0.b.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import d.a.i0.a.e2.c.j.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends d.a.i0.a.e2.c.j.a {
    public String p;

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.i0.a.v2.e1.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    b.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    n.this.p = string;
                    b.this.d();
                    return;
                }
                b.this.e(new OAuthException("empty stoken", 10001));
            }
        }

        public b() {
        }

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            d.a.i0.b.j.a.t(n.this.n, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public n(Activity activity, boolean z, String str, String str2) {
        super(activity, z, str, str2);
        if (z) {
            z();
        }
    }

    @Override // d.a.i0.a.e2.c.j.a, d.a.i0.a.e2.c.j.h
    public void J() {
        super.J();
        d.a.i0.a.n1.q.c.a.f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.e2.c.c
    /* renamed from: Q */
    public a.b n(JSONObject jSONObject) throws JSONException {
        d.a.i0.b.j.a.E(this.n, jSONObject);
        return super.Q(jSONObject);
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", N().D());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_key", N().D());
            jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject2.put("host_key_hash", d.a.i0.a.e2.c.d.g());
            jSONObject2.put("stoken", this.p);
            String l = d.a.i0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject2.put("host_api_key", l);
            }
            jSONObject.put("open", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("permit", Boolean.toString(this.o));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(this.m, jSONObject3);
            jSONObject.put("accredits", jSONObject4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        w("data", jSONObject.toString());
        return true;
    }

    @Override // d.a.i0.a.e2.c.c
    public boolean l() {
        i(new b());
        return true;
    }
}
