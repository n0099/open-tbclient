package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ga implements com.kwad.sdk.core.d {
    public static void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    public static JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = videoPlayerStatus.mVideoPlayerType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mVideoPlayerType", i);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((VideoPlayerStatus) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((VideoPlayerStatus) bVar, jSONObject);
    }
}
