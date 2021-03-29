package d.b.g0.a.c1.c;

import android.util.Log;
import d.b.g0.a.k0.b.g;
import d.b.g0.a.z0.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static void a(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level", String.valueOf(num));
        f.V().N(new d.b.g0.a.k0.b.b("text-size-adjust", hashMap));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2) {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "text-size-adjust");
            jSONObject.put("level", str2);
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f45069b = jSONObject;
        f.V().z(str, gVar);
    }
}
