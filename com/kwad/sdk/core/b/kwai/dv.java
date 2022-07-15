package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dv implements com.kwad.sdk.core.d<PhotoInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoInfo.mOriginJString = jSONObject.optString("mOriginJString");
        if (jSONObject.opt("mOriginJString") == JSONObject.NULL) {
            photoInfo.mOriginJString = "";
        }
        PhotoInfo.BaseInfo baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo = baseInfo;
        baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        PhotoInfo.VideoInfo videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo = videoInfo;
        videoInfo.parseJson(jSONObject.optJSONObject(TbPreviewVideoActivityConfig.KEY_VIDEO_INFO));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mOriginJString", photoInfo.mOriginJString);
        com.kwad.sdk.utils.r.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.r.a(jSONObject, TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, photoInfo.videoInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        a2(photoInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        return b2(photoInfo, jSONObject);
    }
}
