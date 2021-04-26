package d.a.j0.s2.e0.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        jSONObject.optInt("agree_num", -999);
        jSONObject.optInt("share_num", -999);
        jSONObject.optInt("reply_num", -999);
        jSONObject.optLong("time", System.currentTimeMillis());
        return dVar;
    }
}
