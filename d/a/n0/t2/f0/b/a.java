package d.a.n0.t2.f0.b;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61058a;

    /* renamed from: b  reason: collision with root package name */
    public String f61059b;

    /* renamed from: c  reason: collision with root package name */
    public String f61060c;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f61058a = jSONObject.optString("brand_name");
        aVar.f61059b = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        aVar.f61060c = jSONObject.optString("button_scheme");
        return aVar;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_name", this.f61058a);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f61059b);
            jSONObject.put("button_scheme", this.f61060c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
