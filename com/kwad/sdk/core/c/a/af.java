package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class af implements com.kwad.sdk.core.d<PhotoInfo.CoverInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public af() {
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
    public void a(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coverInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        coverInfo.coverUrl = jSONObject.optString("coverUrl");
        coverInfo.width = jSONObject.optInt("width");
        coverInfo.height = jSONObject.optInt("height");
        coverInfo.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        coverInfo.blurCoverUrl = jSONObject.optString("blurCoverUrl");
        coverInfo.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, coverInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "coverUrl", coverInfo.coverUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "width", coverInfo.width);
            com.kwad.sdk.utils.q.a(jSONObject, "height", coverInfo.height);
            com.kwad.sdk.utils.q.a(jSONObject, "webpCoverUrl", coverInfo.webpCoverUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "blurCoverUrl", coverInfo.blurCoverUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "blurBackgroundUrl", coverInfo.blurBackgroundUrl);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
