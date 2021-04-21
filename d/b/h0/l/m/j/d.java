package d.b.h0.l.m.j;

import androidx.annotation.Nullable;
import d.b.h0.l.h.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.h0.l.m.a {
    @Override // d.b.h0.l.m.a, d.b.h0.l.m.d
    public void b(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        JSONObject optJSONObject;
        a a2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("base_info")) == null || (a2 = a.a(optJSONObject)) == null) {
            return;
        }
        b.b().d(a2);
    }
}
