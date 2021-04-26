package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bp implements com.kwad.sdk.core.c<PhotoInfo.VideoInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        videoInfo.manifest = jSONObject.optString("manifest");
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "videoUrl", videoInfo.videoUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "manifest", videoInfo.manifest);
        com.kwad.sdk.utils.o.a(jSONObject, "firstFrame", videoInfo.firstFrame);
        com.kwad.sdk.utils.o.a(jSONObject, "duration", videoInfo.duration);
        com.kwad.sdk.utils.o.a(jSONObject, "size", videoInfo.size);
        com.kwad.sdk.utils.o.a(jSONObject, "width", videoInfo.width);
        com.kwad.sdk.utils.o.a(jSONObject, "height", videoInfo.height);
        com.kwad.sdk.utils.o.a(jSONObject, "leftRatio", videoInfo.leftRatio);
        com.kwad.sdk.utils.o.a(jSONObject, "topRatio", videoInfo.topRatio);
        com.kwad.sdk.utils.o.a(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.o.a(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
