package d.a.l0.g.c.c;

import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.g.f.a {
    static {
        boolean z = k.f43199a;
    }

    public a() {
        super("getDownloadConfig");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(JSONObject jSONObject, d.a.l0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (jSONObject.has("wifiResumeDownloadFlag")) {
            d.a.l0.g.c.d.b.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
        }
        if (jSONObject.has("install_guide_switch")) {
            d.a.l0.g.c.e.a.r(jSONObject.optBoolean("install_guide_switch"));
        }
        if (jSONObject.has("install_guide_count")) {
            d.a.l0.g.c.e.a.q(jSONObject.optInt("install_guide_count"));
        }
        if (jSONObject.has("get_install_result")) {
            d.a.l0.g.c.e.a.s(jSONObject.optBoolean("get_install_result"));
        }
        bVar.b(null);
        return null;
    }
}
