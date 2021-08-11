package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bo implements com.kwad.sdk.core.d<PhotoInfo.PhotoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bo() {
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
    public void a(PhotoInfo.PhotoAd photoAd, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoAd, jSONObject) == null) || jSONObject == null) {
            return;
        }
        photoAd.requestPatchAd = jSONObject.optBoolean("requestPatchAd", new Boolean("false").booleanValue());
        photoAd.requestAdWidgetWithPosition = jSONObject.optInt("requestAdWidgetWithPosition");
        photoAd.requestRewardContentAd = jSONObject.optBoolean("requestRewardContentAd", new Boolean("false").booleanValue());
        photoAd.requestBannerAd = jSONObject.optBoolean("requestBannerAd", new Boolean("false").booleanValue());
        photoAd.requestDynamicRewardAd = jSONObject.optBoolean("requestDynamicRewardAd", new Boolean("true").booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.PhotoAd photoAd, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, photoAd, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "requestPatchAd", photoAd.requestPatchAd);
            com.kwad.sdk.utils.q.a(jSONObject, "requestAdWidgetWithPosition", photoAd.requestAdWidgetWithPosition);
            com.kwad.sdk.utils.q.a(jSONObject, "requestRewardContentAd", photoAd.requestRewardContentAd);
            com.kwad.sdk.utils.q.a(jSONObject, "requestBannerAd", photoAd.requestBannerAd);
            com.kwad.sdk.utils.q.a(jSONObject, "requestDynamicRewardAd", photoAd.requestDynamicRewardAd);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
