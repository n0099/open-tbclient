package d.a.h0.a.c1.c;

import android.util.Log;
import d.a.h0.a.k0.b.g;
import d.a.h0.a.z0.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static void a(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level", String.valueOf(num));
        f.V().x(new d.a.h0.a.k0.b.b("text-size-adjust", hashMap));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2) {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "text-size-adjust");
            jSONObject.put("level", str2);
        } catch (JSONException e2) {
            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f43119b = jSONObject;
        f.V().o(str, gVar);
    }
}
