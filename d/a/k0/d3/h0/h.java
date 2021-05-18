package d.a.k0.d3.h0;

import org.json.JSONObject;
import tbclient.ActBtn;
/* loaded from: classes5.dex */
public class h {
    public h(ActBtn actBtn) {
        if (actBtn == null) {
            return;
        }
        actBtn.type.intValue();
        String str = actBtn.url;
        String str2 = actBtn.text;
    }

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("type");
        jSONObject.optString("url");
        jSONObject.optString("text");
    }
}
