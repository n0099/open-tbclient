package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ag implements com.kwad.sdk.core.d<LiveInfo.CoverThumbnailUrl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag() {
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
    public void a(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coverThumbnailUrl, jSONObject) == null) || jSONObject == null) {
            return;
        }
        coverThumbnailUrl.cdn = jSONObject.optString("cdn");
        coverThumbnailUrl.url = jSONObject.optString("url");
        coverThumbnailUrl.urlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, coverThumbnailUrl, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "cdn", coverThumbnailUrl.cdn);
            com.kwad.sdk.utils.q.a(jSONObject, "url", coverThumbnailUrl.url);
            com.kwad.sdk.utils.q.a(jSONObject, "urlPattern", coverThumbnailUrl.urlPattern);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
