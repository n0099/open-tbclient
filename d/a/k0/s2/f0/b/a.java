package d.a.k0.s2.f0.b;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60956a;

    /* renamed from: b  reason: collision with root package name */
    public String f60957b;

    /* renamed from: c  reason: collision with root package name */
    public String f60958c;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f60956a = jSONObject.optString("brand_name");
        aVar.f60957b = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        aVar.f60958c = jSONObject.optString("button_scheme");
        return aVar;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_name", this.f60956a);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f60957b);
            jSONObject.put("button_scheme", this.f60958c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
