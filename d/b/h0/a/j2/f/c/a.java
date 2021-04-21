package d.b.h0.a.j2.f.c;

import d.b.h0.a.k;
import d.b.h0.a.k0.b.g;
import d.b.h0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slaveId", str);
            jSONObject.put("type", str2);
        } catch (JSONException e2) {
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str2);
            jSONObject3.put("action", str4);
            jSONObject3.put("e", jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str3);
            jSONObject4.put("params", jSONObject3);
            jSONObject2.put("slaveId", str);
            jSONObject2.put("type", "abilityMessage");
            jSONObject2.put("value", jSONObject4);
        } catch (JSONException e2) {
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
    public static void c(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        g gVar = new g();
        gVar.f45790b = b(str, str2, str3, str4, jSONObject);
        f.V().N(gVar);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    public static void d(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        g gVar = new g();
        gVar.f45790b = b(str, str2, str3, str4, jSONObject);
        f.V().z(str, gVar);
    }
}
