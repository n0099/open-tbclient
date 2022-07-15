package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fr implements com.kwad.sdk.core.d<VideoPlayerStatus> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mVideoPlayerType", videoPlayerStatus.mVideoPlayerType);
        com.kwad.sdk.utils.r.a(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        a2(videoPlayerStatus, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        return b2(videoPlayerStatus, jSONObject);
    }
}
