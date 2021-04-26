package com.kwad.sdk.core.c.a;

import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class am implements com.kwad.sdk.core.c<LiveInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveInfo.liveStreamId = jSONObject.optString("liveStreamId");
        LiveInfo.User user = new LiveInfo.User();
        liveInfo.user = user;
        user.parseJson(jSONObject.optJSONObject("user"));
        liveInfo.playInfo = jSONObject.optString("playInfo");
        liveInfo.audienceCount = jSONObject.optString("audienceCount");
        liveInfo.caption = jSONObject.optString("caption");
        liveInfo.cover_thumbnail_urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                LiveInfo.CoverThumbnailUrl coverThumbnailUrl = new LiveInfo.CoverThumbnailUrl();
                coverThumbnailUrl.parseJson(optJSONArray.optJSONObject(i2));
                liveInfo.cover_thumbnail_urls.add(coverThumbnailUrl);
            }
        }
        liveInfo.exp_tag = jSONObject.optString("exp_tag");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "liveStreamId", liveInfo.liveStreamId);
        com.kwad.sdk.utils.o.a(jSONObject, "user", liveInfo.user);
        com.kwad.sdk.utils.o.a(jSONObject, "playInfo", liveInfo.playInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "audienceCount", liveInfo.audienceCount);
        com.kwad.sdk.utils.o.a(jSONObject, "caption", liveInfo.caption);
        com.kwad.sdk.utils.o.a(jSONObject, "cover_thumbnail_urls", liveInfo.cover_thumbnail_urls);
        com.kwad.sdk.utils.o.a(jSONObject, "exp_tag", liveInfo.exp_tag);
        return jSONObject;
    }
}
