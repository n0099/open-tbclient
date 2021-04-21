package d.b.i0.r.q;

import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes3.dex */
public class u0 {
    public static McnAdInfo a(JSONObject jSONObject) {
        McnAdInfo.Builder builder = new McnAdInfo.Builder();
        if (jSONObject != null) {
            builder.ad_start_time = Long.valueOf(jSONObject.optLong("ad_start_time"));
            builder.ad_end_time = Long.valueOf(jSONObject.optLong("ad_end_time"));
            builder.pic_url = jSONObject.optString("pic_url");
            builder.jump_url = jSONObject.optString("jump_url");
            builder.card_title = jSONObject.optString("card_title");
            builder.button_title = jSONObject.optString("button_title");
            builder.effect_time = Long.valueOf(jSONObject.optLong("effect_time"));
            builder.expire_time = Long.valueOf(jSONObject.optLong("expire_time"));
        }
        return builder.build(true);
    }
}
