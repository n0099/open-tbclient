package d.b.g0.f.h;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.f.i.a {
    public b() {
        super("echoSync");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optInt == 0) {
            return new d.b.g0.a.t.e.b(optInt, optJSONObject);
        }
        return new d.b.g0.a.t.e.b(optInt, optString);
    }
}
