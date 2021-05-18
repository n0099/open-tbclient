package d.a.i0.n.j.j;

import androidx.annotation.Nullable;
import d.a.i0.n.f.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.i0.n.j.a {
    @Override // d.a.i0.n.j.a, d.a.i0.n.j.d
    public void b(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        JSONObject optJSONObject;
        a a2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("base_info")) == null || (a2 = a.a(optJSONObject)) == null) {
            return;
        }
        b.c().f(a2);
    }
}
