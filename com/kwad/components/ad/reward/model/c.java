package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.r;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public int rewardType;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rewardType = 1;
    }

    public static c a(AdTemplate adTemplate, AdTemplate adTemplate2, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        InterceptResult invokeLLIL;
        File ad;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, adTemplate, adTemplate2, i, ksVideoPlayConfig)) == null) {
            c cVar = new c();
            AdInfo bQ = d.bQ(adTemplate);
            String A = com.kwad.sdk.core.response.a.a.A(bQ);
            if (com.kwad.sdk.core.config.d.sc() >= 0 || ((ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A)) != null && ad.exists())) {
                boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
                adTemplate.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                    JSONObject jSONObject = new JSONObject();
                    r.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
                    cVar.mReportExtData = jSONObject;
                }
                cVar.mVideoPlayConfig = ksVideoPlayConfig;
                cVar.mAdTemplate = adTemplate;
                cVar.mAdInfo = bQ;
                cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
                cVar.rewardType = i;
                adTemplate.mPlayAgain = adTemplate2;
                return cVar;
            }
            return null;
        }
        return (c) invokeLLIL.objValue;
    }

    public static c c(Intent intent) {
        InterceptResult invokeL;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.e.b.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
            String stringExtra = intent.getStringExtra("key_template_json");
            try {
                AdTemplate adTemplate2 = new AdTemplate();
                adTemplate2.parseJson(new JSONObject(stringExtra));
                String stringExtra2 = intent.getStringExtra(KSRewardVideoActivityProxy.KEY_TEMPLATE_PLAY_AGAIN);
                if (stringExtra2 != null) {
                    adTemplate = new AdTemplate();
                    adTemplate.parseJson(new JSONObject(stringExtra2));
                } else {
                    adTemplate = null;
                }
                return a(adTemplate2, adTemplate, intExtra, ksVideoPlayConfig);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public final AdInfo by() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdInfo : (AdInfo) invokeV.objValue;
    }

    public final boolean bz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.cd(this.mAdTemplate) : invokeV.booleanValue;
    }

    public final boolean gL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.e(getAdTemplate(), com.kwad.components.ad.reward.kwai.b.j(by())) : invokeV.booleanValue;
    }

    public final boolean gM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.p(getAdTemplate()) : invokeV.booleanValue;
    }

    public final KsVideoPlayConfig gN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoPlayConfig : (KsVideoPlayConfig) invokeV.objValue;
    }

    public final int gO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.rewardType : invokeV.intValue;
    }

    public final JSONObject gP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mReportExtData : (JSONObject) invokeV.objValue;
    }

    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    public final int getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mScreenOrientation : invokeV.intValue;
    }

    public final void y(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
            this.mAdInfo = d.bQ(adTemplate);
        }
    }
}
