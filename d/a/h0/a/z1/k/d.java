package d.a.h0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends f {
    public static final boolean y = k.f43101a;
    public static int z = 35;
    public boolean w = false;
    public JSONObject x;

    public d() {
        this.f45413c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
    }

    @Override // d.a.h0.a.z1.k.f, d.a.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            if (this.x != null) {
                if (this.w) {
                    String v = k0.v(z);
                    if (!TextUtils.isEmpty(v)) {
                        this.x.put("stacktrace", v);
                    }
                }
                this.f45417g.put("info", this.x);
            }
            ExtensionCore K = d.a.h0.a.e0.w.d.L().K();
            if (K != null) {
                this.f45417g.put("extension_ver", K.extensionCoreVersionName);
            }
        } catch (JSONException e2) {
            if (y) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public d l(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.x == null) {
                this.x = new JSONObject();
            }
            try {
                this.x.put(str, str2);
            } catch (JSONException e2) {
                if (y) {
                    e2.printStackTrace();
                }
            }
        }
        return this;
    }

    public d m(String str) {
        this.f45415e = str;
        return this;
    }

    public d n(boolean z2) {
        this.w = z2;
        return this;
    }

    public d o(int i2) {
        this.f45412b = String.valueOf(i2);
        return this;
    }

    public d p(@NonNull d.a.h0.a.f2.a aVar) {
        this.f45412b = String.valueOf(aVar.a());
        l("detail", aVar.f().toString());
        return this;
    }

    public d q(String str) {
        this.f45411a = str;
        return this;
    }

    public d r(d.a.h0.a.y0.e.e eVar) {
        if (eVar == null) {
            return this;
        }
        if (!TextUtils.isEmpty(eVar.S())) {
            this.f45413c = eVar.S();
        }
        if (!TextUtils.isEmpty(eVar.G())) {
            this.f45415e = eVar.G();
        }
        if (!TextUtils.isEmpty(eVar.V())) {
            this.q = eVar.V();
        }
        if (!TextUtils.isEmpty(eVar.b0())) {
            this.t = eVar.b0();
        }
        return this;
    }

    public d s(String str) {
        this.f45416f = str;
        return this;
    }

    public d t(String str) {
        this.f45413c = str;
        return this;
    }
}
