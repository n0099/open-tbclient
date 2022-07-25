package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dl implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (jSONObject.opt("materialUrl") == JSONObject.NULL) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (jSONObject.opt("coverUrl") == JSONObject.NULL) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
        materialFeature.firstFrame = jSONObject.optString(SpeedStatsMainTable.FIRST_FRAME_STAGE);
        if (jSONObject.opt(SpeedStatsMainTable.FIRST_FRAME_STAGE) == JSONObject.NULL) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (jSONObject.opt("blurBackgroundUrl") == JSONObject.NULL) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (jSONObject.opt("webpCoverUrl") == JSONObject.NULL) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (jSONObject.opt("ruleId") == JSONObject.NULL) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialFeature.featureType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "featureType", i);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j = materialFeature.photoId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoId", j);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i2 = materialFeature.videoDuration;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, i2);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, SpeedStatsMainTable.FIRST_FRAME_STAGE, materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i3 = materialFeature.videoWidth;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoWidth", i3);
        }
        int i4 = materialFeature.videoHeight;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoHeight", i4);
        }
        long j2 = materialFeature.likeCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "likeCount", j2);
        }
        long j3 = materialFeature.commentCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "commentCount", j3);
        }
        int i5 = materialFeature.source;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "source", i5);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }
}
