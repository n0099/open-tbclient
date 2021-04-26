package d.a.d0.a;

import android.content.Context;
import d.a.d0.a.d.c;
import d.a.d0.a.d.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public d.a.d0.a.g.b a(Context context, b bVar) {
        JSONObject a2;
        if (bVar == null || context == null || (a2 = bVar.a()) == null) {
            return null;
        }
        String optString = a2.optString("material_type");
        if ("image".equals(optString)) {
            return new c(context, a2);
        }
        if ("gif".equals(optString)) {
            return new d.a.d0.a.d.b(context, a2);
        }
        if ("video".equals(optString)) {
            return new d(context, a2);
        }
        return null;
    }
}
