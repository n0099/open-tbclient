package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class fy implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
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
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, SpeedStatsMainTable.FIRST_FRAME_STAGE, videoInfo.firstFrame);
        }
        long j = videoInfo.duration;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "duration", j);
        }
        int i = videoInfo.size;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "size", i);
        }
        int i2 = videoInfo.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", i2);
        }
        int i3 = videoInfo.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", i3);
        }
        double d = videoInfo.leftRatio;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "leftRatio", d);
        }
        double d2 = videoInfo.topRatio;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "topRatio", d2);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.r.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
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
