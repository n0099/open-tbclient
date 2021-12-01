package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class eo implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eo() {
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
    public void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        if (jSONObject.opt("videoUrl") == JSONObject.NULL) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (jSONObject.opt("manifest") == JSONObject.NULL) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString(SpeedStatsMainTable.FIRST_FRAME_STAGE);
        if (jSONObject.opt(SpeedStatsMainTable.FIRST_FRAME_STAGE) == JSONObject.NULL) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, videoInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "videoUrl", videoInfo.videoUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "manifest", videoInfo.manifest);
            com.kwad.sdk.utils.t.a(jSONObject, SpeedStatsMainTable.FIRST_FRAME_STAGE, videoInfo.firstFrame);
            com.kwad.sdk.utils.t.a(jSONObject, "duration", videoInfo.duration);
            com.kwad.sdk.utils.t.a(jSONObject, "size", videoInfo.size);
            com.kwad.sdk.utils.t.a(jSONObject, "width", videoInfo.width);
            com.kwad.sdk.utils.t.a(jSONObject, "height", videoInfo.height);
            com.kwad.sdk.utils.t.a(jSONObject, "leftRatio", videoInfo.leftRatio);
            com.kwad.sdk.utils.t.a(jSONObject, "topRatio", videoInfo.topRatio);
            com.kwad.sdk.utils.t.a(jSONObject, "widthRatio", videoInfo.widthRatio);
            com.kwad.sdk.utils.t.a(jSONObject, "heightRatio", videoInfo.heightRatio);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
