package d.b.h0.h.a.f;

import android.content.Context;
import d.b.h0.a.a1.c.c;
import d.b.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a<T extends d.b.h0.a.a1.c.c> {
    public abstract boolean b(Context context, T t, d.b.h0.a.a1.b bVar, e eVar, JSONObject jSONObject);

    public boolean c(Context context, T t, d.b.h0.a.a1.b bVar, e eVar) {
        JSONObject jSONObject = new JSONObject();
        if (!b(context, t, bVar, eVar, jSONObject)) {
            bVar.d(1001);
            d.b.h0.a.c0.c.b("map", "doAction fail");
            return false;
        }
        if (jSONObject.length() <= 0) {
            jSONObject = null;
        }
        bVar.e(jSONObject);
        return true;
    }
}
