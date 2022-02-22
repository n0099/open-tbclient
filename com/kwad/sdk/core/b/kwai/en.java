package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class en implements com.kwad.sdk.core.d<LiveInfo.User> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo.User user, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        user.headurls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headurls");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                LiveInfo.User.HeadUrl headUrl = new LiveInfo.User.HeadUrl();
                headUrl.parseJson(optJSONArray.optJSONObject(i2));
                user.headurls.add(headUrl);
            }
        }
        user.user_id = jSONObject.optLong("user_id");
        user.user_name = jSONObject.optString("user_name");
        if (jSONObject.opt("user_name") == JSONObject.NULL) {
            user.user_name = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.User user, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "headurls", user.headurls);
        com.kwad.sdk.utils.t.a(jSONObject, "user_id", user.user_id);
        com.kwad.sdk.utils.t.a(jSONObject, "user_name", user.user_name);
        return jSONObject;
    }
}
