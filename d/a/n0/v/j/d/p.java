package d.a.n0.v.j.d;

import com.baidu.searchbox.live.interfaces.DI;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("user_id");
        jSONObject.optString("user_name");
        jSONObject.optString("sex");
        jSONObject.optString("description");
        jSONObject.optString("portrait");
        jSONObject.optString("level_id");
        jSONObject.optString("location");
        jSONObject.optString(DI.FOLLOW_STATUS);
        jSONObject.optString("follow_count");
        jSONObject.optString("fans_count");
        jSONObject.optString("live_count");
        jSONObject.optString("record_count");
        jSONObject.optInt("yy_level_id");
        jSONObject.optLong("yy_levelup_exp");
        jSONObject.optLong("yy_level_exp");
        jSONObject.optString("yy_level_name");
        jSONObject.optString("yy_level_next_name");
    }
}
