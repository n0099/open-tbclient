package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x implements com.kwad.sdk.core.c<AdInfo.AdMaterialInfo.MaterialFeature> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x() {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialFeature)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "featureType", materialFeature.featureType);
            com.kwad.sdk.utils.o.a(jSONObject, "materialUrl", materialFeature.materialUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "photoId", materialFeature.photoId);
            com.kwad.sdk.utils.o.a(jSONObject, "coverUrl", materialFeature.coverUrl);
            com.kwad.sdk.utils.o.a(jSONObject, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, materialFeature.videoDuration);
            com.kwad.sdk.utils.o.a(jSONObject, "firstFrame", materialFeature.firstFrame);
            com.kwad.sdk.utils.o.a(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "videoWidth", materialFeature.videoWidth);
            com.kwad.sdk.utils.o.a(jSONObject, "videoHeight", materialFeature.videoHeight);
            com.kwad.sdk.utils.o.a(jSONObject, "likeCount", materialFeature.likeCount);
            com.kwad.sdk.utils.o.a(jSONObject, "commentCount", materialFeature.commentCount);
            com.kwad.sdk.utils.o.a(jSONObject, "source", materialFeature.source);
            com.kwad.sdk.utils.o.a(jSONObject, "ruleId", materialFeature.ruleId);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, materialFeature, jSONObject) == null) || jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
    }
}
