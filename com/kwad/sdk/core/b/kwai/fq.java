package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fq implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (jSONObject.opt("videoUrl") == JSONObject.NULL) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (jSONObject.opt("manifest") == JSONObject.NULL) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString(SpeedStatsMainTable.FIRST_FRAME_STAGE);
        if (jSONObject.opt(SpeedStatsMainTable.FIRST_FRAME_STAGE) == JSONObject.NULL) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "videoUrl", videoInfo.videoUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "manifest", videoInfo.manifest);
        com.kwad.sdk.utils.r.a(jSONObject, SpeedStatsMainTable.FIRST_FRAME_STAGE, videoInfo.firstFrame);
        com.kwad.sdk.utils.r.a(jSONObject, "duration", videoInfo.duration);
        com.kwad.sdk.utils.r.a(jSONObject, "size", videoInfo.size);
        com.kwad.sdk.utils.r.a(jSONObject, "width", videoInfo.width);
        com.kwad.sdk.utils.r.a(jSONObject, "height", videoInfo.height);
        com.kwad.sdk.utils.r.a(jSONObject, "leftRatio", videoInfo.leftRatio);
        com.kwad.sdk.utils.r.a(jSONObject, "topRatio", videoInfo.topRatio);
        com.kwad.sdk.utils.r.a(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.r.a(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        a2(videoInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return b2(videoInfo, jSONObject);
    }
}
