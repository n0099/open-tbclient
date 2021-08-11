package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
    public void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSplashInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adSplashInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "logoPosition", adSplashInfo.logoPosition);
            com.kwad.sdk.utils.q.a(jSONObject, "skipSecond", adSplashInfo.skipSecond);
            com.kwad.sdk.utils.q.a(jSONObject, "mute", adSplashInfo.mute);
            com.kwad.sdk.utils.q.a(jSONObject, "skipTips", adSplashInfo.skipTips);
            com.kwad.sdk.utils.q.a(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
            com.kwad.sdk.utils.q.a(jSONObject, "countdownShow", adSplashInfo.countdownShow);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
