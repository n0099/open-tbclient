package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bq implements com.kwad.sdk.core.d<PhotoInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoInfo, jSONObject) == null) || jSONObject == null) {
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
        PhotoInfo.PhotoAd photoAd = new PhotoInfo.PhotoAd();
        photoInfo.photoAd = photoAd;
        photoAd.parseJson(jSONObject.optJSONObject("photoAd"));
        LiveInfo liveInfo = new LiveInfo();
        photoInfo.liveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
        PhotoInfo.TubeEpisode tubeEpisode = new PhotoInfo.TubeEpisode();
        photoInfo.tubeEpisode = tubeEpisode;
        tubeEpisode.parseJson(jSONObject.optJSONObject("tubeEpisode"));
        PhotoInfo.WallpaperInfo wallpaperInfo = new PhotoInfo.WallpaperInfo();
        photoInfo.wallpaperInfo = wallpaperInfo;
        wallpaperInfo.parseJson(jSONObject.optJSONObject("wallpaperInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, photoInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "baseInfo", photoInfo.baseInfo);
            com.kwad.sdk.utils.q.a(jSONObject, TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, photoInfo.videoInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "coverInfo", photoInfo.coverInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "authorInfo", photoInfo.authorInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "photoAd", photoInfo.photoAd);
            com.kwad.sdk.utils.q.a(jSONObject, "liveInfo", photoInfo.liveInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "tubeEpisode", photoInfo.tubeEpisode);
            com.kwad.sdk.utils.q.a(jSONObject, "wallpaperInfo", photoInfo.wallpaperInfo);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
