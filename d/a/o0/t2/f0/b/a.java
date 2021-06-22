package d.a.o0.t2.f0.b;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f64875a;

    /* renamed from: b  reason: collision with root package name */
    public String f64876b;

    /* renamed from: c  reason: collision with root package name */
    public String f64877c;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f64875a = jSONObject.optString("brand_name");
        aVar.f64876b = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        aVar.f64877c = jSONObject.optString("button_scheme");
        return aVar;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_name", this.f64875a);
            jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f64876b);
            jSONObject.put("button_scheme", this.f64877c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
