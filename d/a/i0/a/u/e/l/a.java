package d.a.i0.a.u.e.l;

import androidx.annotation.NonNull;
import d.a.i0.a.a2.e;
import d.a.i0.a.u.c.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {
    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r() {
        if (e.Q() == null) {
            return new d.a.i0.a.u.h.b(1001, "null swan runtime");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isAllowed", d.a.i0.a.c1.a.a().a());
            return new d.a.i0.a.u.h.b(0, "success", jSONObject);
        } catch (Exception e2) {
            d.a.i0.a.e0.d.c("ActionConfigApi", e2.getMessage(), e2);
            return new d.a.i0.a.u.h.b(1001, e2.getMessage() + "");
        }
    }
}
