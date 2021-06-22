package d.a.m0.a.j1.e;

import android.util.Log;
import d.a.m0.a.g1.f;
import d.a.m0.a.o0.d.g;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static void a(Integer num, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("level", String.valueOf(num));
        hashMap.put("percentage", str + "%");
        f.V().v(new d.a.m0.a.o0.d.b("text-size-adjust", hashMap));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3) {
        g gVar = new g();
        ?? jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "text-size-adjust");
            jSONObject.put("percentage", str3 + "%");
            jSONObject.put("level", str2);
        } catch (JSONException e2) {
            d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
        }
        gVar.f47708c = jSONObject;
        f.V().m(str, gVar);
    }
}
