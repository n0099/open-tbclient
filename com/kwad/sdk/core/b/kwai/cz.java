package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cz implements com.kwad.sdk.core.d<PhotoInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        PhotoInfo.BaseInfo baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo = baseInfo;
        baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        PhotoInfo.VideoInfo videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo = videoInfo;
        videoInfo.parseJson(jSONObject.optJSONObject(TbPreviewVideoActivityConfig.KEY_VIDEO_INFO));
        PhotoInfo.CoverInfo coverInfo = new PhotoInfo.CoverInfo();
        photoInfo.coverInfo = coverInfo;
        coverInfo.parseJson(jSONObject.optJSONObject("coverInfo"));
        PhotoInfo.AuthorInfo authorInfo = new PhotoInfo.AuthorInfo();
        photoInfo.authorInfo = authorInfo;
        authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        LiveInfo liveInfo = new LiveInfo();
        photoInfo.liveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
        PhotoInfo.TubeEpisode tubeEpisode = new PhotoInfo.TubeEpisode();
        photoInfo.tubeEpisode = tubeEpisode;
        tubeEpisode.parseJson(jSONObject.optJSONObject("tubeEpisode"));
        PhotoInfo.WallpaperInfo wallpaperInfo = new PhotoInfo.WallpaperInfo();
        photoInfo.wallpaperInfo = wallpaperInfo;
        wallpaperInfo.parseJson(jSONObject.optJSONObject("wallpaperInfo"));
        PhotoInfo.ProductInfo productInfo = new PhotoInfo.ProductInfo();
        photoInfo.productInfo = productInfo;
        productInfo.parseJson(jSONObject.optJSONObject("productInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.t.a(jSONObject, TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, photoInfo.videoInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "coverInfo", photoInfo.coverInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "authorInfo", photoInfo.authorInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "liveInfo", photoInfo.liveInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "tubeEpisode", photoInfo.tubeEpisode);
        com.kwad.sdk.utils.t.a(jSONObject, "wallpaperInfo", photoInfo.wallpaperInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "productInfo", photoInfo.productInfo);
        return jSONObject;
    }
}
