package d.a.m0.j.k;

import android.content.Context;
import d.a.m0.a.a2.e;
import d.a.m0.a.h1.c.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a<T extends d.a.m0.a.h1.c.c> {
    public abstract boolean b(Context context, T t, d.a.m0.a.h1.b bVar, e eVar, JSONObject jSONObject);

    public boolean c(Context context, T t, d.a.m0.a.h1.b bVar, e eVar) {
        JSONObject jSONObject = new JSONObject();
        if (!b(context, t, bVar, eVar, jSONObject)) {
            bVar.d(1001);
            d.a.m0.a.e0.d.b("map", "doAction fail");
            return false;
        }
        if (jSONObject.length() <= 0) {
            jSONObject = null;
        }
        bVar.e(jSONObject);
        return true;
    }
}
