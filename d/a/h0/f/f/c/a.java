package d.a.h0.f.f.c;

import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.f.i.a {
    static {
        boolean z = k.f43101a;
    }

    public a() {
        super("getDownloadConfig");
    }

    @Override // d.a.h0.f.i.a
    public d.a.h0.a.t.e.b a(JSONObject jSONObject, d.a.h0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (jSONObject.has("wifiResumeDownloadFlag")) {
            d.a.h0.f.f.d.b.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", true));
        }
        if (jSONObject.has("install_guide_switch")) {
            d.a.h0.f.f.e.a.r(jSONObject.optBoolean("install_guide_switch"));
        }
        if (jSONObject.has("install_guide_count")) {
            d.a.h0.f.f.e.a.q(jSONObject.optInt("install_guide_count"));
        }
        bVar.a(null);
        return null;
    }
}
