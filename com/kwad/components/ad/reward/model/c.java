package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public AdTemplate b;
    public AdInfo c;
    public KsVideoPlayConfig d;
    public int e;
    public JSONObject f;

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
        this.e = 1;
    }

    @Nullable
    public static c a(Intent intent) {
        InterceptResult invokeL;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.b.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
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
                com.kwad.sdk.core.d.b.b(th);
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    @Nullable
    public static c a(AdTemplate adTemplate, @Nullable AdTemplate adTemplate2, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        InterceptResult invokeLLIL;
        File b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65538, null, adTemplate, adTemplate2, i, ksVideoPlayConfig)) == null) {
            c cVar = new c();
            AdInfo i2 = d.i(adTemplate);
            String b2 = com.kwad.sdk.core.response.a.a.b(i2);
            if (com.kwad.sdk.core.config.d.J() >= 0 || ((b = com.kwad.sdk.core.diskcache.a.a.a().b(b2)) != null && b.exists())) {
                boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
                adTemplate.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
                if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                    JSONObject jSONObject = new JSONObject();
                    r.a(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
                    cVar.f = jSONObject;
                }
                cVar.d = ksVideoPlayConfig;
                cVar.b = adTemplate;
                cVar.c = i2;
                cVar.a = isShowLandscape ? 1 : 0;
                cVar.e = i;
                adTemplate.mPlayAgain = adTemplate2;
                return cVar;
            }
            return null;
        }
        return (c) invokeLLIL.objValue;
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.b = adTemplate;
            this.c = d.i(adTemplate);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a(d(), com.kwad.components.ad.reward.kwai.b.d(e())) : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.q(d()) : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.w(this.b) : invokeV.booleanValue;
    }

    public final AdTemplate d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (AdTemplate) invokeV.objValue;
    }

    public final AdInfo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (AdInfo) invokeV.objValue;
    }

    public final KsVideoPlayConfig f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (KsVideoPlayConfig) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : invokeV.intValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }

    public final JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : (JSONObject) invokeV.objValue;
    }
}
