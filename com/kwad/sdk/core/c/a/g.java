package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.core.c<AdInfo.AdSplashInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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
    public JSONObject a(AdInfo.AdSplashInfo adSplashInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSplashInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "logoPosition", adSplashInfo.logoPosition);
            com.kwad.sdk.utils.o.a(jSONObject, "skipSecond", adSplashInfo.skipSecond);
            com.kwad.sdk.utils.o.a(jSONObject, "mute", adSplashInfo.mute);
            com.kwad.sdk.utils.o.a(jSONObject, "skipTips", adSplashInfo.skipTips);
            com.kwad.sdk.utils.o.a(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, adSplashInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
    }
}
