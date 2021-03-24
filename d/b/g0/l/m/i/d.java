package d.b.g0.l.m.i;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.g0.l.m.a {
    @Override // d.b.g0.l.m.a, d.b.g0.l.m.d
    public void b(JSONObject jSONObject, d.b.g0.l.h.g gVar, @Nullable d.b.g0.l.h.g gVar2, @Nullable d.b.g0.l.h.g gVar3) {
        if (jSONObject == null) {
            return;
        }
        e.b().e(jSONObject.optJSONObject("tipmsgs"));
        b.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        g.a().d(jSONObject.optJSONObject("pkg_preload"));
    }
}
