package d.a.k0.d3.h0;

import org.json.JSONObject;
import tbclient.DetailInfo;
/* loaded from: classes5.dex */
public class j {
    public j(DetailInfo detailInfo) {
        if (detailInfo == null) {
            return;
        }
        String str = detailInfo.text;
        String str2 = detailInfo.url;
    }

    public j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("text");
        jSONObject.optString("url");
    }
}
