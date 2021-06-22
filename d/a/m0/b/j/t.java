package d.a.m0.b.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t extends d.a.m0.a.e2.c.j.g {
    public static final boolean u = d.a.m0.a.k.f46983a;
    public boolean s;
    public String t;

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.e2.c.e {

        /* loaded from: classes3.dex */
        public class a implements d.a.m0.a.v2.e1.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    b.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    t.this.t = string;
                    b.this.d();
                    return;
                }
                b.this.e(new OAuthException("empty stoken", 10001));
            }
        }

        public b() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            if (!t.this.s) {
                t.this.t = null;
                if (t.u) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            d.a.m0.b.j.a.t(t.this.m, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public t(Activity activity, String str, String str2, boolean z, boolean z2) {
        super(activity, str, str2, z);
        this.s = z2;
        z();
    }

    @Override // d.a.m0.a.e2.c.j.g
    public JSONObject Q() {
        JSONObject Q = super.Q();
        if (!TextUtils.isEmpty(this.t)) {
            try {
                Q.put("stoken", this.t);
            } catch (JSONException e2) {
                if (u) {
                    e2.printStackTrace();
                }
            }
        }
        return Q;
    }

    @Override // d.a.m0.a.e2.c.c
    public boolean l() {
        i(new b());
        return true;
    }
}
