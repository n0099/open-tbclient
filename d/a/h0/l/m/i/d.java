package d.a.h0.l.m.i;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.h0.l.m.a {
    @Override // d.a.h0.l.m.a, d.a.h0.l.m.d
    public void b(JSONObject jSONObject, d.a.h0.l.h.g gVar, @Nullable d.a.h0.l.h.g gVar2, @Nullable d.a.h0.l.h.g gVar3) {
        if (jSONObject == null) {
            return;
        }
        e.b().e(jSONObject.optJSONObject("tipmsgs"));
        b.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        g.a().d(jSONObject.optJSONObject("pkg_preload"));
    }
}
