package d.a.l0.g.e;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.g.f.a {
    public b() {
        super("echoSync");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optInt == 0) {
            return new d.a.l0.a.u.h.b(optInt, optJSONObject);
        }
        return new d.a.l0.a.u.h.b(optInt, optString);
    }
}
