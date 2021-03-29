package d.b.g0.f.f.c;

import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.f.i.a {
    static {
        boolean z = k.f45051a;
    }

    public a() {
        super("getDownloadConfig");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(JSONObject jSONObject, d.b.g0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (jSONObject.has("wifiResumeDownloadFlag")) {
            d.b.g0.f.f.d.b.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
        }
        if (jSONObject.has("install_guide_switch")) {
            d.b.g0.f.f.e.a.r(jSONObject.optBoolean("install_guide_switch"));
        }
        if (jSONObject.has("install_guide_count")) {
            d.b.g0.f.f.e.a.q(jSONObject.optInt("install_guide_count"));
        }
        bVar.a(null);
        return null;
    }
}
