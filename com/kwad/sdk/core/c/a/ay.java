package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.kwad.sdk.core.response.model.NewsInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ay implements com.kwad.sdk.core.d<NewsInfo.ImageInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ay() {
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
    public void a(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        imageInfo.width = jSONObject.optInt("width");
        imageInfo.height = jSONObject.optInt("height");
        imageInfo.url = jSONObject.optString("url");
        imageInfo.origin = jSONObject.optString(FilterValue.DEFAULT_FILTER_VALUE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, imageInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "width", imageInfo.width);
            com.kwad.sdk.utils.q.a(jSONObject, "height", imageInfo.height);
            com.kwad.sdk.utils.q.a(jSONObject, "url", imageInfo.url);
            com.kwad.sdk.utils.q.a(jSONObject, FilterValue.DEFAULT_FILTER_VALUE, imageInfo.origin);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
