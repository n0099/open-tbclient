package d.a.j0.t;

import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes3.dex */
public class c {
    public void a(JSONObject jSONObject) {
        try {
            jSONObject.optString("icon_url");
            jSONObject.optString("icon_link");
            jSONObject.optString("content");
            jSONObject.optInt("tail_type");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(TailInfo tailInfo) {
        try {
            String str = tailInfo.icon_url;
            String str2 = tailInfo.icon_link;
            String str3 = tailInfo.content;
            tailInfo.tail_type.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
