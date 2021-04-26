package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class au implements com.kwad.sdk.core.c<PhotoInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        PhotoInfo.BaseInfo baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo = baseInfo;
        baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        PhotoInfo.VideoInfo videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo = videoInfo;
        videoInfo.parseJson(jSONObject.optJSONObject("videoInfo"));
        PhotoInfo.CoverInfo coverInfo = new PhotoInfo.CoverInfo();
        photoInfo.coverInfo = coverInfo;
        coverInfo.parseJson(jSONObject.optJSONObject("coverInfo"));
        PhotoInfo.AuthorInfo authorInfo = new PhotoInfo.AuthorInfo();
        photoInfo.authorInfo = authorInfo;
        authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        TrendInfo trendInfo = new TrendInfo();
        photoInfo.trendInfo = trendInfo;
        trendInfo.parseJson(jSONObject.optJSONObject("trendInfo"));
        PhotoInfo.PhotoAd photoAd = new PhotoInfo.PhotoAd();
        photoInfo.photoAd = photoAd;
        photoAd.parseJson(jSONObject.optJSONObject("photoAd"));
        LiveInfo liveInfo = new LiveInfo();
        photoInfo.liveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
        PhotoInfo.TubeEpisode tubeEpisode = new PhotoInfo.TubeEpisode();
        photoInfo.tubeEpisode = tubeEpisode;
        tubeEpisode.parseJson(jSONObject.optJSONObject("tubeEpisode"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "videoInfo", photoInfo.videoInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "coverInfo", photoInfo.coverInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "authorInfo", photoInfo.authorInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "trendInfo", photoInfo.trendInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "photoAd", photoInfo.photoAd);
        com.kwad.sdk.utils.o.a(jSONObject, "liveInfo", photoInfo.liveInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "tubeEpisode", photoInfo.tubeEpisode);
        return jSONObject;
    }
}
