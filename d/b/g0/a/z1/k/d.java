package d.b.g0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends f {
    public static final boolean y = k.f45050a;
    public static int z = 35;
    public boolean w = false;
    public JSONObject x;

    public d() {
        this.f47252c = "NA";
    }

    @Override // d.b.g0.a.z1.k.f, d.b.g0.a.z1.k.e
    public JSONObject f() {
        if (this.f47256g == null) {
            this.f47256g = new JSONObject();
        }
        try {
            if (this.x != null) {
                if (this.w) {
                    String v = k0.v(z);
                    if (!TextUtils.isEmpty(v)) {
                        this.x.put("stacktrace", v);
                    }
                }
                this.f47256g.put("info", this.x);
            }
            ExtensionCore K = d.b.g0.a.e0.w.d.L().K();
            if (K != null) {
                this.f47256g.put("extension_ver", K.extensionCoreVersionName);
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
        this.f47254e = str;
        return this;
    }

    public d n(boolean z2) {
        this.w = z2;
        return this;
    }

    public d o(int i) {
        this.f47251b = String.valueOf(i);
        return this;
    }

    public d p(@NonNull d.b.g0.a.f2.a aVar) {
        this.f47251b = String.valueOf(aVar.a());
        l("detail", aVar.f().toString());
        return this;
    }

    public d q(String str) {
        this.f47250a = str;
        return this;
    }

    public d r(d.b.g0.a.y0.e.e eVar) {
        if (eVar == null) {
            return this;
        }
        if (!TextUtils.isEmpty(eVar.S())) {
            this.f47252c = eVar.S();
        }
        if (!TextUtils.isEmpty(eVar.G())) {
            this.f47254e = eVar.G();
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
        this.f47255f = str;
        return this;
    }

    public d t(String str) {
        this.f47252c = str;
        return this;
    }
}
