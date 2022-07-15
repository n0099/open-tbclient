package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class am implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
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
        baseInfo.createTime = jSONObject.optLong(FileMetaUtil.CREATE_TIME);
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (jSONObject.opt("videoDesc") == JSONObject.NULL) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "photoId", baseInfo.photoId);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        com.kwad.sdk.utils.r.a(jSONObject, "title", baseInfo.title);
        com.kwad.sdk.utils.r.a(jSONObject, "shareUrl", baseInfo.shareUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.r.a(jSONObject, "recoExt", baseInfo.recoExt);
        com.kwad.sdk.utils.r.a(jSONObject, "likeCount", baseInfo.likeCount);
        com.kwad.sdk.utils.r.a(jSONObject, "commentCount", baseInfo.commentCount);
        com.kwad.sdk.utils.r.a(jSONObject, "viewCount", baseInfo.viewCount);
        com.kwad.sdk.utils.r.a(jSONObject, FileMetaUtil.CREATE_TIME, baseInfo.createTime);
        com.kwad.sdk.utils.r.a(jSONObject, "videoDesc", baseInfo.videoDesc);
        com.kwad.sdk.utils.r.a(jSONObject, "playTimes", baseInfo.playTimes);
        com.kwad.sdk.utils.r.a(jSONObject, "videoUrlCacheTime", baseInfo.videoUrlCacheTime);
        com.kwad.sdk.utils.r.a(jSONObject, "contentSourceType", baseInfo.contentSourceType);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }
}
