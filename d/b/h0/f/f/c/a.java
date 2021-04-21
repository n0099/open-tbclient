package d.b.h0.f.f.c;

import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.f.i.a {
    static {
        boolean z = k.f45772a;
    }

    public a() {
        super("getDownloadConfig");
    }

    @Override // d.b.h0.f.i.a
    public d.b.h0.a.t.e.b a(JSONObject jSONObject, d.b.h0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (jSONObject.has("wifiResumeDownloadFlag")) {
            d.b.h0.f.f.d.b.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
        }
        if (jSONObject.has("install_guide_switch")) {
            d.b.h0.f.f.e.a.r(jSONObject.optBoolean("install_guide_switch"));
        }
        if (jSONObject.has("install_guide_count")) {
            d.b.h0.f.f.e.a.q(jSONObject.optInt("install_guide_count"));
        }
        bVar.a(null);
        return null;
    }
}
