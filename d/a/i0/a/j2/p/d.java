package d.a.i0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends f {
    public static final boolean x = k.f43025a;
    public static int y = 35;
    public boolean v = false;
    public JSONObject w;

    public d() {
        this.f43013c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
    }

    @Override // d.a.i0.a.j2.p.f, d.a.i0.a.j2.p.e
    public JSONObject f() {
        if (this.f43018h == null) {
            this.f43018h = new JSONObject();
        }
        try {
            if (this.w != null) {
                if (this.v) {
                    String z = q0.z(y);
                    if (!TextUtils.isEmpty(z)) {
                        this.w.put("stacktrace", z);
                    }
                }
                if (this.w.length() != 0) {
                    this.f43018h.put("info", this.w);
                }
            }
            ExtensionCore M = d.a.i0.a.h0.u.g.N().M();
            if (M != null) {
                this.f43018h.put("extension_ver", M.extensionCoreVersionName);
            }
        } catch (JSONException e2) {
            if (x) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public d l(String str, String str2) {
        if (str != null && str2 != null) {
            if (this.w == null) {
                this.w = new JSONObject();
            }
            try {
                this.w.put(str, str2);
            } catch (JSONException e2) {
                if (x) {
                    e2.printStackTrace();
                }
            }
        }
        return this;
    }

    public d m(String str) {
        this.f43016f = str;
        return this;
    }

    public d n(boolean z) {
        this.v = z;
        return this;
    }

    public d o(int i2) {
        this.f43012b = String.valueOf(i2);
        return this;
    }

    public d p(@NonNull d.a.i0.a.q2.a aVar) {
        this.f43012b = String.valueOf(aVar.a());
        String sb = aVar.f().toString();
        if (!TextUtils.isEmpty(sb)) {
            l("detail", sb);
        }
        return this;
    }

    public d q(String str) {
        this.f43011a = str;
        return this;
    }

    public d r(d.a.i0.a.f1.e.e eVar) {
        if (eVar == null) {
            return this;
        }
        if (!TextUtils.isEmpty(eVar.T())) {
            this.f43013c = eVar.T();
        }
        if (!TextUtils.isEmpty(eVar.H())) {
            this.f43016f = eVar.H();
        }
        if (!TextUtils.isEmpty(eVar.W())) {
            this.p = eVar.W();
        }
        if (!TextUtils.isEmpty(eVar.e0())) {
            this.s = eVar.e0();
        }
        return this;
    }

    public d s(String str) {
        this.f43017g = str;
        return this;
    }

    public d t(String str) {
        this.f43013c = str;
        return this;
    }
}
