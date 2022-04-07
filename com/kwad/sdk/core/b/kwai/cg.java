package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cg implements com.kwad.sdk.core.d<LiveInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveInfo.livingLink = jSONObject.optString("livingLink");
        if (jSONObject.opt("livingLink") == JSONObject.NULL) {
            liveInfo.livingLink = "";
        }
        liveInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (jSONObject.opt("shennongjiaLog") == JSONObject.NULL) {
            liveInfo.shennongjiaLog = "";
        }
        liveInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (jSONObject.opt("nebulaKwaiLink") == JSONObject.NULL) {
            liveInfo.nebulaKwaiLink = "";
        }
        liveInfo.linkCode = jSONObject.optString("linkCode");
        if (jSONObject.opt("linkCode") == JSONObject.NULL) {
            liveInfo.linkCode = "";
        }
        liveInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (jSONObject.opt("liveStreamId") == JSONObject.NULL) {
            liveInfo.liveStreamId = "";
        }
        liveInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            liveInfo.title = "";
        }
        liveInfo.coverUrl = jSONObject.optString("coverUrl");
        if (jSONObject.opt("coverUrl") == JSONObject.NULL) {
            liveInfo.coverUrl = "";
        }
        LiveInfo.User user = new LiveInfo.User();
        liveInfo.user = user;
        user.parseJson(jSONObject.optJSONObject("user"));
        LiveInfo.CoverUrlCdn coverUrlCdn = new LiveInfo.CoverUrlCdn();
        liveInfo.coverUrlCdn = coverUrlCdn;
        coverUrlCdn.parseJson(jSONObject.optJSONObject("coverUrlCdn"));
        liveInfo.playInfo = jSONObject.optString("playInfo");
        if (jSONObject.opt("playInfo") == JSONObject.NULL) {
            liveInfo.playInfo = "";
        }
        liveInfo.audienceCount = jSONObject.optInt("audienceCount");
        liveInfo.caption = jSONObject.optString("caption");
        if (jSONObject.opt("caption") == JSONObject.NULL) {
            liveInfo.caption = "";
        }
        liveInfo.cover_thumbnail_urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                LiveInfo.CoverThumbnailUrl coverThumbnailUrl = new LiveInfo.CoverThumbnailUrl();
                coverThumbnailUrl.parseJson(optJSONArray.optJSONObject(i));
                liveInfo.cover_thumbnail_urls.add(coverThumbnailUrl);
            }
        }
        liveInfo.exp_tag = jSONObject.optString("exp_tag");
        if (jSONObject.opt("exp_tag") == JSONObject.NULL) {
            liveInfo.exp_tag = "";
        }
        liveInfo.liveStreamPlayCdnList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("liveStreamPlayCdnList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode = new LiveInfo.LiveStreamPlayCDNNode();
                liveStreamPlayCDNNode.parseJson(optJSONArray2.optJSONObject(i2));
                liveInfo.liveStreamPlayCdnList.add(liveStreamPlayCDNNode);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "livingLink", liveInfo.livingLink);
        com.kwad.sdk.utils.t.a(jSONObject, "shennongjiaLog", liveInfo.shennongjiaLog);
        com.kwad.sdk.utils.t.a(jSONObject, "nebulaKwaiLink", liveInfo.nebulaKwaiLink);
        com.kwad.sdk.utils.t.a(jSONObject, "linkCode", liveInfo.linkCode);
        com.kwad.sdk.utils.t.a(jSONObject, "liveStreamId", liveInfo.liveStreamId);
        com.kwad.sdk.utils.t.a(jSONObject, "title", liveInfo.title);
        com.kwad.sdk.utils.t.a(jSONObject, "coverUrl", liveInfo.coverUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "user", liveInfo.user);
        com.kwad.sdk.utils.t.a(jSONObject, "coverUrlCdn", liveInfo.coverUrlCdn);
        com.kwad.sdk.utils.t.a(jSONObject, "playInfo", liveInfo.playInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "audienceCount", liveInfo.audienceCount);
        com.kwad.sdk.utils.t.a(jSONObject, "caption", liveInfo.caption);
        com.kwad.sdk.utils.t.a(jSONObject, "cover_thumbnail_urls", liveInfo.cover_thumbnail_urls);
        com.kwad.sdk.utils.t.a(jSONObject, "exp_tag", liveInfo.exp_tag);
        com.kwad.sdk.utils.t.a(jSONObject, "liveStreamPlayCdnList", liveInfo.liveStreamPlayCdnList);
        return jSONObject;
    }
}
