package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ej implements com.kwad.sdk.core.d<PhotoInfo.TubeEpisode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tubeEpisode.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, new Long("-1").longValue());
        tubeEpisode.tubeName = jSONObject.optString("tubeName");
        if (jSONObject.opt("tubeName") == JSONObject.NULL) {
            tubeEpisode.tubeName = "";
        }
        tubeEpisode.episodeName = jSONObject.optString("episodeName");
        if (jSONObject.opt("episodeName") == JSONObject.NULL) {
            tubeEpisode.episodeName = "";
        }
        tubeEpisode.playCount = jSONObject.optLong("playCount");
        tubeEpisode.hasTube = jSONObject.optBoolean("hasTube");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_TUBE_ID, tubeEpisode.tubeId);
        com.kwad.sdk.utils.t.a(jSONObject, "tubeName", tubeEpisode.tubeName);
        com.kwad.sdk.utils.t.a(jSONObject, "episodeName", tubeEpisode.episodeName);
        com.kwad.sdk.utils.t.a(jSONObject, "playCount", tubeEpisode.playCount);
        com.kwad.sdk.utils.t.a(jSONObject, "hasTube", tubeEpisode.hasTube);
        return jSONObject;
    }
}
