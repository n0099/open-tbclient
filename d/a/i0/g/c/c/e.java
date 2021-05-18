package d.a.i0.g.c.c;

import androidx.annotation.NonNull;
import d.a.i0.a.v2.k0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.i0.g.f.a {
    public e() {
        super("getAvailableSpace");
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.i0.a.u0.b bVar) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", k0.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bVar.b(jSONObject2);
        return null;
    }
}
