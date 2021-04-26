package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bk implements com.kwad.sdk.core.c<PhotoInfo.TubeEpisode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tubeEpisode.tubeId = jSONObject.optLong(URLPackage.KEY_TUBE_ID, new Long("-1").longValue());
        tubeEpisode.tubeName = jSONObject.optString("tubeName");
        tubeEpisode.episodeName = jSONObject.optString("episodeName");
        tubeEpisode.playCount = jSONObject.optLong("playCount");
        tubeEpisode.hasTube = jSONObject.optBoolean("hasTube");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, URLPackage.KEY_TUBE_ID, tubeEpisode.tubeId);
        com.kwad.sdk.utils.o.a(jSONObject, "tubeName", tubeEpisode.tubeName);
        com.kwad.sdk.utils.o.a(jSONObject, "episodeName", tubeEpisode.episodeName);
        com.kwad.sdk.utils.o.a(jSONObject, "playCount", tubeEpisode.playCount);
        com.kwad.sdk.utils.o.a(jSONObject, "hasTube", tubeEpisode.hasTube);
        return jSONObject;
    }
}
