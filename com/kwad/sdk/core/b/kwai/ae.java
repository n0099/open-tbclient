package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ae implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (jSONObject.opt("sdkExtraData") == JSONObject.NULL) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            baseInfo.title = "";
        }
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (jSONObject.opt("shareUrl") == JSONObject.NULL) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (jSONObject.opt("recoExt") == JSONObject.NULL) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (jSONObject.opt("videoDesc") == JSONObject.NULL) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "photoId", baseInfo.photoId);
        com.kwad.sdk.utils.t.a(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        com.kwad.sdk.utils.t.a(jSONObject, "title", baseInfo.title);
        com.kwad.sdk.utils.t.a(jSONObject, "shareUrl", baseInfo.shareUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.t.a(jSONObject, "recoExt", baseInfo.recoExt);
        com.kwad.sdk.utils.t.a(jSONObject, "likeCount", baseInfo.likeCount);
        com.kwad.sdk.utils.t.a(jSONObject, "commentCount", baseInfo.commentCount);
        com.kwad.sdk.utils.t.a(jSONObject, "viewCount", baseInfo.viewCount);
        com.kwad.sdk.utils.t.a(jSONObject, "createTime", baseInfo.createTime);
        com.kwad.sdk.utils.t.a(jSONObject, "videoDesc", baseInfo.videoDesc);
        com.kwad.sdk.utils.t.a(jSONObject, "playTimes", baseInfo.playTimes);
        com.kwad.sdk.utils.t.a(jSONObject, "videoUrlCacheTime", baseInfo.videoUrlCacheTime);
        com.kwad.sdk.utils.t.a(jSONObject, "contentSourceType", baseInfo.contentSourceType);
        return jSONObject;
    }
}
