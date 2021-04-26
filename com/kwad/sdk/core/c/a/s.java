package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s implements com.kwad.sdk.core.c<PhotoInfo.BaseInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.title = jSONObject.optString("title");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "photoId", baseInfo.photoId);
        com.kwad.sdk.utils.o.a(jSONObject, "title", baseInfo.title);
        com.kwad.sdk.utils.o.a(jSONObject, "shareUrl", baseInfo.shareUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.o.a(jSONObject, "recoExt", baseInfo.recoExt);
        com.kwad.sdk.utils.o.a(jSONObject, "likeCount", baseInfo.likeCount);
        com.kwad.sdk.utils.o.a(jSONObject, "commentCount", baseInfo.commentCount);
        com.kwad.sdk.utils.o.a(jSONObject, "viewCount", baseInfo.viewCount);
        com.kwad.sdk.utils.o.a(jSONObject, "createTime", baseInfo.createTime);
        com.kwad.sdk.utils.o.a(jSONObject, "videoDesc", baseInfo.videoDesc);
        com.kwad.sdk.utils.o.a(jSONObject, "videoUrlCacheTime", baseInfo.videoUrlCacheTime);
        com.kwad.sdk.utils.o.a(jSONObject, "contentSourceType", baseInfo.contentSourceType);
        return jSONObject;
    }
}
