package d.b.g0.l.m.k;

import com.baidu.webkit.internal.ETAG;
import d.b.g0.l.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.g0.l.m.b {
    @Override // d.b.g0.l.m.b
    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        d.b.g0.l.b b2 = f.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "bbasp_core");
            jSONObject.put("version_name", b2 != null ? b2.l() : "0");
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            if (f.f49281a) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "bbasp_game");
            jSONObject2.put("version_name", b2 != null ? b2.m() : "0");
            jSONArray.put(jSONObject2);
        } catch (JSONException e3) {
            if (f.f49281a) {
                e3.printStackTrace();
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("type", ETAG.KEY_EXTENSION);
            jSONObject3.put("version_name", b2 != null ? b2.C() : "0");
            jSONArray.put(jSONObject3);
        } catch (JSONException e4) {
            if (f.f49281a) {
                e4.printStackTrace();
            }
        }
        return jSONArray;
    }
}
