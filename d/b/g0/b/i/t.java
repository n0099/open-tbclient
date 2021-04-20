package d.b.g0.b.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t extends d.b.g0.a.v1.c.i.g {
    public static final boolean s = d.b.g0.a.k.f45443a;
    public boolean q;
    public String r;

    /* loaded from: classes3.dex */
    public class b extends d.b.g0.a.v1.c.d {

        /* loaded from: classes3.dex */
        public class a implements d.b.g0.a.i2.u0.b<Bundle> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                if (bundle == null) {
                    b.this.e(new OAuthException("null stoken", 10001));
                    return;
                }
                String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                if (!TextUtils.isEmpty(string)) {
                    t.this.r = string;
                    b.this.d();
                    return;
                }
                b.this.e(new OAuthException("empty stoken", 10001));
            }
        }

        public b() {
        }

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            if (!t.this.q) {
                t.this.r = null;
                if (t.s) {
                    Log.w("MaOpenDataRequest", "user not login");
                    return true;
                }
                return true;
            }
            d.b.g0.b.i.a.t(t.this.l, new a(), BdZeusUtil.URL_KEY_MACHINE);
            return false;
        }
    }

    public t(Activity activity, String str, String str2, boolean z, boolean z2) {
        super(activity, str, str2, z);
        this.q = z2;
        z();
    }

    @Override // d.b.g0.a.v1.c.i.g
    public JSONObject I() {
        JSONObject I = super.I();
        if (!TextUtils.isEmpty(this.r)) {
            try {
                I.put("stoken", this.r);
            } catch (JSONException e2) {
                if (s) {
                    e2.printStackTrace();
                }
            }
        }
        return I;
    }

    @Override // d.b.g0.a.v1.c.b
    public boolean l() {
        i(new b());
        return true;
    }
}
