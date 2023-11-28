package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class km implements com.kwad.sdk.core.d<c.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ve = jSONObject.optLong("start_play_duration_ms");
        bVar.Vf = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.UM = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.RT = jSONObject.optLong("ad_info_uid");
        bVar.Vd = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.Vd)) {
            bVar.Vd = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.Ve;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "start_play_duration_ms", j);
        }
        long j2 = bVar.Vf;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_total_duration_ms", j2);
        }
        long j3 = bVar.videoDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j3);
        }
        int i = bVar.UM;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_times", i);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        long j4 = bVar.llsid;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j4);
        }
        long j5 = bVar.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j5);
        }
        long j6 = bVar.RT;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j6);
        }
        String str2 = bVar.Vd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", bVar.Vd);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
