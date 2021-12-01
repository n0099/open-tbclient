package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.PhotoAd;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class cx implements com.kwad.sdk.core.d<PhotoAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cx() {
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
    public void a(PhotoAd photoAd, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoAd, jSONObject) == null) || jSONObject == null) {
            return;
        }
        photoAd.requestPatchAd = jSONObject.optBoolean("requestPatchAd", new Boolean("false").booleanValue());
        photoAd.requestPatchEc = jSONObject.optBoolean("requestPatchEc", new Boolean("false").booleanValue());
        photoAd.widgetAdPosition = jSONObject.optInt("widgetAdPosition");
        photoAd.requestWidgetAd = jSONObject.optBoolean("requestWidgetAd", new Boolean("false").booleanValue());
        photoAd.requestBannerAd = jSONObject.optBoolean("requestBannerAd", new Boolean("false").booleanValue());
        photoAd.requestAggregateAd = jSONObject.optBoolean("requestAggregateAd", new Boolean("false").booleanValue());
        photoAd.requestDynamicRewardAd = jSONObject.optBoolean("requestDynamicRewardAd", new Boolean("true").booleanValue());
        photoAd.requestInsertScreenAd = jSONObject.optBoolean("requestInsertScreenAd", new Boolean("false").booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoAd photoAd, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, photoAd, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "requestPatchAd", photoAd.requestPatchAd);
            com.kwad.sdk.utils.t.a(jSONObject, "requestPatchEc", photoAd.requestPatchEc);
            com.kwad.sdk.utils.t.a(jSONObject, "widgetAdPosition", photoAd.widgetAdPosition);
            com.kwad.sdk.utils.t.a(jSONObject, "requestWidgetAd", photoAd.requestWidgetAd);
            com.kwad.sdk.utils.t.a(jSONObject, "requestBannerAd", photoAd.requestBannerAd);
            com.kwad.sdk.utils.t.a(jSONObject, "requestAggregateAd", photoAd.requestAggregateAd);
            com.kwad.sdk.utils.t.a(jSONObject, "requestDynamicRewardAd", photoAd.requestDynamicRewardAd);
            com.kwad.sdk.utils.t.a(jSONObject, "requestInsertScreenAd", photoAd.requestInsertScreenAd);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
